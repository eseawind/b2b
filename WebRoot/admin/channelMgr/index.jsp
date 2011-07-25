<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	String iStart = "1";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	String ch_idx = "0000000000";
	if (request.getParameter("ch_id") != null) {
		ch_idx = request.getParameter("ch_id");
	}
	int counter = 0;
	String pageTools = "";

	ChannelInfo channel = new ChannelInfo();
	ArrayList list = new ArrayList();

	list = channel.getChannelInfos(Integer.valueOf(iStart).intValue(),ch_idx);
	counter = channel.getChannelInfos(ch_idx);

	pageTools = tools.getPageTools(String.valueOf(counter), "30","index.jsp?ch_id=" + ch_idx + "&iStart=", Integer.parseInt(iStart));
	
	String up_ch_level  = channel.getUpChannelLevel(ch_idx);
%>
<html>
	<head>
		<title>栏目频道管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ChannelInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="addNewChannel.jsp?ch_id=0000000000"><b>新增栏目管理</b></a>
				</td>
			</tr>
		</table>
		<table bgcolor="#FCB0B0" width="100%" cellpadding="1" align="center" cellspacing="1" border="0">
			
			<tr class="u4" height="25">
				<td width="5%" align="left">
					<b>序号</b>
				</td>
				<td width="10%" align="left">
					<b>频道标识</b>
				</td>
				<td width="10%" align="left">
					<b>频道名称</b>
				</td>
				<td width="10%" align="left">
					<b>上级频道</b>
				</td>
				<td width="10%" align="left">
					<b>频道级别</b>
				</td>
				<td width="10%" align="left">
					<b>是否隐藏</b>
				</td>
				<td width="10%" align="left">
					<b>显示顺序</b>
				</td>
				<td width="10%" align="center">
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
				String ch_id = "", ch_name = "", up_ch_id = "", ch_level = "", state_code = "",show_no="",ch_desc="";
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						HashMap map = (HashMap) list.get(i);
						if (map.get("ch_id") != null) {ch_id = map.get("ch_id").toString();}
						if (map.get("ch_name") != null) {ch_name = map.get("ch_name").toString();}
						if (map.get("up_ch_id") != null) {up_ch_id = map.get("up_ch_id").toString();}
						if (map.get("ch_level") != null) {ch_level = map.get("ch_level").toString();}
						if (map.get("state_code") != null) {state_code = map.get("state_code").toString();
							if(state_code.equals("0"))state_code="显示";
							else if(state_code.equals("1"))state_code="隐藏";}
						if (map.get("show_no") != null) {show_no = map.get("show_no").toString();}
						if (map.get("ch_desc") != null) {ch_desc = map.get("ch_desc").toString();}
						int bool = channel.getBooChSon(ch_id);
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
							<td  align="left">
								<%=ch_level%>
							</td>
							<td  align="left">
								<%=state_code%>
							</td>
							<td  align="left">
								<%=show_no%>
							</td>
							<td  align="center">
								<a href="addNewChannel.jsp?ch_id=<%=ch_id%>&up_ch_level=<%=String.valueOf(Integer.parseInt(up_ch_level)+1)%>" ><img src="/admin/images/add.gif" width="16" height="16" border="0" alt="新增下级频道"></a>
							</td>
							<td  align="center">
								<a href="modifyChannel.jsp?ch_id=<%=ch_id%>" ><img src="/admin/images/details.gif" width="16" height="16" border="0" alt="修改频道"></a>
							</td>
							<td  align="center">
							<%
								if(bool==1){ 
							%>
								<img src="/admin/images/delete.gif" width="16" height="16" border="0" onclick="javascript:alert('此频道有子频道，不可删除！');"  style="cursor:hand;" alt="此频道有子频道，不可删除！"> 
							<%
								}else if(bool==0){ 
							%>
								<a href="/doTradeReg.do?ch_id=<%=ch_id%>&trade_type_code=0010" target="_self" ><img src="/admin/images/delete.gif" width="16" height="16" border="0" alt="删除频道"></a>
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
			<%if(!ch_idx.equals("0000000000")){%>
			<tr >
			     <td colspan="11">
			     	<center>
			     		<img src="/admin/images/comeback.JPG" onClick="location.href='index.jsp'" style="cursor:hand;">
			    	</center>
			     </td>
			</tr>
			<%}%>
		</table>
	</body>
</html>




