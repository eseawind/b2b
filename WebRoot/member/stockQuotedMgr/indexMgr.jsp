<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="enqBean" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page" />

<%
String cust_id="",cust_name="";
   HttpSession  logsessionres = request.getSession(); 
   if (logsessionres.getAttribute("SESSION_CUST_ID") != null)
     {
        cust_id = logsessionres.getAttribute("SESSION_CUST_ID").toString();   
        ArrayList list=new ArrayList();
        list = new Custinfo().getCustInfo(cust_id);   
        if(list!=null&&list.size()>0)
		{
			HashMap map1=(HashMap)list.get(0);
			if(map1.get("cust_name")!=null)
			{
				cust_name=map1.get("cust_name").toString();
			if(cust_name.length()>6)
			{        
				cust_name=cust_name.substring(0,6)+"...";
			}
        }        
     }
     }
	 request.setCharacterEncoding("gbk");
     String start_time1 ="",end_time1 ="",code="",key_word="";
     Calendar cal = Calendar.getInstance();
     if (request.getParameter("start_time") != null) 
	 {
		start_time1 = request.getParameter("start_time");
	 }
	 if (request.getParameter("end_time") != null) 
	 {
		end_time1 = request.getParameter("end_time");
	 }
	if (request.getParameter("code") != null) 
	{
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) 
	{
		key_word = request.getParameter("key_word").trim();
	}
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

	String iStart = "1";
	if (request.getParameter("iStart") != null) 
	{
		iStart = request.getParameter("iStart");
	}
	
	HttpSession logsession = request.getSession();
	String user_id = "";
	if (logsession.getAttribute("SESSION_USER_ID") != null) 
	{
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	int counter = 0 ;
	//out.println("===usr_id==="+user_id);
	ArrayList linkArray = new ArrayList();
	if("1".equals(code))
	{
		linkArray = enqBean.getEnquiryByMySelfKey(Integer.parseInt(iStart), user_id, "7",key_word);
		counter = enqBean.getEnquiryByMySelfKey(user_id, "7",key_word);
	}
	else if("2".equals(code))
	{
		linkArray = enqBean.getEnquiryByMySelfDate(Integer.parseInt(iStart), user_id, "7",start_time1,end_time1);
		counter = enqBean.getEnquiryByMySelfDate(user_id, "7",start_time1,end_time1);
	}
	else
	{
		linkArray = enqBean.getEnquiryByMySelf(Integer.parseInt(iStart), user_id, "7");
		counter = enqBean.getEnquiryByMySelf(user_id, "7");
	}
	//out.println("list==="+linkArray+"===");
	String pageTools = tools.getPageTools(String.valueOf(counter), "20", "receiveList.jsp?&code="+code+"&key_word="+key_word+"&start_time="+start_time1+"&end_time="+end_time1+"&iStart=",Integer.parseInt(iStart));
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
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
			<style type="text/css">
	.chaxun{
			background:url(/admin/images/chaxun.gif) left center no-repeat;
			width:70px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>
		<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/stockQuotedMgr.js"></script>
	</head>
	<body>
	<form action="receiveList.jsp" method="post" name="indexdateform">
		<%
			String top_menu_id="";
			if (request.getParameter("menu_id") != null){
	        top_menu_id = request.getParameter("menu_id");
	    }
		%>
				
		<table  width=100% border=0 cellpadding=1 cellspacing=1 align="center" bgcolor="#98D9A2">
			<tr class="u2">
				<td>
					开始时间:<input type="text" id="start_time" name="start_time" onfocus="setday(this);" value="<%=start_time%>">
					结束时间:<input type="text" id="end_time" name="end_time" onfocus="setday(this);" value="<%=end_time%>">
					<input class="chaxun" type="button" name="comit" value="" onclick="Check_Value();" style="cursor: hand;">
					<input type="hidden" name="code" id="code" value="2">
				</td>
				
			</tr>
		</table>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align="center" bgcolor="#98D9A2">		
			<tr class="u2">
				<td>
				关键字:<input type="text" id="keyword" name="key_word"  value="<%=key_word%>">
					<input class="chaxun" type="button" name="comit" value="" onclick="search();" style="cursor: hand;">
				</td>
			</tr>
		</table>

		<%if(null==linkArray) {%>
			<center>没有您要查询的记录。</center>
		<%} if(null!=linkArray){%>
		<table width=100% border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
						<tr class="u4" height="25">
							<td align="left" idth="30%">
								咨询标题
							</td>
							<td align="left" width="15%">
								咨询时间							
							</td>
							<td align="left" width="15%">
								所属客户
							</td>
							<td align="left" width="15%">
								状态
							</td>
							<td align="center" width="15%">
								查看详细
							</td>
						</tr>
						<%
							if (linkArray != null && linkArray.size() > 0) 
							{
								for (int i = 0; i < linkArray.size(); i++) 
								{
									HashMap map = (HashMap) linkArray.get(i);
									String trade_id=map.get("trade_id").toString();
									String title="",enquiry_date="",rsrv_str1="",user_name="",cust_name2="",sale_id="";
									if(map.get("rsrv_str3")!=null){
									 title=map.get("rsrv_str3").toString();
									}
									if(map.get("cust_name")!=null){
									 cust_name2=map.get("cust_name").toString();
									}
									if(map.get("sale_id")!=null){
									 sale_id=map.get("sale_id").toString();
									}
								
									HashMap saleMap = new InfoList().getCastById(sale_id);
									String qiuu_cust_id = "";
									if(saleMap.get("cust_id")!=null){
										qiuu_cust_id = saleMap.get("cust_id").toString();
									}
								
									String qiuu_cust_name = new Custinfo().getCustNameById(qiuu_cust_id);
									
									if(map.get("enquiry_date")!=null){
									  enquiry_date=map.get("enquiry_date").toString();
									  if(enquiry_date.length()>10){
										enquiry_date=enquiry_date.substring(0,10);
									  }
									}
									if(map.get("rsrv_str1")!=null){
									  rsrv_str1=map.get("rsrv_str1").toString();
									  if(rsrv_str1=="0" ||rsrv_str1.equals("0")){
										rsrv_str1="未读";
									  }else if(rsrv_str1=="1" ||rsrv_str1.equals("1")){
										rsrv_str1="已回复";
									  }else{
										rsrv_str1="被删除";
									  }
									}
	
									if(map.get("user_name")!=null){
									  user_name=map.get("user_name").toString();
									}
									String qiu_cust_id = "",deal_tag="";
									HashMap map2=enqBean.getEnquriyById(trade_id);
									if(map2.get("deal_tag")!=null){
										deal_tag =map2.get("deal_tag").toString();
									}
									if(map2!=null){
									 if(map2.get("cust_name")!=null){
											  cust_name=map2.get("cust_name").toString();
										}
										if(map2.get("cust_id")!=null){
											 qiu_cust_id=map2.get("cust_id").toString();
										}
								   }	
       				%>
						<tr class="u2">
							<td align="left">
								<a href="viewProductEnquiry.jsp?trade_id=<%=trade_id%>&cust_id=<%=qiuu_cust_id%>" ><%=title%></a>
							</td>
							<td align="left">
							    <%=enquiry_date%>
							</td>
							<td align="left">
							   <a href="/member/customerMgr/viewcompanyIntroduction.jsp?obj_cust_id=<%=qiuu_cust_id%>" TARGET=_self><%=qiuu_cust_name%></a>
							</td>
							<td align="left">
							   <%=rsrv_str1%>
							</td>
							<td align=center>
								<a href="viewProductEnquiry.jsp?trade_id=<%=trade_id%>&cust_id=<%=qiuu_cust_id%>"  ><img src=/images/views.png width=16 height=16 border=0 alt="查看详细"> </a>
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
	<%}%>
		</form>	
	</body>
</html>




