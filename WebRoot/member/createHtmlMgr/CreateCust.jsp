<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.CustCreateChannel"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="java.util.*"%>

<html>
	<head>
		<title>更新栏目</title>
	</head>
	<body>						
									
									<%
											String cust_id = session.getAttribute("SESSION_CUST_ID").toString();
											String ch_id = "",yes = "";
											String index_temp = "temp";
											if (request.getParameter("ch_id") != null){
													ch_id = request.getParameter("ch_id");
											}
											if (request.getParameter("yes") != null){
												yes = request.getParameter("yes");
											}
											if(!ch_id.equals(""))
											{
												CustCreateChannel cindex = new CustCreateChannel();
												//cindex.CreateChannelIndexList(ch_id,cust_id);
												if(yes.equals("0"))
												{
													cindex.CreateChannelIndexList(ch_id,cust_id);
												}
											}
											index_temp = "";
									%>
									<%
										ChannelColumnInfo info = new ChannelColumnInfo();
										String default_page = "",save_dir = "";
										ArrayList lists = new ArrayList();
										lists = info.getChannel(ch_id,cust_id);
										if (lists != null && lists.size() > 0) {
											HashMap map = (HashMap)lists.get(0);
											if(map.get("save_dir") != null) {
												save_dir = map.get("save_dir").toString();
											}
											if(map.get("default_page") != null){
												default_page = map.get("default_page").toString();
											}
										}
									%>
		
									<font size="3">生成栏目结束.....</font>
									<%
										if(!ch_id.equals("0000000000")){
									%>
									<a href="/<%=save_dir + "/" + default_page%>" target="_blank" >
										<font size="3">预览...</font>
									</a>
									<%
										}else{
									%>
										<a href="/company/web/<%=session.getAttribute("SESSION_CUST_ID").toString()%>/index.html" target="_blank" >
											<font size="3">预览...</font>
										</a>
									<%
										}
									%>
										
		
	</body>
</html>


