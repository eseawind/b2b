<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.custlinkMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
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
      ParamethodMgr comparList=new ParamethodMgr();
	 HashMap compMap=comparList.getCompareInfoByCode("CRM","link_type");
	 /*****************************************/
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
		<script language="javascript" src="/js/friendlyMgr.js"></script>
        <style type="text/css">
		form {padding:0px; margin:0px;}
         .line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
         .line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
         .line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
         .line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
         </style>
	</head>
<body>  
	<table width="727" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="13">&nbsp;</td>
	  </tr>
	  <tr>
	    <td>
		     <table width="727" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">链接类型</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="25%">链接名称</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="40%">描述</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="10%" >修改</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="10%" >删除</td>
		        </tr>
		        <%
					if(linkArray != null  && linkArray.size()>0)
					{
						int i=0;
						for (Iterator inIt = linkArray.iterator(); inIt.hasNext();)
					    {
						    HashMap map = (HashMap) inIt.next();
						   	String linkName=map.get("link_name").toString();
							String linkIdx= map.get("link_no").toString();
							String linkType="";
							if(map.get("link_type") != null)
							{
							   linkType=map.get("link_type").toString();
							   if(compMap.get(linkType) !=null)
							   {
							     linkType=compMap.get(linkType).toString();
							   }
							}
							String linkDesc="";
							if(map.get("rsrv_str3") != null)
							{
							    linkDesc=map.get("rsrv_str3").toString();
							    if(linkDesc !=null || !linkDesc.equals(""))
							    linkDesc=linkDesc.replaceAll("<[^<>]+>","");
							    if(linkDesc.length()>30)
							    { 
							      linkDesc=linkDesc.substring(0,30);
							    }
							}
							%>
							<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
		        			<td  style=" color:#000000;" align="center"><%=linkType%></td>
									<td  style=" color:#000000;" align="left" ><%=linkName%></td>
									<td  style=" color:#000000;" align="left" ><%=linkDesc%></td>
							 		<td  style=" color:#000000;" align=center><a href=modifyLinkInfo.jsp?link_no=<%=linkIdx%>  TARGET=appwin onclick="mydefss()"><img src=/img/edit.gif width=16 height=16 border=0></a></td>
							 		<td  style=" color:#000000;" align=center><a href=/doTradeReg.do?cust_id=<%=cust_id%>&link_no=<%=linkIdx%>&trade_type_code=0299 target="_self"  onClick="return deleteLinkListchechIfo()"><img src=/img/del.gif width=16 height=16 border=0></a></td>
					    </tr>
							<%i++;
						}
						%>
						<tr>
							<td  align="left" colspan="2" class="line1" style="font-weight:normal;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td  align="left"><a href="deleteIndex.jsp?iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="deleteIndex.jsp?iStart=<%=pageUp%>&meun_id=<%=meun_idx%>">上一页</a> &nbsp;<a href="deleteIndex.jsp?iStart=<%=pageDown%>&meun_id=<%=meun_idx%>">下一页 </a>&nbsp; <a  href="deleteIndex.jsp?iStart=<%=pages%>&meun_id=<%=meun_idx%>">尾页</a></td>
				         </tr>
						<%
					}
		        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13">&nbsp;</td>
	  </tr>
	</table>
</body>
</html>


