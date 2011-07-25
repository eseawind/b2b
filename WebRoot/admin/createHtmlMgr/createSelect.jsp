<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>

<html>
	<head>
		<title>更新蜒索</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    document.getElementById("proDiv").style.display = "block";
		    document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0>正在更新............';
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
<input name="submit" type="button" value="更新搜索" onclick="return check_Value()">
[注：更新搜索功能将及时更新客户发布的信息，使全站搜索能及时搜到当前客户发布的信息]
<div id="proDiv" style="display: none;"><img src="/images/wait.gif" border="0">正在更新............</div>

	</body>
</html>


