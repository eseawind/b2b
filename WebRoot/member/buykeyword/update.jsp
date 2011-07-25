<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%@ page import="com.saas.biz.pricerankMgr.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" /><jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" /><%@ page import="java.text.SimpleDateFormat"%>
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
	String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
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
<script language="JavaScript">
			function childver()
			{
				var selectOb= document.getElementById("price");//select对象   
				var selectId = selectOb.selectedIndex;//当前选择的索引   
				var selectValue=  selectOb.options[selectOb.selectedIndex].value//得到值
				var custId=$("cutmp").value;
				var chId=$("ch_id").value;
				var vl=$("keyword").value;
				var pc=$("price").value;
				var titl=$("title").value;
				var ul=$("link").value;
				 if(null==vl||vl==""){
					 alert("请输入关键字！");
					 return false;
		     } else if(pc=="0"){
		     	 alert("请选择每次点击费用信息！");
					 return false;
		     	
		     	}else if(null==titl||titl==""){
		     			alert("请填写显示标题！");
					    return false;		     			
		     			}else if(!IsURL(ul)){
		     				alert("请填写正确的URL！");
					    return false;	
		     				}
				PriceRankInfo.checkInfo_KEY(selectValue,getFlagT);
			}
			function getFlagT(val){
				if(val==1){
					alert('对不起！此竞价位置已经被选，请选择其他位置！');
					return false;
				}else if(val!=1){
				var custId1=$("cutmp").value;
				var chId1=$("ch_id").value;
				var vl1=$("keyword").value;
				PriceRankInfo.checkInfo(custId1,chId1,vl1,setFlag);
				}
			}
			function setFlag(val)
			{
		    document.childForm.submit();				
			}
			function IsURL(url)
					{
					    var regexp = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
					    return regexp.test(url);
					}
</script>
</head>
<body>
<form name=childForm action=/doTradeReg.do method=post target="_self">
	
         <table width=100% border=0 cellpadding=1 cellspacing=1 align=center  bgcolor="#DEEDFD">
         	<tr class="u1">
							<td align="left" colspan="5"> 
								<a href="/member/buykeyword/myOppPrice.jsp">我的竞价情况</a>
							</td>
					</tr>
           <tr>
             <td class="u1"> 购买的关键字：</td> 
             <td class="u2"><input type="text" name="keyword" id="keyword" maxlength="50" size="10" value="<%=keyword%>"> (25字以内) <font color="#ff0000">*</font>
             </td>
             <td class="u1">所在栏目 ： </td>
             <td class="u2"><select name="ch_id" id="ch_id" maxlength="25" >
             	<%if(ch_id.equals("8855381456")){%>
                 <option value="8855381456" selected>产品</option>
                <%}else{%>
                 <option value="8855381456" >产品</option>
                 <%}
                 		if(ch_id.equals("7830633062")){%>
                 <option value="7830633062" selected>供应</option>
                 <%}else{%>
                 <option value="7830633062">供应</option>
                 <%}
                 		if(ch_id.equals("6871426767")){%>
                 <option value="6871426767" selected>求购</option>
                 <%}else{%>
                 <option value="6871426767">求购</option>
               	  <%}
               		if(ch_id.equals("5563378845")){%>
                 <option value="5563378845" selected>企业</option>
                 <%}else{%>
                 <option value="5563378845" >企业</option>                 
                 <%}
                 if(ch_id.equals("1455415210")){%>
                 <option value="1455415210" selected>新闻</option>
                 <%}else{%>
                 <option value="1455415210">新闻</option>
                 <%}%>
               </select>
             </td>
           </tr>
           <tr>
             <input type="hidden" name="cutmp" id="cutmp"  value="<%=cust_id%>" >
             <td class="u1"> 开始时间： </td>
             <td class="u2"><input type="text" name="start_date" id="start_date" size="10" value="<%=start_date%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
             <td class="u1">结束时间： </td>
             <td class="u2"><input type="text" name="end_date" id="end_date" size="10" value="<%=end_date%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
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
		             PriceRankInfo.checkInfo_KEY(value,getFlag);
		             var key_location=value;
		             var data = Math.round(Math.random() * 10000);
		             var myAjax = new Ajax.Updater('price2','price.jsp?&key_location='+ key_location,
					{
						method : 'get',
						evalScripts: true
					});
				 }
				 				function getFlag(val){
				 					if(val==1){
				 						alert('对不起！此竞价位置已经被选，请选择其他位置！');
				 					}
				 				}
		</script>
             <td class="u2" colspan=3>
             						<select  name="price" id="price" size="1" maxlength="50"  onchange="getSelectedText(this.value);" ><!--onKeyUp="if(isNaN(value))execCommand('undo')"--> 
             							<option value="0">请选择...</option>
             							<%=select%>
      					       	</select>
      		<font id="price2"><%=keyprice%></font>(元￥) <font color="#ff0000">*</font>
             </td>
             <td class="u1"  style="display:none">发部日期：</td>
             <td class="u2"  style="display:none"><input type="text" name="publish_date" id="publish_date" size="10" value="<%=publish_date%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1"> 显示标题： </td>
             <td class="u2"><input name="title" id="title" size="35" maxlength="50" value="<%=title%>"> <font color="#ff0000">*</font>
             </td>
             <td class="u1"> 链接地址： </td>
             <td class="u2"><input name="link" id="link" size="30" maxlength="50" value="<%=link%>"> (http://开头) <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1"> 相关图片： </td>
             <td class="u2" colspan="3"><input name="rsrv_str6" id="rsrv_str6" value="<%= rsrv_str6%>" type="hidden">
                 <div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
                   <iframe src="/inc/uploadImg.jsp?root_id=<%=rsrv_str6%>" width="100%" height="150px" frameborder="0" valign="top" marginwidth="0" marginheight="0" scrolling="no"></iframe>
                 </div></td>
           </tr>
           <tr>
             <td class="u1"> 内容简介： </td>
             <td class="u2" colspan=3><textarea name="content" id="content" cols=25 rows=4><%=content%></textarea>
             </td>
             <td class="u1"  style="display:none">备注：</td>
             <td class="u2"  style="display:none"><textarea name="remark"  id="remark" cols=25 rows=4 ><%=remark%></textarea>
             </td>
           </tr>
           <tr >
             <td class="u1"> 产品地址： </td>
             <td class="u2" colspan="3"><input name="rsrv_str7" id="rsrv_str7" size="60" maxlength="70" value="<%=rsrv_str7%>">
             </td>
           </tr>
           <tr>
             <td class="u3" colspan="4" align="center">
             	<input name="comit" type="button" value="" onClick="return childver()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand">&nbsp;&nbsp;&nbsp;&nbsp;
             	<input name="comit" type="button" value="" onClick="javascript:window.location.href='/member/buykeyword/myOppPrice.jsp';" style="background-image: url('/admin/images/comeback.JPG');width:78px;height: 32px;border:0;cursor:hand">
             </td>
           </tr>
           <input type="hidden" name="ifchecked" id="ifchecked" value="0">
           <!--0未审批,1为审校有效,2审核无效；-->
           <input type="hidden" name="rankprice_id" id="rankprice_id" value="<%=rankprice_id%>" >
           <input type="hidden" name="trade_type_code" id="trade_type_code" value="7878">
         </table>
</form>
</body>
</html>




