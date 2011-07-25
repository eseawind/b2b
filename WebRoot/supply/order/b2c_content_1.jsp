<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.*"%>
<%@ page import="com.saas.biz.attachMgr.*"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
 <%
	String sale_id = "";
	if (request.getParameter("sale_id") != null) {
		sale_id = request.getParameter("sale_id");
	  } 
	String session_cust_id="",session_user_id="",session_user_name="";
	    HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		session_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
		session_user_id = logsession.getAttribute("SESSION_USER_ID").toString();
		session_user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
	}
	
	
	String trade_id = comm.GenTradeId();
	String title = "",commodity_price = "",sale_price = "",sale_unit = "";
	
	  SaleInfo info = new SaleInfo ();
	  ArrayList list = info.getProductInfoList(sale_id);
	  EnquirydInfo enquiryd=new EnquirydInfo();	  
	if ( list!=null && list.size() > 0 ){
		HashMap map = (HashMap)list.get(0);
		if (map.get("title")!=null){title = map.get("title").toString();}
		if (map.get("sale_price")!=null){sale_price = map.get("sale_price").toString();}
		if (map.get("commodity_price")!=null){commodity_price = map.get("commodity_price").toString();}
		if (map.get("sale_unit")!=null){sale_unit = map.get("sale_unit").toString();}
	}
    String file_path= "/images/b2c_picx_03.gif";
       Attachinfo attinfo = new Attachinfo();
      ArrayList lists = attinfo.getFilePath(sale_id);
    if ( lists!=null && lists.size() > 0 ){
	    HashMap maps = (HashMap)lists.get(0);
	    if(maps.get("file_path")!=null){
	    	file_path=maps.get("file_path").toString();
	        file_path=file_path.substring(23);
		}
	}
    int  price = 0;
    //price =Integer.parseInt(commodity_price)-Integer.parseInt(sale_price);
    String p = "";
    //p=String.valueOf(Double.parseDouble(sale_price)/Double.parseDouble(commodity_price)*10).substring(0,3);
    
    ArrayList enquiryList=enquiryd.getEnquriyInfoBySaleId(sale_id); //求对商品评论的
    int counter = enquiryd.getNumEnquriyInfoBySaleId( sale_id );//求对商品评论的的总数
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link href="/style/css.css" rel="stylesheet" type="text/css" />
<link href="/zone_b2b/css/b2c.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/zone_b2b/supply/inquiry.js"></script>
<script type="text/javascript">
	function clickValue(){
		if (document.getElementById('rsrv_str3').value == '' || document.getElementById('rsrv_str3').value == null){
			alert('请填写标题');
			return false;
		}
		if (document.getElementById('content').value == '' || document.getElementById('content').value == null){
			alert('请填写内容');
			return false;
		}
		document.enquiryform.submit();
	}
</script>
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
</head>
<body>
<jsp:include flush="true" page="/supply/order/top.jsp"></jsp:include>
 
 
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="16"></td>
  </tr>
