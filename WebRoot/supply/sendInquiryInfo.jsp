<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="sale" class="com.saas.biz.saleMgr.SupplyInfo" scope="page" />
<jsp:useBean id="cust" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<jsp:useBean id="level" class="com.saas.biz.custMgr.CustClass" scope="page" />
<%
  String sale_id="",cust_name="",sale_price="",title="",addr="",content="",commodity_price="",
  publish_date="",end_date="",publish_user_id="";
  
  String session_user_id="";
  if(session.getAttribute("SESSION_USER_ID")!=null){
  	session_user_id = session.getAttribute("SESSION_USER_ID").toString();
  } 
  
  if(request.getParameter("sale_id")!=null){
    sale_id=request.getParameter("sale_id");
  }
  HashMap map=sale.getSaleInfoById(sale_id);
  HttpSession  logsession = request.getSession(); 
   if(map.get("sale_unit")!=null){
    String sale_unit=map.get("sale_unit").toString();
    ArrayList list=cust.genSpecCustInfo(sale_unit);
    if(list!=null && list.size()>0){
      HashMap customer=(HashMap)list.get(0);
      if(customer.get("cust_name")!=null){
        cust_name=customer.get("cust_name").toString();
      }
    }
   }
  if(map.get("title")!=null){title=map.get("title").toString();}
  if(map.get("publish_user_id")!=null){publish_user_id=map.get("publish_user_id").toString();}
  if(map.get("sale_price")!=null){sale_price=map.get("sale_price").toString();}
  if(map.get("sale_addr")!=null){addr=map.get("sale_addr").toString();}
  if(map.get("content") !=null){content=map.get("content").toString();}
  if(map.get("commodity_price") !=null){commodity_price=map.get("commodity_price").toString();}
  if(map.get("publish_date")!=null){
      publish_date=map.get("publish_date").toString();
      if(publish_date.length()>10){
        publish_date=publish_date.substring(0,10);
      }
    }
  if(map.get("end_date")!=null){
      end_date=map.get("end_date").toString();
      if(end_date.length()>10){
        end_date=end_date.substring(0,10);
      }
    }
    String file_path="";
     if(map.get("file_path")!=null){
       file_path=map.get("file_path").toString();
 
	}else{
	file_path="/images/cp.gif";;
	}
    String sale_unit="",cust_class="";
	if(map.get("sale_unit")!=null){
	     sale_unit=map.get("sale_unit").toString();
	     cust_class=level.cust_Class_Name(sale_unit);
	}
	String enq_Tile="我对您发布的“"+title+"”很感兴趣！";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>供应详细信息</title>
	<script type="text/javascript" src="/js/prototype.js"></script>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	#login{
     position: relative;
     display: none;
         top: 20px;
         left: 30px;
         background-color: #ffffff;
         text-align: center;
         border: solid 1px;
         padding: 10px;
         z-index: 1;
   }
	-->
	</style>
	<link href="/style/css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/supply/supply.js"></script>
    <style type="text/css">
<!--
.STYLE1 {font-weight: bold}
.STYLE2 {font-weight: bold}
-->
    </style>
