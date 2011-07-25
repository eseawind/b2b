<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
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
  UserInfo userObj=new UserInfo();
  ArrayList userList =userObj.getUserListByUser(Integer.valueOf(iStart).intValue());
    String news_title = "";
    int counter=userObj.getUserListByUser();
	  if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
		
		}
    if (!news_title.equals(""))
     {
			userList = userObj.getOneUser(Integer.parseInt(iStart),news_title);
	    counter = userObj.getOneUser(news_title);
		}
  
    
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
    else if(pages==currenPage)
	{
	   pageUp=currenPage-1;
	   pageDown=currenPage;
	}
%>
<html>
<head>
<title>��Ա����ֵ�޸�</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/inc/linkMenuInclude.jsp">
<jsp:param name="menu_id" value="fBx626AK587h2t1lX536" />
</jsp:include>
<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
%>
	<script language="javascript">
			function search(){
						if(document.getElementById('news_title').value==''){
								alert('�������Ա�˺ţ�');
								return false;
						}else{ 
						document.searchForm.submit();
					}
				}
					</script>
<form action="updataWealthList.jsp" method="post" name="searchForm">
			
<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
	     		<tr bgcolor="white">
					<td align="left" colspan="6">
					<font size="2"><b>	�������Ա�˺�:</b></font>
						<input type="text" name="news_title" id="news_title" size="30">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
						
					</td>
				</from>
        <tr class="u4" height="25">
        	<td  align=left width="5%">��Ա�˺�</td>
          <td  align=left width="10%">����Ա����</td>
          <td  align=left width="25%">��˾����</td>
          <td   align=left width="15%">��˾�绰</td>
          <td   align=left width="10%">����ֵ</td>          
          <td   align=center width="10%" >�޸�</td>
         
        </tr>
        <%
		            if(userList != null && userList.size()>0)
		            {    int i=0;
		              	 for (Iterator it = userList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String user_id=map.get("user_id").toString();
						        String group_contact_phone="";
						        String user_name="";
						        String cust_name="";
						        String cust_aim = "";
						        String company_address="";
						        String property_value="";
						        String cust_idx=map.get("cust_id").toString();
						        
						         if(map.get("company_address") != null)
						        {
						           company_address=map.get("company_address").toString();
						        }
						        if(map.get("cust_name") != null)
						        {
						           cust_name=map.get("cust_name").toString();
						        }
						        if(map.get("cust_aim") != null)
						        {
						           cust_aim=map.get("cust_aim").toString();
						        }
						        
						         if(map.get("property_value") != null)
						        {
						           property_value=map.get("property_value").toString();
						        }
						        
						         if(map.get("group_contact_phone") != null)
						        {
						           group_contact_phone=map.get("group_contact_phone").toString();
						        }
						         if(map.get("user_name") != null)
						        {
						           user_name=map.get("user_name").toString();
						        }
						        
						        
						        
						        
						        %>
        <tr class="u2" id="changcolor_tr<%=i%>">
        	<td align=left><%=user_name%></td>
          <td align=left><%=cust_name%></td>
          <td align=left><a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_idx%>"><%=cust_aim%></a></td>
          <td align=left><%=group_contact_phone%></td>
          
          <td align=left><%=property_value%></td>
             <td align=center>
		  <a href=updataEditWealth.jsp?user_id=<%=user_id%> >
		  <img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="��Ա����ֵ�޸�"></a></td>
         
        </tr>
        <%i++;
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">��<%=counter%>�� &nbsp;��<%=Integer.parseInt(iStart)+1 %>ҳ&nbsp;&nbsp;��<%=pages%>ҳ</td>
          <td  align="right" colspan="3"  style=" padding:2px 5px;">
		  			<a href="updataWealth.jsp?iStart=0&menu_id=<%=top_menu_id%>&news_title=<%=news_title%>">��ҳ </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>0){
						%>
            <a href="updataWealth.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>&news_title=<%=news_title%>">��һҳ</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages-1){
						%>
            <a href="updataWealth.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>&news_title=<%=news_title%>">��һҳ </a>&nbsp;
            <%
							}
						%>
            <a  href="updataWealth.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>&news_title=<%=news_title%>">βҳ</a></td>
			        </tr>
			      <%
					  }else{
					  %>
        <tr bgcolor="white">
          <td colspan="7" align="center"><b>�޼�¼!</b></td>
        </tr>
        <%
		          }
		        	%>
      </table>
</body>
</html>



