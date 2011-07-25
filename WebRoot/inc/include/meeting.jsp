<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">&nbsp; 
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.showMgr.*"%>
<%@ page import="com.saas.biz.newsMgr.*"%>
<%@ page import="com.saas.biz.infoListMgr.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="java.util.*"%>
<%
	String key="",date="";
	if(request.getParameter("param1")!=null){

		key = new String ( request.getParameter("param1").getBytes("ISO_8859_1"),"GBK");
	}
	if(request.getParameter("param2")!=null){
		date = request.getParameter("param2");
	}

	String iStart = "1";
	if(request.getParameter("iStart")!=null){
		iStart = request.getParameter("iStart");
	}
	

	ShowInfo info = new ShowInfo();
	ArrayList list = new ArrayList();
	int counter = 0;
	String pageTools = "";

	list = info.getSearchShowInfo(Integer.valueOf(iStart).intValue(),30,key,date);
	counter = info.getSearchShowInfo(key,date);
	pageTools = tools.getGoogleToolsBar(counter,"supply.jsp?param1=" + key + "&param2=" + date + "&iStart=", Integer.parseInt(iStart) , 30);
	
%>
<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
<div id="main">	
		<table width="98%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr>
          <td width="16%" class="list_right_cp_lmt">展会图片</td>
          <td width="46%" class="list_right_cp_lmt">展会名称</td>
          <td width="12%" class="list_right_cp_lmt">展会地址</td>
          <td class="list_right_cp_lmt">开展日期</td>
          <td width="14%" class="list_right_cp_lmt">联系方式</td>
        </tr>
        <%	
        	if(list != null && list.size() > 0){ 
        		for(int i = 0;i < list.size();i++){
        		String cust_id ="",show_id ="",title ="",show_addr ="",start_date ="",contact_phone="";
        		HashMap map = (HashMap)list.get(i);
        		if(map.get("cust_id")!=null){cust_id = map.get("cust_id").toString();}
        		if(map.get("show_id")!=null){show_id = map.get("show_id").toString();}
        		if(map.get("title")!=null){title = map.get("title").toString();}
        		if(map.get("show_addr")!=null){show_addr = map.get("show_addr").toString();}
        		if(map.get("contact_phone")!=null){contact_phone = map.get("contact_phone").toString();}
        		if(map.get("start_date")!=null){
        			start_date = map.get("start_date").toString();
        			if(start_date.length()>10)
        				start_date = start_date.substring(0,10);
        		}
        		String filePath = "";
        		filePath = new NewsInfo().getCustAttachPath( show_id, "0");
        		
        		InfoList infoList = new InfoList();
        		ChannelInfo chanInfo = new ChannelInfo();
        		String chId = "",save_dir = "";
        		chId = infoList.getChannelCh_idByInfo(show_id);
        		if(!chId.equals("")) {
        			save_dir = chanInfo.getSaveDir(chId);
        		}
        		String link_url = "/"+ save_dir + "/d/content-"+show_id+".html";
        %>
        <tr>
          <td class="list_right_cp_xian"><a href="<%=link_url%>"><img src="<%=filePath%>" border=0 width=100 height=75></a></td>
          <td class="list_right_cp_xian">
				  <span class="span"><a href="<%=link_url%>"><%=title%></a></span><br>
				  <font></font><br>
				  <div class="button" style="float:left; margin-right:5px;"><a href="<%=link_url%>">详细信息</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank">联系方式</a></div>
				  </td>
          <td class="list_right_cp_xian"><%=show_addr%></td>
          <td class="list_right_cp_xian"><%=start_date%></td>
          <td class="list_right_cp_xian"><%=contact_phone%></td>
        </tr>
        <%
        		}
        	} 
        %>
		</table>
  <div class="cplist_page"><%=pageTools%></div>
</div>




