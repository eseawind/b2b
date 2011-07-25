<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="sale" class="com.saas.biz.saleMgr.SupplyInfo" scope="page" />
<jsp:useBean id="cust" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<jsp:useBean id="level" class="com.saas.biz.custMgr.CustClass" scope="page" />
<%
  String sale_id="",cust_name="",sale_price="",title="",addr="",content="",commodity_price="",
  publish_date="",end_date="",login="0",s_id="";
  String file_path="/images/cp.gif";
  if(request.getParameter("sale_id")!=null){
    sale_id=request.getParameter("sale_id");
  }
  Custinfo info = new Custinfo();
  ArrayList list = new ArrayList();
  HashMap map=sale.getSaleInfoById(sale_id);
  HttpSession  logsession = request.getSession(); 
   if(map.get("sale_unit")!=null){
    String sale_unit=map.get("sale_unit").toString();
    
  	list = info.getCustomerInfo(sale_unit);
    if(list!=null && list.size()>0){
      HashMap customer=(HashMap)list.get(0);
      if(customer.get("cust_name")!=null){
        cust_name=customer.get("cust_name").toString();
      }
    }
   }
   if(logsession.getAttribute("SESSION_USER_ID")==null){
      cust_name="登录后可见";
   }else{
      s_id=(String)logsession.getAttribute("SESSION_USER_ID");
      login="1";
   }
  if(map.get("title")!=null){title=map.get("title").toString();}
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
    
     if(map.get("file_path")!=null){
       file_path=map.get("file_path").toString();
	}else{
		file_path="/images/cp.gif";
	}
    String sale_unit="",cust_class="";
	if(map.get("sale_unit")!=null){
	     sale_unit=map.get("sale_unit").toString();
	     cust_class=level.cust_Class_Name(sale_unit);
	}
	
	String cust_names = "",company_address="",group_contact_phone="",fax_nbr="",email="",website="",qq="",post_code="";

	  	if(list!=null && list.size()>0){
	  		HashMap maps = (HashMap)list.get(0);
	  		if(maps.get("cust_name")!=null){cust_names=maps.get("cust_name").toString();}
	  		if(maps.get("company_address")!=null){company_address=maps.get("company_address").toString();}
	  		if(maps.get("group_contact_phone")!=null){group_contact_phone=maps.get("group_contact_phone").toString();}
	  		if(maps.get("fax_nbr")!=null){fax_nbr=maps.get("fax_nbr").toString();}
	  		if(maps.get("email")!=null){email=maps.get("email").toString();}
	  		if(maps.get("website")!=null){website=maps.get("website").toString();}
	  		if(maps.get("qq")!=null){qq=maps.get("qq").toString();}
	  		if(maps.get("post_code")!=null){post_code=maps.get("post_code").toString();}
	  	}
	//取出该公司其他产品	
	ArrayList otherlist = sale.getOtherInfoByCust(sale_unit);
	
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title><%=title%></title>
	<script type="text/javascript" src="/js/prototype.js"></script>
	<script type="text/javascript" src="inquiry.js"></script>
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
</head>
<body>
   <jsp:include flush="true" page="/include/top.jsp" />
	<table width="980" border="0" align="center" cellpadding="2" cellspacing="0"0>
		<tr>
			<td height="42" valign="bottom">
			<span style="font-size:14px;">您当前位置：</span> <a href="/zone_b2b/" class="lanse">首页</a> > <a href="/supply/supply_List.jsp?sys_code=1" class="lanse">供应信息</a>
			</td>
		</tr>
	</table>
	<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="740" valign="top">
			<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">
								供应信息
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
									<td width="47%" align="center">
										<table width="100%" border="0" cellspacing="0" cellpadding="5">
											<tr>
												<td align="center">
													<img src="<%=file_path%>" width="270" height="246" border="0">
												</td>
											</tr>
											<tr>
												<td align="center">
												</td>
											</tr>
										</table>
									</td>
									<td width="53%" valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="2">
											<tr>
												<td width="20%">
													公 司 名:
												</td>
												<td width="80%">
													<a href="/enterpriseMgr/InterimPages.jsp?cust_id=<%=sale_unit%>" target="_blank"><%=cust_name%></a>
												</td>
											</tr>
											<tr>
												<td>
													产品价格:
													<span class="zi"> </span>
												</td>
												<td>
													<span class="zi"><%=sale_price%></span>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<table width="86%" border="0" cellpadding="5" cellspacing="1" bgcolor="FFC367">
														<tr>
															<td bgcolor="FFF8EE">
																<div style=" height:30;">
																	<%if(s_id!=null && !s_id.equals("")){
																	 
																	}else{%>
																	请 <a href="javascript:openWindow();">登录</a> 后询价
																	<%}%>
																</div>
																<div>
																<%
																  if(s_id!=null && !s_id.equals("")){
																%>
																	<a href="sendInquiryInfo.jsp?sale_id=<%=sale_id%>" target="_self"><img src="/images/Mouse.gif" width="118" height="34" border="0"></a>
																<%}else{%>
																 <a href="javascript:openWindow();"><img src="/images/Mouse.gif" width="118" height="34" border="0"></a>
																<%}%>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td>
													所 在 地:
												</td>
												<td>
													<%=addr%>
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
											<form action="/doTradeReg.do" name="loginForm" method="post" target="_self">
												<div id="login">
												  <span>用户登录</span>
												   <div id="panel">
													   用户名：<input type="text" name="user_name"  id="user_name" size="20" />
													   <br>密&nbsp;&nbsp;码：<input type="password" name="passwd" id="passwd" size="20">
												   </div>
												   <input type="hidden" name="trade_type_code" id="trade_type_code" value="1304">
												   <input type="submit" value="登录" onClick=" return checkLogin()" />
												   <a href="javascript:close();" style="color:red">取消</a>  
												</div>
											</form>
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
							<table width="95%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="Eeeeee">
								<tr>
									<td width="19%" bgcolor="F9F9F9">
										<span class="STYLE1"><strong>详细信息</strong>										</span>									</td>
									<td width="81%" align="right" bgcolor="F9F9F9">
										<a href="/supply/order/b2c_content.jsp?sale_id=<%=sale_id%>"><img src="/admin/images/order_buy.gif" /></a>
									<%
									  if(s_id!=null && !s_id.equals("")){
									%>
										<a href="sendInquiryInfo.jsp?sale_id=<%=sale_id%>" target="_self"><img src="/images/zx.gif" width="75" height="21" border="0"></a>&nbsp;
									<%
										}else{ 
									%>
									<a href="javascript:openWindow();"><img src="/images/zx.gif" width="75" height="21" border="0"></a>&nbsp;
									<%
										}
									%>								  </td>
								</tr>
								<tr>
									<td align="right" bgcolor="F9F9F9">
										供应标题：									</td>
									<td bgcolor="#FFFFFF">
										<%=title%>									</td>
								</tr>
								<tr>
									<td align="right" bgcolor="F9F9F9">
										详细说明：									</td>
									<td bgcolor="#FFFFFF">
										<%=content%>									</td>
								</tr>
								
						  </table>
						</td>
					</tr>
				</table>
				<%
				  if(1==1){
				%>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			      <tr>
			        <td height="10"></td>
			      </tr>
			      <tr>
			        <td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						<td width="215" height="33" background="/images/tiao_5.gif">&nbsp;&nbsp;&nbsp;<span style="color:#23564F; font-size:14px; font-weight:bold;">联系信息</span></td>
							<td align="right" background="/images/xian5.gif">&nbsp;&nbsp;</td>
							<td width="3" height="33" background="/images/xian6.gif"></td>
						</tr>
					</table>
			        </td>
			      </tr>
			      <tr>
			        <td>
			        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="45A175">
			          
			          <tr>
			            <td bgcolor="#FFFFFF">
			           	<ul>
			              <LI><a href="/enterpriseMgr/InterimPages.jsp?cust_id=<%=sale_unit%>" target="_blank"><%=cust_names%></a><br>
			              <LI><strong>地址：</strong><%=company_address%>  
			              <LI><strong>邮编：</strong><%=post_code%>
			              <LI><strong>电话：</strong><%=group_contact_phone%>
			              <LI><strong>传真：</strong> <%=fax_nbr%>   
			              <LI><strong>QQ/MSN：</strong><%=qq%> <A href="http://wpa.qq.com/msgrd?v=1&uin=<%=qq%>&site=中国建材市场&menu=yes" target="blank"><IMG height="24" alt="点击这里给我发消息" src="../images/03_online.gif" width="84" align="Middle" border="0"></A>
			              <LI><strong>电子邮件：</strong><A href="mailto:<%=email%>"><%=email%></A>
			              <LI><strong>公司网址：</strong><A href="http://<%=website%>" target="_blank"><%=website%></A> </LI>
			            </ul>
			            </td>
			          </tr>
			        </table>
			        </td>
			      </tr>
				  <tr>
			        <td height="10"></td>
			      </tr>
			    </table>
			    <%
			    	} else {
			    %>
			    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			      <tr>
			        <td height="10"></td>
			      </tr>
			      <tr>
			        <td>
			        <table width="100%" border="0" cellpadding="0" cellspacing="0">
			          <tr>
			            <td background="/images/lmtt_03.gif" height="29">&nbsp;&nbsp;<span style="color:#FFFFFF; font-size:14px; font-weight:bold;">联系信息</span></td>
			          </tr>
			        </table>
			        </td>
			      </tr>
			      <tr>
			        <td>
			        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="45A175">
			          <tr>
			          <tr>
			            <td bgcolor="#FFFFFF">
			           		企业信息登陆后可见
			            </td>
			          </tr>
			        </table>
			        </td>
			      </tr>
				  <tr>
			        <td height="10"></td>
			      </tr>
			    </table>
			    <%
			    	} 
			    %>
			</td>
			<td valign="top">&nbsp;
				
			</td>
			<td width="228" valign="top">
				<jsp:include flush="true" page="sale_right.jsp"/>
			</td>
		</tr>
	</table>

	<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="29" background="/images/dl.gif">&nbsp;&nbsp;
        <span style="color:#FFFFFF; font-size:14px; font-weight:bold;">该公司其它信息</span></td>
      </tr>
      <tr>
        <td height="69"><table width="100%" border="0" cellspacing="0" cellpadding="10">
          <tr>
            <td align="center">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <%
            	String sale_ids="",titles = "",start_date="";
            	if (otherlist != null && otherlist.size()>0){
            		int ros=0,index=0;
            		if(otherlist.size()%2==0){
					    ros=otherlist.size()/2;
					  }else{
					     ros=otherlist.size()/2+1;
					  }
						for(int i=0;i<ros;i++){
						%>
							<tr>
						<%
							for(int j=0;j<2;j++){
								if(otherlist.size()>index){
									HashMap maping = (HashMap)otherlist.get(index++);
									if (maping.get("sale_id")!=null){sale_ids=maping.get("sale_id").toString();}
									if (maping.get("title")!=null){titles=maping.get("title").toString();}
									if (maping.get("start_date")!=null){start_date=maping.get("start_date").toString();
									if(start_date.length()>10)start_date=start_date.substring(0,10);}
									String	path="/images/cp.gif";
									path = new NewsInfo().getCustAttachPath( sale_ids, "0");
									
            			%>
                
                  <td><img border="1" alt="<%=titles%>" src="<%=path%>" width="70" height="70"></td>
                  <td>
                  	<A href="/supply/saleInquiry.jsp?sale_id=<%=sale_ids%>" target="_blank" style=" font-size:14px;">
                  		<b>供应:<%=titles%></b>                  	</A><br>
                  	<%=start_date%>                  </td>
            <%
            			}
            		}
            %>
            	 </tr>
            <%
            	}		
						}  
            %>
            </table>
           </td>
          
      </tr>
    </table>
	</td>
	</tr>
	</table>
	<jsp:include flush="true" page="/include/footer.jsp" />
	<script language="javascript">
	function ResizeImages()
	{
	   var myimg,oldwidth;
	   var maxwidth=200;
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




