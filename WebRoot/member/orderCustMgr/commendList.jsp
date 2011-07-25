<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.roleMgr.RoleInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr"
	scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools"
	scope="page" />
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="com.saas.biz.infoListMgr.*"%>
<%
	request.setCharacterEncoding("gbk");
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String User_name = "";

	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("User_name") != null) {
		User_name = request.getParameter("User_name");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	ResumeInfo resumeinfo = new ResumeInfo();
	ArrayList resumeList = new ArrayList();
	int counter = 0;
	if (request.getParameter("User_name") != null) {
		resumeList = resumeinfo.getAllNewResumeByLikeName(Integer
				.parseInt(iStart), 20, User_name);
		counter = resumeinfo.getAllNewResumeByLikeName(User_name);
	} else {
		resumeList = resumeinfo.getAllNewResumeByList(Integer
				.parseInt(iStart), 20);
		counter = resumeinfo.getAllNewResumeByList();
	}
	String toolsBar = tools.getPageTools(String.valueOf(counter), "20",
			"commendList.jsp?User_name=" + User_name + "iStart=",
			Integer.parseInt(iStart));
%>

<html>
	<head>
		<title>人才推荐</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style>
.t_head {
	style ="color: #000000;
	font-weight: bold;
	font-size: 13px;
	"
}
</style>
		<script type="text/javascript" src="/js/roleMgr.js"></script>
		<script language="javascript">
			function checkSub(){
				if(document.getElementById('name').value==''){
					alert('请输入姓名作为查询条件!');
					return false;
				}
		document.commForm.submit();
	}
</script>
	</head>
	<body>
		<center>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<form action="commendList.jsp" method="post" name="commForm">
							<table width="100%" border=0 cellpadding=1 cellspacing=1
								align=center bgcolor="#FCB0B0">
								<tr class="u4" height="25">
									<td align="left">
										&nbsp;输入姓名:&nbsp;
										<input type="text" width="20%" name="User_name" id="name"
											size="20" maxlength="20" />
										&nbsp;
										<img src="/admin/images/chaxun.gif" border="0"
											onclick="javascript: return checkSub();"
											style="cursor: hand;">
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border=0 cellpadding=1 cellspacing=1
							align=left bgcolor="#FCB0B0">
							<tr class="u4" height="25">
								<td width="15%">
									真实姓名
								</td>
								<td align="left" width="10%">
									年龄
								</td>
								<td align="left" width="20%">
									专业
								</td>
								<td align="left" width="20%">
									学历
								</td>
								<td align="left" width="15%">
									联系电话
								</td>
								<td align="center" width="15%">
									推荐
								</td>
							</tr>
							<%
								InfoList infoList = new InfoList();
								ArrayList arrayinfolist = new ArrayList();
								String contents = "";

								if (resumeList != null && resumeList.size() > 0) {
									for (Iterator it = resumeList.iterator(); it.hasNext();) {
										HashMap map = (HashMap) it.next();
										String resume_id = "";
										String name = "";
										String born_date = "";
										String age = "";
										String degree = "";
										String position = "";
										String grad_from = "";
										String work_history = "";
										String tel = "";
										String profession = "";

										if (map.get("name") != null) {
											name = map.get("name").toString();
										}
										if (map.get("info_id") != null) {
											resume_id = map.get("info_id").toString();
											arrayinfolist = infoList.getInfoListById(resume_id);
											if (arrayinfolist != null && arrayinfolist.size() > 0) {
												HashMap contMap = (HashMap) arrayinfolist.get(0);
												if (contMap.get("contents") != null) {
													contents = contMap.get("contents").toString();
												}
											}
										}
										if (map.get("born_date") != null) {
											born_date = map.get("born_date").toString();
										}
										if (born_date.length() > 10) {
											born_date = born_date.substring(0, 10);
										}
										if (map.get("age") != null) {
											age = map.get("age").toString();
										}
										if (map.get("degree") != null) {
											degree = map.get("degree").toString();
											degree = bean.getParamNameByValue("39", degree);
										}
										if (map.get("position") != null) {
											position = map.get("position").toString();
										}
										if (map.get("grad_from") != null) {
											grad_from = map.get("grad_from").toString();
										}
										if (map.get("tel") != null) {
											tel = map.get("tel").toString();
										}
										if (map.get("profession") != null) {
											profession = map.get("profession").toString();
										}
										String url = "/default/job/d/content-" + resume_id
												+ ".html";
							%>
							<tr class="u2" id="changcolor_tr<%=cust_id%>"
								onmouseover="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')"
								onmouseout="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')">
								<td align=left>
									<a href="seeone.jsp?resume_id=<%=resume_id%>"><%=name%></a>
								</td>
								<td align=left><%=age%></td>
								<td align=left><%=profession%></td>
								<td align=left>
									<%=degree%></td>
								<td align=left>
									<%=tel%>
								</td>
								<%
									if (contents.length() > 1
													&& contents.substring(0, 1).equals("1")) {
								%>
								<td style="color: #000000;" align=center>
									已推荐&nbsp;
									<font color="red">[<a
										href="/doTradeReg.do?contents=00&cust_id=<%=resume_id%>&trade_type_code=9007"
										target="_self">取消</a>]</font>
								</td>
								<%
									} else {
								%>
								<td align=center>
									<a href=/doTradeReg.do?cust_id=
										<%=resume_id%>&trade_type_code=2323> <img
											src=/images/edit.gif width=16 height=16 border=0 alt="人才推荐">
									</a> &nbsp;&nbsp;&nbsp;
								</td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr class="u1">
								<%=toolsBar%>
							</tr>
							<%
								}
							%>
						</table>
					</td>
				</tr>
				<table>
					<tr>
						<td>
							<%
								if (resumeList == null || resumeList.size() <= 0) {
							%>
							没有您所要查询的人才信息
							<%
								}
							%>
						</td>
					</tr>
				</table>
			</table>
		</center>
	</body>
</html>


