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

<title>bizoss-������� </title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
<script language="javascript"  src="/js/Calendar_Ly.js"></script>
<script language="javascript">
	function checkSub(){
		if(document.getElementById('test_cust_name').value=='' || document.getElementById('test_cust_name').value==null){
			alert('��������������ͻ�����!');
			return false;
		}
		if(document.getElementById('product_name').value=='' || document.getElementById('product_name').value==null){
			alert('�����������Ʒ����!');
			return false;
		}
		if(document.getElementById('contact_type').value=='' || document.getElementById('contact_type').value==null){
			alert('��������ϵ��ʽ!');
			return false;
		}
		if(document.getElementById('in_date').value=='' || document.getElementById('in_date').value==null){
			alert('��ѡ���������ʱ��!');
			return false;
		}
		if(document.getElementById('test_request').value=='' || document.getElementById('test_request').value==null){
			alert('�������������Ҫ��!');
			return false;
		}
	}
</script>
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
	<form action="/doTradeReg.do" method="post" name="updateTestForm" target="_self">
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="50"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>�������</b></font></td>
				<td background="/admin/images/content_04.gif">&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
  </table>
	 <table width="800" border="0" cellspacing="1" cellpadding="1" bgcolor="#dddddd">
        <tr>
          	<td class="u1">
          		 ��������ͻ�����:
          	</td>
          	<td  align="left" bgcolor="white">
            		<input type="text" name="test_cust_name" id="test_cust_name" value="<%=test_cust_name%>">  
            </td>
            	<td class="u1">�����Ʒ����:</td>
            	<td  align="left"bgcolor="white"><input type="text" name="product_name" id="product_name" value="<%=product_name%>"></td>
  
        </tr>
        <tr>
          	<td class="u1">��ϵ��ʽ:</td>
          	<td   align="left" bgcolor="white"><input type="text" name="contact_type" id="contact_type" value="<%=contact_type%>"></td>
        <td class="u1">�������ʱ��:</td>
                 	<td   align="left" bgcolor="white"><input type="text" name="in_date" id="in_date" value="<%=in_date%>" onfocus="setday(this)";></td>

        </tr>      
        <tr>
          	<td class="u1">��������Ҫ��:</td>
          	<td  align="left" bgcolor="white"colspan="3"><textarea name="test_request" id="test_request" cols="51" rows="5"><%=test_request%></textarea></td>
        </tr>
        <tr >
				  <td  colspan="4" bgcolor="white" height="50">
				  	<input type="hidden" name="trade_type_code" id="trade_type_code" value="6664">
				  	<input type="hidden" name="dis_test_id" id="dis_test_id" value="<%=dis_test_id%>">
				  	<input type="hidden" name="publish_date" id="publish_date" value="<%=publish_date%>">
				  	<input type="submit" name="submit" class="xgan" value="" onclick="return checkSub()">
				  </td>
			  </tr>
  </table>
</form>
</center>
</body>
</html>



