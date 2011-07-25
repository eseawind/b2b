<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.enquirytrackMgr.EnquirytrackInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%
	//String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String sale_id = "";
	String title = "";
	String enquiry_content = "";
	String user_id = "";
	String user_name=""; 
	String enquiry_date = ""; 
	      
	if (request.getParameter("sale_id") != null)
	{
		sale_id = request.getParameter("sale_id");		 
	}
	 EnquirytrackInfo enquiryObj = new EnquirytrackInfo(); 
	 ArrayList List = new ArrayList();
		 
 	if (sale_id != null && !sale_id.equals("")) 
	{	
		List = enquiryObj.getCustEnquiryBySaleId( sale_id );
		out.print("========="+List+"===========");
		if (List != null && List.size() > 0)
		 {
		 	 	HashMap map = (HashMap) List.get(0);
				sale_id = map.get("sale_id").toString();
			
				if (map.get("title") != null )
				{
					title = map.get("title").toString();
				}
							
				if (map.get("enquiry_content") != null) 
				{
					enquiry_content = map.get("enquiry_content").toString();
				}
				if (map.get("user_id") != null) 
				{
					user_id = map.get("user_id").toString();
					UserInfo userInfo = new UserInfo();
					ArrayList list = new ArrayList(); 
					HashMap map1 = new HashMap();
					list = userInfo.genOneUserInfo(user_id);
					if (list != null && list.size() > 0)
					{
						  map1 = (HashMap) list.get(0);
						  user_name = map1.get("user_name").toString();
					}
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
		<table width="818" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td height="26" background="/img/bg-1.gif">&nbsp;
				</td>
			</tr>
			<tr>
				<td background="/img/bg-2.gif">
					<table width="93%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="line1" align="left" colspan="2">
								查看应聘
							</td>
						</tr>
					  	<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right width=15%>
								求职标题
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width=85%>
								<%=title%>
							</td>
						</tr>
								
											
						<tr> 
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right valign="top">
								求职内容
							</td>
							<td style= "background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<%=enquiry_content%>
							</td>
						</tr>
					
				
					</table>
				</td>
			</tr>
			<tr>
				<td height="46" background="/img/bg-3.gif">&nbsp;			
				</td>
			</tr>
		</table>
	</body>
</html>





