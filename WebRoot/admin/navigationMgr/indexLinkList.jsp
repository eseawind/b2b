<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.indexLinkMgr.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	String meun_idx = "";
	if (request.getParameter("iStart") != null)
	{
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
	{
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("menu_id") != null)
	{
		meun_idx = request.getParameter("menu_id");
		logsession.setAttribute("menu_id", meun_idx);
	}
	if (logsession.getAttribute("menu_id") != null)
	{
		meun_idx = (String) logsession.getAttribute("menu_id");
	}
	ParamethodMgr comparList = new ParamethodMgr();
	HashMap compMap = comparList.getCompareInfoByCode("CRM","link_type");

	/*****************************************/

	IndexlinkInfo linkList = new IndexlinkInfo();
	ArrayList linkArray = linkList.getLinkListByAll(Integer.valueOf(iStart).intValue());
	int counter = linkList.getLinkNumber();
	int pages = counter / 30 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage)
	{
		if (currenPage > 0)
		{
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	}
	else if (pages == currenPage)
	{
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>新增页面导航</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.line6 {
				width: 72spx;
				width: 70spx !important;
				border: #ffcb99 1px solid;
				background-color: #fff8ee;
				text-align: left;
				padding-left: 20px;
				padding-top: 10px;
				padding-bottom: 10px;
				color: #000000;
				margin-top: 13px;
			}  /*横栏样式6---- 头部提醒1*/
			.line6 .img {
				width: 53px;
				height: 53px;
				float: left;
				margin-right: 20px;
			}
			
			.line6 .title {
				font-size: 14px;
				font-weight: bold;
				color: #ff5400;
			}
			
			.line1 {
				border-left: #ff7300 3px solid;
				background-color: #e2e2e2;
				color: #333333;
				text-align: left;
				font-size: 12px;
			} /*横栏样式1*/
		</style>
	</head>
	<body>
		<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="<%=top_menu_id%>" />
			<jsp:param name="addLink" value="addLinkInfo.jsp" />
		</jsp:include>	
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td align="center" width="15%">
								链接类型
							</td>
							<td align="left" width="25%">
								链接名称
							</td>
							<td align="left" width="48%">
								描述
							</td>
							<td align="center" width="6%">
								修改
							</td>
							<td align="center" width="6%">
								删除
							</td>
						</tr>
						<%
							if (linkArray != null && linkArray.size() > 0)
							{
								int i = 0;
								for (Iterator inIt = linkArray.iterator(); inIt.hasNext();)
								{
									HashMap map = (HashMap) inIt.next();
									String linkName = map.get("link_name").toString();
									String linkIdx = map.get("link_id").toString();
									String link_url = map.get("link_url").toString();
									
									String linkType = "";
									if (map.get("link_type") != null)
									{
								linkType = map.get("link_type").toString();
								if (compMap.get(linkType) != null)
								{
									linkType = compMap.get(linkType).toString();
								}
									}
									String linkDesc = "";
									if (map.get("link_desc") != null)
									{
								linkDesc = map.get("link_desc").toString();
								linkDesc = linkDesc.replaceAll("<[^<>]+>", "");
								if (linkDesc.length() > 30)
								{
									linkDesc = linkDesc.substring(0, 30);
								}
									}
						%>
						<tr class="u2" id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">

							<td align="center"><%=linkType%></td>

							<td align="left"><a href="<%=link_url%>" target="_blank"><%=linkName%></a></td>

							<td align="left"><%=linkDesc%></td>
							
							<td align="center"><a href=modifyLinkInfo.jsp?link_id=<%=linkIdx%> target="_blank"><img src=/images/edit.gif width=16 height=16 border=0></a></td>

							<td align="center"><a href=/doTradeReg.do?link_id=<%=linkIdx%>&trade_type_code=0912 target="_self"><img src=/images/del.gif width=16 height=16 border=0></a></td>
						</tr>
						<%
								i++;
								}
						%>
						<tr class="u1">

							<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>

							<td  align="right" colspan="3"  style=" padding:2px 5px;">
							<a href="pageIndex.jsp?iStart=0&menu_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="pageIndex.jsp?iStart=<%=pageUp%>&menu_id=<%=meun_idx%>">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="pageIndex.jsp?iStart=<%=pageDown%>&menu_id=<%=meun_idx%>">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="pageIndex.jsp?iStart=<%=pages-1%>&menu_id=<%=meun_idx%>">尾页</a></td>

				         </tr>
						<%
						}
						%>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>



