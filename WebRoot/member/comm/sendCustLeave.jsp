<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="enqBean" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page" />
<%
	String cust_id = "", iStart = "1",link_Page="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("cust_id") != null) {
		cust_id = request.getParameter("cust_id");
	}
	link_Page="/zone_b2b/enterprise/customer/"+cust_id+"/leavel.htm";
	HttpSession logsession = request.getSession();
	String user_name = "游客",user_idx="";
	if (logsession.getAttribute("SESSION_USER_NAME") != null) {
		user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_idx = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	ArrayList list = enqBean.getCustomerEnqList(Integer.parseInt(iStart), 3, cust_id,"5");
	int counter = enqBean.getCustomerEnqCount(cust_id,"5");
	String pageTools = tools.getPageTools(String.valueOf(counter), "3", link_Page+"?cust_id=" + cust_id + "&iStart=", Integer.parseInt(iStart));
%>
<style type="text/css">
<!--
P,td,tr,table,text{word-break:break-all;}
-->
</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/js/custLeave.js"></script>
		<form action="/doTradeReg.do" name="loginForm" method="post" target="_self">
		<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>	
				<td>
			<%
				 if ( list != null && list.size() > 0 )
				 {
				   for( int i = 0; i < list.size(); i++ )
				   {
				     HashMap map = ( HashMap ) list.get(i);
				     String rsrv_str3="",rsrv_str5="",content="";
				     if(map.get("rsrv_str3") != null )
					 {	rsrv_str3 = map.get("rsrv_str3").toString(); }
				     if(map.get("rsrv_str5") != null )
					 { rsrv_str5 = map.get("rsrv_str5").toString(); }
				     if(map.get("enquiry_content") != null )
					 { 
					 	content = map.get("enquiry_content").toString(); 
						 
					 }
				     %>
				 <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#eeeeee">
                  <tr>
                    <td colspan="2" bgcolor="#FFFFFF"><%=rsrv_str3%>:<%=rsrv_str5%></td>
                  </tr>
                  <tr>
                    <td width="13%" align="right" bgcolor="#F6F6F6">留言内容:</td>
                    <td width="87%" bgcolor="#FFFFFF"><%=content%></td>
                  </tr>
                 </table>
				 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr><td height="5"></td></tr>
				 </table>
				<%
				   }
				%>
                <table width="94%" border="0" align="center" cellpadding="5" cellspacing="0">
                  <tr>
                     <td align="right"><%=pageTools%></td>
                  </tr>
                </table>
				<%
				}
				%>
		  	  </td>
			 </tr>
			</table>  
		    <table width="94%" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#eeeeee">
			  <tr>
			   <td colspan="2" bgcolor="#FFFFFF">发表留言</td>
			  </tr>
			  <tr>
			    <td align="right" bgcolor="#F6F6F6">用户名:</td>
			    <td bgcolor="#FFFFFF"><input type="text" name="rsrv_str3" id="rsrv_str3" maxlength="100" size="20" value="<%=user_name%>"class="biaodan"><span style="color:red">*</span></td>
			 </tr>
			 <tr>
			  <td align="right" bgcolor="#F6F6F6">E-mail:</td>
			  <td bgcolor="#FFFFFF"><input type="text" name="rsrv_str5" id="rsrv_str5" size="25" maxlength="50" class="biaodan">
				<span style="color:red">*</span></td>
			 </tr>
			 <tr>
			   <td width="13%" align="right" bgcolor="#F6F6F6">留言内容:</td>
			   <td width="87%" bgcolor="#FFFFFF">
			   <textarea name="content" id="content" cols="45" rows="6" class="biaodan" style="width:350; height:120;"></textarea>
				<span style="color:red">*</span>
			   </td>
				
			 </tr>
             <tr>
                <td align="right" bgcolor="#F6F6F6">&nbsp;</td>
                <td bgcolor="#FFFFFF">
					  	<input type="hidden" name="rsrv_str4" id="rsrv_str4">
						<input type="hidden" name="session_user_id" name="session_user_id" value="<%=user_idx%>" >
						<input type="hidden" name="session_cust_id" name="session_cust_id" value="<%=cust_id%>" >
						<input type="hidden" name="cust_id" name="cust_id" value="<%=cust_id%>" >
						<input type="hidden" name="user_id" name="user_id" value="<%=cust_id%>" >
						<input type="hidden" name="sale_id" name="sale_id" value="<%=cust_id%>" >
						<input type="hidden" name="deal_tag" name="deal_tag" value="5" >
						<input type="hidden" name="trade_type_code" name="trade_type_code" value="1308" >
						<input type="submit" name="comm" id="comm" value="确认发送留言" onClick=" return checkValue()">
				</td>
               </tr>
              </table>
		</form>
 




