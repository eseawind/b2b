<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
    HttpSession htSe=request.getSession();
    String cust_id=(String)htSe.getAttribute("SESSION_CUST_ID");
    String org_id=comm.GenShortTradeId();
    String up_orga_id="000000000000000";
		if(request.getParameter("up_org_id")!=null){
			up_orga_id = request.getParameter("up_org_id");
		}
		ArrayList list=bean.getOrganizeByUpIdList(cust_id,up_orga_id);
		ArrayList custOrgList = bean.getOrgnaizeByCust_id(cust_id);
		String org_idx="";
		if(list !=null && list.size()>0){
		  HashMap map=(HashMap)list.get(0);
		  org_idx=map.get("org_id").toString();
		}

	//取用户名称
	OrganizeInfo organ = new OrganizeInfo();
	String cust_name = organ.getCustNameById(cust_id);
%>

<html>

	<head>

		<title>添加部门单位</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/organizeMgr.js"></script>

	</head>

	<body>

		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="index.jsp">部门管理</a>
				</td>
			</tr>
		</table>
			<table width=100% border="0" cellspacing="0" cellpadding="0" align=center>
				
        <tr>
  	       <td  align="left" bgcolor="white" colspan="5" >
  	         注：如选择上级部门，则新增为所选部门子部门，如不选，则直接新增为当前部门！
           </td>
        </tr>
				<tr>

					<td valign="top">

						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td class="u1">
									上级部门：
								</td>
								<td class="u2">
									<div>
										
										<%
											if(custOrgList!=null){

											String up_org_id="",up_org_name="";
											if(list!=null && list.size()>0){
												for(int i=0;i<list.size();i++){
													HashMap upMap = (HashMap)list.get(i);
													if(upMap.get("org_id")!=null){
														up_org_id = upMap.get("org_id").toString();
													}
													if(upMap.get("org_name")!=null){
														up_org_name = upMap.get("org_name").toString();
													}
													ArrayList downlist=bean.getOrganizeByUpIdList(cust_id,up_org_id);
											%>
												<input type="radio" name="up_org_radio" value="<%=up_org_id%>" onclick="javascript:document.getElementById('up_org_id').value = this.value;">
												<%
													if(downlist!=null && downlist.size()>0){
												%>
												<a href="orgIndex.jsp?up_org_id=<%=up_org_id%>" title="点击进入子部门！"><%=up_org_name%></a>
												<%
													}else{
												%>
													<font color="black"><%=up_org_name%></font>
												<%
													}
												%>
												<br>
											<%
												}
											}
										}else{
										%>
											无部门组织结构！
										
										<%
										}
										%>
									</div>
								</td>
							</tr>

							<tr>

								<td class="u1" width=15%>

									部门名称：
								</td>

								<td width=85% class="u2">
									<div>
										<input name="org_name" type="text" id="org_name" size=30 maxlength=50>
									</div>
								</td>
							</tr>

							<input name="org_id" id="org_id" type="hidden" value="<%=org_id%>">
							<input name="org_type" id="org_type" type="hidden" value="">
							<input name="org_class" id="org_class" type="hidden" value="">
							<input name="up_org_id" id="up_org_id" type="hidden" value="000000000000000">

							<tr>

								<td class="u1">

									部门描述：
								</td>

								<td class="u2">
									<div>
										<textarea name="org_desc" id="org_desc" cols="50" rows="6"></textarea>
									</div>
								</td>
							</tr>

							<tr>

								<td class="u1">

									备注：
								</td>

								<td class="u2">
									<div>
										<input name="remark" id="remark" type="text" size=52 maxlength="50" />
									</div>
								</td>
							</tr>

							<input name="trade_type_code" type="hidden" value="1035" />

							<tr>

								<td class="u3" colspan=2>

									<input class="tjan" name="submit1" type="button" value="" style="width:78px;height:32px;" onclick="confirmsub(resumeForm)">
								</td>

							</tr>
						</table>

					</td>

				</tr>

				<tr>

					<td height="13"></td>

				</tr>

			</table>

		</form>

	</body>

</html>





