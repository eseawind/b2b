<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	 request.setCharacterEncoding("gbk");
	 		String info_id ="";
			String cust_name = "";
			String title = "";
			String stock_addr = "";
			String start_date = "";
		  String end_date="";
		  String contents="";
			boolean flag=false;
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	SaleInfo saleObj = new SaleInfo();
	Stockorderinfo stockObj = new Stockorderinfo();
	int counter = 0 ;
	ArrayList saleList = new ArrayList();

		saleList = saleObj.stockCommend(Integer.valueOf(iStart).intValue(), 20);
		counter = saleObj.stockCommend();
		//saleList = stockObj.getStockListByAll(Integer.valueOf(iStart).intValue(), cust_id);
		//counter = stockObj.getStockListNumber(cust_id);
	String pageTools=tools.getPageTools(String.valueOf(counter),"30","stockRecommend.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
	.chaxun{
			background:url(/admin/images/chaxun.gif) left center no-repeat;
			width:70px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	<script language="javascript" src="/js/saleMgr.js"></script>
		
	</head>
	<body>

	<form action="modifyIndex.jsp" method="post" name="indexdateform">
	  	 <!--table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			<td height="30"> 
			</td>
			</tr>
      <tr>
			  <td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>求购推荐</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;</td>						
				<td background="/admin/images/content_04.gif" align="right">&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>				

		  </tr>
	  </table-->
		<table width=100% border="0" cellpadding="1" cellspacing="1" align=center bgcolor="#FCB0B0" style="margin-top:13px">
			<tr class="u4" height="25">
				<td  align=left width="20%">
					求购说明
				</td>

				<td align=left width="20%">
					求购地址
				</td>
				<td  align=left width="10%">
					开始日期
				</td>
				<td   align=left width="10%">
				  结束日期
				</td>
				<td  align=center width="10%">
					推荐
				</td>
			</tr>
			<%
					if (saleList != null && saleList.size() > 0) {
					int size = saleList.size();
					for (int i=0;i<saleList.size();i++) {
						HashMap map = (HashMap)saleList.get(i);
						if (map.get("contents") != null) {
					      contents = map.get("contents").toString();
					      if(contents.length()>1&&contents.substring(0,1).equals("1"))
					      flag=true;
					    else
					    	 flag=false;
						}					
						if (map.get("info_id") != null) {
					      info_id = map.get("info_id").toString();
						}
						if (map.get("title") != null) {
					      title = map.get("title").toString();
					      if(title.length() > 17 ){
					      title = title.substring(0,17)+"...";
					      }
						}
						if (map.get("stock_addr") != null) {
					        stock_addr = map.get("stock_addr").toString();
						}
						if (map.get("start_date") != null) {
					    start_date=map.get("start_date").toString();
					    start_date=start_date.substring(0,10);
						}
						
						if (map.get("end_date") != null) {
					      end_date=map.get("end_date").toString();
					        end_date=end_date.substring(0,10);
						}
			%>
			<tr class="u2">
				<td  align=left>
					<a href=/member/stockMgr/viewStockInfo.jsp?stock_id=<%=info_id%> TARGET=_self>
						<%=title%>
					</a>
					
				</td>
				<td  align=left>
					<%=stock_addr%>
				</td>

				<td  align=left>
					<%=start_date%>
				</td>
					<td  align=left>
					<%=end_date%>
				</td>
				<%if(flag){%>
				<!--td  align=center>
						<a href=/doTradeReg.do?contents=00&cust_id=<%=info_id%>&trade_type_code=9007 target="_self"><img src=/images/delete.gif width=16 height=16 border=0 alt="取消推荐">
				</td-->
					<td  align="center">已推荐&nbsp;<font color="red">[<a href="/doTradeReg.do?contents=00&cust_id=<%=info_id%>&trade_type_code=9007" target="_self">取消</a>]</font></td>
       <%}else{%>
	      <td  align=center>
					<a href=/doTradeReg.do?cust_id=<%=info_id%>&trade_type_code=2323 TARGET=_self><img src=/images/edit.gif width=16 height=16 border=0 alt="求购推荐">
					</a>
				</td>

    <%}%>
			</tr>
			<%}
				}
			%>
			<tr class="u1">
				<%=pageTools%>
			</tr>
		</table>
	<input type="hidden" name="trade_type_code" value="8726" />
	<input type="hidden" name="sale_id" value="" id="sale_id">
</form>
	</body>
</html>




