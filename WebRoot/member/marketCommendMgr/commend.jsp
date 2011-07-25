<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.roleMgr.RoleInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:directive.page import="java.util.Calendar" />
<jsp:directive.page import="java.text.DateFormat" />
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
    String newsid="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
       if (request.getParameter("news_id") != null)
    {
        newsid = request.getParameter("news_id");
    }
     JobInfo jobinfo = new JobInfo();
   //上个页面传过来的
    NewsInfo newsinfo=new NewsInfo();
     ArrayList list=newsinfo.getNewsById(newsid); 
    // out.println(resumeid);
 //已推荐的
 ArrayList newsList =newsinfo.getInNewsCommendList(Integer.parseInt(iStart),20,"8bNE6EQ173XEJ07");//建材市场信息
  int counter=newsinfo.getInNewsCommendList("8bNE6EQ173XEJ07");
  String toolsBar=tools.getPageTools(String.valueOf(counter),"20","commend.jsp?iStart=",Integer.parseInt(iStart));
  Calendar cal = Calendar.getInstance();
 String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>

<html>	
<head>
<title>建材市场推荐</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style>
  .t_head{style="color:#000000;  font-weight:bold; font-size:13px;" }
</style>
		<script type="text/javascript" src="/js/resumeMgr.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/OrderCast.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
</head>
<body>
	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>推荐</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
	<table width="800" border="0" cellspacing="0" cellpadding="0" align=center>
		<tr>
		 <td>
		 	<form action=/doTradeReg.do method="post" target="_self" name="resumeForm">
		 	  <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
		 		   <tr class="u4" height="25">
		 			<td align=center>
		 				资讯标题:
		 			</td>
		 			<td align=center>
		 				发布时间:
		 			</td>
		 			<td align=center>
		 				发布人:
		 			</td>
		 			<td align=center>
		 				推荐值:
		 			</td>
		 		</tr>
		 		<%
		 		  if(list != null && list.size()>0){
		 		   for (Iterator it = list.iterator(); it.hasNext();)
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
		 		<tr  class="u2"  >
			        <td  align=center><a href="/news/zixun_list_content.jsp?news_id=<%=news_id%>" target=_blank ><%=title%></a></td>
					 <td  align=center><%=publish_date%></td>
					<td  align=center><%=publish_user_id%> </td>
					<td align=left>
						<input type="text" name="info_no" id="info_no"  value="<%=info_no%>"  size="5" onkeyup="if(isNaN(value))execCommand('undo');" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="推荐"  onclick="javascript:return check()"/></td>
					<td>
						<input type="hidden" name="info_id" id="info_id"  value="<%=news_id%>" />
						<input name=cust_class  type=hidden value="3">
						<input name=info_title  type=hidden value="">
						<input name=info_type  type=hidden value="5" >
						<input name=start_date  type=hidden value="<%=start_Date%>"  >
						<input name=end_date  type=hidden value= "<%=start_Date%>" >
						<input name=session_user_id  type=hidden value= "" >
						<input name=remark  type=hidden value= "" >
						<input name=trade_type_code type=hidden value= "0355" >
					</td>
		        </tr>
		        <%
		        }
		        }
		        %>
		 	</table>
		</form>
		</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
				
						<td colspan="6"  height="10">
				
				已推荐的如下:
			</td>
			
			</tr>
		</table>
			</td>
		</tr>
	  <tr>
	    <td>
		     <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
		        <tr class="u4" height="25">
			        <td width="15%" align=center>资讯标题</td>
					<td width="15%" align=center>发布时间</td>
					<td width="15%" align=center>发布人</td>
					<td width="15%" align=center>推荐值</td>
					<td width="15%" align=center>删除</td>
		        </tr>
		        <%
		            if(newsList != null && newsList.size()>0)
		            {
		            	 for (Iterator it = newsList.iterator(); it.hasNext();)
		                  {
						   HashMap map = (HashMap) it.next();
						  String title="",news_id="",content="",publish_date="",publish_user_id="",user_name="",info_no="",custid="";
						      if (map.get("title") != null) {title = map.get("title").toString();}
						       if (map.get("info_no") != null) {info_no = map.get("info_no").toString();}
						       if (map.get("news_id") != null) {news_id = map.get("news_id").toString();}
						        if (map.get("content") != null) {content = map.get("content").toString();
						                                                          if(content.length()>20) content=content.substring(0,19);}
						         if (map.get("publish_date") != null) {publish_date = map.get("publish_date").toString();}
						         if(publish_date.length()>10) publish_date=publish_date.substring(0,10);
						          if (map.get("publish_user_id") != null) {publish_user_id = map.get("publish_user_id").toString();}
						          // OrderCast ordercast=new OrderCast();
						           //HashMap mapOrder=ordercast.getCastByIdandType(news_id,"4");
						           // if(mapOrder !=null &&  mapOrder.get("info_no") !=null){info_no= mapOrder.get("info_no").toString();}
						              if (map.get("CUST_ID") != null) {custid = map.get("CUST_ID").toString();}
						                String job_cust_name = new Custinfo().getCustNameById(custid);
								
						 %>
				   <tr  class="u2"  >
			        <td  align=center><a href="/news/zixun_list_content.jsp?news_id=<%=news_id%>" target=_blank ><%=title%></a></td>
					 <td  align=center><%=publish_date%></td>
					<td  align=center><%=publish_user_id%> </td>
				    <td  align=center><%=info_no%></td>
					 <td align=center><a href=/doTradeReg.do?info_id=<%=news_id%>&trade_type_code=0367  target="_self"  onClick="return roleListchechIfo()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除推荐"></a></td>
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
</body>
</html>


