<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	
	ChannelInfo info = new ChannelInfo();
	String select = info.getChannelItems("0000000000");
	


%>
<html>
	<head>
		<title>更新文档</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    	document.getElementById("proDiv").style.display = "block";
		    	document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>正在生成，请稍等，这可能要花费您几分钟时间............</font>';
		    	var code = document.getElementById('code').value;
		    	var ch_id = document.getElementById('ch_id').value;
		    	var born_type = document.forms[0].born_type;   
				var born_t = '';
				for(var i = 0;i<born_type.length;i++)
				{   
	          		if(born_type[i].checked == true)
					{
	          		born_t = born_type[i].value;
	        	}
          }  
          out.print(born_t); 
		    	var data = Math.round(Math.random() * 10000);
					var myAjax = new Ajax.Updater('proDiv',
					'ajaxCreate.jsp?ch_id='+ch_id+'&code='+code+'&date='+data+'&born_type='+born_t,{
						method : 'get',
						evalScripts : true
					});
		   }
		</script>
	</head>
	<body>
		<form name="createForm" id="createForm" action=creatArticle.jsp method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td class="u1" width="15%">
									选择栏目：
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<select id="ch_id" name="ch_id">
											<option value="0000000000">更新所有文档...</option>
											<%=select%>
										</select>
									</div>
								</td>
							</tr>
							<tr bgcolor="white">
								<td class="u1" width="15%">
									选择生成方式:
								</td>
								<td class="u2" width="85%">
									<input type="radio" name="born_type" value="1" checked>全量生成
									<input type="radio" name="born_type" value="2">增量生成
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="1" id="code">
									<input name="submit" type="button" value="开始生成html" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td>
									<div id="proDiv" style="display: none;">
										<img src="/images/wait.gif" border="0"><font size="3">正在生成，请稍等，这可能要花费您几分钟时间............</font>
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


