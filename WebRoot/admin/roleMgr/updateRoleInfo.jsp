<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="role" class="com.saas.biz.roleMgr.RoleInfo" scope="page" />
<%
	String cust_id = "", role_code = "", role_name = "", remark = "", role_type = "",role_types="";
	cust_id = request.getParameter("cust");
	role_code = request.getParameter("role");
	ArrayList roleList = role.getRoleInfoByCode(cust_id, role_code);
	if (roleList != null && roleList.size() > 0) {
		HashMap roleMap = (HashMap) roleList.get(0);
		role_name = roleMap.get("role_name").toString();
		remark = roleMap.get("remark").toString();
		role_type = roleMap.get("role_type").toString();
	    role_types = bean.getItemsBySelected("45",role_type);
	}
%>
<html>
	<head>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<title>角色管理</title>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="JavaScript">
	    function Check_Value()
		{
		    var role_name=$F("role_name");
		    role_name=delAllSpace(role_name);
		    if(role_name==""|| role_name==null){
		      alert("角色名称不能为空！");
		      $("role_name").focus();
		      return false;
		    }
	 	    return true;
		}
   
    	function confirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {  	    	
    	        if (Check_Value())
    	        {
    	            formobj.submit();   	
    	        }
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
	  //删除所有空格
	 function delAllSpace(str) {
		return str.replace(/^\s+|\s+$/g, "")
	 }
</script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
		
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>修改角色名称</b></font></td>
				<td background="/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>

			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">				
				<tr>
					<td valign="top">
						<table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
						    
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right width=15%>
									角色名称
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width=85%>
									<div>
										<input name="role_name" type="text" id="role_name" size=20 maxlength=30 value="<%=role_name%>">
									</div>
								</td>
							</tr>
							<tr style="display:none">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
									角色代码
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<input name="role_code" id="role_code" type="text" size=30 maxlength=15 value="<%=role_code%>" readonly>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
									角色类型
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<select name="role_type" id="role_type">
										<%=role_types%>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
									是否有效
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<select name="enable_tag" id="enable_tag">
										<option value="0">
											有效
										</option>
										<option value="1">
											无效
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
									备注
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<input name="remark" id="remark" type="text" size=30 maxlength="500" value="<%=remark%>" />
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1031" />
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
									<input name="submit1" class="tjan" type="button" value="" onclick="confirmsub(resumeForm)">
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



