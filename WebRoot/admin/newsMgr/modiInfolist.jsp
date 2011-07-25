<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.infoListMgr.*" %>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String class_id = "",news_id ="";
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	if (request.getParameter("news_id") != null) {
		news_id = request.getParameter("news_id").toString();
	}
	
	String class_name = proInfo.getClassNameById(class_id);
	
	String title = "",contents= "",mimi_title="",src="",read_right="",other_tag="",author="",
	tag="",user_temp="",pub_date="",title_color="",create_tag="",message_tag="",
	info_dsec="",info_key="",log_tag="";
	String one = "",two ="",three ="";
	InfoList infolist = new InfoList();
	ArrayList list = infolist.getInfoListById(news_id);
	if (list != null && list.size()>0){
		HashMap map = (HashMap)list.get(0);
		if(map.get("title")!=null){title=map.get("title").toString();}
		if(map.get("contents")!=null){contents=map.get("contents").toString();}
			if(contents.equals("000")){
				one = "0"; two = "0"; three = "0";
			}else if (contents.equals("001")){
				one = "0"; two = "0"; three = "1";
			}else if (contents.equals("010")){
				one = "0"; two = "1"; three = "0";
			}else if (contents.equals("100")){
				one = "1"; two = "0"; three = "0";
			}else if (contents.equals("011")){
				one = "0"; two = "1"; three = "1";
			}else if (contents.equals("101")){
				one = "1"; two = "0"; three = "1";
			}else if (contents.equals("110")){
				one = "1"; two = "1"; three = "0";
			}else if (contents.equals("111")){
				one = "1"; two = "1"; three = "1";
			}
		if(map.get("mimi_title")!=null){mimi_title=map.get("mimi_title").toString();}
		if(map.get("src")!=null){src=map.get("src").toString();}
		if(map.get("author")!=null){author=map.get("author").toString();}
		if(map.get("tag")!=null){tag=map.get("tag").toString();}
		if(map.get("user_temp")!=null){user_temp=map.get("user_temp").toString();}
		if(map.get("pub_date")!=null){pub_date=map.get("pub_date").toString();}
			pub_date = pub_date.substring(0,10);
		if(map.get("title_color")!=null){title_color=map.get("title_color").toString();}
		if(map.get("create_tag")!=null){create_tag=map.get("create_tag").toString();}
		if(map.get("message_tag")!=null){message_tag=map.get("message_tag").toString();}
		if(map.get("info_dsec")!=null){info_dsec=map.get("info_dsec").toString();}
		if(map.get("info_key")!=null){info_key=map.get("info_key").toString();}
		if(map.get("log_tag")!=null){log_tag=map.get("log_tag").toString();}
		if(map.get("read_right")!=null){read_right=map.get("read_right").toString();}
			read_right = comm.getItemsBySelected("117",read_right);
		if(map.get("other_tag")!=null){other_tag=map.get("other_tag").toString();}
			other_tag = comm.getItemsBySelected("120",other_tag);
	}
