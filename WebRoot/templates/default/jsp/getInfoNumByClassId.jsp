
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="infoList" class="com.saas.biz.infoListMgr.InfoList" scope="page"></jsp:useBean>
<%
	String class_id="",type="";
	if(request.getParameter("class_id")!=null){
		class_id = request.getParameter("class_id");
	}
	if(request.getParameter("type")!=null){
		type = request.getParameter("type");
	}
	String infoNum=infoList.getInfoNumByClassId(class_id,type);
	if(!infoNum.equals("")){
		out.print( "document.write('("+infoNum+")');");
	}else{
		out.print( "document.write('("+0+")');");	
	}
%>



 
 



