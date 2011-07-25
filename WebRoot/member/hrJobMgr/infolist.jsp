<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String class_id = "",news_id ="",channel_id="",title="",mimititle="";
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	if (request.getParameter("news_id") != null) {
		news_id = request.getParameter("news_id").toString();
	}

	if (request.getParameter("ch_id") != null ) 
	{
		channel_id = request.getParameter("ch_id").toString();
	}
	String cust_id="",cust_type="";
	if( session.getAttribute( "SESSION_CUST_ID" ) != null )
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	

	Custinfo custInfo=new Custinfo();
	ArrayList listc=new ArrayList();
	listc=	custInfo.getCustomerByCustId(cust_id);
	if(null!=listc&&listc.size()>0){
	HashMap map=(HashMap)listc.get(0);
	if(null!=map.get("cust_type"))
	 cust_type=map.get("cust_type").toString();
	}

	String read_right = comm.getSelectItems("117");
	String other_tag = comm.getSelectItems("120"); 
	
	Calendar cal = Calendar.getInstance();
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String class_name = proInfo.getClassNameById(class_id);
	
	ChannelColumnInfo info = new ChannelColumnInfo();
	String select = info.getChannelItems("0000000000",cust_id );
	
%>
<html>
	<head>
		<title></title>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/inc/upLoad.js"></script>
	</head>
	<body>
		<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" id="bo0" style="display:none">
			<tr>
				<td width="111" class="u1">
					信息标题：
				</td>
				<td width="278" class="u2" colspan=3 >
					
				</td>
				<td class="u1"style="display:none">
					所属栏目：
				</td>
				<td class="u2"style="display:none">
					<select id="cust_ch_id" name="cust_ch_id">
						<option value="000000000">选择栏目...</option>
						<%=select%>
					</select>
				</td>
			</tr>
			<input type="hidden" name="ch_id" id="ch_id" value="<%=channel_id%>">
			<tr >
				<td width="114" class="u1">
					显示属性：
				</td>
				<td width="280" class="u2"  colspan="3">
					<input type="checkbox" name="one" id="one" value="0" onClick="clickSel(this.value,this.id)">
					推荐
					<input type="checkbox" name="two" id="two" value="0" onClick="clickSel(this.value,this.id)">
					加粗
					<!--<input type="checkbox" name="three" id="three" value="0" onclick="clickSel(this.value,this.id)">
					跳转网址-->
					<input type="hidden" name="contents" id="contents">
				</td>
				<td class="u1" style="display:none">
					记录痕迹：
				</td>
				<td class="u2" style="display:none">
					<input type="radio" name="log_tag" id="log_tag" value="0" checked="checked">
					记录
					<input type="radio" name="log_tag" id="log_tag" value="1">
					不记录
				</td>
			</tr>
			<tr >
				<td class="u1">
					简略标题：
				</td>
				<td class="u2">
					<input name="mimi_title" id="mimi_title" type="text" size="30">
				</td>
				<%if(cust_type.equals("1")){%>
				<td class="u1">
					客户名称：
				</td>
				<td class="u2">
					<input name="src" id="src" type="text" size="30">
				</td>
					<%}else{%>
						<td class="u1">
					信息来源：
				</td>
				<td class="u2">
					<input name="src" id="src" type="text" size="30">
				</td>
				<%}%>
				<!---->
			
				<!---->
			</tr>
			<tr>
				<%if(cust_type.equals("1")){%>
				<td class="u1" >
					联系电话：
				</td>
				<td class="u2"  colspan="3">
					<input name="author" id="author" type="text" size="30">
				</td>
				<%}else{%>
				<td class="u1" >
					信息作者：
				</td>
				<td class="u2"  colspan="3">
					<input name="author" id="author" type="text" size="30">
				</td>
				<%}%>
				<!---->
				
				<!---->
				<td class="u1" style="display:none">
					相关信息：
				</td>
				<td class="u2" style="display:none">
					<select name="other_tag" id="other_tag">
						<%=other_tag%>
					</select>
				</td>
				
			</tr>
			
			<tr style="display:none">
				<td class="u1">
					缩略图：
				</td>
				<td class="u2" colspan="3">
					<input name="mini_img" id="mini_img" type="hidden">
					<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
						<iframe src="/inc/uploadImg.jsp?root_id=<%=news_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					</div>
				</td>				
			</tr>
			
			<tr style="display:none">
				<td class="u1">
					最后归属栏目：
				</td>
				<td class="u2">
					<input type="text" name="class_name" value="<%=class_name%>" readonly="readonly">
				</td>
				<td class="u1">
					tag标签：
				</td>
				<td class="u2">
					<input name="tag" id="tag" type="text" size="30">
				</td>
			</tr>
			<tr style="display:none">
				<td class="u1">
					自定义模板：
				</td>
				<td class="u2">
					<input name="user_temp" id="user_temp" type="text" size="20">
					<input type="button" onClick="open('/admin/channelMgr/filelist.jsp?id=article_temp','file','width=400,height=200,htoolbar=0,status=0,scroll=yes')" value="浏览"/>	
				</td>
				<td class="u1">
					发布时间：
				</td>
				<td class="u2">
					<input name="pub_date" id="pub_date" type="text" size="30" value="<%=start_time%>" onFocus="setday(this);">
					<input name="in_date" id="in_date" type="hidden"  value="<%=start_time%>" >
				</td>
			</tr>
			<tr style="display:none">
				<td class="u1">
					标题颜色：
				</td>
				<td class="u2">
					<input name="title_color" id="title_color" type="text" size="15">
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
			<tr style="display:none">
				<td class="u1">
					发布选项：
				</td>
				<td class="u2">
					<input type="radio" name="create_tag" id="create_tag" value="0" checked="checked">
					生成html
					<input type="radio" name="create_tag" id="create_tag" value="1">
					动态浏览
				</td>
				<td class="u1">
					是否留言：
				</td>
				<td class="u2">
					<input type="radio" name="message_tag" id="message_tag" value="0" checked="checked">
					支持
					<input type="radio" name="message_tag" id="message_tag" value="1">
					不支持
				</td>
			</tr>
			<tr>
				<td class="u1">
					文档摘要：
				</td>
				<td class="u2"  colspan="3">
					<textarea name="info_dsec" id="info_dsec" rows="4" cols="35"></textarea>
				</td>
				<td class="u1" style="display:none">
					关键字：
				</td>
				<td class="u2" style="display:none">
					<textarea name="info_key" id="info_key" rows="4" cols="35"></textarea>
				</td>
			</tr>
		</table>
	</body>
</html>




