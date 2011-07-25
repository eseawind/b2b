<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>农业企业信息化服务平台</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript">
		  function setDatas(type){
		    document.getElementById("createType").value=type;
		  }
		</script>
	</head>
	<body>
		<br><br><br>
		<form name="creatform" method="post" id="creatform" action="build.jsp" target="_blank">
		<table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>前台页面生成</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width="500" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
				<tr class="u4" height="25">
					<td width="60%">
						生成页面所在位置					</td>
					<td width="40%">
						执行					</td>
				</tr>
				<!---生成说明   createType为生成类型: 0:首页 1:供应信息 2:求购信息  3：企业库  4:资讯 5:人才库 6:学院 7:企业管理 8:建材资讯---->
				<!---0:首页---->
				<tr class="u6">
					<td>
						网站首页<input name="createType" type="hidden" id="createType" value="0">
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('0')">
					</td>
				</tr>
				<!---1:供应信息---->
				<tr class="u6">
					<td>
						供应首页
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('1')">
					</td>
				</tr>

				<!---2:求购信息---->

				<tr class="u6">
					<td>
						求购首页
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('2')">
					</td>
				</tr>
				<!---3:企业库---->
				<tr class="u6">
					<td>
						企业库首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('3')">
					</td>
				</tr>
				<!---5:人才库---->
				<tr class="u6">
					<td>
						人才首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('5')">
					</td>
				</tr>
				<!---6:学院---->
				<tr class="u6">
					<td>
						学院首页
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('6')">
					</td>
				</tr>	
				<!---8:资讯首页---->
				<tr class="u6">
					<td>
						资讯首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('8')">
					</td>
				</tr>
				<!---9:建材评测频道首页---->
				<tr class="u6">
					<td>
						评测首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('9')">
					</td>
				</tr>
				<!---10:图书首页---->
				<tr class="u6">
					<td>
						图书首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('10')">
					</td>
				</tr>
				<!---11:行情首页---->
				<tr class="u6">
					<td>
						行情首页
					</td>
					<td>
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('11')">
					</td>
				</tr>
		  </table>
		</form>
	</body>
</html>



