<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String news_types = "";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("news_type") != null) {
		news_types = request.getParameter("news_type");
	}
	String str1 = "";
	ArrayList classlist = bean.getClassByUpId();
	if (classlist != null && classlist.size() > 0) {
		String class_name = "", class_id = "";
		for (int a = 0; a < classlist.size(); a++) {
			HashMap class_map = (HashMap) classlist.get(a);
			if (class_map.get("class_name") != null) {
				class_name = class_map.get("class_name").toString();
			}
			if (class_map.get("class_id") != null) {
				class_id = class_map.get("class_id").toString();
			}
			str1 += "<option value=" + class_id + ">" + class_name + "</option>";
		}
	}
	
	NewsInfo newsObj = new NewsInfo();
	ArrayList newsList = newsObj.getNewsListByCustId(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
	int counter = newsObj.getNewsListByCustId(cust_id,news_types);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "modifyNewsIndex.jsp?news_type="+news_types+"iStart=", Integer.parseInt(iStart));
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
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
		<script language="javascript">
		  function checkRaleType(type){
		  	if(type!="0"){
			       document.relationForm.submit();
			       }
			  }
		</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="13"></td>
			</tr>
			<tr>
				<td height="13" background="/images/kehu_list_17.gif" align="left">
					<form name="relationForm" id="relationForm" action="modifyNewsIndex.jsp" method="post">
						请选择信息分类:
						<select name="news_type" id="news_type" onchange="checkRaleType(this.value)">
							<option value="0">
								请选择...
							</option>
							<%=str1%>
						</select>
					</form>
				</td>
			</tr>
			<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
				<tr>
					<td width="2" background="/images/kehu_list_03.gif" height="8"></td>
					<td width="704" background="/images/kehu_list_04.gif" height="8"></td>
					<td width="2" background="/images/kehu_list_06.gif" height="8"></td>
				</tr>
			</table>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#DEEDFD">
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
								修改
							</td>
							<td width="10%">
								删除
							</td>
						</tr>
						<%
								if (newsList != null && newsList.size() > 0) {
								for (Iterator it = newsList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String news_id = map.get("news_id").toString();
									String title = "";
									String class_name = "";
									String publish_date = "";
									if (map.get("title") != null) {title = map.get("title").toString();}

									if (map.get("news_type") != null) {
										class_name = map.get("news_type").toString();
										ArrayList list = bean.genUpclassByClassId(class_name);
										if (list != null && list.size() > 0) {
											HashMap claMap = (HashMap) list.get(0);
											if (claMap.get("class_name") != null) {
												class_name = claMap.get("class_name").toString();
											}
										}
									}

									if (map.get("publish_date") != null) {
										publish_date = map.get("publish_date").toString();
										if (publish_date.length() > 10) {
											publish_date = publish_date.substring(0, 10);
										}
									}
						%>
						<tr class="u2">
							<td align=left>
								<a href="viewNewsInfo.jsp?news_id=<%=news_id%>" TARGET=appwin onclick="mydefss()"><%=title%></a>
							</td>
							<td align=center><%=class_name%></td>
							<td align=center><%=publish_date%></td>
							<td align=center>
								<a href=modifyNewsInfo.jsp?news_id= <%=news_id%> TARGET=appwin onclick="mydefss()"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改资讯信息">
								</a>
							</td>
							<td align=center>
								<a href="/doTradeReg.do?news_id=<%=news_id%>&trade_type_code=0291" target="_self"><img src=/images/del.gif width=16 height=16 border=0 alt="删除资讯信息">
								</a>
							</td>
						</tr>
						<%
						}
						%>
						<tr class="u1">
							<%=pageTools%>
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



