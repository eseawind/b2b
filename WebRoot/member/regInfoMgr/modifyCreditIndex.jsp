<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.creditMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
   HttpSession  logsession = request.getSession(); 

    String iStart ="0";
    String meun_idx="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    String se_cust_id = "";
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
       se_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
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
	 HashMap compMap=comparList.getCompareInfoByCode("CRM","credit_type");
	 /*****************************************/
	 CreditInfo  creditObj=new CreditInfo();
	 ArrayList linkArray = creditObj.getCustCredit(Integer.valueOf(iStart).intValue(),se_cust_id);
	 int counter=creditObj.getCreditNumber(se_cust_id);
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
<meta name = "Generator" content = "Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
<script type="text/javascript" src="/js/regInfoMgr.js"></script>
		<script language="javascript">

		</script>
</head>
<body>  
	<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		
	<table width=100% border="0" cellspacing="0" cellpadding="0">
		<tr class="u1">
					<td class="head" align="left">
						<a href="addCreditIndex.jsp">新增资质证书</a>
					</td>
			</tr>
	  <tr>
	    <td>
		     <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
		        <tr class="uu">
					    <td align="left" width="20%">证书名称</td>
							<td align="left" width="20%">证书类型</td>
							<td align="left" width="20%">开始日期</td>
							<td align="left" width="20%">结束日期</td>
							<td align="center" width="10%">修改</td>
							<td align="center"  width="10%">删除</td>
		        </tr>
		        <%
					if(linkArray != null  && linkArray.size()>0)
					{
						int i=0;
						for (Iterator inIt = linkArray.iterator(); inIt.hasNext();)
					    {
						    HashMap map = (HashMap) inIt.next();
						    String  credit_title="";
							String credit_id= map.get("credit_id").toString();
							String credit_type="";
							
							String credit_end_date="",credit_start_date="";
							if(map.get("credit_title")!=null)
							{
							   credit_title=map.get("credit_title").toString();
							}
							if(map.get("credit_type")!= null)
							{
							    credit_type=map.get("credit_type").toString();
							    if(compMap.get(credit_type) != null)
							    {
							       credit_type=compMap.get(credit_type).toString();
							    }
							}
							if(map.get("credit_start_date")!= null)
							{
							    credit_start_date=map.get("credit_start_date").toString();
							    if(credit_start_date.length()>10)
							    { 
							      credit_start_date=credit_start_date.substring(0,10);
							    }
							}
							if(map.get("credit_end_date")!= null)
							{
							    credit_end_date=map.get("credit_end_date").toString();
							    if(credit_end_date.length()>10)
							    { 
							      credit_end_date=credit_end_date.substring(0,10);
							    }
							}
							%>
							<tr class="u2">
			        			<td align="left"><a href="CreditInfo.jsp?credit_id=<%=credit_id%>" onClick="mydefss()"><%=credit_title%></a></td>
								<td align="left" ><%=credit_type%></td>
								<td align="left" ><%=credit_start_date%></td>
								<td align="left" ><%=credit_end_date%></td>
								<td   align=center>
									<a href=modifyCreditInfo.jsp?credit_id=<%=credit_id%> ><img src=/images/edit.gif width=16 height=16 border=0 alt="修改证书信息">
									</a>
								</td>
								<td align=center><a href="/doTradeReg.do?credit_id=<%=credit_id%>&info_id=<%=credit_id%>&trade_type_code=0296" target="_self"><img src=/images/del.gif width=16 height=16 border=0></a></td>
					        </tr>
							<%i++;
						}
						%>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
						<tr class="u1">
							<td align="left" colspan="2"  style="font-weight:normal;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
							<td  align="right" colspan="3">
								<a href="modifyCreditIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
								 <% 
							if(Integer.parseInt(iStart)>0){
						%>
								<a href="modifyCreditIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<%}
									if(Integer.parseInt(iStart)<pages-1){
									%>
								<a href="modifyCreditIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
							<%}
									if(Integer.parseInt(iStart)==pages-1){
								%>
								<a  href="modifyCreditIndex.jsp?iStart=<%=pages-1%>">尾页</a></td>
							<%}%>
							
				    </tr>
						<%
					} else {
					%>
						<tr>
							<td colspan="6" align="center">
								无记录！
							</td>
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


