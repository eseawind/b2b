<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.advertiseMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	String fbtime = new SimpleDateFormat("yyyy-MM-dd")
			.format(new Date());
	String resume_id = "", userName = "", grad_from = "", profession = "", wish = "", born_date = fbtime, born_site = "", phone = "", email = "", addr = "", position = "", age = "", job_age = "", grad_date = fbtime, work_history = "", spec = "", tel = "";
	String sex = "", degree = "", cert = "", cust_name = "", cust_id = "";
	HttpSession logsessionres = request.getSession();
	String userIdx = "";
	if (logsessionres.getAttribute("SESSION_USER_ID") != null) {
		userIdx = logsessionres.getAttribute("SESSION_USER_ID")
				.toString();
		userName = logsessionres.getAttribute("SESSION_USER_NAME")
				.toString();
	}
	if (logsessionres.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsessionres.getAttribute("SESSION_CUST_ID")
				.toString();
		ArrayList list = new ArrayList();
		list = new Custinfo().getCustInfo(cust_id);
		if (list != null && list.size() > 0) {
			HashMap map1 = (HashMap) list.get(0);
			if (map1.get("cust_name") != null) {
				cust_name = map1.get("cust_name").toString();
			}
		}
	}
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList degreeList = paramCom.getCompareInfo("CRM", "degree");
	ArrayList sexList = paramCom.getCompareInfo("CRM", "sex");
	ArrayList certList = paramCom.getCompareInfo("CRM", "cert");
	ArrayList resumeLists = resume.genResumeByUser_Id(userIdx);

	if (resumeLists != null && resumeLists.size() > 0)

	{

		HashMap map = (HashMap) resumeLists.get(0);

		resume_id = map.get("resume_id").toString();

		if (map.get("grad_from") != null) {
			grad_from = map.get("grad_from").toString();
		}
		if (map.get("profession") != null) {
			profession = map.get("profession").toString();
		}
		if (map.get("wish") != null) {
			wish = map.get("wish").toString();
		}
		if (map.get("born_site") != null) {
			born_site = map.get("born_site").toString();
		}
		if (map.get("born_date") != null) {
			born_date = map.get("born_date").toString();
			if (born_date.length() > 10) {
				born_date = born_date.substring(0, 10);
			}
		}
		if (map.get("phone") != null) {
			phone = map.get("phone").toString();
		}
		if (map.get("email") != null) {
			email = map.get("email").toString();
		}
		if (map.get("addr") != null) {
			addr = map.get("addr").toString();
		}
		if (map.get("position") != null) {
			position = map.get("position").toString();
		}
		if (map.get("age") != null) {
			age = map.get("age").toString();
		}
		if (map.get("job_age") != null) {
			job_age = map.get("job_age").toString();
		}
		if (map.get("grad_date") != null) {
			grad_date = map.get("grad_date").toString();
			if (grad_date.length() > 10) {
				grad_date = grad_date.substring(0, 10);
			}
		}
		if (map.get("work_history") != null) {
			work_history = map.get("work_history").toString();
		}
		if (map.get("spec") != null) {
			spec = map.get("spec").toString();
		}
		if (map.get("tel") != null) {
			tel = map.get("tel").toString();
		}
		if (map.get("remark") != null) {
			sex = map.get("remark").toString();
		}
		if (map.get("degree") != null) {
			degree = map.get("degree").toString();
		}
		if (map.get("cert") != null) {
			cert = map.get("cert").toString();
		}
	}
%>

