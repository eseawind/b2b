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
		<title>������Ŀ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    	document.getElementById("proDiv").style.display = "block";
		    	document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>�������ɣ����Եȣ������Ҫ������������ʱ��............</font>';
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
									ѡ����Ŀ��
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<select id="ch_id" name="ch_id" onchange="">
											<option value="0000000000">����������Ŀ...</option>
											<%=select%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="15%">
									�Ƿ��������Ŀ��
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<table>
											<tr>
												<td colspan="2"><input type="radio" name="yes" value="1" checked="checked">������ѡ��Ŀ��ҳ���б�ҳ�������б�ҳ�������б�ҳ </td>
											</tr>
											<tr>
												<td colspan="2"><input type="radio" name="yes" value="0" >������ѡ��Ŀ������Ŀ��ҳ���б�ҳ�������б�ҳ�������б�ҳ</td>
											</tr>
											<tr>
												<td><input type="radio" name="yes" value="2" >������ѡ��Ŀ�����б�ҳ </td>
												<td><input type="radio" name="yes" value="3" >������ѡ��Ŀ�����б�ҳ </td>
											</tr>
											<tr>
												<td><input type="radio" name="yes" value="4" >��������ѡ��Ŀ�б�ҳ </td>
												<td><input type="radio" name="yes" value="5" >��������ѡ��Ŀ��ҳ </td>
											</tr>
											</table>

									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="2" id="code">
									<input name="submit" type="button" value="��ʼ����html" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td>
									<div id="proDiv" style="display: none;">
										<img src="/images/wait.gif" border="0"><font size="3">����,��Ŀ��������...��Լ��5����,�����ĵȴ�</font>
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


