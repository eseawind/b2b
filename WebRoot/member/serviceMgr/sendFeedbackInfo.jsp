<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%
 
 
  String trade_id="";
  
  if( request.getParameter( "trade_id" ) != null )
  {
      trade_id = request.getParameter( "trade_id" );
  }
  String cust_id = "",title="",content="",in_date="",root_id = "",user_name="",user_id="";
  LeavewordsInfo wordsInfo = new LeavewordsInfo();
  ArrayList list = wordsInfo.getLeaveByTradeId(trade_id);
  HashMap map = new HashMap();
  if(list!=null){
   map = (HashMap) list.get(0);
  }
  if(map.get("title")!=null){
  	title = map.get("title").toString();
  }
  if(map.get("root_id")!=null){
  	root_id = map.get("root_id").toString();
  }
  if(map.get("cust_id")!=null){
  	cust_id = map.get("cust_id").toString();
  }
  if(map.get("in_date")!=null){
  	in_date = map.get("in_date").toString();
  }
  if(map.get("content")!=null){
  	content = map.get("content").toString();
  }
  if(map.get("user_name")!=null){
  	user_name = map.get("user_name").toString();
  }
  if(map.get("user_id")!=null){
  	user_id = map.get("user_id").toString();
  }
 
 	commMethodMgr commen = new commMethodMgr();
	String back_trade_id = commen.GenTradeId();
	
	
	ArrayList backList = new ArrayList();
	backList = wordsInfo.getLeaveByRootId(trade_id);
	
	
   
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/hrJobMgr.js"></script>
  </head>
	<body>
	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>意见回复</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	</table>		
			
	   <table width="802"  border="0" align="center" cellpadding="1" cellspacing="1">
		  <tr class="u4" height="27">
			  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">&nbsp;&nbsp;意见内容</td>
	 	</tr>
	  </table>
	  
		<table width=800 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
							<td class="u1" width="15%">
								意见主题：
							</td>
							<td class="u2" width="35%">
								<%=title%>
							</td>
							<td class="u1" width="15%">
								时间：
							</td>
							<td class="u2" width="35%">
								<%=in_date%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								意见提出者：
							</td>
							<td class="u2" width="75%" colspan="3">
								<a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>"><%=user_name%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								意见内容：
							</td>
							<td class="u2" width="75%" colspan="3">
								<%=content%>
							</td>
						</tr>
	</table>
	<%
		if(backList!=null){
			for(int j=0;j<backList.size();j++){
				HashMap backMap = (HashMap)backList.get(j);
				String back_title = "",back_content = "",back_date = "";
				if(backMap.get("title")!=null){
			  	back_title = backMap.get("title").toString();
			  }
			  if(backMap.get("in_date")!=null){
			  	back_date = backMap.get("in_date").toString();
			  }
			  if(backMap.get("content")!=null){
			  	back_content = backMap.get("content").toString();
			  }
		
	%>
	<table width=800 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
								<td height="20">
								</td>
						</tr>
						<tr>
							<td class="u1" width="13%">
								回复主题：
							</td>
							<td class="u2" width="87%">
								<%=back_title%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								回复内容：
							</td>
							<td class="u2" width="35%">
								<%=back_content%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								回复时间：
							</td>
							<td class="u2" width="35%">
								<%=back_date%>
							</td>
						</tr>
						
	</table>
	<%
		}
	}
	%>
	<table>
		<form method="post" name="trustpass" id="trustpass" action="/doTradeReg.do" onsubmit="return revertFeedbackInfoformCheckout();">
			<table width="802"  border="0" align="center" cellpadding="1" cellspacing="1">
			  <tr class="u4" height="27">
				  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">
				  	&nbsp;&nbsp;意见回复
				  </td>
	 		</tr>
		</table>
	  <table cellspacing="1" cellpadding="3" width=800 bgcolor="#efefef" border="0" align="center">
		<tr>
				  <td class="u1">
				  	<div align="right">主题：</div>																			
				  </td>
				  <td valign="bottom" bgcolor="#FFFFFF">
				  	<input type="text" maxlength="200" size="48" name="title" id="title"/>
			      <span class="STYLE1">*</span>
			 	   </td>
		</tr>
		<tr>
				  <td class="u1"><div align="right">内容：</div>																			</td>
				  <td bgcolor="#FFFFFF"><textarea type="text" name="content" id="content" rows="5" cols="60"></textarea>
				    <span class="STYLE1">*</span>														  </td>
		</tr>
				<input name="trade_id" type="hidden" value="<%=back_trade_id%>"/>
				<input name="update_trade_id" type="hidden" value="<%=trade_id%>"/>
				<input name="cust_id" type="hidden" value="<%=cust_id%>"/>
				<input name="user_id" type="hidden" value="<%=user_id%>"/>
				<input name="root_id" type="hidden" value="<%=trade_id%>"/>
				<input name="user_name" type="hidden" value=""/>
				<input name="phone" type="hidden" value="">
				<input name="email" type="hidden" value="">
				<input name="word_type" type="hidden" value="9">
				<input name="word_status" type="hidden" value="1">
				<input name="trade_type_code" type="hidden" value="0006">
		<tr>
					<td bgcolor="white" colspan="2" align="center">
						<input class="tjan" name=submit1 type=submit value="" >
				  </td>
		</tr>
    </table>
	 </form>							
    </body>
</html>




