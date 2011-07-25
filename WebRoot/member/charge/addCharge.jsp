<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="MD5" scope="request" class="beartool.MD5"/>
<%@ page import="com.saas.biz.feeSetMgr.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.acctMgr.CustAccount"%>
<jsp:useBean id="classBean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String charge_id = bean.GenTradeId();	
   HttpSession  logsession = request.getSession(); 
 //	String fbtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String cust_id = "";
	String user_id = "";
	String user_name = "";
	String cust_name = "";
  String account_id="";
  String class_id="";
  String cmoney="";
  String cust_class="";
  
  if (logsession.getAttribute("SESSION_CUST_CLASS") != null)
  {
      cust_class = logsession.getAttribute("SESSION_CUST_CLASS").toString();
  }
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    	if (logsession.getAttribute("SESSION_CUST_CLASS") != null)
    {
        class_id = logsession.getAttribute("SESSION_CUST_CLASS").toString();
    }
   if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }
   if(!cust_id.equals(""))
   {
    account_id=classBean.getBankAccouId(cust_id);
   }
   //out.println(account_id);
   if(!class_id.equals(""))
   {
   cmoney=classBean.getParamMoneyByValue("14",class_id);
   }
	String v_mid="",key="",v_url="",v_oid="",v_amount="",v_moneytype="",v_md5info="";  //定义必须传递的参数变量
	CustAccount custA = new CustAccount();
	ArrayList acctList = new ArrayList();
	acctList = custA.getALLByCustId();                                    // 商户号，
	String bank_id="";
		if(acctList!=null && acctList.size()>0){
			HashMap map = (HashMap)acctList.get(0);
			if(map.get("bank_code")!=null){
				bank_id = map.get("bank_code").toString();
			}
			if(map.get("bank_id")!=null){
				key = map.get("bank_id").toString();
			}
		}
	v_mid = bank_id;
		//out.println(bank_id+"*******"+key+"-----------"+cust_id+"<br>+v_mid="+v_mid);
	v_url = "http://b2b.bizoss.com/member/charge/webBankMgr/Receive.jsp";     // 商户自定义返回接收支付结果的页面
                                 //十六位秘钥
	Date currTime = new Date();
  SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd-"+v_mid+"-hhmmss",Locale.US);
  v_oid=sf.format(currTime); 																//推荐订单号构成格式为 年月日-商户号-小时分钟秒
	v_moneytype="CNY";                                          //费用类型 0:人民币 1:美元
	//out.println("<br><br>"+v_oid+"<br><br>");
	FeeSetInfo feeset = new FeeSetInfo();
	ArrayList feeList = new ArrayList();
	feeList = feeset.GetAllByLevel(cust_class);
	String selectFee="";
	String trade_id="",limit_time="",level_id="",fee="";
	if(null!=feeList){
		for(int i=0;i<feeList.size();i++){
			HashMap feeMap = (HashMap)feeList.get(i);
			if(feeMap.get("trade_id")!=null){
				trade_id = feeMap.get("trade_id").toString();
			}
			if(feeMap.get("limit_time")!=null){
				limit_time = feeMap.get("limit_time").toString();
			}
			if(feeMap.get("level_id")!=null){
				level_id = feeMap.get("level_id").toString();
			}
			if(feeMap.get("fee")!=null){
				fee = feeMap.get("fee").toString();
			}
			if(level_id.equals(cust_class)){
				selectFee = selectFee + "<option value="+trade_id+">"+limit_time+"</option>";
			}
		}
	}
	//key = "wanglonglongwang";
	String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;   	
	v_md5info = MD5.getMD5ofStr(text);
	//out.println("text="+text+"<br>"+v_md5info+"------------"+text+"<BR>--v_oid="+v_oid);
%>
<html>
	<head>
		<title>会员缴费</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/ChargeInfo.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/FeeSetInfo.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="charge.js"></script>
	</head>
	<body >
			<form method="post" name="NewRegisterForm" id="NewRegisterForm" action="payCharge.jsp" onsubmit="return Check_Value() ">
		  <table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#98D9A2">
								 <tr class="u1">
								   <td align="left" colspan="4" class="head"> 
									  <a href="charge.jsp">交费记录</a>
								   </td>
						      </tr>				
									<tr>
										<td class="u1" width="25%">
											定购时长：
										</td>
										<td class="u2" >
											<div class="ping1">
												<select name="buyfordays1" id="buyfordays1" style="width:150px"	onChange="calcMoney(this.value)">
													<option value="0">选择定购时长</option>
													<%=selectFee%>
											  </select>
										 </div>
										</td>
									</tr>
										<tr>
										<td class="u1" width="25%" >
											需要金额：
										</td>
										<td class="u2">
											<div class="ping1">
											<input type="text" name="money" id="moneyId"  onkeyup="if(isNaN(value))execCommand('undo')"  maxlength="20"  onblur="calcdate(this);">
										 <span>(元)</span>
										</div>
										</td>
									  </tr>
										<tr>
										<td  class="u1" width="25%">
											会费过期日：
										</td>
										<td  class="u2" >
											<div class="ping1">
											<input type="text" name="expire_date" id="expire_date"  readOnly  maxlength="20" >
										</div>
										</td>
									</tr>
									<!--tr>
										<td class="u1" width="25%" >
											对付方式：
										</td>
										<td class="u2">
										<div>
											<select name="payType" id="payType" style="width:150px"
											onChange="selecPayMod(this.value)">
											<option value="1">
												现金  
											</option>
											<option value="2">
												网购  
											</option>							
										 </select>
										</div>
										</td>										
									 </tr-->
									 <tr>
									 	<table width="100%" border="0" id="tab0" cellspacing="0" cellpadding="0" align="center" style="display:none">
										<tr>
										<td height="30" align="center">
												<div>联系运营商</div>
										</td>
									   </tr>
									  </table>
									 </tr>																	 							
									<tr>
										<table width="100%" border="0"  id="tab1" cellspacing="0" cellpadding="0" align="center" style="disp1lay:none" >
										<tr>
										<td height="30" align="center">
										<input type="hidden" name="v_md5info" value="<%=v_md5info%>">
										<input type="hidden" name="v_mid" value="<%=v_mid%>">
										<input type="hidden" name="v_oid" value="<%=v_oid%>">
										<input type="hidden" name="v_amount" id="v_amount"  value="">
										<input type="hidden" name="v_moneytype" id="v_moneytype" value="<%=v_moneytype%>">
										<input type="hidden" name="buyfordays" id="buyfordays">
										<input type="hidden" name="v_url" value="<%=v_url%>">
										<input type="hidden" name="key" value="<%=key%>">
										
										<!--insert into tf_f_fee_record-->
										<input type="hidden" name="trade_id" id="trade_id" value="<%=charge_id%>">
										<input type="hidden" name="remark1" id="remark1" value="<%=charge_id%>">
										<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
										<input type="hidden" name="fee" id="fee" value="">
										<input type="hidden" name="level_id" id="level_id" value="<%=cust_class%>">
										<input type="hidden" name="limit_time" id="limit_time" value="">
										<input type="hidden" name="publish_user_id" id="publish_user_id" value="<%=user_id%>">
										  <input type="hidden" name="trade_type_code" value="3118">
									  </tr>																	
										<!--end-->
										<td class="u3"" colspan=2>
											<input name="comit" type="submit" value="" onclick="return confirmsub()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand">
										</td>
									  
									  </table>
								</table>																			
          </form>
	</body>
</html>



