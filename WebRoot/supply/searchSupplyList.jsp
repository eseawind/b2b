<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.SupplyInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="tools.util.StringUtil"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="areaBean" class="com.saas.biz.AreaInfoMgr.AreaInfo" scope="page" />
<%
	String country = areaBean.getCountrySelect("5J2mc0X0G85BH");
	String product_name = "", pro = "", city = "", date_scope = "", param = "";
	String iStart = "0";
	int counter = 0;
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("product_name") != null) {
		product_name = request.getParameter("product_name");
	}
	if (request.getParameter("pro") != null) {
		pro = request.getParameter("pro");
	}
	if (request.getParameter("city") != null) {
		city = request.getParameter("city");
	}
	if (request.getParameter("date") != null) {
		date_scope = request.getParameter("date");
	}

	SupplyInfo supplyInfo = new SupplyInfo();
	ArrayList saleList = new ArrayList();

		saleList = supplyInfo.getProductByLike(Integer.valueOf(iStart).intValue(), product_name, pro, city, date_scope);
		counter = supplyInfo.getProductByLike(product_name, pro, city,date_scope);

	String pageTools = tools.getGoogleToolsBar(counter, "searchSupplyList.jsp?product_name="+product_name+"&pro="+pro+"&city="+city+"&date="+date_scope+"&counter="+counter+"&iStart=", Integer.parseInt(iStart),10);
    int size=0;
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>供应详细信息</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="quoted.js"></script>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="supply.js"></script>
	</head>
	<body>
		<jsp:include flush="true" page="/include/top.jsp" />
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="DCDCDC">
			<tr>
				<td height="29" background="/images/Content_03.gif" bgcolor="#FFFFFF">
					&nbsp;&nbsp;您当前位置：
					<a href="/">首页</a>
					<img src="/images/lujian.gif" border="0">
					<a href="/supply">供应信息</a>
					<img src="/images/lujian.gif" border="0">
					查看供应信息
				</td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0" height="433">
			<tr>
				<td width="740" valign="top">
					<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">供应列表</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg"> 
							</td>
						</tr>
					</table>
					<!--供应列表-->
					
								<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="90ABDF">
									<tr>
										<td height="200" valign="top" bgcolor="FFFFFF">
											<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
												<tr>
													<td width="23%" height="30">
														<img src="/images/jiantou.gif" width="20" height="17">
														<input type="submit" name="Submit2" value="对比产品" onClick="saleCompare()">
													</td>
													<td width="37%" class="STYLE2">
														供应信息/公司
													</td>
													<td width="11%" class="STYLE2">
														价格(元)
													</td>
													<td width="13%" class="STYLE2">
														所在地
													</td>
													<td width="16%" class="STYLE2">
														留言/联系
													</td>
												</tr>
												<tr>
													<td height="1" class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
												</tr>
											</table>
											<table width="726" border="0" align="center" cellpadding="0" cellspacing="0" height="130">
											<%
									            if(saleList != null && saleList.size()>0){
									               size=saleList.size();
								              	 	for (int i=0;i<saleList.size();i++){
												        HashMap map = (HashMap) saleList.get(i);
												        String sale_id="",title="",content="",sale_price="",start_date="",end_date="",sale_addr="";
												        if(map.get("sale_id") != null){sale_id=map.get("sale_id").toString();}
												        if(map.get("title") != null){title=map.get("title").toString();}
												        if(map.get("content") != null){
												        content=map.get("content").toString();
												        content = content.replaceAll("<[^<>]+>","");
																if (content.length() > 115) 
																{
																	content =StringUtil.getLimitLengthString(content, "", 230);
																}
												        }
												        if(map.get("sale_price") != null){sale_price=map.get("sale_price").toString();}
												        if(map.get("start_date") != null){
												          start_date=map.get("start_date").toString();
												          if(start_date.length()>10){
												            start_date=start_date.substring(0,10);
												          }
												        }
												        if(map.get("end_date") != null){
												          end_date=map.get("end_date").toString();
												          if(end_date.length()>10){
												            end_date=end_date.substring(0,10);
												          }
												        }
												        if(map.get("sale_addr") != null){sale_addr=map.get("sale_addr").toString();}
												        				String file_path = "";
																			file_path = new Custinfo().getCustAttachPath( sale_id, "0");
																			
																			if(null==file_path || "/upload/default.gif".equals(file_path)){
																				file_path = "/images/cp.gif";
																			}
											%>
												<tr>
													<td width="4%" height="30">
														<input type="checkbox" name="sale_<%=i%>" id="sale_<%=i%>" value="<%=sale_id%>">
													</td>
													<td width="19%" height="130">
														<img name="" src="<%=file_path%>" width="100" height="100" alt="" />
													</td>
													<td width="37%">
														<a href="saleInquiry.jsp?sale_id=<%=sale_id%>" class="cpbt"><%=title%></a>
														<%=start_date%>
														<br><%=content%>
													</td>
													<td width="11%">
														￥<%=sale_price%>/套
													</td>
													<td width="13%"><%=sale_addr%></td>
													<td width="16%">
														<a href="saleInquiry.jsp?sale_id=<%=sale_id%>"><img src="/images/zx.gif" width="75" height="21"></a>
													</td>
												</tr>
												<tr>
													<td height="1" colspan="2" class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
													<td class="xian"></td>
												</tr>
												<%
											       }
											  }
											 %>
											</table>
										</td>
									</tr>
								</table>
								<table width="732" border="0" cellpadding="0" cellspacing="0" 0 height="1">
									<tr>
										<td height="10"></td>
									</tr>
								</table>
								<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="E3E3E3">
									<tr>
										<td height="32" align="center" background="/images/btt1.gif">
											<%=pageTools%>
											<input type="hidden" name="s_size" id="s_size" value="<%=size%>">
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"0>
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							
					<!--选项结束-->
					<br>
				</td>
				<td valign="top">&nbsp;
					
				</td>
				<form action="supplyComparam.jsp" method="post" name="commpara" id="commpara" target="_blank">
			      <input type="hidden" name="idx" id="idx">
		       </form>
				<td valign="top"><br></td><td width="228" valign="top">
					<jsp:include flush="true" page="/supply/sale_right.jsp" />
				</td>
			</tr>
		</table>
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>



