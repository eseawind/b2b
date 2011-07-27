<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="tools.util.FileIO"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	HttpSession top_session = request.getSession();
	String user_name = "", login_cust_id = "", subsys_codenow = "SYS", web = "", cust_id = "", cust_type = "";
	if (request.getParameter("subsys_code") != null) {
		subsys_codenow = request.getParameter("subsys_code");
	}
	if (top_session.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = top_session.getAttribute("SESSION_CUST_ID")
				.toString();
	}
	if (top_session.getAttribute("SESSION_CUST_TYPE") != null) {
		cust_type = top_session.getAttribute("SESSION_CUST_TYPE")
				.toString();
	}
	if (top_session.getAttribute("SESSION_USER_NAME") != null) {
		user_name = top_session.getAttribute("SESSION_USER_NAME")
				.toString();
		login_cust_id = top_session.getAttribute("SESSION_CUST_ID")
				.toString();
	}

	String cust_name = new OrganizeInfo().getCustNameById(cust_id);
	String class_name = new CustClass().cust_Class_Name(cust_id);
	if ("1".equals(cust_type)) {
		class_name = "(管理员)";
	} else {
		class_name = "(" + class_name + ")";
	}
	/*ArrayList comList = custInfo.getCustInfo(cust_id);
	String company = "";
	if(comList!=null && comList.size()>0){
		HashMap comMap = (HashMap)comList.get(0);
		if(comMap.get("juristic_type_code")!=null){
			company = comMap.get("juristic_type_code").toString();
		}
	}
	if(company.equals("")){
		company = login_cust_id;
	}*/
	ChannelInfo ch = new ChannelInfo();
	ArrayList list = new ArrayList();
	list = ch.getChNameAndPath("1");
	config con = new config();
	con.init();
	String logolink = con.getString("logolink");
	String logourl = con.getString("logourl");
%>
<html>
	<head>
		<title>top</title>
		<LINK href="images/member.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<TABLE width="100%" border="0" align="center" cellPadding="0"
			cellSpacing="0" class="topnav">
			<TBODY>
				<TR>
					<TD align="left" width="297">
						<a href="<%=logolink%>" target="_blank">
							<div
								style="width: 400px; height: 68px; background: none; filter: progid : DXImageTransform . Microsoft . AlphaImageLoader(src = '<%=logourl%>', sizingMethod = 'crop'); margin: 5px 0 0 10px;"></div>
						</a>
					</TD>
					<TD valign="bottom">
						<TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">

							<tr>
								<TD height="30"
									style="color: #ffffff; font-size: 9px; margin-right: 10px"
									align="right">
									<img src="/admin/images/tophome.gif" align="absmiddle"
										border="0" />
									&nbsp;&nbsp;
									<a href="/" target="_blank"><font style="font-size: 13px">首页</font>
									</a> |
									<%
										if (list.size() > 0) {
											String ch_name = "", save_dir = "";
											for (int j = 0; j < list.size(); j++) {
												HashMap map = (HashMap) list.get(j);
												if (map.get("ch_name") != null) {
													ch_name = map.get("ch_name").toString();
												}
												if (map.get("save_dir") != null) {
													save_dir = "/" + map.get("save_dir").toString() + "/";
												}
									%>
									<a href="<%=save_dir%>" target="_blank"><font
										style="font-size: 13px"><%=ch_name%></font>
									</a>|
									<%
										}
										}
									%>

									<!--a href="http://www.itonghui.com/bbs/forumdisplay.php?fid=121" target="_blank"><font style="font-size:13px">问题反馈</font></a><br><br><br-->
								</TD>
							</tr>
						</table>
					</td>
				</TR>
		</TABLE>


		<TABLE class="topmenu" height="30" cellSpacing="0" cellPadding="0"
			width="100%" border="0">
			<TBODY>
				<TR>
					<TD width="79%" align="left">
						&nbsp;&nbsp;&nbsp;
						<img src="images/member_ico.gif" width="14" height="15"
							align="absmiddle">
						<font color="#ffffff">欢迎&nbsp;<%=class_name%>&nbsp; <%=user_name%>
							登录我的商务室 </font>
						<A target="_parent" href="/admin/out.jsp"><font
							color="#ffffff">[退出]</font> </A> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<A target="_blank" href="/admin/help/"><font color="#ffffff">[帮助]</font>
						</A> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					</TD>
					<TD width="21%">
						<img src="images/ppc.gif" align="absmiddle">
						<font color="#ffffff">程序问题反馈：0551-5310317</font>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</body>
</html>



