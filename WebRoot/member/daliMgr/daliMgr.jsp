<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	 request.setCharacterEncoding("gbk");
     String start_time1 ="",end_time1 ="",code="",key_word="";
     Calendar cal = Calendar.getInstance();
     if (request.getParameter("start_time") != null) {
		start_time1 = request.getParameter("start_time");
	}
	if (request.getParameter("end_time") != null) {
		end_time1 = request.getParameter("end_time");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word").trim();
	}
	
	String top_menu_id="";
	if(request.getParameter("menu_id")!=null){
		top_menu_id = request.getParameter("menu_id");
	}
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>
<%
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
	int counter = 0 ;
	ArrayList saleList = new ArrayList();
	if("1".equals(code)){
		saleList = saleObj.gentSalesByCust_idKey(Integer.valueOf(iStart).intValue(), cust_id,key_word,"2");
		counter = saleObj.getSaleListNumberByKey(cust_id,key_word,"2");
	}else if("2".equals(code)){
		saleList = saleObj.gentSalesByCust_idDate_T(Integer.valueOf(iStart).intValue(), start_time1,end_time1,"2");
		counter = saleObj.getSaleListNumberByDate_T(start_time1,end_time1,"2");
	}else{
		saleList = saleObj.gentSalesByCust_id(Integer.valueOf(iStart).intValue(), cust_id,"2");
		counter = saleObj.getSaleListNumber(cust_id,"2");
	}
	String pageTools=tools.getPageTools(String.valueOf(counter),"30","modifyIndex.jsp?&code="+code+"&menu_id="+top_menu_id+"&key_word="+key_word+"&start_time="+start_time1+"&end_time="+end_time1+"&iStart=",Integer.parseInt(iStart));
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
			<script language="javascript">
				function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
				function delAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								if(document.getElementById('re_news'+i).checked==true){
									document.getElementById('re_news'+i).checked = false;	
								}else{
									document.getElementById('re_news'+i).checked = true;		
								}
						}
				}
				function reloadNews(val){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						/*
						document.getElementById('sale_id').value = all_news_id;
						document.indexdateform.action='/doTradeReg.do';
						document.indexdateform.submit();
						*/
						
						document.getElementById('sale_id').value = all_news_id;
						document.getElementById('root_id').value = all_news_id;
						document.getElementById('info_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else {
							if(val=='1'){
								document.indexdateform.action='/doTradeReg.do';
								document.indexdateform.submit();
							}
							if(val=='2'){
									document.indexdateform.action='/doTradeReg.do';
									document.getElementById("trade_type_code").value="5595";
									document.indexdateform.submit();
								}
						}
				}
				
		</script>
	</head>
	<body>

	<form action="daliMgr.jsp" method="post" name="indexdateform">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addSale.jsp">新增代理信息</a>
				</td>
			</tr>
		</table>

		<table  width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
			<tr class="u1">
				<td align="left">
					开始时间:<input type="text" id="start_time" name="start_time" onfocus="setday(this);" value="<%=start_time%>">
					结束时间:<input type="text" id="end_time" name="end_time" onfocus="setday(this);" value="<%=end_time%>">
				<input class="chaxun" type="button" name="comit" value="" onclick="Check_Value();" style="cursor: hand;">
					<input type="hidden" name="code" value="2">
				</td>				
			</tr>
		</table>		
		<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">		
			<tr class="u1">
				<td align="left">
				关键字:<input type="text" id="keyword1" name="key_word"  value="">
							 <input type="hidden" id="menu_id" name="menu_id"  value="<%=top_menu_id%>">
				<input class="chaxun" type="button" name="comit" value=""  onclick="search();" style="cursor: hand;">
				</td>
			</tr>
		</table>
		<%if(null==saleList) {%>
			没有您要查询的记录。
		<%} else{%>
		<table width=100% border="0" cellpadding="1" cellspacing="1" align=center bgcolor="#DEEDFD" style="margin-top:13px">
			<tr class="u4" height="25">
				<td  align=left width="20%">
					销售标题
				</td>
				<td align=left width="20%">
					开始日期
				</td>
				<td  align=left width="20%">
					结束日期
				</td>
				<td   align=center width="10%">
					修改
				</td>
				<td width="20%" align="center">
						<input type="button" name="reload" value="删除" onclick="reloadNews(2)"/>
						<input type="button" name="reload" value="重发" onclick="reloadNews(1)"/>
						<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
						<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
				</td>
			</tr>
			<%
					if (saleList != null && saleList.size() > 0) {
					int size = saleList.size();
					for (int i=0;i<saleList.size();i++) {
						HashMap map = (HashMap)saleList.get(i);
						String sale_id = map.get("sale_id").toString();
						String title = "";
						String sale_addr = "";
						String start_date = "";
						String end_date = "";
						
						if (map.get("title") != null) {
					      title = map.get("title").toString();
					      if(title.length()>17){
					      	title = title.substring(0,17)+"...";
					      }
						}
						if (map.get("sale_addr") != null) {
					        sale_addr = map.get("sale_addr").toString();
						}
						if (map.get("start_date") != null) {
					        start_date = map.get("start_date").toString();
							if (start_date.length() > 10) {
								start_date = start_date.substring(0, 10);
							}
						}
						
						if (map.get("end_date") != null) {
					        end_date = map.get("end_date").toString();
							if (end_date.length() > 10) {
								end_date = end_date.substring(0, 10);
							}
						}
			%>
			<tr class="u2">
				<td  align=left>
					<a href="viewsaleinfo1.jsp?sale_id=<%=sale_id%>" title=<%=title%> target="_self"><%=title%>
					</a>
				</td>
				<td  align=left>
					<%=start_date%>
				</td>

				<td  align=left>
					<%=end_date%>
				</td>
				<td   align=center>
					<a href=modifySaleInfo.jsp?sale_id=<%=sale_id%> ><img src=/images/edit.gif width=16 height=16 border=0 alt="修改代理信息">
					</a>
				</td>
				<td style="color: #000000;" align=center>
						<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=sale_id%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
						
				</td>
			</tr>
			<%}
				}
			%>
			<tr class="u1">
				<%=pageTools%>
			</tr>
		</table>
	<%}%>
	<input type="hidden" name="trade_type_code" value="8726" />
	<input type="hidden" name="sale_id" value="" id="sale_id">
	<input type="hidden" name="root_id" value="" id="root_id">
	<input type="hidden" name="info_id" value="" id="info_id">
</form>
	</body>
</html>




