<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	String iStart = "1",ch_id="";
	if ( request.getParameter("ch_id") != null ) {
		ch_id = request.getParameter( "ch_id" );
	}
	if ( request.getParameter("iStart") != null ) {
		iStart = request.getParameter( "iStart" );
	}
	NewsInfo re = new NewsInfo();
	ArrayList alist = new ArrayList();
	alist = re.genAllNewsByCHID(ch_id);
	int counter = 0;
	if(null!=alist){
		counter = alist.size();
	}
	String pageTools = tools.getPageTools(String.valueOf(counter), "20","repositoryList.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>栏目频道管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<table bgcolor="#DEEDFD" width="100%" cellpadding="1" align="center" cellspacing="1" border="0">
			<tr class="u4">
				<td width="20%" align="left">
					<b>技术名称</b>
				</td>
				<td width="20%" align="center">
					<b>技术内容</b>
				</td>
				<td width="20%" align="center">
					<b>时间</b>
				</td>
				<td width="20%" align="center">
					<b>修改</b>
				</td>
				<td width="20%" align="center">
					<b>删除</b>
				</td>
			</tr>
				<%
				String title ="",content="",publish_date="",news_id="";
				if(alist!=null){
					for(int i=0;i<alist.size();i++){
						HashMap map = (HashMap)alist.get(i);
						if(map.get("news_id")!=null){
							news_id = map.get("news_id").toString();
						}
						if(map.get("title")!=null){
							title = map.get("title").toString();
						}
						if(map.get("content")!=null){
							content = map.get("content").toString();
						}
						if(map.get("publish_date")!=null){
							publish_date = map.get("publish_date").toString();
						}
						if(content.length()>15){
							content = content.substring(0,15)+"...";
						}
						if(publish_date.length()>10){
							publish_date = publish_date.substring(0,10);
						}
				%>
			<tr class="u2">
				<td >
					<a href="viewonenews.jsp?news_id=<%=news_id%>&ch_id=<%=ch_id%>"><%=title%></a>
				</td>
				<td >
					<%=content%>
				</td>
				<td>
					<%=publish_date%>
				</td>
				<td>
					<center>
					<a href="updatenews.jsp?news_id=<%=news_id%>&ch_id=<%=ch_id%>">
				  <img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="修改信息"></a>
				</center>
				</td>
				<td align=center>
		 		 <a href="/doTradeReg.do?trade_type_code=8269&info_id=<%=news_id%>&news_id=<%=news_id%>" target="_self">
		  <img src="/images/del.gif" border="0" title="点击删除"> </a></td>
        </tr>
			<%}}%>
					<%=pageTools%>					
          
		</table>
		<table align="center">
			<tr>
          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
          	 	<img src="/admin/images/comeback.JPG" onClick="location.href='modifyProcessList.jsp'" style=" border: 0;cursor: hand; text-align: center;">
          </td>
          </tr>
		</table>
	</body>
</html>



