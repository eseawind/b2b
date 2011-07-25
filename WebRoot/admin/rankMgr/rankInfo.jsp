<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.custMgr.Custinfo" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>

<%
    String iStart ="0";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
	ParamethodMgr comparList=new ParamethodMgr();
	 HashMap compMap=comparList.getCompareInfoByCode("CRM","cust_type");
    Custinfo	  custEntity=new Custinfo();
    ArrayList custArray = custEntity.getCustListByAll(Integer.valueOf(iStart).intValue());
    int counter=custEntity.getCustListNumber();
    int pages=counter/30;
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
		<meta name = "Generator" content = "Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B电子商务后台管理系统</title>
		
	</head>


<body>  
<h1>级别管理</h1>
<div class="line6">
                         <div class="img"><img src="/admin/images/icon3_manager_rightbody.gif" /></div><span class="title">您可以将以下客户的级别进行设置</span><br />
                                             1、客户的级别代表一个客户在本系统中的身份。<br />
                                             2、客户的级别与客户所享受的待遇成正比。                          
                                                                       </div>
<table width="100%" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7">
  <tr>  
 
    <td class="line1" style=" background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">客户名称</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="13%">级别</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="7%">状态</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="35%">地址</td>
    <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="10%">修改级别</td>
  </tr>
<%
	if(custArray != null  && custArray.size()>0)
	{
	            int i=0;
		for (Iterator inIt = custArray.iterator(); inIt.hasNext();)
	    {
		    HashMap map = (HashMap) inIt.next();
		    String cust_id="";
		    String cust_name="";
		    String cust_type="";
		    String cust_state="正常";
		    String cust_addr="";
	   	    cust_id=map.get("cust_id").toString();
	   	    cust_name=map.get("cust_name").toString();
	   	    if(map.get("cust_type")!=null)
	   	    {
	   	      cust_type=map.get("cust_type").toString();
	   	    }
	   	    if(map.get("company_address")!=null)
	   	    {
	   	      cust_addr=map.get("company_address").toString();
	   	    }
   %>
	<tr  style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
	     <td style=" color:#000000;" align="left"><%=cust_name%></td>
	     <td style=" color:#000000;" align="center"><%=compMap.get(cust_type)%></td>
	     <td style=" color:#000000;" align="center"><%=cust_state%></td>
	     <td style=" color:#000000;" align="left" class="ping1"><%=cust_addr%></td>
		<td  style=" color:#000000;" align="center"><!--a href="modifyRank.jsp?cust_id=<%=cust_id%>&cust_name=<%=cust_name%>" target="_bank"-->
			<a href="javascript:void(window.open('modifyRank.jsp?cust_id=<%=cust_id%>&cust_name=<%=cust_name%>','_blank','toolbar=no,scrollbar=no,top=5,right=25,width=700,height=420'));" >
			<img src="/img/edit.gif"  width="16"  height="16" border="0"></a></td>
    </tr>
	<%
		i++;}
		%>
		<tr>
			<td  class="line1" style="font-weight:normal;" align="center" colspan="2">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
			<td  align="left" colspan="3"><a href="index.jsp?iStart=0">首页 </a>&nbsp; &nbsp;<a href="index.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;<a href="index.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; <a  href="index.jsp?iStart=<%=pages%>">尾页</a></td>
	    </tr>
		<%
	}
   %>
</table>
	<body>
</html>