</head>
<body>
  <jsp:include flush="true" page="/include/top.jsp" />
	<table width="980" border="0" align="center" cellpadding="2" cellspacing="0"0>
		<tr>
			<td height="42" valign="bottom">
			<span style="font-size:14px;">您当前位置：</span> <a href="/" class="lanse">首页</a> > <a href="/supply/"class="lanse">供应信息</a> / <a href="#"class="lanse">查看供应信息</a> 
			</td>
		</tr>
	</table>
	<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="740" valign="top">

				<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">
								产品名称
							</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg"> 
							</td>
						</tr>
					</table>
				<table width="100%" border="0" cellpadding="10" cellspacing="1" bgcolor="90ABDF">
					<tr>
						<td height="255" valign="top" bgcolor="FFFFFF">
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1">
								<tr>
									<td width="47%" align="left">
										<table width="100%" border="0" cellspacing="0" cellpadding="5">
											<tr>
												<td align="left">
													<img src="<%=file_path%>" width="130px" height="130px" border="0">
												</td>
											</tr>
										</table>
									</td>
									<td width="53%">
										<table width="100%" border="0" cellspacing="0" cellpadding="2">
											<tr>
												<td width="20%">
													公 司 名:
												</td>
												<td width="80%">
													<%=cust_name%>
												</td>
											</tr>
											<tr>
												<td width="20%">
													供应标题:
												</td>
												<td width="80%">
													<%=title%>
												</td>
											</tr>
											<tr>
												<td>
													当 前 价:
													<span class="zi"> </span>
												</td>
												<td>
													<span class="zi"><%=sale_price%></span>
												</td>
											</tr>
											<tr>
												<td>
													所 在 地:
												</td>
												<td>
													<%=title%>
												</td>
											</tr>
											<tr>
												<td>
													发布日期:
												</td>
												<td>
													<%=publish_date%>
												</td>
											</tr>
											<tr>
												<td>
													有 效 期:
												</td>
												<td>
													<%=end_date%>
												</td>
											</tr>
										</table>
										<table width="100%" border="0" cellspacing="1" cellpadding="0">
											<tr>
												<td height="1" class="xian"></td>
											</tr>
											<tr>
												<td height="30">
													
												</td>
											</tr>
											<tr>
												<td height="1" class="xian"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td>&nbsp;
										
									</td>
								</tr>
							</table>
							<form action="/doTradeReg.do" name="loginForm" method="post" target="_self">
							<table width="95%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="Eeeeee">
								<tr>
									<td width="19%" bgcolor="F9F9F9">
										<span class="STYLE1"><strong>我要询价</strong>										</span>									</td>
									<td width="81%" align="right" bgcolor="F9F9F9">&nbsp;									</td>
								</tr>
								<tr>
									<td align="right" bgcolor="F9F9F9">
								    询价标题：</td>
									<td bgcolor="#FFFFFF"><input type="text" name="rsrv_str3" id="rsrv_str3" maxlength="100" size="35" value=<%=enq_Tile%> style="border-bottom:1px solid #ccc;border-right:1px solid #ccc;border-left:1px solid #666;border-top:1px solid #666; color:#666666;">
								    <span style="color:red">*</span>									</td>
								</tr>
								<tr>
									<td align="right" bgcolor="F9F9F9">
									订货总量：</td>
									<td bgcolor="#FFFFFF">
										<input type="text" name="rsrv_str4" id="rsrv_str4" size="5" maxlength="10" onKeyUp="if(isNaN(this.value))this.value=''" style="border-bottom:1px solid #ccc;border-right:1px solid #ccc;border-left:1px solid #666;border-top:1px solid #666;"> 件									</td>
								</tr>
								<tr>
									<td align="right" bgcolor="F9F9F9">
									期望价格：</td>
									<td bgcolor="#FFFFFF">
										<input type="text" name="rsrv_str5" id="rsrv_str5" size="5" maxlength="10" onKeyUp="if(isNaN(this.value))this.value=''" style="border-bottom:1px solid #ccc;border-right:1px solid #ccc;border-left:1px solid #666;border-top:1px solid #666;"> 元/件 (单价)									</td>
								</tr>
								<tr>
									<td align="right" valign="top" bgcolor="F9F9F9">
									补充信息：</td>
									<td bgcolor="#FFFFFF">
									<textarea name="content" id="content" cols="45" rows="6" style="border-bottom:1px solid #ccc;border-right:1px solid #ccc;border-left:1px solid #666;border-top:1px solid #666;"></textarea><span style="color:red">*</span>									</td>
								</tr>
								<tr>
									<td align="center" bgcolor="F9F9F9" colspan="2">
									   <input type="hidden" name="cust_id" id="cust_id" value="<%=sale_unit%>">
									   <input type="hidden" name="user_id" id="user_id" value="<%=publish_user_id%>">
									   <input type="hidden" name="sale_id" id="sale_id" value="<%=sale_id%>">
									   <input type="hidden" name="deal_tag" id="deal_tag" value="1">
									   <input type="hidden" name="session_user_id"  id="session_user_id" value="<%=session_user_id%>">
									   <input type="hidden" name="trade_type_code" id="trade_type_code" value="1308">
									   <input type="submit" name="comm" id="comm" value="确认发送询价" onClick=" return checkValue()">								  
									</td>
								</tr>
							</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
			<td valign="top">&nbsp;
				
			</td>
			<td width="228" valign="top">
				<jsp:include flush="true" page="sale_right.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	<jsp:include flush="true" page="/include/footer.jsp" />
	<script language="javascript">
	function ResizeImages()
	{
	   var myimg,oldwidth;
	   var maxwidth=600;
	   for(i=0;i<document.images.length;i++){
	     myimg = document.images[i];
	     if(myimg.width > maxwidth)
	     {
	        oldwidth = myimg.width;
	        myimg.style.width = maxwidth;
	        myimg.style.height = "auto";
	     }
	   }
	}
	ResizeImages();
  </script> 

</body>
</html>




