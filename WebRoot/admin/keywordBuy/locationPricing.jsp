<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%
	String top_menu_id="";
	String iStart = "0";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if(request.getParameter("menu_id")!=null){
		top_menu_id = request.getParameter("menu_id");
	}
	KeyPriceInfo priceInfo = new KeyPriceInfo();
	ArrayList priceList = priceInfo.getAllKeyPriceList();
	int counter = 0;
	if(priceList!=null && priceList.size()>0){
		counter = priceList.size();
	}
	int pages = (counter-1) / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>关键字价格设置</title>
		
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid; font-weight:bold; background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		.td{background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;}
		</style>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		
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
				
				function reloadNews(){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('trade_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else{
									document.proForm.action='/doTradeReg.do';
									document.getElementById("trade_type_code").value="4268";
									document.proForm.submit();
							}
				}
				</script>
	</head>
	<body>
		<form action="" method="post" name="proForm">	
		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
						<a href="addKeyLocation.jsp">新增位置定价</a>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=left bgcolor="#FCB0B0">
						<tr class="u4" height="25">
							<td align="left" width="20%">关键字位置</td>
							<td align="left" width="25%">价格</td>		 
							<td align="center" width="15%">修改</td>
							<!--td align="center" width="15%">删除</td-->
						<td width="15%" align="center">
								<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
								<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
								<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
						</td>
						</tr>
					<%
						if( priceList != null )
						{
						int size = priceList.size();
							for( int i = 0; i < priceList.size(); i++ )
							{
								HashMap pmap = ( HashMap )priceList.get( i );
								String trade_id = "";
								String key_location = "";
								String key_price = "";
								String in_date = "";
								if( pmap.get( "trade_id" ) != null )
								{
									trade_id = pmap.get( "trade_id" ).toString();
								} 
								if( pmap.get( "key_location" ) != null )
								{
									key_location = pmap.get( "key_location" ).toString();
								} 
								if( pmap.get( "key_price" ) != null )
								{
									key_price = pmap.get( "key_price" ).toString();
								} 			
					%>	 
						<tr class="u2">
							<td align="left" width="20%"><%=key_location%></td>
							<td align="left" width="25%"><%=key_price%>&nbsp;元</td>
							<td align="center" width="15%">
								<a href="modKeyLocation.jsp?trade_id=<%=trade_id%>" >
								<img src=/images/edit.gif width=16 height=16 border=0 alt="修改关键字位置信息"></a>
							</td>
							<td align="center" width="15%">
								<!--a href="/doTradeReg.do?trade_id=<%=trade_id%>&trade_type_code=1324" target="_self" onClick="return chechIfo()">
								<img src=/images/del.gif width=16 height=16 border=0 alt="删除此关键字位置"></a-->
								  <input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=trade_id%>" />
									<input type="hidden" name="size" value="<%=size%>" id="size" />
							</td>
						</tr>
						
					<%
							}
						}
						else
						{
					%>				 
			      	<tr>
			      		<td class="u6" colspan="6">
			      			无记录！
			      		</td>
			      	</tr>
			        <%
						}
					%><tr class="u3">
							<td background="/images/kehu_list_17.gif"  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td background="/images/kehu_list_17.gif" align="right" colspan="5"  style=" padding:2px 5px;">
								<a href="locationPricing.jsp?iStart=0&menu_id=<%=top_menu_id%>"info_type=2>首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="locationPricing.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>"&info_type=2>上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="locationPricing.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>"info_type=2>下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="locationPricing.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>"info_type=2>尾页</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="hidden" id="trade_type_code" name="trade_type_code" value="">
		<input type="hidden" id="trade_id" name="trade_id" value="">
	</form>
	</body>
</html>




