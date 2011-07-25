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
<title>www.21oil.com</title>
<link href="/style/layout1.css" rel="stylesheet" type="text/css">
</head>
<script language="javascript">
				
				function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
				
				function delAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								if(document.getElementById('re_news'+i).checked==true){
									document.getElementById('re_news'+i).checked = false;	
								}else{
									document.getElementById('re_news'+i).checked = true;		
								}
						}
				}
				function reloadNews(){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('user_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else{
							document.deleteFrom.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value="6905";
							document.deleteFrom.submit();
						}
				}
				
		</script>
<body>
		<form action="" method="post" name="deleteFrom">
<jsp:include page="/inc/linkMenuInclude.jsp">
<jsp:param name="menu_id" value="fBx626AK587h2t1lX536" />
</jsp:include>
<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addUserIndex.jsp">添加新员工</a>
				</td>
			</tr>
		</table>
<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
	     <tr class="u4" height="25">
          <td  align=left width="15%">登陆账号</td>
          <td   align=left width="10%">性别</td>
          <td   align=left width="15%">电话</td>
          <td   align=left width="15%">真实姓名</td>
          <td   align=left width="20%">地址</td>
          <td   align=center width="10%" >修改</td>
          <!--td   align=center width="10%" >删除</td-->
          <td width="15%" align="center">
						<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
						<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
						<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
				</td>
        </tr>
        <%
		            if(userList != null && userList.size()>0)
		            {    int i=0;
		            		 int size = userList.size();
		              	 for (Iterator it = userList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String user_id=map.get("user_id").toString();
						        String user_name="";
						        String sex="";
						        String phone="";
						        String home_addr="";
						        String birthday="";
						        String cust_name = "";
						        String cust_idx=map.get("cust_id").toString();
						        if(map.get("user_name") != null)
						        {
						           user_name=map.get("user_name").toString();
						        }
						        if(map.get("cust_name") != null)
						        {
						           cust_name=map.get("cust_name").toString();
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
          <td align=left><a href="modify.jsp?user_id=<%=user_id%>"><%=user_name%></a></td>
          <td align=left><%=sex%></td>
          <td align=left><%=phone%></td>
          <td align=left><%=cust_name%></td>
          <td align=left><%=home_addr%></td>
          <td align=center>
		  <a href=modifyLianInfo.jsp?cust_id=<%=cust_idx%>&user_id=<%=user_id%> >
		  <img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="修改用户详细信息"></a></td>
          <td align=center>
          	<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=user_id%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
		  <!--a href="/doTradeReg.do?trade_type_code=6900&user_id=<%=user_id%>&user_state=2" target="_self">
		  <img src="/images/del.gif" border="0" title="点击将注销该员工"> </a--></td>
        </tr>
        <%i++;
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
          <td  align="right" colspan="4"  style=" padding:2px 5px;">
		  			<a href="modifyUserIndex.jsp?iStart=0&menu_id=<%=top_menu_id%>">首页 </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>0){
						%>
            <a href="modifyUserIndex.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>">上一页</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages-1){
						%>
            <a href="modifyUserIndex.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>">下一页 </a>&nbsp;
            <%
							}
						%>
            <a  href="modifyUserIndex.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>">尾页</a></td>
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
		    <input type="hidden" value="" id="user_id" name="user_id">
		    <input type="hidden" value="" id="trade_type_code" name="trade_type_code">
		    <input type="hidden" value="2" id="user_state" name="user_state">
      </table>
    </form>
</body>
</html>




