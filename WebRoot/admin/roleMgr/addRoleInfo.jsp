<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	ArrayList list = bean.getCompareInfoByAttr("45");
	String role_code = comm.GenTradeId();
	String role_types = bean.getItemsBySelected("45","0");
	
	String cust_id = "";
	HttpSession logsession = request.getSession();
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
%>

<html>
	<head>
		<title>添加角色参数</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/role_wind.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RoleInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="JavaScript">
	    function Check_Value()
		{
		    if(document.getElementById("role_name").value==""){
		      alert("角色名称不能为空！");
		      document.getElementById("role_name").focus();
		      return false;
		    }
	 	    return true;
		}
		
	    function check_none(current_obj)
	    {
	        if (current_obj.advshow.checked)
	        {
	      	    current_obj.submit1.disabled=false;        	     
	      	}
	      	else
	      	{
	      	    current_obj.submit1.disabled=true;
	      	}
	  	 }

    	function confirmsub(formobj){
    	    if (Check_Value())
    	        {
    	            formobj.submit();   	
    	        }
    	}
    	function checkRoleName() {    		
    			var code = document.getElementById("role_name").value;
					RoleInfo.ifRoleName(document.getElementById("role_name").value,document.getElementById("setCust").value,getValues);
					return false;
    	}
    	function getValues(data) {
				if(data == "0") {
					alert('角色名称已经存在，请重新输入!');
					document.getElementById("role_name").value = '';
				}else{
					
				}				
			}
     </script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
		<input type="hidden" name="setCust" id="setCust" value="<%=cust_id%>">
		    <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
					<td height="30"></td>
			  </tr>
			  <tr>
					<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>新增角色</b></font></td>
					<td background="/admin/images/content_04.gif" align="right">&nbsp;
					</td>
					<td width="8"><img src="/admin/images/content_06.gif"></td>
			  </tr>
		    </table>
			<table width="800" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td class="u1" width=15%>
									角色名称：
								</td>
								<td width=85% class="u2" colspan="3">
									<div class="ping1">
										<input name="role_name" type="text" id="role_name" size=30 maxlength=30 onblur="checkRoleName()">
										<input type="button" name="show-btn" id="show-btn" value="查看角色" onClick="open('/admin/roleMgr/view_roleList.jsp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')">
										<input name="role_code" id="role_code" type="hidden" value="<%=role_code%>">
										<input name="role_type" id="role_type" type="hidden" value="1">
									</div>
								</td>
							</tr>
							<div id="role_div"></div>
							<input type="hidden" name="role_type" id="role_type" value="1" />
							<tr>
								<td class="u1">
									是否有效：
								</td>
								<td class="u2">
									<div class="ping1">
										<select name="enable_tag" id="enable_tag">
											<option value="0">
												有效
											</option>
											<option value="1">
												无效
											</option>
										</select>
									</div>
								</td>
							</tr>
							
							<tr>
								<td class="u1">备注：
								</td>
								<td class="u2" colspan="3"><div class="ping1">
										<input name="remark" id="remark" type="text" size=50 maxlength="800" />
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1029" />
							<tr>
								<td class="u3" colspan=4>
									<input class="tjan" name="submit1" type="button" value="" onclick="confirmsub(resumeForm)">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




