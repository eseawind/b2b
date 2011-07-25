<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="att" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />

<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String stock_id = "";
	String title = "";
	String content = "";
	String cust_id = "";
	String cust_name=""; 
	
	String stock_addr = "";
	String start_date = date;
	String end_date = date;
	
	if (request.getParameter("stock_id") != null)
	 {
		stock_id = request.getParameter("stock_id");
	}
	Stockorderinfo stockObj = new Stockorderinfo();
	ArrayList stockList = new ArrayList();
	
	if (stock_id != null && !stock_id.equals(""))
	 {
		stockList = stockObj.genOneStockorder(stock_id);
		if (stockList != null && stockList.size() > 0) 
		{
			HashMap map = (HashMap) stockList.get(0);
			stock_id = map.get("stock_id").toString();
			if (map.get("title") != null) 
			{
				title = map.get("title").toString();
			}
			if (map.get("content") != null) 
			{
				content = map.get("content").toString();
			}
			
			if (map.get("cust_id") != null) 
				{
					cust_id = map.get("cust_id").toString();
					Custinfo custInfo = new Custinfo();
					ArrayList list = new ArrayList(); 
					HashMap map1 = new HashMap();
					list = custInfo.genSpecCustInfo(cust_id);
					if (list != null && list.size() > 0)
					{
						  map1 = (HashMap) list.get(0);
						  cust_name = map1.get("cust_name").toString();
					}
				}
			
			if (map.get("stock_addr") != null) 
			{
				stock_addr = map.get("stock_addr").toString();
			}
			if (map.get("start_date") != null)
			 {
				start_date = map.get("start_date").toString();
				if (start_date.length() > 10)
				 {
					start_date = start_date.substring(0, 10);
				}
			}
			if (map.get("end_date") != null) 
			{
				end_date = map.get("end_date").toString();
				if (end_date.length() > 10) 
				{
					end_date = end_date.substring(0, 10);
				}
			}
	}
		}
	String file_path="";
	ArrayList listatt = att.getAttachInfoByList(stock_id);
	if(null != listatt){
		HashMap mp = (HashMap)listatt.get(0);
		if(mp.get("file_path")!=null){
			file_path = mp.get("file_path").toString();
		}		
	}
	if(file_path==null || file_path.equals("")){
		file_path="/images/cpwu.gif";
		}
%>
<html>
	<head>
		<title>采购主题详细信息</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>
	<body>
		<table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td >
					<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">										
						<tr>
							<td class="u1">
								采购标题：
							</td>
							<td class="u2" colspan="3">
								<%=title%>
							</td>
						</tr>
						
						<tr>
							<td class="u1">
								采购单位：
							</td>
							<td class="u2">
								<a href="/member/customerMgr/companyIntroduction.jsp?obj_cust_id=<%=cust_id%>"><%=cust_name%></a>
							</td>
							<td class="u1">
								采购地点：
							</td>
							<td class="u2">
								<%=stock_addr%>
							</td>
						</tr>				
						<tr>
							<td class="u1">
								开始日期：
							</td>
							<td class="u2">
								<%=start_date%>
							</td>
							<td class="u1">
								结束日期：
							</td>
							<td class="u2">
								<%=end_date%>
							</td>
						</tr>
						<tr>
							<td class="u1">
								采购内容：
							</td>
							<td class="u2" colspan="3">
								<%=content%>
							</td>
						</tr>

							<tr>
								<td class="u1">
									图片：
								</td>
								<td class="u2" colspan="3">
									<img src="<%=file_path%>" border=0 width="100" height="100">
								</td>
							</tr>

						<tr bgcolor="white">
							<td  colspan="4" align="center">
								<img src="/admin/images/comeback.JPG" onclick="javascript:history.go(-1);" style="cursor:hand;"/>
							</td>
						</tr>
				  </table>
				</td>
			</tr>
			<tr>
				<td height="12px">&nbsp;</td>
			</tr>
	</table>
	</body>
</html>





