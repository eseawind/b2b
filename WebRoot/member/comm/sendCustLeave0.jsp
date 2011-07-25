<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="enqBean" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page" />
<%
	String cust_id = "", iStart = "1",link_Page="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("cust_id") != null) {
		cust_id = request.getParameter("cust_id");
	}
	link_Page="/zone_b2b/enterprise/customer/"+cust_id+"/leavel.htm";
	HttpSession logsession = request.getSession();
	String user_name = "游客",user_idx="";
	if (logsession.getAttribute("SESSION_USER_NAME") != null) {
		user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_idx = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	ArrayList list = enqBean.getCustomerEnqList(Integer.parseInt(iStart), 3, cust_id,"5");
	int counter = enqBean.getCustomerEnqCount(cust_id,"5");
	String pageTools = tools.getPageTools(String.valueOf(counter), "3", link_Page+"?cust_id=" + cust_id + "&iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>留言</title>
<style type="text/css">
<!--
P,td,tr,table,text{word-break:break-all;}
-->
</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form action="/doTradeReg.do" name="loginForm" method="post" target="_self">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="E1E1E1">
				<%
				 if(list !=null && list.size()>0){
				   for(int i=0;i<list.size();i++){
				     HashMap map=(HashMap)list.get(i);
				     String rsrv_str3="",rsrv_str5="",content="";
				     if(map.get("rsrv_str3")!=null){rsrv_str3=map.get("rsrv_str3").toString();}
				     if(map.get("rsrv_str5")!=null){rsrv_str5=map.get("rsrv_str5").toString();}
				     if(map.get("enquiry_content")!=null){content=map.get("enquiry_content").toString();}
				     %>
				      <tr>
				        <td align="right" bgcolor="F2F2F2" width="15%">
						<strong><%=rsrv_str3%>：</strong>
						</td>
						<td bgcolor="#FFFFFF" width="85%">
							<%=rsrv_str5%>
						</td>
				      </tr>
				      <tr>
				        <td align="right" bgcolor="#FFFFFF">
						<strong>留言内容：</strong>
						</td>
						<td bgcolor="#FFFFFF">
							<span class="xian" style="text-align: left;word-break:break-all;">&nbsp;&nbsp;&nbsp;<%=content%></span>
						</td>
				      </tr>
				     <%
				   }
				   %>
				    <tr>
				        <td align="center" bgcolor="#FFFFFF" colspan="2">
						   <table width=100% border=0 cellpadding=0 cellspacing=0 align=center class="r_td">
						     <%=pageTools%>
						    </table>
						</td>
				      </tr>
				   <%
				 }
				%>
			</table>
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="E1E1E1">
				<tr>
					<td align="right" bgcolor="F2F2F2">
						<strong>用户名称：</strong>
					</td>
					<td bgcolor="#FFFFFF">
						<input type="text" name="rsrv_str3" id="rsrv_str3" maxlength="100" size="20" value="<%=user_name%>">
						<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="F2F2F2">
						<strong>Email：</strong>
					</td>
					<td bgcolor="#FFFFFF">
						<input type="text" name="rsrv_str5" id="rsrv_str5" size="25" maxlength="50">
						<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="F2F2F2">
						<strong>留言内容：</strong>
					</td>
					<td bgcolor="#FFFFFF">
						<textarea name="content" id="content" cols="45" rows="6"></textarea>
						<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="F2F2F2" colspan="2">
						<input type="hidden" name="rsrv_str4" id="rsrv_str4">
						<input type="hidden" name="session_user_id" name="session_user_id" value="<%=user_idx%>">
						<input type="hidden" name="session_cust_id" name="session_cust_id" value="<%=cust_id%>">
						<input type="hidden" name="cust_id" name="cust_id" value="<%=cust_id%>">
						<input type="hidden" name="user_id" name="user_id" value="<%=cust_id%>">
						<input type="hidden" name="sale_id" name="sale_id" value="<%=cust_id%>">
						<input type="hidden" name="deal_tag" name="deal_tag" value="5">
						<input type="hidden" name="trade_type_code" name="trade_type_code" value="1308">
						<input type="submit" name="comm" id="comm" value="确认发送留言" onClick=" return checkValue()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




