<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.*"%>
<%@ page import="com.saas.biz.shoppingcartMgr.*"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>中国建材市场B2C平台</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<link href="/zone_b2b/css/b2c.css" rel="stylesheet" type="text/css" />
		<link href="/style/b2c_css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include flush="true" page="/supply/order/top.jsp"></jsp:include>
		<table cellspacing="0" cellpadding="0" width="970" align="center"
			border="0">
			<tr>
				<td class="gome_bg_07" valign="top">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td style="PADDING-RIGHT: 42px; PADDING-LEFT: 42px" valign="top"
								height="300">
								<table cellspacing="1" cellpadding="0" width="100%" border="0">
									<tr>
										<td valign="bottom" width="176" height="76">
											<img height="33" alt="" width="176"
												src="/images/car_img2_01.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176"
												src="/images/car_img_02.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176"
												src="/images/car_img_03.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176"
												src="/images/car_img_04.gif" />
										</td>
										<td valign="bottom">
											<img height="33" alt="" width="176"
												src="/images/car_img_05.gif" />
										</td>
									</tr>
								</table>
								<table align="center">
									<tr>
										<td>
											<a onclick=javascript:window.close(); href="#">								
											<img height=29 src="/images/z_img10.gif" width=104 border=0>
											</A>
										</td>
										<td>
											<a href="/supply/shopping_carts.jsp">查看购物车</a>
										</td>
									</tr>
								</table>
								<br />
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<jsp:include flush="true" page="/supply/order/footer.jsp"></jsp:include>
	</body>
</html>




