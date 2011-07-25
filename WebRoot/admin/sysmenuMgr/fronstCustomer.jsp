<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>

<%
	 request.setCharacterEncoding("gbk");
	String meun_idx = "";
	String iStart = "0";
	String it = "0";
	if (request.getParameter("i") != null) {
		it = request.getParameter("i");
	}
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	ParamethodMgr comparList = new ParamethodMgr();
	Custinfo custEntity = new Custinfo();
	ArrayList custArray = custEntity.getCustListByState(Integer.valueOf(iStart).intValue(), "0");
	int counter = custEntity.getCustStateNumber("0");
	
	 String news_title = "";
	  if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
		
		}
		if(it.equals("1")){
			news_title=URLDecoder.decode(news_title,"GBK");
			news_title= new String(news_title.getBytes("ISO-8859-1"),"GBK");
		}
    if (!news_title.equals(""))
     {
			custArray = custEntity.getOneCustD(Integer.parseInt(iStart),news_title);
	    counter = custEntity.getOneCustD(news_title);
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
%>
<html>
	<head>
		<meta name="Generator"
			content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>会员冻结</title>
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
  function chechIfo()
  {
	   if(confirm('是否确认冻结会员？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
</script>
<script language="javascript">
			function search(){
						if(document.getElementById('news_title').value==''){
								alert('请输入客户名！');
								return false;
						}else{ 
						document.searchForm.submit();
					}
				}
					</script>
	<body>
		<form action="fronstCustomer.jsp" method="post" name="searchForm">	
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="left" bgcolor="#FCB0B0">
			<tr bgcolor="white">
					<td align="left" colspan="7">
					<font size="2"><b>	请输入公司名称:</b></font>
						<input type="text" name="news_title" id="news_title" size="30">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
						
					</td>
				
			<tr class="u4" height="25">
				<td width="20%">
					管理员姓名
				</td>
				<td width="15%">
					公司名称
				</td>
				<td width="15%">
					联系电话
				</td>
				
				<td width="15%">
					公司网址
				</td>
				<td width="10%">
					注册时间
				</td>
				<td width="20%">
					地址
				</td>
				<td align="center" width="10%">
					冻结
				</td>
			</tr>
			<%
			    if (custArray != null && custArray.size() > 0) {
					int i = 0;
					for (Iterator inIt = custArray.iterator(); inIt.hasNext();) {
						HashMap map = (HashMap) inIt.next();
						String cust_id = "";
						String cust_name = "";
						String phone = "";
						String website = "";
						String cust_addr = "";
						String cust_aim = "";
						String publish_date = "";
						cust_id = map.get("cust_id").toString();
						if(map.get("cust_name") != null) {
							cust_name = map.get("cust_name").toString();
						}
						if (map.get("group_contact_phone") != null) {
					      phone = map.get("group_contact_phone").toString();
						}
						if (map.get("company_address") != null) {
					      cust_addr = map.get("company_address").toString();
						}
						if (map.get("website") != null) {
					      website = map.get("website").toString();
						}
						if (map.get("publish_date") != null) {
					      publish_date = map.get("publish_date").toString();
					      if( publish_date.length()>10 ){
					      		publish_date = publish_date.substring(0,10);
					      }
						}
						if (map.get("cust_aim") != null) {
					      cust_aim = map.get("cust_aim").toString();
						}
					%>
					<tr class="u2"id="changcolor_tr<%=i%>" onMouseOver="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')"	onMouseOut="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')">
						<td align="left"><%=cust_name%></td>
						<td align="left"><a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>&user_id=" onClick="mydefss()"><%=cust_aim%></a></td>
						<td align="left"><%=phone%></td>
						
						<td align="left"><%=website%></td>
						<td align="left"><%=publish_date%></td>
						<td align="left"><%=cust_addr%></td>
						<td align=center><a href="/doTradeReg.do?cust_id=<%=cust_id%>&cust_state=2&trade_type_code=0167" target="_self" onClick="return chechIfo()"><img src=/images/frost.gif width=16	height=16 border=0 alt="冻结会员"></a></td>
					</tr>
					<%
					i++;
					}
					%>
					
					<tr class="u1">
							<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td align="right" colspan="5"  style=" padding:2px 5px;">
							<a href="fronstIndex.jsp?iStart=0&news_title=<%=news_title%>&i=1">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="fronstIndex.jsp?iStart=<%=pageUp%>&news_title=<%=news_title%>&i=1">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="fronstIndex.jsp?iStart=<%=pageDown%>&news_title=<%=news_title%>&i=1">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="fronstIndex.jsp?iStart=<%=pages-1%>&news_title=<%=news_title%>&i=1">尾页</a></td>

				 </tr>
					
					<%
			}
			%>
		</table></form>
	</body>
</html>



