<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%

    HttpSession  logsession = request.getSession(); 
    String cust_id = "",cust_name="";
  
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (logsession.getAttribute("SESSION_USER_NAME") != null)
    {
        cust_name = logsession.getAttribute("SESSION_USER_NAME").toString();
    }
    String id ="";// commen.GenTradeId();
     String menu_id = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
%>
<%@ page import="com.base.config.ProjectConfig"%>
<html>
<head>
<title>B2B电子商务后台管理系统</title> 
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>	
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <jsp:include page="/inc/top.jsp"/>
	    <tr><!-- 中间 -->
            <td align="center" >        
	         <div id="manager_body"> <!--左边菜单-->
                <div id="manager_body_left">
                    <jsp:include page="/inc/left.jsp"/>
                </div>
                <div id="manager_body_right">
                     <table width="740" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td>
                                <div id="righttop">
                                <jsp:include page="/inc/menu.jsp">
																  <jsp:param name="menu_id" value="<%=menu_id%>" />
																</jsp:include>
																<%
																  if(cust_name=="admin" || cust_name.equals("admin")){
																%>
                                 <jsp:include page="userInfo.jsp"/>
                                <%}else{
                                	 %>
                                	 
                                	 <jsp:include page="template.jsp">
																      <jsp:param name="cust_id" value="<%=cust_id%>"/>
																   </jsp:include>
                                	 
                                	 <%
                                	}
                                %>
                                </div>
                          </td>
                        </tr>
                     </table>
                </div>  <!--右边 主体部分结束  -->
            </div>
            </td>  <!-- 中间 结束 -->  
        </tr>
        <tr><!-- 底部 -->
         <td align="center">
	    	<div class="bottom_admin">
	    		<%@ include file="../../bottom.jsp" %>
	    	</div>
          </td>
       </tr><!-- 底部结束 -->
    </table>
</body>
</html>



