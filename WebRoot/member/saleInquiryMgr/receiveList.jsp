<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="enqBean" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page" />
<%  
	
	request.setCharacterEncoding("gbk");
	String cust_id="",cust_name="";
   HttpSession  logsessionres = request.getSession(); 
   if (logsessionres.getAttribute("SESSION_CUST_ID") != null)
     {
        cust_id = logsessionres.getAttribute("SESSION_CUST_ID").toString();   
        ArrayList list=new ArrayList();
        list=new Custinfo().getCustInfo(cust_id);   
        if(list!=null&&list.size()>0){
        HashMap map1=(HashMap)list.get(0);
        if(map1.get("cust_name")!=null)
        {
        cust_name=map1.get("cust_name").toString();
        }
     }
     }
	String start_time1 = "", end_time1 = "", code = "", key_word = "";
	Calendar cal = Calendar.getInstance();
	if (request.getParameter("start_time") != null) {
		start_time1 = request.getParameter("start_time");
	}
	if (request.getParameter("end_time") != null) {
		end_time1 = request.getParameter("end_time");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word").trim();
	}
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String iStart = "1";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	HttpSession logsession = request.getSession();
	String user_id = "";
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	int counter = 0;
	ArrayList linkArray = new ArrayList();
	if ("1".equals(code)) {
		linkArray = enqBean.getEnquiryByMySelfKey(Integer
		.parseInt(iStart), user_id, "1", key_word);
		counter = enqBean.getEnquiryByMySelfKey(user_id, "1", key_word);
	} else if ("2".equals(code)) {
		linkArray = enqBean
		.getEnquiryByMySelfDate(Integer.parseInt(iStart),
				user_id, "1", start_time1, end_time1);
		counter = enqBean.getEnquiryByMySelfDate(user_id, "1",
		start_time1, end_time1);
	} else {
		linkArray = enqBean.getEnquiryByMySelf(Integer.parseInt(iStart), user_id, "1");
		counter = enqBean.getEnquiryByMySelf(user_id, "1");
	}

	/*if(null!=linkArray){

	String userid="";
		for(int a=0; a<linkArray.size();a++){
			HashMap amap = (HashMap)linkArray.get(a);
			if(amap.get("user_id")!=null){
				userid = amap.get("user_id").toString();
			}
			if(!user_id.equals(userid)){
				counter--;
			}
		}
	}*/
	String pageTools = tools.getPageTools(String.valueOf(counter),
			"20", "receiveList.jsp?&code=" + code + "&key_word="
			+ key_word + "&start_time=" + start_time1
			+ "&end_time=" + end_time1 + "&iStart=", Integer
			.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid; font-weight:bold; background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		.td{background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;}
		</style>
		<style type="text/css">
	.chaxun{
			background:url(/admin/images/chaxun.gif) left center no-repeat;
			width:70px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>
		<link rel="stylesheet" type="text/css" href="../style/mg.css" />
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/saleInquiryMgr.js"></script>
	</head>
	<body>

		<form action="receiveList.jsp" method="post" name="indexdateform">
			<%
				String top_menu_id = "";
				if (request.getParameter("menu_id") != null) {
					top_menu_id = request.getParameter("menu_id");
				}
			%>
			
			<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#98D9A2" align="center">
				<tr class="u2">
					<td>
						开始时间:
						<input type="text" id="start_time" name="start_time" onfocus="setday(this);" value="<%=start_time%>">
						结束时间:
						<input type="text" id="end_time" name="end_time" onfocus="setday(this);" value="<%=end_time%>">
						<input type="hidden" name="code" value="2">
						<input class="chaxun" type="button" name="comit" value="" onclick="indexMgrCheck_Value();" style="cursor: hand;">
					</td>

				</tr>
			</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#98D9A2" align="center">
				<tr class="u2">
					<td>
						关键字:
						<input type="text" id="keyword1" name="key_word" value="">
						<input class="chaxun" type="button" name="comit" value="" onclick="search();" style="cursor: hand;">
					</td>
				</tr>
			</table>
		 
			<%
			if (null == linkArray ) {
			%>
			<center>没有您要查询的记录!</center>
			<%
			} else {
			%>
			<table width=100% border="0" cellspacing="0" cellpadding="0" align=center>
				<tr>
					<td>
						<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
							<tr class="u4" height="25">
								<td align="left" width="30%">
									询价标题
								</td>
								<td  align="left" width="15%">
									询价时间
								</td>
								<td  align="left" width="15%">
									供应公司
								</td>
								<td  align="left" width="15%">
									状态
								</td>
								<td align="center" width="15%">
									查看详细
								</td>
							</tr>
							<%
										if (linkArray != null && linkArray.size() > 0) {
										for (int i = 0; i < linkArray.size(); i++) {
									HashMap map = (HashMap) linkArray.get(i);
									String user_id2="";
									if(map.get("user_id")!=null){
										user_id2 = map.get("user_id").toString();
									}
									/*if(!user_id2.equals(user_id)){
										continue;
									}*/
									String trade_id = map.get("trade_id").toString();
									String title = map.get("rsrv_str3").toString();
									String enquiry_date = "", rsrv_str1 = "";
									if (map.get("enquiry_date") != null) {
										enquiry_date = map.get("enquiry_date").toString();
										if (enquiry_date.length() > 10) {
											enquiry_date = enquiry_date.substring(0, 10);
										}
									}
									if (map.get("rsrv_str1") != null) {
										rsrv_str1 = map.get("rsrv_str1").toString();
										if (rsrv_str1 == "0" || rsrv_str1.equals("0")) {
											rsrv_str1 = "未读";
										} else if (rsrv_str1 == "1"
										|| rsrv_str1.equals("1")) {
											rsrv_str1 = "已回复";
										} else {
											rsrv_str1 = "被删除";
										}
									}
									String user_name = "";
									if (map.get("user_name") != null) {
										user_name = map.get("user_name").toString();
									}
							%>
							<tr class="u2">
								<td  align="left">
									<a href="viewEnquiry.jsp?trade_id=<%=trade_id%>"  onclick="mydefss()"><%=title%> </a>
								</td>
								<td   align="left">
									<%=enquiry_date%>
								</td>
								<td align="left">
								<%
									 UserInfo userinfo = new UserInfo();
									 ArrayList comName = new ArrayList();
									 String ccomName = "";
									 comName = userinfo.getcomName(user_name);
									 	if (comName != null && comName.size() > 0) {
										HashMap map1 = (HashMap) comName.get(0);
										ccomName = map1.get("cust_name").toString();
										}
								%>
							   <%=ccomName%>
								</td>
								<td  align="left">
									<%=rsrv_str1%>
								</td>
								<td  align=center>
									<a href="viewEnquiry.jsp?trade_id=<%=trade_id%>"  onclick="mydefss()"><img src=/images/views.png width=16 height=16 border=0 alt="查看详细"> </a>
								</td>
							</tr>
							<%
							}
							%>
							<tr class="u1">
								<%=pageTools%>
							</tr>
							<%
							}
							%>
						</table>
					</td>
				</tr>
			</table>
			<%
			}
			%>
		</form>
	</body>
</html>




