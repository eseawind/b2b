<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%
     HttpSession  logsession = request.getSession(); 
     String user_id="";
     if (logsession.getAttribute("SESSION_USER_ID") != null)
     {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
     }
     String id ="";// commen.GenTradeId();
     String menu_id = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
    ResumeInfo resume=new ResumeInfo();
    ArrayList resumeList=resume.genResumeByUser_Id(user_id);
    boolean isShow=true;
    if(resumeList!=null && resumeList.size()>0)
    {
        isShow=false;
    }
%>
<html>
<head>
<title>B2B���������̨����ϵͳ</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">

    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>	
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <jsp:include page="/inc/top.jsp"/>
	    <tr><!-- �м� -->
            <td align="center" >        
	         <div id="manager_body"> <!--��߲˵�-->
                <div id="manager_body_left">
                    <jsp:include page="/inc/left.jsp"/>
                </div>
                <div id="manager_body_right">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td>
                                <div id="righttop">
                                 <jsp:include page="/inc/menu.jsp">
								  <jsp:param name="menu_id" value="<%=menu_id%>" />
								</jsp:include>
                                </div>
                          </td>
                        </tr>
                        <%
                         if(isShow)
                         {
                        %>
                         <tr>
                          <td>
                                <div id="righttop">
                                    <div class="line1">��Ҫ��������</div>
                                        <div class="line2">
                                            <img src="/admin/images/icon1_manager_rightbody.gif" />  
                                               �������δ�������˼�����Ϣ����Ƹ��λ�����޷������ҵ���<br /><br />
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-left:#dddddd 1px solid;border-right:#dddddd 1px solid;border-top:#dddddd 1px solid;border-bottom:#dddddd 2px solid; margin-bottom:20px; height:35px">
                                              <tr>
                                                <td width="24%" align="right" style=" background-color:#f6f6f6; border-right:#dddddd 1px solid; font-size:14px; color:#000000; font-weight:bold">������Ƹ��Ϣ&nbsp;&nbsp;</td>
                                                <td width="76%">&nbsp;&nbsp;�����Է���������Ϣ������ <a href="#" style="font-size:12px; font-weight:normal">�����˲���Ϣ</a></td>
                                              </tr>
                                            </table>
                                         </div>
                                </div>
                          </td>
                        </tr>
                        <%}%>
                     </table>
                </div>  <!--�ұ� ���岿�ֽ���  -->
            </div>
            </td>  <!-- �м� ���� -->  
        </tr>
        <tr><!-- �ײ� -->
         <td align="center">
	    	<div class="bottom_admin">
	    		<%@ include file="../../bottom.jsp" %>
	    	</div>
          </td>
       </tr><!-- �ײ����� -->
    </table>
</body>
</html>



