  
 
	function openReg(){
		window.open('/member/Newcregister.html');
	}
	
  document.write("<div id=out>                                                                                                                                             ");
	document.write("<div id=top>                                                                                                                                              ");
	document.write("<div class=width>																																																																					");
	document.write("<div class=left><a href=javascript:window.external.AddFavorite(top.location.href)>添加到收藏夹</a></div>                                                  ");
	document.write("<div class=right><a href=/member/mainMenu/default.jsp>我的会员中心</a> |<a href=#>帮助</a></div>                                                           ");
  document.write("</div>                                                                                                                                                      ");
  document.write("</div>                                                                                                                                                       ");
  document.write("<div id=head>                                                                                                                                                   ");
  document.write("<div class=logo><a href=/><img src=/templates/wood/images/logo.gif border=0 /></a> 最具商业价值的木业平台</div>                        ");
  document.write("<div class=head_right>                                                                                                                                            ");
  document.write("<div class=head_right_button> <span class=button><a href=/member/Newcregister.html?class_level=4>免费注册</a></span> <span class=button><a href=/member/index.html>发布信息</a></span> <span class=button><a href=/wood/enterprise/>商铺直达</a></span> <span class=button><a href=/wood/product/>产品中心</a></span><div id=out_sys style=display:none;><span class=button><a href=/member/out.jsp>退&nbsp;&nbsp;出</a></span></div></div>");
  document.write("<form action=/stafflogin.do name=loginForm method=post >                                                                                                              ");
  document.write("<div id=login_id class=head_right_login valign=top>用户名:                                                                              ");
  document.write("<input type=text name=user_name  id=user_name size=8/>                                                                                                    ");
  document.write("密码:                                                                                                                                                                     ");
  document.write("<input type=password name=passwd id=passwd size=8 style=height:15px;/>");
  document.write("<span id=checkImage>验证码:<input type=text name=userrand  id=userrand size=4/> <img src=/checkImage id=rc onClick=changeCode()/></span>                                                                                                   ");
  document.write("<input type=submit value=登录 class=login style=cursor:hand; onclick=\'return Check_Value();\'/>                                                                            ");
  document.write("<input name=trade_type_code  id=trade_type_code type=hidden value=0123>                                                                                                      ");
  document.write("<input name=cookietime  id=cookietime type=hidden value=36000>                                                                                                                ");
  document.write("</div>																																																																																				");
  document.write("</form>																																																																																				");
  document.write("</div>																																																																																				");
  document.write("</div>																																																																																					");
  document.write("</div>																																																																																					");