<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<% 

	String news_title = "";	 
	if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
	}
	
	ArrayList custArray = new ArrayList();
	Custinfo custInfo = new Custinfo();
	String iStart = "0",limit="20";
	int counter = 0;
	if(request.getParameter("iStart") != null) {
		iStart=request.getParameter("iStart").toString();
	}	
	
  if (news_title.equals("")) {
  	custArray = custInfo.getAllCustByCount(Integer.parseInt(iStart),Integer.parseInt(limit),"0");
  	counter = custInfo.getAllCustByCount("0");
  }else {
  	news_title= new String(news_title.getBytes("ISO-8859-1"),"GBK");  	
  	custArray = custInfo.getAllCustByTitleForCount(Integer.parseInt(iStart),Integer.parseInt(limit),"0",news_title);
  	counter = custInfo.getAllCustByTitleForCount("0",news_title);
  }  
		
	
	int pages = (counter-1) / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "CustomerCount.jsp?news_title="+news_title+"&iStart=", Integer.parseInt(iStart));
	
%>
<html>
	<head>
		<meta name="Generator"
			content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>会员信息统计</title>
		 <link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
			h1 {float:left;padding-left:8px; font-size:15px; font-weight:bold; padding-top:5px;}
		</style>
	</head>

	<script language="javascript">
				function search(){
					if(document.getElementById('news_title').value==''){
						alert('请输入关键字！');
						return false;
					}else {
						document.searchForm.submit();
					}					
				}				
	</script>
	<body>
		<form action="CustomerCount.jsp" method="post" name="searchForm">
			<table height="8">
				<tr>
					<td>
					</td>
				</tr>
			</table>
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="left" bgcolor="#DEEDFD">
			<tr bgcolor="white">
					<td align="left" colspan="3">
					<font size="2"><b>	请输入公司名称:</b></font>						
						<input type="text" name="news_title" id="news_title" size="30" value="">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
					</td>
				
			<tr class="u4" height="25">				
				<td width="50%">
					公司名称
				</td>				
				<td width="30%" align="center">
					注册时间
				</td>
				<td width="20%" align="center">
					统 计
				</td>
			</tr>
			<%
			   if (custArray != null && custArray.size() > 0) {
					for (int i=0; i<custArray.size(); i++) {
						HashMap map = (HashMap)custArray.get(i);
						String cust_id = "";				
						String cust_aim = "";
						String publish_date = "";
						if(map.get("cust_id") != null) {
							cust_id = map.get("cust_id").toString();						
						}
						if (map.get("publish_date") != null) {
							publish_date = map.get("publish_date").toString();
					    if( publish_date.length()>10 ){ publish_date = publish_date.substring(0,10); }
						}
						if (map.get("cust_aim") != null) {
					      cust_aim = map.get("cust_aim").toString();
						}
					%>
					<tr class="u2">
						<td align="left"><%=cust_aim%></td>
						<td align="center"><%=publish_date%></td>
						<td align="center"><a href="CustomerCountInfo.jsp?cust_id=<%=cust_id%>">统 计</a></td>
					</tr>					
					<%
						}
					%>
					<tr class="u1">
							<td align="left" colspan="1" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td align="right" colspan="2"  style=" padding:2px 5px;">
							<a href="CustomerCount.jsp?iStart=0&news_title=<%=news_title%>&i=1">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="CustomerCount.jsp?iStart=<%=pageUp%>&news_title=<%=news_title%>&i=1">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="CustomerCount.jsp?iStart=<%=pageDown%>&news_title=<%=news_title%>&i=1">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="CustomerCount.jsp?iStart=<%=pages-1%>&news_title=<%=news_title%>&i=1">尾页</a></td>

				 </tr>
					
					<%
			}else {
				%>
				<tr class="u2">
						<td align="center" colspan="3" style="font-weight:normal; padding:2px 5px;">暂无信息</td>
				</tr>	
			<%
				}
			%>
		</table></form>
	</body>
</html>



