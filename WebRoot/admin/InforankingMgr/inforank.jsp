<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="com.saas.biz.propertyuMgr.PropertyuInfo"%>
<%@ page import="com.saas.biz.validityMgr.ValidityInfo"%>
<%
	String iStart = "0";
	int counter = 0;
	HashMap maps=bean.getPagetUrlByCode("106");
	String cust_class="",info_type="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("cust_class") != null) {
		cust_class = request.getParameter("cust_class");
	}
	if (request.getParameter("info_type") != null){
		info_type = request.getParameter("info_type");
	}
	
	ValidityInfo info = new ValidityInfo();
	ArrayList infoList = new ArrayList();
	
	if  ( info_type.equals("1") || info_type=="1" ){
		infoList=info.getNewsById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getNewsById(cust_class,info_type);
	}
	else if(info_type.equals("2") || info_type=="2"){
		infoList=info.getAdvertiseById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getAdvertiseById(cust_class,info_type);
	}
	else if(info_type.equals("3") || info_type=="3" ){
		infoList=info.getSaleById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getSaleById(cust_class,info_type);
	}
	else if(info_type.equals("4")|| info_type=="4"){
		infoList=info.getStockorderById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getStockorderById(cust_class,info_type);
	}
	else if(info_type.equals("5") || info_type=="5"){
		infoList=info.getCategoryById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getCategoryById(cust_class,info_type);
	} 
	else if(info_type.equals("6") || info_type=="6"){
		infoList=info.getJobById(Integer.parseInt(iStart),cust_class,info_type);
		counter = info.getJobById(cust_class,info_type);
	}
	
	int pages = counter / 20 + 1;
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
		<title>信息排名推荐</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
.ping_1 {
	font-weight: bold;
	color: black;
}

#tr {
	background-color: #f6f6f6;
	color: #000000;
	font-weight: bold;
	font-size: 12px;
	text-align: center;
}

#tr1 {
	background-color: #f6f6f6;
	color: #000000;
	font-size: 12px;
}

#tr2 {
	background-color: #ffffff;
	color: #000000;
	font-size: 12px;
}
</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
	</head>
	<body>
		<form name="serverForm" id="serverForm" action="index.jsp" method="post">
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>信息排名推荐</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td style="margin-top: 20px">
									<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
										<tr>
											<td  colspan="2">
												<table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
													<tr>
														<td background="/admin/images/newsbg.gif" style="color: #000000; font-weight: bold; font-size: 13px;" align=center width="15%">
															客户级别
														</td>
														<td background="/admin/images/newsbg.gif" style="color: #000000; font-weight: bold; font-size: 13px;" align=center width="15%">
															信息类型
														</td>
														<td background="/admin/images/newsbg.gif" style="color: #000000; font-weight: bold; font-size: 13px;" align=center width="40%">
															信息标题
														</td>
														<td background="/admin/images/newsbg.gif" style="color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
															发布时间
														</td>
														<td background="/admin/images/newsbg.gif" style="color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
															排名
														</td>
													</tr>
													<%
														
														if (infoList != null && infoList.size() > 0) {
														for (int i = 0; i < infoList.size(); i++) {
															HashMap map = (HashMap) infoList.get(i);
															String titles="",audit_date="",para_code2="",cust_classs="",page_Url="",quo_id="";
															cust_classs = bean.getParaCode2ByParaCode1("14",cust_class);
															if(map.get("para_code2")!=null){para_code2 = map.get("para_code2").toString();}
															if(map.get("quo_id")!=null){quo_id = map.get("quo_id").toString();}
															if(map.get("title")!=null){titles = map.get("title").toString();}
															if(map.get("category_title")!=null){titles = map.get("category_title").toString();}
															if(map.get("audit_date")!=null){audit_date = map.get("audit_date").toString();}
															if (audit_date.length() > 10) {audit_date = audit_date.substring(0, 10);}
															if(map.get("publish_date")!=null){audit_date = map.get("publish_date").toString();}
															if (audit_date.length() > 10) {audit_date = audit_date.substring(0, 10);}
															if(map.get("start_date")!=null){audit_date = map.get("start_date").toString();}
															if (audit_date.length() > 10) {audit_date = audit_date.substring(0, 10);}
															if(maps!=null && maps.size()>0){
															  if(maps.get(info_type)!=null){ 
															    page_Url=maps.get(info_type).toString();
															    page_Url=page_Url+quo_id;
															  }
															}
													%>
													<tr style="background-color: #f9f9f9;" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
														<td style="color: #000000; padding: 2px 5px;" align=center><%=cust_classs%></td>
														<td style="color: #000000;" align=center><%=para_code2%></td>
														<td style="color: #000000; padding: 2px 5px;" align=center>
															<a href="/admin/<%=page_Url%>" TARGET=appwin onclick="mydefss()"><%=titles%></a>
														</td>
														<td style="color: #000000;" align=center><%=audit_date%></td>
														<td style="color: #000000;" align=center>
															<a href="addrank.jsp?&quo_id=<%=quo_id%>" TARGET=appwin onclick="mydefss()"><img src=/images/edit.png width=16 height=16 border=0 style="cursor: hand" alt="修改"></a>
														</td>
													</tr>
													<%
														}
													%>
													<tr>
														<td align="left" colspan="3" background="/admin/images/newsbg.gif">
															共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart) + 1%>页&nbsp;&nbsp;共<%=pages%>页
														</td>
														<td align="right" colspan="3" background="/admin/images/newsbg.gif">
															<a href="rankindex.jsp?iStart=0&cust_class=<%=cust_class%>&info_type=<%=info_type%>">首页 </a>&nbsp; &nbsp;
															<%
															if (Integer.parseInt(iStart) > 0) {
															%>
															<a href="rankindex.jsp?iStart=<%=pageUp%>&cust_class=<%=cust_class%>&info_type=<%=info_type%>">上一页</a> &nbsp;
															<%
																}
																if (Integer.parseInt(iStart) < pages - 1) {
															%>
															<a href="rankindex.jsp?iStart=<%=pageDown%>&cust_class=<%=cust_class%>&info_type=<%=info_type%>">下一页 </a>&nbsp;
															<%
															}
															%>
															<a href="rankindex.jsp?iStart=<%=pages - 1%>&cust_class=<%=cust_class%>&info_type=<%=info_type%>">尾页</a>
														</td>
													</tr>
													<%
														}else{
										      %>
										      	<tr>
										      		<td align="center" colspan="6" bgcolor="white">
										      			无记录！
										      		</td>
										      	</tr>
										      <%		
										      }
													%>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="hidden" id="obj_cust_id" name="obj_cust_id">
												<input type="hidden" id="trade_type_code" name="trade_type_code" value="1187">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


