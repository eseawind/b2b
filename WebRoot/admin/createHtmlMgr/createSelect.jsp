<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>

<html>
	<head>
		<title>��������</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    document.getElementById("proDiv").style.display = "block";
		    document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0>���ڸ���............';
		    var data = Math.round(Math.random() * 10000);
				var myAjax = new Ajax.Updater('proDiv',
				'ajaxCreate.jsp?getselect=gengxin&data='+data,{
					method : 'get',
					evalScripts : true
				});
		    	return true;
		   }
		</script>
	</head>
	<body>
<input name="submit" type="button" value="��������" onclick="return check_Value()">
[ע�������������ܽ���ʱ���¿ͻ���������Ϣ��ʹȫվ�����ܼ�ʱ�ѵ���ǰ�ͻ���������Ϣ]
<div id="proDiv" style="display: none;"><img src="/images/wait.gif" border="0">���ڸ���............</div>

	</body>
</html>


