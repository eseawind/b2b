<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	String cust_id="";
	if ( session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	config configFile = new config();
	configFile.init();
	
	
	ChannelColumnInfo info = new ChannelColumnInfo();
	String select = info.getChannelItems("0000000000",cust_id);
	
	String ch_id = "",yes="";
	if (request.getParameter("ch_id") != null){
		ch_id = request.getParameter("ch_id");
	}
	 
	String save_dir = "",default_page = "";
	
	ArrayList list = info.getChannel( ch_id,cust_id );
	if ( list != null && list.size() > 0 )
	{
		HashMap map = (HashMap)list.get(0);
		if(map.get("save_dir") != null)
			save_dir = map.get("save_dir").toString();
		if(map.get("default_page") != null)
			default_page = map.get("default_page").toString();	
	}
	
	if( save_dir.equals("") )
	{
		save_dir = configFile.getString("templates_save_path") + cust_id;
	}
	
	String code = "";
	if (request.getParameter("code") != null)
	{
		code = request.getParameter("code");
	}
	String showEnd = "none";
	if( code.equals( "1" ) )
	{
		showEnd = "block";
	}
	
%>
<html>
	<head>
		<title>更新文档</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value()
		  {
		  		var channel_id = document.getElementById("ch_id").value;
				/*if( channel_id == "0000000000" )
				{
					alert( "请选择要更新的栏目文档!");
					return false;
				} */
		    	document.getElementById("proDiv").style.display = "block";
		    	document.getElementById("proDiv1").style.display = "none";
		    	document.createForm.submit();
		    	return true;
		   }
		</script>
	</head>
	<body>
		<form name="createForm" id="createForm" action=creatArticle.jsp method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
							<tr>
								<td class="u1" width="15%">
									选择栏目：
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<select id="ch_id" name="ch_id">
											<option value="0000000000">更新文档...</option>
											<%=select%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="1" id="code">
									<input name="submit" type="submit" value="开始生成html" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
							<tr>
								<td>
									<div id="proDiv" style="display: none;">
										<img src="/images/wait.gif" border="0"><font size="3">正在生成栏目............</font>
									</div>
									<div id="proDiv1" style="display: <%=showEnd%>;">
										<font size="3">生成栏目结束............
										<a href="/<%=save_dir%>/<%=default_page%>" target="_blank" style="cursor: hand;"><font size="3">预览...</font></a><br>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<%
											if( !ch_id.equals("") )
											{
												CustCreateArticle article = new CustCreateArticle();
												article.CreateArticleList( ch_id, cust_id );
											}
										
									%>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


