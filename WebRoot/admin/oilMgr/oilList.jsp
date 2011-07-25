<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.lastOilMgr.LastOilInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
    HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
    if (request.getParameter("iStart") != null){
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null){
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    
    LastOilInfo oil = new LastOilInfo();
    ArrayList oilList = oil.getOilListByCust(Integer.valueOf(iStart).intValue(),cust_id);
    int counter = oil.getOilListByCust(cust_id);
    
    String pageTools=tools.getPageTools(String.valueOf(counter),"20","oilList.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
<script language="javascript" src="/js/oilMgr.js"></script>
<style type="css">
.tbg{ 
	background-color:#dddddd
}
.bt{ 
	background:url(../images/btbg.gif); 
	color:#003077;  
	font-weight:bold; 
	font-size:12px;
}
.bfoot{ 
	background-color:#f6f6f6
}
</style>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="13"></td>
	  </tr>
	  <tr>
	    <td>
		     <table class="tbg" width=100% border=0 cellpadding=2 cellspacing=1 align=center >
		        <tr class="bt">
			        <td  align=center width="20%">市场名称</td>
					<td  align=center width="15%">采集时间</td>
					<td align=center width="15%">当前油价</td>
					<td align=center width="15%">浮动类型</td>
					<td align=center width="15%">浮动值</td>
					<td  align=center width="10%">修改</td>
					<td  align=center width="10%">删除</td>
		        </tr>
		        <%
		            if(oilList != null && oilList.size()>0)
		            {    int i=0;
		              	 for (Iterator it = oilList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String commerce_id = "";
						        String commerce_name = "";
						        String get_date = "";
						        String last_price = "";
						        String ud_type = "";
						        String ud_price="";
						        if(map.get("commerce_id") != null){
						           commerce_id = map.get("commerce_id").toString();
						        }
						        if(map.get("commerce_name") != null){
						           commerce_name = map.get("commerce_name").toString();
						        }
						        if(map.get("get_date") != null){
						           get_date = map.get("get_date").toString();
						           if(get_date.length()>10)
						           		get_date = get_date.substring(0,10);
						        }
						        if(map.get("last_price") != null){
						           last_price = map.get("last_price").toString();
						        }
						        if(map.get("ud_type") != null)
						        {
						           ud_type = map.get("ud_type").toString();
						        }	
						        if(ud_type == "1" || ud_type.equals("1")){
						        	ud_type = "上涨";
						        }else if (ud_type == "2" || ud_type.equals("2")){
						        	ud_type = "下跌";
						        }else if (ud_type == "3" || ud_type.equals("3")){
						        	ud_type = "持平";
						        }
						        if(map.get("ud_price") != null){
						           ud_price=map.get("ud_price").toString();
						        }
						        %>
						        
						        <tr  style="background-color:#ffffff; " id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">
					              <td   style=" color:#000000; padding: 2px 5px;" align=center><%=commerce_name%></td>
					              <td   style=" color:#000000;" align=center><%=get_date%></td>
					              <td   style=" color:#000000; padding: 2px 5px;" align=center><%=last_price%></td>
					              <td   style=" color:#000000;" align=center><%=ud_type%></td>
					              <td   style=" color:#000000; padding: 2px 5px;" align=center><%=ud_price%></td>
					              <td   style=" color:#000000;" align=center><a href="modifyoil.jsp?commerce_id=<%=commerce_id%>" target="_blank"><img src=/img/edit.png width=16 height=16 border=0></a></td>
					              <td   style=" color:#000000; padding: 2px 5px;" align=center><a href="/doTradeReg.do?commerce_id=<%=commerce_id%>&trade_type_code=6001" target="_self"  onClick="return oilListchechIfo()"><img src=/img/delete.png width=16 height=16 border=0></a></td>
					            </tr>
						        <%i++;
					     }
					     %>
					     <tr>
							<%=pageTools%>
						</tr>
					     
					     <%
				            }
				        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13"></td>
	  </tr>
	</table>
</body>
</html>


