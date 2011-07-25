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
<%@ page import="com.saas.biz.validityMgr.ValidityInfo"%>
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
	//out.println(news_types);
	ArrayList newsList = bean.getNewsListByCustIdAuditing(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
	//out.println(newsList);
	int counter = bean.getNewsListByCustIdAuditing(cust_id,news_types);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "viewClassNewsInfo.jsp?cust_id="+cust_id+"&class_id="+news_types+"&iStart=", Integer.parseInt(iStart));
	
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
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
								审批值
							</td>
							<td width="10%">
								审批
							</td>
						</tr>
						
						<%	
								if (newsList != null && newsList.size() > 0) {
								for (Iterator it = newsList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String news_id="",title = "",class_name = "",publish_date = "",info_no="未审批",trade_id="";
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
									if (map.get("publish_date") != null) {publish_date = map.get("publish_date").toString();
										                                                        if (publish_date.length() > 10) {publish_date = publish_date.substring(0, 10);}
									                                                        }
						            if(map.get("info_state") !=null){info_no= map.get("info_state").toString();
						                                                               if("1".equals(info_no)) info_no="审批通过";
						                                                               if("0".equals(info_no)) info_no="未审批";
						                                                               if("2".equals(info_no)) info_no="审批未通过";}
						             if(map.get("trade_id") !=null){trade_id= map.get("trade_id").toString();}
						            // out.println(trade_id);
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
								<a href="auditValidity.jsp?trade_id=<%=trade_id%>&quo_id=<%=news_id%>&info_type=1&class_id=<%=news_types%>" target="_self"><img src=/images/edit.gif width=16 height=16 border=0 alt="审批">
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
						<tr>
					      <td colspan="5" >
					      	<center>
					      	<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;">
					      </center>
					      </td>
						 </tr>
		</table>
	</body>
</html>




