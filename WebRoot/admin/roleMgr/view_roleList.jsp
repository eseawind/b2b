<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.roleMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>查看角色</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/role_wind.js"></script>
		<%
			String cust_id = "";
			HttpSession logsession = request.getSession();
			if(logsession.getAttribute("SESSION_CUST_ID")!=null)
			{
				cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();			
			}
		%>
	</head>
	<body>			
		<%
			String iStart = "1";
			if (request.getParameter("iStart") != null) 
			{
        		iStart = request.getParameter("iStart");
  	  		}
  	  		int counter = 0; 
  	  		RoleInfo roleInfo = new RoleInfo();
			ArrayList list = new ArrayList();
			list = roleInfo.getRoleAll(Integer.parseInt(iStart),cust_id); 	
			counter = roleInfo.getRoleAll(cust_id);			
			  
  	  		String toolsBar=tools.getPageTools(String.valueOf(counter),"20","view_roleList.jsp?iStart=",Integer.parseInt(iStart));
		%>
		 
		<table  width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="">
			<tr  class="u4" height="25">
				<td  background="/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="40%">角色名称</td>
				<td  background="/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="40%">当前状态</td>
			</tr>
		<%
			String name = "";
			String role_state="";
			if(list != null && list.size()>0) 
			{
				for(int i=0; i<list.size(); i++) 
				{
					HashMap map = (HashMap)list.get(i);
					if(map.get("role_name") != null) 
					{
						name = map.get("role_name").toString();						
					}
					if(map.get("enable_tag") != null) 
					{
						role_state = map.get("enable_tag").toString();
						if( role_state.equals("0") )
						{
							role_state = "有效";
						}
						else
						{
							role_state = "无效";
						}						
					}
					
		%>
			<tr class="u2">
				<td style=" color:#000000; padding:3px 5px;" align=center><%=name%></td>
				<td style=" color:#000000; padding:3px 5px;" align=center><%=role_state%></td>
			</tr>	
		<%			
					 
				}
			}
		%>	
		
	</table>
	 <table  width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="">
	 <tr align="center"><%=toolsBar%></tr>
	 </table> 
	  
	</body>
</html>