<html>

	<head>

		<title>B2B电子商务后台管理系统</title>

		<link href="/style/layout.css" rel="stylesheet" type="text/css">

		<script language="javascript" src="/js/Calendar_Ly.js"></script>

		<script src="/www/fuction/calendar.js" type="text/javascript"></script>

		<script language="JavaScript" src="/www/fuction/public.js"></script>

		<script language="JavaScript" src="/js/hrResumeMgr.js"></script>

	</head>

	<body>
		<%
			String top_menu_id = "";
			if (request.getParameter("menu_id") != null) {
				top_menu_id = request.getParameter("menu_id");
			}
		%>


		<table width=100% border="0" cellspacing="0" cellpadding="0">


			<tr>

				<td valign="top">
					<form name=resumeForm action=/doTradeReg.do method=post
						onsubmit="return updateResumeInfoconfirmsub()">
						<table width=100% border=0 cellpadding=1 cellspacing=1
							align=center bgcolor="#DEEDFD">


							<tr class="u4" height="25">
								<td colspan="4" align="left">
									&nbsp;&nbsp;
									<img src="/admin/images/newbt.gif" align="absmiddle">
									&nbsp;&nbsp;
									<font size="2"><b>简历基本信息</b>
									</font>
								</td>
							</tr>


							<tr>

								<td class="u1" width="20%">
									姓名：

									<input name="resume_id" type="hidden" value=<%=resume_id%>>
								</td>

								<td class="u2" width="30%">
									<input name="name" type="text" value="<%=cust_name%>">

								</td>
								<td class="u1" width="20%">
									毕业学校：
								</td>

								<td class="u2" width="30%">
									<input name="grad_from" type="text" value="<%=grad_from%>">

								</td>

							</tr>
							<tr>

								<td class="u1">
									专业：
								</td>

								<td class="u2">
									<input name="profession" type="text" value="<%=profession%>">

								</td>

								<td class="u1">
									期望薪资：
								</td>

								<td class="u2">
									<input name="wish" type="text" value="<%=wish%>"
										onKeyUp="if(isNaN(value))execCommand('undo')">

								</td>

							</tr>

							<tr>

								<td class="u1">
									出生年月：
								</td>

								<td class="u2">
									<input name="born_date" id="born_date" readonly type="text"
										size=10 value="<%=born_date%>" onfocus="setday(this);"
										style="width: 93px">
									(四位年-二位月-二位日)
								</td>
								<td class="u1">
									籍贯：
								</td>

								<td class="u2">
									<input name="born_site" type="text" value="<%=born_site%>">

								</td>
							</tr>
							<tr class="u4" height="25">
								<td colspan="4" align="left">
									&nbsp;&nbsp;
									<img src="/admin/images/newbt.gif" align="absmiddle">
									&nbsp;&nbsp;
									<font size="2"><b>简历详细信息</b>
									</font>
								</td>
							</tr>


							<tr>

								<td class="u1">
									联系电话：
								</td>

								<td class="u2">
									<input name="phone" type="text" value="<%=phone%>">

								</td>
								<td class="u1">
									电子邮件：
								</td>

								<td class="u2">
									<input name="email" type="text" value="<%=email%>">

								</td>

							</tr>

							<tr>

								<td class="u1">
									固定电话：
								</td>

								<td class="u2">
									<input name="tel" type="text" value="<%=tel%>">

								</td>
								<td class="u1">
									联系地址：
								</td>

								<td class="u2">
									<input name="addr" type="text" value="<%=addr%>">

								</td>

							</tr>

							<tr>

								<td class="u1">
									当前职位：
								</td>

								<td class="u2">
									<input name="position" type="text" value="<%=position%>">

								</td>
								<td class="u1">
									年龄：
								</td>

								<td class="u2">
									<input name="age" type="text" value="<%=age%>"
										onkeyup="if(isNaN(value))execCommand('undo')">

								</td>


							</tr>

							<tr>

								<td class="u1">
									性别：
								</td>

								<td class="u2">

									<select name=remark>

										<%
											if (sexList != null && sexList.size() > 0)

											{

												for (int i = 0; i < sexList.size(); i++)

												{

													HashMap map = (HashMap) sexList.get(i);

													String value = map.get("para_code1").toString();

													String name = map.get("para_code2").toString();

													if (sex.equals(value)) {
										%>
										<option value="<%=value%>" selected=selected><%=name%></option>
										<%
											} else {
										%>

										<option value="<%=value%>"><%=name%></option>

										<%
											}
												}

											}
										%>

									</select>
								</td>
								<td class="u1">
									学历：
								</td>

								<td class="u2">
									<select name=degree>

										<%
											if (degreeList != null && degreeList.size() > 0)

											{

												for (int i = 0; i < degreeList.size(); i++)

												{

													HashMap map = (HashMap) degreeList.get(i);

													String value = map.get("para_code1").toString();

													String name = map.get("para_code2").toString();
													if (degree.equals(value)) {
										%>
										<option value="<%=value%>" selected=selected><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=value%>"><%=name%></option>
										<%
											}
										%>
										<%
											}

											}
										%>

									</select>

								</td>


							</tr>


							<tr>

								<td class="u1">
									工作年限：
								</td>

								<td class="u2">
									<input name="job_age" type="text" value="<%=job_age%>"
										onkeyup="if(isNaN(value))execCommand('undo')">

								</td>
								<td class="u1">
									毕业年份：
								</td>

								<td class="u2">
									<input name="grad_date" id="grad_date" readonly type="text"
										size=10 value="<%=grad_date%>" onfocus="setday(this);"
										style="width: 93px">
									(四位年-二位月-二位日)
								</td>


							</tr>


							<tr>

								<td class="u1">
									工作经历：
								</td>

								<td class="u2" colspan="3">
									<textarea name="work_history" style="display: none"><%=work_history%></textarea>

									<iframe ID=work_history
										src=/www/ewebeditor/ewebeditor.htm?id=work_history&style=coolblue&root_id=
										<%=resume_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
								</td>

							</tr>

							<tr>

								<td class="u1">
									求职描述：
								</td>

								<td class="u2" colspan="3">
									<textarea name="spec" style="display: none"><%=spec%></textarea>

									<iframe ID=spec
										src=/www/ewebeditor/ewebeditor.htm?id=spec&style=coolblue&root_id=
										<%=resume_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
								</td>

							</tr>

							<input name="trade_type_code" type="hidden" value="0341">

							<tr>

								<td class="u1" align="left">
									所获证书：
								</td>

								<td class="u2" colspan="3">
									<select name="cert">

										<%
											if (certList != null && certList.size() > 0)

											{

												for (int i = 0; i < certList.size(); i++)

												{

													HashMap map = (HashMap) certList.get(i);

													String value = map.get("para_code1").toString();

													String name = map.get("para_code2").toString();
													if (cert.equals(value)) {
										%>
										<option value="<%=value%>" selected=selected><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=value%>"><%=name%></option>
										<%
											}
												}
											}
										%>

									</select>

								</td>

							</tr>

							<tr>

								<td class="u3" colspan=4>
									<input class="tjan" name="submit1" type="submit" value=""
										onClick="alert("ddd");">

								</td>

							</tr>


						</table>
					</form>
				</td>

			</tr>

			<tr>

				<td height="13"></td>

			</tr>

		</table>

	</body>

</html>





