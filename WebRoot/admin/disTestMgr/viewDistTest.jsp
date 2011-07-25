<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.disTestMgr.DisTestInfo"%>

<%@ page contentType="text/html;charset=GBK"%>



<html>

<head>

<title>bizoss-评测管理 </title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>

<style type="text/css">
	.bord{
		border-style: none;
	}
</style>
</head>

<body>

<%
    String dis_test_id="",test_cust_name="",product_name="",contact_type="",in_date="",test_request="",publish_date="";

    if (request.getParameter("dis_test_id") != null){
        dis_test_id = request.getParameter("dis_test_id");
    }
	 DisTestInfo disInfo = new DisTestInfo();
	 ArrayList disList = new ArrayList();
	 disList = disInfo.getOneDisTestById(dis_test_id);
	 if(disList != null && disList.size()>0){
      HashMap map = (HashMap)disList.get(0);
      if(map.get("test_cust_name")!=null){
       test_cust_name=map.get("test_cust_name").toString();
      }
      if(map.get("product_name")!=null){
       product_name=map.get("product_name").toString();
      }
      if(map.get("contact_type")!=null){
       contact_type=map.get("contact_type").toString();
      }
      if(map.get("in_date")!=null){
       in_date=map.get("in_date").toString().substring(0,10);
      }
      if(map.get("test_request")!=null){
       test_request=map.get("test_request").toString();
      }
      if(map.get("publish_date")!=null){
       publish_date=map.get("publish_date").toString();
      }
    }
   
%>
<center>
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="50"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>评测查看</b></font></td>
				<td background="/admin/images/content_04.gif">&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
  </table>
	 <table width="800" border="0" cellspacing="1" cellpadding="1" bgcolor="#dddddd">
        <tr>
          	<td class="u1">
          		<div class="ping1">
          		申请评测客户名称:
          	</div>
          	</td>
          	<td width="80%" align="left" bgcolor="white" colspan="3">
            		<%=test_cust_name%>
            </td>
        </tr>
        <tr>
          	<td class="u1" width="15%"><div class="ping1">评测产品名称:<div></td>
          	<td align="left" bgcolor="white" width="35%"><%=product_name%></td>
          		<td class="u1" width="15%"><div class="ping1">联系方式:<div></td>
          	<td  align="left" bgcolor="white" width="35%"><%=contact_type%></td>
        </tr>
        <tr>
          	<td class="u1"><div class="ping1">申请测试时间:<div></td>
          	<td  align="left" bgcolor="white" colspan="3"><%=in_date%></td>
          	
        </tr>
        <tr>
        	<td class="u1"><div class="ping1">具体评测要求:<div></td>
          	<td  align="left" bgcolor="white" colspan="3"><%=test_request%></td>
        	
        	</tr>
        <tr >
				  <td align="center" colspan="4" bgcolor="white" height="50">
				  	<input type="submit" name="submit" class="gban" value="" onclick="javascript:window.open('','_self','');window.close();">
				  </td>
			  </tr>
  </table>
</center>
</body>
</html>



