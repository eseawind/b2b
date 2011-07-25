<%@ page contentType="text/html;charset=GBK" %>

<%@ page import="com.saas.biz.indexLinkMgr.*" %>

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

	  IndexlinkInfo  linkList=new IndexlinkInfo();

	  ArrayList linkArray = linkList.getLinkListByAll(Integer.valueOf(iStart).intValue());

	 int counter=linkList.getLinkNumber();

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

		<title>菜单管理</title>

		

		<style type="text/css">

		.line5 {width:788px; width:767px!important;border:#ffdf81 1px solid;  background-color:#fff8ee; text-align:left; padding: 10px 0 10px 20px; margin:10px 0px; color:#FF3300; font-weight:bolder;}   /*横栏样式5---- 底部提醒1*/

		</style>

		<script language="javascript">

		  function chechIfo()

		  {

			   if(confirm('是否确认删除本条记录？')) 

			{

				return true;

			}

			else

			{

				return false;

			}

		  }

		</script>

	</head>

<body>  
	<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="rQc713e5Ch3R1s1" />
			<jsp:param name="addLink" value="addLinkInfo.jsp" />
		</jsp:include>	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

	  <tr>

	    <td>

		     <table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">

		        <tr>

			        <td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="20%">链接类型</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="left" width="25%">链接名称</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="50%">描述</td>

					<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="10%">删除</td>

		        </tr>

		        <%

					if(linkArray != null  && linkArray.size()>0)

					{

						int i=0;

						for (Iterator inIt = linkArray.iterator(); inIt.hasNext();)

					    {

						    HashMap map = (HashMap) inIt.next();

						   	String linkName=map.get("link_name").toString();

							String linkIdx= map.get("link_id").toString();

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

							if(map.get("link_desc") != null)

							{

							    linkDesc=map.get("link_desc").toString();

							    linkDesc=linkDesc.replaceAll("<[^<>]+>","");

							    if(linkDesc.length()>25)

							    { 

							      linkDesc=linkDesc.substring(0,25)+"...";

							    }

							}

							%>

							<tr style="background-color:#f9f9f9; " id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">

			        				<td style=" color:#000000;" align="center"><%=linkType%></td>

								<td style=" color:#000000; padding:2px 5px;" align="left"><%=linkName%></td>

								<td style=" color:#000000; padding:2px 5px;" align="left" ><%=linkDesc%></td>

								 <td  style=" color:#000000;" align=center><a href=/doTradeReg.do?link_id=<%=linkIdx%>&trade_type_code=0912 target="_self"  onClick="return chechIfo()"><img src=/img/del.gif width=16 height=16 border=0></a></td>

					        </tr>

							<%i++;

						}

						%>

						<tr>

							<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>

							<td  align="right" colspan="3"  style=" padding:2px 5px;">
							<a href="deleteIndex.jsp?iStart=0&menu_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="deleteIndex.jsp?iStart=<%=pageUp%>&menu_id=<%=meun_idx%>">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="deleteIndex.jsp?iStart=<%=pageDown%>&menu_id=<%=meun_idx%>">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="deleteIndex.jsp?iStart=<%=pages-1%>&menu_id=<%=meun_idx%>">尾页</a></td>

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


