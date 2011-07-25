<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page contentType="text/html;charset=GBK"%>
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
	 String news_title = "",title = "";
	  if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
		}
		if(it.equals("1")){
			news_title=URLDecoder.decode(news_title,"GBK");
			news_title= new String(news_title.getBytes("ISO-8859-1"),"GBK");
		}
    if (!news_title.equals(""))
     {
			custArray = custEntity.getOneCustDel(Integer.parseInt(iStart),news_title);
	    counter = custEntity.getOneCustDel(news_title);
		}
	
	int pages = counter / 20 + 1;
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
		<meta name="Generator" content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B电子商务后台管理系统</title>
		 <link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; color:#333333;text-align:center; font-size:12px;}  /*横栏样式1*/
			h1 {float:left;padding-left:8px; font-size:15px; font-weight:bold; padding-top:5px;}
		</style>
	</head>
	<script language="javascript">
	function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
		function delAllNews(){
				var size = document.getElementById('size').value;
				for(var i=0;i<size;i++){
						if(document.getElementById('re_news'+i).checked==true){
							document.getElementById('re_news'+i).checked = false;	
						}else{
							document.getElementById('re_news'+i).checked = true;		
						}
				}
		}
				
				function reloadNews(){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('sale_unit').value = all_news_id;
						document.getElementById('cust_id').value = all_news_id;
						document.getElementById('info_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}
						else{
							document.searchForm.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value="9254";
							document.searchForm.submit();
					}
				}	
		
		
  function chechIfo()
  {
	   if(confirm('是否确认删除该客户？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  function search(){
						if(document.getElementById('news_title').value==''){
								alert('请输入客户名称！');
								return false;
						}else{ 
						document.searchForm.submit();
					}
				}
</script>

	<body>
		<form action="delCustomer.jsp" method="post" name="searchForm">		
		<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>会员资料删除</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;<a href="http://b2b.bizoss.com/frame/moduleMgr/addBpm.jsp" target="_blank"></a>
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->					
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="left" bgcolor="#DEEDFD">
			<tr bgcolor="white">
					<td align="left" colspan="7">
					<font size="2"><b>	请输入公司名称:</b></font>
						<input type="text" name="news_title" id="news_title" size="30">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
						
					</td>
				
			<tr class="u4" height="25">
				<td width="16%">
					管理员姓名
				</td>
				<td width="11%">
					联系电话
				</td>
				<td width="14%">
					公司名称
				</td>
				<td width="15%">
					公司网址
				</td>
				<td width="10%">
					注册时间
				</td>
				<td width="16%">
					地址
				</td>
				<td width="18%" align="center">
						<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
						<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
						<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
				</td>
			</tr>
			<%
			    if (custArray != null && custArray.size() > 0) {
			    int size = custArray.size();
					int i = -1;
					for (Iterator inIt = custArray.iterator(); inIt.hasNext();) {
					i++;
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
					<tr class="u2">
						<td align="left">
							<a href=/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%> ><%=cust_name%></a>
						</td>
						<td align="left"><%=phone%></td>
						<td align="left"><%=cust_aim%></td>
						<td align="left"><%=website%></td>
						<td align="left"><%=publish_date%></td>
						<td align="left"><%=cust_addr%></td>
						
				<td style="color: #000000;" align=center>
						<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=cust_id%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
						
				</td>
						<!--td align="center">
							<a href=/doTradeReg.do?cust_id=<%=cust_id%>&trade_type_code=9987&sale_unit=<%=cust_id%> target="_self">
								<img src="/images/del.gif" border="0" />
							</a>
						
						</td-->
					</tr>
					<%
					}
					%>
					
					<tr class="u1">
										<td  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td  align="right" colspan="5"  style=" padding:2px 5px;">
										<a href="delIndex.jsp?iStart=0&news_title=<%=news_title%>&i=1">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="delIndex.jsp?iStart=<%=pageUp%>&news_title=<%=news_title%>&i=1">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="delIndex.jsp?iStart=<%=pageDown%>&news_title=<%=news_title%>&i=1">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="delIndex.jsp?iStart=<%=pages-1%>&news_title=<%=news_title%>&i=1">尾页</a></td>
			
							         </tr>
					<%
			}
			else{
      %>
      	<tr>
      		<td align="center" colspan="6" bgcolor="white">
      			无记录！
      		</td>
      	</tr>
      <%		
      }
			%>
			<input type="hidden" value="" id="trade_type_code" name="trade_type_code">
			<input type="hidden" value="" id="sale_unit" name="sale_unit">
			<input type="hidden" value="" id="cust_id" name="cust_id">
			<input type="hidden" value="" id="info_id" name="info_id">
		</table>
		</form>
	<body>
</html>



