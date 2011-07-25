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

<%request.setCharacterEncoding("GBK");
  String para_code1="",param_attr="",param_code="",param_name="",para_code2="",para_code3="",para_code4="",para_code5="",para_code6="",para_code7="",para_code8="",para_code9="",para_code10="",para_code11="",para_code12="",para_code13="",para_code14="",para_code15="",para_code16="",para_code17="",para_code18="",para_code19="",para_code20="",para_code21="",para_code22="",para_code23="",para_code24="",para_code25="",para_code26="",para_code27="",para_code28="",para_code29="",para_code30="";
String start_date="",end_date="",remark="",subsys_code="";
	
	if(request.getParameter("subsys_code")!=null)
	{
	  subsys_code=request.getParameter("subsys_code");
	}
	if(request.getParameter("param_attr")!=null)
	{
	  param_attr=request.getParameter("param_attr");
	}
	if(request.getParameter("param_code")!=null)
	{
	  param_code=request.getParameter("param_code");
	}
	if(request.getParameter("hongdong2")!=null)
	{
	  para_code2=request.getParameter("hongdong2");
	  para_code2 = new String(para_code2.getBytes("iso-8859-1"),"gbk");
	}
	if(request.getParameter("hongdong")!=null)
	{
	  para_code1=request.getParameter("hongdong");
	}
	if(request.getParameter("Thename")!=null)
	{
	  param_name=request.getParameter("Thename");
	  param_name = new String(param_name.getBytes("iso-8859-1"),"gbk");
	}
	//out.println("subsys_code="+subsys_code+" param_attr="+param_attr+" param_code="+param_code+" para_code2="+para_code2+" para_code1="+para_code1+" param_name="+param_name);
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList alist = new ArrayList();
	alist = paramCom.getComparamListByCodeByALL(subsys_code,param_attr,param_code,para_code2,para_code1,param_name);
	
%>
 <html>
	<head>
		<title>修改参数</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
			<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
	

