<%@page contentType="text/html; charset=gb2312" language="java"%>
<jsp:useBean id="MD5" scope="request" class="beartool.MD5"/>
<HTML>
<head>
<title>订购服务</title>
<script type="text/javascript">
  function autoSubmit(){   
        var form = document.forms[0];   
        form.method = 'post';    
        form.submit();   
  } 
</script>
</head>
<body onload="setTimeout('autoSubmit()',5000)">
<%
	// MD5密钥要跟订单提交页相同，如Send.asp里的 key = "test" ,修改""号内 test 为您的密钥
											// 如果您还没有设置MD5密钥请登陆我们为您提供商户后台，地址：https://merchant3.chinabank.com.cn/
String key = "wanglonglongwang";						// 登陆后在上面的导航栏里可能找到“资料管理”，在资料管理的二级导航栏里有“MD5密钥设置” 
											// 建议您设置一个16位以上的密钥或更高，密钥最多64位，但设置16位已经足够了


//获取参数

	String v_oid = request.getParameter("v_oid");		// 订单号
	String v_pmode = request.getParameter("v_pmode");		// 支付方式中文说明，如"中行长城信用卡"
  String v_pstatus = request.getParameter("v_pstatus");	// 支付结果，20支付完成；30支付失败；
  String v_pstring = request.getParameter("v_pstring");	// 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
	String v_amount = request.getParameter("v_amount");		// 订单实际支付金额
  String v_moneytype = request.getParameter("v_moneytype");	// 币种
	String v_md5str = request.getParameter("v_md5str");		// MD5校验码
	String charge_id = request.getParameter("v_charge_id");		// 备注1
	String user_id = request.getParameter("v_user_id");		// 备注2
	String cust_id = request.getParameter("v_cust_id");		// 备注3
	String account_id = request.getParameter("v_account_id");		// 备注4
	String money = request.getParameter("v_money");		// 备注5
	String buyfordays = request.getParameter("v_buyfordays");		// 备注6
	String expire_date = request.getParameter("v_expire_date");		// 备注7
	String check_id = request.getParameter("v_check_id");		// 备注8


   v_pmode=new String(v_pmode.getBytes("ISO-8859-1"),"GBK");             
   v_pstatus=new String(v_pstatus.getBytes("ISO-8859-1"),"GBK");         
   v_pstring=new String(v_pstring.getBytes("ISO-8859-1"),"GBK");         
   //v_amount=new String(v_pstring.getBytes("ISO-8859-1"),"GBK");          
   v_moneytype=new String(v_moneytype.getBytes("ISO-8859-1"),"GBK");     
   v_md5str=new String(v_md5str.getBytes("ISO-8859-1"),"GBK");           
   remark1=new String(remark1.getBytes("ISO-8859-1"),"GBK");             
   remark2=new String(remark2.getBytes("ISO-8859-1"),"GBK");             
   

	String text = v_oid+v_pstatus+v_amount+v_moneytype+key;
	String v_md5text = MD5.getMD5ofStr(text).toUpperCase();
if (v_md5str.equals(v_md5text))
{
	if ("30".equals(v_pstatus))
	{
		out.print("支付失败");
	}else if ("20".equals(v_pstatus)){
		// 支付成功，商户 根据自己业务做相应逻辑处理
		//此处加入商户系统的逻辑处理（例如判断金额，判断支付状态，更新订单状态等等）......
		%>
		<form name=form1 action=/doChinaBankReg.do method=post>
		<TABLE width=500 border=0 align="center" cellPadding=0 cellSpacing=0>
		  <TBODY>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE:14px">MD5校验码:<%=v_md5str%></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">订单号:<%=v_oid%></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">支付卡种:<%=v_pmode%></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">支付结果:<%=v_pstring%></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">支付金额:<%=v_amount%></FONT></B></div></TD>
			</TR>
			<TR> 
			  <TD vAlign=top align=middle> <div align="left"><B><FONT style="FONT-SIZE: 14px">支付币种:<%=v_moneytype%></FONT></B></div></TD>
			</TR>
		  </TBODY>
		  <input type="hidden" name="trade_type_code" value="9912">
		  <input type="hidden" name="trade_id" value="<%=remark1%>">
		  <input type="hidden" name="order_type" value="2">
		</TABLE>
		</form>
		<%
	}
}else{
    out.print("校验失败,数据可疑");
}
%>
</body>
</HTML>


