<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String cust_class = bean.getSelectItems("14");
	String right_code = bean.getSelectItems("41");
	String limit_type = bean.getSelectItems("106");
%>
<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		 function check_Value(){
		 	if (document.resumeForm.cust_class.value == ""||document.resumeForm.cust_class.value == null)
			{
				alert("�ͻ����𲻿���Ϊ�գ�");
				document.resumeForm.cust_class.focus(); 
				return false;
			}
		/*	if (document.resumeForm.right_code.value == ""||document.resumeForm.right_code.value == null)
			{
				alert("Ȩ�޴��벻����Ϊ�գ�");
				document.resumeForm.right_code.focus(); 
				return false;
			}*/
			if (document.resumeForm.limit_type.value == ""||document.resumeForm.limit_type.value == null)
			{
				alert("�޶����Ͳ�����Ϊ�գ�");
				document.resumeForm.limit_type.focus(); 
				return false;
			}
			if (document.resumeForm.limit_value.value.replace(/\s*/g,"") == ""||document.resumeForm.limit_value.value.replace(/\s*/g,"") == null)
			{
				alert("�޶�ֵ������Ϊ�գ�");
				document.resumeForm.limit_value.focus(); 
				return false;
			}
			return true;
		  }
		</script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center"><font size="2"><b>��Ա����������Ϣ</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->

						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td class="u1">
									�ͻ�����
								</td>
								<td class="u2" colspan="3">
									<div>
										<select name="cust_class" id="cust_class">
											<option value="">
												��ѡ��...
											</option>
											<%=cust_class%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1"  style="display:none">
									Ȩ�޴��룺
								</td>
								<td class="u2" style="display:none">
									<div>
										<!--select name="right_code" id="right_code">
											<option value="">
												��ѡ��...
											</option>
											<%=right_code%>
										</select-->
									</div>
								</td>
								<td class="u1">
									�޶����ͣ�
								</td>
									<td class="u2" colspan="3">
									<div>
										<select name="limit_type" id="limit_type">
											<option value="">
												��ѡ��...
											</option>
											<%=limit_type%>
										</select>
									</div>
								</td>
							</tr>							
							<tr>
								<td class="u1">
									�޶�ֵ��
								</td>
								<td class="u2" colspan="3">
									<div>
										  <input type="text" name="limit_value" id="limit_value" maxlength="10" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
								<td class="u1"  style="display:none">
									�Ƿ���Ч��
								</td>
								<td class="u2" style="display:none">
									<div class="ping1">
										
										<!--select name="enable_tag" id="enable_tag">
											<option value="0">
												��Ч
											</option>
											<option value="1">
												��Ч
											</option>
										</select-->
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									��ע��
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<input type="text" name="remark" id="remark" maxlength="50" size="52">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="4">
									<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
									<input type="hidden" name="right_code" value="B2B">  
									<input type="hidden" name="enable_tag" value="0">
									<input type="hidden" name="update_staff_id" id="update_staff_id" value="">
									<input type="hidden" name="update_depart_id" id="update_depart_id" value="">
									<input type="hidden" name="update_time" id="update_time" value="">
									<input type="hidden" name="trade_type_code" value="1203">
								</td>
							</tr>
						</table>
		</form>
	</body>
</html>



