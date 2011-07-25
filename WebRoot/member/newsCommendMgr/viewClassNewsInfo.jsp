<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="bean" class="com.saas.biz.newsMgr.NewsInfo" scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>

<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String news_types="";
	String iStart = "1",class_type="";
	
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("class_type") != null) {
		class_type = request.getParameter("class_type");
	}
	if (request.getParameter("class_id") != null) {
		news_types = request.getParameter("class_id");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	//out.println(cust_id);
//	out.println("*****"+news_types);
	ArrayList newsList = bean.getNewsListByCustIdAudi(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
	int counter = bean.getNewsListByCustIdAudi(cust_id,news_types);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "viewClassNewsInfo.jsp?cust_id="+cust_id+"&class_id="+news_types+"&iStart=", Integer.parseInt(iStart));
	
	
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="50"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>信息分类</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">
					&nbsp;<!--<a href="addNewsIndex.jsp?class_id=<%=news_types%>" target="_blank"><img src=/admin/images/newAdd.gif border=0></a>-->&nbsp;
				</td>
				<td width="8">
					<img src="/admin/images/content_06.gif">
				</td>
		  </tr>
  	</table>
		<table width="800" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="30%">
								标题
							</td>
							<td width="10%">
								信息类型
							</td>
							<td width="15%">
								发布日期
							</td>
							<td width="10%">
								推荐值
							</td>
							<td width="10%">
								推荐
							</td>
						</tr>
						
						<%	
								if (newsList != null && newsList.size() > 0) {
								for (Iterator it = newsList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String news_id="",title = "",class_name = "",publish_date = "",info_no="未推荐";
									if (map.get("news_id")!=null)news_id=map.get("news_id").toString();
									if (map.get("title") != null) {title = map.get("title").toString();}
									if (map.get("news_type") != null) {
										class_name = map.get("news_type").toString();
										ArrayList list = new Productclass().genUpclassByClassId(class_name);
										if (list != null && list.size() > 0) {
											HashMap claMap = (HashMap) list.get(0);
											if (claMap.get("class_name") != null) {class_name = claMap.get("class_name").toString();}
											}	
										}	
									if (map.get("publish_date") != null) {
										publish_date = map.get("publish_date").toString();
										if (publish_date.length() > 10) {
											publish_date = publish_date.substring(0, 10);
										}
									}
									 OrderCast ordercast=new OrderCast();
						           HashMap mapOrder=ordercast.getCastByIdandType(news_id,"4");
						            if(mapOrder !=null &&  mapOrder.get("info_no") !=null){info_no= mapOrder.get("info_no").toString();}
						%>
							<tr class="u2">
							<td align=left>
								<a href="/admin/sysInfoMgr/viewNewsInfo.jsp?news_id=<%=news_id%>" TARGET="_blank"><%=title%></a>
							</td>
							<td align=center><%=class_name%></td>
							<td align=center><%=publish_date%></td>
							<td align=center>
								<!--<a href="modifyNewsInfo.jsp?news_id=<%=news_id%>&class_type=<%=class_type%>" TARGET="_blank">--><%=info_no%>
								
							</td>
							<td style="color: #000000;" align=center>
								<a href="commend.jsp?news_id=<%=news_id%>&class_id=<%=news_types%>" target="_self"><img src=/images/edit.gif width=16 height=16 border=0 alt="推荐">
								</a>
							</td>
						</tr>
						<%
						}
						%>
						<tr class="u3">
							<%=pageTools%>
						</tr>
						<%
						}else{
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
									  	<%}
						%>
		</table>
	</body>
</html>





