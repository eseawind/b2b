<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("mysqlbase.rootpath");
	
	ChannelInfo info = new ChannelInfo();
	String select = info.getChannelItems("0000000000");
	
%>
<html>
	<head>
		<title>更新栏目</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    	document.getElementById("proDiv").style.display = "block";
		    	document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>正在生成，请稍等，这可能要花费您几分钟时间............</font>';
		    	var code = document.getElementById('code').value;
		    	var ch_id = document.getElementById('ch_id').value;
	    	  var yesRadio = document.forms[0].yes;   
				  var yes = '';
				  for(var i = 0;i<yesRadio.length;i++){   
	          if(yesRadio[i].checked == true){
	          	yes = yesRadio[i].value;
	        	}
          }   
		    	var data = Math.round(Math.random() * 10000);
					var myAjax = new Ajax.Updater('proDiv',
					'ajaxCreate.jsp?ch_id='+ch_id+'&code='+code+'&date='+data+'&yes='+yes,{
						method : 'get',
						evalScripts : true
					});
		   }
		</script>
	</head>
	<body>
		<form name="createForm" id="createForm" action=createChannel.jsp method=post target="_self">
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="P8wPm44FU4py6dk" />
			</jsp:include>
			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
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
										<table>
											<tr>
												<td colspan="2"><input type="radio" name="yes" value="1" checked="checked">更新所选栏目首页、列表页、分类列表页、地区列表页 </td>
											</tr>
											<tr>
												<td colspan="2"><input type="radio" name="yes" value="0" >更新所选栏目及子栏目首页、列表页、分类列表页、地区列表页</td>
											</tr>
											<tr>
												<td><input type="radio" name="yes" value="2" >更新所选栏目地区列表页 </td>
												<td><input type="radio" name="yes" value="3" >更新所选栏目分类列表页 </td>
											</tr>
											<tr>
												<td><input type="radio" name="yes" value="4" >仅更新所选栏目列表页 </td>
												<td><input type="radio" name="yes" value="5" >仅更新所选栏目首页 </td>
											</tr>
											</table>

									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="2" id="code">
									<input name="submit" type="button" value="开始生成html" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td>
									<div id="proDiv" style="display: none;">
										<img src="/images/wait.gif" border="0"><font size="3">您好,栏目正在生成...大约需5分钟,请耐心等待</font>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


