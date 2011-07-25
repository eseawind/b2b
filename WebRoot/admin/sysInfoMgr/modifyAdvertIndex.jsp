<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.advertiseMgr.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	//out.println( "cust_id="+cust_id );
	ChannelInfo info = new ChannelInfo();
	AdvertiseInfo advertList = new AdvertiseInfo();
	ArrayList linkArray = advertList.genCustAdvertise(Integer.valueOf(iStart).intValue(), cust_id);
	int counter = advertList.getAdvertNumber(cust_id);
	
	
	int pages = (counter-1) / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
%>
<html>
	<head>
		<title>管理广告</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
				
				function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
				
				function delAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								if(document.getElementById('re_news'+i).checked==true){
									document.getElementById('re_news'+i).checked = false;	
								}else{
									document.getElementById('re_news'+i).checked = true;		
								}
						}
				}
				
				function reloadNews(){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('adv_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							document.getElementById("trade_type_code").value='';
							return false;
						}else{
									document.proForm.action='/doTradeReg.do';
									document.getElementById("trade_type_code").value="3597";
									document.proForm.submit();
							}
				}
				</script>
	</head>
	<body>
			<form action="" method="post" name="proForm">	
		<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
						<a href="advertIndex.jsp">新增广告信息</a>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="1" align=center>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=left bgcolor="#FCB0B0">
						<tr class="u4" height="25">
							<td width="15%" align="left">广告位标识</td>
							<td width="10%" align="left">是否限时</td>
							<td width="10%" align="left">结束日期</td>
							<td width="30%" align="left">广告代码</td>
							<td width="5%" align="left">JS</td>
							<td width="5%" align="center">修改</td>
						<td width="15%" align="center">
								<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
								<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
								<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
						</td>
						</tr>
						<%
						if(linkArray != null && linkArray.size() > 0) {
							int size = linkArray.size();
							for(int i=0;i<linkArray.size();i++) {
								HashMap map = (HashMap) linkArray.get(i);
								String adv_id = "";
								String end_date="",adv_name="",ch_id="",time_limit="",cust_adv_id="";
								if(map.get("adv_id") != null){
								  adv_id = map.get("adv_id").toString();
								}
								if(map.get("adv_name") != null){
								  adv_name = map.get("adv_name").toString();
								}
								if(map.get("time_limit") != null){
								  time_limit = map.get("time_limit").toString();
								  if(time_limit.equals("0")){
								  	time_limit = "不限时间";
									}else{
										time_limit = "限制时间";
									}
								}
								if(map.get("ch_id") != null){
								  ch_id = map.get("ch_id").toString();
								  ch_id = info.getChName(ch_id);
								}
								if(map.get("cust_adv_id") != null){
								  cust_adv_id = map.get("cust_adv_id").toString();
								}
								if(map.get("end_date") != null){
								  end_date = map.get("end_date").toString();
								  if(end_date.length() > 10) {
										end_date = end_date.substring(0, 10);
								  }
								}
									%>
									<tr class="u2">
										<td align="left"><a href="disAdvertInfo.jsp?adv_id=<%=adv_id%>"><%=cust_adv_id%></a></td>
										<td align="left"><%=time_limit%></td>
										<td align="left"><%=end_date%></td>
										<td align=left>
											{ecms:myad name='<%=cust_adv_id%>'/}
										</td>
										<td align="left"><a href="advertJs.jsp?cust_adv_id=<%=cust_adv_id%>">[JS]</a></td>
										<td align=center>
											<a href="modifyAdvertInfo.jsp?adv_id=<%=adv_id%>" onClick="mydefss()"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改广告信息"></a>
										</td>
										<td align=center>
											<!--a href="/doTradeReg.do?adv_id=<%=adv_id%>&trade_type_code=0308" target="_self" onClick="return chechIfo()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除广告信息"></a-->
											  <input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=adv_id%>" />
												<input type="hidden" name="size" value="<%=size%>" id="size" />
										</td>
									</tr>
									<%
								}
						%>
						<tr class="u3">
							<td background="/images/kehu_list_17.gif"  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td background="/images/kehu_list_17.gif" align="right" colspan="5"  style=" padding:2px 5px;">
								<a href="modifyAdvertIndex.jsp?iStart=0&menu_id=<%=top_menu_id%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="modifyAdvertIndex.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="modifyAdvertIndex.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="modifyAdvertIndex.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>">尾页</a>
							</td>
						</tr>
						<%
						}else{
						%>
						<tr align=center ><td colspan="6">暂无记录!</td></tr>
						<%}%>
						<input type="hidden" name="trade_type_code" id="trade_type_code" value="">
						<input type="hidden" name="adv_id" id="adv_id" value="">
					</table>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>



