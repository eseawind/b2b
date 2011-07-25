<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String up_ch_id = "";
	if(request.getParameter("ch_id") != null){
		up_ch_id = request.getParameter("ch_id");
	}else{
		up_ch_id = "0000000000";
	}
	ChannelInfo info = new ChannelInfo();
	String save_dir = info.getUpFilePath(up_ch_id);	
	
	String up_ch_level = "";
	if(request.getParameter("up_ch_level") != null)
	{
		up_ch_level = request.getParameter( "up_ch_level" );
	}
	else if(up_ch_id.equals("0000000000"))
	{
		up_ch_level = info.getUpChannelLevel(up_ch_id);
	}
	else 
	{
		up_ch_level  = String.valueOf(Integer.parseInt(info.getSelfChannelLevel(up_ch_id))+1) ;
		 
	}
	String ch_id = bean.GenNumTradeId();
	String right_tag = comm.getSelectItems("117");
	String cont_mod = comm.getSelectItems("118");
	
	String up_ch_name="";
	if(!up_ch_id.equals("")){
		up_ch_name = info.getChName(up_ch_id);
	}
	if(up_ch_name.equals("")){
		up_ch_name="���ϼ�Ƶ��";
	}
	
%>
<html>
	<head>
		<title>������Ŀ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/js/cnToEn.js"></script>
		<style type=text/css>
			.ec4 {
				CURSOR: hand;
				background:url(/images/wl_03.jpg);
				background-repeat:no-repeat;
				COLOR: #20539E;
				font-weight:bold;
				font-size: 14px;
			}
			.ec3 {
				CURSOR: hand; 
				background:url(/images/wl_02.gif); 
				background-repeat:no-repeat;
				COLOR: #DA6326; 
				font-weight:bold;
				font-size: 14px;
			}
	    </style>
		<script type="text/javascript">
		function showOne(){
			document.getElementById('sale-list').style.display ='block';
			document.getElementById('sale-new-list').style.display ='none';
		}
		function showTwo(){
			document.getElementById('sale-list').style.display ='none';
			document.getElementById('sale-new-list').style.display ='block';
		}
		function submitInfo(){
			if ($F('ch_name') == ''){
			 	alert("����дƵ������!"); 
				document.getElementById('ch_name').focus();
				return false;
			}
			var form1 = document.getElementById('menuForm');
			var i=0;
      if (form1.dir_pos[1].checked){
        document.getElementById("save_dir").value = '/'+ form1.dir.value;
      }else{
      	document.getElementById("save_dir").value = "<%=save_dir%>" + "/" + document.getElementById("dir").value;
    	}
			document.menuForm.submit();
		}
		function getSave_dir(){
			var save_dir = document.getElementById("save_dir");
			save_dir.value = "<%=save_dir%>" + "/" + document.getElementById("dir").value;
		}
		function showText(val){
			if(val==1){
				document.getElementById('default_pageA').style.display='block';
				document.getElementById('default_pageB').style.display='none';
			}
			if(val==2){
				document.getElementById('default_pageA').style.display='none';
				document.getElementById('default_pageB').style.display='block';	
			}
			if(val==3){
				document.getElementById('default_pageA').style.display='none';
				document.getElementById('default_pageB').style.display='none';	
			}
		}
		function setDefaultPageValue(val){
			if(val=='��������ת��ַ...' || val=='��������תҳ��...'){
				document.getElementById('default_page').value='';
			}else{
				document.getElementById('default_page').value=val;	
			}
		}
		</script>
	</head>
	<body>
		<form name="menuForm" id="menuForm" action="/doTradeReg.do" method="post" target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="index.jsp?ch_id=<%=up_ch_id%>"><b>��Ŀ����</b></a>
				</td>
			</tr>
		</table>
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>������Ŀ</b>
					</td>
				</tr>
			</table>
			<table width="100%" align="center">
				<tr align="center" style="display: none;">
					<td width="115" height="29" onclick="showOne()" align="center" class="ec4" style="padding-top:2"> ����ѡ�� </td>
					<td width="115" height="29" onclick="showTwo()" align="center" class="ec3" style="padding-top:2"> �߼�ѡ�� </td>
				</tr>
			</table>
			<div id="sale-list" style="display:block" align="center">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								Ƶ����ʶ��
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_id" type="text" id="ch_id" value="<%=ch_id%>" maxlength="15" size="20" readonly="readonly">
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								Ƶ�����ƣ�
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_name" type="text" id="ch_name" size="30" maxlength="50" onblur="CC2PY(this.value);">
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								�ϼ�Ƶ����
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="up_ch_id" type="hidden" id="up_ch_id" size="20" maxlength="15" value="<%=up_ch_id%>" readonly="readonly">
								<input name="up_ch_name" type="text" id="up_ch_name" size="20" maxlength="15" value="<%=up_ch_name%>" readonly="readonly">
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								Ƶ������
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_level" type="text" id="ch_level" size="15" maxlength="20" value="<%=up_ch_level%>" onkeyup="if(isNaN(value))execCommand('undo')" readonly="readonly">
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								�Ƿ�������Ŀ��
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="state_code" type="radio" id="state_code" checked="checked" value="0">��ʾ
								<input name="state_code" type="radio" id="state_code" value="1">����
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								��ʾ˳��
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="show_no" type="text" id="show_no" size="15" maxlength="50" value="1" onkeyup="if(isNaN(value))execCommand('undo')">(�ɵ� -> ��)
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								���Ȩ�ޣ�
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<select id="right_tag" name="right_tag">
									<%=right_tag%>
								</select>
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								�ļ�����Ŀ¼��
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<span style="display:block;" id="file_save"><%=save_dir+"/"%></span><input name="dir" type="text" id="dir" size="30" maxlength="100" onChange="getSave_dir()">
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								Ŀ¼λ�ã�
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="dir_pos" type="radio" id="dir_pos1" checked="checked" value="0" onclick="javascript:document.getElementById('file_save').style.display='block';">�ϼ�Ŀ¼
								<input name="dir_pos" type="radio" id="dir_pos2" value="1" onclick="javascript:document.getElementById('file_save').style.display='none';">վ���Ŀ¼
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								����ģ�ͣ�
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<select id="cont_mod" name="cont_mod">
									<%=cont_mod%>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								Ĭ��ҳ��
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="default_page" type="text" id="default_page" size="30" maxlength="100">
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								��ϸҳ��ģ�壺
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" name="article_temp" id="article_temp" size="40" maxlength="100">
								<input type="button" onClick="open('filelist.jsp?id=article_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="���"/>	
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								��ҳģ�壺
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" id="index_temp" name="index_temp" size="40" maxlength="100">
								<input type="button" onClick="open('filelist.jsp?id=index_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="���"/>	
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								�б�ģ�壺
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" name="list_temp" id="list_temp" size="40" maxlength="100">
								<input type="button" onClick="open('filelist.jsp?id=list_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="���"/>	
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#efefef">
							<div style=" text-align:right; font-weight:bold;">
								�ĵ�����
							</div>
						</td>
						<td width="75%" bgcolor="#FFFFFF" colspan="3">
							<div class="ping1">
								<input name="list_type" type="radio" id="list_type" checked="checked" value="0">����ʱ��
								<input name="list_type" type="radio" id="list_type" value="1">�����߼���
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								Ƶ�����ԣ�
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_attr" type="radio" id="ch_attr" checked="checked" value="0" onclick="showText(3)">�����б�ҳ�������ڱ�Ƶ�������������б�<br>
								<input name="ch_attr" type="radio" id="ch_attr" value="1" onclick="showText(3)">Ƶ�����棨��Ŀ�������Է�����Ϣ��<br>
								<input name="ch_attr" type="radio" id="ch_attr" value="2" onclick="showText(1)">����ҳ�棨��Ŀ�������Է�����Ϣ��<br>
								<input type="text" name="default_pageA" id="default_pageA" value="��������תҳ��..." onclick="this.value='';" size="30" maxlength="100" style="display:none;" onblur="setDefaultPageValue(this.value);">
								<input name="ch_attr" type="radio" id="ch_attr" value="3" onclick="showText(2)">��ת��ַ�����ļ�����Ŀ¼����д������ַ��
								<input type="text" name="default_pageB" id="default_pageB" value="��������ת��ַ..." onclick="this.value='';" style="display:none;" size="30" maxlength="100" onblur="setDefaultPageValue(this.value);">
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								��Ŀ����ͼ��
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="hidden" id="ch_img" name="ch_img">
								<iframe src="/inc/uploadImg.jsp?root_id=<%=ch_id%>" width="100%" height="180px" marginwidth="0"  frameborder=0 marginheight="0" scrolling="no"></iframe>
							</div>
						</td>
					</tr>
					
						<input name="index_view" type="hidden" id="index_view" value="0">
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								�ؼ��֣�
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<textarea id="ch_key" name="ch_key" rows="6" cols="50"></textarea>
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								��Ŀ˵����
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<textarea id="ch_desc" name="ch_desc" rows="6" cols="50"></textarea>
							</div>
						</td>
					</tr>
					<tr>
						
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="0008">
						<input name="state_code_date" type="hidden" id="state_code_date" value="">
						<input name="in_date" type="hidden" id="in_date" value="">
						<input name="remark" type="hidden" id="remark" value="">
						<input type="hidden" name="save_dir" id="save_dir" value="<%=save_dir%>"/>
						<img src="/admin/images/submit_0.gif" onclick="return submitInfo()" style="cursor: hand;">
						<img src="/admin/images/submit_1.gif" onClick="location.href='index.jsp?ch_id=<%=up_ch_id%>'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
				</table>
			</div>
			<div id="sale-new-list" style="display:none" align="center">
			</div>
		</form>
	</body>
</html>




