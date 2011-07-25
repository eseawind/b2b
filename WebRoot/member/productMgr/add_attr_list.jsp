<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="orderBean" class="com.saas.biz.formStateMgr.FormStateInfo" scope="page" />
<jsp:useBean id="comParam" class="com.saas.biz.commen.ParamethodMgr" scope="page"/>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%@ page import="com.saas.biz.addproductattrMgr.*"%>
<html>
<head>
<title>查看产品属性</title>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductAttrInfo.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
</head>
<body>
<%
    HttpSession  logsession = request.getSession(); 
    String cust_id = "",class_id="";
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("class_id") != null)
    {
        class_id = request.getParameter("class_id");
    }
    AddProductAttrInfo group=new AddProductAttrInfo();
    ArrayList tableList =group.getProductById(cust_id,class_id);
%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="13" align="left">
	    </td>
	  </tr>
	  <tr>
	    <td>
		     <table width=727 border=0 cellpadding=2 cellspacing=1 align=center  bgcolor="#e7e7e7">
		        <tr>
			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">属性名称</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=left width="85%">属性值</td>
		        </tr>
		       <%
		       int size=0;
		         if(tableList !=null && tableList.size()>0){
		         size=tableList.size();
		         for(int i=0;i<tableList.size();i++){
		           HashMap map=(HashMap)tableList.get(i);
		           String attr_name="",attr_id="";
		           if(map.get("class_id")!=null){
		             class_id=map.get("class_id").toString();
		           }
		           if(map.get("attr_id")!=null){
		             attr_id=map.get("attr_id").toString();
		           }
		           if(map.get("attr_name")!=null){
		             attr_name=map.get("attr_name").toString();
		           }
		       %>
		        <tr style="background-color:#f9f9f9;"id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
	              <td style="color:#000000;" align="center"><%=attr_name%></td>
	               <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name="<%=attr_name%>&<%=attr_id%>" id="attr_value<%=i%>"></td>
	            </tr>
	            <%}%>
		       <%}%>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13"><input type="hidden" id="size" name="size" value="<%=size%>"></td>
	  </tr>
	</table>
</body>
</html>




