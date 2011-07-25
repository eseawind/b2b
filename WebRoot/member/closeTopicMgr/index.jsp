<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<%
	HttpSession logsession = request.getSession();
	String iStart = "0";
	String meun_idx = "";
	String cust_id = "";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}

	EnquirydInfo Info = new EnquirydInfo();
	ArrayList List = Info.getEnquiryOffed( Integer.parseInt( iStart ) );
	int counter = Info.getEnquiryOffed();
	int pages = (counter-1) / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) 
	{
		if (currenPage > 0) 
		{
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} 
	else if (pages == currenPage) 
	{
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
%>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

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
						var all_sale='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
									all_sale += document.getElementById('re_sale'+i).value+'|';
							}
						}
						
						document.getElementById('trade_id').value = all_news_id;
						document.getElementById('sale_id').value = all_sale;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else {
							document.indexdateform.action='/doTradeReg.do';
							document.getElementById("trade_type_code").value="9657";
							document.indexdateform.submit();
						}
				}
				
		</script>
		<form action="index.jsp" method="post" name="indexdateform">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"  align="center">
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
						<tr class="u4" height="25">
							<td align="left" width="25%" >
								标题
							</td>
							<td align="left" width="20%" >
								提问人
							</td>
							<td align="left" width="20%" >
								提问时间
							</td>
							<td align="center" width="15%" >
								关闭提问
							</td>
							<td width="20%" align="center">
									<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
									<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
									<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
							</td>
						</tr>
						<%
							if ( List != null && List.size() > 0 ) 
							{
							int size = List.size();
								for ( int i = 0; i < List.size(); i++ ) 
								{
									HashMap map = (HashMap) List.get(i);
									String rsrv_str3 = "", rsrv_str5 = "",  trade_id = "", enquiry_date = "";
									String rsrv_str1="" ,sale_id="";
									if (map.get("rsrv_str3") != null ) 
									{
										rsrv_str3 = map.get("rsrv_str3").toString();
									}
									if (map.get("sale_id") != null ) 
									{
										sale_id = map.get("sale_id").toString();
									}
									if (map.get("rsrv_str1") != null ) 
									{
										rsrv_str1 = map.get("rsrv_str1").toString();
									}
									if (map.get("rsrv_str5") != null ) 
									{
										rsrv_str5 = map.get("rsrv_str5").toString();
										if( rsrv_str5.equals("") )
										{
											rsrv_str5 = "游客";
										}
									}
									if (map.get("trade_id") != null ) 
									{
										trade_id = map.get("trade_id").toString();
									}
									if (map.get("enquiry_date") != null ) 
									{
										enquiry_date = map.get("enquiry_date").toString();
									}
						%>
						<tr class="u2">
							<td align="left">
								<a href="viewTopic.jsp?trade_id=<%=trade_id%>" ><%=rsrv_str3%> </a>
							</td>
							<td align="left">
								<%=rsrv_str5%>
							</td>
							<td align="left">
								<%=enquiry_date%> 
							</td>
							<%if(rsrv_str1.equals("1") || rsrv_str1.equals("0")){%>
							<td align=center>
								<a href="/doTradeReg.do?trade_type_code=1313&trade_id=<%=trade_id%>" target="_self"><img src=/images/icon_key.png width=16 height=16 border=0 alt="关闭提问"> </a>
							</td>
							<%}else{%>
							<td align=center>
								<a href="/doTradeReg.do?trade_type_code=3697&trade_id=<%=trade_id%>" target="_self"><img src=/images/open.png width=16 height=16 border=0 alt="重新打开"> </a>
							</td>
							<%}%>
				<td style="color: #000000;" align=center>
						<input type="hidden" name="re_sale<%=i%>" id="re_sale<%=i%>" value="<%=sale_id%>" />
						<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=trade_id%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
						
				</td>
						</tr>
						<%
						}
						%>
						<tr class="u1">
							<td align="left" colspan="3">
								共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart) + 1%>页&nbsp;&nbsp;共<%=pages%>页
							</td>
							<td align="right" colspan="2">
								<a href="index.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
								<%
								if (Integer.parseInt(iStart) > 0) {
								%>
								<a href="index.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<%
										}
										if (Integer.parseInt(iStart) < pages - 1) {
								%>
								<a href="index.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp;
								<%
								}
								%>
								<a href="index.jsp?iStart=<%=pages - 1%>">尾页</a>
							</td>
						</tr>
						<%
						}else{
						%>
						<tr align=center ><td colspan="4">暂无记录!</td></tr>
						<%}%>
					</table>
				</td>
			</tr>
		</table>
	<input type="hidden" name="trade_type_code" value="8726" />
	<input type="hidden" name="trade_id" value="" id="trade_id">
	<input type="hidden" name="sale_id" value="" id="sale_id">
</form>
 


