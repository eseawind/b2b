<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="advBean" class="com.saas.biz.advertiseMgr.AdvertiseInfo" scope="page" />
<%
	String reange = "", no = "";
	String content = "";
	if (request.getParameter("range") != null) 
	{
		reange = request.getParameter("range");
	}
	if (request.getParameter("no") != null) 
	{
		no = request.getParameter("no");
	}
	if( Integer.parseInt(no) == 1 )
	{
	 	content = "<iframe marginWidth=\"0\" marginHeight=\"0\" src=\"/adimages/tuijian.html\" frameBorder=\"0\" width=\"980\" scrolling=\"no\" height=\"50\"></iframe>";
	}
	else
	{
  	content = advBean.getAderviseByRange(reange, no);
  }
	out.print(content);
%>





