<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.indexLinkMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.biddingMgr.Biddinginfo"%>
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
	 /*****************************************/
     Biddinginfo biddingObj=new Biddinginfo();
	 ArrayList resuleList=biddingObj.getBiddingList(Integer.valueOf(iStart).intValue(),cust_id);
	 int counter=biddingObj.getBiddingNumber(cust_id);
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
	    <td height="13"></td>
	  </tr>
	  <tr>
	    <td>
		     <table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		        <tr>
			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">招标主题</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="10%">标号</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%">开标时间</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="30%" >招标地点</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="15%" >联系电话</td>
					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center"  width="10%" >操作</td>
		        </tr>
		        <%
					if(resuleList != null  && resuleList.size()>0)
					{
						int i=0;
						for (Iterator inIt = resuleList.iterator(); inIt.hasNext();)
					    {
						    HashMap map = (HashMap) inIt.next();
						    String bidding_id=map.get("bidding_id").toString();
						   	String title=map.get("title").toString();
							String bidding_no=map.get("bidding_no").toString();
							String open_date="";
							String addr="";
							String phone="";
							if(map.get("open_date") !=null)
							{
							  open_date=map.get("open_date").toString();
							  if(open_date.length()>10)
							  {
							    open_date=open_date.substring(0,10);
							  }
							}
						    if(map.get("addr") !=null)
							{
							  addr=map.get("addr").toString();
							}
							if(map.get("phone") !=null)
							{
							  phone=map.get("phone").toString();
							}
							%>
							<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
			        			<td style=" color:#000000; padding:2px 5px;" align="left"><%=title%></td>
							  <td style=" color:#000000; padding:2px 5px;" align="left" ><%=bidding_no%></td>
								<td style=" color:#000000;" align="center" ><%=open_date%></td>
								<td style=" color:#000000; padding:2px 5px;" align="left" ><%=addr%></td>
								<td style=" color:#000000; padding:2px 5px;" ><%=phone%></td>
								<td  style=" color:#000000;" align=center><a href=addIsBiddingInfo.jsp?bidding_id=<%=bidding_id%> target=blank><img src=/img/edit.gif width=16 height=16 border=0></a></td>
					        </tr>
							<%i++;
						}
						%>
						<tr>

																		<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
											
																		<td  align="right" colspan="3"  style=" padding:2px 5px;">
																		<a href="biddingListIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
																		<% 
																			if(Integer.parseInt(iStart)>0){
																		%>
																			<a href="biddingListIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
																		<%
																			}
																			if(Integer.parseInt(iStart)<pages-1){
																		%>
																			<a href="biddingListIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
																		<%
																			}
																		%>
																		<a  href="biddingListIndex.jsp?iStart=<%=pages-1%>">尾页</a></td>
											
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


