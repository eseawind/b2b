<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="enquiry" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page"/>
<jsp:useBean id="dealBean" class="com.saas.biz.enquirydealMgr.Enquirydealinfo" scope="page"/>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<%
  	String cust_id="";
  	String cust_id2="";
	String enquiry_id="";
	if(request.getParameter("trade_id")!=null)
	{
	   enquiry_id=request.getParameter("trade_id");
	}
	if(request.getParameter("cust_id")!=null)
	{
	   cust_id2=request.getParameter("cust_id");
	}
	HashMap map=enquiry.getEnquriyById( enquiry_id );
	String deal_tag=map.get("deal_tag").toString();
	String title="",user_name="",enquiry_content="",enquiry_date="",sale_id="";
	String get_user_id="";
	String cust_name="",save_dir = "",stock_title = "";
	if(map!=null)
	{
		if(map.get("rsrv_str3")!=null)
		{
		  title=map.get("rsrv_str3").toString();
		}
		if(map.get("save_dir")!=null)
		{
		  save_dir=map.get("save_dir").toString();
		}
		if(map.get("stock_title")!=null)
		{
		  stock_title=map.get("stock_title").toString();
		}
		if(map.get("user_name")!=null)
		{
		  user_name=map.get("user_name").toString();
		}
		if(map.get("enquiry_content")!=null)
		{
		  enquiry_content=map.get("enquiry_content").toString();
		}
		if(map.get("enquiry_date")!=null)
		{
		  enquiry_date=map.get("enquiry_date").toString();
		}
		if(map.get("sale_id")!=null)
		{
			  sale_id=map.get("sale_id").toString();
		}
		if(map.get("cust_id")!=null)
		{
			  get_user_id=map.get("cust_id").toString();
		}
		if(map.get("cust_name")!=null)
		{
			  cust_name=map.get("cust_name").toString();
		}
	}
	String qiuu_cust_name = new Custinfo().getCustNameById(cust_id2);
	String stock_url = "/"+save_dir+"/d/content-"+sale_id+".html";

	///////////////////////////////////////////////////
	String iStart="1",user_id="";
    HttpSession logsession = request.getSession();
    if (logsession.getAttribute("SESSION_USER_ID") != null) 
	{
    	user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	if( request.getParameter("iStart") != null )
	{
	   iStart=request.getParameter("iStart");
	}
	ArrayList list=dealBean.getEnquriyInfoById( enquiry_id );
	
	int counter=dealBean.getEnquriyCountById( enquiry_id );
	String pageTools=tools.getPageTools(String.valueOf(counter),"5","viewEnquiry.jsp?trade_id="+enquiry_id+"&iStart=",Integer.parseInt(iStart));

%>
<html>
	<head>
		<title>采购报价信息</title>
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		 function check_Value()
		 {
		   var content=$F("content");
		   content=delAllSpace(content);
		   if(content=="" || content==null)
		   {
		    	alert("请输入回复内容！");
		    	$("content").focus();
		     	return false;
		   }
		   return true;
		 }
		 //删除所有空格
		 function delAllSpace(str) 
		 {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		</script>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
	<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">	
		<tr class=u1>
				<td align='left' colspan='5'>
					<a href="javascript:history.go(-1)">返回</a>
				</td>
		<tr>									
		<tr>
			<td  class="u1">报价标题：</td>
			<td  align="left" class="u2"><div class="ping1"><%=title%></div></td>
		    <td class="u1">求购客户：</td>
			<td align="left" class="u2">
				<div class="ping1">
					<a href="/member/customerMgr/viewcompanyIntroduction.jsp?obj_cust_id=<%=cust_id2%>"><%=qiuu_cust_name%></a>
				</div>
			</td>
		</tr>
		<tr>
			<td class="u1">报价日期：</td>
			<td align="left" class="u2"><div class="ping1"><%=enquiry_date%></div></td>
			<td class="u1">求购产品：</td>
			<td align="left" class="u2">
				<div class="ping1">
					<a href="<%=stock_url%>"><%=stock_title%></a>
				</div>
			</td>
		</tr>
		<tr>
			<td class="u1">报价内容：</td>
			<td align="left" class="u2" colspan="3"><div class="ping1"><%=enquiry_content%></div></td>
			 
		</tr>
		<tr>
			<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:left;" align="left" colspan="4">
			 回复信息
			</td>
		</tr>
		<% 
			if( list != null && list.size() > 0 )
			{
		   		for( int i = 0; i < list.size(); i++ )
				{
			 		HashMap dealMap=(HashMap)list.get( i );
			 		String deal_content="",id="";
			 		if( dealMap.get("trade_id") != null )
					{
						id=dealMap.get("trade_id").toString();
					}
			 		if( dealMap.get("deal_content") != null )
					{
						deal_content = dealMap.get("deal_content").toString();
					}
		%>
		<tr>
			<td class="u1" style="display: inline;float: left;">
				删除回复<<%=i+1%>><a href="/doTradeReg.do?trade_type_code=1322&trade_id=<%=id%>" target="_self" onclick="return delete()">
				<img src=/images/delete.png width=16 height=16 border=0 alt="删除留言"></a>
			</td>
			<td align="left" class="u2" colspan="4">
				<div class="ping1">
					<%=deal_content%>
				</div>
			</td>
		</tr>
		<%
				}
			}
		%>
		<tr>
		 <td colspan="4" align="center" bgcolor="#FFFFFF">
			<table width=100% border=0 cellpadding=0 cellspacing=0 align=center class="u2">
			 <%=pageTools%>
			</table>
		  </td>
		</tr>
											
	  </table>
			
	</form>
	</body>
</html>




