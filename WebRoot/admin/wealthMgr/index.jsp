<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<jsp:useBean id="property" class="com.saas.biz.propertyuMgr.PropertyuInfo" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;}
		 .t1{background-color:#ffffff; color:#000000;font-size:12px;}
		 .t2{background-color:#f6f6f6; color:#000000;font-size:12px;}
		</style>
		<%
		  String cust_class="",user_id="";
		  HttpSession  sesion = request.getSession(); 
		  if(sesion.getAttribute("SESSION_CUST_CLASS")!=null){
		     cust_class=sesion.getAttribute("SESSION_CUST_CLASS").toString();
		     cust_class=comparam.getParamNameByValue("14",cust_class);
		  }
		  if(sesion.getAttribute("SESSION_USER_ID")!=null){
		     user_id=sesion.getAttribute("SESSION_USER_ID").toString();
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
						<jsp:include page="/inc/jspTop.jsp">
							<jsp:param name="menu_id" value="<%=top_menu_id%>" />
						</jsp:include>								
										<table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#e7e7e7">
											<tr>
												<td height="22" colspan="2" align="center" bgcolor="#fefaf4">
													当前帐户情况
												</td>
												<td colspan="2" align="center" bgcolor="#ffffff">
													金币小计
													<span class="gray3">（截止<%=date%>）</span>
												</td>
											</tr>
											<tr>
												<td width="14%" align="center" bgcolor="#fefaf4">
													黄金
												</td>
												<td width="26%" align="center" bgcolor="#fefaf4">
													会员级别
												</td>
												<td width="20%" align="center" bgcolor="#ffffff">
													黄金奖励
												</td>
												<td width="16%" align="center" bgcolor="#ffffff">
													已消费
												</td>
											</tr>
											<tr>
												<td align="center" bgcolor="#fefaf4">
													<span class="red14"><%=menoy%>两</span>
												</td>
												<td align="center" bgcolor="#fefaf4">
													<p style="font-family: serif;font-weight: bold;">
													 <%=cust_class%>
													</p>
												</td>
												<td align="center" bgcolor="#ffffff">
													<%=menoy%>两
												</td>
												<td align="center" bgcolor="#ffffff">
													0
												</td>
											</tr>
											<tr>
											 <td colspan="4">
											    <table width=800 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
													<tr>
														<td class="l_td" align="center" width="15%">
															会员级别
														</td>
														<td class="l_td" align="center" width="30%">
															会员动作
														</td>
														<td class="l_td" align="center" width="15%">
															奖励黄金数量
														</td>
													</tr>
													<%
													  if(list !=null && list.size()>0){
													    for(int i=0;i<list.size();i++){
													       HashMap map=(HashMap)list.get(i);
													       String para_code1="";
													       if(map.get("para_code1")!=null){para_code1=map.get("para_code1").toString();}
													       String para_code2="";
													       if(map.get("para_code2")!=null){para_code2=map.get("para_code2").toString();}
													       String para_code3="";
													       if(map.get("para_code3")!=null){para_code3=map.get("para_code3").toString();}
													       String para_code4="";
													       if(map.get("para_code4")!=null){para_code4=map.get("para_code4").toString();}
													       String para_code5="";
													       if(map.get("para_code5")!=null){para_code5=map.get("para_code5").toString();}
													       if(i%2==0){
													        out.print("<tr class=t1>");
													       }else{
													        out.print("<tr class=t2>");
													       }
													 %>
														<td align="left" width="15%">
															<%=para_code5%>
														</td>
														<td align="left" width="30%">
															<%=para_code2%>
														</td>
														<td align="center" width="15%">
															<%=para_code3%>两黄金
														</td>
												 
													 <%      
													    }
													  }
													%>
												</table>
											 </td>
											</tr>
										</table>
	</body>
</html>



