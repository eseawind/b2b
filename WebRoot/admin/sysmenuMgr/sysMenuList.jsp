<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%
//    commMethodMgr commen = new commMethodMgr();
    String id ="";// commen.GenTradeId();
     String menu_id = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
    <link href="/style/daohang.css" rel="stylesheet" type="text/css">
    <link href="/style/manager.css" rel="stylesheet" type="text/css">
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
                              <jsp:include page="menuinfoList.jsp"/>
                          </td>
                        </tr>
                     </table>
                </div>
            </div>
            </td> 
        </tr>
    </table>
</body>
</html>




