<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.indexLinkMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    String meun_idx="";
    String contentKey="";
    if(request.getParameter("content_Key")!=null)
	{
	   contentKey=new String(request.getParameter("content_Key")); 
	}
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
     ParamethodMgr comparList=new ParamethodMgr();
     HashMap custMap=comparList.getCompareInfoByCode("CRM","cust_type");
     HashMap stateMap=comparList.getCompareInfoByCode("CRM","cust_state");
	 /*****************************************/
     Custinfo custObj=new Custinfo();
	 ArrayList resuleList=custObj.getCustListBySearch(Integer.valueOf(iStart).intValue(),contentKey);
	 int counter=custObj.getCustSearch(contentKey);
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
		<meta name = "Generator" content = "Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B电子商务后台管理系统</title>

	</head>
<body>  
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="13">&nbsp;</td>
	  </tr>
	  <tr>
	    <td>
		     <table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        	<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="30%">客户名称</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">客户级别</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">当前状态</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="15%" >联系电话</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="30%" >地址</td>
		        </tr>
		        <%
					if(resuleList != null  && resuleList.size()>0)
					{
						int i=0;
						for (Iterator inIt = resuleList.iterator(); inIt.hasNext();)
					    {
						    HashMap map = (HashMap) inIt.next();
						   	String cust_name=map.get("cust_name").toString();
							String cust_type=map.get("cust_type").toString();
							String cust_state=map.get("cust_state").toString();
							String group_contact_phone="";
							String company_address="";
							if(custMap.get(cust_type)!=null)
							{
							   cust_type=custMap.get(cust_type).toString();
							}
							if(stateMap.get(cust_state)!=null)
							{
							   cust_state=stateMap.get(cust_state).toString();
							}
						    if(map.get("group_contact_phone") !=null)
							{
							  group_contact_phone=map.get("group_contact_phone").toString();
							}
							if(map.get("company_address") !=null)
							{
							  company_address=map.get("company_address").toString();
							}
							%>
							<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
			        				<td style=" color:#000000;" align="left"><%=cust_name%></td>
								<td style=" color:#000000;" align="center" ><%=cust_type%></td>
								<td style=" color:#000000;" align="center" ><%=cust_state%></td>
								<td style=" color:#000000;" align="left" ><%=group_contact_phone%></td>
								<td style=" color:#000000;" align="center" ><%=company_address%></td>
					        </tr>
							<%i++;
						}
						%>
						<tr >
							<td  align="left" style=" color:#000000;" colspan="2" width="50%">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td  align="right" style=" color:#000000;"  colspan="4" width="50%"><a href="searchIndex.jsp?content=<%=contentKey%>&iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="searchIndex.jsp?content=<%=contentKey%>&iStart=<%=pageUp%>&meun_id=<%=meun_idx%>">上一页</a> &nbsp;<a href="searchIndex.jsp?content=<%=contentKey%>&iStart=<%=pageDown%>&meun_id=<%=meun_idx%>">下一页 </a>&nbsp; <a  href="searchIndex.jsp?content=<%=contentKey%>&iStart=<%=pages%>&meun_id=<%=meun_idx%>">尾页</a></td>
				         </tr>
						<%
					}
		        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="46">&nbsp;</td>
	  </tr>
	</table>
</body>
</html>



