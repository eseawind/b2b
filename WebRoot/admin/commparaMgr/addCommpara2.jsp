<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%> 
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
   	String param_attr="",subsys_code="",param_code="";
   	if(request.getParameter("param_attr")!=null){
   		param_attr = request.getParameter("param_attr");
   	}
   	if(request.getParameter("subsys_code")!=null){
   		subsys_code = request.getParameter("subsys_code");
   	}
   	if(request.getParameter("param_code")!=null){
   		param_code = request.getParameter("param_code");
   	}
%>
 <html>
	<head>
		<title>增加参数</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script language="javascript">
			function checkValue(){
				if(document.getElementById('subsys_code').value==''){
						alert('请输入subsys_code!');
						return false;
				}
				if(document.getElementById('param_attr').value==''){
						alert('请输入param_attr!');
						return false;
				}
				if(document.getElementById('param_code').value==''){
						alert('请输入param_code!');
						return false;
				}
				if(document.getElementById('param_name').value==''){
						alert('请输入param_name!');
						return false;
				}
				if(document.getElementById('para_code1').value==''){
						alert('请输入para_code1!');
						return false;
				}
				if(document.getElementById('para_code2').value==''){
						alert('请输入para_code2!');
						return false;
				}
				if(document.getElementById('start_date').value==''){
						alert('请输入start_date!');
						return false;
				}
				if(document.getElementById('end_date').value==''){
						alert('请输入end_date!');
						return false;
				}
			}
		</script>

</head>
	<body onload="createTree()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
				<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>增加参数信息</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
				
				<tr>
					<td>
						<table width=100% border=0 cellpadding=0 cellspacing=1 bgcolor="#dddddd" align="center">	
					
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数所属:								
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=subsys_code type=text value="<%=subsys_code%>" size="30" maxlength="3" readonly><font color="red">*</font>
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数代码:
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=param_attr type=text value="<%=param_attr%>" size="30" readonly><font color="red">*</font>
								</td>
					
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数类型:
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name="param_code" type="text" id="param_code" value="<%=param_code%>" readonly><font color="red">*</font>
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数名称:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=param_name type=text value=""><font color="red">*</font>
								</td>
							</tr>
	
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code1
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code1 type=text value="" size="30"><font color="red">*</font>
								</td>			
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code2								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code2 type=text value="" size="30"><font color="red">*</font>
								</td>			
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code3								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type=text name=para_code3 value="" size="30">
								</td>
					
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数说明:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code4 type=text value="" size="30" >
								</td>
							</tr>
						
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code5:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name="para_code5" id="para_code5" value=""  size="30" maxlength="15">
								</td>
										
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code6:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code6 value=""  size="30" maxlength="15">
								</td>
							</tr>
					 		<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code6:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code6 value=""  size="30" maxlength="40">
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code7:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code7 value=""  size="30" maxlength="30">
								</td>
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code8:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code8 type=text value="" size="30" >
								</td>
						
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code9:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code9 type=text value="" size="30" >
								</td>
					
							</tr>
							
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code10:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type=text name=para_code10 value="" size="30" maxlength="30">
								</td>
							
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code11:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code11 type=text value="" size="30">
								</td>
					
							</tr>
							
							
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code12:							</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type="text" name=para_code12 value="" size = "30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
								para_code13:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type="text" name=para_code13 value="" size="30">
								</td>
						 	</tr>
	
						
							
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code14:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code14 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code15:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code15 type=text value="" size="30" >
								</td>
							</tr>														
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code16:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code16 type=text value="" size="30" >
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code17:</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code17 value="" size = "30">
								</td>
							</tr>		
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code18:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code18 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code19:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code19 type=text value="" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code20:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code20 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code21:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code21 type=text value="" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code22:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code22 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code23:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code23 type=text value="" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code24:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code24 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code25:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code25 type=text value="" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code26:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code26 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code27:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code27 type=text value="" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code28:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code28 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code29:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code29 type=text value="" size="30" >
								</td>
							</tr>
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code30:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code30 type=text value="" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									start_date:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=start_date type=text value="2008-08-08" size="30" onfocus="setday(this);" ><font color="red">*</font>
								</td>
							</tr>	
								<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									end_date:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=end_date type=text value="2050-01-01" size="30" onfocus="setday(this);"><font color="red">*</font>
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									remark:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=remark type=text value="" size="30" >
								</td>
							</tr>						

							<tr>
								<td height="40" colspan="4" bgcolor="#FFFFFF">
									<div align="center">
										<input type="hidden" name="xtype" id="xtype" value="0" />
										<input type="hidden" name="trade_type_code" id="trade_type_code" value="1188" />
										<input class="tjan" type="submit" name="Submit" value="" onclick="return checkValue()">
									</div>
								</td>
							</tr>

					  </table>
					</td>
				</tr>
				<tr>
					<td height="46">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




