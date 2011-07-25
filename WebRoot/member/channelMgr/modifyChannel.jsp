<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String cust_id="";
	if ( session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	String ch_id = "";
	if (request.getParameter("ch_id")!=null){
		ch_id = request.getParameter("ch_id");
	}
	
	ChannelColumnInfo info = new ChannelColumnInfo();
	ArrayList list = info.getChannel( ch_id , cust_id ); 
	
	String ch_name = "",up_ch_id="",ch_level="",state_code="",show_no="",right_tag="",
	save_dir="",dir_pos="",cont_mod="",default_page="",ch_attr="",index_temp="",list_temp="",
	article_temp="",ch_img="",list_type="",ch_key="",ch_desc="",index_view="";
	if( list != null && list.size() > 0 )
	{
		HashMap map = ( HashMap )list.get( 0 );
		if (map.get("ch_name")!=null){ch_name=map.get("ch_name").toString();}
		if (map.get("up_ch_id")!=null){up_ch_id=map.get("up_ch_id").toString();}
		if (map.get("ch_level")!=null){ch_level=map.get("ch_level").toString();}
		if (map.get("state_code")!=null){state_code=map.get("state_code").toString();}
		if (map.get("show_no")!=null){show_no=map.get("show_no").toString();}
		if (map.get("right_tag")!=null){right_tag=map.get("right_tag").toString();}
		if (map.get("save_dir")!=null){save_dir=map.get("save_dir").toString();}
		if (map.get("dir_pos")!=null){dir_pos=map.get("dir_pos").toString();}
		if (map.get("cont_mod")!=null){cont_mod=map.get("cont_mod").toString();}
		if (map.get("default_page")!=null){default_page=map.get("default_page").toString();}
		if (map.get("ch_attr")!=null){ch_attr=map.get("ch_attr").toString();}
		if (map.get("index_temp")!=null){index_temp=map.get("index_temp").toString();}
		if (map.get("list_temp")!=null){list_temp=map.get("list_temp").toString();}
		if (map.get("article_temp")!=null){article_temp=map.get("article_temp").toString();}
		if (map.get("ch_img")!=null){ch_img=map.get("ch_img").toString();}
		if (map.get("list_type")!=null){list_type=map.get("list_type").toString();}
		if (map.get("ch_key")!=null){ch_key=map.get("ch_key").toString();}
		if (map.get("ch_desc")!=null){ch_desc=map.get("ch_desc").toString();}
		if (map.get("index_view")!=null){index_view=map.get("index_view").toString();}
		right_tag = comm.getItemsBySelected("117",right_tag);
		cont_mod = comm.getItemsBySelected("119",cont_mod);
	}
	
	
	String default_pageAH="none",default_pageBH="none";
	if(ch_attr.equals("2")){
		default_pageAH = "block";
	}
	if(ch_attr.equals("3")){
		default_pageBH = "block";
	}

	String up_ch_name="";
	if(!up_ch_id.equals("")){
		up_ch_name = info.getChName(up_ch_id);
	}
	if(up_ch_name.equals("")){
		up_ch_name="无上级频道";
	}
	
	String up_save_dir="";
	if(!up_ch_id.equals("")){
		ArrayList up_list = info.getChannel(up_ch_id,cust_id); 
		if(up_list!=null && up_list.size()>0){
			HashMap up_map = (HashMap)up_list.get(0);
			if(up_map.get("save_dir")!=null){
				up_save_dir = up_map.get("save_dir").toString();
			}
		}
	}
%>
<html>
	<head>
		<title>栏目管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
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
			 	alert("请填写频道名称!"); 
				document.getElementById('ch_name').focus();
				return false;
			}
			document.menuForm.submit();
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
		
		function setSave_dir(val){
			var save_dir=document.getElementById('save_dir').value;
			var i=0;
			if(val==1){
				i = save_dir.lastIndexOf('/');
				save_dir = save_dir.substring(i,save_dir.length);
				document.getElementById('save_dir').value = save_dir;
			}
			if(val==0){
				if(document.getElementById('save_dir_again').value != ''){
					document.getElementById('save_dir').value = document.getElementById('save_dir_again').value+document.getElementById('save_dir').value;
				}else{
					document.getElementById('save_dir').value = document.getElementById('save_dir_cc').value;	
				}
			}
		}
		
		function showTip(){
			move.style.display='block';
			move.style.top=event.y;
			move.style.left=event.x;
		}
		function hiddenTip(){
			move.style.display='none';
		}
		
		</script>
	</head>
	<body>
		<div id="move" style="position:absolute;width:80;height;30;top:-30;left:-50;background-color:#EDF8FA;border:solid 1px #BED9E1;display:none;">请填写跳转网址！</div>
		
		<form name="menuForm" id="menuForm" action="/doTradeReg.do" method="post" target="_self">
			<input name="index_view" type="hidden" id="index_view" value="0">
			
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>修改栏目</b>
					</td>
				</tr>
			</table>
			<table width="100%" align="center">
				<tr align="center" style="display: none;">
					<td width="115" height="29" onclick="showOne()" align="center" class="ec4" style="padding-top:2"> 常规选项 </td>
					<td width="115" height="29" onclick="showTwo()" align="center" class="ec3" style="padding-top:2"> 高级选项 </td>
				</tr>
			</table>
			<div id="sale-list" style="display:block" align="center">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								频道标识：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_id" type="text" id="ch_id" value="<%=ch_id%>" maxlength="15" size="20">
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								频道名称：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_name" type="text" id="ch_name" value="<%=ch_name%>" size="30" maxlength="50">
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								上级频道：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="up_ch_id" type="hidden" id="up_ch_id" value="<%=up_ch_id%>" size="20" maxlength="15">
								<input name="up_ch_name" type="text" id="up_ch_name" value="<%=up_ch_name%>" size="20" maxlength="15">
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								频道级别：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_level" type="text" id="ch_level" value="<%=ch_level%>" size="15" maxlength="20" value="0" onkeyup="if(isNaN(value))execCommand('undo')">
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								是否隐藏栏目：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="state_code" type="radio" id="state_code" <%if(state_code.equals("0"))out.print("checked");%> value="0">显示
								<input name="state_code" type="radio" id="state_code" <%if(state_code.equals("1"))out.print("checked");%> value="1">隐藏
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								显示顺序：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="show_no" type="text" id="show_no" value="<%=show_no%>" size="15" maxlength="50" value="1" onkeyup="if(isNaN(value))execCommand('undo')">(由低 -> 高)
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								浏览权限：
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
								文件保存目录：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="save_dir" type="text" id="save_dir" value="<%=save_dir%>" size="40" maxlength="100">
								<input name="save_dir_cc" type="hidden" id="save_dir_cc" value="<%=save_dir%>" size="40" maxlength="100">
								<input name="save_dir_again" type="hidden" id="save_dir_again" value="<%=up_save_dir%>" />
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								目录位置：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="dir_pos" type="radio" id="dir_pos" <%if(dir_pos.equals("0"))out.print("checked");%> value="0" onclick="setSave_dir(0);">上级目录
								<input name="dir_pos" type="radio" id="dir_pos" <%if(dir_pos.equals("1"))out.print("checked");%> value="1" onclick="setSave_dir(1);">站点根目录
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								内容模型：
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
								默认页：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="default_page" type="text" id="default_page" value="<%=default_page%>" size="30" maxlength="100">
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								详细页面模板：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" name="article_temp" id="article_temp" value="<%=article_temp%>" size="40" maxlength="500">
								<input type="button" onClick="open('filelist.jsp?id=article_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="浏览"/>	
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#ffffff">
							<div style=" text-align:right; font-weight:bold;">
								首页模板：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" id="index_temp" name="index_temp" value="<%=index_temp%>" size="40" maxlength="100">
								<input type="button" onClick="open('filelist.jsp?id=index_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="浏览"/>	
							</div>
						</td>
						<td width="15%" bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								列表模板：
							</div>
						</td>
						<td width="35%" bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="text" name="list_temp" id="list_temp" value="<%=list_temp%>" size="40" maxlength="100">
								<input type="button" onClick="open('filelist.jsp?id=list_temp','file','height=400,width=400,toolbar=0,status=0,scroll=yes')" value="浏览"/>	
							</div>
						</td>
					</tr>
					<tr>
						<td width="15%" bgcolor="#efefef">
							<div style=" text-align:right; font-weight:bold;">
								文档排序：
							</div>
						</td>
						<td width="75%" bgcolor="#FFFFFF" colspan="3">
							<div class="ping1">
								<input name="list_type" type="radio" id="list_type" <%if(list_type.equals("0"))out.print("checked");%>  value="0">发布时间
								<input name="list_type" type="radio" id="list_type" <%if(list_type.equals("1"))out.print("checked");%>  value="1">发布者级别
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								频道属性：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input name="ch_attr" type="radio" id="ch_attr" <%if(ch_attr.equals("0"))out.print("checked");%> value="0" onclick="showText(3)">最终列表页（可以在本频道发布并生成列表）<br>
								<input name="ch_attr" type="radio" id="ch_attr" <%if(ch_attr.equals("1"))out.print("checked");%> value="1" onclick="showText(3)">频道封面（栏目本身不可以发布信息）<br>
								<input name="ch_attr" type="radio" id="ch_attr" <%if(ch_attr.equals("2"))out.print("checked");%> value="2" onclick="showText(1)">单独页面（栏目本身不可以发布信息）<br>

								<input type="text" name="default_pageA" id="default_pageA" value="<%=default_page%>" size="30" maxlength="100" style="display:<%=default_pageAH%>" onblur="javascript:document.getElementById('default_page').value=this.value;">

								<input name="ch_attr" type="radio" id="ch_attr" <%if(ch_attr.equals("3"))out.print("checked");%> value="3" onclick="showText(2)">跳转网址（在文件保存目录处填写完整网址）

								<br>
								<input type="text" name="default_pageB" id="default_pageB" value="<%=default_page%>" onmousemove="showTip();" onmouseout="hiddenTip()" style="display:<%=default_pageBH%>" size="30" maxlength="100" onblur="javascript:document.getElementById('default_page').value=this.value;">

							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								栏目缩略图：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<input type="hidden" id="ch_img" name="ch_img">
								<iframe src="/inc/uploadImg.jsp?root_id=<%=ch_id%>" width="100%" height="180px" marginwidth="0"  frameborder=0 marginheight="0" scrolling="no"></iframe>
							</div>
						</td>
					</tr>
					
					<tr>
						<td bgcolor="#efefef">
							<div style="text-align:right; font-weight:bold;">
								关键字：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<textarea id="ch_key" name="ch_key" rows="6" cols="40"><%=ch_key%></textarea>
							</div>
						</td>
						<td bgcolor="#ffffff">
							<div style="text-align:right; font-weight:bold;">
								栏目说明：
							</div>
						</td>
						<td bgcolor="#FFFFFF">
							<div class="ping1">
								<textarea id="ch_desc" name="ch_desc" rows="6" cols="40"><%=ch_desc%></textarea>
							</div>
						</td>
					</tr>
					<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="0012">
						<input name="state_code_date" type="hidden" id="state_code_date" value="">
						<input name="in_date" type="hidden" id="in_date" value="">
						<input name="remark" type="hidden" id="remark" value="">
						<img src="/admin/images/submit_0.gif" onclick="return submitInfo()" style="cursor: hand;">
					</td>
				</tr>
				</table>
			</div>
			<div id="sale-new-list" style="display:none" align="center">
			</div>
		</form>
	</body>
</html>



