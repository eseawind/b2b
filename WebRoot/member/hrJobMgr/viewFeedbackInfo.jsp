<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserDetailInfo"%>
<%@ page import="com.saas.biz.userMgr.UserDetailInfo"%>
<%@ page import="com.saas.biz.acceptMgr.AcceptInfo"%>
<%@ page import="com.saas.biz.dao.acceptjobDAO.AcceptjobDAO"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
	commMethodMgr commen = new commMethodMgr();
  String trade_id = commen.GenTradeId();
  			
  String root_id="";
  if( request.getParameter( "trade_id" ) != null && request.getParameter( "trade_id" ) != "" )
  {
      root_id = request.getParameter( "trade_id" );
  }
  HttpSession  logsession = request.getSession();     
  String cust_id="",user_id="",user_name="";
  if (logsession.getAttribute("SESSION_CUST_ID") != null)
  {
    cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
  }
  //out.print( cust_id );
	if (logsession.getAttribute("SESSION_USER_ID") != null)
  {
    user_id = logsession.getAttribute("SESSION_USER_ID").toString();
  }
  if (logsession.getAttribute("SESSION_USER_NAME") != null)
  {
    user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
  }
  AcceptInfo acceptInfo = new AcceptInfo();
  AcceptjobDAO acceptDao = new AcceptjobDAO();
  acceptDao = acceptInfo.getAcceptJobById(root_id);
  
  LeavewordsInfo wordsInfo = new LeavewordsInfo();
  ArrayList wordslist = new ArrayList();
  wordslist = wordsInfo.genLeavewords(root_id); 
  
  
  String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String job_id = "";
	String title = "";
	String req = "";
	String publish_user_id="";
	String cust_id2="";
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
						   cust_id2 = map1.get("cust_id").toString();
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
            
        
			if (map.get("job_addr") != null) 
			{
				job_addr = map.get("job_addr").toString();
			}

	
		}

	}

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/hrJobMgr.js"></script>
  </head>
	<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					 <a href="javascript:history.go(-1)">Ͷ�ݼ�������</a>
				</td>
			</tr>
		</table>
	   <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
	  
		  <tr class="u4" height="27">
			  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">&nbsp;&nbsp;ְλ���</td>
	 	</tr>
	  </table>
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
							<td class="u1" width="15%">
								ְλ����
							</td>
							<td class="u2" width="35%">
								<%=title%>
							</td>
							<td class="u1" width="15%">
								��˾����
							</td>
							<td class="u2" width="35%">
							<%
							if(cop_name!=null && !cop_name.equals("")){%>
									<a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=job_unit%>" target="_blank"><%=cop_name%></a>
									<%}else{%>
									û�ж�Ӧ�Ĺ�˾
									<%}%>
							</td>
						</tr>
	
						<tr>
							<td class="u1" width="15%">
								�����ص�
							</td>
							<td class="u2" colspan="3">
								<%=job_addr%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								ְλҪ��
							</td>
							<td class="u2" width="35%" colspan="3">
									<%=req%>
							</td>
						</tr>
	</table>
					
		   <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
		  <tr class="u4" height="27">
		  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">&nbsp;&nbsp;��ְ����</td>
			 </tr>
		  </table>
	  <table cellspacing="1" cellpadding="3" width=100% bgcolor="#DEEDFD" border="0" align="center">
	  <tr>
		  <td class="u1" width="15%">�ҵ���ְ����																		
		</td>
		<td width="98%" valign="bottom" class="u2"><%=acceptDao.getRsrv_str3()%>	</td>
		</tr>
	</table>				
		   <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
		  <tr class="u4" height="27">
		  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">&nbsp;&nbsp;��˾�ظ�</td>
			 </tr>
		  </table>
	  <%
	  		if(wordslist!=null && wordslist.size()>0){
	  		int i = 0;
	  		Iterator iterator = wordslist.iterator();
							while(iterator.hasNext()){
				HashMap map1 = (HashMap) iterator.next();
				i++;
	  	%>
	  <table cellspacing="1" cellpadding="3" width=800 bgcolor="#DEEDFD" border="0" align="center">
	<tr>
						  <td class="u1" width="15%">
						  	�ظ����⣺<%=i%>																			
						  </td>
						  <td valign="bottom" class="u2">
						  	<%=map1.get("title")%>
					    </td>
						</tr>
						<tr>
						  <td class="u1">�ظ����ݣ�</td>
						  <td class="u2">
						  	<%=map1.get("content")%>
						  </td>
						</tr>
						<tr>
						  <td class="u1">�ظ�ʱ�䣺</td>
						  <td class="u2">
						  	<%=map1.get("in_date")%>
						  </td>
						</tr>
						<%}
			}%>
			<%if(wordslist==null || wordslist.size()<=0){%>
			<tr>
				 <td class="u1">�޹�˾�ظ�</td> 
			</tr>
			<%}%>
						<input name="trade_id" type="hidden" value="<%=trade_id%>"/>
						<input name="root_id" type="hidden" value="<%=acceptDao.getTrade_id()%>"/>
						<input name="cust_id" type="hidden" value="<%=cust_id%>"/>
						<input name="user_id" type="hidden" value="<%=user_id%>"/>
						<input name="user_name" type="hidden" value="<%=user_name%>"/>
						<input name="phone" type="hidden" value="">
						<input name="email" type="hidden" value="">
						<input name="word_type" type="hidden" value="8">
						<input name="word_status" type="hidden" value="0">
						<input name="trade_type_code" type="hidden" value="0006">
    </table>							
    </body>
</html>




