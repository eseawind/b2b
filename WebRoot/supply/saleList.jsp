<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="sale" class="com.saas.biz.saleMgr.SupplyInfo" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="com.saas.biz.custMgr.Custinfo" %>
<%
  String iStart = "0";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	int counter = sale.getSaleInfoCount();
	ArrayList list=sale.getSupplyInfoList(Integer.parseInt(iStart),5,"3");
	//String pageTools = tools.getGoogleToolsBar(counter, "supply_List.jsp?sys_code=0&page=", Integer.parseInt(iStart),5);
	String defaultImg="/images/cp.gif";
	int size=0;
	
	int pages = (counter-1) / 5 + 1;
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
<table  width="100%" border="0" cellpadding="0" cellspacing="0" id="tbo0" align="top">
<tr>
	<td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="90ABDF">
			<tr>
				<td height="255" valign="top" bgcolor="FFFFFF">
					<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="23%" height="30">
								<img src="/images/jiantou.gif" width="20" height="17">
								<input type="submit" name="Submit2" value="对比产品" onclick="saleCompare()">
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
					        String sale_id="",sale_unit="",cust_name="";
					        String title="",pub_date="",content="",addr="",price="";
					        if(map.get("sale_id")!=null){
					        	sale_id=map.get("sale_id").toString();
					        }
					        if(map.get("title")!=null){
					        	title=map.get("title").toString();
					        }
					        if(map.get("sale_unit")!=null){
					        	sale_unit=map.get("sale_unit").toString();
					        }
					        if(map.get("sale_price")!=null){
					        	price=map.get("sale_price").toString();
					        }
					        if(map.get("sale_addr")!=null){
					        	addr=map.get("sale_addr").toString();
					        }
					        
					        cust_name = new Custinfo().getCustomerNameById(sale_unit);
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
						    String file_path=defaultImg;
						    file_path = new Custinfo().getCustAttachPath( sale_id, "0");
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
								<a href="saleInquiry.jsp?sale_id=<%=sale_id%>" target="_blank" class="cpbt"><%=title%></a> <%=pub_date%>
								</br>
								<%=content%>
								</br>
								<a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=sale_unit%>" target="_blank"><%=cust_name%></a>
								<%
									if(!cust_img.equals("")){
								%>
									<img src="<%=cust_img%>" border="0">
								<%
									}
								%>
							</td>
							<td width="11%">
								<%=price%>
							</td>
							<td width="13%">
								<%=addr%>
							</td>
							<td width="16%">
								<a href="saleInquiry.jsp?sale_id=<%=sale_id%>"><img src="/images/zx.gif" border="0" width="75" height="21" alt="点击询价"></a>
								<img src="/images/msn.gif" width="16" height="16">							</td>
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
										<td background="/images/btt1.gif"  align="left"  style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td background="/images/btt1.gif" align="right"  style=" padding:2px 5px;">
										<a href="supply_List.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="supply_List.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="supply_List.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="supply_List.jsp?iStart=<%=pages-1%>">尾页</a></td>
			
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



