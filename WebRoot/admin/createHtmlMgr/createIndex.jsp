<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.intf.ChannelIntf"%>
<%
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("mysqlbase.rootpath");
	
%>
<html>
	<head>
		<title>������ҳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		    if($F("index_temp") =="" || $F("index_temp")==null){
		      alert("��ѡ����ҳģ�壡");
		      $("index_temp").focus();
		      return false;
		    }
		    if($F("save_dir") =="" || $F("save_dir")==null){
		      alert("��������ҳλ�ã�");
		      $("save_dir").focus();
		      return false;
		    }
		    if($F("default_page") =="" || $F("default_page")==null){
		      alert("������Ĭ��ҳ��");
		      $("default_page").focus();
		      return false;
		    }
		    document.getElementById("proDiv").style.display = "block";
		    document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>�������ɣ����Եȣ������Ҫ������������ʱ��............</font>';
		    var data = Math.round(Math.random() * 10000);
				var myAjax = new Ajax.Updater('proDiv',
				'ajaxCreate.jsp?index_temp='+$F("index_temp")+'&save_dir='+$F("save_dir")+'&default_page='+$F("default_page"),{
					method : 'get',
					evalScripts : true
				});
		    	return true;
		   }
		</script>
	</head>
	<body>
		<form name="createForm" id="createForm" action=createIndex.jsp method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td class="u1" width="15%">
									ѡ����ҳģ�壺
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<input type="text" id="index_temp" name="index_temp" value="templates/default/templates/index.html" size="40" maxlength="100" />
										<input type="button" onClick="open('/admin/channelMgr/filelist.jsp?id=index_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="���"/>	 &nbsp;&nbsp; &nbsp;(����ҳģ������λ�õĶ�Ӧ�ļ������ѡ�������ܻᵼ�������ҳ��ʾ������)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="15%">
									��ҳλ�ã�
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<input type="text" name="save_dir" id="save_dir" maxlength="100" value="/" /> &nbsp;&nbsp; &nbsp;(Ĭ��Ϊ��վ��Ŀ¼�����������޸�)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="15%">
									Ĭ��ҳ��
								</td>
								<td class="u2" width="85%">
									<div class="ping1">
										<input name="default_page" type="text" id="default_page" value="index.html" size="30" maxlength="100">&nbsp;&nbsp; &nbsp;(������ķ�������������Ӧ���ģ��������Ϥ����ѯ <a href=http://www.itonghui.com/bbs/index.php target=_blank><font color=red>��������� iTH </font></a>)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan="2">
									<input name="code" type="hidden" value="1" id="code">
									<input name="submit" type="button" value="������ҳhtml" onclick="return check_Value()">
								</td>
							</tr>
						</table>
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
							<tr>
								<td>
									<div id="proDiv" style="display: none;"><img src="/images/wait.gif" border="0"><font size="3">�������ɣ����Եȣ������Ҫ������������ʱ��............</font></div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


