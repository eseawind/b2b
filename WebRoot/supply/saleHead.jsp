<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="date" class="com.saas.biz.commen.DateFormatByString" scope="page" />
<%
String dateTime=date.getDateTimeNow();
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="23" align="center" background="/images/ba_02.gif">
			<table width="980" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<a onclick="var strHref=window.location.href;this.style.behavior='url(http://www.bizoss.com)';this.setHomePage('http://www.bizoss.com');"  style="cursor:hand">设为首页</a> | <a href="javascript:window.external.AddFavorite('http://www.bizoss.com', '中国建材市场')">把"中国建材市场"加入我的收藏夹</a> | <%=dateTime%>
					</td>
					<td align="right">
						<img src="/images/Max.gif" width="15" height="12" align="absmiddle" />
						金钻会员 | 黄金展位 | 广告服务 | 网站建设 | 建材金币 | 我的商务室 | 竟价排名 | 联系我们 | 客服中心
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td height="70">
			<img src="/admin/images/ba_13.gif" alt="" width="148" height="42" />
		</td>
		<td align="right" valign="bottom">
			<table width="500" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="right">
						<img src="/images/zx0.gif" width="73" height="19" border="0" />
						<img src="/images/hd.gif" width="55" height="19" />
						<a href="/"><img src="/images/ba_06.gif" width="56" height="21" alt="登录" /></a>
						&nbsp;
						<a href="/Newcregister.jsp"><img src="/images/ba_08.gif" width="79" height="21" alt="免费注册" /></a>
						&nbsp;
						<img src="/images/ba_10.gif" width="79" height="21" alt="" />
						&nbsp;
						<img src="/images/mf.gif" width="23" height="12" align="top" />
					</td>
				</tr>
				<tr>
					<td height="36" align="right">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="86">
									<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="DCDCDC">
										<tr>
											<td height="26" align="center" background="/images/Content_03.gif" bgcolor="#FFFFFF">
												<a href="/zone_b2b/supply/" class="cpbt">供应信息</a>
											</td>
										</tr>
									</table>
								</td>
								<td width="6"></td>
								<td width="86">
									<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="DCDCDC">
										<tr>
											<td height="26" align="center" background="/images/Content_03.gif" bgcolor="#FFFFFF">
												<a href="/zone_b2b/stock/" class="cpbt">求购信息</a>
											</td>
										</tr>
									</table>
								</td>
								<td width="6"></td>
								<td width="86">
									<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="DCDCDC">
										<tr>
											<td height="26" align="center" background="/images/Content_03.gif" bgcolor="#FFFFFF">
												<a href="/zone_b2b/enterprise/" class="cpbt">名企展示</a>
											</td>
										</tr>
									</table>
								</td>
								<td width="6"></td>
								<td width="86">
									<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="DCDCDC">
										<tr>
											<td height="26" align="center" background="/images/Content_03.gif" bgcolor="#FFFFFF">
												<a href="/zone_b2b/news/" class="cpbt">行业资讯</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>




