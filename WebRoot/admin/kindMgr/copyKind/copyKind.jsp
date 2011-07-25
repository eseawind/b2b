<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="product" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>分类拷贝</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		
		<script language="javascript">
			function showLeft(){
				var leftSize = document.getElementById('leftSize').value;
				
				var all_class_id = document.getElementById('all_class_id');
				
				if(all_class_id.checked==true){
					for(var a=0;a<leftSize;a++){
						document.getElementById('leftClassId'+a).checked=true;
					}
				}else{
					for(var a=0;a<leftSize;a++){
						document.getElementById('leftClassId'+a).checked=false;
					}
				}
			}
			
			function copKind(){
				var class_type = document.getElementById('class_type').value;
				var right_class_type = document.getElementById('right_class_type').value;
				var leftSize = document.getElementById('leftSize').value;
				if(class_type==right_class_type){
					alert('请选择不同分类进行共享！');
					return false;
				}
				if(leftSize==0){
					alert('您选择的开始分类无数据共享！');
					return false;
				}
				
				var class_id_string = '';
				for(var b=0;b<leftSize;b++){
					if(document.getElementById('leftClassId'+b).checked==true){
							class_id_string += document.getElementById('leftClassId'+b).value+'|';
					}
				}
				
				if(class_id_string==''){
					alert('请至少选择一个分类！');
					return false;
				}
				
				var right_class_type = document.getElementById('right_class_type').value;
				
				
				
				document.copyForm.all_class_id.value = class_id_string;
				document.copyForm.to_class_type.value = right_class_type;
				document.copyForm.from_class_type.value = class_type;
				
				
				document.copyForm.submit();
				
			}
			
			
		</script>
	</head>
	<body>
		
		<%
			ParamethodMgr param = new ParamethodMgr();
			String class_type = "2",right_class_type = "2";
			if(request.getParameter("class_type")!=null){
				class_type = request.getParameter("class_type");
			}
			if(request.getParameter("right_class_type")!=null){
				right_class_type = request.getParameter("right_class_type");
			}
			ArrayList leftList = product.getInfoByUpId("000000000000000",class_type);
			ArrayList rightList = product.getInfoByUpId("000000000000000",right_class_type);	
			
			String leftClassSel = param.getItemsBySelected("26",class_type);
			String rightClassSel = param.getItemsBySelected("26",right_class_type);
		%>
		
		<table>	
			
			<tr>
				<td width="55%">						
					<form action="copyKind.jsp" method="post" name="leftForm">
					请选择开始分类：
					<select name="class_type" id="class_type" onchange="javascript:document.leftForm.submit();">
						<%=leftClassSel%>
					</select>
					<input type="hidden" name="right_class_type" value="<%=right_class_type%>">
					</form>
				</td>
				<td>
				</td>
				<td>
					<form action="copyKind.jsp" method="post" name="rightForm">
					请选择分类分类共享到：
					<select name="right_class_type" id="right_class_type"  onchange="javascript:document.rightForm.submit();">
						<%=rightClassSel%>
					</select>
					<input type="hidden" name="class_type" value="<%=class_type%>">
					</form>
				</td>
			</tr>	
			<tr>
				<td valign="top">
					<%
						int leftSize = 0;
						if(leftList!=null){
					%>
					
						<input type="checkbox" name="all_class_id" id="all_class_id" onclick="showLeft()">&nbsp;全选</br>
					
					<%
							leftSize = leftList.size();
							for(int i=0;i<leftList.size();i++){
								String class_id="",class_name="";
								HashMap leftMap = (HashMap)leftList.get(i);
								if(leftMap.get("class_id")!=null){
									class_id = leftMap.get("class_id").toString();
								}
								if(leftMap.get("class_name")!=null){
									class_name = leftMap.get("class_name").toString();
								}
								
					%>
						<input type="checkbox" name="class_id" id="leftClassId<%=i%>" value="<%=class_id%>"> &nbsp;<%=class_name%></br>
					<%
								
							}
						}else{
					%>
						
						该分类下无数据。
					
					<%		
						}
					%>
					
					<input type="hidden" name="leftSize" id="leftSize" value="<%=leftSize%>" >
				</td>
				<td valign="middle" align="center">
					<input type="button" name="copy" value="共享到>>" onclick="copKind()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td valign="top">
					
					<%
						if(rightList!=null){
							for(int i=0;i<rightList.size();i++){
								String class_id="",class_name="";
								HashMap leftMap = (HashMap)rightList.get(i);
								if(leftMap.get("class_id")!=null){
									class_id = leftMap.get("class_id").toString();
								}
								if(leftMap.get("class_name")!=null){
									class_name = leftMap.get("class_name").toString();
								}
								
					%>
						<%=class_name%></br>
					<%
								
							}
						}else{
					%>
						
						该分类下无数据。
					
					<%		
						}
					%>
					
				</td>
				
			</tr>			
		</table>	
		<form action="/doTradeReg.do" name="copyForm" method="post" target="_self">		
			<input type="hidden" name="trade_type_code" value="6668">
			<input type="hidden" name="all_class_id" value="">
			<input type="hidden" name="to_class_type" value="">
			<input type="hidden" name="from_class_type" value="">		
		</form>	
	</body>
</html>



