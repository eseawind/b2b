<style type="text/css">
.add_button{ float:right; background:url(/images/newAdd_button.gif) right top no-repeat; height:24px; width:auto; padding-right:10px; position:relative; z-index:2; top:-5px;}
.add_button span{ float:left; background:url(/images/newAdd_button.gif) left top no-repeat; height:24px; font-size:12px; width:auto; line-height:22px; padding-left:20px;}
	 
.lin0 a:link, .lin0 a:visited, .lin0 a:active{ 
     color:#2E4690;
	 text-decoration:none;
	 }
.lin0 a:hover{ 
	 color: #fff;
	 text-decoration:none;
	 }
</style>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.*"%>

<%
	RightMenu rightMenu = new RightMenu();
	String menu_name="",menu_id="",addLink="",addName = "";
	if(request.getParameter("menu_id")!=null){
		menu_id = request.getParameter("menu_id");
		menu_name = rightMenu.getMenuNameById(menu_id);
	}
	

%>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b><%=menu_name%></b></font></td>
				<td background="/admin/images/content_04.gif" align="right">
				<div class="add_button lin0">
						<span>
							<%
								if(request.getParameter("addLink")!=null){
									addLink = request.getParameter("addLink");
									out.println("<a href="+addLink+" target=_blank>µã»÷ÐÂÔö</a>");
								}
							%>
						</span>
					</div>
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
		<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
         <td>
					 <jsp:include page="/inc/linkMenuInclude.jsp">
						<jsp:param name="menu_id" value="<%=menu_id%>" />
					 </jsp:include>	
				</td>
     </tr>
    </table>
    <input type="hidden" name="menu_id" id="menu_id" value="<%=menu_id%>">
    




