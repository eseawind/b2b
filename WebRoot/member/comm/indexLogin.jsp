 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
 
	config configFile = new config();
	configFile.init();

	String checkloginimage = configFile.getString("checkloginimage");
	String showlogin = "none";
    if( checkloginimage.equals("0") )
	{
		showlogin = "block";
	}
 	
%>

		<link rel="stylesheet" type="text/css" href="/templates/wood/style/wood.css" />
        <script language="javascript">
		  function changeCode()
          {
          	 var dt = new Date();
				var randomnum = Math.random();

           document.getElementById("rc").src= "/checkImage"+'?'+randomnum;
          
          }
		  function Check_Value()
		  {
					
				if (document.getElementById("user_name").value == ""||document.getElementById("user_name").value == null)
				{
					alert('用户名不可以为空！');
					document.getElementById("user_name").focus();
					return false;
				}
				if (document.getElementById("passwd").value == ""||document.getElementById("passwd").value == null)
				{
					alert("密码不可以为空！");
					document.getElementById("passwd").focus();
					return false;
				}
				if( document.getElementById("rand").style.display != "none")
				{
					var loguserrand = document.getElementById("indexuserrand").value;
					if( loguserrand == "" )
					{
						alert('验证码不可以为空！');
						document.getElementById("indexuserrand").focus();
						return false;
					}
					document.getElementById( "userrand" ).value=loguserrand;
				}
				 
				//document.loginForm.submit();
			}
		</script>
 
  	  
		<form action="/stafflogin.do" name="loginForm" method="post" target="_parent">                                                                                                  
  		<div id=login_id class=head_right_login style="padding-top:15px">
			<span style="float:left"><font color="#339900">会员登录</font> 用户名:
				<span class="head_right_login" style="padding-top:15px">
				<input type="text" name="user_name2"  id="user_name2" size="8" class="input" onblur="javascript:document.getElementById('user_name').value=this.value;" />
				</span>
		<input type="hidden" name="user_name"  id="user_name" size="8" class="input" /> 
				密码:<input type="password" name="passwd" id="passwd" size="8" class="input"/> 
			</span>
			<span id="rand" style="display:<%=showlogin%>;float:left">&nbsp;
				验证码:
			<input name="indexuserrand" id="indexuserrand" type="text" size="8" maxlength="4" class="input"/> <img src="/checkImage" id="rc" onclick="changeCode()" align="absmiddle">
			</span>
			<span style="float:left;">&nbsp;<input type="hidden" name="userrand"  id="userrand" /> 
				<input type="submit" value="登录" class="login" style="cursor:hand;" onclick="return Check_Value();"/> 
				<input name="trade_type_code"  id="trade_type_code" type="hidden" value=0123> 
				<input name="cookietime"  id="cookietime" type="hidden" value="36000">
			</span>                                                                                                                 
  		</div>																																																																																				
		</form>
 



