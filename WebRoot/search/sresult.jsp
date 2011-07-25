
<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.searchMgr.SearchJob"%>
<%@ page import="java.lang.Integer"%>
<%@ page import="java.util.*"%>
		<script type="text/javascript">		
			 p = window.location.search.substr(1);
	//		 alert(p);
  //    var parr=p.split("&");
 //    alert(parr[0]);//关键字
  //   alert(parr[1]);//栏目类型；
 //  ajaxFu(parr[0],parr[1]);
		</script>

<% 

// 该页面用于 AJAX
SearchJob rsinfo = new SearchJob();
//request.setCharacterEncoding("gbk");
//String keyword   = request.getParameter("k");
String url=request.getServerName();

String keyword = new String(request.getParameter("k").getBytes("ISO-8859-1"),"GBK");
String tradeTypeCode= request.getParameter("t");
String pageNo=request.getParameter("p");
String result="";
if(!pageNo.equals(""))
{
  int pno=Integer.valueOf(pageNo).intValue();
  result = rsinfo.getSearshRusult(tradeTypeCode,keyword,pno,url);
  out.print(result );
}
else
{
  result = rsinfo.getSearshRusult(tradeTypeCode,keyword,0,url);
 out.print(result );
}

	

%>



