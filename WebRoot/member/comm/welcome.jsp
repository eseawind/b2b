<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
<!--
body {
	margin: 0px;
	padding:0px;
	
}
-->
</style>
<link href="/style/b2b_css.css" rel="stylesheet" type="text/css" />

<title>�ޱ����ĵ�</title>
</head>
<body>
<span style="font-family:Verdana, Arial, Helvetica, sans-serif; color:#666;font-size:12px;"><%
	String cust_id="",user_name="";
    HttpSession  logsession = request.getSession(); 
    String cust_name = "";
    if( logsession.getAttribute("SESSION_CUST_ID")!= null )
    {
       cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
       user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
       cust_name = new OrganizeInfo().getCustNameById(cust_id);
    }
    String class_name = new CustClass().cust_Class_Name(cust_id);
    String temp = "";
    if( cust_id != "" || !cust_id.equals( "" ) ) 
    {	
  	  temp = "�𾴵�" + cust_name + "&nbsp;��ӭ����!";
    }
    else if( cust_id == "" || cust_id.equals("") )
    {
       temp = "��ӭ���� -�����й������̵�������ƽ̨";
    }
    out.print(temp);
%>
</span>
</body>
</html>




