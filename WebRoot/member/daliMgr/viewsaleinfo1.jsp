<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="att" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />

<%

	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String sale_id = "";
	String title = "";
	String content = "";
	String publish_user_id="";
	String cust_id="";
	String cust_name="";
	String sale_addr = "";
	String start_date = date;
	String end_date = date;
	String sale_price = "";
	String commodity_price = "";
	

	if (request.getParameter("sale_id") != null)
	{
		sale_id = request.getParameter("sale_id");
	}

	SaleInfo saleObj = new SaleInfo();
	ArrayList saleList = new ArrayList();

	if (sale_id != null && !sale_id.equals("")) 
	{
		saleList = saleObj.genOneSale(sale_id);
		if (saleList != null && saleList.size() > 0) 
		{
			HashMap map = (HashMap) saleList.get(0);
			sale_id = map.get("sale_id").toString();

			if (map.get("title") != null) 
			{
				title = map.get("title").toString();
			}

			if (map.get("content") != null) 
			{
				content = map.get("content").toString();
			}
            
            if (map.get("publish_user_id") != null) 
				{
					publish_user_id = map.get("publish_user_id").toString();
					UserInfo userInfo = new UserInfo();
					ArrayList list = new ArrayList(); 
					HashMap map1 = new HashMap();
					list = userInfo.genOneUserInfo(publish_user_id);
					if (list != null && list.size() > 0)
					{
						   map1 = (HashMap) list.get(0);
						   cust_id = map1.get("cust_id").toString();
						  
						    Custinfo custInfo = new Custinfo();
							ArrayList list2 = new ArrayList(); 
							HashMap map2 = new HashMap();
							list2 = custInfo.genSpecCustInfo(cust_id);
							if (list2 != null && list2.size() > 0)
							{
								  map2 = (HashMap) list2.get(0);
								  cust_name = map2.get("cust_name").toString();
							}
					}
				}
            
			if (map.get("sale_addr") != null) 
			{
				sale_addr = map.get("sale_addr").toString();
			}

			if (map.get("start_date") != null) 
			{
				start_date = map.get("start_date").toString();
				if (start_date.length() > 10)
				{
					start_date = start_date.substring(0, 10);
				}
			}

			if (map.get("end_date") != null)
			{
		         end_date = map.get("end_date").toString();
				if (end_date.length() > 10) 
				{
					end_date = end_date.substring(0, 10);
				}
			}

			if (map.get("sale_price") != null) 
			{
				sale_price = map.get("sale_price").toString();
			}

			if (map.get("commodity_price") != null)
			{
				commodity_price = map.get("commodity_price").toString();
			}

		}

	}
	String file_path="";
	ArrayList listatt = att.getAttachInfoByList(sale_id);
	if(null != listatt){
		HashMap mp = (HashMap)listatt.get(0);
		if(mp.get("file_path")!=null){
			file_path = mp.get("file_path").toString();
		}		
	}
	if(file_path==null || file_path.equals("")){
		file_path="/images/cpwu.gif";
		}
%>

<html>

	<head>

		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>

	</head>

	<body>
  <form  name="classForm" method="post" action="/doTradeReg.do" target="_bank">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr><td>
					
				  <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
							<td class="u1">
								<div class="ping1">								
								代理标题
								<div>
							</td>
							<td class="u2" colspan="3">
								<%=title%>
							</td>
						</tr>
										

						
						<tr>
							<td class="u1">
								<div class="ping1">	
								开始日期
								<div>	
							</td>
							<td class="u2">
								<%=start_date%>
							</td>
							<td class="u1">
								<div class="ping1">	
								结束日期
								<div>	
							</td>
					    	<td class="u2"s>
								<%=end_date%>
							</td>
						</tr>
						<tr>
							<td class="u1">
							<div class="ping1">	
								内容
						<div>	
							</td>
								<td class="u2" colspan="3">
									<%=content%>
							</td>	
							</tr>
							
						<tr bgcolor="white">
							<td colspan="4" align="center">
								<img src="/admin/images/comeback.JPG" onclick="javascript:history.go(-1);" style="cursor:hand">
								
								</td>
							
							
							</tr>
					</table>
					</td>
			</tr>
			
		</table>
	</form>
	</body>

</html>




