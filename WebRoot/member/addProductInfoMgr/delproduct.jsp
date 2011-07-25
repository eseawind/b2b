<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<%
	String class_id=comm.GenTradeId();
	HttpSession httpSess=request.getSession();
	String cust_id=(String)httpSess.getAttribute("SESSION_CUST_ID");
	
			String up_id="000000000000000";
	if(request.getParameter("up_class_id") != null){
		up_id=request.getParameter("up_class_id").toString();
	}
	ArrayList json = proInfo.getproductByUpId(cust_id, up_id);
%>
<html>

	<head>
		<title>��Ʒ����</title>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="../../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext/ext-all.js"></script>
		<script type="text/javascript" src="delchannal.js"></script>
		
		<style type="text/css">
		.Tree-Img {
		    background-image:url(/images/org.png) !important;
		}
		.root-Img {
		    background-image:url(/images/home.png) !important;
		}
      </style>
	</head>
	    <body>
	    	
			<form name=productForm method=post action=/doTradeReg.do target="_self">
				<jsp:include page="/inc/jspTop.jsp">
					<jsp:param name="menu_id" value="G43G5G8Y5F3V6F5D" />
				</jsp:include>	
				<table width="800" border="0" cellspacing="1" cellpadding="1"  bgcolor="#DEEDFD">
					<tr>
						<td class="u1">
							ѡ���Ʒ���ࣺ
						</td>
						<td class="u2">
							<!--<div class="ping1">
								<div id="tree-div"></div>
							</div>-->
							<table  width="450px" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="20%" align="center" >ѡ�����</td>
								<td width="20%" align="center" >��������</td>
								<td width="40%" align="center" >��������</td>
								<td width="20%" align="center" >�Ƿ���Ч</td>
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
					          	 		class_desc="��";
					          	 }
					           }
					           if(map.get("enable_tag")!=null){
					          	 enable_tag=map.get("enable_tag").toString();
					          	 if(enable_tag.equals("0")){
					          	 		enable_tag="��Ч";
					          	 }else{
					          	 		enable_tag="��Ч";
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
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%if(list!=null){%>
									<a href="/member/addProductInfoMgr/delproduct.jsp?up_class_id=<%=class_id_up%>" title="�鿴�¼�����"><%=class_name%></a>
									<%}else{%>
									<%=class_name%>
									<%}%>
									
								</td>
								<td width="40%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%=class_desc%>
								</td>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%=enable_tag%>
								
							</tr>
								<%}
							}else{%>
								<tr>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;" colspan="4">���޷��࣡</td>
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
				<td class="u1">��Ʒ�������ƣ�
				</td>
				<td class="u2"><div class="ping1">
						<input name="class_name" type="text" id="class_name" size=30 maxlength=50>
					</div>
				</td>
			</tr>
			<tr>
				<td height="30" class="u1">�Ƿ���Ч ��
			    </td>
				<td class="u2"><div class="ping1">
					  <select id="enable_tag" name="enable_tag">
					    <option value="0">��Ч</option>
					    <option value="1">��Ч</option>
					  </select>
					</div>
			    </td>
			</tr>
			<tr>
				<td height="30" class="u1">���� ��
			   </td>
				<td class="u2"><div class="ping1">
					  <textarea name="class_desc" cols="50" rows="6"></textarea>
					</div>
			  </td>
			</tr>
			<tr>
				<td height="30" class="u1">��ע ��
			    </td>
				<td class="u2"><div class="ping1">
					  <input type="text" name="remark" id="remark" size="50"/>
					</div>
			  </td>
			</tr>
				<input type="hidden" name="trade_type_code" value="1223"/>
				<input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>">
				<input name="class_id" id="class_id" type="hidden">
				<input name="class_name" id="class_name" type="hidden" value="0">
				<input name="up_class_id" id="up_class_id" type="hidden" value="000000000000000">
				<input name="class_level" id="class_level" type="hidden" value="0">
				<input name="class_type" id="class_type" type="hidden" value="0">
				<input name="class_desc" id="class_desc" type="hidden" value="0">
				<input name="enable_tag" id="enable_tag" type="hidden" value="0">
				<input name="remark" id="remark" type="hidden" value="0">
				<tr>
					<td class="u3" colspan=2>
							<input name="comit" type="button" value="" onclick="return Check_Value()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
					</td>
				</tr>
				<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
						</table>
					 
			 
		</form>
	</body>
</html>






