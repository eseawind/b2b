<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.productMgr.*"%>
<%
			request.setCharacterEncoding("gbk");
			String iStart ="0",cust_id = "";
			if (session.getAttribute("SESSION_CUST_ID") != null) {
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
			}
			if ( request.getParameter( "iStart" ) != null )
	    {
	        iStart = request.getParameter( "iStart" );
	    }
	    String pro_name="";
	    if ( request.getParameter( "pro_name" ) != null )
	    {
	        pro_name = request.getParameter( "pro_name" );
	    }
			ProductInfo product = new ProductInfo();
			ArrayList tableList = product.getProductInfoById(Integer.parseInt(iStart),cust_id);
			int counter = product.getProductInfoById(cust_id);
			
			if(!pro_name.equals("")){
				tableList = product.getProductInfoById(Integer.parseInt(iStart),cust_id,pro_name);
				counter = product.getProductInfoById(cust_id,pro_name);
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
		<title>产品管理</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		 		<script language="javascript">
			function selAllNews(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
							document.getElementById('product_id'+i).checked = true;
					}
			}
			
			function delAllNews(){
					var size = document.getElementById('size').value;
					for(var i=0;i<size;i++){
						if(document.getElementById('product_id'+i).checked==true){
							document.getElementById('product_id'+i).checked = false;
						}else{
							document.getElementById('product_id'+i).checked=true;
						}
					}
			}
			function reloadNews(val){
				var size = document.getElementsByName('product_ids');
				var all_news_id='';
				for(var i=0;i<size.length;i++){
					if(size[i].checked==true){
							all_news_id += size[i].value+'|';
					}
				}
				document.getElementById('product_id').value = all_news_id;
				document.getElementById('root_id').value = all_news_id;
				document.getElementById('info_id').value = all_news_id;
				if(all_news_id==''){
					alert('请至少选择一条!');
					return false;
				}
				if(val=='1'){
					document.proForm.action='/doTradeReg.do';
					document.getElementById("trade_type_code").value="4573";
					document.proForm.submit();
				}
				if(val=='2'){
				if( window.confirm( '确定要删除此信息？' ) )
				{
					document.proForm.action='/doTradeReg.do';
					document.getElementById("trade_type_code").value="4572";
					document.proForm.submit();
				}
			}
		}
		</script>
	</head>
	<body>
		<form action="modiProductIndex.jsp" method="post" name="proForm">
		<table width="100%" border="0" cellpadding="2" cellspacing="1" align="center">
			<tr bgcolor="white">
					<td align="left" class="head">
						<a href="/member/b2b_productMgr/productIndex.jsp">新增产品信息</a>
					</td>
			</tr>
			<tr bgcolor="#E6F6E9" >
				<td align="left" >
					产品名称：<input type="text" name="pro_name" id="pro_name" value="" />&nbsp;
					<img src="/admin/images/chaxun.gif" border="0" onclick="javascript:document.proForm.submit();" style="cursor:hand;" align="absmiddle"/>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="2" cellspacing="1"  bgcolor="#E6F6E9">
			<tr class="u4" >
				<td align="left" style=" font-weight: bold; font-size: 13px;" width="20%">
					产品名称
				</td>
				<td align="left" style=" font-weight: bold; font-size: 13px;" width="25%">
					产品简介
				</td>
				<td align="left" style="font-weight: bold; font-size: 13px;" width="20%">
					地址
				</td>
				<td align="left" style="font-weight: bold; font-size: 13px;" width="10%">
					发布日期
				</td>
				<td align="center" style="font-weight: bold; font-size: 13px;" width="5%">
					修改
				</td>
				<td align="center" style=" font-weight: bold; font-size: 13px;" width="20%">
					<input type="button" name="reload" value="删除" onclick="reloadNews(2)"/>
					<input type="button" name="reload" value="重发" onclick="reloadNews(1)"/>
					<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
					<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
				</td>
			</tr>
			<%
				if (tableList != null && tableList.size() > 0) 
				{
					int size = tableList.size();
					for (int i = 0; i < tableList.size(); i++) 
					{
						HashMap map = (HashMap) tableList.get(i);
						String product_id = "", product_class = "", product_name = "", product_abstract = "", product_desc = "", product_site = "", publish_date = "";
						if ( map.get("product_id") != null ) 
						{
							product_id = map.get("product_id").toString();
						}
						
						if ( map.get("product_class") != null ) 
						{
							product_class = map.get("product_class").toString();
						}
						if ( map.get("product_name") != null) 
						{
							product_name = map.get("product_name").toString();
						}
						if ( map.get("product_abstract") != null ) 
						{
							product_abstract = map.get("product_abstract").toString();
							if( product_abstract.length() > 50 )
							{
								product_abstract = product_abstract.substring(0,50)+"...";
							}
						}
						if ( map.get("product_desc") != null ) 
						{
							product_desc = map.get("product_desc").toString();							
						}
						if ( map.get("product_site") != null ) 
						{
							product_site = map.get("product_site").toString();
						}
						if ( map.get("publish_date") != null ) 
						{
							publish_date = map.get("publish_date").toString();
						}
						if( publish_date.length() > 10 )
						{
							publish_date = publish_date.substring( 0,10 );
						}
			%>
			<tr class="u2">
				<td align="left"><a href="modi_product_attr.jsp?product_id=<%=product_id%>" target=""><%=product_name%></a></td>
				<td align="left"><%=product_abstract%></td>
				<td align="left"><%=product_site%></td>
				<td align="left"><%=publish_date%></td>
				<td align="center">
					<a href="member_update_product.jsp?product_id=<%=product_id%>"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改产品属性"></a>
				</td>
				<td style="color: #000000;" align=center>
					<input type="checkbox" name="product_ids" id="product_id<%=i%>" value="<%=product_id%>" />	
					<input type="hidden" name="size" value="<%=size%>" id="size" />		
					<input type="hidden" name="product_id" value="" id="product_id" />		
				<input type="hidden" name="root_id" value="" id="root_id" />	
				<input type="hidden" name="info_id" value="" id="info_id" />	
				<input type="hidden" name="trade_type_code" value="" id="trade_type_code" />
				</td>
				<!--td style="color: #000000;" align="center">
					<a href="/doTradeReg.do?trade_type_code=1227&product_id=<%=product_id%>&root_id=<%=product_id%>&info_id=<%=product_id%>" target="_self">
					<img src=/images/del.gif width=16 height=16 border=0 alt="删除产品属性"> </a>
				</td-->
			</tr>
			<%
			}
			%> 
			<tr>
					<td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
					<td  align="right" colspan="5"  style=" padding:2px 5px;">
					<a href="modiProductIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
					<% 
						if(Integer.parseInt(iStart)>0){
					%>
						<a href="modiProductIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
					<%
						}
						if(Integer.parseInt(iStart)<pages-1){
					%>
						<a href="modiProductIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
					<%
						}
					%>
					<a  href="modiProductIndex.jsp?iStart=<%=pages-1%>">尾页</a></td>

		  </tr> 
				<%
			}else{
				%>
					<tr>
						<td colspan="6" align="center" bgcolor="white">
							无产品信息！
						</td>
					</tr>
				<%
				}
				%>
				
			</table>
			<table>
					<tr>
						<td colspan="6" align="center" bgcolor="white" height="30"></td>
					</tr>
			</table>
		</form>

	</body>
</html>



