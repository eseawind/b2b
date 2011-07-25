<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.saas.biz.linkmenuMgr.LinkmenuInfo"%>
<%
	String menu_id = "";
  if(request.getParameter("menu_id")!=null){
 		 menu_id = request.getParameter("menu_id");
  }
  String linkMenu = new LinkmenuInfo().getLinkMenuByMenuId(menu_id);
%>
<%
	if(linkMenu.length()>0){
%>

		<table width="100%" border="0" cellspacing="0" cellpadding="0" background="/images/newsbg.gif" height="28">
		  <tr>
		    <td width="100%">
					<div style="float:left; width:atuo;font-size:14px;">
						&nbsp;&nbsp; <b>¹ØÁª²Ù×÷:</b>&nbsp;&nbsp; &nbsp;&nbsp;
						¡¾<%=linkMenu.substring(0,linkMenu.length()-1)%>
					</div>	
				</td>
			</tr>
		</table>
<%
	}
%> 



