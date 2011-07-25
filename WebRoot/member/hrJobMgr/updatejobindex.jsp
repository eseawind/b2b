<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    String meun_idx="";
    if ( request.getParameter( "iStart" ) != null)
    {
        iStart = request.getParameter( "iStart" );
    }
    if ( logsession.getAttribute( "SESSION_CUST_ID" ) != null)
    {
        cust_id = logsession.getAttribute( "SESSION_CUST_ID" ).toString();
    }
    if ( request.getParameter( "menu_id" ) != null )
    {
        meun_idx = request.getParameter( "menu_id" );
        logsession.setAttribute( "menu_id", meun_idx );
        
    }
    if( logsession.getAttribute( "menu_id" ) != null )
    {
       meun_idx=( String )logsession.getAttribute( "menu_id" );
    }
	 //out.println(cust_id);
  JobInfo jobObj = new JobInfo();
  ArrayList jobList = jobObj.gentjobByCust_id( Integer.valueOf( iStart ).intValue(), cust_id );
  //out.print( " jobList " + jobList );
  int counter = jobObj.getjobListNumber( cust_id );
  int pages = counter/20 + 1;
	int pageUp = 0,pageDown = 0;
	int currenPage  = Integer.valueOf(iStart).intValue();
	if( pages > currenPage )
	{
	   if( currenPage > 0 )
	   {
		   pageUp = currenPage-1;
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
	       <link href="/style/layout1.css" rel="stylesheet" type="text/css">
	</head>
			<body>
				<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		
			
	        	<table  width=100% border="0" cellpadding="1" cellspacing="1" align=center bgcolor="#98D9A2">
	        		<tr class="u1">
								<td align="left" class="head">
									<a href="/member/hrJobMgr/addJobIndex.jsp">新增招聘信息</a>
								</td>	
							</tr>
	            <tr class="u4" height="25">
	              <td align=left width="20%">职位标题</td>
	              <td align=left width="30%">工作地址</td>
	              <td align=left width="20%">发布日期</td>
	              <td align=center  width="10%">修改</td>
				        <td align=center width="10%">删除</td>
	            </tr>
	            <%
	              if( jobList != null && jobList.size() > 0 )
	              {
	                 for (Iterator it = jobList.iterator(); it.hasNext();)
	                 {
							HashMap map = (HashMap) it.next();
							String job_id = map.get("job_id").toString();
							String title ="";
							String req ="";
							String job_addr="";
							String publish_date="";
							if(map.get("title") != null)
							{
							    title=map.get("title").toString();
							}
							 
							if(map.get("job_addr") != null)
							{ 
							   job_addr=map.get("job_addr").toString();
							}
				  
							if (map.get("publish_date") != null)
							{
								publish_date = map.get("publish_date").toString();
								if ( publish_date.length() > 10 ) 
								{
									publish_date = publish_date.substring(0, 10);
								}
							}
				
	             %>
	            <tr class="u2">
	              <td align=left>
	              	<a href="viewjobinfo.jsp?job_id=<%=job_id%>" title=<%=title%> target="_self"><%=title%></a>
	            </td>
	            
	              <td align=left><%=job_addr%></td>
	               <td align=left><%=publish_date%></td>
	              <td align=center><a href=modifyjobInfo.jsp?job_id=<%=job_id%> TARGET="_self"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改信息"></a></td>
				   			<td align=center><a href=/doTradeReg.do?job_id=<%=job_id%>&trade_type_code=0388&info_id=<%=job_id%> target="_self"><img src=/images/del.gif width=16 height=16 border=0 alt="删除信息"></a></td>
	            </tr>
	            <%}
	            }else{
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
						<%}%>
				   <tr class="u3">
			          <td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;
							   第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
						
							  <td align="right" colspan="3"  style=" padding:2px 5px;">
							  <a href="updatejobindex.jsp?iStart=0&menu_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;
							  <% 
							    if(Integer.parseInt(iStart)>0){
							  %>
							   <a href="updatejobindex.jsp?iStart=<%=pageUp%>&menu_id=<%=meun_idx%>">上一页</a> &nbsp;
							  <%
							  }
							  if(Integer.parseInt(iStart)<pages-1){
							  %>
							  <a href="updatejobindex.jsp?iStart=<%=pageDown%>&menu_id=<%=meun_idx%>">下一页 </a>&nbsp; 
							  <%
							  }
							 %>
							<a  href="updatejobindex.jsp?iStart=<%=pages-1%>&menu_id=<%=meun_idx%>">尾页</a>
							</td>

 </tr>
     </table>
</body>
</html>




