<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
		 request.setCharacterEncoding("gbk");
   HttpSession  logsession = request.getSession(); 
    String cust_name_001="";
    String iStart ="0";
    String meun_idx="";
    if (request.getParameter("cust_name_001") != null)
    {
        cust_name_001 = request.getParameter("cust_name_001");
    }
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
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
      int counter=0;
  Custinfo custinfo=new Custinfo();
  ArrayList custList =null;
  if(null==cust_name_001||cust_name_001.equals(""))
  {
  custList=custinfo.getCustList(Integer.valueOf(iStart).intValue(),30);
  ArrayList custList2=custinfo.getCustList();
  counter=custList2.size();
    }
  else{
  	  custList=custinfo.getCListByName("%"+cust_name_001+"%",Integer.valueOf(iStart).intValue(),30);
      ArrayList custList2=custinfo.getCListByName("%"+cust_name_001+"%");
      if(custList2!=null){
      	counter=custList2.size();	
      }
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
<title>获取会员注册信息</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style>
  .chaxun{
					background:url(/admin/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
</style>
</head>
<body>
<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>

			<form name="findForm" method="post" action="resetCustPsw.jsp" target="_self">
			<table width=100% border=0 cellpadding=0 cellspacing=0 align=center bgcolor="#FCB0B0">
				<tr>
					<td  align=left >请输入公司名称:</td>
          <td  align=center width="22%">
          	<input name="cust_name_001" type="text" maxlength="100">
          </td>
          <td width="3%" align=left>					
					</td>
					<td width="15%" align=left>
					<input id="custname" class="chaxun" type="submit"  name="comit" value="" style="cursor: hand;">
					</td>
					<td width="50%" align=left>			
					</td>
				</tr>
			</table>
		
  <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
        <tr class="u4" height="25">
          <td  align=left width="15%">客户名</td>
          <td   align=left width="22%">公司地址</td>
          <td   align=left width="15%">联系电话</td>
          <td   align=left width="15%">传真号</td>
          <td   align=left width="20%">邮件地址</td>
          <td   align=center width="10%" >查看用户</td>
        </tr>
        <%
		            if(custList != null && custList.size()>0)
		            {    int i=0;
		              	 for (Iterator it = custList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String cust_id=map.get("cust_id").toString();
						        String cust_name="";
						        String group_contact_phone="";
						        String fax_nbr="";
						        String company_address="";
						        String email="";
						        if(map.get("cust_aim") != null)
						        {
						           cust_name=map.get("cust_aim").toString();
						        }
						         if(map.get("group_contact_phone") != null)
						        {
						           group_contact_phone=map.get("group_contact_phone").toString();
						        }
						        if(map.get("company_address") != null)
						        {
						           company_address=map.get("company_address").toString();
								       if(company_address.length()>14)
									      {
									        company_address=company_address.substring(0,14)+"...";
									         company_address=company_address.replaceAll("<[^<>]+>","");
									      }
						        }
						        if(map.get("fax_nbr") != null)
						        {
						           fax_nbr=map.get("fax_nbr").toString();
						        }
						        if(map.get("email")!=null)
						        {
						         email=map.get("email").toString();
						        }
						        %>
        <tr class="u2" id="changcolor_tr<%=i%>">
          <td align=left><a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>"><%=cust_name%></a></td>
          <td align=left><%=company_address%></td>
          <td align=left><%=group_contact_phone%></td>
          <td align=left><%=fax_nbr%></td>
          <td align=left><%=email%></td>         
          <td align=center>
		  <a href=resetUserPsw.jsp?cust_id=<%=cust_id%>&menu_id=<%=top_menu_id%> >
		  <img src=/images/view.gif width=16 height=16 border=0 style="cursor: hand" alt="重置密码"></a></td>
        </tr>
        <%i++;
		 }
		 %>
        <tr class="u1">
          <td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
          <td  align="right" colspan="4"  style=" padding:2px 5px;">
		  			<a href="resetCustPsw.jsp?iStart=0&menu_id=<%=top_menu_id%>&cust_name_001=<%=cust_name_001%>">首页 </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>0){
						%>
            <a href="resetCustPsw.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>&cust_name_001=<%=cust_name_001%>">上一页</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages-1){
						%>
            <a href="resetCustPsw.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>&cust_name_001=<%=cust_name_001%>">下一页 </a>&nbsp;
            <%
							}
						%>
            <a  href="resetCustPsw.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>&cust_name_001=<%=cust_name_001%>">尾页</a></td>
			        </tr>
			      <%
					  }else{
					  %>
        <tr bgcolor="white">
          <td colspan="7" align="center"><b>无客户记录!</b></td>
        </tr>
        <%
		          }
		        	%>
      </table>
      </form>
</body>
</html>




