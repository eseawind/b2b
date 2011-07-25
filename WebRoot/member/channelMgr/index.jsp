<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<%
	
	String iStart = "1";
	if ( request.getParameter("iStart") != null ) {
		iStart = request.getParameter( "iStart" );
	}
	String ch_idx = "0000000000";
	if (request.getParameter("ch_id") != null) {
		ch_idx = request.getParameter("ch_id");
	}
	String cust_id = "";
	if( session.getAttribute( "SESSION_CUST_ID" ) != null )
	{
		cust_id = session.getAttribute( "SESSION_CUST_ID" ).toString();
	}
	int counter = 0,cpage=0;
	String pageTools = "";
 
	ChannelColumnInfo channel = new ChannelColumnInfo();
	ArrayList list = new ArrayList();
    try
	{
      cpage=Integer.parseInt( iStart );  
    }
	catch(Exception e)
	{
     	cpage=1;
    }

	list =  channel.getChannelInfos( Integer.valueOf(iStart).intValue(), ch_idx, cust_id );
	counter = channel.getChannelcount( ch_idx, cust_id );
	pageTools = tools.getPageTools( String.valueOf(counter), "30","index.jsp?ch_id=" + ch_idx + "&iStart=", Integer.parseInt( iStart )	);
	
	String up_ch_level  = channel.getUpChannelLevel(ch_idx);
%>
<html>
	<head>
		<title>栏目栏目管理</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ChannelInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

	</head>
	<body>
	
		<table bgcolor="#98D9A2" width="100%" cellpadding="1" align="center" cellspacing="1" border="0">
			<tr class="u2">
				<td align="left" class="head" colspan="10">
					<a href="addNewChannel.jsp?ch_id=0000000000&up_ch_level=0%>">新增栏目</a>
				</td>
			</tr>
			<tr class="u4" height="25">
				<td width="5%" align="left">
					<b>序号</b>
				</td>
				<td width="10%" align="left">
					<b>栏目标识</b>
				</td>
				<td width="10%" align="left">
					<b>栏目名称</b>
				</td>
				<td width="10%" align="left">
					<b>上级栏目</b>
				</td>
				<td width="10%" align="left">
					<b>栏目级别</b>
				</td>
				<td width="10%" align="left">
					<b>是否隐藏</b>
				</td>
				<td width="10%" align="left">
					<b>显示顺序</b>
				</td>
				<td width="8%" align="center">
					<b>新增子栏目</b>
				</td>
				<td width="5%" align="center">
					<b>修改</b>
				</td>
				<td width="5%" align="center">
					<b>删除</b>
				</td>
			</tr>
			<%
				String ch_id = "", ch_name = "", up_ch_id = "", ch_level = "", state_code = "",show_no="",ch_desc="",cust_Id="";
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						HashMap map = (HashMap) list.get(i);
						if (map.get("cust_id") != null) {cust_Id = map.get("cust_id").toString();}
						if (map.get("ch_id") != null) {ch_id = map.get("ch_id").toString();}
						if (map.get("ch_name") != null) {ch_name = map.get("ch_name").toString();}
						if (map.get("up_ch_id") != null) {up_ch_id = map.get("up_ch_id").toString();}
						if (map.get("ch_level") != null) {ch_level = map.get("ch_level").toString();}
						if (map.get("state_code") != null) {state_code = map.get("state_code").toString();
							if(state_code.equals("0"))state_code="显示";
							else if(state_code.equals("1"))state_code="隐藏";}
						if (map.get("show_no") != null) {show_no = map.get("show_no").toString();}
						if (map.get("ch_desc") != null) {ch_desc = map.get("ch_desc").toString();}
						int bool = channel.getBooChSon(ch_id,cust_Id);
						String ch_namex = "";
						if (up_ch_id.equals("0000000000") ){
							ch_namex ="无上级";
						}
						else
							ch_namex = channel.getChName(up_ch_id);
			%>
						<tr class="u2">
							<td align="left">
								<b><%=i+1%></b>
							</td>
							<td align="left">
								<%=ch_id%>
							</td>
							<td align="left">
							<%
								if(bool==1){ 
							%>
								<a href="index.jsp?ch_id=<%=ch_id%>" title="点击进入子栏目！"><%=ch_name%></a>
							<%
								}else if(bool==0){ 
							%>
								<font color="black"><%=ch_name%></font>
							<%
								} 
							%>
								
							</td>
							<td  align="left">
								<%=ch_namex%>
							</td>
							<td  align="center">
								<%=ch_level%>
							</td>
							<td  align="center">
								<%=state_code%>
							</td>
							<td  align="center">
								<%=show_no%>
							</td>
							<td  align="center">
								<a href="addNewChannel.jsp?ch_id=<%=ch_id%>&up_ch_level=<%=String.valueOf(Integer.parseInt(up_ch_level)+1)%>" ><img src="/admin/images/add.gif" width="16" height="16" border="0" alt="新增下级栏目"></a>
							</td>
							<td  align="center">
								<a href="modifyChannel.jsp?ch_id=<%=ch_id%>" ><img src="/admin/images/details.gif" width="16" height="16" border="0" alt="修改栏目"></a>
							</td>
							<td  align="center">
							<%
								if(bool==1){ 
							%>
								<img src="/admin/images/delete.gif" width="16" height="16" border="0" onclick="javascript:alert('此栏目有子栏目，不可删除！');"  style="cursor:hand;" alt="此栏目有子栏目，不可删除！"> 
							<%
								}else if(bool==0){ 
							%>
								<a href="/doTradeReg.do?ch_id=<%=ch_id%>&trade_type_code=0013" target="_self" ><img src="/admin/images/delete.gif" width="16" height="16" border="0" alt="删除栏目"></a>
							<%
								} 
							%>
							</td>
						</tr>
			<%
					}
				}
			%>
			
		</table>	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr class="u1">
				<%=pageTools%>
			</tr>
		</table>
	</body>
</html>



