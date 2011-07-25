<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import ="com.saas.biz.commen.*"%> 
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html> 
	<head>
		<meta name = "Generator" content = "Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>Struts Form for paradateForm</title>
		 
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
			h1 {float:left;padding-left:8px; font-size:15px; font-weight:bold; padding-top:5px;}
		</style>
	</head>
<script language="javascript">
function confirmremove()
{
	if(confirm('是否确认分配')) 
	{
		return true;
	}
	else
	{
		return false;
	}
}
</script>
<body>  
<h5></h5><br>
<table width="727" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7" >
  <tr>    
    <td  class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="30%">序号</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align="center" width="30%">客户级别</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="40%">操作</td>
  </tr>
<%
	ArrayList ClassList = new ArrayList();
    ParamethodMgr  compars  = new ParamethodMgr();
    String menu_id  = request.getParameter("menu_id");  
    String menu_class  = request.getParameter("menu_class"); 
	ClassList  = compars.getCompareInfo("CRM","cust_class");
	int xuhao =0;
	if(ClassList!=null && ClassList.size()>0)
	{
		for (Iterator its = ClassList.iterator(); its.hasNext();) 
	    	{  
	    		xuhao = xuhao +1;
	    		String  class_code = "";
	    		String  class_name = "";	
			HashMap classMap = (HashMap) its.next();
			class_name  =  classMap.get("para_code2").toString();
			class_code   = classMap.get("para_code1").toString();
			%>
			<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=xuhao%>" onmouseover="MM_changeProp('changcolor_tr<%=xuhao%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=xuhao%>','','backgroundColor','#f9f9f9','DIV')">
			<td style=" color:#000000;" align="center"><%=xuhao%></td>
	      	<td style=" color:#000000;" align="center">〖<%=class_code%>级〗
	     	<%=class_name%></td>
			<td style=" color:#000000;" align="center">    
			<a  href="/doTradeReg.do?trade_type_code=0905&class_code=<%=class_code%>&menu_id=<%=menu_id%>&menu_class=<%=menu_class%>"  target="_self" onClick="return confirmremove()">
	   		分配给</a>【<%=class_name%>】
	    	</td>
	    	</tr>
			<% 	 
		}
  }	
%>
<tr><td   colspan=7 class="line1">&nbsp;</td></tr>
</table>
	<body>
</html>



