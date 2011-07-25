<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
    HttpSession  logsession = request.getSession(); 
    String session_cust_id = "";
    String code ="",keyword ="";
    String iStart ="1";
    if (request.getParameter("iStart") != null){
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null){
        session_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("keyword") != null) {
		keyword = request.getParameter("keyword");
		keyword = new String(keyword.getBytes("ISO-8859-1"), "GBK");
	}
	
    Custinfo cust = new Custinfo();
    int counter = 0 ;
    ArrayList List = new ArrayList();
    if (code != "1" || !code.equals("1")) {
    	List = cust.getCustomerListLikeCust(Integer.valueOf(iStart).intValue(),"2" ,keyword);
    	counter = cust.getCustomerListLikeCust("2" ,keyword);
    }else{
	    List = cust.getCustomerListByCust(Integer.valueOf(iStart).intValue(),"2");
	    counter = cust.getCustomerListByCust("2");
    }
    String pageTools=tools.getPageTools(String.valueOf(counter),"20","index.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
<script type="text/javascript">
function checkRelation(){
    if(document.getElementById("keyword").value!=""){
       document.getElementById("code").value="1";
       sumbimtData();
    }else{
      alert('请输入正确的客户名称，否则会影响你的查询结果！');
      document.getElementById("keyword").focus();
    }
  }
  function sumbimtData(){
    document.relationForm.submit();
  }

</script>
<style type="css">
.tbg{ 
	background-color:#dddddd
}
.bt{ 
	background:url(../images/btbg.gif); 
	color:#003077;  
	font-weight:bold; 
	font-size:12px;
}
.bfoot{ 
	background-color:#f6f6f6
}
</style>
</head>
<body>
	<form name="relationForm" id="relationForm" action="index.jsp" method="post">
	<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="ii3i2n2mB092X0G85Be1" />
		</jsp:include>

			<table width="800" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#DEEDFD">
				<tr class="u2">
					<td  align="right">
						客户名称:&nbsp;
						<input type="text" maxlength="50" name="keyword" id="keyword">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="查询" onclick="checkRelation()" style="cursor: hand">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="code" id="code" value="1">
					
					</td>
				</tr>
			</table>
		     <table width=800 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
		        <tr class="u4" height="25">
			        <td  align=center width="20%">客户名称</td>
					<td  align=center width="20%">联系地址</td>
					<td align=center width="10%">联系电话</td>
					<td align=center width="15%">网址</td>
					<td align=center width="15%">Email</td>
					<td  align=center width="10%">加入时间</td>
					<td  align=center width="5%">排名</td>
		        </tr>
		        <%
		            if(List != null && List.size()>0)
		            {    int i=0;
		              	 for (Iterator it = List.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String cust_id = "";
						        String cust_name = "";
						        String company_address = "";
						        String website = "";
						        String email = "";
						        String group_contact_phone="";
						        String publish_date ="";
						        if(map.get("cust_id") != null){
						           cust_id = map.get("cust_id").toString();
						        }
						        if(map.get("cust_name") != null){
						           cust_name = map.get("cust_name").toString();
						        }
						        if(map.get("company_address") != null){
						           company_address = map.get("company_address").toString();
						        }
						        if(map.get("group_contact_phone") != null){
						           group_contact_phone = map.get("group_contact_phone").toString();
						        }
						        if(map.get("website") != null){
						           website = map.get("website").toString();
						        }
						        if(map.get("email") != null){
						           email = map.get("email").toString();
						        }
						        if(map.get("publish_date") != null){
						           publish_date = map.get("publish_date").toString();
						           if (publish_date.length()>10)
						           	publish_date = publish_date.substring(0,10);	
						        }
						        %>
						        
						        <tr class="u2" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">
					              <td align=left><a href="/admin/customerMgr/Custinfo.jsp?obj_cust_id=<%=cust_id%>" target="_blank"><%=cust_name%></a></td>
					              <td align=left><%=company_address%></td>
					              <td align=center><%=group_contact_phone%></td>
					              <td align=center><%=website%></td>
					              <td align=center><%=email%></td>
					              <td align=center><%=publish_date%></td>
					              <td align=center><a href="modifyCustorder.jsp?cust_id=<%=cust_id%>" target="_blank"><img src=/images/addUser.png width=20 height=20 border=0></a></td>
					            </tr>
						        <%i++;
					     }
					     %>
					     <tr class="u1">
							<%=pageTools%>
						</tr>
					     
					     <%
				            }else{
						%>
						<tr align=center ><td colspan="7">暂无记录!</td></tr>
						<%}%>
		    </table>
		    </form>
</body>
</html>



