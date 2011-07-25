<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:directive.page import="java.util.Calendar" />
<jsp:directive.page import="java.text.DateFormat" />
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
    String resumeid="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
       if (request.getParameter("resume_id") != null)
    {
        resumeid = request.getParameter("resume_id");
    }
   //上个页面传过来的
     ResumeInfo resumeinfo = new ResumeInfo();
     ArrayList list=resumeinfo.genResumeByResumeId(resumeid); 
    // out.println(resumeid);
 //已推荐的
  ArrayList resumeList =resumeinfo.getInResumeCommendList(Integer.parseInt(iStart),20);
   int counter=resumeinfo.getInResumeCommendListNum();
   String toolsBar=tools.getPageTools(String.valueOf(counter),"20","commend.jsp?iStart=",Integer.parseInt(iStart));
  //out.println(counter);
  Calendar cal = Calendar.getInstance();
 String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
// out.println(start_Date);
  
%>

<html>	
<head>
<title>人才推荐</title>
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
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>推荐人才</b></font></td>
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
		 				姓名:
		 			</td>
		 			<td align=center>
		 				年龄:
		 			</td>
		 			<td align=center>
		 				专业:
		 			</td>
		 			<td align=center>
		 				学历:
		 			</td>
		 			<td align=center>
		 				联系电话:
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
						     String resume_id = "";
							String name = "";
							String born_date = "";
							String age = "";
							String degree = "";
							String position = "";
							String grad_from = "";
							String work_history = "";
							String tel = "";
							String profession="";
							 String info_no="";
							   if (map.get("name") != null) {name = map.get("name").toString();}
							    if (map.get("resume_id") != null) {resume_id = map.get("resume_id").toString();}
							    if (map.get("born_date") != null) {born_date = map.get("born_date").toString();}
                                   if (born_date.length() > 10) {born_date = born_date.substring(0, 10);}
							    if (map.get("age") != null) {age = map.get("age").toString();}
							    if (map.get("degree") != null) {degree = map.get("degree").toString();
								                                               degree = bean.getParamNameByValue("39", degree);}
								if (map.get("position") != null) {position = map.get("position").toString();}
								if (map.get("grad_from") != null) {grad_from = map.get("grad_from").toString();}
								if (map.get("tel") != null) {tel = map.get("tel").toString();}
								if (map.get("profession") != null) {profession = map.get("profession").toString();}
							//通过resume_id找推荐的值
							 OrderCast ordercast=new OrderCast();
							 HashMap mapOrder=ordercast.getCastById(resume_id);
							 if(mapOrder !=null &&  mapOrder.get("info_no") !=null){info_no= mapOrder.get("info_no").toString();}
		 		%>
		 		<tr  class="u2"  >
			        <td align=center><a href="/resume/resume_content.jsp?resume_id=<%=resume_id%>"  target="_blank"><%=name%></a></td>
					<td align=center><%=age%></td>
					<td align=center><%=profession%></td>
					<td align=center><%=degree%></td>
					<td align=center><%=tel%></td>
					<td align=left>
						<input type="text" name="info_no" id="info_no"  value="<%=info_no%>"  size="5" onkeyup="if(isNaN(value))execCommand('undo');" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="推荐"  onclick="javascript:return check()"/></td>
					<td>
						<input type="hidden" name="info_id" id="info_id"  value="<%=resume_id%>" />
						<input name=cust_class  type=hidden value="3">
						<input name=info_title  type=hidden value="">
						<input name=info_type  type=hidden value="2" >
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
			        <td width="15%" align=center>姓名</td>
					<td width="15%" align=center>年龄</td>
					<td width="15%" align=center>专业</td>
					<td width="15%" align=center>学历</td>
					<td width="20%" align=center>联系电话</td>
					<td width="10%" align=center>推荐值</td>
					<td width="15%" align=center>删除</td>
		        </tr>
		        <%
		            if(resumeList != null && resumeList.size()>0)
		            {
		            	 for (Iterator it = resumeList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						     String resume_id = "";
							String name = "";
							String born_date = "";
							String age = "";
							String degree = "";
							String position = "";
							String grad_from = "";
							String work_history = "";
							String tel = "";
							String profession="";
							String info_no="";
							   if (map.get("name") != null) {name = map.get("name").toString();}
							    if (map.get("resume_id") != null) {resume_id = map.get("resume_id").toString();}
							    if (map.get("born_date") != null) {born_date = map.get("born_date").toString();}
                                   if (born_date.length() > 10) {born_date = born_date.substring(0, 10);}
							    if (map.get("age") != null) {age = map.get("age").toString();}
							    if (map.get("degree") != null) {degree = map.get("degree").toString();
								                                               degree = bean.getParamNameByValue("39", degree);}
								if (map.get("position") != null) {position = map.get("position").toString();}
								if (map.get("grad_from") != null) {grad_from = map.get("grad_from").toString();}
								if (map.get("tel") != null) {tel = map.get("tel").toString();}
								if (map.get("profession") != null) {profession = map.get("profession").toString();}
							    if (map.get("info_no") != null) {info_no = map.get("info_no").toString();}
							   //out.println(info_no);
								
						 %>
						  <tr class="u2" id="changcolor_tr<%=cust_id%>" onmouseover="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')">
						  	 <td  align=center><a href="/resume/resume_content.jsp?resume_id=<%=resume_id%>"  target="_blank"><%=name%></a></td>
						  	 <td  align=center><%=age%></td>
						  	 <td  align=center><%=profession%></td>
						  	 <td  align=center> <%=degree%></td>
					           <td align=center>  <%=tel%> </td>
					           <td  align=center><%=info_no%></td>
					            	<td align=center><a href=/doTradeReg.do?info_id=<%=resume_id%>&trade_type_code=0367  target="_self"  onClick="return roleListchechIfo()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除推荐"></a></td>
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


