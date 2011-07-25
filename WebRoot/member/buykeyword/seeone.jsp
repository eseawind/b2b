<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%@ page import="com.saas.biz.pricerankMgr.*"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comm2" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%
   HttpSession logsession = request.getSession();
   String rankprice_id="",cust_id="",user_id="",news_id="";
   String rsrv_str6 = "";
    if (request.getParameter("rankprice_id") != null)
    {
        rankprice_id = request.getParameter("rankprice_id");
    }
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){
			
		cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
		}
		if(logsession.getAttribute("SESSION_USER_ID")!=null){
			
		user_id=logsession.getAttribute("SESSION_USER_ID").toString();
		}

	PriceRankInfo ppp = new PriceRankInfo();
	ArrayList alist = new ArrayList();
	alist = ppp.getPriceRankBy6(rankprice_id);
	ArrayList list=null;
	
	Calendar cal = Calendar.getInstance();
	String keyword="",start_date="",end_date="",publish_date="";
	String title="";
	String link="";
	String content="";
	String rsrv_str7="",ch_id="",price="";
	String remark="";
	String keyprice = "";
	if(alist!=null && alist.size()>0){
		HashMap map1 = (HashMap)alist.get(0);
		if(map1.get("price")!=null){
			price = map1.get("price").toString();
		}
		if(map1.get("ch_id")!=null){
			ch_id = map1.get("ch_id").toString();
		}
		if(map1.get("keyword")!=null){
			keyword = map1.get("keyword").toString();
		}
		if(map1.get("start_date")!=null){
			start_date = map1.get("start_date").toString();
		}
		if(map1.get("end_date")!=null){
			end_date = map1.get("end_date").toString();
		}
		if(map1.get("publish_date")!=null){
			publish_date = map1.get("publish_date").toString();
		}
		if(map1.get("title")!=null){
			title = map1.get("title").toString();
		}
		if(map1.get("link")!=null){
			link = map1.get("link").toString();
		}
		if(map1.get("content")!=null){
			content = map1.get("content").toString();
		}
		if(map1.get("remark")!=null){
			remark = map1.get("remark").toString();
		}
		if(map1.get("rsrv_str7")!=null){
			rsrv_str7 = map1.get("rsrv_str7").toString();
		}
		if(map1.get("rsrv_str6")!=null){
			rsrv_str6 = map1.get("rsrv_str6").toString();
		}
	}
	KeyPriceInfo keyp = new KeyPriceInfo();
	ArrayList plist = keyp.getKeyPriceInfo(price);
	if(plist!=null){
		HashMap tmap = (HashMap)plist.get(0);
		if(tmap.get("key_price")!=null){
			keyprice = tmap.get("key_price").toString();
		}
	}
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='/dwr/interface/PriceRankInfo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script language="javascript"  src="/js/UrlEncode.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>
</head>
<body>
<form name=childForm action=/doTradeReg.do method=post target="_self">

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			
	  </table>
         <table width=100% border=0 cellpadding=1 cellspacing=1 align=center  bgcolor="#DEEDFD">
           <tr>
             <td class="u1"> 购买的关键字：</td> 
             <td class="u2"><%=keyword%> 
             </td>
             <td class="u1">所在栏目 ： </td>
             <td class="u2"><%=ch_id%>
             </td>
           </tr>
           <tr>
             <input type="hidden" name="cutmp" id="cutmp"  value="<%=cust_id%>" >
             <td class="u1"> 开始时间： </td>
             <td class="u2"><%=start_date%>
             </td>
             <td class="u1">结束时间： </td>
             <td class="u2" ><%=end_date%>
             </td>
           </tr>
           <tr>
             <td class="u1">竞价位置：</td>
             <%
				KeyPriceInfo priceInfo = new KeyPriceInfo();
				ArrayList priceList = priceInfo.getAllKeyPriceList();
				String select="";
				String trade_id = "";
				String key_location = "";
				if( priceList != null ){		
							for( int i = 0; i < priceList.size(); i++ )
							{
								HashMap pmap = ( HashMap )priceList.get( i );
								if( pmap.get( "trade_id" ) != null )
								{
									trade_id = pmap.get( "trade_id" ).toString();
								} 
								if( pmap.get( "key_location" ) != null )
								{
									key_location = pmap.get( "key_location" ).toString();
								}
								if(price.equals(key_location)){
									select = select+"<option selected value="+key_location+">"+key_location+"</option>";
								}else{
									select = select+"<option value="+key_location+" >"+key_location+"</option>";		
								}
							}
				}
             %>
             <script>
		             function getSelectedText(value){
		             var key_location=value;
		             var data = Math.round(Math.random() * 10000);
		             var myAjax = new Ajax.Updater('price2','price.jsp?&key_location='+ key_location,
					{
						method : 'get',
						evalScripts: true
					});
				 }
		</script>
             <td class="u2" colspan=3>
      		<font id="price2"><%=keyprice%></font>(元￥) 
             </td>
             <td class="u1"  style="display:none">发部日期：</td>
             <td class="u2"  style="display:none"><input type="text" name="publish_date" id="publish_date" size="10" value="<%=publish_date%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1"> 显示标题： </td>
             <td class="u2"><%=title%>
             </td>
             <td class="u1"> 链接地址： </td>
             <td class="u2"><a href=<%=link%> target="_blank"><%=link%></a>
             </td>
           </tr>
           <tr>
             <td class="u1"> 相关图片： </td>
             <%
				ArrayList listt = comm2.getAttachInfoByList(rsrv_str6);
				String attach_id="",file_path="";
				if (listt != null && listt.size() > 0) {
				%>
							<td class="u2" colspan=3>
					<%for (int i = 0; i < listt.size(); i++) {
						HashMap maptt = (HashMap) listt.get(i);
						attach_id = maptt.get("attach_id").toString();
						file_path = "";
						if (maptt.get("file_path") != null) {
							file_path = maptt.get("file_path").toString();
						}
						%>
								<img src="<%=file_path%>" border=0 width="100" height="100"> 
						<%
				 }%>
							</td>
			<%}if(null==listt || listt.size()<=0){
					%>
					<td class="u2" colspan=3>
						<img src="/admin/images/e_18.gif" border=0 width="100" height="100">		
					</td>
			<%}%>
           </tr>
           <tr>
             <td class="u1"> 内容简介： </td>
             <td class="u2" colspan=3><%=content%>
             </td>
             <td class="u1"  style="display:none">备注：</td>
             <td class="u2"  style="display:none"><%=remark%>
             </td>
           </tr>
           <tr >
             <td class="u1"> 产品地址： </td>
             <td class="u2" colspan="3"><%=rsrv_str7%>
             </td>
           </tr>
          <tr>
          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
          	 <a href="javascript:history.go(-1)">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
          </tr>
           <input type="hidden" name="ifchecked" id="ifchecked" value="0">
           <!--0未审批,1为审校有效,2审核无效；-->
           <input type="hidden" name="rankprice_id" id="rankprice_id" value="<%=rankprice_id%>" >
         </table>
</form>
</body>
</html>




