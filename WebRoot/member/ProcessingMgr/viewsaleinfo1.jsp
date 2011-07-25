<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.ProcessMgr.ProcessInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>

<%

	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String category_id = "";
	String category_title = "";

	String category_abstract = "";
	String category_desc="";
	String publish_user_id="";
	String cust_id="";
	String cust_name="";

	String category_unit="";
	String start_date = date;
	String end_date = date;
 	String category_addr = "";
	

	if (request.getParameter("category_id") != null)
	{
		category_id = request.getParameter("category_id");
	}

	ProcessInfo processObj = new ProcessInfo();
	ArrayList processList = new ArrayList();

	if (category_id != null && !category_id.equals("")) 
	{
		processList = processObj.genOneProcess(category_id);
		if (processList != null && processList.size() > 0) 
		{
			HashMap map = (HashMap) processList.get(0);
			category_id = map.get("category_id").toString();
   
			if (map.get("category_title") != null) 
			{
				category_title = map.get("category_title").toString();
			}

			if (map.get("category_abstract") != null) 
			{
				category_abstract = map.get("category_abstract").toString();
			}
			if (map.get("category_desc") != null) 
			{
				category_desc = map.get("category_desc").toString();
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
            
        
			if (map.get("category_addr") != null) 
			{
				category_addr = map.get("category_addr").toString();
			}
			if(map.get("category_unit")!=null)
			{
			  category_unit=map.get("category_unit").toString();
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

			if (map.get("category_unit") != null) 
			{
				category_unit = map.get("category_unit").toString();
			}

	

		}

	}

%>

<html>

	<head>

		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/ProcessingMgr.js"></script>

	</head>

	<body>
  <form  name="classForm" method="post" action="/doTradeReg.do" target="_bank">
  		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
					<table width="100%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="u1">
								<div class="ping1">
								标题
								<div>
							</td>
							<td class="u2">
								<%=category_title%>
							</td>
							<td class="u1">
								<div class="ping1">
								分类产品信息介绍
								<div>
							</td>
							<td class="u2">
									<%=category_abstract%>
							</td>
						</tr>
						<tr>
							<td class="u1">
								<div class="ping1">
								分类产品信息描述
								<div>
							</td>
							<td class="u2">
									<%=category_desc%>
							</td>
								<td class="u1">
									<div class="ping1">
								计量单位
								<div>
							</td>
							<td class="u2">
								<%=category_unit%>
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
					    	<td class="u2">
								<%=end_date%>
							</td>
						</tr>
								<tr>
							<td class="u1">
								<div class="ping1">
								分类产品信息产地
								<div>
							</td>
							<td class="u2" colspan="3">
									<%=category_addr%>
							</td>
						</tr>
						
						
					</table>
			</tr>
			
		</table>
	</form>
	</body>

</html>





