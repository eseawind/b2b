<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%@page pageEncoding="gbk"%>   
<%request.setCharacterEncoding("gbk");%>

<%
	String trade_id = "";
	if ( request.getParameter("trade_id") != null )
	{
		trade_id = request.getParameter("trade_id");
	}
	 
  
	String key_location = "";
	String key_price = "";
	String remark = ""; 
	KeyPriceInfo priceInfo = new KeyPriceInfo();
	ArrayList priceList = priceInfo.getKeyPriceInfoById( trade_id );
	 
	if( priceList != null )
	{	
		for( int i = 0; i < priceList.size(); i++ )
		{
			HashMap pmap = ( HashMap )priceList.get( i );
			 
			if( pmap.get( "key_location" ) != null )
			{
				key_location = pmap.get( "key_location" ).toString();
			} 
			if( pmap.get( "key_price" ) != null )
			{
				key_price = pmap.get( "key_price" ).toString();
			} 
			if( pmap.get( "remark" ) != null )
			{
				remark = pmap.get( "remark" ).toString();
			}
		}
	} 
	
%>
<html>
	<head>
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>关键字价格设置</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		
		<script language="javascript">
			function Check_Value()
			{
				if( document.form.key_location.value == "" )
				{
					alert( "关键字位置不能为空！" );
					return false;
				}
				if( document.form.key_price.value == "" )
				{
					alert( "关键字位价格不能为空！" );
					return false;
				}
			}
		</script>
		
	</head>
	<body>
	 
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
			<tr>
				<td>
					<form name="form" action="/doTradeReg.do" method="post">
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr height="25">
							<td class="u1" align="center" width="20%">关键字位置</td>
							<td class="u2" align="center" width="40%">
								<input type="text" name="key_location" id="key_location" size="8" value="<%=key_location%>" readonly />
							</td>
						</tr>
						<tr>
							<td class="u1" align="center" width="20%">设置价格</td>
							<td class="u2" align="center" width="40%">
								<input type="text" name="key_price" id="key_price" size="8" value="<%=key_price%>" />&nbsp;元
							</td> 
						</tr>
						<tr>
							<td class="u1" align="center" width="20%">备注</td>
							<td class="u2" align="center" width="40%">
								<textarea name="remark" id="remark" rows="6" cols="25"><%=remark%></textarea>
							</td> 
						</tr>
						<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>" />
						<input type="hidden" name="trade_type_code" id="trade_type_code" value="1325" />
						<tr>
							<td class="u6" colspan="6">
								 <input type="submit" name="submit" value="提  交" onclick="return Check_Value()"/>
								 &nbsp;&nbsp;&nbsp;	
								 <input type="button" name="button" value="返  回" onClick="location.href='locationPricing.jsp'"/>	 
							</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>



