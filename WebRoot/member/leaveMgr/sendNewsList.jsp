<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	 request.setCharacterEncoding("gbk");
     String start_time1 ="",end_time1 ="",code="",key_word="";
     Calendar cal = Calendar.getInstance();
     if (request.getParameter("start_time") != null) {
		start_time1 = request.getParameter("start_time");
	}
	if (request.getParameter("end_time") != null) {
		end_time1 = request.getParameter("end_time");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word").trim();
	}
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>
<%
   HttpSession  logsession = request.getSession(); 
    String suser_name = "";
    String iStart ="1";
    String meun_idx="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_USER_NAME") != null)
    {
        suser_name = logsession.getAttribute("SESSION_USER_NAME").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        meun_idx = request.getParameter("menu_id");
        logsession.setAttribute("menu_id",meun_idx);
    }
    if( logsession.getAttribute("menu_id")!= null)
    {
       meun_idx=(String)logsession.getAttribute("menu_id");
    }
  LeavewordsInfo enquiryObj=new LeavewordsInfo();
  int counter = 0 ;
  ArrayList newsList = new ArrayList();
  if("1".equals(code)){
   	newsList = null;//enquiryObj.getLeavelListByMyKey(Integer.valueOf(iStart).intValue(),suser_name,key_word);
    counter=0;//enquiryObj.getLeaveNumberByMyKey(suser_name,key_word);
  }else if("2".equals(code)){
   	newsList = null;//enquiryObj.getLeavelListByMyDate(Integer.valueOf(iStart).intValue(),suser_name,start_time1,end_time1);
    counter=0;//enquiryObj.getLeaveNumberByMyDate(suser_name,start_time1,end_time1);
  }else{
   	newsList = enquiryObj.getLeavelListByMy(Integer.valueOf(iStart).intValue(),suser_name);
  // ParamethodMgr paramObj=new ParamethodMgr();
  //HashMap typeMap=paramObj.getCompareInfoByCode("CRM","news_type");
    counter=enquiryObj.getLeaveNumberByMy(suser_name);
  }
String pageTools=tools.getPageTools(String.valueOf(counter),"30","sendNewsIndex.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link rel="stylesheet" type="text/css"  href="../css/mg.css"/>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<link href="/style/css.css" rel="stylesheet" type="text/css">
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
<script language="javascript">
  function chechIfo()
  {
	   if(confirm('是否确认删除留言？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
</script>
<script language="javascript">
	  function Check_Value(){
	       if(document.getElementById("start_time").value ==null || document.getElementById("start_time").value ==""){
	        alert("请选择开始时间！");
	        return false;
	       }
	       if(document.getElementById("end_time").value ==null || document.getElementById("end_time").value ==""){
	        alert("请选择结束时间！");
	        return false;
	       }
	    document.indexdateform.submit();
	  }
	  function Change()
	  {
	  	document.getElementById("keyword").value="";
	  	
	  }
	 function search(){
	 	if(document.getElementById('keyword1').value==''){
	 			alert('请输入关键字！');
	 			return false;
	 	}
	 	document.indexdateform.submit();
	 }
</script>
</head>
<body>
	<form action="sendNewsIndex.jsp" method="post" name="indexdateform">
			<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="<%=top_menu_id%>" />
			</jsp:include>	
		<table  width="100%" border=0 cellpadding=2 cellspacing=1   bgcolor="#efefef">
			<tr>
				<td bgcolor="white" align="left">
					开始时间:<input type="text" id="start_time" name="start_time" onfocus="setday(this);" value="<%=start_time%>">
					结束时间:<input type="text" id="end_time" name="end_time" onfocus="setday(this);" value="<%=end_time%>">
					<img src="/images/chaxun.gif" onclick="Check_Value();" style="cursor:hand;">
					<input type="hidden" name="code" value="2">
				</td>
				
			</tr>
		</table>	
		<table width="800" border=0 cellpadding=2 cellspacing=1   bgcolor="#efefef">		
			<tr>
				<td bgcolor="white" align="left">
				关键字:<input type="text" id="keyword1" name="key_word"  value="">
					<input type="hidden" name="code" value="1">
					<img src="/images/chaxun.gif" onclick="search();" style="cursor:hand;">	
				</td>
			</tr>
		</table>
	
		<%if(null==newsList && ("1".equals(code)||"2".equals(code))) {%>
			很抱歉！没有您要查询的记录。
		<%} else{%>
	<table width="800" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td>
		     <table width=800 border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        <td background="/images/newsbg.gif" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=left width="25%">新闻标题</td>
					<td background="/images/newsbg.gif" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="50%">留言内容</td>
					<td background="/images/newsbg.gif" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="10%">收言人</td>
					<td background="/images/newsbg.gif" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="15%">留言时间</td>
		        </tr>
		        <%
		            if(newsList != null && newsList.size()>0)
		            {   int i=0;
		              	 for (Iterator it = newsList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String trade_id=map.get("trade_id").toString();
						        String title="";
						        String user_name="";
						        String content="";
						        String in_date="";
						        if(map.get("title")!=null)
						        {
						         title=map.get("title").toString();
						        }
						         if(map.get("user_name")!=null)
						        {
						         user_name=map.get("user_name").toString();
						        }
						        if(map.get("content")!=null)
						        {
						          content=map.get("content").toString();
						          if(1>2)//content.length()>30)
						          {
						             content=content.substring(0,30)+"...";
						          }
						         }
						         if(map.get("in_date")!=null)
						        {
						          in_date=map.get("in_date").toString();
						          if(in_date.length()>10)
						          {
						             in_date=in_date.substring(0,10);
						          }
						         }
						       
						        %>
						        
						        <tr  style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
					              <td    style=" color:#000000;" align=left><%=title%></td>
					              <td    style=" color:#000000;" align=left><%=content%></td>
					              <td    style=" color:#000000;" align=left><%=user_name%></td>
					              <td    style=" color:#000000;" align=left><%=in_date%></td>
					             <!--td  class=grayD align=center><a href=/doTradeReg.do?trade_id=<%=trade_id%>&trade_type_code=0273 target="_self"  onClick="return chechIfo()"><img src=/img/edit.gif width=16 height=16 border=0></a></td-->
					            </tr>
					            
						        <%i++;
					     }
					     %>
					     
					     <tr>
							<%=pageTools%>
							</tr>
					     
					     <%
		          }else{
		             %>
						<tr>
							<td colspan="6" align="center" bgcolor="white">
								无记录！
							</td>
						</tr>
					<%		
					}
		        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13"></td>
	  </tr>
	</table>
	<%}%>
	</form>	
</body>
</html>



