<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="roleBean" class="com.saas.biz.roleMgr.RoleInfo" scope="page"></jsp:useBean>
<jsp:useBean id="rightTree" class="com.saas.biz.roleMgr.RoleMenu" scope="page"></jsp:useBean>
<%
    String class_code = bean.getSelectItems("14");
    String start_date = "", end_date = "";
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
    start_date = formate.format(cal.getTime());
    cal.add( Calendar.YEAR, 1 );
    end_date = formate.format(cal.getTime());
    
    String cust_class = "", service = "", up_menu_id = "", rcode = "";
    if( request.getParameter("rcode") != null )
	{
    	rcode = request.getParameter("rcode");
    }
    if( request.getParameter("role_code") != null )
	{
    	cust_class = request.getParameter("role_code");
    }
    //if(request.getParameter("service")!=null){
    	//service = request.getParameter("service");
    //}
    service = "B2B";
    HttpSession sesson = request.getSession();
    String cust_type = (String)sesson.getAttribute("SESSION_CUST_TYPE");
    if( request.getParameter("up_menu_id") != null )
	{
    	up_menu_id = request.getParameter("up_menu_id");
    }
    RightMenu rightMenu = new RightMenu();
    ArrayList oneMenuList = new ArrayList();
        
    String cust_id = ( String )sesson.getAttribute("SESSION_CUST_ID");
    if( !cust_class.equals("") && !service.equals("") )
	{
    	oneMenuList = rightMenu.getNoExistMenuByCustClassForMumber(cust_id,cust_class,service,up_menu_id);
    }
	if( cust_type.equals("1") && !cust_class.equals("") )
	{
		service="SYS";
    oneMenuList = rightMenu.getMenuRightByUpMenuId("SYS",up_menu_id);
 }
    
    //out.println("cust_class="+cust_class+" service="+service+" up_menu_id="+up_menu_id+" cust_type="+cust_type);
    ArrayList rolecodeList = new ArrayList();
    rolecodeList = roleBean.getRoleInfoByType( cust_id, "1" );
    String role_code = "<option value=n>δ���ý�ɫ</option>";
    if ( rolecodeList != null && rolecodeList.size() > 0 ) 
	{
		role_code = "";
		for ( int i = 0; i < rolecodeList.size(); i++ ) 
		{
			HashMap map = ( HashMap ) rolecodeList.get( i );
			String role_name = map.get( "role_name" ).toString();
			String role_codeT = map.get( "role_code" ).toString();
			if( role_codeT.equals( cust_class ) )
			{
				role_code = role_code + "<option selected value=" + role_codeT + ">" + role_name + "</option>";
			}
			else
			{
				role_code = role_code + "<option value=" + role_codeT + ">" + role_name + "</option>";
			}
		}
	}
    
 %>
