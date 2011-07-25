<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.feeSetMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
		request.setCharacterEncoding("gbk");
    String iStart ="0";
   	if(request.getParameter("iStart")!=null){
   		iStart = request.getParameter("iStart");
   	}
	FeeSetInfo feeset = new FeeSetInfo();
	ArrayList feeList = new ArrayList();
	feeList = feeset.getAllByNone(Integer.parseInt(iStart));
	int counter = feeset.getAllByNone();
	int pages = counter / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.parseInt(iStart);
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
	String trade_id="",fee="",limit_time="",para_code2="";
	
	//String toolsBar=tools.getPageTools(String.valueOf(counter),"20","ViewSetFee.jsp?iStart=",Integer.parseInt(iStart));
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script>
			
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
						document.getElementById('trade_id').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else{
							document.indexdateform.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value="1364";
							document.indexdateform.submit();	
						}
				}
		</script>
</head>
<body>
	<form action="" method="post" name="indexdateform">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
					<td align="left" class="head">
						<a href="feeSet.jsp">新增费用设置</a>
					</td>
			</tr>
		</table>
	<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
		<%if(feeList==null){
		%>
		暂无记录
		<%}else{%>
						<tr class="u4" height="25">
							<td align="left" width="25%">
								会员级别
							</td>
							<td align="center" width="20%">
								时间
							</td>
							<td align="left" width="20%">
								缴纳费用
							</td>
							<!--td align="left" width="20%">
								描述
							</td-->
							<td align="center" width="15%">
								修改
							</td>
							<td width="20%" align="center">
								<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
								<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
								<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
							</td>
							<%
							if(null!=feeList){
							int size = feeList.size();
								for(int i=0;i<feeList.size();i++){
									HashMap feeMap = (HashMap)feeList.get(i);
									if(feeMap.get("trade_id")!=null){
										trade_id = feeMap.get("trade_id").toString();
									}
									if(feeMap.get("fee")!=null){
										fee = feeMap.get("fee").toString();
									}
									if(feeMap.get("limit_time")!=null){
										limit_time = feeMap.get("limit_time").toString();
									}
									if(feeMap.get("para_code2")!=null){
										para_code2 = feeMap.get("para_code2").toString();
									}
							%>
							<tr class="u2">
								<td align="left"><%=para_code2%></td>
								<td align="left"><%=limit_time%></td>
								<td align="left"><%=fee%></td>
								<td align="center"><a href=FeeUpdate.jsp?trade_id=<%=trade_id%>><img src=/images/edit.gif width=16 height=16 border=0></a></td>
								<td style="color: #000000;" align=center>
									<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=trade_id%>" />
									<input type="hidden" name="size" value="<%=size%>" id="size" />
									<input type="hidden" name="trade_id" value="<%=trade_id%>" id="trade_id" />
								</td>
							</tr>
							<%}
							}
							}
							%>
						<input type="hidden" id="all_news_id" name="all_news_id" value="">
						<input type="hidden" name="trade_type_code" id="trade_type_code" value="">
						
						<tr class="u1">

							<td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>

							<td  align="right" colspan="3"  style=" padding:2px 5px;">
							<a href="ViewSetFee.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
							<% 
								if(Integer.parseInt(iStart)>0){
							%>
								<a href="ViewSetFee.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
							<%
								}
								if(Integer.parseInt(iStart)<pages-1){
							%>
								<a href="ViewSetFee.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
							<%
								}
							%>
							<a  href="ViewSetFee.jsp?iStart=<%=pages-1%>">尾页</a></td>

				         </tr>
				</table>
			</form>
	</body>
</html>



