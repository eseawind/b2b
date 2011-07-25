<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.addproductattrMgr.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	//String class_type=bean.getSelectItems("64");
	String class_id=comm.GenTradeId();
	HttpSession httpSess=request.getSession();
	String cust_id=(String)httpSess.getAttribute("SESSION_CUST_ID");
	String attr_id="";
	if(request.getParameter("attr_id")!=null){
		attr_id = request.getParameter("attr_id");
	}
	AddProductAttrInfo addInfo = new AddProductAttrInfo();
	HashMap map = addInfo.getattrById(cust_id,attr_id);
	String attr_name = "",attr_no = "",default_value = "",attr_desc = "",remark="";
	if(map.get("attr_name")!=null){attr_name=map.get("attr_name").toString();}
	if(map.get("attr_no")!=null){attr_no=map.get("attr_no").toString();}
	if(map.get("default_value")!=null){default_value=map.get("default_value").toString();}
	if(map.get("attr_desc")!=null){attr_desc=map.get("attr_desc").toString();}
	if(map.get("remark")!=null){remark=map.get("remark").toString();}
%>
<html>
	<head>
		<title>产品属性修改</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="../../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext/ext-all.js"></script>
		<script type="text/javascript" src="modichannal.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script> 
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='/js/addProductattrInfoMgr.js'></script>
	</head>
	<body>
		<form name=productForm method=post action=/doTradeReg.do target="_self">
			<table width="100%" border="0" cellspacing="1" cellpadding="1" align="center" >
				<tr class="u1">
					<td align="left" class="head">
						<a href="modiproductattrIndex.jsp">产品规格管理</a>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
		
				<tr>
					<td align="right" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"> 
						规格名称： 
					</td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;" colspan="3">
						<div class="ping">
							<input name="attr_name" type="text" id="attr_name" size=30 maxlength=50 value="<%=attr_name%>">
						</div>
					</td>
				</tr>
				<tr>
					
					<input name="attr_no" type="hidden" id="attr_no" value="<%=attr_no%>" >

					<td align="right" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
						默认值：
					</td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;" colspan="3">
						<div class="ping1">
							<input name="default_value" type="text" id="default_value" value="<%=default_value%>">
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" align="right" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
							描述 ：
				   </td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;" colspan="3">
						<div class="ping1">
						  <textarea name="attr_desc" cols="50" rows="6" id="attr_desc"><%=attr_desc%></textarea>
						</div>
				  </td>
				</tr>
				<input type="hidden" name="remark" id="remark" size="50" value="<%=remark%>"/>
				<input type="hidden" name="trade_type_code" value="1224"/>
				<input name="attr_id" id="attr_id" type="hidden" value="<%=attr_id%>"/>
				<tr>
					<td height="30" align="center" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;" colspan="4">
						<input name="comit" type="submit" value="" onclick="return modiattrCheck_Value()" style="background-image: url('/admin/images/xg.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" name="" class="comeback" value="" onclick="javascript:window.location.href='/member/addProductattrInfoMgr/modiproductattrIndex.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>







