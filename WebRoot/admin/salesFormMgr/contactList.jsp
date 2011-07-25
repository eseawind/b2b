<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>

<%@ page import="com.saas.biz.relationUuMgr.RelationUUInfo"%>

<%@ page contentType="text/html;charset=GBK"%>

<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../ext/ext-all.js"></script>
<script type="text/javascript">
function sumbimtData(){
    if(document.getElementById("contact_man").value==""){
      Ext.MessageBox.alert("bizoss 提示","请选择一个联系人!");
      return false;
    }else{
	window.opener.resumeForm.contact_man.value=document.getElementById("contact_man").value;
	window.open('','_top');
    window.top.close();
	return false;
	}
  }
  function setCustomer(cust){
    document.getElementById("contact_man").value=cust;
  }
</script>
</head>
<body>
<%
   HttpSession  logsession = request.getSession(); 
    String user_id = "";
    String iStart ="0";
    String meun_idx="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        meun_idx = request.getParameter("menu_id");
    }
   RelationUUInfo relation=new RelationUUInfo();
   ArrayList relationList =new ArrayList();
   relationList=relation.getContactList(Integer.parseInt(iStart),user_id,"1");
    int counter=relation.getContactSum(user_id,"1");
    int pages=counter/30+1;
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

	<table width="750" border="0" cellspacing="0" cellpadding="0" align="center">

	  <tr>

	    <td height="13" align="left">

	    </td>

	  </tr>

	  <tr>

	    <td>

		     <table width=100% border=0 cellpadding=2 cellspacing=1 align=center  bgcolor="#e7e7e7">

		        <tr>

			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="20%">联系人</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="10%">性别</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">联系电话</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">电子邮件</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="40%" >地址</td>

		        </tr>

		        <%

		            if(relationList != null && relationList.size()>0)
		            {    
		              	 for (int i=0;i<relationList.size();i++)
		                  {
						        HashMap map = (HashMap) relationList.get(i);
						        String cust_name="";
						        String sex="";
						        String contact_phone="";
						        String email="";
						        String home_addr="";
						        String cust_id="";
						        String user="";
						        if(map.get("cust_id") != null)
						        {
						           cust_id=map.get("cust_id").toString();
						        }
						        if(map.get("user_id") != null)
						        {
						           user=map.get("user_id").toString();
						        }
						        if(map.get("cust_name") != null)
						        {
						           cust_name=map.get("cust_name").toString();
						        }
						        if(map.get("sex") != null)
						        {
						           sex=map.get("sex").toString();
						           if(sex=="0" || sex.equals("0")){
						             sex="男";
						           }else{
						             sex="女";
						           }
						        }
						        if(map.get("phone") != null)
						        {
						           contact_phone=map.get("phone").toString();
						        }

						        if(map.get("email") != null)

						        {

						           email=map.get("email").toString();

						        }

						        if(map.get("home_addr") != null)

						        {
						           home_addr=map.get("home_addr").toString();
						        }
						          if(i%2==0){
									%>
									<tr bgcolor=#FFFFFF>
									<%
									}else{
									%>
									<tr bgcolor=#efefef>
									<%
									}
						        %>
					              <td  style=" color:#3300FF; font-size:12px; padding:2px 5px;" align=left><input type="radio" name="sel" id="sel" onclick="setCustomer('<%=cust_name%>')"><%=cust_name%></td>
					              <td  style=" color:#000000; font-size:12px; padding:2px 5px;" align=center><%=sex%></td>
					              <td  style=" color:#000000; font-size:12px; padding:2px 5px;" align=left><%=contact_phone%></td>
					              <td  style=" color:#000000; font-size:12px; padding:2px 5px;" align=left><%=email%></td>
					              <td  style=" color:#000000; font-size:12px; padding:2px 5px;" align=left><%=home_addr%></td>
					            </tr>
						        <%
					     }
					     %>
					     <tr>
							<td colspan="2"  align="left" bgcolor="#FFFFFF"style="font-weight:normal; font-size:12px; padding:2px 5px;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td colspan="3"  align="right" bgcolor="#FFFFFF" style=" font-size:12px; padding:2px 5px;"><a href="contactList.jsp?iStart=0&menu_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="contactList.jsp?iStart=<%=pageUp%>&menu_id=<%=meun_idx%>">上一页</a> &nbsp;<a href="contactList.jsp?iStart=<%=pageDown%>&menu_id=<%=meun_idx%>">下一页 </a>&nbsp; <a  href="contactList.jsp?iStart=<%=pages%>&menu_id=<%=meun_idx%>">尾页</a></td>
				         </tr>
					 <%}
		        %>
		        <tr>
		         <input type="hidden" name="contact_man" id="contact_man" value="">
		         <input type="hidden" name="menu_id" id="menu_id" value="<%=meun_idx%>">
		         <input type="hidden" name="sel_type" id="sel_type" value="0">
				 <td colspan="5"  align="center" bgcolor="#FFFFFF"><input type="submit" value="提交" onclick=" return sumbimtData();"></td>
				</tr>
	      </table>
        </td>
	  </tr>
	  <tr>
	    <td height="13"></td>
	  </tr>
	</table>
</body>
</html>





