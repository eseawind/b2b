<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.acctMgr.CustAccount"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />

<html>
	<head>
		<title>系统开关</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<%
			ArrayList commList = comm.getCompareInfoByAttr("115");
			String para_code1="";
			if(commList!=null && commList.size()>0){
				HashMap commMap = (HashMap)commList.get(0);
				if(commMap.get("para_code1")!=null){
					para_code1=commMap.get("para_code1").toString();
				}
			}
			String para_code2="";
			if(para_code1.equals("1")){
				para_code2="<font color=green><b>开</b></font>";
			}else{
				para_code2="<font color=red><b>关</b></font>";
			}
			String value="";
			if(para_code1.equals("1")){
				value="关";
			}else{
				value="开";		
			}
			
		%>
		<center>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
				<!--table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
							<td height="50"> 
							</td>
					</tr>
				  <tr>
						<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>在线支付开关</b></font></td>
						<td background="/admin/images/content_04.gif">&nbsp;</td>
						<td width="8"><img src="/admin/images/content_06.gif"></td>
				  </tr>
		  	</table-->
		  	<form action="/doTradeReg" method="post" name="switchForm" id="switchForm" target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td class="u1" width="30%">
									支付开关：
								</td>
								<td class="u2">
									<table cellpadding="u5" cellpadding="1" cellspacing="1">
										<tr class="u6">
											<td ><b>当前状态</b></td>
											<td width="60" align="center">
													<b>操作</b>
											</td>
									  </tr>
									  <tr class="u6">
											<td align="center"><%=para_code2%></td>
											<td align="center">
													<input type="hidden" name="trade_type_code" id="trade_type_code" value="3256">
													<input type="hidden" name="param_attr" id="param_attr" value="115">
													<input type="hidden" name="para_code1" id="para_code1" value="<%=para_code1%>">
													<input type="submit" name="submit" value="<%=value%>">
											</td>
									  </tr>
									</table>		
								</td>
							</tr>
							
						</table>
						 
						
					</td>
				</tr>
			</table>
		</form>
		</center>
	</body>
</html>





