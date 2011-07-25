<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.ahbay.RightMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<%@ page import="com.saas.biz.attachMgr.Attachinfo"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%
				String iStart="0",cust_id="";
				if (session.getAttribute("SESSION_CUST_ID") != null){
				   cust_id = session.getAttribute("SESSION_CUST_ID").toString();
				} 
				if (request.getParameter("iStart") != null)
		    {
		        iStart = request.getParameter("iStart");
		    }
				int counter=0;
				String start_date="",end_date="";
				String order_type="",cust_name="";
				if (request.getParameter("start_date") != null) {
					start_date = request.getParameter("start_date");
				}
				if (request.getParameter("end_date") != null) {
					end_date = request.getParameter("end_date");
				}
				if (request.getParameter("order_type") != null) {
					order_type = request.getParameter("order_type");
				}
				if (request.getParameter("cust_name") != null) {
					cust_name = request.getParameter("cust_name");
				}
				
				//new新对象
	      ShoppingOrderInfo shopOrder = new ShoppingOrderInfo();
	      SaleInfo saleInfo = new SaleInfo();
	      Attachinfo attach = new Attachinfo();
	      Custinfo custInfo = new Custinfo();
	      ParamethodMgr param = new ParamethodMgr();
	      AreaInfo areaInfo = new AreaInfo();
	      
	      ArrayList orderList = new ArrayList();
	     
				Calendar cal = Calendar.getInstance();
				String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				cal.add(Calendar.DAY_OF_MONTH, -3); 
				String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				
				orderList = shopOrder.getAllShopOrder(Integer.parseInt(iStart));
		   	counter = shopOrder.getAllShopOrder();
				if(!start_date.equals("")){
					orderList = shopOrder.getAllOrderListByDateNoCust(Integer.valueOf(iStart).intValue(),start_date , end_date);
					counter = shopOrder.getAllOrderListByDateNoCust(start_date , end_date);
				}
				if(!start_date.equals("") && !order_type.equals("")){
					orderList = shopOrder.getAllOrderListByDateWithOrderType(Integer.valueOf(iStart).intValue(),start_date , end_date,order_type);
					counter = shopOrder.getAllOrderListByDateWithOrderType(start_date , end_date,order_type);
				}
				if(!start_date.equals("") && !order_type.equals("") && !cust_name.equals("")){
					orderList = shopOrder.getAllOrderListByDateWithCustName(Integer.valueOf(iStart).intValue(),start_date , end_date,order_type,cust_name);
					counter = shopOrder.getAllOrderListByDateWithCustName(start_date , end_date,order_type,cust_name);
				}
				int pages=counter/21+1;
				int pageUp=0,pageDown=0;
				int currenPage=Integer.valueOf(iStart).intValue();
				if(pages>currenPage){
				   if(currenPage>0){
							pageUp=currenPage-1;
				   }
					 pageDown=currenPage+1;
				}else if(pages==currenPage){
				   pageUp=currenPage-1;
				   pageDown=currenPage;
				}			
				String remark1="";
				int one=0,two=0,three=0,four=0,five=0,six=0;
				int after=0;
				float a_all_sum_money=0;
				float all_sum_money=0;
				if(orderList!=null && orderList.size()>0){
					for(int z=0;z<orderList.size();z++){
						HashMap aMap = (HashMap)orderList.get(z);
						if(aMap.get("sum_money")!=null){all_sum_money=Float.parseFloat(aMap.get("sum_money").toString());}
						if(aMap.get("order_type")!=null){remark1=aMap.get("order_type").toString();}
						a_all_sum_money += all_sum_money;
						if(remark1.equals("1")){
							one++;
						}
						if(remark1.equals("2")){
							two++;
						}
						if(remark1.equals("3")){
							three++;
						}
						if(remark1.equals("4")){
							four++;
						}
						if(remark1.equals("5")){
							five++;
						}
						if(remark1.equals("6")){
							six++;
						}
					}
				}
				
				String order_type_sel = param.getSelectItems("113")+param.getSelectItems("116");
				
