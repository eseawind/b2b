<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.enquirytrackMgr.EnquirytrackInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    String user_id="";
    if ( request.getParameter("iStart") != null )
    {
        iStart = request.getParameter("iStart");
    }
    if ( logsession.getAttribute("SESSION_CUST_ID") != null )
    {
        cust_id = logsession.getAttribute( "SESSION_CUST_ID" ).toString();
    }
     
    if( logsession.getAttribute( "SESSION_USER_ID" ) != null )
    {
       user_id = logsession.getAttribute( "SESSION_USER_ID" ).toString();
    }
    // out.print( user_id );
	  EnquirytrackInfo enquirytrack = new EnquirytrackInfo();
	  ArrayList trackList = enquirytrack.getStockListByUser( Integer.valueOf(iStart).intValue(), user_id );
	  //out.print( trackList );
	  ArrayList List = new ArrayList();
	  ParamethodMgr paramObj = new ParamethodMgr();
	  
	  int counter = enquirytrack.getStockNumberByUser( user_id );
	  int pages = counter/30 + 1;
		int pageUp = 0,pageDown = 0;
		int currenPage = Integer.valueOf( iStart ).intValue();
		if( pages > currenPage )
		{
		   if( currenPage > 0 )
		   {
					pageUp = currenPage - 1;
		   }
			pageDown = currenPage + 1;
		}
	  else if( pages == currenPage )
		{
		   pageUp = currenPage - 1;
		   pageDown = currenPage;
		}
	%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>

<link href="/style/layout.css" rel="stylesheet" type="text/css">

</head>
<body>
	<table width=100% border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="13"></td>
	  </tr>
	  <tr>
	   <td>
		  <table width="560" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#dddddd">
        <tr>
        	<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="35%">标题</td>
        	<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="25%">客户</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="20%">时间</td>
        	<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="20%">状态</td>
        </tr>
		        <%
		            if( trackList != null && trackList.size()>0)
		            {    
		            	int i=0;
			          	for (Iterator it = trackList.iterator(); it.hasNext();)
			            {
					        HashMap map = (HashMap) it.next();
					        String trade_id = map.get("trade_id").toString();
					        String stack_id = map.get( "stack_id" ).toString();
					        String user_name="";
					        user_id = "";
					        String deal_status="",deal_tag="";
					        String enquiry_date = "";
					        String title="";
					        
					        if( map.get( "user_id" ) != null )
					        {
					            user_id = map.get( "user_id" ).toString();
					            UserInfo userInfo = new UserInfo();
											ArrayList list = new ArrayList(); 
											HashMap map1 = new HashMap();
											list = userInfo.genOneUserInfo( user_id );
											if (list != null && list.size() > 0)
											{
												  map1 = (HashMap) list.get(0);
												  user_name = map1.get("user_name").toString();
											}
					        }
					        
									if ( map.get("title") != null )
									{
										title = map.get("title").toString();
									}
										 
					        if( map.get( "deal_tag" ) != null )
					        {
					           deal_tag = map.get( "deal_tag" ).toString();
					           deal_status = bean.getParamNameByValue( "40", deal_tag );
					        }
					        if( map.get( "enquiry_date" ) != null )
					        {
					          enquiry_date =  map.get( "enquiry_date" ).toString();
							      if( enquiry_date.length() > 10 )
							      {
							        enquiry_date = enquiry_date.substring( 0, 10 );
							      }
					        }
							         
							   %>
						        
				          <tr style="background-color:#f9f9f9;">
				          	<td   style=" color:#000000; padding: 2px 5px;" align=left>
				          		<a href="viewEnquiryInfo.jsp?trade_id=<%=trade_id%>"><%=title%></a>
				          	</td>
			              <td   style=" color:#000000;" align=center><%=user_name%></td>
			              <td   style=" color:#000000;" align=center><%=enquiry_date%></td>
			              <td   style=" color:#000000;" align=center><%=deal_status%></td>
			            </tr>
				        
				        <%i++;
					     }
					     %>
									<tr>					  
										<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td  align="right" colspan="3"  style=" padding:2px 5px;">
										<a href="entirePriceList.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="entirePriceList.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="entirePriceList.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="entirePriceList.jsp?iStart=<%=pages-1%>">尾页</a></td>
							    </tr>
					     <%
		            }
		        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13"></td>
	  </tr>
	</table>
	<script language="javascript">
			window.opener.document.location.reload()
</script>
</body>
</html>



