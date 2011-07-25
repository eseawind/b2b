<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custrightsMgr.RightManage"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	String cust_classs = bean.getSelectItems("14");
	String code = "";
	String cust_class="";
	
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("cust_class") != null) {
		cust_class = request.getParameter("cust_class");
	}

	RightManage relation = new RightManage();
	ArrayList relationList = new ArrayList();
	
	if (code == "0" || code.equals("0")) {
		relationList = relation.genAllrightsByClass(cust_class);
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
		  function checkType(type){
		    if(type!="0"){
		      document.getElementById("code").value="0";
		      document.relationForm.submit();
		    }
		  }
		</script>
	</head>
	
	<body>
		<form name="relationForm" id="relationForm" action="model.jsp" method="post">
			<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
						<td height="30"> </td>
				</tr>
			  <tr>
					<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center"><font size="2"><b>信息发布限制修改</b></font></td>
					<td background="/admin/images/content_04.gif" align="right">&nbsp;
					</td>
					<td width="8"><img src="/admin/images/content_06.gif"></td>
			  </tr>
		  </table-->
		  <input type="hidden" name="code" id="code" value="0">
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
			<tr class="u6">
				<td align="left" colspan="5">
				<div style="margin-left: 12px; margin-top: 5px; margin-bottom: 5px">
					请选择客户级别：
					<select name="cust_class" id="cust_class" class="login_textarea" onchange="checkType(this.value)">
						<option value="0">
							请选择...
						</option>
						<%=cust_classs%>
					</select>
				</div>
			</td>
		</tr>
			<tr class="u4" height="25">
				<td align=left width="30%">
					客户级别
				</td>
				<td align=left width="25%">
					限定类型
				</td>
				<td align=left width="20%">
					限定值
				</td>
				<td align=center width="15%">
					修改
				</td>
			</tr>
			<%
			
			String cust_classly = "",right_codely = "",limit_typely = "";
			if (relationList != null && relationList.size() > 0) {
			for (int i = 0; i < relationList.size(); i++) {
				HashMap map = (HashMap) relationList.get(i);
				String right_code = "",limit_type="",limit_value="",cust_li="";
				String cust_lili="",right_codes="",limit_types="";
				if (map.get("cust_class") != null) {
					cust_li = map.get("cust_class").toString();
					cust_lili  = cust_li;
				}
				
				if (map.get("right_code") != null) {
					right_code = map.get("right_code").toString();
					right_codes = right_code;
				}
				
				if (map.get("limit_type") != null) {
					limit_type = map.get("limit_type").toString();
					limit_types = limit_type;
				}
				if (map.get("limit_value") != null) {
					limit_value = map.get("limit_value").toString();
				}
				
				cust_classly = bean.getParaCode2ByParaCode1("1",cust_li);
				right_codely = bean.getParaCode2ByParaCode1("41",right_code);
				limit_typely = bean.getParaCode2ByParaCode1("106",limit_type);			
			%>
			<tr class="u2" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">
				<td align=left><%=cust_classly%></td>
				<td align=left><%=limit_typely%></td>
				<td align=left><%=limit_value%></td>
				<td align=center>
					<a href="modifyOwn.jsp?cust_class=<%=cust_lili%>&right_code=<%=right_codes%>&limit_type=<%=limit_types%>" TARGET="" onclick="mydefss()"><img src=/images/edit.png width=16 height=16 border=0 style="cursor: hand" alt="修改"></a>
				</td>
			</tr>
			
			<%
				}
				%>
				
				 
				<%}if (relationList == null || relationList.size() < 0) {
			%>
			<tr align=center ><td colspan="6">暂无记录!</td></tr>
			<%}%>
		</table>
		</form>
	</body>
</html>



