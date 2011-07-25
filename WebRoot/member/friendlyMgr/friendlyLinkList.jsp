<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.custlinkMgr.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
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
      ParamethodMgr comparList=new ParamethodMgr();
	  HashMap compMap=comparList.getCompareInfoByCode("CRM","link_type");
	  CustlinkInfo  linkList=new CustlinkInfo();
	  ArrayList linkArray = linkList.getCustLinkListByAll(Integer.valueOf(iStart).intValue(),cust_id);
	  int counter=linkList.getLinkNumber(cust_id);
      int pages=counter/30+1;
	 int pageUp=0,pageDown=0;
	 int currenPage=Integer.valueOf(iStart).intValue();
	if(pages>currenPage)
	{
	   if(currenPage>0)
	   {
				pageUp=currenPage-1;
				if( pageUp == 0 )
				 	pageUp = 1;
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
<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
</head>
<body>  
      
      <jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="7FFJWH57i1n8544Js5PU" />
				<jsp:param name="addLink" value="addLinkInfo.jsp" />
			</jsp:include>	
	<table width="800" border="0" cellspacing="1" cellpadding="1">
	  <tr>
	    <td>
		     <table width="800" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        <td background="/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="35%">链接名称</td>
					<td background="/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="20%">链接类型</td>
					<td background="/images/newsbg.gif" style="color:#000000;  font-weight:bold; font-size:13px;" align="center" width="45%">链接地址</td>
		        </tr>
		        <%
					if(linkArray != null  && linkArray.size()>0)
					{
						int i=0;
						for (Iterator inIt = linkArray.iterator(); inIt.hasNext();)
					    {
						    HashMap map = (HashMap) inIt.next();
						    String link_no=map.get("link_no").toString();
						   	String linkName=map.get("link_name").toString();
							String linkType="";
							if(map.get("link_type") != null)
							{
							   linkType=map.get("link_type").toString();
							   if(compMap.get(linkType) !=null)
							   {
							     linkType=compMap.get(linkType).toString();
							   }
							}
							String link_url="";
							if(map.get("link_url") != null)
							{
							  link_url=map.get("link_url").toString();
							}
							%>
							<tr style="background-color:#f9f9f9; ">
			        			<td style="color:#000000;" align="left"><a href="viewLinkInfo.jsp?link_no=<%=link_no%>"  TARGET=appwin onclick="mydefss()"><%=linkName%></a></td>
								<td style="color:#000000;" align="center"><%=linkType%></td>
								<td style=" color:#000000;" align="left"><html:link href="<%=link_url%>"><%=link_url%></html:link></td>
					        </tr>
					        <!--这里可能出错！-->
							<%i++;
						}
						%>
						<tr class="line1">
							<td background="/images/newsbg.gif"  align="left" colspan="2" >共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td background="/images/newsbg.gif"  align="right"><a href="friendlyIndex.jsp?iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="friendlyIndex.jsp?iStart=<%=pageUp%>&meun_id=<%=meun_idx%>">上一页</a> &nbsp;<a href="friendlyIndex.jsp?iStart=<%=pageDown%>&meun_id=<%=meun_idx%>">下一页 </a>&nbsp; <a  href="friendlyIndex.jsp?iStart=<%=pages%>&meun_id=<%=meun_idx%>">尾页</a></td>
				         </tr>
						<%
					}else{
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
						<%}%>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13">&nbsp;</td>
	  </tr>
	</table>
</body>
</html>


