<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	  <script type="text/javascript" src="/js/prototype.js"></script>
		<style type="text/css">
			td{
					background-color:white;
			}
		</style>
		<script language="javascript">
			function Chick(){
				var imag = document.getElementById('excel').value;
				if (imag == null || imag == "") {
					alert("��ѡ��Ҫ�ϴ���Excel�ļ���");
					return false;
				} else {
					var pos = imag.lastIndexOf(".");
					var lastname = imag.substring(pos, imag.length)
					if (lastname.toLowerCase() == ".xls") {
						alert("���ϴ����ļ�����Ϊ" + lastname + "����ʽ���Ͳ���ȷ��");
						return false;
					}
				}
				document.getElementById("proDiv").style.display = "block";
		    document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>���ڵ��룬���Ե�............</font>';
		    var data = Math.round(Math.random() * 10000);
				var myAjax = new Ajax.Updater('proDiv',
				'ajaxInput.jsp?data='+data,{
					method : 'get',
					evalScripts : true
				});
		    	return true;
			}
		</script>
	</head>
	<body>
		<form name="createForm" id="createForm" action=excel.jsp method=post target="_self">
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
			<tr>
				<td class="u1">
						��ѡ����Ҫ�����Excel�ļ���
				</td>
				<td>
					<input type="hidden" id="excel" name="excel" value="excel">
					<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
						<iframe src="/inc/uploadAttr.jsp?idx=excel" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					</div>
				</td>
			</tr>
			<tr>
				<td class="u3" colspan="2">
					<input name="code" type="hidden" value="1" id="code">
					<input name="submit" type="button" value="�����Ա����" onclick="return Chick()">
				</td>
			</tr>
		</table>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
			<tr>
				<td>
					<div id="proDiv" style="display: none;"><img src="/images/wait.gif" border="0"><font size="3">���ڵ��룬���Ե�............</font></div>
				</td>
			</tr>
		</table>
		</form>
		<form name="cForm" id="cForm" action=excel.jsp method=post target="_self">
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0" style="display:none">
				<tr>
					<td>
						<input type="button" name="Submit22" value="������ҵվ" onclick="setDatas()">
						<div id="CustDiv" style="display: none;"><img src="/images/wait.gif" border="0"><font size="3">�������ɣ����Ե�............</font></div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



<script language="javascript">
  function setDatas(){
  	document.getElementById("CustDiv").style.display='block';
  	document.getElementById("CustDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>�������ɣ����Ե�............</font>';
    var dataa = Math.round(Math.random() * 10000);
		var myAjax = new Ajax.Updater('CustDiv',
		'creat.jsp?createType=1&data='+dataa,{
			method : 'get',
			evalScripts : true
		});
   }
</script>










