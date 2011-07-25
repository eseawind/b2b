<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.productMgr.*"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%
			request.setCharacterEncoding("gbk");
			String iStart ="0",cust_id = "";
			String it = "0";
			if (request.getParameter("i") != null) {
				it = request.getParameter("i");
			}
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
	    if(it.equals("1")){
					pro_name=URLDecoder.decode(pro_name,"GBK");
					pro_name= new String(pro_name.getBytes("ISO-8859-1"),"GBK");
				}
			ProductInfo product = new ProductInfo();
			InfoList infoList = new InfoList();		
			ArrayList tableList = product.getAllProductInfoByIdForMum(Integer.parseInt(iStart),cust_id);
			int counter = product.getAllProductInfoByIdForMum(cust_id);
			if(!pro_name.equals("")){
				tableList = product.getProductInfoByLIKE(Integer.parseInt(iStart),cust_id,pro_name);
				counter = product.getProductInfoByLIKE(cust_id,pro_name);
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
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
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
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('product_id'+i).checked==true){
									all_news_id += document.getElementById('product_id'+i).value+'|';
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
							document.proForm.submit();
						}
						if(val=='2'){
							document.proForm.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value="5597";
							document.proForm.submit();
						}
				}
		</script>

	</head>
	<body>
		<form action="index.jsp" method="post" name="proForm">
						
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="/member/b2b_productMgr/productIndex.jsp">新增产品信息</a>
				</td>
			</tr>
		</table>

					<table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr class="u1">
							<td align="left" bgcolor="white">
								产品名称：<input type="text" name="pro_name" id="pro_name" value="" />
													<img src="/admin/images/chaxun.gif" border="0" onclick="javascript:document.proForm.submit();" style="cursor:hand;"/>
							</td>
						</tr>
					</table>
					<table width=100% border=0 cellpadding=2 cellspacing=1 bgcolor="#e7e7e7">
						<tr>
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=left width="20%">
								产品名称
							</td>
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=left width="20%">
								产品简介
							</td>
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=left width="20%">
								地址
							</td>
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=left width="10%">
								发布日期
							</td>
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=center width="5%">
								修改
							</td>
							<!--td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=center width="5%">
								删除
							</td-->
							<td style="background-color: #DEEDFD; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
									
									<input type="button" name="reload" value="删除" onclick="reloadNews(2)"/>
									<input type="button" name="reload" value="重发" onclick="reloadNews(1)"/>
									<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
									<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
							</td>
							 
						</tr>
						<%
									
							String address = "",addr = "";

								if (tableList != null && tableList.size() > 0) {
								int size = tableList.size();
								for (int i = 0; i < tableList.size(); i++) {
									HashMap map = (HashMap) tableList.get(i);
									String product_id = "", product_class = "", product_name = "", product_abstract = "", product_desc = "", product_site = "", audit_date = "";
									if (map.get("product_id") != null) {
										product_id = map.get("product_id").toString();
										address = infoList.getChannelSaveDirByInfoId(product_id);
									}
									
									if (map.get("product_class") != null) {
										product_class = map.get("product_class").toString();
									}
									if (map.get("product_name") != null) {
										product_name = map.get("product_name").toString();
										if(product_name.length()>17){
											product_name = product_name.substring(0,17)+"...";
										}
									}
									if (map.get("product_abstract") != null) {
										product_abstract = map.get("product_abstract").toString();
									}
									if (map.get("product_desc") != null) {
										product_desc = map.get("product_desc").toString();
										product_desc = product_desc.replace("&nbsp;","");
										if(product_desc.length()>15){
											product_desc = product_desc.substring(0,15)+"...";
										}
									}
									if (map.get("product_site") != null) {
										product_site = map.get("product_site").toString();
									}
									if (map.get("audit_date") != null) {
										audit_date = map.get("audit_date").toString();
									}
									if(audit_date.length()>10){
						      			audit_date=audit_date.substring(0,10);
						     		}
						     
						     //addr = "/" + address + "/d/content-" + product_id +".html";
						%>
						<tr style="background-color: #f9f9f9;">
							<td style="color: #000000;" align="left"><a href=modi_product_attr.jsp?product_id=<%=product_id%> target=""><%=product_name%></a></td>
							<td style="color: #000000;" align="left"><%=product_desc%></td>
							<td style="color: #000000;" align="left"><%=product_site%></td>
							<td style="color: #000000;" align="left"><%=audit_date%></td>
							<td style="color: #000000;" align="center">
								<a href="/member/productMgr/member_modi_product.jsp?product_id=<%=product_id%>"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改产品属性"> </a>
							</td>
							<!--td style="color: #000000;" align="center">
								<a href="/doTradeReg.do?trade_type_code=1227&product_id=<%=product_id%>" target="_self"><img src=/images/del.gif width=16 height=16 border=0 alt="删除产品属性"> </a>
							</td-->
							<td style="color: #000000;" align=center>
								<input type="checkbox" name="product_id<%=i%>" id="product_id<%=i%>" value="<%=product_id%>" />	
								<input type="hidden" name="size" value="<%=size%>" id="size" />							
							</td>
						</tr>
						
						<%
						}
						%>
					<tr>
							<td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td  align="right" colspan="5"  style=" padding:2px 5px;">
							<a href="index.jsp?iStart=0&pro_name=<%=pro_name%>&i=1">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="index.jsp?iStart=<%=pageUp%>&pro_name=<%=pro_name%>&i=1">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="index.jsp?iStart=<%=pageDown%>&pro_name=<%=pro_name%>&i=1">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="index.jsp?iStart=<%=pages-1%>&pro_name=<%=pro_name%>&i=1">尾页</a></td>

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
								<input type="hidden" name="trade_type_code" value="8723" />
								<input type="hidden" name="product_id" id="product_id" value="" />
								<input type="hidden" name="root_id" id="root_id" />
								<input type="hidden" name="info_id" id="info_id" />
							</tr>
					</table>
				</form>

	</body>
</html>




