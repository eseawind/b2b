<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.menuguideMgr.MenuguideInfo"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<%@ page import="com.saas.intf.LinkIntf"%>
<%
	String user_name = "", up_menu_id = "", user_class = "", 
	role_code = "", user_type = "", cust_id = "", subsys_code = "";
	HttpSession index_session = request.getSession();
	if (index_session.getAttribute("SESSION_USER_NAME") != null) {
		user_name = index_session.getAttribute("SESSION_USER_NAME").toString();
		user_class = index_session.getAttribute("SESSION_CUST_CLASS").toString();
		role_code = index_session.getAttribute("SESSION_ROLE_CODE").toString();
		user_type = index_session.getAttribute("SESSION_USER_TYPE").toString();
		cust_id = index_session.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("menu_id") != null) {
		up_menu_id = request.getParameter("menu_id");
	}
	if (request.getParameter("subsys_code") != null) {
		subsys_code = request.getParameter("subsys_code");
	}
	
	RightMenu menu = new RightMenu();
	String menu_name = menu.getMenuNameById(up_menu_id);
	//取出友情联接
  ArrayList linkList=new LinkIntf().getLinkListByPage(0,100);
%>
<HTML>
	<HEAD>
		<title>B2B电子商务后台管理系统</title>
		<META http-equiv="Content-Type" content="text/html; charset=gb2312">
		<LINK href="images/member.css" type="text/css" rel="stylesheet">
		<link href="css/vip.css" rel="stylesheet" type="text/css">
		<link href="/style/new_layout.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="/images/favicon.ico" />
		<link rel="Bookmark" href="/images/favicon.ico" />
		<script type="text/JavaScript">
		<!--
		function MM_preloadImages() { //v3.0
		  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
		    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
		    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
		}
		//-->
		</script>
		<style type="text/css">
