<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="channel" class="com.saas.biz.channelMgr.ChannelInfo" scope="page" />
<%@ page import="com.saas.biz.pricerankMgr.PriceRankInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%
	String iStart = "1";
	String meun_idx = "",title="",ch_id="",price="",publish_date="",rankprice_id="",keyword="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	PriceRankInfo rankInfo = new PriceRankInfo();
	ArrayList linkArray = rankInfo.getApplication(Integer.valueOf(iStart).intValue(),10);
	int counter = rankInfo.getApplication();
	String toolsBar=tools.getPageTools(String.valueOf(counter),"10","keywordList.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>关键字管理</title>
		
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
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=left bgcolor="#FCB0B0">
						<tr class="u4" height="25">
							<td align="left" width="15%">关键字</td>
							<td align="left" width="15%">显示标题</td>
							<td align="left" width="15%">栏目名</td>
							<td align="left" width="15%">每次点击价</td>
							<td align="left" width="15%">申请时间</td>
							<td align="left" >查看审批</td>
						</tr>
						<%
						String price_p="" ,ifchecked="";
						if(linkArray != null && linkArray.size() > 0) 
						{
							for(int i=0;i<linkArray.size();i++) 
							{
								HashMap map = (HashMap) linkArray.get(i);
								if(map.get("rankprice_id")!=null)
								  rankprice_id = map.get("rankprice_id").toString();
								if(map.get("ifchecked")!=null)
								  ifchecked = map.get("ifchecked").toString();
								  
							  if(map.get("publish_date")!=null)
								 publish_date=map.get("publish_date").toString();
								 
								if(map.get("ch_id")!=null){
								  ch_id=map.get("ch_id").toString();
								  ch_id=channel.getChName(ch_id);							 
								 }
								 
								if(map.get("price")!=null){
								   	price=map.get("price").toString();
								   	 KeyPriceInfo priceInfo = new KeyPriceInfo();
									 ArrayList plist = priceInfo.getKeyPriceInfo(price);
									 if(null!=plist){
									 		HashMap pmap = (HashMap)plist.get(0);
											if( pmap.get( "key_price" ) != null )
											{
												price_p = pmap.get( "key_price" ).toString();
											} 		
								   		}
								   }				   
								 if(map.get("title")!=null)
								  title=map.get("title").toString();	
								 							 
							   if(map.get("keyword")!=null)
								 keyword=map.get("keyword").toString();
									%>
									<tr class="u2">
										<td align="left" width="15%"><a href="seeone.jsp?rankprice_id=<%=rankprice_id%>"><%=keyword%></a></td>
										<td align="left" width="15%"><%=title%></td>
										<td align="left" width="15%"><%=ch_id%></td>
										<td align="left" width="15%"><%=price_p%>元</td>
										<td align="left" width="15%"><%=publish_date%></td>
										<%if(ifchecked.equals("0")){%>
										<td align=left>
											<a href="viewKeyword.jsp?rankprice_id=<%=rankprice_id%>" TARGET="" onclick="mydefss()"><img src=/images/edit.gif width=16 height=16 border=0  alt="进行审核"></a>
										</td>
										<%}if(ifchecked.equals("2")){%>
										<td align=left>
											<a href="viewKeyword.jsp?rankprice_id=<%=rankprice_id%>" TARGET="" onclick="mydefss()"><img src=/images/edit.png width=16 height=16 border=0  alt="进行审核"></a>审批不通过
										</td>
										<%}if(ifchecked.equals("1")){%>
										<td align=left>
											<a href="viewKeyword.jsp?rankprice_id=<%=rankprice_id%>" TARGET="" onclick="mydefss()"><img src=/images/edit.png width=16 height=16 border=0  alt="重新审核"></a>审批通过
										</td>
										<%}%>
									</tr>
									<%
								}
								}else{
			      %>
			      	<tr>
			      		<td class="u6" colspan="6">
			      			无记录！
			      		</td>
			      	</tr>
			      <%		
			      }
						%>
							<tr class="u1">
						  <%=toolsBar%>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>




