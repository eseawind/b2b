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
	

%>
<html>
	<head>
		<title>栏目频道管理</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">

	</head>
	<body>
	
		<table bgcolor="#98D9A2" width="100%" cellpadding="1" align="center" cellspacing="1" border="0">
			<tr class="u4" height="25">
				<td width="80%" align="left">
					<b>频道名称</b>
				</td>
				<td width="10%" align="center">
					<b>新增信息</b>
				</td>
				<td width="10%" align="center">
					<b>查看信息</b>
				</td>
			</tr>
			<%
				String ch_id = "", ch_name = "", up_ch_id = "",cont_mod = "", ch_level = "", state_code = "",show_no="",ch_desc="",cust_Id="";
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						HashMap map = (HashMap) list.get(i);
						if (map.get("cust_id") != null) {cust_Id = map.get("cust_id").toString();}
						if (map.get("ch_id") != null) {ch_id = map.get("ch_id").toString();}
						if (map.get("ch_name") != null) {ch_name = map.get("ch_name").toString();}
						if (map.get("cont_mod") != null) {cont_mod = map.get("cont_mod").toString();}
						if(cont_mod.equals("7") || cont_mod.equals("8")  ){
			%>
						<tr class="u2">
							<td  align="left">
								<%=ch_name%>
							</td>
							<td  align="center">
								<a href="ProcessAdd.jsp?ch_id=<%=ch_id%>"><img src="/admin/images/add.gif" width="16" height="16" border="0"></a>
							</td>
							<td  align="center">
								<a href="repositoryList.jsp?ch_id=<%=ch_id%>" ><img src="/admin/images/details.gif" width="16" height="16" border="0" alt="修改频道"></a>
							</td>
						</tr>
			
			
			<%
						}
					}
				}
			%>
			
		</table>	
	</body>
</html>




