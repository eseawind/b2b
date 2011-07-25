<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.custMgr.Custinfo" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html> 
	<head>
		<meta name = "Generator" content = "Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B电子商务后台管理系统</title>
	</head>
<script language="javascript" src="/js/recomMgr.js"></script>

<body>
<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="6XWK125L83j44D2" />
		</jsp:include>	
<table width="800" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7">
  <tr>    
    <td background="/images/newsbg.gif" style=" color:#000000;  font-weight:bold; font-size:13px;" align="center" width="7%">序号</td>
    <td background="/images/newsbg.gif" style=" color:#000000;  font-weight:bold; font-size:13px;"  align="center" width="25%">客户名称</td>
    <td background="/images/newsbg.gif" style=" color:#000000;  font-weight:bold; font-size:13px;"  align="center" width="20%">联系电话</td>
    <td background="/images/newsbg.gif" style=" color:#000000;  font-weight:bold; font-size:13px;"  align="center" width="35%">地址</td>
    <td background="/images/newsbg.gif" style=" color:#000000;  font-weight:bold; font-size:13px;"  align="center" width="10%">操作</td>
  </tr>
<%
    Custinfo	  custEntity=new Custinfo();
    ArrayList custArray = custEntity.getCustListByResume();
	if(custArray != null  && custArray.size()>0)
	{
		int i=0;
		for (Iterator inIt = custArray.iterator(); inIt.hasNext();)
	    {
		    HashMap map = (HashMap) inIt.next();
		    String cust_id="";
		    String cust_name="";
		    String phone="";
		    String cust_addr="";
	   	    cust_id=map.get("cust_id").toString();
	   	    cust_name=map.get("cust_name").toString();
	   	    if(map.get("group_contact_phone")!=null)
	   	    {
	   	      phone=map.get("group_contact_phone").toString();
	   	    }
	   	    if(map.get("company_address")!=null)
	   	    {
	   	      cust_addr=map.get("company_address").toString();
	   	    }
   %>
	<tr style="background-color:#f9f9f9; " >
	<td style=" color:#000000;" align="center"><%=String.valueOf(i+1)%></td>
    <td style=" color:#000000;" align="left"><%=cust_name%></td>
    <td style=" color:#000000;" align="left"><%=phone%></td>
     <td style=" color:#000000;" align="center"><%=cust_addr%></td>
	<td style=" color:#000000;" align="center"><a href=/doTradeReg.do?cust_id=<%=cust_id%>&trade_type_code=0331 target="_self"  onClick="return chechIfo()"><img src=/img/edit.gif width=16 height=16 border=0></a></td>
    </tr>
	<%
	   i++;
		}
	}
   %>
   <tr><td   colspan=7 >&nbsp;</td></tr>
</table>
	<body>
</html>




