<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<jsp:useBean id="property" class="com.saas.biz.propertyuMgr.PropertyuInfo" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;}
		 .t1{background-color:#ffffff; color:#000000;font-size:12px;}
		 .t2{background-color:#f6f6f6; color:#000000;font-size:12px;}
		</style>
		<%
		  String cust_class="",user_id="",cust_name="",cust_id="";
		  Custinfo custinfo=new Custinfo();
		  HttpSession  sesion = request.getSession(); 
		  if(sesion.getAttribute("SESSION_CUST_CLASS")!=null){
		     cust_class=sesion.getAttribute("SESSION_CUST_CLASS").toString();
		     cust_class=comparam.getParamNameByValue("14",cust_class);
		  }
		  if(sesion.getAttribute("SESSION_USER_ID")!=null){
		     user_id=sesion.getAttribute("SESSION_USER_ID").toString();
		     cust_id=sesion.getAttribute("SESSION_CUST_ID").toString();
		     cust_name=custinfo.getCustomerTrueNameById(cust_id);
		  }
		  String date="";
		  SimpleDateFormat formate= new SimpleDateFormat("yyyy-MM-dd");
		  date=formate.format(new Date());
		  ArrayList list = comparam.getCompareInfoByAttr("101");
		  String menoy=property.getUserPropertyValue(user_id,"0");
		%>
	</head>
	<body>
					<%
					String top_menu_id="";
					if (request.getParameter("menu_id") != null){
			        top_menu_id = request.getParameter("menu_id");
			    }
				%>
														
										<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
											
											<tr class="u4">
												尊敬的 &nbsp;<%=cust_name%> &nbsp; 客户 
											</tr>
											<tr>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您的客户级别为：<b><%=cust_class%></b>&nbsp;&nbsp;您目前的积分值为：&nbsp;<b><%=menoy%></b>分
											</tr>
																						
											<tr>
											 <td colspan="4">
											    <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
													<tr class="u4" height="25">
													会员积分规则说明：
													</tr>
													<%
													  if(list !=null && list.size()>0){
													    for(int i=0;i<list.size();i++){
													       HashMap map=(HashMap)list.get(i);
													       String para_code5="";
													        String para_code3="";
													        String para_code2="";
													       if(map.get("para_code5")!=null&&map.get("para_code5").toString().equals(cust_class))
													       {
													          para_code5=map.get("para_code5").toString();
													          if(para_code5.equals(cust_class))
													          {
													            if(map.get("para_code2")!=null)
													            {
													              para_code2=map.get("para_code2").toString();
													              para_code2=para_code2;
													            }
													            if(map.get("para_code3")!=null)
													            {
													             para_code3=map.get("para_code3").toString();
													             para_code3="赠送"+para_code3+"分"+"(每条)";
													            }
													          }
													       }
													 %>
													 <tr>
													 	<!--
														<td align="left" width="20%" bgcolor="white">
															<%//para_code5%>
														</td>
														-->
														<td align="left" width="20%" bgcolor="white">
															<%=para_code2%>
														</td>
														<td align="left" width="80%" bgcolor="white">
															<%=para_code3%>
														</td>
													</tr>
													 <%      
													    }
													   }else{
														%>
											<tr align=center ><td colspan="4">暂无记录!</td></tr>
														<%
															}
														%>
												</table>
											 </td>
											</tr>
										</table>
	</body>
</html>




