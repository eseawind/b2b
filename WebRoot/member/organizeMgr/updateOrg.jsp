<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
    HttpSession htSe=request.getSession();
    String cust_id=(String)htSe.getAttribute("SESSION_CUST_ID");
    String org_id="";
    if(request.getParameter("org_id")!=null){
    	org_id = request.getParameter("org_id");
    }
    
    ArrayList orgList = bean.getOrgnaizeByOrg_id(org_id);
    String org_name="",org_desc="",remark="";
    if(orgList!=null && orgList.size()>0){
    	HashMap orgMap = (HashMap)orgList.get(0);
    	if(orgMap.get("org_name")!=null){
    		org_name = orgMap.get("org_name").toString();
    	}
    	if(orgMap.get("org_desc")!=null){
    		org_desc = orgMap.get("org_desc").toString();
    	}
    	if(orgMap.get("remark")!=null){
    		remark = orgMap.get("remark").toString();
    	}
    }

%>

<html>

	<head>

		<title>修改部门</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/organizeMgr.js"></script>
		<script language="JavaScript">
			function 	checkUp(){
					if(document.getElementById('org_name').value=='' || document.getElementById('org_name').value==null){
							alert('部门名称不能为空！');
							return false;
					}
			}
		</script>
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
			<table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
        	
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td class="u1" width=15%>
									部门名称：
								</td>
								<td width=85% class="u2">
									<div>
										<input name="org_name" type="text" id="org_name" size=30 maxlength=50 value="<%=org_name%>">
									</div>
								</td>
							</tr>
							<input name="org_id" id="org_id" type="hidden" value="<%=org_id%>">
							<tr>
								<td class="u1">
									部门描述：
								</td>
								<td class="u2">
									<div>
										<textarea name="org_desc" id="org_desc" cols="50" rows="6"><%=org_desc%></textarea>
									</div>
								</td>
							</tr>

							<tr>

								<td class="u1">

									备注：
								</td>

								<td class="u2">
									<div class="ping1">
										<input name="remark" id="remark" type="text" size=52 maxlength="50" value="<%=remark%>"/>
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1036" />
							<tr>
								<td class="u3" colspan=2>
									<input class="xgan" name="submit1" type="submit" value="" style="width:78px;height:32px;" onclick="return checkUp()">
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





