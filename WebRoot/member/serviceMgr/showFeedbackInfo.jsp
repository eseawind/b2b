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
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/hrJobMgr.js"></script>
  </head>
	<body>
	   <table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
		  <tr class="u4" height="27">
			  <td align="left" style="border-left:#DEEDFD 1px solid; border-right:#DEEDFD 1px solid;">&nbsp;&nbsp;�������</td>
	 	</tr>
	  </table>
	  
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
							<td class="u1" width="15%">
								������⣺
							</td>
							<td class="u2" width="35%">
								<%=title%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								������ݣ�
							</td>
							<td class="u2" width="75%" colspan="3">
								<%=content%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								����ʱ�䣺
							</td>
							<td class="u2" width="75%" colspan="3">
								<%=in_date%>
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
	<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
								<td height="20">
								</td>
						</tr>
						<tr>
							<td class="u1" width="13%">
								�ظ����⣺
							</td>
							<td class="u2" width="87%">
								<%=back_title%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								�ظ����ݣ�
							</td>
							<td class="u2" width="35%">
								<%=back_content%>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								�ظ�ʱ�䣺
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
	<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#DEEDFD">
		
					<tr>
						<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
          	 <a href="javascript:history.go(-1)">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
					</tr>
	</table>	
	
    </body>
</html>



