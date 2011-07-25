<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="tools.util.FileIO"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.Reader"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>



<html>

  <head>   
      <title>±£´æÄ£°å´úÂë</title>   
  </head>   
  <body>   
    
  <%   
    
   
    String   content   =  ""; 
    if (request.getParameter("content") != null)
    {
        content = request.getParameter("content");
    }
    String cust_name="",cust_id="";
	  if (request.getParameter("cust_name") != null)
    {
        cust_name = request.getParameter("cust_name");
    }
    if (request.getParameter("cust_id") != null)
    {
        cust_id = request.getParameter("cust_id");
    }
  String   filename   =   "/usr/www/b2b.bizoss.com/templates/enterprise/"+cust_id+"/" + cust_name;  
  File  f  =  new File(filename);   
   
  try   
  {   
		  PrintWriter pw  = new PrintWriter(new  FileOutputStream(filename));   
		  pw.println(str); 
		  pw.close();   
  }   
  catch(IOException   e)   
  {   
  		out.println(e.getMessage());   
  }   

           

  </body>
</html>











