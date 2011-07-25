<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
	<head>
		<title>新客户注册</title>
		<link href="/style/login.css" rel="stylesheet" type="text/css">
		<link href="/style/css_layout.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
        .green {float:left;
        border-color: #485E00;
        border-style: solid;
        background-color: #F7FFDD;
        border-width: 1px;
        font-size: 12px;
        color: #485E00;
        font-family: 宋体;
        padding: 3px 3px;
        
        }
        .orange {float:left;
        border-color: #FF7300;
        border-style: solid;
        background-color: #FFF5D8;
        border-width: 1px;
        font-size: 12px;
        color: #000000;
        font-family: 宋体;
        padding: 3px 3px;
        
        }
    </style>
		<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
		<script src="/js/newcregister.js" language="jscript" type="text/jscript"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>
	<body>
		<jsp:include flush="true" page="/zone_b2b/top.html" />
		<center>
			<div id="login-body">
				<div id="lg_content">
					<div  style=" width:100%;" align="center"> 
						<a href="/Newcregister.jsp?class_level=4"><img src="/admin/images/login_yp.gif" border="0"></a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/PerCregister.jsp"><img src="/admin/images/login_gr.gif" border="0"></a> 
					</div>
				</div>
			</div>
			<div class="login_bottom"></div>
			<table>
				<tr>
					<td align="center">
						<div class="bottom_admin">
							<div class="containertow">
								<div class="footer">
									<div class="footer3" style="margin-top:6px">
										<div class="cpy width margin">
											<div class="about">
												<p align="center">
													<a target="_blank" href="http://www.21oil.com/html/bizossxinwen/20080519/18.html">联系我们</a> |
													<a target="_blank" href="http://www.21oil.com/html/bizossxinwen/20080519/22.html">免责声明</a> |
													<a href="javascript:void(0);" onclick="var strHref=window.location.href;this.style.behavior='url(#default#homepage)';if(window.location.href.toLowerCase().indexOf('www.21oil.com') != -1){this.setHomePage('https://www.21oil.com')}else{this.setHomePage('http://www.21oil.com')};">设为首页</a>
													<br>
													<title>B2B电子商务后台管理系统</title>协办 &copy;Copyright 2008 版权所有 ICP证
													<a href="http://www.miibeian.gov.cn/"></a>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>





