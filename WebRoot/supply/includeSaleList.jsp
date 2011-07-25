<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="sale" class="com.saas.biz.infoClassMgr.CalalogInfo" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="com.saas.biz.attachMgr.*" %>
<%
    String iStart = "1",class_id="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id");
	}
	Attachinfo attach = new Attachinfo();
	int counter = sale.getSaleInfoByClassCount(class_id);
	ArrayList list=sale.getSaleInfoByClassGroup(Integer.parseInt(iStart),5,class_id);
	String pageTools = tools.getGoogleToolsBar(counter, "/product/calalogList.jsp?type=5&supply=1&class_id="+class_id+"&iStart=", Integer.parseInt(iStart),5);
	String defaultImg="/images/cp.gif";
	int size=0;
%>

<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">
								供应信息列表
							</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg" align="bottom"> 
							</td>
						</tr>
					</table>
<table  width="100%" border="0" cellpadding="0" cellspacing="0" id="tbo0" align="top">
<tr>
	<td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="90ABDF">
			<tr>
				<td height="255" valign="top" bgcolor="FFFFFF">
					<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="23%" height="30">
							    <form action="/supply/supplyComparam.jsp" method="post" name="commpara" id="commpara" target="_blank">
			                      <input type="hidden" name="idx" id="idx">
								  <img src="/images/jiantou.gif" width="20" height="17">
								  <input type="button" name="Submit2" value="对比产品" onclick=" return saleCompare()">
								</form>
							</td>
							<td width="37%" class="STYLE2">
								供应信息/公司
							</td>
							<td width="11%" class="STYLE2">
								价格(元)
							</td>
							<td width="13%" class="STYLE2">
								所在地
							</td>
							<td width="16%" class="STYLE2">
								留言/联系
							</td>
						</tr>
						<tr>
							<td height="1" class="xian"></td>
							<td class="xian"></td>
							<td class="xian"></td>
							<td class="xian"></td>
							<td class="xian"></td>
						</tr>
					</table>
					<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
					    <%
					     if(list !=null && list.size()>0){
					      size=list.size();
					      for(int i=0;i<list.size();i++){
					        HashMap map=(HashMap)list.get(i);
					        String title="",pub_date="",content="",addr="",price="",sale_id="",sale_unit="",cust_name="";
					        if(map.get("cust_name")!=null){cust_name=map.get("cust_name").toString();}
					        if(map.get("title")!=null){title=map.get("title").toString();}
					        if(map.get("sale_id")!=null){sale_id=map.get("sale_id").toString();}
					        if(map.get("sale_unit")!=null){sale_unit=map.get("sale_unit").toString();}
					        if(map.get("sale_price")!=null){price=map.get("sale_price").toString();}
					        if(map.get("sale_addr")!=null){addr=map.get("sale_addr").toString();}
					        if(map.get("content") !=null)
						    {
						      content=map.get("content").toString();
						      content=content.replaceAll("<[^<>]+>","");
						      if(content.length()>40)
						      {
						        content=content.substring(0,40)+"...";
						      }
						    }
						    if(map.get("publish_date")!=null){
						      pub_date=map.get("publish_date").toString();
						      if(pub_date.length()>10){
						        pub_date=pub_date.substring(0,10);
						      }
						    }
						    String file_path="";
						    file_path = attach.getAttachAddr(sale_id);
						    if(file_path.equals(""))
						    {
						      file_path=defaultImg;
								}
							//取客户级别
							String para_code1 = new CustClass().getCustClassById(sale_unit);
							//取出级别图片
							String cust_img = param.getCustImgByParaCode1("1", para_code1);
					    %>
					        <tr>
							<td width="4%" height="30">
								<input type="checkbox" name="sale_<%=i%>" id="sale_<%=i%>" value="<%=sale_id%>">
							</td>
							<td width="19%" height="130">
								<img name="" src="<%=file_path%>" width="100" height="100" alt="" />							</td>
							<td width="37%">
								<a href="/supply/saleInquiry.jsp?sale_id=<%=sale_id%>" target="_blank" class="cpbt"><%=title%></a> <%=pub_date%>
								<br>
								<%=content%>
								<br>
								<a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=sale_unit%>" target="_blank"><%=cust_name%></a><img src="<%=cust_img%>" border="0">
							</td>
							<td width="11%">
								<%=price%>
							</td>
							<td width="13%">
								<%=addr%>
							</td>
							<td width="16%">
								<a href="/supply/saleInquiry.jsp?sale_id=<%=sale_id%>"><img src="/images/zx.gif" border="0" width="75" height="21" alt="点击询价"></a>
								<img src="/images/msn.gif" width="16" height="16"></td>
						</tr>
					     <%} 
					     }%>
				  </table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10">
				<input type="hidden" name="s_size" id="s_size" value="<%=size%>">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="E3E3E3">
			<tr>
				<td height="32" align="center" background="/images/btt1.gif">
					<%=pageTools%>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td height="10"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>



