<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<%
   HttpSession  logsession = request.getSession(); 
    String suser_name = "";
    String iStart ="1";
    String meun_idx="";
    String cust_id="";
    boolean flag=false;
    String cust_type="";
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
    if( logsession.getAttribute("SESSION_CUST_ID")!= null)
    {
       cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    Custinfo info =new Custinfo();
    cust_type=info.getCustTypeById(cust_id);
    if(cust_type.equals("1"))
     flag=true;
  LeavewordsInfo enquiryObj=new LeavewordsInfo();
  int counter = 0 ;
    ArrayList newsList = new ArrayList();

   	newsList = enquiryObj.getLeavelListByOut(Integer.valueOf(iStart).intValue(),10,cust_id);

    counter=enquiryObj.getLeavelListByOut(cust_id);

String pageTools=tools.getPageTools(String.valueOf(counter),"10","sendNewsIndex.jsp?iStart=",Integer.parseInt(iStart));
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

</head>
<body>
	<form action="sendNewsIndex.jsp" method="post" name="indexdateform">
				 <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td height="30"> 
			</td>
			</tr>
      <tr>
			  <td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>已发出的信息</b></font></td>
			  <%if(flag){%><!--admin to customer-->
				  <td background="/admin/images/content_04.gif" align="right">&nbsp;<a href=toadmin.jsp target=_blank><img src=/admin/images/pay.gif border=0></a>&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
				<%}else{%>
			  <td background="/admin/images/content_04.gif" align="right">&nbsp;<a href=toadmin.jsp target=_blank><img src=/admin/images/pay.gif border=0></a>&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>			
				<%}%>
		  </tr>
	     </table>

		     <table width=800 border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#DEEDFD">
		        <tr class="u4">
			        <td  align=left width="25%">标题</td>
					    <td  width="30%">信息内容</td>
					    <td  width="15%">收信人</td>
					    <td  width="15%">发信日期</td>
		        </tr>
		        <%
		            if(newsList != null && newsList.size()>0)
		            {  
                  String word_type="";
		              	 for (Iterator it = newsList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String trade_id=map.get("trade_id").toString();
						        String title="";
						         String cust_name="";
						        String content="";
						        String in_date="";
						        if(map.get("title")!=null)
						        {
						         title=map.get("title").toString();
						        }
						         if(map.get("cust_id")!=null)
						        {
						         cust_id=map.get("cust_id").toString();
						         cust_name =info.getCustName(cust_id);
						        }
						        if(map.get("content")!=null)
						        {
						          content=map.get("content").toString();
						          if(content.length()>10)
						          {
						             content=content.substring(0,10)+"...";
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
						         if(map.get("word_type")!=null)
						        {
						          word_type=map.get("word_type").toString();

						         }
						        %>
						        
						        <tr class="u2" >
					              <td  align=left>
					              	<center>
						              <a href="sendFeedBack.jsp?trade_id=<%=trade_id%>" ><%=title%></a>
					                </center>
					              	</td>
					              <td  align=left><%=content%></td>
					              <%if(word_type.equals("a")){%>
					              <td  align=left>全部客户</td>
					              <%}else{%>
					              <td  align=left><%=cust_name%></td>
					              <%}%>
					              <td  align=left><%=in_date%></td>

					            </tr>
					            <%
					     }
					     %>
					     
					      <tr>
							  <%=pageTools%>
							 </tr>
					     
					  <%}
		          else
		          	{
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
	</form>	
</body>
</html>



