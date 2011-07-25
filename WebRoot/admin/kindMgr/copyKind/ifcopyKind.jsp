
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<%
    Productclass product=new Productclass();
		String class_id = "";
	  String uptype="";
	   boolean flagExst=false;
	   String flagName="";
	HttpSession logsession = request.getSession();
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id");
	}
	if (request.getParameter("uptype") != null) {
		uptype = request.getParameter("uptype");
	}
		if(!class_id.equals("")){			  		  
			   flagName=product.getClassNameById(class_id);
			   flagExst=product.isExsit("000000000000000",uptype,flagName);			  
			  }
			  
			  if(flagExst)
			  {
			   out.print(flagName);
			  }
			  else
				 out.print("");
		%>



