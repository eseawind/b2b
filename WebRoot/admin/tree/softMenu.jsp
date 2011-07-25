<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.text.SimpleDateFormat"%>
<%
    String class_code=bean.getSelectItems("14");
    String start_date="",end_date="";
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
    start_date=formate.format(cal.getTime());
    cal.add(Calendar.MONTH,3);
    end_date=formate.format(cal.getTime());
    
    String cust_class="",service="",up_menu_id="";
    if(request.getParameter("a_cust_class")!=null){
    	cust_class = request.getParameter("a_cust_class");
    }
    if(request.getParameter("service")!=null){
    	service = request.getParameter("service");
    }
    service = "B2B";
    if(request.getParameter("up_menu_id")!=null){
    	up_menu_id = request.getParameter("up_menu_id");
    }
    RightMenu rightMenu = new RightMenu();
    RightTreeMenu rightTree = new RightTreeMenu();
    ArrayList oneMenuList = new ArrayList();
    if(!cust_class.equals("") && !service.equals("")){
    	oneMenuList = rightMenu.getNoExistMenuByCustClass(cust_class,service,up_menu_id);
    }
 %>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	  <script language="javascript" src="/js/Calendar_Ly.js"></script>
		<style type="text/css">
			td{
					background-color:white;
			}
		</style>
		<script language="javascript">
			function formSub(){
					if(document.getElementById('a_cust_class').value=='0'){
							
							alert('请选择客户类型！');
							return false;
					}
					document.resumeForm.submit();
			}
			function selAll(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
						if(document.getElementById('o_add'+i).value!=''){
							 document.getElementById('o_add'+i).checked=true;
						}	
					}
			}
			function delAll(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
						if(document.getElementById('o_add'+i).value!=''){
							document.getElementById('o_add'+i).checked=false;
						}
					}
			}
			
			function selDAll(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
						if(document.getElementById('o_del'+i).value!=''){
							 document.getElementById('o_del'+i).checked=true;
						}	
					}
			}
			function delDAll(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
						if(document.getElementById('o_del'+i).value!=''){
							document.getElementById('o_del'+i).checked=false;
						}
					}
			}
			
			function addMenu(){
					var size = document.getElementById('size').value;
					var menu_id='';
					for(var i=0;i<size;i++){
						if(document.getElementById('o_add'+i).checked==true){
							if(document.getElementById('o_add'+i).value!=''){
								menu_id += document.getElementById('o_add'+i).value+'|';
							}
						}
					}
					document.getElementById('all_menu_id').value = menu_id;
					if(menu_id==''){
							alert('请选择菜单！');
							return false;
					}
					document.getElementById('resumeForm').action='/doTradeReg.do';
					document.resumeForm.submit();
			}
			
			function delMenu(){
					var size = document.getElementById('size').value;
					var menu_id='';
					for(var i=0;i<size;i++){
						if(document.getElementById('o_del'+i).checked==true){
							if(document.getElementById('o_del'+i).value!=''){
								menu_id += document.getElementById('o_del'+i).value+'|';
							}
						}
					}
					document.getElementById('all_menu_id').value = menu_id;
					if(menu_id==''){
							alert('请选择菜单！');
							return false;
					}
					document.getElementById('resumeForm').action='/doTradeReg.do';
					document.getElementById('trade_type_code').value = '9811';
					document.resumeForm.submit();
			}
			
		</script>
	</head>
	<body>
		
		<form id=resumeForm name=resumeForm action=index.jsp method=post target="_self">
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
			<tr>
				<td class="u1">
						客户类型：
					</td>
					<td class="u2" colspan="3">
						<div class="ping1">
							<select id="a_cust_class" name="a_cust_class" onChange="formSub()">
							 <option value="0">请选择..</option>
							  <%=class_code%>
							</select>
							<%
								String cust_class_name="",service_name="";
								if(!cust_class.equals("")){
									cust_class_name = bean.getParaCode2ByParaCode1("1", cust_class);
							%>
								&nbsp;&nbsp;<b>客户类型：</b><%=cust_class_name%>
							<%
								}
							%>
							
						</div>
					</td>
					 
				</tr>
			<tr>
				<td  class="u1" >
					开始时间：
				</td>
				<td class="u2">
				    <input type="text" name="start_date" id="start_date" maxlength="100" size="10" value="<%=start_date%>" onFocus="setday(this);">
				</td>
					<td  class="u1">
				结束时间：
				</td>
				<td class="u2">
				    <input type="text" name="end_date" id="end_date" maxlength="100" size="10" value="<%=end_date%>" onFocus="setday(this);">
				</td>
			</tr>
			<tr>
				<td colspan="4"  align=center width=790>
					<table width=100% bgcolor="#FCB0B0" cellpadding="1" cellspacing="1">
							
							<%
								String o_menu_id="",o_menu_name="",o_menu_class="";
								int size = 0;
								
								if(oneMenuList!=null && oneMenuList.size()>0){
								size = oneMenuList.size();
							%>
								<tr bgcolor="white">
									<td align="center" width="30%">
											<b>菜单名称</b>
									</td>
									<td width="35%" align="center">
											<input type="button" name="addButton" value="添加" onClick="return addMenu()">
											<input type="button" name="selAllButton" value="全选" onClick="selAll()">
											<input type="button" name="delAllButton" value="反选" onClick="delAll()">
									</td>
									<td width="35%" align="center">
											<input type="button" name="addButton" value="回收" onClick="return delMenu()">
											<input type="button" name="selAllButton" value="全选" onClick="selDAll()">
											<input type="button" name="delAllButton" value="反选" onClick="delDAll()">
									</td>
								</tr>
							<%
									for(int i=0;i<oneMenuList.size();i++){
										HashMap oneMap = (HashMap)oneMenuList.get(i);
										if(oneMap.get("menu_id")!=null){
											o_menu_id = oneMap.get("menu_id").toString();
										}
										if(oneMap.get("menu_name")!=null){
											o_menu_name = oneMap.get("menu_name").toString();
										}
										if(oneMap.get("menu_class")!=null){
											o_menu_class = oneMap.get("menu_class").toString();
										}
							%>
								<tr bgcolor="white">
									<td>
											<%
												if(o_menu_class.equals("3")){
											%>
												<%=o_menu_name%>
											<%		
											}else{
											%>
												<a href="index.jsp?up_menu_id=<%=o_menu_id%>&a_cust_class=<%=cust_class%>&service=<%=service%>" ><%=o_menu_name%></a>
											<%
												}
											%>
									</td>
									<td>
										<%
											ArrayList twoList = new ArrayList();
											ArrayList threeList = new ArrayList();
											HashMap twoMap = new HashMap();
											HashMap threeMap = new HashMap();
											int a = 0;
											String left_menu_id="",right_menu_id="";
											if(o_menu_class.equals("1")){
												twoList = rightMenu.getMenuInfoByUpMenuId(o_menu_id);
												if(twoList!=null && twoList.size()>0){
													for(int b=0;b<twoList.size();b++){
														twoMap = (HashMap)twoList.get(b);
														if(twoMap.get("menu_id")!=null){
															left_menu_id = twoMap.get("menu_id").toString();
															a += rightTree.getExistByMenuId(left_menu_id,cust_class);
															
															threeList = rightMenu.getMenuInfoByUpMenuId(left_menu_id);
															if(twoList!=null && twoList.size()>0){
																for(int j=0;j<twoList.size();j++){
																	twoMap = (HashMap)twoList.get(j);
																	if(twoMap.get("menu_id")!=null){
																		right_menu_id = twoMap.get("menu_id").toString();	
																		a += rightTree.getExistByMenuId(right_menu_id,cust_class);
																	}
																}
															}
														}
													}
												}
											}
											
											
											if(o_menu_class.equals("2")){
												twoList = rightMenu.getMenuInfoByUpMenuId(o_menu_id);
												if(twoList!=null && twoList.size()>0){
													for(int j=0;j<twoList.size();j++){
														twoMap = (HashMap)twoList.get(j);
														if(twoMap.get("menu_id")!=null){
															left_menu_id = twoMap.get("menu_id").toString();
															a += rightTree.getExistByMenuId(left_menu_id,cust_class);
														}
													}
												}
											}
											
											
											if(o_menu_class.equals("3")){
													a += rightTree.getExistByMenuId(o_menu_id,cust_class);
											}
											
											if(a==0){
										%>
											<font color="red">已添加</font>
											<input type="hidden" name=o_add<%=i%> id=o_add<%=i%> value="" />
										<%
											}else{
										%>
											<input type="checkbox" name=o_add<%=i%> id=o_add<%=i%> value="<%=o_menu_id%>"/>
										<%
											}
										%>
									</td>
									<td>
											<%
												if(a==0){
											%>
												<input type="checkbox" name=o_del<%=i%> id=o_del<%=i%> value="<%=o_menu_id%>"/>
											<%
											}else{
											%>
												<input type="hidden" name=o_del<%=i%> id=o_del<%=i%> value="<%=o_menu_id%>"/>
											<%
												}
											%>
									</td>
							</tr>
							<%			
									}
								}
							%>
							<input type="hidden" name="menu_class" id="menu_class" value="<%=o_menu_class%>">
							<input type="hidden" name="size" id="size" value="<%=size%>">
							<input type="hidden" name="all_menu_id" id="all_menu_id" value="">
							<input type="hidden" name="subsys_code" id="subsys_code" value="<%=service%>">
							<input type="hidden" name="cust_class" id="cust_class" value="<%=cust_class%>">
							<input type="hidden" name="trade_type_code" id="trade_type_code" value="2240">
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="u3">
					
					<%
						if(!cust_class.equals("") &&  !o_menu_class.equals("1")){
					%>
					<a href="javascript:history.go(-1);">[返回上一页]</a>&nbsp;&nbsp;<!--a href="javascript:window.open('','_self','');window.close();">[关闭窗口]</a-->
					<%
						}
					%>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>





