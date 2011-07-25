<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%
	String subsys_code = "SYS", menu_class = "1";
	if (request.getParameter("menu_class") != null) 
	{
		menu_class = request.getParameter("menu_class");
	}
	if (request.getParameter("subsys_code") != null) 
	{
		subsys_code = request.getParameter("subsys_code");
	}
	HttpSession left_session = request.getSession();
	String user_name = "", user_id = "", user_class = "", role_code = "", user_type = "",cust_type = "";
	if (left_session.getAttribute("SESSION_USER_NAME") != null) 
	{
		user_name = left_session.getAttribute("SESSION_USER_NAME").toString();
		user_id = left_session.getAttribute("SESSION_USER_ID").toString();
		user_class = left_session.getAttribute("SESSION_CUST_CLASS").toString();
		role_code = left_session.getAttribute("SESSION_ROLE_CODE").toString();
		user_type = left_session.getAttribute("SESSION_USER_TYPE").toString();
		cust_type = left_session.getAttribute("SESSION_CUST_TYPE").toString();
	}
	
	//out.println("user_id===="+user_id+"user_name==="+user_name+"menu_class===="+menu_class+"user_class====="+user_class+"subsys_code===="+subsys_code+"user_type===="+user_type+"role_code==="+role_code);


	ArrayList firstMenuList = new RightMenu().getLeftMenuList(user_id, cust_type, menu_class, user_class, subsys_code, user_type, role_code);
