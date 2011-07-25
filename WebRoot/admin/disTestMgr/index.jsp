<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.disTestMgr.DisTestInfo"%>

<%@ page contentType="text/html;charset=GBK"%>



<html>
<head>

<title>bizoss-评测管理 </title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
<script language="javascript">
</script>
<style type="text/css">
	.bord{
		border-style: none;
	}
</style>
</head>

<body>

<%
    String iStart ="0";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    
	 DisTestInfo disInfo = new DisTestInfo();
	 ArrayList disList = new ArrayList();
	 disList = disInfo.getAllDisTestById(Integer.valueOf(iStart).intValue());
	 
	int counter=disInfo.getAllDisTestById();
	int pages=counter/20+1;
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
<center>
	
<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="abeeEFE113yH15a" />
			</jsp:include>
	
	<table width="800" border="0" cellspacing="0" cellpadding="0">
	  <tr>

	    <td>

		     <table class="tbg" width=800 border=0 cellpadding=1 cellspacing=1 align=center  bgcolor="#DEEDFD">

		        <tr class="u4" height="25">

			        <td width="25%">申请评测客户</td>
							<td width="25%">评测产品</td>
							<td width="20%">测试时间</td>
							<td width="10%">修改</td>
							<td width="10%">删除</td>
							<td width="10%">查看</td>
		        </tr>

		       <%	
		            if(disList != null && disList.size()>0)
		            {    
		              	 for (int i=0;i<disList.size();i++)
		                  {
						        HashMap map = (HashMap)disList.get(i);
						        String dis_test_id="",test_cust_name="",product_name="",contact_type="",in_date="",test_request="";
						        if(map.get("dis_test_id")!=null){
						         dis_test_id=map.get("dis_test_id").toString();
						        }
						        if(map.get("test_cust_name")!=null){
						         test_cust_name=map.get("test_cust_name").toString();
						        }
						        if(map.get("product_name")!=null){
						         product_name=map.get("product_name").toString();
						        }
						        if(map.get("contact_type")!=null){
						         contact_type=map.get("contact_type").toString();
						        }
						        if(map.get("in_date")!=null){
						         in_date=map.get("in_date").toString().substring(0,10);
						        }
						        if(map.get("test_request")!=null){
						         test_request=map.get("test_request").toString();
						        }
						        	        
						  %>
						        <tr class="u2" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">
					              <td align=left><a href="/admin/disTestMgr/viewDistTest.jsp?dis_test_id=<%=dis_test_id%>" target="_blank"><%=test_cust_name%></a></td>
					              <td align=left><%=product_name%></td>
					              <td align=left><%=in_date%></td>
					              <td align=center>
					              	<a href="updateDistTest.jsp?dis_test_id=<%=dis_test_id%>" target="_blank">
					              		<img src="/images/edit.png" style="cursor: hand;" border="0" alt="点击修改评测信息">
					              	</a>
					              </td>
					              <td align=center>
					              	<a href="/doTradeReg.do?trade_type_code=6665&dis_test_id=<%=dis_test_id%>">
					              		<img src="/images/del.gif" style="cursor: hand;" border="0" alt="点击删除评测">
					              	</a>
					              </td>
					              <td align=center>
					              	<a href="viewDistTest.jsp?dis_test_id=<%=dis_test_id%>" target="_blank">
					              		<img src="/images/views.png" style="cursor: hand;" border="0" alt="点击查看评测详细信息">
					              	</a>
					              </td>
					            </tr>
						 <%
					     }
					  %>
				         <tr class="u3">
								<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td  align="right" colspan="4"  style=" padding:2px 5px;">
								<a href="index.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
								<% 
								if(Integer.parseInt(iStart)>0){
								%>
								<a href="index.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<%
								}
								if(Integer.parseInt(iStart)<pages-1){
								%>
								<a href="index.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
								<%
								}
								%>
								<a  href="index.jsp?iStart=<%=pages-1%>">尾页</a></td>
						</tr>
					 <%}else{
					 %>
					 		<tr>
	              <td class="u6" colspan="6" align=center>无评测记录!</td>
	            </tr>
					 <%
					 	}
		        %>
		    </table>
	     </td>
	  </tr>
	  <tr>
	    <td height="13"></td>
	  </tr>
	</table>
</center>
</body>
</html>