%>
<html>
<head>
<title>店铺交易量查看</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
    <script language="javascript" src="/js/Calendar_Ly.js"></script>
    <style type="text/css">
			.chaxun{
					background:url(/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
		</style>
		<script language="javascript">
	   //空值判断
	    function Check_Value(){
	       if(document.getElementById("start_date").value ==null || document.getElementById("start_date").value ==""){
	        alert("请选择开始时间！");
	        return false;
	       }
	       if(document.getElementById("end_date").value ==null || document.getElementById("end_date").value ==""){
	        alert("请选择结束时间！");
	        return false;
	       }
	       document.orderform.submit();
	    }
	 </script>
</head>
<body>	
	<form action="index.jsp" method="post" name="orderform">
		<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="50" colspan="3" >					</td>
			</tr>
		  <tr>
				<td background="/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>菜单管理</b></font></td>
				<td background="/images/content_04.gif" align="right">&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
		</table>	
		<table width="1000" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
		  <tr>
			<td height="36" valign="middle" bgcolor="#FFFFFF">
  
请选择服务：   
『<a href = #></a>』
           </td>
		  </tr>
		  <tr>
					<td valign="middle" background="../images/bg_0.gif">
							菜单ID:
							  <input type="text" id="start_date" name="start_date" onfocus="setday(this);" value="">
							菜单名:<input type="text" id="end_date" name="end_date" onfocus="setday(this);" value="">
							&nbsp;
			<input class="chaxun" type="button" name="comit" value="" onclick="return Check_Value()" style="cursor: hand;"></td>
		  </tr>
	  </table>

</form>
		
    <table bgcolor="#ECF4F7" width=1000 border=0 cellpadding=2 cellspacing=1 align="center">
		    	<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
				<tr>
		    		<td>
						<!--重复区-->
						<table width="280" height="150" border="0" align="center" cellpadding="5" cellspacing="0" bgcolor="white" style="float:left; margin-left:30px; margin-top:20px;  display:inline;">
							<tr>
								<td valign="top"><table width="260" border="0" align="center" cellpadding="0" cellspacing="0" style="borber-bottom:1px dashed CDD4DA;">
                                  <tr>
                                    <td width="125" height="30" align="left"><img src="../images/new_0.gif" width="80" height="26"></td>
                                    <td width="135" align="right"><img src="../images/an_03.gif" width="49" height="22"> <img src="../images/an_05.gif" width="49" height="22"></td>
                                  </tr>
                                </table>
								  <table width="260" border="0" align="center" cellpadding="5" cellspacing="0">
														<tr>
															<td align="left">
																菜单ID：<br>
																菜单名：<br>
																文件路径:<br>
															文件名：<br>
															功能描述：</td>
														</tr>
								  </table>
							  </td>
							</tr>
					  </table>
						<!--重复区//-->
						
		    		
					</td>
		    	</tr>
				<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
	</table>
			  
			  
			<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">  
	          <tr class="bfoot">
					<td background="/images/newsbg.gif" align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
					<td width="534" colspan="7"  align="right" background="/images/newsbg.gif"  style=" padding:2px 5px;">
					<a href="index.jsp?iStart=0&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">首页 </a>&nbsp; &nbsp;
					<% 
					if(Integer.parseInt(iStart)>0){
					%>
					<a href="index.jsp?iStart=<%=pageUp%>&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">上一页</a> &nbsp;
					<%
					}
					if(Integer.parseInt(iStart)<pages-1){
					%>
					<a href="index.jsp?iStart=<%=pageDown%>&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">下一页 </a>&nbsp; 
					<%
					}
					%>
				<a  href="index.jsp?iStart=<%=pages-1%>&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">尾页</a></td>
	  </tr>	
</table>
			<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr class="bt">											
						<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"align=center colspan="6">
							无交易记录！				
						</td>
						
				</tr>
</table>
		    		  
</body>
</html>


