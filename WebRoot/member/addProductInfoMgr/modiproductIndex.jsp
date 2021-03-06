<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="proInfo" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%@ page import="java.util.*"%>
<%
	String class_id = comm.GenTradeId();
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
		<title>产品管理</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="../../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext/ext-all.js"></script>
		<script type="text/javascript" src="modichannal.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='/js/addProductInfoMgr.js'></script>
	</head>
	<body>
		<form name=productForm method=post action=/doTradeReg.do target="_self">
		<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
			<table align="center" width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#E6F6E9">
				<tr>
					<td colspan="4" class="head">
						<a href="addproductIndex.jsp">新增产品型号</a>
					</td>
				</tr>
				<tr>
					<td class="u1">
						选择产品型号：
					</td>2009-7-10
					<td class="u2" colspan="3">
						<!--<div class="ping1">
							<div id="tree-div"></div>
						</div>-->
						<table  width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#E6F6E9">
							<tr class="u4" height="25">
								<td width="20%" align="center">选择型号</td>
								<td width="20%" align="left">型号名称</td>
								<td width="40%" align="left">型号描述</td>
							</tr>
							<%
								if(json!=null && json.size()>0){
								HashMap map=null;
									for(int i=0;i<json.size();i++){
									String class_name="";
									String class_id_up="";
									String class_desc="";
									String enable_tag="";
									String remark="";
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
					           if(map.get("remark")!=null){
					          	 remark=map.get("remark").toString();
					          	 
					           }
					           %>
					           <tr>
					      <td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<input type="radio" name="up_class_id" value="<%=class_id_up%>" title="<%=class_name%>" onclick="document.getElementById('class_name').value='<%=class_name%>';document.getElementById('class_desc').value='<%=class_desc%>';document.getElementById('enable_tag').value='<%=map.get("enable_tag").toString()%>';document.getElementById('class_id').value='<%=class_id_up%>';document.getElementById('remark').value='<%=remark%>';"/>
								</td>
								<td width="20%" align="left" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%if(list!=null){%>
									<a href="/member/addProductInfoMgr/modiproductIndex.jsp?up_class_id=<%=class_id_up%>&menu_id=<%=top_menu_id%>" title="查看下级型号"><%=class_name%></a>
									<%}else{%>
									<%=class_name%>
									<%}%>
									
								</td>
								<td width="40%" align="left" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
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
				<tr>
					<td class="u1">
						产品型号名称：
					</td>
					<td class="u2">
						<div class="ping1">
							<input name="class_name" type="text" id="class_name" >
						</div>
					</td>
					<!--
					<td height="30" class="u1">
						是否有效 ：
					</td>
					<td class="u2">
						<div class="ping1">
							<select id="enable_tag" name="enable_tag">
								<option value="0">
									有效
								</option>
								<option value="1">
									无效
								</option>
							</select>
						</div>
					</td>
					-->
				</tr>
				<tr>
					<td height="30" class="u1">
						型号描述 ：
					</td>
					<td class="u2" colspan="3">
						<div class="ping1">
							<textarea name="class_desc" cols="50" rows="6"></textarea>
						</div>
					</td>
				</tr>
				<input type="hidden" name="remark" id="remark" size="50" />
						 
						<input type="hidden" name="trade_type_code" id="trade_type_code" value="1222" />
						<input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>">
						<input name="class_id" id="class_id" type="hidden" value="" >
						<input name="class_name" id="class_name" type="hidden" value="0">
						<input name="up_class_id" id="up_class_id" type="hidden" value="000000000000000">
						<input name="class_level" id="class_level" type="hidden" value="0">
						<input name="class_type" id="class_type" type="hidden" value="0">
						<input name="class_desc" id="class_desc" type="hidden" value="0">
						<input name="enable_tag" id="enable_tag" type="hidden" value="0">
						<input name="remark" id="remark" type="hidden" value="0">
					
				<tr>
					<td height="30" class="u3" colspan=4>
						<input name="comit" type="submit" value="" onclick="return modiproductCheck_Value()" style="background-image: url('/admin/images/xg.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
						&nbsp;&nbsp;
						<input name="comit" type="submit" value="" onclick="return delCheck_Value()" style="background-image: url('/admin/images/scan1.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>








