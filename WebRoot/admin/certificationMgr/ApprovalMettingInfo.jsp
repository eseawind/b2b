<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.showMgr.ShowInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    String meun_idx="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        meun_idx = request.getParameter("menu_id");
        logsession.setAttribute("menu_id",meun_idx);
    }
    if( logsession.getAttribute("menu_id")!= null)
    {
       meun_idx=(String)logsession.getAttribute("menu_id");
    }
  ShowInfo infos = new ShowInfo();
  ArrayList userList = new ArrayList();
  int counter = 0;
  
  userList = infos.getMemShow(Integer.valueOf(iStart).intValue());
  counter = infos.getMemShow();
  
  int pages=(counter-1)/30+1;
	int pageUp=0,pageDown=0;
	int currenPage=Integer.valueOf(iStart).intValue();
	if(pages>currenPage)
	{
	   if(currenPage>0)
	   {
		pageUp=currenPage-1;
	   }
		pageDown=currenPage+1;
	}
  else if(pages==currenPage) {
	   pageUp=currenPage-1;
	   pageDown=currenPage;
	}
	
	
	
	
%>
<html>
<head>
<title>www.21oil.com</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
</head>
<body>


<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
        
        
		     					
		     				<tr class="u4" height="25">
				          <td  align=left width="20%">展会标题</td>
				          <td   align=left width="60%">展会内容</td>
				          <td   align=left width="10%">展会时间</td>
				          <td   align=center width="10%" >审批</td>
				        </tr>
				        
				        <%
				        String title="",content="",in_date="",show_id="";
		            if(userList != null && userList.size()>0)
		            {
		              for (int i=0;i<userList.size();i++) {
		                  HashMap map = (HashMap)userList.get(i);
		                  if(map.get("show_id") != null) {
		                  	show_id = map.get("show_id").toString();		                  	
		                  }
		                  if(map.get("title") != null) {
		                  	title = map.get("title").toString();
		                  	if(title.length()>12) {title = title.substring(0,12);}
		                  }
		                  if(map.get("content") != null) {
		                  	content = map.get("content").toString();
		                  	if(content.length()>25) {content = content.substring(0,25);}
		                  }
		                  if(map.get("in_date") != null) {
		                  	in_date = map.get("in_date").toString();
		                  	if(in_date.length()>10) {in_date = in_date.substring(0,10);}
		                  }
						        %>
        <tr class="u2" id="changcolor_tr<%=i%>">
          <td align=left><%=title%></td>
          <td align=left><%=content%></td>
          <td align=left><%=in_date%></td>
          <td align=center>
					  <a href="/doTradeReg.do?show_id=<%=show_id%>&trade_type_code=4568" target="_self">
					  	<img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="验证审批">
					  </a>
					</td>
        </tr>
        <%
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="1" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
          <td  align="right" colspan="3"  style=" padding:2px 5px;">
		  			<a href="ApprovalInfo.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>0){
						%>
            <a href="ApprovalInfo.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages-1){
						%>
            <a href="ApprovalInfo.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp;
            <%
							}
						%>
            <a  href="ApprovalInfo.jsp?iStart=<%=pages-1%>">尾页</a></td>
			        </tr>
			      <%
					  }else{
					  %>
        <tr bgcolor="white">
          <td colspan="4" align="center"><b>无会员审批记录!</b></td>
        </tr>
        <%
		          }
		        	%>
      </table>
</body>
</html>