</table>
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="980" border="0" align="center" cellpadding="10" cellspacing="1" bgcolor="#EEEADF">
  <tr>
     <td valign="top" bgcolor="#FFFFFF"><!--产品区-->  
	<!--01-->
	<!--02-->
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td>
		<span style="color:#333333;font-size:14px;font-weight:bold;"><%=title%></span>&nbsp;&nbsp;(对该产品共有<%=counter%>评论)</td>
      </tr>
    </table>
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td width="28%" valign="top"><img src="<%=file_path%>" width="238" height="206"></td>
        	<td width="72%" valign="top">
		        <table width="64%" border="0" cellspacing="0" cellpadding="2">
		          <tr>
		            <td>价&nbsp;&nbsp;格：<span class="jianqian">￥<%=sale_price%>元</span></td>
		          </tr>
		          <tr>
		            <td>市场价：<span class="jianq">￥<%=commodity_price%>元</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#666666;">节省：<%=price%>元(<%=p%>折)</span></td>
		          </tr>
		           
		          <tr>
		            <td>
		            <%
		            	if ( session_cust_id!=null  && !session_cust_id.equals("") ) {
		            %>
		            <script language="javascript">
		            	function cartFormSub(){
		            		document.cartForm.submit();
		            	}
		            </script>
		            <form name="cartForm" method="post" action="/doCartTradeReg.do">
		            	<img src="/images/b2c-_17.gif" width="77" height="22" border="0" onClick="cartFormSub()" style="cursor: hand;">
		            	<input type="hidden" name="trade_type_code" id="trade_type_code" value="5555">
		            	<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>">
		            	<input type="hidden" name="cust_id" id="cust_id" value="<%=sale_unit%>">
		            	<input type="hidden" name="sale_id" id="sale_id" value="<%=sale_id%>">
		            	<input type="hidden" name="price" id="price" value="<%=commodity_price%>">
		            	<input type="hidden" name="discount" id="discount" value="<%=sale_price%>">
		            	<input type="hidden" name="user_id" id="user_id" value="<%=session_user_id%>">
		            	<input type="hidden" name="oper_user_id" id="oper_user_id" value="<%=session_user_id%>">
		            	<input type="hidden" name="oper_date" id="oper_date" value="">
		            	<input type="hidden" name="in_date" id="in_date" value="">
		            	<input type="hidden" name="num" id="num" value="1">
		            	<input type="hidden" name="remark" id="remark" value="新加购物车">
		            </form>
		            
		             <form action="/doTradeReg.do" method="post" name="enquiryform">
				        <table width="100%" border="0" cellspacing="0" cellpadding="1">
				        	<tr>
				        		<td>
				        			标&nbsp;&nbsp;题:<input type="text" id="rsrv_str3" name="rsrv_str3" >				        		</td>
				        	</tr>
				        	<tr>
				        		<td>
				        			内&nbsp;&nbsp;容:<textarea id="content" name="content" rows="5" cols="30"></textarea>				        		</td>
				        	</tr>
				        	<tr>
				        		<td>
				        			<input style="cursor: hand;" type="button" id="comit" value="提&nbsp;&nbsp;交" onClick="clickValue()">
				        			<input type="hidden" id="trade_type_code" name="trade_type_code" value="1308">
				        			<input type="hidden" id="sale_id" name="sale_id" value="<%=sale_id%>">
				        			<input type="hidden" id="cust_id" name="cust_id" value="<%=sale_unit%>">
				        			<input type="hidden" id="deal_tag" name="deal_tag" value="7">
				        			<input type="hidden" id="rsrv_str4" name="rsrv_str4" value="0">
				        			<input type="hidden" id="rsrv_str5" name="rsrv_str5" value="<%=session_user_name%>">
				        			<input type="hidden" id="user_id" name="user_id" value="<%=session_user_id%>">				        		</td>
				        	</tr>
				        </table>
				    </form>
				    <div>
				    	      <table width="100%">
				    	        <tr>
				    	        	      <td>客户最产品的最新评论</td>
				    	        	      <td><a href="/admin/enquiryMgr/enquiryList.jsp?sale_id=<%=sale_id%>">更多..</a></td>
			    	            </tr>
				    	          <tr>
				    	          	<td>标题:</td>
				    	          	<td>内容:</td>
				    	          </tr>
				    	       <%
				    	          if(enquiryList !=null || enquiryList.size()>0)
				    	         {
				    	            for(int i=0;i<enquiryList.size();i++){
				    	               if(i>=5) break;
				    	             HashMap enquirymap = (HashMap)enquiryList.get(i);
				    	             String rsrv_str3="",enquiry_content="",rsrv_str5="";
				    	             if( enquirymap.get( "rsrv_str3" ) != null ){	rsrv_str3 = enquirymap.get( "rsrv_str3" ).toString(); }
				    	             if( enquirymap.get( "enquiry_content" ) != null ){	enquiry_content = enquirymap.get( "enquiry_content" ).toString(); }
				    	       %>
				    	            <tr>
				    	            	<td><%=rsrv_str3%></td>
				    	            	<td><%=enquiry_content%></td>
				    	            </tr>      
				    	       <%
				    	       				    	             }
				    	             }
				    	            else{
				    	            	    %>
				    	            	    <tr>
				    	            	    	 <td colspan="2"> 目前还没有对该产品的评论~!!</td>
				    	            	    </tr>
				    	            	    <%
				    	            	}
				    	       %>				    	       				    	          				    	          
                      </table>
				    </div>

		            <%
		            	}
		            		else {
		            			
		            %>
		            	<a href="javascript:openWindow();"><img src="/images/b2c-_17.gif" width="77" height="22" border="0"></a> 
		            	<a href="#"></a>
		            	<div id="login">
						  <span>用户登录</span>
						  <form name="loginForm" method="post" action="/doTradeReg.do" target="_self">
						   <div id="panel">
							   用户名：<input type="text" name="user_name"  id="user_name" size="20" />
							   <br>密&nbsp;&nbsp;码：<input type="password" name="passwd" id="passwd" size="20">
						   </div>
						   <input type="hidden" name="trade_type_code" id="trade_type_code" value="1304">
						   <input type="submit" value="登录" onClick=" return checkLogin()" />
						   <a href="javascript:close();" style="color:red">取消</a>  
					      </form>
						</div>
		            <%
		            	}
		            %>		            </td>
		          </tr>
		          <tr>
		            <td>&nbsp;</td>
		          </tr>
		        </table>	     </td>
      </tr>
    </table>    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>
</table>
<jsp:include flush="true" page="/supply/order/footer.jsp"></jsp:include>
</body>
</html>



