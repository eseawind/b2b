<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="java.net.*" %>
<%
	loggerMgr logger = new loggerMgr(); 
	String host = "";
	String www="";
	String ver="";
	String web="";
	if (request.getParameter("h") != null)
    {
        host = request.getParameter("h");
    }
    if (request.getParameter("w") != null)
    {
        www = request.getParameter("w");
    }
    if (request.getParameter("v") != null)
    {
        ver=  request.getParameter("v");
    }
    if (request.getParameter("web") != null)
    {
        web = request.getParameter("web");
        web = URLDecoder.decode(web);
    }
    try
	{	
		web =new String(web.getBytes("ISO8859_1"),"GBK"); 
	} 
	catch (Exception e)
	{	
		System.out.println("SQLERROR:"+e.getMessage());				
	}
    logger.AddRunnfo(host,www,ver,web);	
	 
%>




