<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="role" class="com.saas.biz.roleMgr.RoleInfo" scope="page" />
<%
	String cust_id="";
	Calendar cal = Calendar.getInstance();
    String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    cal.add(Calendar.MONTH, 3);
    String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    HttpSession sess=request.getSession();
    if(sess.getAttribute("SESSION_CUST_ID")!=null){
      cust_id=(String)sess.getAttribute("SESSION_CUST_ID");
    }
    ArrayList roleList=role.getRoleInfoByCustId(cust_id);
%>
<html>
<head>
<title>角色权限回收</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RightMenu.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type="text/javascript" src="/js/roleRightMgr.js"></script>
</head>
<body>
<form name=resumeForm action=/doTradeReg.do method=post target="_blank">
  <%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
			top_menu_id = request.getParameter("menu_id");
		}
  %>
   <jsp:include page="/inc/jspTop.jsp">
	 	<jsp:param name="menu_id" value="<%=top_menu_id%>" />
   </jsp:include>
  <table width=800 border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td valign="top">
	  <table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
          <tr>
            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width=15%> 角色名称：</td>
            <td width=85% align=left bgcolor="#FFFFFF">
			<div>
                <select name="role_code" id="role_code" onclick="initMenu(this.value);">
                  <option value="0">请选择...</option>
                  <%
                        if(roleList!=null && roleList.size()>0)
						{
						   for(int i=0;i<roleList.size();i++)
						   {
							 HashMap map=(HashMap)roleList.get(i);
							 String id=map.get("role_code").toString();
							 String name=map.get("role_name").toString();
				  %>
                  <option value="<%=id%>"><%=name%></option>
                  <%
						   }
						 }
				  %>
                </select>
              </div></td>
          </tr>
          <tr>
            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right> 菜单名称： </td>
            <td align=left bgcolor="#FFFFFF">
			   <div>
                <select name="sort1" id="sort1" size="10" style="width: 110px;float: left" onclick="setMenu2Info(this.value);">
                  <option value="0">请选角色...</option>
                </select>
                <select name="sort2" id="sort2" size="10" style="display:none;width: 110px;float: left" onclick="setMenu3Info(this.value);">
                </select>
                <select name="sort3" id="sort3" size="10" style="display:none;width: 110px;float: left" onclick="setMenuID(this.value);">
                </select>
              </div>
			</td>
          </tr>
          <input name="trade_type_code" type="hidden" value="1039"/>
          <input name="menu_id" id="menu_id" type="hidden" value=""/>
          <input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>"/>
          <tr>
            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
			<input class="hsan" name="submit1" type="button" value="" disabled="true" onclick="confirmsub(resumeForm)">
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