%>
<html>
	<head>
		<title></title>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>
	<body>
		<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" id="bo1"  style="display: none">
			<tr>
				<td width="111" class="u1">
					信息标题：
				</td>
				<td width="278" class="u2">
					<input name="title" id="title" type="text" value="<%=title%>" size=30 maxlength=70>
				</td>
				<td width="114" class="u1">
					显示属性：
				</td>
				<td width="280" class="u2">
					<input type="checkbox" name="one" id="one" value="<%=one%>" <%if(one.equals("1")){%>checked="checked"<%}%> onclick="clickSel(this.value,this.id)">
					推荐
					<input type="checkbox" name="two" id="two" value="<%=two%>" <%if(two.equals("1")){%>checked="checked"<%}%> onclick="clickSel(this.value,this.id)">
					加粗
					<input type="checkbox" name="three" id="three" value="<%=three%>" <%if(three.equals("1")){%>checked="checked"<%}%> onclick="clickSel(this.value,this.id)">
					<!--跳转网址
					<input type="hidden" name="contents" id="contents" value="">-->
				</td>
			</tr>
			<tr>
				<td class="u1">
					简略标题：
				</td>
				<td class="u2">
					<input name="mimi_title" id="mimi_title" type="text" value="<%=mimi_title%>" size="30">
				</td>
				<td class="u1">
					信息来源：
				</td>
				<td class="u2">
					<input name="src" id="src" type="text" size="30" value="<%=src%>">
				</td>
			</tr>
			<tr>
				<td class="u1">
					信息作者：
				</td>
				<td class="u2">
					<input name="author" id="author" type="text" size="30" value="<%=author%>">
				</td>
				<td class="u1">
					缩略图：
				</td>
				<td class="u2">
					<input name="mini_img" id="mini_img" type="hidden">
					<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
						<iframe src="/inc/uploadImg.jsp?root_id=<%=news_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					</div>
				</td>
			</tr>
			<tr>
				<td class="u1">
					最后归属栏目：
				</td>
				<td class="u2">
					<input type="hidden" name="ch_id" id="ch_id" size="30" value="<%=class_id%>">
					<input type="text" name="class_name" value="<%=class_name%>" readonly="readonly">
				</td>
				<td class="u1">
					tag标签：
				</td>
				<td class="u2">
					<input name="tag" id="tag" type="text" size="30" value="<%=tag%>">
				</td>
			</tr>
			<tr>
				<td class="u1">
					自定义模板：
				</td>
				<td class="u2">
					<input name="user_temp" id="user_temp" type="text" size="30" value="<%=user_temp%>">
				</td>
				<td class="u1">
					发布时间：
				</td>
				<td class="u2">
					<input name="pub_date" id="pub_date" type="text" size="30" value="<%=pub_date%>" onfocus="setday(this);">
				</td>
			</tr>
			<tr>
				<td class="u1">
					标题颜色：
				</td>
				<td class="u2">
					<input name="title_color" id="title_color" type="text" size="15" value="<%=title_color%>">
					<input name="modcolor" type="button" id="modcolor" value="选取" onClick="ShowColor()">
				</td>
				<td class="u1">
					阅读权限：
				</td>
				<td class="u2">
					<select id="read_right" name="read_right">
						<%=read_right%>
					</select>
				</td>
			</tr>
			<tr>
				<td class="u1">
					发布选项：
				</td>
				<td class="u2">
					<input type="radio" name="create_tag" id="create_tag" value="0" <%if(create_tag.equals("0")){%>checked="checked"<%}%>>
					生成html
					<input type="radio" name="create_tag" id="create_tag" value="1" <%if(create_tag.equals("1")){%>checked="checked"<%}%>>
					动态浏览
				</td>
				<td class="u1">
					是否留言：
				</td>
				<td class="u2">
					<input type="radio" name="message_tag" id="message_tag" value="0" <%if(message_tag.equals("0")){%>checked="checked"<%}%>>
					支持
					<input type="radio" name="message_tag" id="message_tag" value="1" <%if(message_tag.equals("1")){%>checked="checked"<%}%>>
					不支持
				</td>
			</tr>
			<tr>
				<td class="u1">
					文档摘要：
				</td>
				<td class="u2">
					<textarea name="info_dsec" id="info_dsec" rows="4" cols="35"><%=info_dsec%></textarea>
				</td>
				<td class="u1">
					关键字：
				</td>
				<td class="u2">
					<textarea name="info_key" id="info_key" rows="4" cols="35"><%=info_key%></textarea>
				</td>
			</tr>
			<tr>
				<td class="u1">
					记录痕迹：
				</td>
				<td class="u2">
					<input type="radio" name="log_tag" id="log_tag" value="0" <%if(log_tag.equals("0")){%>checked="checked"<%}%>>
					记录
					<input type="radio" name="log_tag" id="log_tag" value="1" <%if(log_tag.equals("1")){%>checked="checked"<%}%>>
					不记录
				</td>
				<td class="u1">
					相关信息：
				</td>
				<td class="u2">
					<select name="other_tag" id="other_tag">
						<%=other_tag%>
					</select>
				</td>
			</tr>
		</table>
	</body>
</html>



