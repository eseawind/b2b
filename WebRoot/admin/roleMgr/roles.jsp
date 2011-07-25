<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.roleMgr.RoleInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%

   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
   RoleInfo roleObj=new RoleInfo();
   ArrayList roleList =roleObj.getRoleInfoByCustId(cust_id);
   HashMap typeMap=bean.getCompareInfoByCode("CRM","role_type");
%>
<html>
	<head>
		<title>角色管理</title>
	</head>
	<body>

		<table width="350" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
			<tr>
				<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="30%">
					角色名称
				</td>
				<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="30%">
					角色类型
				</td>
				<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="30%">
					当前状态
				</td>
			</tr>
			<%
		            if(roleList != null && roleList.size()>0)
		            {
		              	 for (Iterator it = roleList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String role_name="";
						        String role_type="";
						        String role_code="";
						        String role_state="有效";
						        if(map.get("role_name") != null)
						        {
						           role_name=map.get("role_name").toString();
						        }
						        if(map.get("role_type") != null)
						        {
						           role_type=map.get("role_type").toString();
						           if(typeMap!=null && typeMap.size()>0){
						             role_type=typeMap.get(role_type).toString();
						           }
						        }
						        if(map.get("role_code") != null)
						        {
						           role_code=map.get("role_code").toString();
						        }
						        %>
			<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=cust_id%>" onmouseover="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000; padding:3px 5px;" align=left>
					<%=role_name%>
				</td>
				<td style=" color:#000000;" align=center>
					<%=role_type%>
				</td>
				<td style=" color:#000000;" align=center>
					<%=role_state%>
				</td>

			</tr>
			<%
					     }

		            }
		        %>
		</table>
	</body>
</html>



