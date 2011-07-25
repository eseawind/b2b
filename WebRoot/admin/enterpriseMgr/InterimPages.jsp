<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="cust" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<%@ page import="tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
	String s_id="";
	HttpSession  logsession = request.getSession(); 
	if(logsession.getAttribute("SESSION_USER_ID")!=null){
      s_id=(String)logsession.getAttribute("SESSION_USER_ID");
   }
	String cust_id = "";
	if( request.getParameter( "cust_id" ) != null )
 	{
  		cust_id = request.getParameter( "cust_id" );
  	}
  	
  	
  	ArrayList list=cust.genSpecCustInfo(cust_id);
  	String cust_names = "",company_address="",group_contact_phone="",fax_nbr="",email="",website="",qq="",post_code="";
  	ArrayList lists = cust.getCustomerInfo(cust_id);
	if(lists!=null && lists.size()>0)
	{
		HashMap maps = (HashMap)lists.get(0);
		if( maps.get("cust_name") != null ){cust_names=maps.get("cust_name").toString();}
		if( maps.get("company_address") != null ){company_address=maps.get("company_address").toString();}
		if( maps.get("group_contact_phone") != null ){group_contact_phone=maps.get("group_contact_phone").toString();}
		if( maps.get("fax_nbr") != null ){fax_nbr=maps.get("fax_nbr").toString();}
		if( maps.get("email") != null ){email=maps.get("email").toString();}
		if( maps.get("website") != null ){website=maps.get("website").toString();}
		if( maps.get("qq") != null ){qq=maps.get("qq").toString();}
		if( maps.get("post_code") != null ){post_code=maps.get("post_code").toString();}
	}
	/*Custinfo custinfo = new Custinfo();
	ArrayList comList = custinfo.getCustInfo(cust_id);
	if(comList!=null && comList.size()>0)
	{
		HashMap comMap = (HashMap)comList.get(0);
		if(comMap.get("juristic_type_code")!=null)
		{
			cust_id = comMap.get("juristic_type_code").toString();
		}
	}*/
	 
%>

<html>
	<head>
		<title>B2B电子商务平台</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<SCRIPT language=javascript src="/js/index.js" type=text/javascript></SCRIPT>
		<SCRIPT language=javascript src="/templates/wood/js/top.js" type=text/javascript></SCRIPT>
		<SCRIPT language=javascript src="/templates/wood/js/footer.js" type=text/javascript></SCRIPT>
		<SCRIPT language=javascript src="/js/enterpriseMgr.js" type=text/javascript></SCRIPT>
</head>
<body>
	<jsp:include flush="true" page="/include/top.html" />
	<script type="text/javascript">
			document.body.onload=init;
	</script>
<%
		config configFile = new config();
		configFile.init();
		String dirpat = configFile.getString("ecms_path");
		String filepath = dirpat + "company/web/"+ cust_id;
		if ( !FileIO.ExistFloder(filepath) ) 
		{
%>
			<%
				  if(!s_id.equals("")){
			%>
				<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			      <tr>
			        <td height="10"></td>
			      </tr>
			      <tr>
			        <td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td width="215" height="33" background="/images/tiao_5.gif">&nbsp;&nbsp;&nbsp;<span style="color:#23564F; font-size:14px; font-weight:bold;">企业联系信息</span></td>
						<td align="right" background="/images/xian5.gif">&nbsp;&nbsp;</td>
						<td width="3" height="33" background="/images/xian6.gif"></td>
					</tr>
					</table>
					 <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="45A175">
			         
			          <tr>
			            <td bgcolor="#FFFFFF">
			           	<ul>
			              <LI><a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank"><%=cust_names%></a><br>
			              <LI><strong>地址：</strong><%=company_address%>  
			              <LI><strong>邮编：</strong><%=post_code%>
			              <LI><strong>电话：</strong><%=group_contact_phone%>
			              <LI><strong>传真：</strong> <%=fax_nbr%>   
			              <LI><strong>QQ/MSN：</strong><%=qq%> <A href="http://wpa.qq.com/msgrd?v=1&uin=<%=qq%>&site=中国建材市场&menu=yes" target="blank">
						  <IMG height="24" alt="点击这里给我发消息" src="/images/03_online.gif" width="84" align="Middle" border="0"></A>
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
			    	<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			      <tr>
			        <td height="10"></td>
			      </tr>
			      <tr>
			        <td>
			      <table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						<td width="215" height="33" background="/images/tiao_5.gif">&nbsp;&nbsp;&nbsp;<span style="color:#23564F; font-size:14px; font-weight:bold;">企业联系信息</span></td>
							<td align="right" background="/images/xian5.gif">&nbsp;&nbsp;</td>
							<td width="3" height="33" background="/images/xian6.gif"></td>
						</tr>
					</table>
			        <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="45A175">
			         
			          <tr>
			            <td bgcolor="#FFFFFF">
			           		企业信息<a href="/member/index.jsp">登陆</a>后可查看!
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
			    
<%
		}else 
		{
%>
			<script language="javascript">
					window.location.href='/company/web/<%=cust_id%>/';
			</script>
<%		 
		 }
%>
    <br><br><br><br><br><br><br><br>
<jsp:include flush="true" page="/include/footer.jsp" />
</body>
</html>