<html>
	<head>
	  <title>B2B���������̨����ϵͳ</title>
	  <link href="/style/layout1.css" rel="stylesheet" type="text/css">
	  <script language="javascript" src="/js/Calendar_Ly.js"></script>
		<style type="text/css">
		 td{
				background-color:white;
			}
		</style>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RoleInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript">
			function formSub()
			{
				if( document.getElementById('role_code').value == '0' )
				{
					alert('��ѡ���ɫ���ƣ�');
					return false;	
				}
				if( document.getElementById('role_code').value == 'n' )
				{
					alert('δ���ý�ɫ��');
					return false;
				}
				document.getElementById('loading').style.display = 'block';
				document.getElementById('dis').style.display = 'none';
				document.resumeForm.submit();
			}
			function selAll()
			{
				var size = document.getElementById('size').value;
				for( var i = 0; i < size; i++ )
				{
					if( document.getElementById('o_add' + i ).value != '' )
					{
						 document.getElementById('o_add'+i).checked = true;
					}	
				}
			}
			function delAll()
			{
				var size = document.getElementById('size').value;
				for( var i = 0; i < size; i++ )
				{
					if( document.getElementById('o_add'+i).value != '' )
					{
						document.getElementById('o_add'+i).checked = false;
					}
				}
			}
			
			function selDAll()
			{
				var size = document.getElementById('size').value;
				for( var i = 0; i < size; i++ )
				{
					if( document.getElementById('o_del'+i).value != '' )
					{
						 document.getElementById('o_del'+i).checked = true;
					}	
				}
			}
			function delDAll()
			{
				var size = document.getElementById('size').value;
				for( var i = 0; i < size; i++ )
				{
					if( document.getElementById('o_del'+i).value != '' )
					{
						document.getElementById('o_del'+i).checked = false;
					}
				}
			}
			
			function addMenu()
			{
				var size = document.getElementById('size').value;
				var menu_id = '';
				for(var i=0;i<size;i++)
				{
					if(document.getElementById('o_add'+i).checked==true){
						if(document.getElementById('o_add'+i).value!=''){
							menu_id += document.getElementById('o_add'+i).value+'|';
						}
					}
				}
				document.getElementById('all_menu_id').value = menu_id;
				if(menu_id==''){
						alert('��ѡ��˵���');
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
						alert('��ѡ��˵���');
						return false;
				}
				document.getElementById('resumeForm').action='/doTradeReg.do';
				document.getElementById('trade_type_code').value = '8655';
				document.resumeForm.submit();
			}
			
		</script>
		
	</head>
	<body>
		
		<form id="resumeForm" name="resumeForm" action="index.jsp" method="post" target="_self">
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#98D9A2">
			<tr>
				<td class="u1">
						��ɫ���ƣ�
				</td>
				<td class="u2" colspan="3">
					<div class="ping1">
					  <select id="role_code" name="role_code">
					    <option value="0">��ѡ��...</option>  
					    <%=role_code%>
					  </select>
					  <input type="button" name="ss" value="����Ȩ��" onClick="formSub()">
					</div>
				</td>
			</tr>
			<tr>
				<td  class="u1" >��ʼʱ�䣺</td>
				<td class="u2">
				    <input type="text" name="start_date" id="start_date" maxlength="100" size="10" value="<%=start_date%>" onFocus="setday(this);">
				</td>
				<td  class="u1">����ʱ�䣺</td>
				<td class="u2">
				    <input type="text" name="end_date" id="end_date" maxlength="100" size="10" value="<%=end_date%>" onFocus="setday(this);">
				</td>
			</tr>
			<tr>
				<td colspan="4"  align=center width=790>
					<table width=100% bgcolor="#98D9A2" cellpadding="1" cellspacing="1">
							<tr>
								<td id="loading" style="display:none;">
									�˵����ڼ���......
								</td>
							</tr>
					</table>
					<table width=100% bgcolor="#98D9A2" cellpadding="1" cellspacing="1" id="dis" style="display:block;">
							<%
								String o_menu_id="",o_menu_name="",o_menu_class="";
								int size = 0;
								if( oneMenuList != null && oneMenuList.size() > 0 )
								{
									size = oneMenuList.size();
							%>
								<tr bgcolor="white">
									<td align="center" width="30%">
										<b>�˵�����</b>
									</td>
									<td width="35%" align="center">
										<input type="button" name="addButton" value="����" onClick="return addMenu()">
										<input type="button" name="selAllButton" value="ȫѡ" onClick="selAll()">
										<input type="button" name="delAllButton" value="��ѡ" onClick="delAll()">
									</td>
									<td width="35%" align="center">
										<input type="button" name="addButton" value="����" onClick="return delMenu()">
										<input type="button" name="selAllButton" value="ȫѡ" onClick="selDAll()">
										<input type="button" name="delAllButton" value="��ѡ" onClick="delDAll()">
									</td>
								</tr>
								<%
									for( int i = 0; i < oneMenuList.size(); i++ )
									{
										HashMap oneMap = (HashMap)oneMenuList.get( i );
										if( oneMap.get("menu_id") != null )
										{
											o_menu_id = oneMap.get("menu_id").toString();
										}
										if( oneMap.get("menu_name") != null )
										{
											o_menu_name = oneMap.get("menu_name").toString();
										}
										if( oneMap.get("menu_class") != null )
										{
											o_menu_class = oneMap.get("menu_class").toString();
										}
										
										ArrayList downdownlist = rightMenu.getMenuInfoByUpMenuId(o_menu_id);
										
								%>
								<tr bgcolor="white">
									<td>
									<%
										if( downdownlist == null )
										{
									%>
											<%=o_menu_name%>
									<%		
										}
										else{
									%>
											<a href="index.jsp?up_menu_id=<%=o_menu_id%>&role_code=<%=cust_class%>&service=<%=service%>" ><%=o_menu_name%></a>
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
											int t = 0;
											String left_menu_id = "",right_menu_id = "";
											if( o_menu_class.equals("1") )
											{
												twoList = rightMenu.getMenuInfoByUpMenuId( o_menu_id );
												a += rightTree.getExistByMenuId( o_menu_id, cust_class, cust_id );
												if( twoList != null && twoList.size() > 0 && a!=0)
												{
													for( int b = 0; b < twoList.size(); b++ )
													{
														twoMap = (HashMap)twoList.get(b);
														if( twoMap.get("menu_id") != null )
														{
															left_menu_id = twoMap.get("menu_id").toString();
															a += rightTree.getExistByMenuId( left_menu_id, cust_class, cust_id );
															if( rightTree.getExistByMenuId( left_menu_id, cust_class, cust_id ) == 0 )
															{
																a = 0;
															}
															threeList = rightMenu.getMenuInfoByUpMenuId( left_menu_id );
															if( twoList != null && twoList.size() > 0 )
															{
																for( int j = 0; j < twoList.size(); j++ )
																{
																	twoMap = (HashMap)twoList.get(j);
																	if(twoMap.get("menu_id") != null )
																	{
																		right_menu_id = twoMap.get("menu_id").toString();	
																		a += rightTree.getExistByMenuId( right_menu_id, cust_class, cust_id );	
																		if( rightTree.getExistByMenuId( right_menu_id, cust_class, cust_id ) == 0 )
																		{
																			a = 0;
																		}
																	}
																}
															}
														}
													}
												}
											}
											if( o_menu_class.equals("2") )
											{
												a += rightTree.getExistByMenuId( o_menu_id, cust_class, cust_id );
												twoList = rightMenu.getMenuInfoByUpMenuId( o_menu_id );
												if( twoList != null && twoList.size() > 0 )
												{
													for( int j = 0; j < twoList.size(); j++ )
													{
														twoMap = (HashMap)twoList.get(j);
														if( twoMap.get("menu_id") != null )
														{
															left_menu_id = twoMap.get("menu_id").toString();
															a += rightTree.getExistByMenuId( left_menu_id, cust_class, cust_id );
															if( rightTree.getExistByMenuId( left_menu_id, cust_class, cust_id ) ==0 )
															{
																a = 0;
															}
														}
													}
												}
											}
											if( o_menu_class.equals("3") )
											{
												a += rightTree.getExistByMenuId(o_menu_id,cust_class,cust_id);
											}
											
											if( a == 0 )
											{
										%>
											<font color="red">������</font>
											<input type="hidden" name=o_add<%=i%> id=o_add<%=i%> value="" />
										<%
											}
											else
											{
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
							
							
							<%
								if( oneMenuList != null )
								{
							%>
							<script language="javascript">
								document.getElementById('loading').style.display='none';
							</script>
							<%
								}
							%>
							
							<input type="hidden" name="menu_class" id="menu_class" value="<%=o_menu_class%>">
							<input type="hidden" name="size" id="size" value="<%=size%>">
							<input type="hidden" name="all_menu_id" id="all_menu_id" value="">
							<input type="hidden" name="rcode" id="rcode" value="">
							<input type="hidden" name="subsys_code" id="subsys_code" value="<%=service%>">
							<input type="hidden" name="cust_class" id="cust_class" value="<%=cust_class%>">
							<input type="hidden" name="trade_type_code" id="trade_type_code" value="8656">
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="u3">
					<%
						if( !o_menu_class.equals("1") && !cust_class.equals("") )
						{
					%>
						<a href="javascript:history.go(-1);">[������һҳ]</a>
					<%
						}
					%>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>



