<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.biddingMgr.Biddinginfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	String bidding_id = "", title = "", content = "";
	if (request.getParameter("bidding_id") != null) {
		bidding_id = request.getParameter("bidding_id");
		Biddinginfo bidingObj = new Biddinginfo();
		ArrayList bindList = bidingObj.genPKBidding(bidding_id);
		if (bindList != null && bindList.size() > 0) {
			HashMap map = (HashMap) bindList.get(0);
			if (map.get("title") != null) {
				title = map.get("title").toString();
			}
			if (map.get("content") != null) {
				content = map.get("content").toString();
			}
		}
	}
%>
<html>
	<head>
		<title>中标公告</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/calendar.js"></script>
		<script type="text/javascript" src="/js/certificationMgr.js"></script>
		<script language="javascript">
  var cdr = new Calendar("cdr");
  document.write(cdr);
  cdr.showMoreDay = true;
</script>
	</head>
	<body>
		<table width="818" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td height="26" background="/img/bg-1.gif">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td background="/img/bg-2.gif">
					<form name=bidForm action=/doTradeReg.do method=post>
						<table width=93% border=0 cellpadding=5 cellspacing=1 align=center
							bgcolor="#dddddd">

							<tr>
								<td class="line1" align="left" colspan="2">
									修改招标信息
								</td>
							</tr>
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"
									align=right width="15%">
									招标标题：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left width="85%"><%=title%>
								</td>
							</tr>
							<input name="bidding_id" type="hidden" value=<%=bidding_id%>>
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"
									align=right>
									详细信息：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<bean:define id="contents" value="<%=content%>" />
									<bean:write name="contents" filter="false" />
								</td>
							</tr>
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"
									align=right valign="top">
									中标公告内容：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<div class="ping">
										<textarea name="hit_content" style="display: none"></textarea>
										<iframe ID=hit_content
											src=/www/ewebeditor/ewebeditor.htm?id=hit_content&style=coolblue&root_id=
											<%=bidding_id%> frameborder=0 scrolling=no width=600
											HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"
									align=right>
									中标单位名称：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<div class="ping">
										<input name="hit_custname" type="text" size=50 maxlength=50>
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="0235">
							<input name="attach_tag" type="hidden" value="0">
							<tr>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan=2 align="center">
									<INPUT name="advshow" type="checkbox" value="0"
										onclick="addIsBiddingInfocheck_none(bidForm)">
									&nbsp;以上资料正确无误。
								</td>
							</tr>
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; padding-top: 10px; padding-bottom: 10px;"
									colspan=2 align=center>
									<input name="submit1" type="button" value="提交" disabled="true"
										onclick="addIsBiddingInfoconfirmsub(bidForm)">
								</td>
							</tr>

						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td height="46" background="/img/bg-3.gif">
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>




