<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%><%@ 
taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%><%@ 
taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<%@ page contentType="text/html;charset=gbk"%>
<% 

// 检查指定的用户名或客户名是否存在，该页面用于 AJAX
String custName= request.getParameter("c");
custName = new String(custName.getBytes("ISO-8859-1"),"gbk");
if(custName == null || custName.length() == 0)
{
	out.print("0");
	out.close();
}
else
{
	Custinfo custinfo = new Custinfo();
  //	boolean result = custinfo.checkCustName(custName);
   int  result = custinfo.checkCustName(custName);
	if(result>=1)
		out.print("1");
	else
		out.print("0");
}
%>



