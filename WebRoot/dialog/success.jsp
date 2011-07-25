<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.tradeTypeMgr.TradeTypeInfo"%>
<%
	request.setCharacterEncoding("GBK");
	response.setCharacterEncoding("GBK");
String from = request.getHeader("referer");
ArrayList list=(ArrayList)request.getAttribute("backQ");
String trade_type_code="";
String trade_id="";
String menu="menu_id=2J0Vn2mMK0G0X0G85BH&info_type=2";
if(list !=null && list.size()>0){
	for(Iterator it = list.iterator();it.hasNext();)
	{
		HashMap infoMap  = (HashMap)it.next();
	    if(infoMap.get("TRADE_TYPE_CODE")!=null)
	     {
		   trade_type_code = infoMap.get("TRADE_TYPE_CODE").toString();
		 }
		 if(infoMap.get("FORM_ID")!=null)
	     {
		   trade_id = infoMap.get("FORM_ID").toString();
		 }
	}
}
String trade_name = "";
TradeTypeInfo tradetype = new TradeTypeInfo();
trade_name = tradetype.getOneTradeName(trade_type_code);
if(trade_type_code=="1076" ||trade_type_code.equals("1076")){
String url="/templateMgr/formListIndex.jsp?trade=0&form_id="+trade_id+"&"+menu;
 from=url;
}
String from2 = from ;
from = new String(from.getBytes("ISO-8859-1"),"gbk");
from2 = new String(from2.getBytes("ISO-8859-1"),"UTF-8"); 
%>
<html>
<head>
	<script language="JavaScript" src="/js/dialog.js"></script>
    <script language="javascript">
    function successredirectit()
    { 
        alert("<%=trade_name%>³É¹¦£¡"); 
		var isIE4  = (navigator.appVersion.indexOf("MSIE 6")==17);
		if(isIE4){
     		  window.location.href("<%=from%>"); 
		}else
		{ 
      		  window.location.href("<%=from2%>"); 
		}//window.open("<%//from%>","newwidow");
        //window.open('','_self','');
        //window.close(); 
    }
    </script>

</head>    
<body onload="successredirectit()">   
    
</body>
</html>



