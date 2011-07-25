<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/wealthMgr.js">
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align:right;width: 15%}
		 .r_td{background-color:#ffffff; color:#000000;  font-size:12px;width: 85%}
		</style>
		
		<%
			String start_date = "",para_code6="",actiont="";
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			start_date = formate.format(new Date());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 50);
			String end_date = formate.format(cal.getTime());
			String cust_class = "";
			String para_code1 = "",para_code4="";
			if(request.getParameter("code1")!=null){
			  para_code1=request.getParameter("code1");
			}
			if(request.getParameter("code4")!=null){
			  para_code4=request.getParameter("code4");
			  cust_class=comparam.getParamNameByValue("14",para_code4);
			}
			HashMap map=comparam.getCommparamByCode4("B2B","101",para_code1,para_code4);
			String remark="",para_code2="",para_code3="",para_code5="";
			if(map.get("remark")!=null){
			  remark=map.get("remark").toString();
			}
			if(map.get("para_code5")!=null){
			  para_code5=map.get("para_code5").toString();
			}
			if(map.get("para_code2")!=null){
			  para_code2=map.get("para_code2").toString();
			}
			if(map.get("para_code6")!=null){
			  actiont=map.get("para_code6").toString();
			  para_code6=comparam.getParamNameByValue("102",actiont);
			}
			if(map.get("para_code3")!=null){
			  para_code3=map.get("para_code3").toString();
			}
			if(map.get("end_date")!=null){
			  end_date=map.get("end_date").toString();
			  if(end_date.length()>10){
			     end_date=end_date.substring(0,10);
			  }
			}
		   if(map.get("start_date")!=null){
			  start_date=map.get("start_date").toString();
			  if(start_date.length()>10){
			     start_date=start_date.substring(0,10);
			  }
			}
		%>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
					
						<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>�������û�Ա�Ƹ� </b></font></td>
				<td background="/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>

										<table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
											<tr>
												<td class="l_td">
													��Ա������
												</td>
												<td align="left" class="r_td">
													<div>
													 <input type="text" size="25" name="action" value="<%=para_code6%>" readonly>
													<input type="hidden" name="para_code6" id="para_code6" value="<%=actiont%>">
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													��Ա����
												</td>
												<td align="left" class="r_td">
													<div>
													    <input type="text" size="25" name="class_anem" value="<%=cust_class%>" readonly>
														<input type="hidden" name="para_code4" id="para_code4" value=<%=para_code4%>>
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													�����ƽ�����
												</td>
												<td align="left" class="r_td">
													<div>
														<input type="text" name="para_code3" name="para_code3" size="5" maxlength="50" value="<%=para_code3%>" onkeyup="if(isNaN(this.value))this.value=''">
														(��)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													��ʼ���ڣ�
												</td>
												<td align="left" class="r_td">
													<div>
														<input name="start_date" type="text" id="start_date" size=10 maxlength=15 value="<%=start_date%>" onfocus="setday(this);" readonly>
														(yyyy-MM-dd)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													�������ڣ�
												</td>
												<td align="left" class="r_td">
													<div>
														<input name="end_date" type="text" id="end_date" size=10 maxlength=15 value="<%=end_date%>" onfocus="setday(this);" readonly>
														(yyyy-MM-dd)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													��ע��
												</td>
												<td align="left" class="r_td">
													<div class="ping1">
														<input name="remark" type="text" id="remark" size=50 maxlength=100 value="<%=remark%>">
													</div>
												</td>
											</tr>
											<tr>
												<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:center;" align="center" colspan="2">
													<input class="xgan" name="submit" type="submit" value="" onclick="return check_Value()">
												</td>
											</tr>
											<input type="hidden" name="xtype" id="xtype" value="1">
											<input type="hidden" name="param_code" id="param_code" value="action">
											<input type="hidden" name="param_name" id="param_name" value="���û�Ա�Ƹ�">
											<input type="hidden" name="subsys_code" id="subsys_code" value="B2B" />
											<input type="hidden" name="param_attr" id="param_attr" value="101" />
											<input type="hidden" name="para_code1" value="<%=para_code1%>">
											<input type="hidden" name="para_code5" value="<%=para_code5%>">
											<input type="hidden" name="para_code2" value="<%=para_code2%>">
											<input type="hidden" name="para_code7">
											<input type="hidden" name="para_code8">
											<input type="hidden" name="para_code9">
											<input type="hidden" name="para_code10">
											<input type="hidden" name="para_code11">
											<input type="hidden" name="para_code12">
											<input type="hidden" name="para_code13">
											<input type="hidden" name="para_code14">
											<input type="hidden" name="para_code15">
											<input type="hidden" name="para_code16">
											<input type="hidden" name="para_code17">
											<input type="hidden" name="para_code18">
											<input type="hidden" name="para_code19">
											<input type="hidden" name="para_code20">
											<input type="hidden" name="para_code21">
											<input type="hidden" name="para_code22">
											<input type="hidden" name="para_code23">
											<input type="hidden" name="para_code24">
											<input type="hidden" name="para_code25">
											<input type="hidden" name="para_code26">
											<input type="hidden" name="para_code27">
											<input type="hidden" name="para_code28">
											<input type="hidden" name="para_code29">
											<input type="hidden" name="para_code30">
											<input type="hidden" name="trade_type_code" value="1188">
										</table>

	</form>
	</body>
</html>




