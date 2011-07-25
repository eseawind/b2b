<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	 String news_id = "",ch_id="";
	 if ( request.getParameter("news_id") != null ) {
		news_id = request.getParameter( "news_id" );
	 }
	 if ( request.getParameter("ch_id") != null ) {
		ch_id = request.getParameter( "ch_id" );
	 }
	NewsInfo re = new NewsInfo();
	ArrayList alist = new ArrayList();
	alist = re.NewsByCHIDandID(ch_id,news_id);
	String title ="",content="",publish_date="",mini_img="";
	if(alist!=null){
			HashMap map = (HashMap)alist.get(0);
			if(map.get("mini_img")!=null){
				mini_img = map.get("mini_img").toString();
			}
			if(map.get("title")!=null){
				title = map.get("title").toString();
			}
			if(map.get("content")!=null){
				content = map.get("content").toString();
			}
			if(map.get("publish_date")!=null){
				publish_date = map.get("publish_date").toString();
			}
			if(publish_date.length()>10){
				publish_date = publish_date.substring(0,10);
			}
			if(mini_img==null || mini_img.equals("")){
				mini_img = "/images/cp.gif";
			}
	}
%>
<html>
	<head>
		<title>栏目频道管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

	</head>
	<body>
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
			<td width="10%" class="u1">
					<b>技术名称</b>
				</td>
				<td class="u2">
					<%=title%>
				</td>
			</tr>
			<tr>			
				<td class="u1">
					<b>技术内容</b>
				</td>
				<td class="u2">
					<%=content%>
				</td>
			</tr>
				<td class="u1">
					<b>时间</b>
				</td>
				<td class="u2">
					<%=publish_date%>
				</td>
				<td class="u1">
					<b>相关图片</b>
				</td>
				<td class="u2">
					<img src="<%=mini_img%>">
				</td>
				 <tr>
          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
          	 <a href="javascript:history.go(-1)">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
          </tr>
		</table>
	</body>
</html>

<script language="javascript">
		function ResizeImages()
		{
		   var myimg,oldwidth;
		   var maxwidth=200;
		   for(i=0;i<document.images.length;i++){
		     myimg = document.images[i];//得到页面中所有的图片信息
		     if(myimg.width > maxwidth)//若图片的宽度大于200，则将宽度设为200，高度是自动的"auto"
		     {
		        oldwidth = myimg.width;
		        myimg.style.width = maxwidth;
		        myimg.style.height = "auto";
		     }
		   }
		}
		ResizeImages();
	   </script>



