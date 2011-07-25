<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="role" class="com.saas.biz.roleMgr.RoleInfo" scope="page" />

<%

	String cust_id="";

	Calendar cal = Calendar.getInstance();

    String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

    cal.add(Calendar.MONTH, 3);

    String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

    HttpSession sess=request.getSession();

    if(sess.getAttribute("SESSION_CUST_ID")!=null){

      cust_id=(String)sess.getAttribute("SESSION_CUST_ID");

    }

    ArrayList roleList=role.getRoleInfoByCustId(cust_id);
	ArrayList list=bean.getCompareInfoByAttr("41");
	
	String role_code="",server_id="",up_menu_id="",cust_id1="";
	
	if(request.getParameter("cust_id1")!=null){cust_id1=request.getParameter("cust_id1");}
	if(request.getParameter("role_code1")!=null){role_code=request.getParameter("role_code1");}
	if(request.getParameter("server_id")!=null){server_id=request.getParameter("server_id");}
	if(request.getParameter("up_menu_id")!=null){up_menu_id=request.getParameter("up_menu_id");}
	RightMenu rightMenu = new RightMenu();
	ArrayList rightMenuList = new ArrayList();
	if(!role_code.equals("")){
		rightMenuList = rightMenu.getOneClassMenuBySer(up_menu_id,server_id);
	}
	ArrayList rightList = rightMenu.getRightInfoMenuMessage(cust_id,role_code);
	out.println(rightList);
%>

