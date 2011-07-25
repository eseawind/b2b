<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
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
   
  Custinfo custObj = new Custinfo();
   
	ArrayList custList = custObj.getCustStateByUser(Integer.valueOf(iStart).intValue(),"3");
  int counter = custObj.getCustStateByUserCount("3");


 
  
    
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
<title></title>
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

<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
        
        <%
		            if(custList != null && custList.size()>0)
		            { 
		            
		     %>
		     					
		     				<tr class="u4" height="25">				          
				          <td   align=left width="15%">管理员姓名</td>
				          <td   align=left width="15%">公司名称</td>
				          <td   align=left width="15%">联系电话</td>
				          <td   align=left width="20%">电子邮箱</td>
				          <td   align=left width="10%">注册时间</td>
				          <td   align=center width="10%" >审批</td>
				        </tr>
		     <%
		              for (int i=0;i<custList.size();i++) 
		              {
		                  
						        HashMap map = (HashMap)custList.get(i);;
						        String publish_date = "";
						        String user_id = "";
						        if(map.get("publish_date") != null) {
						        	publish_date = map.get("publish_date").toString();
						        }
						        if(map.get("user_id") != null) {
						        	user_id = map.get("user_id").toString();
						        }
						        publish_date = publish_date.substring(0,10);
						         
						     
						        String cust_name="",cust_aim="",group_contact_phone="",email="",company_address="";
						        String cust_idx=map.get("cust_id").toString();
						        
						   
						        if(map.get("cust_name") != null){cust_name=map.get("cust_name").toString();}
						        if(map.get("cust_aim") != null){cust_aim=map.get("cust_aim").toString();}
						        if(map.get("group_contact_phone") != null){group_contact_phone=map.get("group_contact_phone").toString();}
						        if(map.get("email") != null){email=map.get("email").toString();}
			   %>
        <tr class="u2" id="changcolor_tr<%=i%>">
          
          <td align=left><%=cust_name%></td>
          <td align=left><a href="/member/customerMgr/companyIntroduction.jsp?obj_cust_id=<%=cust_idx%>&user_id=<%=user_id%>"><%=cust_aim%></a></td>
          <td align=left><%=group_contact_phone%></td>
          <td align=left><a href="mailto:<%=email%>"><%=email%></a></td>
          <td align=left><%=publish_date%></td>
          <td align=center>
					  <a href="viewCustinfo.jsp?cust_id=<%=cust_idx%>&user_id=<%=user_id%>">
					  	<img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="验证审批">
					  </a>
					</td>
        </tr>
        <%
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart) %>页&nbsp;&nbsp;共<%=pages%>页</td>
          <td  align="right" colspan="4"  style=" padding:2px 5px;">
		  			<a href="addverify.jsp?iStart=0&menu_id=<%=top_menu_id%>">首页 </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>1){
						%>
            <a href="addverify.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>">上一页</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages){
						%>
            <a href="addverify.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>">下一页 </a>&nbsp;
            <%
							}
						%>
            <a  href="addverify.jsp?iStart=<%=pages%>&menu_id=<%=top_menu_id%>">尾页</a></td>
			        </tr>
			      <%
					  }else{
					  %>
        <tr bgcolor="white">
          <td colspan="7" align="center"><b>无会员审批记录!</b></td>
        </tr>
        <%
		          }
		        	%>
      </table>
</body>
</html>



