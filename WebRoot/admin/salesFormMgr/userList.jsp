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
   
	  UserInfo userObj=new UserInfo();
	  ArrayList userList =userObj.getUserListByCust(Integer.valueOf(iStart).intValue(),cust_id,"0");
	  ParamethodMgr paramObj=new ParamethodMgr();
	  HashMap sexMap=paramObj.getCompareInfoByCode("CRM","sex");
	    int counter=userObj.getUserNumber(cust_id,"0");
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
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../ext/ext-all.js"></script>
<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link href="/style/daohang.css" rel="stylesheet" type="text/css">
<link href="/style/css.css" rel="stylesheet" type="text/css">
<link href="/style/manager.css" rel="stylesheet" type="text/css">
<style type="text/css" media="screen">
form {padding:0px; margin:0px;}
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
<script language="javascript">
 function sumbimtData(){
    if(document.getElementById("sale_user_name").value=="" || document.getElementById('sale_user_name').value ==null){
      Ext.MessageBox.alert("bizoss 提示","请选择一个销售人员!");
      return false;
    }else{
		window.opener.resumeForm.sale_user_name.value=document.getElementById("sale_user_name").value;
		window.opener.resumeForm.sale_user_id.value=document.getElementById("sale_user_id").value;
		window.open('','_top');
        window.top.close();
		return false;
	}
  }
  function setObjValue(cust_name,cust_id){
    document.getElementById("sale_user_name").value=cust_name;
    document.getElementById("sale_user_id").value=cust_id;
  }
</script>
</head>
<body>
	<table width="750" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td height="13"></td>
	  </tr>
	  <tr>
	    <td>
		     <table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">用户名</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="10%">性别</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="15%">电话</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="15%">出生日期</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  align=center width="35%">地址</td>
		        </tr>
		        <%
		            if(userList != null && userList.size()>0)
		            {    
		              	 for (int i=0;i<userList.size();i++)
		                  {
						        HashMap map = (HashMap) userList.get(i);
						        String user_id=map.get("user_id").toString();
						        String user_name="";
						        String sex="";
						        String phone="";
						        String home_addr="";
						        String birthday="";
						        String cust_idx=map.get("cust_id").toString();
						        if(map.get("user_name") != null)
						        {
						           user_name=map.get("user_name").toString();
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
					              <td  style=" color:#000000; padding:2px 5px;" align=left><input type="radio" name="sel" id="sel" onclick="setObjValue('<%=user_name%>','<%=user_id%>')"><%=user_name%></td>
					              <td  style=" color:#000000; padding:2px 5px;" align=center><%=sex%></td>
					              <td  style=" color:#000000; padding:2px 5px;" align=left><%=phone%></td>
					              <td  style=" color:#000000; padding:2px 5px;" align=center><%=birthday%></td>
					              <td  style=" color:#000000; padding:2px 5px;" align=left><%=home_addr%></td>
					            </tr>
						        <%
					     }
					     %>
					     
					     <tr>
							<td  align="left" colspan="2" style=" padding:2px 5px;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td  align="right" colspan="3" style=" padding:2px 5px;"><a href="userList.jsp?iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="userList.jsp?iStart=<%=pageUp%>&meun_id=<%=meun_idx%>">上一页</a> &nbsp;<a href="userList.jsp?iStart=<%=pageDown%>&meun_id=<%=meun_idx%>">下一页 </a>&nbsp; <a  href="userList.jsp?iStart=<%=pages%>&meun_id=<%=meun_idx%>">尾页</a></td>
				         </tr>
					     
					     <%
		            }
		        %>
		        <tr bgcolor=#FFFFFF>
					<input type="hidden" name="sale_user_id" id="sale_user_id" value="">
					<input type="hidden" name="sale_user_name" id="sale_user_name" value="">
					<td align="center" colspan="5">
						<input type="button" value="确定" onclick=" return sumbimtData();">
					</td>
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



