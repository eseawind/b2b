<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr"
	scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
  HttpSession  logsession = request.getSession(); 
	String cust_id="",cust_name="",user_id="",word_type="";
	String root_id="BO8SJKa0Iqg8iix";
	String iStart = "1";
  if (logsession.getAttribute("SESSION_CUST_ID") != null) { 
  	cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
  }
	if(request.getParameter("iStart")!=null){
		iStart = request.getParameter("iStart");
	}
  LeavewordsInfo leavewords = new LeavewordsInfo();
  ArrayList leaveList = leavewords.getLeavelListByIn( Integer.valueOf(iStart).intValue(),10,cust_id);
  int counter = leavewords.getLeavelListByIn(cust_id);
  String pageTools=tools.getPageTools(String.valueOf(counter),"10","userFeedInfo.jsp?&cust_id="+cust_id+"&iStart=",Integer.parseInt(iStart));

%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<%
			String top_menu_id = "";
			if (request.getParameter("menu_id") != null) {
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center
			bgcolor="#DEEDFD">
			<tr class="u4" height="25">			
				<td align=left width="50%">
					标题
				</td>
				<td align=left width="20%">
					发送日期
				</td>		
				<td align=left width="15%">
					状态
				</td>
			</tr>
			<%
					if (leaveList != null && leaveList.size() > 0) {
					int i = 0;
					for (Iterator it = leaveList.iterator(); it.hasNext();) {
						HashMap map = (HashMap) it.next();
						String trade_id = map.get("trade_id").toString();
						String trade_id2 = "";
						String word_status = "", word_status_value = "";
						String in_date = "";
						String title = "";
						String cust_id2 = "";

						if (map.get("trade_id") != null) {
							trade_id2 = map.get("trade_id").toString();
						}
						if (map.get("cust_id") != null) {
							cust_id2 = map.get("cust_id").toString();
						}
						if (map.get("user_id") != null) {
							user_id = map.get("user_id").toString();
						}
						if (map.get("cust_id") != null) {
						  Custinfo info=new Custinfo();
							cust_id2 = map.get("cust_id").toString();
							cust_name=info.getCustName(cust_id2);
						}

						if (map.get("title") != null) {
							title = map.get("title").toString();
						}
						if (map.get("word_status") != null) {
						  word_status= map.get("word_status").toString();
							//word_status=	 word_status.equals("1")?"已回复":"未回复";
						}
						if (map.get("word_type") != null) {
						  word_type= map.get("word_type").toString();
						}
						if (map.get("in_date") != null) {
							in_date = map.get("in_date").toString();
							if (in_date.length() > 10) {
								in_date = in_date.substring(0, 10);
							}
						}
			%>
			<tr class="u2">
				<td align=left>					
					<a href="sendFeedBack.jsp?trade_id=<%=trade_id%>" ><%=title%></a>
				</td>
				<td align=left>
					<%=in_date%>
				</td>
				<td align=left width="15%">
					<%
						if( word_status.equals("1") )
						{
					%>
					已回复
					<%	
						}else{
					%>
					未回复&nbsp;&nbsp;&nbsp;&nbsp;<a href="sendFeedBack.jsp?trade_id=<%=trade_id%>" ><font color="#FF0000">点击回复</font></a>
					<%	
					}
					%>
				</td>
			</tr>
			<%
					i++;
					}
			%>
			<tr class="u1">
				<%=pageTools%>
			</tr>

			<%
			} else {
			%>
			<tr align=center>
				<td colspan="4">
					暂无记录!
				</td>
			</tr>
			<input name="word_type" type="hidden" value="4" />
			<%
			}
			%>
		</table>
	</body>
</html>




