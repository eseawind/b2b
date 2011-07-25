<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
				
%>
<html>
<head>
<title>会员信息统计</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
    <script language="javascript" src="/js/Calendar_Ly.js"></script>
    <style type="text/css">
			.chaxun{
					background:url(/admin/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
		</style>
</head>
		<%
			String cust_id = "";
			if(request.getParameter("cust_id") != null) {
				cust_id = request.getParameter("cust_id");
			}
			String cust_name="",cust_aim="",publish_date="";
			Custinfo custInfo = new Custinfo();
			ArrayList custList = new ArrayList();
			custList = custInfo.getCustListById(cust_id);
			if(custList!=null && custList.size()>0) {
				HashMap custMap = (HashMap)custList.get(0);
				if(custMap.get("cust_name") != null) {
					cust_name = custMap.get("cust_name").toString();
				}
				if(custMap.get("cust_aim") != null) {
					cust_aim = custMap.get("cust_aim").toString();
				}
				if(custMap.get("cust_name") != null) {
					publish_date = custMap.get("publish_date").toString();
				}
			}
		%>	
		<%
			String count1="",count2="",count3="",count4="";
			int count5=0;
			InfoList infoList = new InfoList();
			count1 = infoList.getInfoListCountByCustId(cust_id,"1");
			count2 = infoList.getInfoListCountByCustId(cust_id,"2");
			count3 = infoList.getInfoListCountByCustId(cust_id,"7");
			count4 = infoList.getInfoListCountByCustId(cust_id,"3");
			count5 = Integer.parseInt(count1)+Integer.parseInt(count2)+Integer.parseInt(count3)+Integer.parseInt(count4);
		%>
<body>	
	<form action="countInfoList.jsp" method="post" name="orderform">		
		<table height="20">
			<tr>
				<td>
				</td>
			</tr>
		</table>
				<table width="80%" border=0 cellpadding=2 cellspacing=1 bgcolor="#DEEDFD" align="center">
					<tr bgcolor="white">
						<td>
							公司名称：<%=cust_aim%>&nbsp;&nbsp;&nbsp;&nbsp;
							真实姓名：<%=cust_name%>&nbsp;&nbsp;&nbsp;&nbsp;
							注册时间：<%=publish_date%>
						</td>
					</tr>
					
				</table>
		</form>
		
    <table bgcolor="#ECF5FD" width=80% border=0 cellpadding=1 cellspacing=1 align="center"  >
		    	<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
					<tr>									 
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td>
										<table width="100%" height="80">
											<tr>
												<th>
													供应信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<%=count1%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													求购信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<%=count2%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													二手信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<%=count3%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>									   		
				 <tr><td height=15></td>
				</tr>
				 
				 
				 
				<tr>
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													产品信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<%=count4%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													信息总数统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<%=count5%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" >													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="left">
										&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>									   		
				 <tr align="center" >
				 	<td>
				 	</td>
				 	<td height=15 colspan="3">
				 		<br><img src="/admin/images/comeback.JPG" onClick="javascript:history.go(-1)" style="cursor:hand;">
				 	</td>
				</tr> 
				 
				 
		    </table>		  
		    <table>
		    		<tr>
		    				<td height="30">
		    				</td>
		    		</tr>
		    </table>
</body>
</html>


