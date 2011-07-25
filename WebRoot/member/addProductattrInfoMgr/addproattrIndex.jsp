<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="proInfo" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	//String class_type=bean.getSelectItems("64");
	String attr_id = comm.GenTradeId();
	HttpSession httpSess = request.getSession();
	String cust_id = (String) httpSess.getAttribute("SESSION_CUST_ID");
	
		String up_id="000000000000000";
	if(request.getParameter("up_class_id") != null){
		up_id=request.getParameter("up_class_id").toString();
	}
	ArrayList json = proInfo.getproductByUpId(cust_id, up_id);
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="channal.js"></script>
		<script type='text/javascript' src='/js/addProductattrInfoMgr.js'></script>
	</head>
	<body>
		<form name=productForm method=post action=/doTradeReg.do target="_self">
			<table width="100%" border="0" cellspacing="1" cellpadding="1" align="center" >
				<tr class="u1">
					<td align="left">
						<a href="modiproductattrIndex.jsp">产品规格管理</a>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<table width=800 border=0 cellpadding=1 cellspacing=1 align= bgcolor="#DEEDFD">
							<tr>
								<td class="u1" width="15%">
									产品型号选择：
								</td>
								<td class="u2" width="85%">
								<!--	<div class="ping1">
										<div id="tree-div"></div>
									</div>-->
										<table align="left" width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="20%" align="center" >选择型号</td>
								<td width="20%" align="center" >型号名称</td>
								<td width="40%" align="center" >型号描述</td>
							</tr>
							<%
								if(json!=null && json.size()>0){
								HashMap map=null;
									for(int i=0;i<json.size();i++){
									String class_name="";
									String class_id_up="";
									String class_desc="";
									String enable_tag="";
									ArrayList list=null;
					           map=(HashMap)json.get(i);
					           if(map.get("class_name")!=null){
					          	 class_name=map.get("class_name").toString();
					           }
					           if(map.get("class_id")!=null){
					          	 class_id_up=map.get("class_id").toString();
					          	 list = proInfo.getproductByUpId(cust_id, class_id_up);
					           }
					           if(map.get("class_desc")!=null){
					          	 class_desc=map.get("class_desc").toString();
					          	 if(class_desc.equals("")){
					          	 		class_desc="无";
					          	 }
					           }
					           if(map.get("enable_tag")!=null){
					          	 enable_tag=map.get("enable_tag").toString();
					          	 if(enable_tag.equals("0")){
					          	 		enable_tag="有效";
					          	 }else{
					          	 		enable_tag="无效";
					          	 	}
					           }
					           %>
					           <tr>
					      <td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<input type="radio" id="radio" name="up_class_id" value="<%=class_id_up%>" title="<%=class_name%>" onclick="javaScript:document.getElementById('class_id').value='<%=class_id_up%>';">
								</td>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%if(list!=null){%>
									<a href="/member/addProductattrInfoMgr/addproattrIndex.jsp?up_class_id=<%=class_id_up%>" title="查看下级型号"><%=class_name%></a>
									<%}else{%>
									<%=class_name%>
									<%}%>
									
								</td>
								<td width="40%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%=class_desc%>
								</td>
								
							</tr>
								<%}
							}else{%>
								<tr>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;" colspan="4">暂无型号！</td>
							</tr>
							<%	}
							%>
							<tr>
								<td width="20%" align="center" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;" colspan="4"></td>
							</tr>
	
						</table>
								</td>
							</tr>
							<div id="div-win"></div>
							<input type="hidden" name="trade_type_code" value="1221" />
							<input type="hidden" name="attr_id" value="<%=attr_id%>" />
							<input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>">
							<input name="enable_tag" id="enable_tag" type="hidden" value="">
							<input name="remark" id="remark" type="hidden" value="">
							<input name="default_tag" id="default_tag" type="hidden" value="">
							<input name="class_id" id="class_id" type="hidden" >
							<input name="class_name" id="class_name" type="hidden" value="0">
							<input name="up_class_id" id="up_class_id" type="hidden" value="000000000000000">
						
					<tr>
					<td class="u1"> 
						规格名称： 
					</td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;">
						<div class="ping1">
							<input name="attr_name" type="text" id="attr_name" size=30 maxlength=50 >
						</div>
					</td>
				</tr>
				<input name="attr_no" type="hidden" id="attr_no" value="1" />
				<tr>
					<td class="u1">
						默认值：
					</td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;">
						<div class="ping1">
							<input name="default_value" type="text" id="default_value" >
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
							描述 ：
				   </td>
					<td align="left" style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;">
						<div class="ping1">
						  <textarea name="attr_desc" cols="50" rows="6" id="attr_desc"></textarea>
						</div>
				  </td>
				</tr>
				
				<input type="hidden" name="remark" id="remark" size="50" />
				<input name="attr_id" id="attr_id" type="hidden" />
				<tr>
					<td height="30" align="center" style="background-color:#ECF5FD; color:#003399; font-weight: bold; font-size: 12px;" colspan="2">
						<input name="comit" type="submit" value="" onclick="return modiattrCheck_Value()" style="background-image: url('/admin/images/tj.gif');width:78px;height:32px;border:0;cursor:hand;text-align:center;">
					</td>
				</tr>
						</table>
					</td>
				</tr>

			</table>
		</form>
	</body>
</html>







