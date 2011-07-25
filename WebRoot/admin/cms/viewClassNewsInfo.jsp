<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="bean" class="com.saas.biz.newsMgr.NewsInfo" scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String news_types = "";
	String iStart = "1", class_type = "",message_class="";
	request.setCharacterEncoding("gbk");
	ChannelInfo channel = new ChannelInfo();
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("class_type") != null) {
		class_type = request.getParameter("class_type");
		
	}
	String classid = "";
	if (request.getParameter("class_id") != null) {
		news_types = request.getParameter("class_id");
		
		message_class = channel.getChName(news_types);
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}

	ArrayList newsList = new ArrayList();
	int counter = 0;

	String news_title = "";
	if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
	}
	if (!news_title.equals("")) {
		newsList = bean.getNewsListByNewsTitle(Integer.valueOf(iStart).intValue(), cust_id, news_types, news_title);
		counter = bean.getNewsListByNewsTitle(cust_id, news_types,news_title);
	}else{
		newsList = bean.getNewsListByCustId(Integer.valueOf(iStart).intValue(), cust_id, news_types);
		counter = bean.getNewsListByCustId(cust_id, news_types);
	}

	String pageTools = tools.getPageTools(String.valueOf(counter),
			"20", "viewClassNewsInfo.jsp?news_title=" + news_title
			+ "&cust_id=" + cust_id + "&class_id=" + news_types
			+ "&iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
				function search(){
						if(document.getElementById('news_title').value==''){
								alert('请输入信息标题！');
								return false;
						}
						document.searchForm.submit();
				}
				
				function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
				
				function delAllNews1(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								if(document.getElementById('re_news'+i).checked)
								document.getElementById('re_news'+i).checked=false;
								else
									document.getElementById('re_news'+i).checked=true;	
						}
				}
				
				function reloadNews(val){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('news_id').value = all_news_id;
						document.getElementById('info_id').value = all_news_id;
						document.getElementById('root_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}
						if(val==1){
							document.searchForm.action='/doTradeReg.do';
							document.searchForm.submit();
						}
						if(val==2){
							document.searchForm.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value='0391';
							//alert(document.getElementById("trade_type_code").value);
							document.searchForm.submit();
						}
				}
				
		function setInfoId()
		{
			document.getElementById('info_id').value = document.getElementById('news_id').value;
		}
		</script>
	</head>
	<body>
		<form action="viewClassNewsInfo.jsp" method="post" name="searchForm">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addNewsIndex.jsp?class_id=<%=news_types%>">新增信息</a>
				</td>
			</tr>
		</table>
			<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
				<%if (newsList == null) {
				%>
				<tr align=center  bgcolor="white">
					<td colspan="6">
						暂无记录!
					</td>
				</tr>
				<%
				}else{%>
				<tr bgcolor="white">
					<td align="left" colspan="6">
						<b>请输入信息标题:</b>
						<input type="text" name="news_title" id="news_title" size="30">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
						<input type="hidden" name="class_id" id="class_id" value="<%=news_types%>">
					</td>
				</tr>
				
				<tr class="u4" height="25">
					<td width="20%">
						标题
					</td>
					<td width="25%">
						信息类型
					</td>
					<td width="20%">
						发布日期
					</td>
					<td width="10%" align="center">
						修改
					</td>
					<!--td width="10%" align="center">
						删除
					</td-->
					<td width="25%" align="center">
						<input type="button" name="reload" value="删除" onclick="reloadNews(2)" />
						<input type="button" name="reload" value="刷新" onclick="reloadNews(1)" />
						<input type="button" name="selAll" value="全选" onclick="selAllNews()" />
						<input type="button" name="delAll" value="反选" onclick="delAllNews1()" />
					</td>
				</tr>

				<%
						if (newsList != null && newsList.size() > 0) {
						int size = newsList.size();
						for (int i = 0; i < newsList.size(); i++) {
							HashMap map = (HashMap) newsList.get(i);
							String news_id = "", title = "", class_name = "", publish_date = "";
							if (map.get("news_id") != null)
						news_id = map.get("news_id").toString();
							if (map.get("title") != null) {

						title = map.get("title").toString();
						if (title.length() > 10) {
							title = title.substring(0, 10) + "...";
						}
							}
							if (map.get("news_type") != null) {
								class_name = map.get("news_type").toString();
								ArrayList list = new Productclass().genUpclassByClassId(class_name);
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
						<a href="viewNewsInfo.jsp?news_id=<%=news_id%>" TARGET=""><%=title%>
						</a>
					</td>
					<td align=center>
						<%=message_class%>
					</td>
					<td align=center>
						<%=publish_date%>
					</td>
					<td align=center>
						<a href="modifyNewsInfo.jsp?news_id=<%=news_id%>&class_type=<%=news_types%>" TARGET=""><img src=/images/edit.gif width=16 height=16 border=0 alt="修改资讯信息"> </a>
					</td>
					<!--td style="color: #000000;" align=center>
						<a href="/doTradeReg.do?info_id=<%=news_id%>&root_id=<%=news_id%>&news_id=<%=news_id%>&trade_type_code=0291" target="_self"><img src=/images/del.gif width=16 height=16 border=0 alt="删除资讯信息"> </a>
					</td-->
					<td style="color: #000000;" align=center>
						<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=news_id%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
					</td>
				</tr>
				<%
				}
				%>
				<tr class="u3">
					<%=pageTools%>
				</tr>
				<%
				}
				}
				%>

				<input type="hidden" name="trade_type_code" value="8859" />
				<input type="hidden" name="news_id" id="news_id" value="" />
				<input type="hidden" name="root_id" id="root_id" value="" />
				<input type="hidden" name="info_id" id="info_id" value="" />
 				<tr >
					 <td colspan="6">
					 	<center>
					   <img src="/admin/images/comeback.JPG" onClick="location.href='modityNewsIndex.jsp'" style="cursor:hand;" align="absmiddle">
				   </center>
				   </td>
				</tr>
			</table>
		</form>
	</body>
</html>



