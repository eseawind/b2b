 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.config"%>
<%

	String n="",p="";
	if( request.getParameter( "n" ) != null )
	{
		n = request.getParameter( "n" ); 
	}
	if( request.getParameter( "p" ) != null )
	{
		p = request.getParameter( "p" ); 
	}		 
	config configFile = new config();
	configFile.init();
	String checkregimage = configFile.getString("checkregimage");
	String showEnd = "none";
	if( checkregimage.equals("1") )
	{
		showEnd = "block";
	}
	String checkloginimage = configFile.getString("checkloginimage");
	String showlogin = "none";
    if( checkloginimage.equals("1") )
	{
		showlogin = "block";
	}
 
	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Registration</title>
		<link rel="stylesheet" type="text/css"  href="/style/b2_blogin.css"/>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/login.css" />
		<style type="text/css">
		<!--
		.buttoon{ 
            	width:148px;
            	height:32px;
            	text-align:center;
            	border:0px;
            	background:url(/images/login/signin_06.gif) left top no-repeat;}
			-->
		</style>
        <script language="javascript">
		function changeCode()
          {
          	 var dt = new Date();
				var randomnum = Math.random();

           document.getElementById("rc").src= "/checkImage"+'?'+randomnum;
          
          }
		 function submited()
		{
			if (document.getElementById("user_name").value == "" || document.getElementById("user_name").value == "��Ա��/����" )
			{
				alert('�û���������Ϊ�գ�');
				document.getElementById("user_name").focus();
				return false;
			}
			if (document.getElementById("passwd").value == "" || document.getElementById("passwd").value == null)
			{
				alert("���벻����Ϊ�գ�");
				document.getElementById("passwd").focus();
				return false;
			}
			if( document.getElementById("loginrand").style.display != "none")
			{
				var loguserrand = document.getElementById("loguserrand").value;
				if( loguserrand == "" )
				{
					alert('��֤�벻����Ϊ�գ�');
					document.getElementById("loguserrand").focus();
					return false;
				}
				document.getElementById( "userrand" ).value=loguserrand;
			}	
			
			document.loginForm.submit();
			 
		}
		
		function submiting()
		{
			if( window.event.keyCode == 13 )
			{
				if( document.getElementById("loginrand").style.display != "none" )
				{
					var loguserrand = document.getElementById( "loguserrand" ).value; 
					document.getElementById( "userrand" ).value=loguserrand;
					document.loginForm.submit();
				}
				 
			}
		}
		</script>
	</head>
<body>
<%
	if( n.equals("1"))
	{
%>
	<table id="reg" width="90%" align="center" border="0" cellspacing="0" cellpadding="0" style="display:<%=showEnd%>;">
	 <tr>
		<td align="right" width="18%" height="40" class="t">��֤�룺<font color="#ff0000" style="font-size:14px; font-weight:500;">*</font></td>
		<td align="left">
			<input type="text" id="reguserrand" name="reguserrand"  size="4" class="login_input0"  maxlength="4"/> <img src="/checkImage" id="rc" name="rc"  align="absmiddle"> <input type="button"  name="refreshmap"  style="border:1px solid #666; line-height:20px; height:20px;" value="�����壬��һ��" onClick="changeCode()"/>
		</td>
	</tr>
	</table>
<%
	}
	else if( n.equals("2") )
	{
%>	 	<form action="/stafflogin.do" name="loginForm" method="post" target="_parent">
			<table cellspacing=3 cellpadding=2 width="100%" align=center border=0>
				<tbody>
				  <tr>
					<td class=M width="35%">��Ա��¼����</td>
					<td width="35%" align="left">
					<input name="user_name" id="user_name" type="text" class="box_cs0" maxlength=25 size=17 value="��Ա��/����" onmousedown="javascript:this.value=''"  style="color:#666;" />			                    </td>
					<td class=S></td>
				  </tr>
				  <tr>
					<td class=M>�ܡ������룺</td>
					<td width="35%" align="left"><input maxlength=30 size=19 name="passwd" id="passwd" type="password"/></td>
					<td class=S></td>
				  </tr>
				  </tbody>
			</table>
			<table id="loginrand"  style="display:<%=showlogin%>;">
				<tr>
					<td class=M width="35%">��&nbsp;&nbsp;֤&nbsp;&nbsp;�룺</td>
					<td width="35%" align="left">
						<input name="loguserrand" id="loguserrand" type="text" size="8"  maxlength="4" class="input" onKeyDown="submiting()"/>&nbsp;&nbsp;&nbsp;
						<img src="/checkImage" id="rc" onClick="changeCode()" align="absmiddle"/>
					</td>     
					<td class=S></td>           
				</tr>
			</table>	
			<table cellspacing=3 cellpadding=2 width="100%" align=center border=0>
				<tr>
					<td class=M width="33%">��&nbsp;ס&nbsp;��¼��</td>
					<td align="left"><select name="cookietime" id="cookietime">
						<option value="315360000">����</option>
						<option value="315360000">һ��</option>
						<option value="2592000">һ����</option>
						<option value="86400">һ��</option>
						<option value="3600">һСʱ</option>
						<option value="0">���������</option>
					  </select>
					</td>
				</tr> 
					<input name="trade_type_code"  id="trade_type_code" type="hidden" value="0123">
					<input name="userrand" id="userrand" type="hidden"/>
				<tr>
					 <td align="center" colspan="2" height="23" valign="bottom">
                     <input type="button" class="buttoon" value=""  onclick="submited()" onmouseover="hand()" name="bout" style="cursor:hand;"/>&nbsp;&nbsp;</td>
				</tr>
			 </table>
		 </form>  		    
<%	
	}
 
%>
	 
	 	
	 
</body>
</html>



