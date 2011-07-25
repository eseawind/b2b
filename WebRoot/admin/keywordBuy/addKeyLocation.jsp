<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
 
<%
	String top_menu_id="";
	if(request.getParameter("menu_id")!=null){
		top_menu_id = request.getParameter("menu_id");
	}
	
 
	
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>关键字价格设置</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='/dwr/interface/KeyPriceInfo.js'></script>
		<script type='text/javascript' src='/dwr/interface/ParamethodMgr.js'></script>
		<script type='text/javascript' src='/dwr/engine.js'></script>
		<script type='text/javascript' src='/dwr/util.js'></script>
		<script language="javascript">
			function Check_Value()
			{
				if( document.form.key_location.value == "" )
				{
					alert( "关键字位置不能为空！" );
					return false;
				}
				if( document.form.key_price.value == "" )
				{
					alert( "关键字位价格不能为空！" );
					return false;
				}
				
				
			}
			
			
			function checkKeyLocationExists( name )
			{
				var div=document.getElementById("divname");
				var klocation = name.replace(/\s*/g,"");
				if( klocation == "" || klocation == null )
				{
					div.innerHTML = "<--请输入关键字位置!";
					document.getElementById("key_location").focus();
				}
				else
				{
					div.innerHTML = "";
					KeyPriceInfo.getKeyPriceList( klocation,function( result ) 
					{
						if( result == "" || result == null )
						{
							div.innerHTML = "&nbsp;填写正确，并且可以使用!";
						}
						else
						{ 
							div.innerHTML = "<--关键字位已存在，请重新写填写！";
							document.getElementById("key_location").focus();
						}
					});
				 }
			}
		</script>
		
	</head>
	<body>
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
		 	<tr>
				<td height="80"></td>
			</tr>	
		 </table>
	 
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<form name="form" action="/doTradeReg.do" method="post">
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr height="25">
							<td class="u1" align="center" width="22%">关键字位置</td>
							<td class="u2" align="center" width="78%">
								<input type="text" name="key_location" id="key_location" size="8" onkeyup="if(isNaN(value))execCommand('undo')" onblur="checkKeyLocationExists(this.value)" value="" />
								&nbsp;*&nbsp;<span id="divname">(请输入0-9之间的数字或组合)</span>
							</td>
						</tr>
						<tr>
							<td class="u1" align="center" width="22%">设置价格</td>
							<td class="u2" align="center" width="78%">
								<input type="text" name="key_price" id="key_price" size="8" value="" onkeyup="if(isNaN(value))execCommand('undo')" />&nbsp;元
							</td> 
						</tr>
						<tr>
							<td class="u1" align="center" width="22%">备注</td>
							<td class="u2" align="center" width="78%">
								<textarea name="remark" id="remark" rows="6" cols="25"></textarea>						  </td> 
						</tr>
						<input type="hidden" name="trade_type_code" id="trade_type_code" value="1323" />
						<tr>
							<td class="u6" colspan="6">
								 <input type="submit" name="submit" value="提  交" onclick="return Check_Value()"/>	
									&nbsp;&nbsp;&nbsp;	
								 <input type="button" name="button" value="返  回" onClick="location.href='locationPricing.jsp'"/>	 
							</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>




