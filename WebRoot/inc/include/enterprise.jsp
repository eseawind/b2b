<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">&nbsp; 
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.*"%>
<%@ page import="com.saas.biz.newsMgr.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.*"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="java.util.*"%>
<%
	String key="",pro="",city="",part="",precision="";
	if(request.getParameter("param1")!=null){
		key = request.getParameter("param1");
	}
	if(request.getParameter("param2")!=null){
		pro = request.getParameter("param2");
	}
	if(request.getParameter("param3")!=null){
		city = request.getParameter("param3");
	}
	String iStart = "0";
	if(request.getParameter("iStart")!=null){
		iStart = request.getParameter("iStart");
	}
	AreaInfo area = new AreaInfo();
	String pro_name = "";
	if(pro != null && !pro.equals("请选择")){
		pro_name = area.getAreaName(pro);
	}else{
		pro_name = "";
	}
	
	String city_name = "";
	if(city != null)
		city_name = area.getAreaName(city);
	else
		city_name = "";
	Custinfo info = new Custinfo();
	ArrayList list = new ArrayList();
	int counter = 0;
	String pageTools = "";
	list = info.getCustInfoByTypeCityPro(Integer.valueOf(iStart).intValue(),key,city,pro);
 
	counter = info.getCustInfoByTypeCityPro(key,city,pro);
 
	pageTools = tools.getGoogleToolsBar(counter,"enterprise.jsp?param1=" + key + "&param2=" + pro + "&param3=" + city + "&iStart=", Integer.parseInt(iStart) , 20);
	
%>
<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
<div id="main">	
		<table width="98%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr>
          <td width="16%" class="list_right_cp_lmt">公司图片</td>
          <td width="46%" class="list_right_cp_lmt">公司/主营产品、服务</td>
          <td width="12%" class="list_right_cp_lmt">主营产品</td>
          <td class="list_right_cp_lmt">注册日期</td>
          <td width="14%" class="list_right_cp_lmt">联系方式</td>
        </tr>
        <%	
        
        
        	if(list != null && list.size() > 0){ 
        		String cust_id ="",cust_name ="",title ="",stock_addr ="",publish_date ="",scope="",group_contact_phone="";
        		for(int i = 0;i < list.size();i++){        		
        			HashMap map = (HashMap)list.get(i);
        			if(map.get("cust_id")!=null){
        				cust_id = map.get("cust_id").toString();
        			}
        			if(map.get("cust_name")!=null){
        				cust_name = map.get("cust_name").toString();
        			}        			
        			if(map.get("publish_date")!=null){
        				publish_date = map.get("publish_date").toString();
        				if(publish_date.length()>10)
        					publish_date = publish_date.substring(0,10);
	        		}
	        		if(map.get("scope")!=null){
        				scope = map.get("scope").toString();
        				if(scope.length()>10)
        					scope = scope.substring(0,10);
	        		}
	        		if(map.get("group_contact_phone")!=null){
        				group_contact_phone = map.get("group_contact_phone").toString();
        			}
	        		String filePath = "";
	        		filePath = new NewsInfo().getCustAttachPath( cust_id, "0");
	        		
	        		String phone = "";
	        		phone = new Custinfo().getPhoneById(cust_id);
        %>
        <tr>
          <td class="list_right_cp_xian"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank"><img src="<%=filePath%>" border=0 width=100 height=75></a></td>
          <td class="list_right_cp_xian">
				  <span class="span"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank"><%=cust_name%></a></span><br>
				  <font></font><br>
				  <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>">联系方式</a></div>
				  </td>
          <td class="list_right_cp_xian"><%=scope%></td>
          <td class="list_right_cp_xian"><%=publish_date%></td>
          <td class="list_right_cp_xian"><%=group_contact_phone%></td>
        </tr>
        <%
        		}
        	} 
        %>
		</table>
  <div class="cplist_page"><%=pageTools%></div>
</div>




