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
    String custid2="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
       if (request.getParameter("custid") != null)
    {
        custid2 = request.getParameter("custid");
    }
   //上个页面传过来的
    Custinfo custinfo=new Custinfo();
  ArrayList list=custinfo.getOneCustAndClass(custid2);
 //已推荐的
 ArrayList custList =custinfo.getCommendCustAndClass(Integer.parseInt(iStart),20);
  int counter=custinfo.getCommendCustAndClass();
  String toolsBar=tools.getPageTools(String.valueOf(counter),"20","commend.jsp?iStart=",Integer.parseInt(iStart));
  Calendar cal = Calendar.getInstance();
 String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>

<html>	
<head>
<title>会员推荐</title>
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
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>推荐会员</b></font></td>
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
		 				供应商名称:
		 			</td>
		 			<td align=center>
		 				供应商级别:
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
						      String custid1="",info_no="",cust_name="",para_code2="";
						      if (map.get("cust_id") != null) {custid1 = map.get("cust_id").toString();}
						       if (map.get("para_code2") != null) {para_code2 = map.get("para_code2").toString();}
						       if (map.get("cust_name") != null) {cust_name = map.get("cust_name").toString();}
						          OrderCast ordercast=new OrderCast();
						           HashMap mapOrder=ordercast.getCastByIdandType(custid1,"6");
						            if(mapOrder !=null &&  mapOrder.get("info_no") !=null){info_no= mapOrder.get("info_no").toString();}
		 		%>
		 		<tr  class="u2"  >
			        <td  align=center><a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=custid1%>" target=_blank ><%=cust_name%></a></td>
					 <td  align=center><%=para_code2%></td>
					<td align=center>
						<input type="text" name="info_no" id="info_no"  value="<%=info_no%>"  size="5" onkeyup="if(isNaN(value))execCommand('undo');" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="推荐"  onclick="javascript:return check()"/></td>
					<td>
						<input type="hidden" name="info_id" id="info_id"  value="<%=custid1%>" />
						<input name=cust_class  type=hidden value="3">
						<input name=info_title  type=hidden value="">
						<input name=info_type  type=hidden value="6" >
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
			        <td width="15%" align=center>供应商名称</td>
					<td width="15%" align=center>供应商级别</td>
					<td width="15%" align=center>推荐值</td>
					<td width="15%" align=center>删除</td>
		        </tr>
		        <%
		            if(custList != null && custList.size()>0)
		            {
		            	 for (Iterator it = custList.iterator(); it.hasNext();)
		                  {
						   HashMap map = (HashMap) it.next();
						  String custid1="",info_no="",cust_name="",para_code2="";
						      if (map.get("cust_id") != null) {custid1 = map.get("cust_id").toString();}
						       if (map.get("info_no") != null) {info_no = map.get("info_no").toString();}
						       if (map.get("cust_name") != null) {cust_name = map.get("cust_name").toString();}
						        if (map.get("para_code2") != null) {para_code2 = map.get("para_code2").toString();}
						 %>
				   <tr  class="u2"  >
			        <td  align=center><a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=custid1%>" target=_blank ><%=cust_name%></a></td>
					 <td  align=center><%=para_code2%></td>
				    <td  align=center><%=info_no%></td>
					 <td align=center><a href=/doTradeReg.do?info_id=<%=custid1%>&trade_type_code=0367  target="_self"  onClick="return roleListchechIfo()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除推荐"></a></td>
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



