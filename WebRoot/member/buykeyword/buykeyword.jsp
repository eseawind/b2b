<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" /><jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" /><%@ page import="java.text.SimpleDateFormat"%>
<%
   HttpSession logsession = request.getSession();
   String rankprice_id="",cust_id="",user_id="",news_id="",remark="";
   news_id=comm.GenTradeId();
   rankprice_id =comm.GenTradeId();
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){
			
		cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
		}
		if(logsession.getAttribute("SESSION_USER_ID")!=null){
			
		user_id=logsession.getAttribute("SESSION_USER_ID").toString();
		}

	ArrayList list=null;
	if(null!=list&&list.size()>0){
	 HashMap map = (HashMap) list.get(0);
		if(null!=map.get("remark"))
			 remark= map.get("remark").toString();
	}
	Calendar cal = Calendar.getInstance();
	String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	cal.add(Calendar.MONTH, 1);
	String end = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>
<html>
<head>
<title>B2B���������̨����ϵͳ</title>
<link href="/style/layout1.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='/dwr/interface/PriceRankInfo.js'></script>
<script type='text/javascript' src='/dwr/interface/KeyPriceInfo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script language="javascript"  src="/js/UrlEncode.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>
<script language="JavaScript">
			function childver()
			{
				var selectOb= document.getElementById("price");//select����   
				var selectId = selectOb.selectedIndex;//��ǰѡ�������   
				var selectValue=  selectOb.options[selectOb.selectedIndex].value//�õ�ֵ
				var custId=$("cutmp").value;
				var chId=$("ch_id").value;
				var vl=$("keyword").value;
				var pc=$("price").value;
				var titl=$("title").value;
				var ul=$("link").value;
				 if(null==vl||vl==""){
					 alert("������ؼ��֣�");
					 return false;
		     } else if(pc=="0"){
		     	 alert("��ѡ�񾺼�λ�ã�");
					 return false;
		     	
		     	}else if(null==titl||titl==""){
		     			alert("����д��ʾ���⣡");
					    return false;		     			
		     			}else if(!IsURL(ul)){
		     				alert("����д��ȷ��URL��");
					    return false;	
		     				}
				PriceRankInfo.checkInfo_KEY(selectValue,getFlagT);
			}
			function getFlagT(val){
				if(val==1){
					alert('�Բ��𣡴˾���λ���Ѿ���ѡ����ѡ������λ�ã�');
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
				if(!val)
				  	{		  	
			  	  alert("���ڱ���Ŀ�¹���ı��ؼ��ֻ�û���ڣ������ظ�����");
			  	  return false;
		  	   }
		  	   else{ 
		  	   	//alert('�ɹ�');
		    	document.childForm.submit();
		    }			
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

         <table width=100% border=0 cellpadding=1 cellspacing=1 align=center  bgcolor="#98D9A2">
         	 <tr>
         	 	<td colspan="4" class="head">
         	 		<a href="/member/buykeyword/myOppPrice.jsp">�ҵľ������</a>
         	 	</td>
         	</tr>
           <tr>
             <td class="u1"> ����Ĺؼ��֣�</td> 
             <td class="u2"><input type="text" name="keyword" id="keyword" maxlength="50" size="10" value=""> (25������) <font color="#ff0000">*</font>
             </td>
             <td class="u1">������Ŀ��</td>
             <td class="u2"><select name="ch_id" id="ch_id" maxlength="25" >
                 <option value="8855381456">��Ʒ</option>
                 <option value="7830633062">��Ӧ</option>
                 <option value="6871426767">��</option>
                 <option value="5563378845">��ҵ</option>
                 <option value="1455415210">����</option>
               </select>
             </td>
           </tr>
           <tr>
             <input type="hidden" name="cutmp" id="cutmp"  value="<%=cust_id%>" >
             <td class="u1"> ��ʼʱ�䣺 </td>
             <td class="u2"><input type="text" name="start_date" id="start_date" size="10" value="<%=start%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
             <td class="u1">����ʱ�䣺 </td>
             <td class="u2"><input type="text" name="end_date" id="end_date" size="10" value="<%=end%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1">����λ�ã�</td>
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
								select = select+"<option value="+key_location+">"+key_location+"</option>";
							}
				}
             %>
             <script language="javascript">
		         function getSelectedText(value){
		             var keyword = document.getElementById('keyword').value;
		             PriceRankInfo.checkInfo_Key_price(keyword,value,getFlag);
		             
		             KeyPriceInfo.getKeylocationPrice(value,setData);
		            
						 }
						 
						function setData(data){
							document.getElementById('price2').innerHTML=data;
						}
						 
				 		function getFlag(val){
				 			if(val==1){
				 				alert('�Բ��𣡴˾���λ���Ѿ���ѡ����ѡ������λ�ã�');
				 			}
						}
						</script>
             <td class="u2" colspan=3><select  name="price" id="price" size="1" maxlength="50"  onchange="getSelectedText(this.value);" ><!--onKeyUp="if(isNaN(value))execCommand('undo')"--> 
             							<option value="0">��ѡ��...</option>
             							<%=select%>
      					       	</select>
      		<span id="price2"></span>(0.0Ԫ��) <font color="#ff0000">*</font>
			<!--input type="hidden" id="price" name="price" value=""-->
             </td>
             <td class="u1" style="display:none">�������ڣ�</td>
             <td class="u2"style="display:none"><input type="text" name="publish_date" id="publish_date" size="10" value="<%=start%>" onFocus="setday(this);"> <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1"> ��ʾ���⣺ </td>
             <td class="u2"><input name="title" id="title" size="35" maxlength="50" value=""> <font color="#ff0000">*</font>
             </td>
             <td class="u1"> ���ӵ�ַ�� </td>
             <td class="u2"><input name="link" id="link" size="30" maxlength="50" value="http://"> (http://��ͷ) <font color="#ff0000">*</font>
             </td>
           </tr>
           <tr>
             <td class="u1"> ���ͼƬ�� </td>
             <td class="u2" colspan="3"><input name="rsrv_str6" id="rsrv_str6" value="<%=news_id%>" type="hidden">
                 <div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
                   <iframe src="/inc/uploadImg.jsp?root_id=<%=news_id%>" width="100%" height="150px" frameborder="0" valign="top" marginwidth="0" marginheight="0" scrolling="no"></iframe>
                 </div></td>
           </tr>
           <tr>
             <td class="u1"> ������֣� </td>
             <td class="u2" colspan=3><textarea name="content" id="content" cols=25 rows=4></textarea>
             </td>
             <td class="u1" style="display:none">��ע��</td>
             <td class="u2" style="display:none"><textarea name="remark"  id="remark" cols=25 rows=4 ></textarea>
             </td>
           </tr>
           <tr >
             <td class="u1"> ��Ʒ��ַ�� </td>
             <td class="u2" colspan="3"><input name="rsrv_str7" id="rsrv_str7" size="60" maxlength="70" value="">
             </td>
           </tr>
           <tr>
             <td class="u3" colspan="4" align="center"><input name="comit" type="button" value="" onClick="return childver()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand"></td>
           </tr>
           <input type="hidden" name="ifchecked" id="ifchecked" value="0">
           <!--0δ����,1Ϊ��У��Ч,2�����Ч��-->
           <input type="hidden" name="rankprice_id" id="rankprice_id" value="<%=rankprice_id%>" >
           <input type="hidden" name="trade_type_code" id="trade_type_code" value="5858">
         </table>
</form>
</body>
</html>




