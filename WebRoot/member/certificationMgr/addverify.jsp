<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%
	String iStart = "1";
	String meun_idx = "";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	VerifyInfo verifyList = new VerifyInfo();
	ArrayList linkArray = verifyList.genCustVerifyByCust_id(Integer.valueOf(iStart).intValue(),"0");
	int counter = verifyList.getVerifyNumber("0");
	String toolsBar=tools.getPageTools(String.valueOf(counter),"20","addverify.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B���������̨����ϵͳ</title>
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid; font-weight:bold; background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*������ʽ6---- ͷ������1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*������ʽ1*/
		.td{background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;}
		</style>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="newc4n2mB904X0G85Be2" />
		</jsp:include>
		<table width="800" border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr class="line1">
							<td style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="15%" background="/images/newsbg.gif">��֤����</td>
							<td  style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="15%" background="/images/newsbg.gif">��֤֤������</td>
							<td style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="25%" background="/images/newsbg.gif">�ͻ�����</td>
						    <td  style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="15%" background="/images/newsbg.gif">�鿴��ϸ</td>
							<td  style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="15%" background="/images/newsbg.gif">����ʱ��</td>
							<td  style="color: #000000; font-weight: bold; font-size: 13px;" align="center" width="10%" background="/images/newsbg.gif">����</td>
						</tr>
						<%
						if(linkArray != null && linkArray.size() > 0) 
						{
							for(int i=0;i<linkArray.size();i++) 
							{
								HashMap map = (HashMap) linkArray.get(i);
								String verify_id = map.get("verify_id").toString();
								String verify_name=map.get("verify_name").toString();
								String verify_status="",cust_id="",cust_name="";
								String req_date = "",	verify_type="",para_code1="";
								if( map.get("verify_type" ) != null) 
								{
								    para_code1 = map.get("verify_type").toString();
									verify_type = param.getParamNameByValue( "100",para_code1);
								}
								if( map.get("cust_id" ) != null) 
								{
								    cust_id = map.get("cust_id").toString();
								}
								if( map.get("cust_name" ) != null) 
								{
								    cust_name = map.get("cust_name").toString();
								}
								if(map.get("verify_status") != null) 
								{
							    verify_status = map.get("verify_status").toString();
								if(map.get("req_date") != null) {
								   req_date = map.get("req_date").toString();
									if (req_date.length() > 10) {
										req_date = req_date.substring(0, 10);
									}
								}
									%>
									<tr style="background-color:#f9f9f9; ">
										<td style=" color:#000000;" align="left"><%=verify_type%></td>
										<td style=" color:#000000;" align="left"><%=verify_name%></td>
										<td style=" color:#000000;" align="left"><a href="/customerMgr/Custinfo.jsp?obj_cust_id=<%=cust_id%>&user_id=" TARGET=appwin onclick="mydefss()"><%=cust_name%></a></td>
										<td style=" color:#000000;" align=center>
											<a href="viewVerifyInfo.jsp?verify_id=<%=verify_id%>" TARGET=appwin onclick="mydefss()"><img src=/img/view.gif width=16 height=16 border=0 alt="�鿴������Ϣ"></a>
										</td>
										<td style=" color:#000000;" align="center"><%=req_date%></td>
										<td style=" color:#000000;" align=center>
											<a href="modifyVerify.jsp?verify_id=<%=verify_id%>" TARGET=appwin onclick="mydefss()"><img src=/img/edit.gif width=16 height=16 border=0  alt="�������"></a>
										</td>
										
									</tr>
									<%
								}
								}
						%>
						<tr>
						  <%=toolsBar%>
						</tr>
						<%
						}else{
			      %>
			      	<tr>
			      		<td align="center" colspan="6" bgcolor="white">
			      			�޼�¼��
			      		</td>
			      	</tr>
			      <%		
			      }
						%>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>




