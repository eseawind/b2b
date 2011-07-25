<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.showMgr.ShowInfo"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("GBK");
	
	ShowInfo showInfo = new ShowInfo();
	ArrayList showlist = new ArrayList();
	String iStart = "0";
	String it = "0";
	if (request.getParameter("i") != null) {
		it = request.getParameter("i");
	}
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	String cust_id="";
	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	
	showlist = showInfo.getMemberShows(Integer.parseInt(iStart),cust_id);
	int counter = showInfo.getMemberShows(cust_id);
	
	String input_title="";
  if (request.getParameter("input_title") != null ){
		input_title = request.getParameter("input_title");
		if(it.equals("1")){
			input_title=URLDecoder.decode(input_title,"GBK");
			input_title= new String(input_title.getBytes("ISO-8859-1"),"GBK");
		}
		showlist = showInfo.getMemShowByTitle(Integer.parseInt(iStart),input_title,cust_id);
		counter =  showInfo.getMemShowByTitle(input_title,cust_id);
  }
	  
	int pages = counter / 20 +1;
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
		<title>展会管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
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
				function reloadNews(val){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}						
						document.getElementById('show_id').value = all_news_id;
						document.getElementById('root_id').value = all_news_id;
						document.getElementById('info_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else {
							if(val=='1'){
								document.proForm.action='/doTradeReg.do';
								document.proForm.submit();
							}
							if(val=='2'){
									document.proForm.action='/doTradeReg.do';
									document.getElementById("trade_type_code").value="5956";
									document.proForm.submit();
								}
						}
				}
			function showDown(){
				if(document.getElementById('input_title').value==''){
						alert('请输入请输展会标题！');
						return false;
					}
				javascript:document.proForm.submit();
			}
		</script>
	</head>
	<body>
			<form action="showMgr.jsp" method="post" name="proForm">	
				<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addshow.jsp">新增展会信息</a>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" bgcolor="#DEEDFD" cellspacing="1" cellpadding="1" align="center">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" >
					<tr class="u1">
						<td align=left>
							请输入展会标题：	<input type="text" name="input_title" id="input_title" value="" />
							<img src="/admin/images/chaxun.gif" border="0" onclick="showDown();" style="cursor:hand;"/>
						</td>
					</tr>
			</table>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=left bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="30%">
								展会标题
							</td>
							<td width="30%">
								展会地点
							</td>
							<td width="20%">
								展会开始时间
							</td>
							<td width="10%">
								<center>修改</center>
							</td>
							<td width="10%" align="center">
									<input type="button" name="reload" value="删除" onclick="reloadNews(2)"/>
									
							</td>
						</tr>
						<%
							String title="",show_addr="",show_id="",start_time="";
							if(showlist!=null){
							int size = showlist.size();
								for(int i=0;i<showlist.size();i++){
									HashMap map = (HashMap)showlist.get(i);
									if(map.get("show_id")!=null){
										show_id = map.get("show_id").toString();
									}
									if(map.get("title")!=null){
										title = map.get("title").toString();
										if(title.length() > 17){
										title = title.substring(0,17) + "...";
										}
									}
									if(map.get("show_addr")!=null){
										show_addr = map.get("show_addr").toString();
										if(show_addr.length() > 20){
										show_addr = show_addr.substring(0,20) + "...";
										}
									}
									if(map.get("start_date")!=null){
										start_time = map.get("start_date").toString();
									}%>
							
						<tr class="u2">
							<td align=left>
								 <a href="showone.jsp?show_id=<%=show_id%>"><%=title%></a>
							</td>
							<td align=left>
								<%=show_addr%>
							</td>
							<td align=left>
								<%=start_time%>
							</td>
							<td align=left>
								<center>
									<a href="updateshowInfo.jsp?show_id=<%=show_id%>" ><img src="/images/edit.png"  border="0"/></a>
								</center>
							</td>
							<td style="color: #000000;" align=center>
									<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=show_id%>" />
									<input type="hidden" name="size" value="<%=size%>" id="size" />
									
							</td>
							<!--td align=left>
								<center>
								  <a href="/doTradeReg.do?trade_type_code=0001&show_id=<%=show_id%>" target="_self">
								  <img src="/images/del.gif" border="0" title="点击删除该展会"> </a></td></center>
							</td-->
						</tr>
							<%
							}
							}
						%>

						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right" colspan="4"  style=" padding:2px 5px;"> 
								<a href="showMgr.jsp?iStart=0&menu_id=<%=top_menu_id%>&input_title=<%=input_title%>&i=1">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="showMgr.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>&input_title=<%=input_title%>&i=1">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="showMgr.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>&input_title=<%=input_title%>&i=1">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="showMgr.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>&input_title=<%=input_title%>&i=1">尾页</a></td>
						</tr>
						<%
						if(showlist==null){
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
									  	<%}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td height="13">&nbsp;
					
				</td>
			</tr>
			<input type="hidden" id="trade_type_code" name="trade_type_code" value="5986">
			</table>
			<input type="hidden" id="show_id" name="show_id">
			<input type="hidden" id="root_id" name="root_id">
			<input type="hidden" id="info_id" name="info_id">
		</form>
	</body>
</html>