<html>

	<head>

		<title>角色权限分配</title>

		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RightMenu.js'></script> 
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/roleRightMgr.js"></script>
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
		
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="2"></td>
				</tr>
				<tr>
					<td valign="top">
					<form action="addRoleRightInfo.jsp" method="post" name="roleForm">
						<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"
									align=right width=15%>
									角色名称：
								</td>
								<td width=85% align=left bgcolor="#FFFFFF">
								<div class="ping">
									<select name="role_code1" id="role_code1">
									<option value="0">请选择...</option>
                                   <%
                                     if(roleList!=null && roleList.size()>0){
                                       for(int i=0;i<roleList.size();i++){
                                         HashMap map=(HashMap)roleList.get(i);
                                         String id=map.get("role_code").toString();
                                         String name=map.get("role_name").toString();
                                         %>
                                         <option value="<%=id%>"><%=name%></option>
                                         <%
                                       }
                                     }
                                   %>
                                   </select>
								</div>
							  </td>
							</tr>
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"
									align=right>
									服务名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									<select name="server_id" id="server_id" onchange="submitRoleForm()">
									<option value="0">请选择..</option>
                                   <%
                                     if(list!=null && list.size()>0){
                                       for(int i=0;i<list.size();i++){
                                         HashMap ser_map=(HashMap)list.get(i);
                                         String ser_id=ser_map.get("para_code1").toString();
                                         String ser_name=ser_map.get("para_code2").toString();
                                         %>
                                         <option value="<%=ser_id%>"><%=ser_name%></option>
                                         <%
                                       }
                                     }
                                   %>
                                   </select>
                                 </div>
                               </td>
                            </tr>
                            <input name="cust_id1" id="cust_id1" type="hidden" value="<%=cust_id%>"/>
                            <input name="up_menu_id" id="up_menu_id" type="hidden" value=""/>
                          </table>
                          </form>
                            <form name=resumeForm action=/doTradeReg.do method=post target="_self">
						<table>
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									菜单名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
                                  		<% 
                                  			String right_menu_id="",right_menu_name="";
                                  			String two_menu_id="",two_menu_name="";
                                  			String three_menu_id="",three_menu_name="";
                                  			if(rightMenuList!=null && rightMenuList.size()>0){
										    	for(int i = 0;i<rightMenuList.size();i++){
										    		HashMap rightMenuMap = (HashMap)rightMenuList.get(i);
											            right_menu_id = rightMenuMap.get("menu_id").toString();
											            right_menu_name = rightMenuMap.get("menu_name").toString();
									%>
														
														<input type="checkbox" name="right_menu<%=i%>" id="right_menu<%=i%>" value="<%=right_menu_id%>" onclick="showTwoMenu('<%=i%>')"><%=right_menu_name%><br>
									<%                  
													    ArrayList twoMenuList = rightMenu.getOneClassMenuBySer(right_menu_id,server_id);
													    int twoMenuSize = twoMenuList.size(); 	
													    if(twoMenuList!=null && twoMenuList.size()>0){
										    	 			for(int j = 0;j<twoMenuList.size();j++){
										    	 				HashMap twoMenuMap = (HashMap)twoMenuList.get(j);
											            		two_menu_id = twoMenuMap.get("menu_id").toString();
											            		two_menu_name = twoMenuMap.get("menu_name").toString();
									%>
														<div id="two<%=i%><%=j%>" style="display: none;">
															&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="hidden" name="two<%=i%>" id="two<%=i%>" value="<%=twoMenuSize %>">
															<input type="checkbox" name="tow_menu<%=i%><%=j%>" id="tow_menu<%=i%><%=j%>" value="<%=two_menu_id%>" onclick="showThreeMenu('<%=i%>','<%=j%>')"><%=two_menu_name%><br>
														</div>
									<%	
																ArrayList threeMenuList = rightMenu.getOneClassMenuBySer(two_menu_id,server_id);
																int threeMenuSize = threeMenuList.size();
															    if(threeMenuList!=null && threeMenuList.size()>0){
												    	 			for(int k = 0;k<threeMenuList.size();k++){
												    	 				HashMap threeMenuMap = (HashMap)threeMenuList.get(k);
													            		three_menu_id = threeMenuMap.get("menu_id").toString();
													            		three_menu_name = threeMenuMap.get("menu_name").toString();
													            		
													            		for(int a = 0;a<rightList.size();a++){
													            			HashMap rightMap = (HashMap)rightList.get(a);
													            			String role_right_menu_id = "";
													            			if(rightMap.get("menu_id")!=null){role_right_menu_id = rightMap.get("menu_id").toString();}
													            			if(role_right_menu_id.equals(three_menu_id)){
													            				three_menu_name+="[已分配]";
													            			}
													            		}
													            		
									%>
														<div id="three<%=i%><%=j%><%=k %>" style="display: none;">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="hidden" name="three<%=i%>" id="three<%=i%>" value="<%=threeMenuSize%>">
															<input type="checkbox" name="three_menu<%=i%><%=j%><%=k %>" id="three_menu<%=i%><%=j%><%=k %>" value="<%=three_menu_id%>"><%=three_menu_name%><br>
														</div>
									<%
													            	}
													            }
										    	 			}
										    	 		}
										    	}
										    }
                                  	%>
									</div>
							  	</td>
							</tr>
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"
									align=right>
									开始时间：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="start_date" type="text" id="start_date" value="<%=start_Date%>" size="16" maxlength="16" onfocus="setday(this);" />
									</div>
							  </td>
							</tr>
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									结束时间：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="end_date" type="text" id="end_date" value="<%=end_Date%>" size="16" maxlength="16" onfocus="setday(this);" />
									</div>
							  </td>
							</tr>
							<tr>
								<td
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									备注：
								</td>
								<td align=left bgcolor="#FFFFFF">
								<div class="ping1">
									<input name="remark" id="remark" type="text" size=30 maxlength="500" />
								</div>
							  </td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1038"/>
							<input name="menu_id" id="menu_id" type="hidden" value=""/>
							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value=""/>
							<input name="rsrv_str2" id="rsrv_str2" type="hidden" value=""/>
							<input name="rsrv_str3" id="rsrv_str3" type="hidden" value=""/>
							<input name="role_code" id="role_code" type="hidden" value="<%=role_code %>"/>
							<input name="cust_id" id="cust_id" type="hidden" value="<%=cust_id%>"/>
							
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
									<input class="fpan" name="submit1" type="submit" value="" onclick="addRoleRightInfoconfirmsub()">
								</td>
							</tr>
					  </table></form>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		
	</body>
</html>





