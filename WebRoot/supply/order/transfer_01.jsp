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
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="38">&nbsp;首页 &gt; 购物车管理 &gt; 我的购物车</td>
          </tr>
        </table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0" height="37">
          <tr>
            <td class="gw_dh" valign="top"><table width="980" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="28" width="115" align="center"><span style=" font-size:14px; font-weight:bold; color:#fff;">购物车(1)</span></td>
                  <td width="180" align="center"><span style=" font-size:14px; font-weight:bold;">收藏夹</span>（商品0/店铺0）</td>
                  <td width="180" align="center"><span style=" font-size:14px; font-weight:bold;">订单</span>（未付款/待确认）</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
            </table></td>
          </tr>
        </table>
		<table cellspacing="0" cellpadding="0" width="980" align="center"
			border="0">
			<tr>
				<td class="gome_bg_07" valign="top">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td valign="top"
								height="300"><table cellspacing="1" cellpadding="0" width="100%" border="0">
                              <tr>
                                <td valign="bottom" width="195" height="50"><img height="33" alt="" width="195" src="/images/car_img2_01_0.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_02.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_03.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_04_0.gif" /></td>
                                <td valign="bottom"><img height="33" alt="" width="195" src="/images/car_img_05_01.gif" /></td>
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




