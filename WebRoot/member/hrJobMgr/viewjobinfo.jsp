<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>

<%

	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String job_id = "";
	String title = "";
	String req = "";
	String publish_user_id="";
	String cust_id="";
	String cust_name="";
	String job_addr = "";
	
	String cop_name="";
	String job_unit="";
	OrganizeInfo organ = new OrganizeInfo();
	if (request.getParameter("job_id") != null)
	{
		job_id = request.getParameter("job_id");
	}

	JobInfo jobObj = new JobInfo();
	ArrayList jobList = new ArrayList();

	if (job_id != null && !job_id.equals("")) 
	{
		jobList = jobObj.genOneJob(job_id);
		if (jobList != null && jobList.size() > 0) 
		{
			HashMap map = (HashMap) jobList.get(0);
			job_id = map.get("job_id").toString();

			if (map.get("title") != null) 
			{
				title = map.get("title").toString();
			}

			if (map.get("job_unit") != null) 
			{
				job_unit = map.get("job_unit").toString();
				cop_name = organ.getCustNameById(job_unit);
			}
			if (map.get("request") != null) 
			{
				req = map.get("request").toString();
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
								  if(map2.get("cust_aim")!=""){
								  	cust_name = map2.get("cust_aim").toString();
								  }
							}
					}
				}
            
        
			if (map.get("job_addr") != null) 
			{
				job_addr = map.get("job_addr").toString();
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

	</head>

	<body>
  <form  name="classForm" method="post" action="/doTradeReg.do" target="_bank">
  		
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="u1" width="15%">
								职位标题
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
								<%=title%>
							</td>
							<td class="u1" width="15%">
								公司名称
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
							<%
							if(cop_name!=null && !cop_name.equals("")){%>
									<a href="/member/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=job_unit%>" target=""><%=cop_name%></a>
									<%}else{%>
									没有对应的公司
									<%}%>
							</td>
						</tr>
	
						<tr>
							<td class="u1" width="15%">
								工作地点
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=leftcolspan="3"">
								<%=job_addr%>
							</td><td class="u1" width="15%">
								职位要求
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
									<%=req%>
							</td>
						</tr>
						<tr>
	          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
								
			       	 		<img src="/admin/images/comeback.JPG" onclick="javascript:history.go(-1)" style=" border: 0;cursor: hand; text-align: center;">
								
	          	</td>
         	 </tr>
	</table>
	</form>
	</body>

</html>





