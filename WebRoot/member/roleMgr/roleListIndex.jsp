<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.roleMgr.RoleInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
   RoleInfo roleObj=new RoleInfo();
   ArrayList roleList = roleObj.getRoleInfoByCust_id(Integer.valueOf(iStart).intValue(),cust_id);
   
   HashMap typeMap=bean.getCompareInfoByCode("CRM","role_type");
   int counter=roleObj.getRoleCount(cust_id,"0");
   
   
   int pages = ( counter - 1 )/20 + 1;
   int pageUp = 0, pageDown = 0;
   int currenPage = Integer.valueOf( iStart ).intValue();
   if ( pages > currenPage ) 
   {
	  if ( currenPage > 0 ) 
	  {
		pageUp = currenPage - 1;
	  }
	  pageDown = currenPage + 1;
   } 
   else if ( pages == currenPage ) 
   {
	  pageUp = currenPage - 1;
	  pageDown = currenPage;
   }
   
   
   //String toolsBar=tools.getPageTools(String.valueOf(counter),"20","roleListIndex.jsp?iStart=",Integer.parseInt(iStart));
%>

<html>
<head>
<title>角色管理</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
<style>
  .t_head{style="color:#000000;  font-weight:bold; font-size:13px;" }
</style>
		<script type="text/javascript" src="/js/roleMgr.js"></script>
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addRoleInfo.jsp">添加角色</a>
			</tr>
		</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td>
		     <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
		    	<tr class="u4" height="25">
			        <td width="80%">角色名称 </td>
							<td width="10%" align=center>修改 </td>
							<td width="10%" align=center>删除 </td>
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
						           if(null!=typeMap.get(role_type))
						             role_type=typeMap.get(role_type).toString();
						           }
						        }
						        if(map.get("role_code") != null)
						        {
						           role_code=map.get("role_code").toString();
						        }
						        %>
						        <tr class="u2" id="changcolor_tr<%=cust_id%>" onmouseover="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=cust_id%>','','backgroundColor','#ffffff','DIV')">
					            	<td  align=left><%=role_name%></td>
					              <td  align=center>
					                <a href=updateRoleInfo.jsp?role=<%=role_code%>&cust=<%=cust_id%>   onclick="mydefss()"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改角色"></a>&nbsp;&nbsp;&nbsp;
					              </td>
					              <td align=center>  
					                <a href=/doTradeReg.do?cust_id=<%=cust_id%>&trade_type_code=1030&role_code=<%=role_code%> target="_self"  onClick="return roleListchechIfo()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除角色"></a>
					              </td>
					            </tr>
						        <%
					     }
					     %>
					    <tr class="u1">
						  		<td  align="left" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td background="/images/kehu_list_17.gif" align="right" colspan="2"  style=" padding:2px 5px;">
										<a href="roleListIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="roleListIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="roleListIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="roleListIndex.jsp?iStart=<%=pages-1%>">尾页</a></td>			
						</tr>
					   <% }else{%>
						<tr align=center >
							<td colspan="5">暂无记录!</td>
						</tr>
						<%}%>
		    </table>
	     </td>
	  </tr>
	</table>
</body>
</html>


