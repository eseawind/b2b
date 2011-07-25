<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%
	HttpSession logsession = request.getSession();
	String user_name = "";
	String cust_name = "";
	String login_cust_id = "";
	String cust_class_name = "";
	String user_class = "";
	String depart_name = "";
	TradeInterface inter = new TradeInterface();
	if (logsession.getAttribute("SESSION_USER_NAME") != null) {
		user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
		user_class = logsession.getAttribute("SESSION_CUST_CLASS").toString();
		login_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
		cust_class_name = inter.codeToName("cust_type", user_class);
		cust_name = logsession.getAttribute("SESSION_CUST_NAME").toString();
		cust_name = URLDecoder.decode(cust_name);
		depart_name = inter.comCodetoName("org_name", logsession.getAttribute("DEPART_CODE").toString());
	}
	else {
		response.sendRedirect("/index.jsp");
	}
	String subsys_codenow = "CTR";
	if (request.getParameter("subsys_code") != null) {
		subsys_codenow = request.getParameter("subsys_code");
	}
%>
<script type="text/javascript" src="/js/jquery-1[1].2.1.pack.js"></script>
<script type="text/javascript" src="/js/png/jquery.pngFix.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('div.top-mainnav').pngFix( );
	});
</script>
<tr>
	<td colspan="2" valign="top">
		<div class="top-bj">
			<div class="top-logo">
				<img src="images/logo.png" width="189" height="70" />
			</div>
			<div class="top-logo" style="margin-left:10px">
				 
				<font style="font-size:15px;font-weight:bold;color:gray">中国第一建材贸易平台</font></br>
				<font style="font-size:12px;font-weight:bold;color:gray">Copyright @2007-2008 www.bolibaba.com All rights reserved </font>
			</div>
			<div class="top-mainnav">
				<table border=0>
					<tr>
						<td>
							<table>
								<tr>
									<%
										RightMenu sysright = new RightMenu();
										ArrayList syslist = sysright.genSysServByCust(login_cust_id, user_name);
										int i = 1;
										if (syslist != null) {
											for (Iterator it = syslist.iterator(); it.hasNext();) {
												HashMap sysInfo = (HashMap) it.next();
												String sysname = "";
												String syscode = "";
												if (sysInfo.get("para_code1") != null)
											      syscode = sysInfo.get("para_code1").toString();
												if (sysInfo.get("para_code2") != null)
											      sysname = sysInfo.get("para_code2").toString();
										    if (!user_name.equals("admin") && !sysname.equals("框架系统")) {
									%>
<td>
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<a href="/main.jsp?subsys_code=<%=syscode%>" title="<%=sysname%>"><img src="/admin/images/<%=syscode%>.png" border="0" />
													</a>
												</td>
											</tr>
											<tr>
												<td align="center">
													<a href="/main.jsp?subsys_code=<%=syscode%>" title="<%=sysname%>">
													<%
													 if (subsys_codenow.equals(syscode)) {
													 %> <font style="font-size:13px;color:#065706;font-weight:bold; "><%=sysname%>
																										</font> <%
													 		}
													 		else {
													 %> <font style="font-size:13px"><%=sysname%>
																										</font> <%
													 }
													 %> </a>
												</td>
											</tr>
										</table>
									</td>
									 
									<%
												}
												else if (user_name.equals("admin")) {
									%>

									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<a href="/main.jsp?subsys_code=<%=syscode%>" title="<%=sysname%>"><img src="/admin/images/<%=syscode%>.png" border="0" />
													</a>
												</td>
											</tr>
											<tr>
												<td align="center">
													<a href="/main.jsp?subsys_code=<%=syscode%>" title="<%=sysname%>">
													<%
													 if (subsys_codenow.equals(syscode)) {
													 %> <font style="font-size:13px;color:#065706;font-weight:bold; "><%=sysname%>
																										</font> <%
													 		}
													 		else {
													 %> <font style="font-size:13px"><%=sysname%>
																										</font> <%
													 }
													 %> </a>
												</td>
											</tr>
										</table>
									</td>
									<%
												}
												i = i + 1;
											}
											
										}
									%>
									
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</td>
</tr>




