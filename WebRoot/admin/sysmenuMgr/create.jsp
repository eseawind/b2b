<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>ũҵ��ҵ��Ϣ������ƽ̨</title>
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
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>ǰ̨ҳ������</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width="500" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
				<tr class="u4" height="25">
					<td width="60%">
						����ҳ������λ��					</td>
					<td width="40%">
						ִ��					</td>
				</tr>
				<!---����˵��   createTypeΪ��������: 0:��ҳ 1:��Ӧ��Ϣ 2:����Ϣ  3����ҵ��  4:��Ѷ 5:�˲ſ� 6:ѧԺ 7:��ҵ���� 8:������Ѷ---->
				<!---0:��ҳ---->
				<tr class="u6">
					<td>
						��վ��ҳ<input name="createType" type="hidden" id="createType" value="0">
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('0')">
					</td>
				</tr>
				<!---1:��Ӧ��Ϣ---->
				<tr class="u6">
					<td>
						��Ӧ��ҳ
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('1')">
					</td>
				</tr>

				<!---2:����Ϣ---->

				<tr class="u6">
					<td>
						����ҳ
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('2')">
					</td>
				</tr>
				<!---3:��ҵ��---->
				<tr class="u6">
					<td>
						��ҵ����ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('3')">
					</td>
				</tr>
				<!---5:�˲ſ�---->
				<tr class="u6">
					<td>
						�˲���ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('5')">
					</td>
				</tr>
				<!---6:ѧԺ---->
				<tr class="u6">
					<td>
						ѧԺ��ҳ
					</td>
					
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('6')">
					</td>
				</tr>	
				<!---8:��Ѷ��ҳ---->
				<tr class="u6">
					<td>
						��Ѷ��ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('8')">
					</td>
				</tr>
				<!---9:��������Ƶ����ҳ---->
				<tr class="u6">
					<td>
						������ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('9')">
					</td>
				</tr>
				<!---10:ͼ����ҳ---->
				<tr class="u6">
					<td>
						ͼ����ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('10')">
					</td>
				</tr>
				<!---11:������ҳ---->
				<tr class="u6">
					<td>
						������ҳ
					</td>
					<td>
						<input type="submit" name="Submit22" value=" �� �� " onclick="setDatas('11')">
					</td>
				</tr>
		  </table>
		</form>
	</body>
</html>



