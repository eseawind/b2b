<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%> 
<%@ page import="com.saas.biz.pricerankMgr.PriceRankInfo"%>
<%@ page import="com.saas.biz.attachMgr.Attachinfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" /><jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" /><%@ page import="java.text.SimpleDateFormat"%>
<%
     Attachinfo attinfo=new Attachinfo();
     ArrayList attlist=new ArrayList();
   HttpSession logsession = request.getSession();
 String rankprice_id="",rsrv_str7="",rsrv_str6="",keyword="",cust_id="",cust_name="",remark="",start_date="",end_date="",price="",ch_name="",title="",link="",content="",publish_date="";
 String price_p="",ifchecked="";
  PriceRankInfo rankInfo=new PriceRankInfo();
	if(request.getParameter("rankprice_id") != null){
			
		rankprice_id=request.getParameter("rankprice_id").toString();
		}

	ArrayList list=rankInfo.getRankByRankId(rankprice_id);
	if(null!=list&&list.size()>0){
	 HashMap map = (HashMap) list.get(0);
		if(null!=map.get("keyword"))
			 keyword= map.get("keyword").toString();
		if(null!=map.get("ifchecked"))
			 ifchecked= map.get("ifchecked").toString();
			 
		if(null!=map.get("start_date"))
			 start_date= map.get("start_date").toString();
			 
		if(null!=map.get("end_date"))
			 end_date= map.get("end_date").toString();
			 
		if(null!=map.get("price")){
			 price= map.get("price").toString();
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
			 
		if(null!=map.get("ch_name"))
			 ch_name= map.get("ch_name").toString();
			 
		if(null!=map.get("title"))
			 title= map.get("title").toString();	
			 
		if(null!=map.get("cust_id")){
		   Custinfo custinfo=new Custinfo();
			 cust_id= map.get("cust_id").toString();
			 cust_name=custinfo.getCustomerNameById(cust_id);
			 
			 }
			  
		if(null!=map.get("link"))
			 link= map.get("link").toString();
			 
		if(null!=map.get("content"))
			 content= map.get("content").toString();
			 
			 
	 if(null!=map.get("rsrv_str7"))
			 rsrv_str7= map.get("rsrv_str7").toString();
				 
	 if(null!=map.get("rsrv_str6")){//图片；
			     rsrv_str6= map.get("rsrv_str6").toString();
			     attlist=  attinfo.getFilePath(rsrv_str6);           
             if(attlist!=null&&attlist.size()>0){          
                HashMap map1=(HashMap)attlist.get(0);
                if(map1.get("file_path")!=null)
                rsrv_str6=map1.get("file_path").toString();
             }
           else{
           	rsrv_str6="/upload/wg0S2U43cRrWBM5/bm7fLQDA3pb7j7O.JPG";
           	
           	}
          rsrv_str6="<img src="+rsrv_str6+ " border=0 width=100 height=75>";
						 
			 }
			 
		if(null!=map.get("remark"))
			 remark= map.get("remark").toString();
			 
	  if(null!=map.get("publish_date"))
			 publish_date= map.get("publish_date").toString();
			 

	}

%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='/dwr/interface/PriceRankInfo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script language="javascript" src="/js/UrlEncode.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>

</head>
<body>
<form name=childForm action=/doTradeReg.do method=post target="_self">
<table width=100% border=0 cellpadding=1 cellspacing=1 align=center  bgcolor="#DEEDFD">
    <tr>
      <td class="u1"> 购买的关键字：</td>
      <td class="u2">
      	   <input type="text" name="keyword" id="keyword" readOnly  maxlength="50" size="20" value="<%=keyword%>"> 
       </td>
      <td class="u1"> 所在栏目： </td>
      <td class="u2">  
         <input type="text" name="keyword" id="keyword"  readOnly maxlength="50" size="20" value="<%=ch_name%>">   
      </td>
    </tr>
    
    <tr>
    	 <td class="u1"> 开始时间： </td>
       <td class="u2">
          <input type="text" name="start_date"  id="start_date" readOnly size="10" value="<%=start_date%>" >    
       </td>
        <td class="u1">结束时间： </td>
        <td class="u2">
          <input type="text" name="end_date" id="end_date" readOnly size="10" value="<%=end_date%>" >     
       </td>
  
    </tr>
    <tr>
      <td class="u1">发部日期：</td>
      <td class="u2" colspan=3>
      	   <input type="text" name="publish_date" id="publish_date"  readOnly size="10" value="<%=publish_date%>" >   
      </td>
    </tr>
    <tr>
      <td class="u1">显示位置：</td>
      <td class="u2">
          <input name="price" id="price" size="20" readOnly maxlength="50" value="<%=price%>">     
      </td>
      <td class="u1">每次点击费：</td>
      <td class="u2">
          <input name="price" id="price" size="20" readOnly maxlength="50" value="<%=price_p%>元">  
      </td>
    </tr>
    	 <td class="u1"> 显示标题： </td>
      <td class="u2">
         <input name="title" id="title" size="20" maxlength="50" readOnly value="<%=title%>"> 
        </td>
      <td class="u1"> 链接地址： </td>
      <td class="u2">
      <input name="link" id="link" size="20" maxlength="50"  readOnly value="<%=link%>"> 
          
        </td>
    
       <tr>
    	
    	 <td class="u1"> 相关图片： </td>
      <td class="u2" colspan="3" >
         <%=rsrv_str6%>					   
        </td>
    </tr>
     <tr>
       <td class="u1"> 内容简介： </td>
      <td class="u2">
          <textarea name="content" id="content" readOnly cols=25 rows=4 ><%=content%></textarea>
        
        </td>
        <td class="u1">备注：</td>
      <td class="u2">
          <textarea name="remark"  id="remark" cols=25 rows=4 ><%=remark%></textarea>
         
        </td>
    </tr>
    <tr>
      <td class="u1"> 产品地址： </td>
      <td class="u2" colspan="3">
       <input name="rsrv_str7" id="rsrv_str7" size="70"  readOnly maxlength="50" value="<%=rsrv_str7%>"> 
        
        </td>

    </tr>
    <tr>
      <td class="u1"> 审核： </td>
      <td class="u2" colspan="3">
       <select name="ifchecked" id="ifchecked">
       <%if(ifchecked.equals("1")){%>
       	<option value="1" selected>审核通过</option>
       	<%}else{%>
       	<option value="1">审核通过</option>
       	<%}%>
       	<%if(ifchecked.equals("0") || ifchecked.equals("2")){%>
       	<option value="2" selected>审核不通过</option>
       	<%}else{%>
       	<option value="2">审核不通过</option>
       	<%}%>
       	</select>        
        </td>
        <td class="u1"></td>
      <td class="u2">              
        </td>
    </tr>
  
    <tr>
      <td class="u3" colspan="4" align="center">
       <input name="comit" type="submit" value=""  style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand">
       	&nbsp;&nbsp;&nbsp;<img src="/admin/images/comeback.JPG" onClick="location.href='keywordList.jsp'" style="cursor:hand;" align="absmiddle">
       </td>
    </tr>
       <input type="hidden" name="rankprice_id" id="rankprice_id" value="<%=rankprice_id%>" >
    <input type="hidden" name="trade_type_code" id="trade_type_code" value="6868">

  </table>

</form>
</body>
</html>




