<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
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
	     
				String start_date="",end_date="";
				Calendar cal = Calendar.getInstance();
				String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				cal.add(Calendar.DAY_OF_MONTH, -5); 
				String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				int counter=0;
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
		//分页
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
		int counts = 0; 
		int after=0;
		float a_all_sum_money=0;
		float all_sum_money=0;
		if(orderList!=null && orderList.size()>0){
			for(int z=0;z<orderList.size();z++){
				HashMap aMap = (HashMap)orderList.get(z);
				if(aMap.get("sum_money")!=null){all_sum_money=Float.parseFloat(aMap.get("sum_money").toString());}
				if(aMap.get("order_type")!=null){remark1=aMap.get("order_type").toString();}
				a_all_sum_money += all_sum_money;
				counts ++;
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
					background:url(/admin/images/chaxun.gif) left center no-repeat;
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
		<!--table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="50"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>店铺交易量</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
		</table-->	
				<table width="100%" border=0 cellpadding=2 cellspacing=1 bgcolor="#DEEDFD" align="center">
					<tr bgcolor="white">
						<td>
							开始时间:<input type="text" id="start_date" name="start_date" onfocus="setday(this);" value="<%=start_Date%>">
							结束时间:<input type="text" id="end_date" name="end_date" onfocus="setday(this);" value="<%=end_Date%>">
							&nbsp;
							<!--交易客户：<input type="text" name="cust_name" id="cust_name" value=""/>&nbsp;-->
							订单状态：
								<select name="order_type" id="order_type">
									<%=order_type_sel%>
								</select>
							<input class="chaxun" type="button" name="comit" value="" onclick="return Check_Value()" style="cursor: hand;">
						</td>
					</tr>
					<tr bgcolor="white">
						<td>
							交易量： &nbsp;&nbsp;
							[未付款：<%=one%>个] &nbsp;
							[已付款,待确认：<%=two%>个]&nbsp;
							[确认收货：<%=three%>个]&nbsp;
							[申请退货：<%=four%>个] &nbsp;
							[确认收款,发货：<%=five%>个]&nbsp; 
							[退货确认：<%=six%>个]&nbsp; 
							[合计：<%=counts%>个] &nbsp;<b>
							交易总金额：<%=a_all_sum_money%></b>
						</td>
					</tr>
				</table>
		</form>
		
    <table bgcolor="#ECF5FD" width=100% border=0 cellpadding=1 cellspacing=1 align="center"  >
		    	<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
					<%
						if(orderList!=null && orderList.size()>0){
						String trade_id="",sale_id="",price="",discount="",num="",money="",user_id="",buy_cust_id="",buy_cust_name="";
						String deliver_type="",pay_type="",phone="",cellphone="",consignee="",post_code="",province_city="",addr="",oper_date="";
						String carriage_pay="",sum_money="",filepath="",remark="",pro_name="",sale_unit="",province="",eparchy_code="",city="",obj_cust_id="";

									if(orderList!=null && orderList.size()>0){
									  int ros=0,index=0;
									  if(orderList.size()%3==0){
									    ros=orderList.size()/3;
									  }else{
									     ros=orderList.size()/3+1;
									  }
									  for(int i=0;i<ros;i++){
									  out.print("<tr><td width=70></td>");
									    for(int j=0;j<3;j++){
									      if(orderList.size()>index){
									             HashMap map = (HashMap) orderList.get(index++);
															if(map.get("cust_id")!=null){
																buy_cust_id=map.get("cust_id").toString();
																buy_cust_name = custInfo.getCustNameById(buy_cust_id);
															}
															if(map.get("trade_id")!=null){trade_id=map.get("trade_id").toString();}
													    if(map.get("sale_id")!=null){
													    	sale_id=map.get("sale_id").toString();
													    	filepath = attach.getAttachAddr(sale_id);
													    	if(filepath.equals("") || filepath==""){
													    		filepath="/upload/default.gif";
													    	}
													    	pro_name = saleInfo.getProName(sale_id);
													    	if(pro_name.length()>8){
													    		pro_name = pro_name.substring(0,8)+"..";
													    	}
													    	sale_unit = saleInfo.getCustNameBySaleId(sale_id);
													    	if(!sale_unit.equals("")){
													    		obj_cust_id = sale_unit;
													    		sale_unit = custInfo.getCustNameById(sale_unit);
													    	}
													    }

													    if(map.get("order_type")!=null){
													    	order_type=map.get("order_type").toString();
													    	if (order_type == "1" || order_type.equals("1")){
																	order_type = "1";
																}else if (order_type == "2" || order_type.equals("2")){
																	order_type = "2";
																}else if (order_type == "3" || order_type.equals("3")){
																	order_type = "3";
																}else if (order_type == "4" || order_type.equals("4")){
																	order_type = "4";
																}else if (order_type == "5" || order_type.equals("5")){
																	order_type = "5";
																}
																else if (order_type == "6" || order_type.equals("6")){
																	order_type = "6";
																}
													    }
													    if(map.get("price")!=null){price=map.get("price").toString();}
													    if(map.get("discount")!=null){discount=map.get("discount").toString();}
													    if(map.get("num")!=null){num=map.get("num").toString();}
													    if(map.get("money")!=null){money=map.get("money").toString();}
													    if(map.get("user_id")!=null){user_id=map.get("user_id").toString();}
													    if(map.get("deliver_type")!=null){
													    	deliver_type=map.get("deliver_type").toString();
													    	deliver_type = param.getParaCode2ByParaCode1("111",deliver_type);
													    }
													    if(map.get("pay_type")!=null){
													    	pay_type=map.get("pay_type").toString();
													    	pay_type = param.getParaCode2ByParaCode1("112",pay_type);
													    }
													    if(map.get("phone")!=null){phone=map.get("phone").toString();}
													    if(map.get("cellphone")!=null){cellphone=map.get("cellphone").toString();}
													    if(map.get("consignee")!=null){consignee=map.get("consignee").toString();}
													    if(map.get("post_code")!=null){post_code=map.get("post_code").toString();}
													    if(map.get("province")!=null){
													    	province=map.get("province").toString();
													    	if(!province.equals("0")){
													    		province = areaInfo.getAreaNameByCode(province);
													    	}else{
													    		province="";		
													    	}
													    }
													    if(map.get("eparchy_code")!=null){
													    	eparchy_code=map.get("eparchy_code").toString();
													    	if(!eparchy_code.equals("0")){
													    		eparchy_code = areaInfo.getAreaNameByCode(eparchy_code);
													    	}else{
													    		eparchy_code="";		
													    	}
													    }
													    if(map.get("city")!=null){
													    	city=map.get("city").toString();
													    	if(!city.equals("0")){
													    		city = areaInfo.getAreaNameByCode(city);
													    	}else{
													    		city="";		
													    	}
													    }
													    if(map.get("addr")!=null){addr=map.get("addr").toString();}
													    if(map.get("oper_date")!=null){oper_date=map.get("oper_date").toString().substring(0,10);}
													    if(map.get("carriage_pay")!=null){carriage_pay=map.get("carriage_pay").toString();}
													    if(map.get("sum_money")!=null){sum_money=map.get("sum_money").toString();}
													    if(map.get("remark")!=null){remark=map.get("remark").toString();}
												
									%>
												
												<td width="250" height="150" align="center" bgcolor="white">									    
													
													<table width="283" border="0" cellspacing="0" cellpadding="2">
														<tr>
															<td width="150" height="26" align="left">
																交易日期:<%=oper_date%>
															</td>
															<td width="125">
																<span class="shanchu">
																	<% 
																		if (order_type == "1" || order_type.equals("1")){
																	out.println("未付款");
																}else if (order_type == "2" || order_type.equals("2")){
																	out.println("已付款，待确定");
																}else if (order_type == "3" || order_type.equals("3")){
																	out.println("确定收货");
																}else if (order_type == "4" || order_type.equals("4")){
																	out.println("申请退货");
																}else if (order_type == "5" || order_type.equals("5")){
																	out.println("未付账");
																}
																else if (order_type == "6" || order_type.equals("6")){
																	out.println("确定收款发货");
																}%>
																</span>
															</td>
														</tr>
													</table>
													
													<table width="100%" border="0" cellspacing="0" cellpadding="4">
														<tr>
															<td width="39%">
																<img
																	style="BORDER-LEFT-COLOR: #333333; BORDER-BOTTOM-COLOR: #333333; BORDER-TOP-COLOR: #333333; BORDER-RIGHT-COLOR: #333333"
																	src="<%=filepath%>" width="83" height="74" border=1>															</td>
															<td width="61%" align="left">
																商品：<a href="/supply/saleInquiry.jsp?sale_id=<%=sale_id%>" target="_blank"><%=pro_name%></a>
																</br>
																单价：<%=price%>折扣：<%=discount%>
																</br>
																交易数量:<%=num%>&nbsp;金额：<%=money%>
																</br>
																运费:<%=carriage_pay%>总金额:<%=sum_money%>
														  </td>
														</tr>
												  </table>
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td align="left">
																交易码：<%=trade_id%></br>
																买方：<a href="/admin/customerMgr/Custinfo.jsp?obj_cust_id=<%=buy_cust_id%>&user_id=" target="_blank"><%=buy_cust_name%></a></br>
																卖方：<a href="/admin/customerMgr/Custinfo.jsp?obj_cust_id=<%=obj_cust_id%>&user_id=" target="_blank"><%=sale_unit%></a></br>
																运输类型：<%=deliver_type%></br>
																付款类型：<%=pay_type%></br>
																电话：<%=phone%>&nbsp;手机：<%=cellphone%></br>
																收货人：<%=consignee%>&nbsp;邮编：<%=post_code%></br>
																省市区：<%=province%>-<%=eparchy_code%>-<%=city%></br>
																详细地址：<%=addr%>

															</td>
														</tr>
												  </table>
												</td>
												<td width="0" height=25></td>
									<%
									      }
									    }
									   out.print("<td height=25></td></tr><tr><td height=15></td></tr>");
									  }
									  }
									%>
	          <tr bgcolor="white">
					<td background="/images/newsbg.gif" align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
					<td width="534" colspan="7"  align="right" background="/images/newsbg.gif"  style=" padding:2px 5px;">
					<%if(pages>1){%>
					<a href="index.jsp?iStart=0&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">首页 </a>&nbsp; &nbsp;
						<%}%>
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
					if(pages>1){
					%>
				 <a  href="index.jsp?iStart=<%=pages-1%>&start_date=<%=start_date%>&end_date=<%=end_date%>&order_type=<%=order_type%>&cust_name=<%=cust_name%>">尾页</a>
				 	<%}%>
				 	</td>
	     </tr>		
			 <% 
			  }else if(orderList==null)
				{				
				%>
				<tr class="bt">											
						<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"align=center colspan="6">
							无交易记录！				
						</td>
						
				</tr>
				<%
				}
				%>
        
		    </table>		  
		    <table>
		    		<tr>
		    				<td height="30">
		    				</td>
		    		</tr>
		    </table>
</body>
</html>


