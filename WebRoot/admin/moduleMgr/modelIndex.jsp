<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.bpmdefinitionMgr.BpmInfo"%>
 
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function search(){
						if(document.getElementById('news_title').value==''){
								alert('请输入信息标题！');
								return false;
						}else{ 
						document.searchForm.submit();
					}
				}
					</script>
	</head>
	<%
		String iStart = "0";
		if (request.getParameter("iStart") != null) {
			iStart = request.getParameter("iStart");
		}
		ArrayList bpmList = new ArrayList();
		BpmInfo bpmInfo = new BpmInfo();
		int counter = 0;
		bpmList = bpmInfo.getBpmAll(Integer.valueOf(iStart).intValue());
		counter = bpmInfo.getBpmAll();
		
		//out.println(counter);
		String news_title = "";
	  if (request.getParameter("news_title") != null) {
		news_title = request.getParameter("news_title");
		news_title = new String(news_title.getBytes("ISO_8859-1"),
		"GBK");
		}
		if (!news_title.equals("")) {
			bpmList = bpmInfo.getOneBpmNode(Integer.parseInt(iStart),news_title);
			counter = bpmInfo.getOneBpmNode(news_title);
		}
		
		int pages = counter / 30 + 1;
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
	<body><!--table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>业务流程管理</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;<a href="http://b2b.bizoss.com/frame/moduleMgr/addBpm.jsp" target="_blank"><img src=/admin/images/newAdd.gif border=0></a>
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->
	  <form action="modelIndex.jsp" method="post" name="searchForm">
	  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addBpm.jsp">新增业务流程</a>
				</td>
			</tr>
		</table>

	  <table bgcolor="#DEEDFD" width="100%" cellpadding="1" align="center" cellspacing="1" border="0">
	  		<tr class="u1">
					<td align="left" colspan="6">
					<font size="2"><b>	请输入关键字:</b></font>
						<input type="text" name="news_title" id="news_title" size="30">
						<img src="/admin/images/chaxun.gif" onclick="return search()" style="cursor:hand;">
						
					</td>
				</tr>
					
					<tr class="u4" height="25">
						<td width="15%" align="left">
							<b>trade_type_code</b>
						</td>
						<td width="10%" align="left">
							<b>bpm_id</b>
						</td>
						<td width="40%" align="left">
							<b>node_class</b>
						</td>
						<td width="15%" align="left">
							<b>node_method</b>
						</td>
						<td width="10%" align="center">
							<b>修改</b>
						</td>
						<td width="10%" align="center">
							<b>删除</b>
						</td>
					</tr>
					<%
						String bpm_id="",trade_type_code="",node_class="",node_method="";
						if(bpmList!=null && bpmList.size()>0){
							for(int i=0;i<bpmList.size();i++){
								HashMap bpmMap = (HashMap)bpmList.get(i);
								if(bpmMap.get("trade_type_code")!=null){
									trade_type_code = bpmMap.get("trade_type_code").toString();
								}
								if(bpmMap.get("bpm_id")!=null){
									bpm_id = bpmMap.get("bpm_id").toString();
								}
								if(bpmMap.get("node_class")!=null){
									node_class = bpmMap.get("node_class").toString();
								}
								if(bpmMap.get("node_method")!=null){
									node_method = bpmMap.get("node_method").toString();
								}
						%>
								<tr class="u2">
									<td align="left">
										<%=trade_type_code%>
									</td>
									<td align="left">
										<%=bpm_id%>
									</td>
									<td  align="left">
										<%=node_class%>
									</td>
									<td  align="left">
										<%=node_method%>
									</td>
									<td  align="center">
										<a href="http://b2b.bizoss.com/admin/moduleMgr/updateBpm.jsp?trade_type_code=<%=trade_type_code%>" target=""><img src="/images/edit.png"  border="0"/></a>
									</td>
									<td  align="center">
										<a href="/doTradeReg.do?trade_type_code=9999&trade_type_code1=<%=trade_type_code%>&bpm_id=<%=bpm_id%>&node_class=	<%=node_class%>&node_method=<%=node_method%>"><img src="/images/delete.png" border="0" /></a>
									</td>
								</tr>
					<%
							}
						}
					%>
					<tr class="u1">
							<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
							<td align="right" colspan="4"  style=" padding:2px 5px;">
							<a href="modelIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="modelIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="modelIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="modelIndex.jsp?iStart=<%=pages-1%>">尾页</a></td>
				     </tr>
			</table>	
		
	<body>
</html>



