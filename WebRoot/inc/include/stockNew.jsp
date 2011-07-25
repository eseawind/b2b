<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">&nbsp; 
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.*"%>
<%@ page import="com.saas.biz.newsMgr.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.*"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<%@ page import="com.saas.biz.infoListMgr.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="java.util.*"%>
<%
	String key="",pro="",city="",part="",precision="";
	if(request.getParameter("param1")!=null){
	key=new String (request.getParameter("param1").getBytes("ISO-8859-1"),"GBK");
	}
	if(request.getParameter("param2")!=null){
		pro = request.getParameter("param2");
	}
	if(request.getParameter("param3")!=null){
		city = request.getParameter("param3");
	}
	if(request.getParameter("param4")!=null){
		part = request.getParameter("param4");
	}

	String iStart = "1";
	if(request.getParameter("iStart")!=null){
		iStart = request.getParameter("iStart");
	}
	//out.print("key="+key+"pro="+pro+"city="+city+"part="+part+"precision="+precision);
	AreaInfo area = new AreaInfo();
	String pro_name = "";
	if(pro != null)
		pro_name = area.getAreaName(pro);
	else
		pro_name = "";
	String city_name = "";
	if(city != null)
		city_name = area.getAreaName(city);
	else
		city_name = "";
	
	Stockorderinfo info = new Stockorderinfo();
	ArrayList list = new ArrayList();
	int counter = 0;
	String pageTools = "";
		list = info.getSearchStockInfo(Integer.valueOf(iStart).intValue(),30,key,pro_name,city_name,Integer.parseInt(part));
		counter = info.getSearchStockInfo(key,pro,city,Integer.parseInt(part));
		pageTools = tools.getGoogleToolsBar(counter,"stockNew.jsp?param1=" + key + "&param2=" + pro + "&param3=" + city + "&param4=" + part + "&iStart=", Integer.parseInt(iStart) , 30);


%>
<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
<div id="main">	
		<table width="98%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr>
          <td width="16%" class="list_right_cp_lmt">产品图片</td>
          <td width="46%" class="list_right_cp_lmt">公司/主营产品、服务</td>
          <td width="12%" class="list_right_cp_lmt">供应地区</td>
          <td class="list_right_cp_lmt">发布日期</td>
          <td width="14%" class="list_right_cp_lmt">联系方式1<%=key%></td>
        </tr>
        <%	
        	if(list != null && list.size() > 0){ 
        		for(int i = 0;i < list.size();i++){
        		String cust_id ="",stock_id ="",title ="",stock_addr ="",publish_date ="";
        		HashMap map = (HashMap)list.get(i);
        		if(map.get("cust_id")!=null){cust_id = map.get("cust_id").toString();}
        		if(map.get("stock_id")!=null){stock_id = map.get("stock_id").toString();}
        		if(map.get("title")!=null){title = map.get("title").toString();}
        		if(map.get("stock_addr")!=null){stock_addr = map.get("stock_addr").toString();}
        		if(map.get("publish_date")!=null){
        			publish_date = map.get("publish_date").toString();
        			if(publish_date.length()>10)
        				publish_date = publish_date.substring(0,10);
        		}
        		String filePath = "";
        		filePath = new NewsInfo().getCustAttachPath( stock_id, "0");
        		String phone = "";
        		phone = new Custinfo().getPhoneById(cust_id);
        		InfoList infoList = new InfoList();
        		ChannelInfo chanInfo = new ChannelInfo();
        		String chId = "",save_dir = "";
        		chId = infoList.getChannelCh_idByInfo(stock_id);
        		if(!chId.equals("")) {
        			save_dir = chanInfo.getSaveDir(chId);
        		}
        		String link_url = "/"+ save_dir + "/d/content-"+stock_id+".html";
        %>
        <tr>
          <td class="list_right_cp_xian"><a href="<%=link_url%>"><img src="<%=filePath%>" border=0 width=100 height=75></a></td>
          <td class="list_right_cp_xian">
				  <span class="span"><a href="<%=link_url%>"><%=title%></a></span><br>
				  <font></font><br>
				  <div class="button" style="float:left; margin-right:5px;"><a href="<%=link_url%>">产品信息</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank">联系方式</a></div>
				  </td>
          <td class="list_right_cp_xian"><%=stock_addr%></td>
          <td class="list_right_cp_xian"><%=publish_date%></td>
          <td class="list_right_cp_xian"><%=phone%></td>
        </tr>
        <%
        		}
        	} 
        %>
		</table>
  <div class="cplist_page"><%=pageTools%></div>
</div>




