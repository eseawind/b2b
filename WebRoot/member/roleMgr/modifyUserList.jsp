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
    ArrayList userList =userObj.getUserListByCust(Integer.valueOf(iStart).intValue(),cust_id,"0");
    ParamethodMgr paramObj=new ParamethodMgr();
    HashMap sexMap=paramObj.getCompareInfoByCode("CRM","sex");
    
	int counter=userObj.getUserNumber(cust_id,"0");
    int pages = counter/30 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
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
	   pageUp=currenPage-1;
	   pageDown=currenPage;
	}
%>
<html>
<head>
<title>员工列表</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function showOpenValue(val){
		var user_id = document.getElementById('user_id'+val).value;
		var user_name = document.getElementById('user_name'+val).value;
		window.opener.resumeForm.user_name.value = user_name;
		window.opener.resumeForm.user_id.value = user_id;
		window.open('','_self','');
		window.close();
	}	
</script>
</head>
<body>
<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
        <tr class="u4" height="25">
        	<td  align=left width="5%">选择</td>
          <td  align=left width="15%">员工</td>
          <td   align=center width="10%">性别</td>
          <td   align=center width="15%">电话</td>
          <td   align=center width="15%">出生日期</td>
          <td   align=center width="25%">地址</td>
        </tr>
        <%
        				int size = 0;
		            if(userList != null && userList.size()>0)
		            {    int i=0;
		            		 size = userList.size();
		              	 for (Iterator it = userList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String user_id=map.get("user_id").toString();
						        String user_name="";
						        String sex="";
						        String phone="";
						        String home_addr="";
						        String birthday="";
						        String cust_idx=map.get("cust_id").toString();
						        if(map.get("cust_name") != null)
						        {
						           user_name=map.get("cust_name").toString();
						        }
						         if(map.get("phone") != null)
						        {
						           phone=map.get("phone").toString();
						        }
						        if(map.get("sex") != null)
						        {
						           sex=map.get("sex").toString();
						           if(sexMap.get(sex)!=null)
						           {
						               sex=sexMap.get(sex).toString();
						           }
						        }
						        if(map.get("home_addr") != null)
						        {
						           home_addr=map.get("home_addr").toString();
						           home_addr=home_addr.replaceAll("<[^<>]+>","");
							      if(home_addr.length()>16)
							      {
							        home_addr=home_addr.substring(0,16)+"...";
							      }
						        }
						        if(map.get("birthday") != null)
						        {
						           birthday=map.get("birthday").toString();
						           if(birthday.length()>10)
						           {
						             birthday=birthday.substring(0,10);
						           }
						        }
						        %>
        <tr class="u2" id="changcolor_tr<%=i%>">
        	<td  align=left width="5%"><input type="radio" name="user_id<%=i%>" id="user_id<%=i%>" value="<%=user_id%>" onclick="showOpenValue('<%=i%>')"></td>
        	<input type="hidden" name="user_name<%=i%>" id="user_name<%=i%>" value="<%=user_name%>">
        	<input type="hidden" name="size" id="size" value="<%=size%>">
          <td align=left><a href="/member/memberMgr/modify.jsp?user_id=<%=user_id%>"><%=user_name%></a></td>
          <td align=center><%=sex%></td>
          <td align=left><%=phone%></td>
          <td align=center><%=birthday%></td>
          <td align=left><%=home_addr%></td>
        </tr>
        <%i++;
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">
		  共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
          <td  align="right" colspan="4"  style=" padding:2px 5px;">
		  <a href="modifyUserList.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
            <% 
				if(Integer.parseInt(iStart)>0){
			%>
            <a href="modifyUserList.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
            <%
				}
				if(Integer.parseInt(iStart)<pages-1){
			%>
            <a href="modifyUserList.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp;
            <%
				}
			%>
            <a  href="modifyUserList.jsp?iStart=<%=pages-1%>">尾页</a></td>
        </tr>
        <%
		  }else{
		  %>
        <tr bgcolor="white">
          <td colspan="7" align="center"><b>无员工记录!</b></td>
        </tr>
        <%
		          }
		        	%>
      </table>
</body>
</html>



