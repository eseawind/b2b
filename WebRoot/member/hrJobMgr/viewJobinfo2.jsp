<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>

<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String job_id = "";
	String title = "";
	String req = "";
	String publish_user_id = "";
	String cust_id = "";
	String cust_name = "";
	String job_addr = "";
	String job_type = "";
	//String enquiry_date="";
	if (request.getParameter("job_id") != null) {
		job_id = request.getParameter("job_id");
	}
	
	JobInfo jobObj = new JobInfo();
	ArrayList jobList = new ArrayList();
	if (job_id != null && !job_id.equals("")){
		jobList = jobObj.genOneJob(job_id);
	  	if(jobList != null && jobList.size() > 0){
			HashMap map = (HashMap) jobList.get(0);
			job_id = map.get("job_id").toString();
			if (map.get("title") != null) {
	     		title = map.get("title").toString();
			}
			if (map.get("request") != null) {
	    		req = map.get("request").toString();
			}
			if (map.get("publish_user_id") != null) {
				publish_user_id = map.get("publish_user_id").toString();
				UserInfo userInfo = new UserInfo();
				ArrayList list = new ArrayList();
				HashMap map1 = new HashMap();
				list = userInfo.genOneUserInfo(publish_user_id);
				if (list != null && list.size() > 0){
					map1 = (HashMap) list.get(0);
					cust_id = map1.get("cust_id").toString();
					Custinfo custInfo = new Custinfo();
					ArrayList list2 = new ArrayList();
					HashMap map2 = new HashMap();
					list2 = custInfo.genSpecCustInfo(cust_id);
					if (list2 != null && list2.size() > 0) {
						map2 = (HashMap) list2.get(0);
						cust_name = map2.get("cust_name").toString();
					}
				}
			}
			if (map.get("job_addr") != null){
		 	   job_addr = map.get("job_addr").toString();
			}
			if(null != map.get("job_type")){
				job_type = map.get("job_type").toString();
			}
		}
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		
<script language="javascript">
	function onclick_val(){
		if(document.getElementById("rsrv_str3").value==''){
				alert("请输入求职意向！");
				return false;
			}
		return true;
	}
</script>
	</head>
	<body>
		<form name="classForm" method="post" action="/doTradeReg.do" target="_self">
	
	  <table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
					
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="15%">
								职位标题							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<%=title%>							</td>
						</tr>
						<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right valign="top">
								职位要求							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<%=req%>							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								工作地点							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
								<%=job_addr%>							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								求职意向：							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
								<textarea name="rsrv_str3" id="rsrv_str3" cols="50" rows="6"></textarea>							</td>
						</tr>
						<input type="hidden" name="job_id" value="<%=job_id%>">
					  	<input type="hidden" name="job_type" value="<%=job_type%>">
					  	
						<input type="hidden" name="trade_type_code" value="0005">
						<tr>
							<td align="left" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" colspan="4">
								<input type="submit" value="发送求职意向" name="submit"  border="0" width="64" height="22" onclick="return onclick_val();"/></td>
						</tr>
						<tr>
          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
          	 <a href="/member/hrJobMgr/PersonApplyIndex.jsp">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
          </tr>
		  </table>
		</form>
	</body>
</html>