BODY {
	MARGIN: 20px 5px 10px 5px
}
html { overflow-x: hidden; overflow-y: auto; } 
</style>
	</HEAD>
	<body>
		<table cellspacing="0" cellpadding="0" width="98%" border="0">
			<tbody>
				<tr>
					<td class="mtitle">
						<%=menu_name%>
					</td>
				</tr>
				<tr><td height="5"></td></tr>
				<tr>
					<td>
						<%
							ArrayList thirdMenuList = new ArrayList();
							thirdMenuList = new RightMenu().genchildRightMenuList(user_name,"3", up_menu_id, user_class, role_code, user_type);

							if (thirdMenuList != null && thirdMenuList.size() > 0) {
								for (Iterator thit = thirdMenuList.iterator(); thit.hasNext();) {
									HashMap thmenuInfo = (HashMap) thit.next();
									String thmenuId = "";
									String thmenuName = "";
									String thmenudesc = "";
									String rsrv_str1 = "";
									if (thmenuInfo.get("menu_id") != null)
										thmenuId = thmenuInfo.get("menu_id").toString();
									if (thmenuInfo.get("menu_name") != null)
										thmenuName = thmenuInfo.get("menu_name").toString();
									if (thmenuInfo.get("rsrv_str4") != null)
										thmenudesc = thmenuInfo.get("rsrv_str4").toString();
									if (thmenuInfo.get("rsrv_str1") != null)
										rsrv_str1 = thmenuInfo.get("rsrv_str1").toString();
									ArrayList guideList = new MenuguideInfo().getLevelListByCustEntity(cust_id, subsys_code,thmenuId);
									String note_name = "", note_desc = "", link_url = "", obj_cust_id = "", param_code = "";
									if (guideList != null && guideList.size() > 0) {
								HashMap guideMap = (HashMap) guideList.get(0);
								if (guideMap.get("note_name") != null) {
									note_name = guideMap.get("note_name").toString();
								}
								if (guideMap.get("note_desc") != null) {
									note_desc = guideMap.get("note_desc").toString();
								}
								if (guideMap.get("link_url") != null) {
									link_url = guideMap.get("link_url").toString();
								}
								if (guideMap.get("obj_cust_id") != null) {
									obj_cust_id = guideMap.get("obj_cust_id")
									.toString();
								}
								if (guideMap.get("param_code") != null) {
									param_code = guideMap.get("param_code").toString();
								}
									}
									if (guideList == null) {
						%>
						<div class="mid-nrone1">
							<div class="mid-nrone2" onMouseOver="this.style.backgroundColor='#ECF5FD'" onMouseOut="this.style.backgroundColor='#FFFFFF'">
								<div class="mid-nrone4">
									<img src="/admin/images/mid-06.gif" width="51" height="55" />
								</div>
								<div class="mid-nrone5">
									<div class="mid-nrone6">
										<%
										if (rsrv_str1 == "0" || rsrv_str1.equals("0")) {
										%>
										<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" target="_blank"><%=thmenuName%> </a>
										<%
										} else {
										%>
										<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onClick="mydefss()"><%=thmenuName%> </a>
										<%
										}
										%>
									</div>
									<div class="mid-nrone7">
										<%=thmenudesc%>
									</div>
								</div>
							</div>
						</div>
						<%
								} else {
								if (obj_cust_id == "" || obj_cust_id.equals("")) {
						%>
						<div class="mid-nrone1">
							<div class="mid-nrone2" onMouseOver="this.style.backgroundColor='#FFCC66'" onMouseOut="this.style.backgroundColor='#FFFFFF'">
								<div class="mid-nrone4">
									<img src="images/mid-06.gif" width="51" height="55" />
								</div>
								<div class="mid-nrone5">
									<div class="mid-nrone6">
										<font color="#a9a9a9"><%=param_code%> </font>
									</div>
									<div class="mid-nrone7">
										<a href="<%=link_url%>" TARGET=appwin onClick="mydefss()"><font color="red"><b><%=note_name%> </b> </font> </a>
										<br />
										<%=note_desc%>
									</div>
								</div>
							</div>
						</div>
						<%
						} else {
						%>
						<div class="mid-nrone1">
							<div class="mid-nrone2" onMouseOver="this.style.backgroundColor='#FFCC66'" onMouseOut="this.style.backgroundColor='#FFFFFF'">
								<div class="mid-nrone4">
									<img src="images/mid-06.gif" width="51" height="55" />
								</div>
								<div class="mid-nrone5">
									<div class="mid-nrone6">
										<%
										if (rsrv_str1 == "0" || rsrv_str1.equals("0")) {
										%>
										<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onClick="mydefss()"><%=thmenuName%> </a>
										<%
										} else {
										%>
										<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onClick="mydefss()"><%=thmenuName%> </a>
										<%
										}
										%>
									</div>
								  <div class="mid-nrone7">
										<%=thmenudesc%>
								  </div>
								</div>
							</div>
						</div>
						<%
									}
									}
								}
							}
						%>
					</td>
				</tr>
			</tbody>
		</table><br>
		<TABLE cellSpacing="0" cellPadding="0" width="98%" border="0">
			<TBODY>
				<TR>
					<TD vAlign="top" bgcolor="#ffffff">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
							  <td>
									<table cellspacing="0" cellpadding="0" width="100%" border="0">
										<tbody>
											<tr>
												<td class="mtitle">
													本网服务
												</td>
											</tr>
										</tbody>
									</table>
									<TABLE style="BORDER: #85aad6 1px solid;" cellSpacing="0" cellPadding="8" width="100%" align="center" border="0">
										<TBODY>
											<TR>
												<TD class="t14" noWrap bgColor="#ffffff" height="24">
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td>
																<a href="/service/vip.html" target="_blank"><img src="images/192x96_070719_anquan.gif" width="171" height="93" border="0"> </a>
															</td>
															<td>
																<a href="/service/keyword.html" target="_blank"><img src="images/192x96_070719_jingjiapaimin.gif" width="171" height="93" border="0"> </a>
															</td>
															<td>
																<a href="/service/webad.html" target="_blank"><img src="images/192x96_070719_mingqi.gif" width="171" height="93" border="0"> </a>
															</td>
															<td>
																<a href="/service/website.html" target="_blank"><img src="images/192x96_070719_shangbiao.gif" width="171" height="93" border="0"> </a>
															</td>
														</tr>
													</table>
												</TD>
											</TR>
										</TBODY>
								  </TABLE>
									<br>
									<table cellspacing="0" cellpadding="0" width="100%" border="0">
										<tbody>
											<tr>
												<td class="mtitle">
													联系我们
												</td>
											</tr>
										</tbody>
									</table>
									<TABLE style="BORDER: #85aad6 1px solid;" cellSpacing="0" cellPadding="8" width="100%" align="center" border="0">
										<TBODY>
											<TR>
												<TD class="t14" noWrap bgColor="#ffffff" height="24">
													<TABLE cellSpacing="0" cellPadding="0" width="98%" align="center" border="0">
														<TBODY>
															<TR>
																<TD align="right" width="3%" height="20">
																	·&nbsp;
																</TD>
																<TD class="eng" width="97%" height="18">
																	想了解更多服务内容？请联系我们。电话：0551-5310317
																	<img src="images/ppc.gif">
																</TD>
															</TR>
															<TR>
																<TD align="right" width="3%" height="20">
																	·&nbsp;
																</TD>
																<TD class="t12line" height="18">
																	关于本网站技术方面的问题，请联系
																	<A href="mailto:sales@bizoss.com">sales@bizoss.com</A>
																</TD>
															</TR>
															<TR>
																<TD align="right" height="20">
																	·&nbsp;
																</TD>
																<TD class="eng" height="18">
																	在线客服：
																	<a href="tencent://message/?uin=578778707&Site=bizoss&Menu=yes"><img border="0" SRC=/images/qq.gif alt="系统客服QQ"> </a>
																</TD>
															</TR>
														</TBODY>
													</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
							  </td>
							</tr>
						</table>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<!-- 
		<span id='img' style='position:absolute;' onmouseover='mystop()' onmouseout='start()'><a href='/zone_b2b/school/' target='_blank'><img src='images/LogoMaker.gif' width='88' height='31' border='0'> </a> </span>
		<script language='JavaScript'>
			var xPos = 0;var yPos = 0; var step = 1;var delay = 10;var height = 0; var Hoffset = 0;var Woffset = 0; var yon = 0;var xon = 0; var xon = 0; var interval;
			var img = document.getElementById('img');
			img.style.top = 0;
			function changePos(){
			width = document.body.clientWidth;
			height = document.body.clientHeight;
			Hoffset = img.offsetHeight;
			Woffset = img.offsetWidth;
			img.style.left = xPos + document.body.scrollLeft;
			img.style.top = yPos + document.body.scrollTop;
			if (yon) {
			yPos = yPos + step;
			
			}else {
			yPos = yPos - step;
			}
			if (yPos < 0) {
			yon = 1;
			yPos = 0;
			}
			if (yPos >= (height - Hoffset)) {
			yon = 0;
			yPos = (height - Hoffset);
			}
			if (xon) {
			xPos = xPos + step;
			}
			else {
			xPos = xPos - step;
			}
			if (xPos < 0) {
			xon = 1;
			xPos = 0;
			}
			if (xPos >= (width - Woffset)) {
			xon = 0;
			xPos = (width - Woffset);
			}
			}
			function start() {
			img.visibility = 'visible';
			interval = setInterval('changePos()', delay);
			}
			function mystop()
			{
			clearInterval(interval)
			}
			 start()
		</script> -->
         <!--底部-->
 <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:20px;">
 <tr>
    <td align="center" height="36">
    	
	 <span style="font-family:Verdana, Arial, Helvetica, sans-serif;">友情链接:
	 	<%
	 	 if(linkList !=null)
	 	 {
       String link_name="",link_url="";	 	 
	 	   for(int i=0;i<linkList.size();i++)
	 	   { 
	 	    HashMap map = (HashMap) linkList.get(i);
	 	    if (map.get("link_name") != null)
	 	    {
				 link_name = map.get("link_name").toString();
				}
			 if (map.get("link_url") != null)
	 	    {
				 link_url = map.get("link_url").toString();
				}	 	    	 	  
	 	 %>
	 	  <a href="<%=link_url%>">&nbsp;&nbsp;<%=link_name%></a>
	   <%
	     }
	   }
	  %>
	  </span>
	</td>
  </tr>
</table>
<table width="85%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="2" bgcolor="#FF8000"></td>
  </tr>
</table>
<table width="85%" border="0" align="center" cellpadding="6" cellspacing="0">
 <tr>
    <td align="center" width="800px">
    	<script language="javascript" src="/templates/wood/js/footer.js"></script>
   </td>
  </tr>
</table>
	</body>
</HTML>



