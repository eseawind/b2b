<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr"
	scope="page" />
<%
	String resume_id = "";
	if (request.getParameter("resume_id") != null) {
		resume_id = request.getParameter("resume_id");
	}
	ResumeInfo res = new ResumeInfo();
	ArrayList list = res.genOneByResumeId(resume_id);
	String name = "", age = "", work_history = "", spec = "", wish = "", born_date = "", born_site = "", grad_from = "";
	String profession = "", update_date = "", phone = "", email = "", tel = "", job_age = "", grad_date = "", addr = "";
	String position = "", degree = "";
	if (list != null) {
		HashMap map = (HashMap) list.get(0);
		if (map.get("degree") != null) {
			degree = map.get("degree").toString();
			degree = bean.getParamNameByValue("39", degree);
		}
		if (map.get("name") != null) {
			name = map.get("name").toString();
		}
		if (map.get("age") != null) {
			age = map.get("age").toString();
		}
		if (map.get("work_history") != null) {
			work_history = map.get("work_history").toString();
		}
		if (map.get("spec") != null) {
			spec = map.get("spec").toString();
		}
		if (map.get("wish") != null) {
			wish = map.get("wish").toString();
		}
		if (map.get("born_date") != null) {
			born_date = map.get("born_date").toString();
			born_date = born_date.substring(0, 10);
		}
		if (map.get("born_site") != null) {
			born_site = map.get("born_site").toString();
		}
		if (map.get("grad_from") != null) {
			grad_from = map.get("grad_from").toString();
		}
		if (map.get("profession") != null) {
			profession = map.get("profession").toString();
		}
		if (map.get("update_date") != null) {
			update_date = map.get("update_date").toString();
		}
		if (map.get("phone") != null) {
			phone = map.get("phone").toString();
		}
		if (map.get("email") != null) {
			email = map.get("email").toString();
		}
		if (map.get("tel") != null) {
			tel = map.get("tel").toString();
		}
		if (map.get("job_age") != null) {
			job_age = map.get("job_age").toString();
		}
		if (map.get("addr") != null) {
			addr = map.get("addr").toString();
		}
		if (map.get("position") != null) {
			position = map.get("position").toString();
		}
		if (map.get("grad_date") != null) {
			grad_date = map.get("grad_date").toString();
			grad_date = grad_date.substring(0, 10);
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
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center
			bgcolor="#dddddd">
			<tr>
				<td class="u1" width="15%">
					欲求职位
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%" colspan=3>
					<%=position%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					求职描述
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%" colspan=3>
					<%=spec%>
				</td>
			</tr>

			<tr>
				<td class="u1" width="15%">
					姓名
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=name%>
				</td>
				<td class="u1" width="15%">
					出生日期
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=born_date%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					年龄
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=age%>
				</td>
				<td class="u1" width="15%">
					期望工资
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=wish%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					学历
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=degree%>
				</td>
				<td class="u1" width="15%">
					专业
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=profession%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					工作经验
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=work_history%>
				</td>
				<td class="u1" width="15%">
					毕业学校
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=grad_from%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					工作年限
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=job_age%>
				</td>
				<td class="u1" width="15%">
					毕业时间
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=grad_date%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					电话
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=tel%>
				</td>
				<td class="u1" width="15%">
					邮箱
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=email%>
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					手机
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=leftcolspan="3"">
					<%=phone%>
				</td>
				<td class="u1" width="15%">
					联系地址
				</td>
				<td
					style="background-color: #ffffff; color: #000000; font-size: 12px;"
					align=left width="35%">
					<%=addr%>
				</td>
			</tr>




			<tr>
				<td height="30" colspan="4" align="center"
					style="background-color: #ffffff; color: #000000; font-size: 12px;">
					<!-- a href="talentsList.jsp" -->
					<img src="/admin/images/comeback.JPG"
						onclick="javascript:history.go(-1)"
						style="border: 0; cursor: hand; text-align: center;">
				</td>
			</tr>
		</table>
	</body>

</html>



