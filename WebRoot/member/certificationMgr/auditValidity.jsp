<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.validityMgr.ValidityInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="advBean" class="com.saas.biz.advertiseMgr.AdvertiseInfo" scope="page" />
<jsp:useBean id="saleBean" class="com.saas.biz.saleMgr.SaleInfo" scope="page" />
<jsp:useBean id="newsBean" class="com.saas.biz.newsMgr.NewsInfo" scope="page" />
<jsp:useBean id="stockBean" class="com.saas.biz.stockorderMgr.Stockorderinfo" scope="page" />
<jsp:useBean id="typeBean" class="com.saas.biz.ProcessMgr.ProcessInfo" scope="page" />
<jsp:useBean id="jobBean" class="com.saas.biz.JobMgr.JobInfo" scope="page" />
<%
	String cust_id = "" ,trade_id ="" ,info_type = "",quo_id="";
	HttpSession logs = request.getSession();
	if (logs.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logs.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}
	if (request.getParameter("info_type") != null){
		info_type = request.getParameter("info_type");
	}
	if (request.getParameter("quo_id") != null){
		quo_id = request.getParameter("quo_id");
	}
	String para_code2="",title="",content="",publish_user_id="";
	para_code2=bean.getParamNameByValue("106",info_type);
	ValidityInfo info = new ValidityInfo();
	if(info_type.equals("1") || info_type=="1"){
		ArrayList infoList1=newsBean.genOneNews(quo_id);
		if (infoList1 != null && infoList1.size() > 0) {
		HashMap map = (HashMap) infoList1.get(0);
		if(map.get("title")!=null){title = map.get("title").toString();}
		if(map.get("content")!=null){content = map.get("content").toString();}
		if(map.get("publish_user_id")!=null){publish_user_id = map.get("publish_user_id").toString();}
		}
	}else if(info_type.equals("2") || info_type=="2"){
		ArrayList infoList2=advBean.genOneAdvertise(quo_id);
		if (infoList2 != null && infoList2.size() > 0) {
		HashMap map = (HashMap) infoList2.get(0);
		title="广告";
		if(map.get("content")!=null){content = map.get("content").toString();}
		if(map.get("rsrv_str1")!=null){publish_user_id = map.get("rsrv_str1").toString();}
		}
	}else if(info_type.equals("3") || info_type=="3" ){
		ArrayList infoList3=saleBean.genOneSale(quo_id);
		if (infoList3 != null && infoList3.size() > 0) {
		HashMap map = (HashMap) infoList3.get(0);
		if(map.get("title")!=null){title = map.get("title").toString();}
		if(map.get("content")!=null){content = map.get("content").toString();}
		if(map.get("publish_user_id")!=null){publish_user_id = map.get("publish_user_id").toString();}
		}
	}else if(info_type.equals("4")|| info_type=="4"){
		ArrayList infoList4=stockBean.genOneStockorder(quo_id);
		if (infoList4 != null && infoList4.size() > 0) {
		HashMap map = (HashMap) infoList4.get(0);
		if(map.get("title")!=null){title = map.get("title").toString();}
		if(map.get("content")!=null){content = map.get("content").toString();}
		if(map.get("publish_user_id")!=null){publish_user_id = map.get("publish_user_id").toString();}
		}
	}else if(info_type.equals("5") || info_type=="5"){
		ArrayList infoList5=typeBean.genOneProcess(quo_id);
		if (infoList5 != null && infoList5.size() > 0) {
		HashMap map = (HashMap) infoList5.get(0);
		if(map.get("category_title")!=null){title = map.get("category_title").toString();}
		if(map.get("category_abstract")!=null){content = map.get("category_abstract").toString();}
		if(map.get("publish_user_id")!=null){publish_user_id = map.get("publish_user_id").toString();}
		}
	}else if(info_type.equals("6") || info_type=="6"){
		ArrayList infoList6=jobBean.genOneJob(quo_id);
		if (infoList6 != null && infoList6.size() > 0) {
		HashMap map = (HashMap) infoList6.get(0);
		if(map.get("title")!=null){title = map.get("title").toString();}
		if(map.get("request")!=null){content = map.get("request").toString();}
		if(map.get("publish_user_id")!=null){publish_user_id = map.get("publish_user_id").toString();}
		}
	}
	
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/certificationMgr.js"></script>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 10px">
				<tr>
					<td height="13"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width=717 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									信息类型：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping1">
										<%=para_code2%>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									信息标题：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping1">
										<%=title%>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									信息内容：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping1">
										<%=content%>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									审核结果：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping">
										<select name="info_state" id="info_state">
											<option value="1">
												通过
											</option>
											<option value="2">
												未通过
											</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									审核意见：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping">
										<textarea id="audit_desc" name="audit_desc" rows="6" cols="50"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" width="20%">
									备注：
								</td>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: left" width="80%">
									<div class="ping1">
										<input type="text" name="remark" id="remark" maxlength="50" size="52">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; padding-top: 10px; padding-bottom: 10px; text-align: center;" align="center" colspan="2">
									<input class="tjan" name="submit" type="submit" value="" onclick="return auditValiditycheck_Value()">
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>">
									<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
									<input type="hidden" name="info_type" id="info_type" value="<%=info_type%>">
									<input type="hidden" name="publish_user_id" id="publish_user_id" value="<%=publish_user_id%>">
									<input type="hidden" name="oper_date" id="oper_date" value="">
									<input type="hidden" name="trade_type_code" value="1205">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



