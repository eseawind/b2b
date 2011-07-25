<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,java.lang.String"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%
   request.setCharacterEncoding("gbk");
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
     String newsname = "";
	 NewsInfo newsinfo=new NewsInfo();
	 ArrayList newsList = new  ArrayList();
	 if(request.getParameter("newsname")!=null){
	 	newsname= request.getParameter("newsname");
	 }
	  newsList=newsinfo.genAllNews(Integer.parseInt(iStart),20,"8bNE6EQ173XEJ07");
	  int counter=newsinfo.getNewsCountByTypeCount("8bNE6EQ173XEJ07");
 	 String toolsBar=tools.getPageTools(String.valueOf(counter),"20","talentsList.jsp?iStart=",Integer.parseInt(iStart));
     if(!newsname.equals(""))
		{
			 newsList=newsinfo.genAllNewsByLikeName(Integer.parseInt(iStart),20,"8bNE6EQ173XEJ07",newsname);
			 counter=newsinfo.genAllNewsByLikeName("8bNE6EQ173XEJ07",newsname);
		 }
%>

<html>
<head>
<title></title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style>
  .t_head{style="color:#000000;  font-weight:bold; font-size:13px;" }
</style>
		<script type="text/javascript" src="/js/roleMgr.js"></script>
</head>
<body>
	<center>
	<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="6h47JH245t3B4XK" />
		</jsp:include>	
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<form action="commendList.jsp" method="post" name="commForm">
			 <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
			 	<tr class="u4" height="25">
			 		<td align="left">&nbsp;输入咨询标题:&nbsp;<input type="text" width="20%" name="newsname"/>&nbsp;<img src="/admin/images/chaxun.gif" border="0" onclick="document.commForm.submit();" style="cursor:hand;"></td>
			 	</tr>
			</table>
		</form.
		</td>
	</tr>
	  <tr>
	    <td>
		     <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
		        <tr class="u4" height="25">
					<td>咨询标题</td>
					<td width="25%">发布时间</td>
					<td width="25%">已推荐值</td>
					<td width="25%">推荐</td>
		        </tr>
		          <%
		            if(newsList != null && newsList.size()>0)
		            {
		            	 for (Iterator it = newsList.iterator(); it.hasNext();)
		                  {
						     HashMap map = (HashMap) it.next();
						     String title="",news_id="",content="",publish_date="",publish_user_id="",user_name="",info_no="";
						      if (map.get("title") != null) {title = map.get("title").toString();}
						       if (map.get("news_id") != null) {news_id = map.get("news_id").toString();}
						        if (map.get("content") != null) {content = map.get("content").toString();
						                                                          if(content.length()>20) content=content.substring(0,19);}
						         if (map.get("publish_date") != null) {publish_date = map.get("publish_date").toString();}
						         if(publish_date.length()>10) publish_date=publish_date.substring(0,10);
						          if (map.get("publish_user_id") != null) {publish_user_id = map.get("publish_user_id").toString();}
						           OrderCast ordercast=new OrderCast();
						           HashMap mapOrder=ordercast.getCastByIdandType(news_id,"5");
						            if(mapOrder !=null &&  mapOrder.get("info_no") !=null){info_no= mapOrder.get("info_no").toString();}
						        	%>
					<tr class="u2" >
						  	 <td  align=center><a href="/news/zixun_list_content.jsp?news_id=<%=news_id%>" target=_blank ><%=title%></a></td>
						  	 <td  align=center><%=publish_date%></td>
					           <td align=center>	<%
					           		if(info_no!=null && !info_no.equals("")){
					           	%><%=info_no%>
					           	<%}
					           	else{ %>未推荐
					           		<%}%> </td> 
					           <td  align=center><a href="commend.jsp?news_id=<%=news_id%>" TARGET=appwin ><img src=/images/edit.gif width=16 height=16 border=0 alt="推荐"></a>&nbsp;&nbsp;&nbsp;
					            	</td>
					</tr>
					<%    
				        }
				        	%>
					 <tr class="u1">
						 <%=toolsBar%>	
					</tr>
					<%
						  }
				%>
		      
		    </table>
	     </td>
	  </tr>
	</table>
</center>
</body>
</html>


