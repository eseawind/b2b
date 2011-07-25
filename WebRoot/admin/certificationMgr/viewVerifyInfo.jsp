<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="custObj" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<%
	String verify_id = "";
	String req_desc = "";
	String remark = "";
	String verify_type = "", cust_id = "";
	if (request.getParameter("verify_id") != null) {
		verify_id = request.getParameter("verify_id");
	}
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String req_date = date;
	String verify_name = "";
	VerifyInfo adverObj = new VerifyInfo();
	ArrayList advertList = adverObj.genOneVerify(verify_id);
	if (advertList != null && advertList.size() > 0) {
		HashMap map = (HashMap) advertList.get(0);
		if (map.get("req_desc") != null) {
			req_desc = map.get("req_desc").toString();
		}
		if (map.get("cust_id") != null) {
			cust_id = map.get("cust_id").toString();
		}
		if (map.get("remark") != null) {
			remark = map.get("remark").toString();
		}
		if (map.get("verify_type") != null) {
			verify_type = map.get("verify_type").toString();
			verify_type = param.getParamNameByValue("100", verify_type);
		}
		if (map.get("verify_name") != null) {
			verify_name = map.get("verify_name").toString();
		}
		if (map.get("req_date") != null) {
			req_date = map.get("req_date").toString();
			if (req_date.length() > 10) {
		req_date = req_date.substring(0, 10);
			}
		}
	}
	String cust_name=custObj.getCustNameById(cust_id);
%>

<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		
		<style type="text/css">
		 form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*������ʽ6---- ͷ������1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*������ʽ1*/
		</style>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		   function checkValue(){
		    if(window.confirm("ȷ��Ҫ�ύ��ִ�еĲ�����")){
		      return true;
		    }else{
		      return false;
		    }
		   }
		 </script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center"><font size="2"><b>�鿴������֤��ϸ��Ϣ</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
					
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width=800 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#e7e7e7">
				<tr>
					<td class="u1">
						��֤���ͣ�
					</td>
					<td  align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_type%>
						</div>
					</td>
					<td class="u1">
						��֤֤����
					</td>
					<td  align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_name%>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						����ͻ���
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
						 <a href="/customerMgr/Custinfo.jsp?obj_cust_id=<%=cust_id%>&user_id=" TARGET=appwin onclick="mydefss()"><%=cust_name%></a>
						</div>
					</td>
					<td class="u1">
						����ԭ�ɣ�
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<bean:define id="des" value="<%=req_desc%>" />
							<bean:write name="des" filter="false" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						����ʱ�䣺
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
						<div class="ping1">
							<%=req_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						��ע��
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
						<div class="ping1">
							<%=remark%>
						</div>
					</td>
				</tr>
				<tr bgcolor="white">
					<td colspan="4" align="center"><img src="/admin/images/gb.gif" onclick="javascript:history.go(-1)" style="cursor:hand"></td>
				</tr>
			</table>
		</form>
	</body>
</html>


