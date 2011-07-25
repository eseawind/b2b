<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="custBean" class="com.saas.biz.custMgr.Custinfo" scope="page"/>
<%@ page import="java.util.*"%>
<%
  String name="";
  if(request.getParameter("cust_name")!=null){
   name=request.getParameter("cust_name");
  }
  ArrayList list=custBean.searchCust(name);
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
				<td background="/admin/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;"align="center" align="center" width="25%">
					会员名称
				</td>
				<td background="/admin/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">
					联系电话
				</td>
				<td background="/admin/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="20%">
					公司网址
				</td>
				<td background="/admin/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="30%">
					地址
				</td>
			</tr>
			<%
			    if (list != null && list.size() > 0) {
					for (int i=0;i<list.size();i++) {
						HashMap map = (HashMap) list.get(i);
						String cust_id = "";
						String cust_name = "";
						String phone = "";
						String website = "";
						String cust_addr = "";
						cust_id = map.get("cust_id").toString();
						cust_name = map.get("cust_name").toString();
						if (map.get("group_contact_phone") != null) {
					      phone = map.get("group_contact_phone").toString();
						}
						if (map.get("company_address") != null) {
					      cust_addr = map.get("company_address").toString();
						}
						if (map.get("website") != null) {
					      website = map.get("website").toString();
						}
					%>
					<tr style="background-color:#f9f9f9; ">
						<td style=" color:#000000;" align="left"><input type="radio" name="name_rad" id="cust_<%=i%>" style="margin-left: 5px;margin-right: 2px" onclick="setCustId('<%=cust_id%>')"><%=cust_name%></td>
						<td style=" color:#000000;" align="left"><%=phone%></td>
						<td style=" color:#000000;" align="left"><%=website%></td>
						<td style=" color:#000000;" align="left"><%=cust_addr%></td>
					</tr>
					<%}
				}else{
      %>
      	<tr>
      		<td align="center" colspan="6" bgcolor="white">
      			无客户记录！
      		</td>
      	</tr>
      <%		
      }
      %>
		</table>
	</body>
</html>




