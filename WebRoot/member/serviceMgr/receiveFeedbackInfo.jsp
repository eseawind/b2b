<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page contentType="text/html;charset=GBK"%>

<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%String cust_id="",cust_name="";
   HttpSession  logsessionres = request.getSession(); 
   if (logsessionres.getAttribute("SESSION_CUST_ID") != null)
     {
        cust_id = logsessionres.getAttribute("SESSION_CUST_ID").toString();   
        ArrayList list=new ArrayList();
        list=new Custinfo().getCustInfo(cust_id);   
        if(list!=null&&list.size()>0){
        HashMap map1=(HashMap)list.get(0);
        if(map1.get("cust_name")!=null)
        {
        cust_name=map1.get("cust_name").toString();
        }
     }
     }
   HttpSession  logsession = request.getSession(); 
    String iStart ="0";
    String user_id="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if( logsession.getAttribute("SESSION_USER_ID")!= null)
    {
       user_id= logsession.getAttribute("SESSION_USER_ID").toString();
    }
  LeavewordsInfo leavewords = new LeavewordsInfo();
  ArrayList leaveList = leavewords.getLeavelListBySend( Integer.valueOf(iStart).intValue(), cust_id );
  
  ParamethodMgr paramObj = new ParamethodMgr();
  
  int counter = leavewords.getLeaveNumberBySend( cust_id );
  int pages = counter/30+1;
	int pageUp = 0,pageDown = 0;
	int currenPage = Integer.valueOf( iStart ).intValue();
	if( pages > currenPage )
	{
	   if( currenPage > 0 )
	   {
				pageUp = currenPage - 1;
	   }
		pageDown = currenPage+1;
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
<script language="javascript" src="/js/serviceMgr.js"></script>
<script language="javascript">

</script>

</head>
<body onload="javascript:fresh()">
	<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="<%=top_menu_id%>" />
			</jsp:include>
		     <table width=800 border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
		        <tr class="u4" height="25">
		        	<td align=center width="20%">状态</td>
		        	<td align=center width="35%">标题</td>
			        <td align=center width="20%">用户名</td>
							<td align=center width="25%">时间</td>
							
		        </tr>
		        <%
		            if(leaveList != null && leaveList.size()>0)
		            {    
		            	int i=0;
              	  for (Iterator it = leaveList.iterator(); it.hasNext();)
                  {
							        HashMap map = (HashMap) it.next();
							        String trade_id=map.get("trade_id").toString();
							        String user_name="";
							        String word_status="",word_status_value="";
							        String in_date = "";
							        String title="";
							        
							        if( map.get( "user_name" ) != null )
							        {
							           user_name = map.get( "user_name" ).toString();
							        }
							        if( map.get( "title" ) != null )
							        {
							           title = map.get( "title" ).toString();
							        }
							        if( map.get( "user_id" ) != null )
							        {
							           UserInfo user = new UserInfo();
							           ArrayList listname = user.getcomNamebyId(map.get( "user_id" ).toString());
		    						      if(listname != null && listname.size()>0){
							            	HashMap map1 = (HashMap)listname.get(0);
							            	user_name = map1.get("cust_name").toString();
							            }
							        }
							        if( map.get( "word_status" ) != null )
							        {
							           word_status_value = map.get( "word_status" ).toString();
							           word_status = bean.getParamNameByValue( "104", word_status_value );
							        }
							        if( map.get( "in_date" ) != null )
							        {
							          in_date =  map.get( "in_date" ).toString();
									      if( in_date.length() > 10 )
									      {
									        in_date = in_date.substring( 0, 10 );
									      }
							        }
							         
							   %>
						        
						          <tr class="u2">
						          	<td align=center><%=word_status%></td>
						          	<td align=left><a href="viewFeedbackInfo.jsp?trade_id=<%=trade_id%>&title=<%=title%>"><%=title%></a></td>
					              <td align=center><%=user_name%></td>
					              <td align=center><%=in_date%></td>
					              
					              <!--td   style=" color:#000000;" align=center><a href=/doTradeReg.do?user_state=2&user_id=<%=user_id%>&trade_type_code=0285 target="_self"  onClick="return chechIfo()"><img src=/img/del.gif width=16 height=16 border=0></a></td-->
					            </tr>
						        
						        <%i++;
					     }
					     %>
				         <tr class="u1">
										<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td  align="right" colspan="3"  style=" padding:2px 5px;">
										<a href="receiveFeedbackInfo.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="receiveFeedbackInfo.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="receiveFeedbackInfo.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="receiveFeedbackInfo.jsp?iStart=<%=pages-1%>">尾页</a></td>
							    </tr>
					     
					     <%
		            }else{
						%>
						<tr align=center ><td colspan="4">暂无记录!</td></tr>
						<%}%>
		    </table>

</body>
</html>



