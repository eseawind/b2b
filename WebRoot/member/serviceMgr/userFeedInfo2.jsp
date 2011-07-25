<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	  String cust_id="",cust_name="",user_id1=""; 
    String iStart ="0";
    String user_id="",user_name="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (session.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = session.getAttribute("SESSION_CUST_ID").toString();
    }
    String root_id="BO8SJKa0Iqg8iix";


  LeavewordsInfo leavewords = new LeavewordsInfo();
  ArrayList leaveList = leavewords.getLeaveNumberByRootId( Integer.valueOf(iStart).intValue() ,cust_id,root_id);
  int counter = leavewords.getLeaveNumberByRootId(cust_id,root_id);
  
  
  int pages = (counter-1)/20 + 1;
	int pageUp = 0,pageDown = 0;
	int currenPage = Integer.valueOf( iStart ).intValue();
	if( pages > currenPage )
	{
	   if( currenPage > 0 )
	   {
				pageUp = currenPage - 1;
	   }
		pageDown = currenPage+1;
	}
  else if( pages == currenPage )
	{
	   pageUp = currenPage - 1;
	   if( pageUp == 0 )
	   		pageUp = 1;
	   pageDown = currenPage;
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<%
			String top_menu_id = "";
			if (request.getParameter("menu_id") != null) {
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center
			bgcolor="#98D9A2">
			<tr class="u4" height="25">
				<td align=left width="30%">
					标题
				</td>
				<td align=left width="20%">
					意见类型
				</td>
				<td align=left width="20%">
					时间
				</td>
				<td align=left width="15%">
					是否回复
				</td>
			</tr>
			<%
					if (leaveList != null && leaveList.size() > 0) {
					int i = 0;
					for (Iterator it = leaveList.iterator(); it.hasNext();) {
						HashMap map = (HashMap) it.next();
						String trade_id = map.get("trade_id").toString();
						String cust_name_user = "";
						String trade_id2 = "";
						String word_status = "", word_status_value = "",word_type="";
						String in_date = "";
						String title = "";
						String cust_id2 = "";

						if (map.get("trade_id") != null) {
					trade_id2 = map.get("trade_id").toString();
						}
						if (map.get("word_type") != null) {
							word_type = map.get("word_type").toString();
							 if(word_type.equals("4")){
	           		word_type = "求助";
		           }
		           if(word_type.equals("5")){
		           		word_type = "业务联系";
		           }
		           if(word_type.equals("6")){
		           		word_type = "投诉";
		           }
		           if(word_type.equals("7")){
		           		word_type = "表扬";
		           }
		           if(word_type.equals("8")){
		           		word_type = "建议";
		           }
						}
						if (map.get("cust_id") != null) {
					cust_id2 = map.get("cust_id").toString();
						}
						if (map.get("user_id") != null) {
					user_id = map.get("user_id").toString();
						}
						if (map.get("cust_name") != null) {
					cust_name_user = map.get("cust_name").toString();
						}
						if (map.get("title") != null) {
					title = map.get("title").toString();
						}
						if (map.get("word_status") != null) {
							word_status_value = map.get("word_status").toString();
							word_status = bean.getParamNameByValue("104",word_status_value);
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
						<a href="showFeedbackInfo.jsp?trade_id=<%=trade_id%>"><%=title%></a>
				</td>
				<td align=left>
						<%=word_type%>
				</td>
				<td align=left>
					<%=in_date%>
				</td>
				<td align=left>
					<%
						if(word_status_value.equals("1")){
					%>
						<a href="showFeedbackInfo.jsp?trade_id=<%=trade_id%>"><img src="/images/view.gif" border="0" alt="查看意见回复"></a>
					<%
						}else{
					%>
						<%=word_status%>
					<%
						}
					%>
				</td>
			<%
					i++;
					}
			%>
			<tr class="u1">
				<td align="left" colspan="2"
					style="font-weight:normal; padding:2px 5px;">
					共
					<%=counter%>
					条 &nbsp;第
					<%=Integer.parseInt(iStart) + 1%>
					页&nbsp;&nbsp;共
					<%=pages%>
					页
				</td>
				<td align="right" colspan="3" style=" padding:2px 5px;">
					<a href="userFeedInfo2.jsp?iStart=0&menu_id=<%=top_menu_id%>">首页
					</a>&nbsp; &nbsp;
					<%
					if (Integer.parseInt(iStart) > 0) {
					%>
					<a
						href="userFeedInfo2.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>">上一页</a>
					&nbsp;
					<%
							}
							if (Integer.parseInt(iStart) < pages - 1) {
					%>
					<a
						href="userFeedInfo2.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>">下一页
					</a>&nbsp;
					<%
					}
					%>
					<a
						href="userFeedInfo2.jsp?iStart=<%=pages - 1%>&menu_id=<%=top_menu_id%>">尾页</a>
				</td>
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




