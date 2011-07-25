<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="proInfo" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	//String class_type=bean.getSelectItems("64");
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
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="channal.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
    <script type='text/javascript' src='/js/b2b_productMgr.js'></script>       	
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
			
			<table align=center width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 13px;" bgcolor="#DEEDFD">
				<tr class="u2">
					<td colspan="3" align="left" class="head">
						<a href="modiproductIndex.jsp">��Ʒ�ͺŹ���</a>
					</td>
				</tr>
				<tr>
					<td class="u1" width="25%">��Ʒ�ͺ����ƣ�
					</td>
					<td class="u2"><div class="ping1">
							<input name="class_name" type="text" id="class_name" size=30 maxlength=50>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">ѡ���ϼ��ͺ�:</br>(�粻ѡ�κ��ͺ�,��Ϊ���һ���ͺ�)
					</td>
					<td class="u2">
						<table align="left" width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="20%" align="center" >ѡ���ͺ�</td>    
								<td width="20%" align="center" >�ͺ�����</td>
								<td width="40%" align="center" >�ͺ�����</td>
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
					           %>
					           <tr>
					      <td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<input type="radio" name="up_class_id" value="<%=class_id_up%>" title="<%=class_name%>">
								</td>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%if(list!=null){%>
									<a href="/member/addProductInfoMgr/addproductIndex.jsp?up_class_id=<%=class_id_up%>" title="�鿴�¼�����"><%=class_name%></a>
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
					<input type="hidden" name="enable_tag" value="0" id="enable_tag">
					<input type="hidden" name="remark" id="remark" size="50"/>
				<tr>
					<td height="30" class="u1">���� ��
				   </td>
					<td class="u2"><div class="ping1">
						  <textarea name="class_desc" cols="50" rows="6"></textarea>
						</div>
				  </td>
				</tr>
						  

				<input type="hidden" name="trade_type_code" value="1220"/>
				<input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>">
				
				<input name="class_id" id="class_id" type="hidden" value="<%=class_id%>">
				<input name="class_name" id="class_name" type="hidden" value="0">
				<input name="up_class_id" id="up_class_id" type="hidden" value="000000000000000">
				<input name="class_level" id="class_level" type="hidden" value="0">
				<input name="class_type" id="class_type" type="hidden" value="0">
				<input name="class_desc" id="class_desc" type="hidden" value="0">
				<input name="remark" id="remark" type="hidden" value="0">
				
				<tr>
					<td height="30" class="u3" colspan=2>
						<input name="comit" type="submit" value="" onclick="return Check_Value()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
						
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>