</head>
	<body onload="createTree()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
						<a href="talenslist2.jsp?param_code=<%=param_code%>">参数管理</a>
				</td>
			</tr>
		</table>
			<table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=0 cellspacing=1 bgcolor="#dddddd" align="center">	
						<% 
						if( alist != null && alist.size() > 0 ){ 
							HashMap map = (HashMap)alist.get(0);
							if(map.get("subsys_code")!=null)
							{
								subsys_code = map.get("subsys_code").toString();		
							}
							if(map.get("param_attr")!=null)
							{
								param_attr = map.get("param_attr").toString();		
							}
							if(map.get("param_code")!=null)
							{
								param_code = map.get("param_code").toString();		
							}
							if(map.get("param_name")!=null)
							{
								param_name = map.get("param_name").toString();		
							}
							if(map.get("para_code1")!=null)
							{
								para_code1 = map.get("para_code1").toString();		
							}
							if(map.get("para_code2")!=null)
							{
								para_code2 = map.get("para_code2").toString();		
							}
							if(map.get("para_code3")!=null)
							{
								para_code3 = map.get("para_code3").toString();		
							}
							if(map.get("para_code4")!=null)
							{
								para_code4 = map.get("para_code4").toString();		
							}
							if(map.get("para_code5")!=null)
							{
								para_code5 = map.get("para_code5").toString();		
							}
							if(map.get("para_code6")!=null)
							{
								para_code6= map.get("para_code6").toString();		
							}
							if(map.get("para_code7")!=null)
							{
								para_code7= map.get("para_code7").toString();		
							}
							if(map.get("para_code8")!=null)
							{
								para_code8 = map.get("para_code8").toString();		
							}
							if(map.get("para_code9")!=null)
							{
								para_code9 = map.get("para_code9").toString();		
							}
							if(map.get("para_code10")!=null)
							{
								para_code10 = map.get("para_code10").toString();		
							}
							if(map.get("para_code11")!=null)
							{
								para_code11 = map.get("para_code11").toString();		
							}
							if(map.get("para_code12")!=null)
							{
								para_code12 = map.get("para_code12").toString();		
							}
							
							if(map.get("para_code13")!=null)
							{
								para_code13 = map.get("para_code13").toString();		
							}
							if(map.get("para_code14")!=null)
							{
								para_code14 = map.get("para_code14").toString();		
							}
							if(map.get("para_code15")!=null)
							{
								para_code15 = map.get("para_code15").toString();		
							}
							if(map.get("para_code16")!=null)
							{
								para_code16 = map.get("para_code16").toString();		
							}
							if(map.get("para_code17")!=null)
							{
								para_code17= map.get("para_code17").toString();		
							}
							if(map.get("para_code18")!=null)
							{
								para_code18 = map.get("para_code18").toString();		
							}
							if(map.get("para_code19")!=null)
							{
								para_code19 = map.get("para_code19").toString();		
							}
							if(map.get("para_code20")!=null)
							{
								para_code21 = map.get("para_code22").toString();		
							}
							if(map.get("para_code23")!=null)
							{
								para_code23 = map.get("para_code23").toString();		
							}
							if(map.get("para_code24")!=null)
							{
								para_code24 = map.get("para_code24").toString();		
							}
							if(map.get("para_code25")!=null)
							{
								para_code25 = map.get("para_code25").toString();		
							}
							if(map.get("para_code26")!=null)
							{
								para_code26 = map.get("para_code26").toString();		
							}
							if(map.get("para_code27")!=null)
							{
								para_code27 = map.get("para_code27").toString();		
							}
							if(map.get("para_code28")!=null)
							{
								para_code28 = map.get("para_code28").toString();		
							}
							if(map.get("para_code29")!=null)
							{
								para_code29 = map.get("para_code29").toString();		
							}
							if(map.get("para_code30")!=null)
							{
								para_code30 = map.get("para_code30").toString();		
							}
							if(map.get("start_date")!=null)
							{
								start_date = map.get("start_date").toString();
								start_date=	start_date.substring(0,10);	
							}
							if(map.get("end_date")!=null)
							{
								end_date = map.get("end_date").toString();		
							end_date=end_date.substring(0,10);
							}
							if(map.get("remark")!=null)
							{
								remark = map.get("remark").toString();		
							}
							%>
										 
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数所属:								
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=subsys_code type=text value="<%=subsys_code%>" size="30"  readonly>
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数代码:
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=param_attr type=text value="<%=param_attr%>" size="30" readonly>
								</td>
					
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数类型:
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name="param_code" type="text" id="param_code" value="<%=param_code%>" readonly>
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数名称:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=param_name type=text value=<%=param_name%> readonly>
								</td>
							</tr>
	
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code1:
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code1 type=text value="<%=para_code1%>" size="30" readonly>
								</td>			
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code2:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code2 type=text value="<%=para_code2%>" size="30">
								</td>			
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code3:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type=text name=para_code3
										value="<%=para_code3%>">
								</td>
					
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									参数说明:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code4 type=text value="<%=para_code4%>" size="30" >
								</td>
							</tr>
						
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code5:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name="para_code5" id="para_code5" value="<%=para_code5%>"  size="30" maxlength="15">
								</td>
										
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code6:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code6 value="<%=para_code6%>"  size="30" maxlength="15">
								</td>
							</tr>
					 		<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code6:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code6 value="<%=para_code6%>"  size="30" maxlength="40">
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code7:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code7 value="<%=para_code7%>"  size="10" maxlength="6">
								</td>
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code8:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code8 type=text value="<%=para_code8%>" size="30" >
								</td>
						
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code9:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code9 type=text value="<%=para_code9%>" size="30" >
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
									<input type=text name=para_code10 value="<%=para_code10%>" size="12" maxlength="12">
								</td>
							
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code11:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code11 type=text value="<%=para_code11%>" size="30">
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
									<input type="text" name=para_code12 value="<%=para_code12%>">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
								para_code13:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type="text" name=para_code13 value="<%=para_code13%>">
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
									<input name=para_code14 type=text value="<%=para_code14%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code15:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code15 type=text value="<%=para_code15%>" size="30" >
								</td>
							</tr>														
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code16:								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=para_code16 type=text value="<%=para_code16%>" size="30" >
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code17:</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=para_code17 value="<%=para_code17%>">
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
									<input name=para_code18 type=text value="<%=para_code18%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code19:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code19 type=text value="<%=para_code19%>" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code20:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code20 type=text value="<%=para_code20%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code21:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code21 type=text value="<%=para_code21%>" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code22:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code22 type=text value="<%=para_code22%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code23:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code23 type=text value="<%=para_code23%>" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code24:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code24 type=text value="<%=para_code24%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code25:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code25 type=text value="<%=para_code25%>" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code26:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code26 type=text value="<%=para_code26%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code27:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code27 type=text value="<%=para_code27%>" size="30" >
								</td>
							</tr><tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code28:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code28 type=text value="<%=para_code28%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									para_code29:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=para_code29 type=text value="<%=para_code29%>" size="30" >
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
									<input name=para_code30 type=text value="<%=para_code30%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									start_date:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=start_date type=text value="<%=start_date%>" size="30" >
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
									<input name=end_date type=text value="<%=end_date%>" size="30">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									remark:								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=remark type=text value="<%=remark%>" size="30" >
								</td>
							</tr>						
							<tr>
								<td height="40" colspan="4" bgcolor="#FFFFFF">
									<div align="center">
										<input type="hidden" name="xtype" id="xtype" value="1" />
										<input type="hidden" name="trade_type_code" id="trade_type_code" value="1188" />
										<input class="tjan" type="submit" name="Submit" value="">&nbsp;&nbsp;&nbsp;
										<img src="/admin/images/comeback.JPG" onClick="location.href='talenslist2.jsp?param_code=<%=param_code%>'" style="cursor:hand;" align="absmiddle">
									</div>
								</td>
							</tr>
							<%
							  }
							%>
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




