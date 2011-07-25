<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page  import="java.util.*"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>

<html>
	<head>
		<title>修改地区</title>
		<%
		   String area_code = "";
		   String parent_area_code ="";
	  	  if (request.getParameter("area_code") != null) {
			   area_code = request.getParameter("area_code");
	    	}
		AreaInfo area = new AreaInfo();
		ArrayList arealist = area.getArea(area_code);
		%>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript">
			function checkValue(){
				if(document.getElementById('area_name').value==''){
						alert('请输入地区名!');
						return false;
				}
			}
	</script>
	</head>
	<body>
		<form name="addBpm" id="addBpm" action="/doTradeReg.do" method="post" target="_self">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
						<%
								HashMap map = (HashMap) arealist.get(0);
								String area_name=map.get("area_name").toString();
								if(map.get("parent_area_code")!=null){
									parent_area_code = map.get("parent_area_code").toString();
								}else{
									parent_area_code = "5J2mc0X0G85BH";
								}
						%>
				<tr>
					<td width="15%" bgcolor="#ffffff">
						<div style=" text-align:right; font-weight:bold;">
						地区名:
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
						<input name="area_name" type="text" id="area_name"  value="<%=area_name%>"   maxlength="20"><font color="red">*</font>
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" >
					<tr>
						<td>
							<center><input class="tjan" type="submit" name="Submit" value="" onclick="return checkValue()" >
								
				&nbsp;&nbsp;&nbsp;
				<img src="/admin/images/comeback.JPG" onClick="location.href='areaMgr.jsp?parent_area_code=<%=parent_area_code%>'" style="cursor:hand;" align="absmiddle"></center>
						</td>
					</tr>
			</table>
				<input type="hidden" name="trade_type_code" id="trade_type_code" value="8890" />
				<input type="hidden" name="area_code" id="area_code" value="<%=area_code%>" />
		</form>
	</body>
</html>



