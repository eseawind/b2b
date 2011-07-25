<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("ecms_path");
	String savepath = configFile.getString( "templates_save_path" );
	String cust_id="",save_dir = "";
	if (session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
		save_dir = savepath + cust_id;
	}
	
	ChannelColumnInfo info = new ChannelColumnInfo();
	String select = info.getChannelItems("0000000000",cust_id);
	
	String ch_id = "",yes="";
	if (request.getParameter("ch_id") != null)
	{
		ch_id = request.getParameter("ch_id");
	}
	if (request.getParameter("yes") != null)
	{
		yes = request.getParameter("yes");
	}
	String default_page = "";
	ArrayList list = info.getChannel(ch_id,cust_id);
	if (list != null && list.size() > 0) {
		HashMap map = (HashMap)list.get(0);
		if(map.get("save_dir") != null)
			save_dir = map.get("save_dir").toString();
		if(map.get("default_page") != null)
			default_page = map.get("default_page").toString();
	}

	String code = "";
	if (request.getParameter("code") != null)
	{
		code = request.getParameter("code");
	}
	String showEnd = "none";
	if(code.equals("1"))
	{
		showEnd = "block";
	}
	 
%>

<html>
	<head>
		<title>更新栏目</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value()
		  {		  		
		  		var data = Math.round(Math.random() * 10000);
		  		var ch_id = document.getElementById("ch_id").value;
		  		var yes = document.getElementById("yes").value;
					document.getElementById("proDiv").style.display = "block";
					document.getElementById("proDiv").innerHTML = "<img src=/images/wait.gif border=0><font size=3>正在生成栏目............</font>";
					
					var data = Math.round(Math.random() * 10000);
					var myAjax = new Ajax.Updater('proDiv',
					'CreateCust.jsp?ch_id='+ch_id+'&yes='+yes+'&date='+data,{
						method : 'get',
						evalScripts : true
					});
		  }
		</script>
	</head>
	<body>
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
										<select id="ch_id" name="ch_id" onchange="">
											<option value="0000000000">更新所有栏目...</option>
											<%=select%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="15%">
									是否更新子栏目：
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<input type="radio" id="yes" name="yes" value="0" checked="checked">更新子级栏目
										<input type="radio" id="yes" name="yes" value="1">仅更新所选栏目
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="1" id="code">
									<input name="button" type="button" value="开始生成html" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
							<tr>
								<td>
									<div id="proDiv" style="display: none;">
										<img src="/images/wait.gif" border="0"><font size="3">正在生成栏目............</font>
									</div>

								</td>
							</tr>
							
						</table>
					</td>
				</tr>
			</table>
	</body>
</html>