%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>B2Be-commerce background system</title>
		<link href="images/member.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="/js/prototype.js"></script>
	<script type="text/javascript" src="/member/mainMenu/menu.js"></script>
	<style type="text/css">
	a{color: ##003399;text-decoration: none;}
	a:hover{color: #0066CC;text-decoration: none;}
	</style>
</head>

<body leftmargin="0" topMargin="0" rightmargin="0" bottommargin="0">
<table width="150" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td style="border-right:#85aad6 1px solid; background-color:#dcedfc;">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<TR>
				<TD align="center" height="30"><A  href="/admin/mainMenu/home.jsp" target="main"><img src="/admin/mainMenu/images/backhome.gif" alt="Business page" width="133" height="27" border="0"></A></TD>
			</TR>
			<%
			  if(firstMenuList!=null && firstMenuList.size()>0)
			  {
			  	int index=0;
			    for(int i=0;i<firstMenuList.size();i++)
				{
			      index++;
			      MenuInfo menu=(MenuInfo)firstMenuList.get(i);
			      String m_name="",m_desc="";
			      m_name=menu.getMenu_name(); 
			      m_desc=menu.getMenu_desc();
			      ArrayList children=menu.getChildren();
			      String image="/member/mainMenu/images/1.gif",display="display:none";
			      if(i==0)
				  {
			        image="/member/mainMenu/images/_1.gif";
			        display="display:block";
			       }
			%> 
				<TR>
					<TD class="leftmenutitle" height="31" style="CURSOR: pointer" onClick="javascript:ShowFLT(<%=i%>)">
						<img id="leftmenu<%=i%>" src="<%=image%>" alt="<%=m_desc%>" width="9" height="9"/>
						<%=m_name%>
					</TD>
				</TR>
				<TR  id="LM<%=i%>" style="<%=display%>">
					<TD>
					<table width="100%">
						<%
						if(children!=null && children.size()>0)
						{
						     for(int j=0;j<children.size();j++)
							 {
						     	MenuInfo child=(MenuInfo)children.get(j);
						     	String c_name=child.getMenu_name();
						     	String menu_id=child.getMenu_id();
						     	String menu_desc=child.getMenu_desc();
						     	ArrayList threechild = new RightMenu().getDownMenu(0,menu_id);
						  		if(null==threechild){
						  %>
							<tr>
								<td class="leftmenu">
									<a target="main"  href="/gettradeinterface.do?menu_id=<%=menu_id%>&trade_type_code=0120" title="<%=menu_desc%>"><%=c_name%></a></td>
							</tr>
						 <%}else if(null!=threechild){
						 	  String image3="/member/mainMenu/images/1.gif";
						 	%>
						 <tr>
						 	<td class="" onClick="javascript:ShowChild3('<%=threechild.size()%>','<%=j%>','<%=i%>')" style="cursor: hand">
						 		&nbsp;&nbsp;
						 		<img  src="<%=image3%>"  id="image3<%=j%><%=i%>"  width="9" height="9" />
						 		<font style="FONT-SIZE: 12px; BACKGROUND:  no-repeat 20px 6px; LINE-HEIGHT: 22px; TEXT-ALIGN: left; COLOR: #BE2626;"><%=c_name%></font>
							</td>
						</tr>
						 		<%for(int t = 0; t<threechild.size(); t++){
						 			HashMap child3=(HashMap)threechild.get(t);
						     		String c_name3="";//child.getMenu_name();
						     		String menu_id3="";//child.getMenu_id();
						     		String menu_desc3="";//child.getMenu_desc();
						     		if(child3.get("menu_name")!=null){
						     			c_name3 = child3.get("menu_name").toString();
						     		}
						     		if(child3.get("menu_id")!=null){
						     			menu_id3 = child3.get("menu_id").toString();
						     		}
						     		if(child3.get("menu_desc")!=null){
						     			menu_desc3 = child3.get("menu_desc").toString();
						     		}
						 	%>
							<tr  id="childt<%=t%><%=j%><%=i%>" style="display:none" >
								<td class="leftmenu" style=" padding-left:10px;">
									<a target="main"  href="/gettradeinterface.do?menu_id=<%=menu_id3%>&trade_type_code=0120" title="<%=menu_desc3%>">
									<font style="FONT-SIZE: 12px; BACKGROUND: url(lujian_1.gif) no-repeat 20px 6px; LINE-HEIGHT: 22px; TEXT-ALIGN: left; COLOR: #BE2626;"><%=c_name3%></font></a>
									</td>
							</tr>
						 <%
						 		}
						 	}
						 }
						}%>
						</table>
					</TD>
				</TR>
				<%}
			}%>
	  </table></td></tr></table>
</body>
</html>
<script language="javascript" id="clientEventHandlersJS">
			<!--
			var number=<%=firstMenuList.size()%>;
			
			function LMYC() 
			{
				var lbmc;
			 	var treePic;
				for (i=0;i<number;i++) 
				{
					lbmc = eval('LM' + i);
					treePic = eval('leftmenu'+i);
					treePic.src = '/member/mainMenu/images/1.gif';
					lbmc.style.display = 'none';
				}
			}
			 
			function ShowFLT(i) 
			{
				lbmc = eval('LM' + i);
				treePic = eval('leftmenu' + i)
				if (lbmc.style.display == 'none') 
				{
					LMYC();
					treePic.src = '/member/mainMenu/images/_1.gif';
					lbmc.style.display = '';
				}
				else 
				{
					treePic.src = '/member/mainMenu/images/1.gif';
					lbmc.style.display = 'none';
				}
			}
			function ShowChild3(number3,val,vl)
			{
				var isrc= document.getElementById('image3'+val+''+vl).src;
				if(isrc=='http://b2b.bizoss.com/member/mainMenu/images/_1.gif'){
					document.getElementById('image3'+val+''+vl).src = 'http://b2b.bizoss.com/member/mainMenu/images/1.gif';
					for (i=0;i<number3;i++){
						document.getElementById('childt'+i+val+''+vl).style.display = 'none';
						}
				}
				if(isrc=='http://b2b.bizoss.com/member/mainMenu/images/1.gif'){
					document.getElementById('image3'+val+''+vl).src = 'http://b2b.bizoss.com/member/mainMenu/images/_1.gif';
					for(j=0;j<number3;j++){
						document.getElementById("childt"+j+''+val+''+vl).style.display = 'block';
						//alert(document.getElementById("childt"+j+val+''+vl).style.display);
					}
				}
			}
			//-->
</script>



