<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="bean" class="com.saas.biz.newsMgr.NewsInfo" scope="page" />
<%
	String news_id = "", title = "", content = "", news_type = "", class_type = "";
	ChannelInfo channel = new ChannelInfo();
	
	if ( request.getParameter( "news_id" ) != null) 
	{
		news_id = request.getParameter( "news_id" );
		ArrayList newsList = bean.genOneNews( news_id );
		if ( newsList != null && newsList.size() > 0 ) 
		{
			HashMap map = ( HashMap ) newsList.get( 0 );
			if ( map.get("title" ) != null ) 
			{
				title = map.get("title").toString();
			}
			if ( map.get("content") != null ) 
			{
				content = map.get("content").toString();
			}	
			if (map.get("news_type") != null) 
			{
				news_type = map.get("news_type").toString();
			}
		}
	}
	String type = "";
	if ( request.getParameter( "class_type" ) != null ) 
	{
		type = request.getParameter( "class_type" );
	}
	class_type = channel.getChName( type );
	String idx = news_id;
%>
<html>
	<head>
		<title>电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
   		function clickSel( val, valId )
		{
			if( val == '0' )
			{
				document.getElementById(valId).value = '1';
			}
			else
			{
				document.getElementById(valId).value = '0';
			}
		}
 	 	function Check_Value()
		{
			 if(document.getElementById("class_type").value == "" || document.getElementById("class_type").value == null )
			  {
					alert("请选择信息分类！");
					document.getElementById("class_type").focus();
					return false;
			  }
			  if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"") == null )
			  {
					alert("请填写新闻的标题！");
					document.getElementById("title").focus();
					return false;
			  }
			  var str=content.getText();
			  str = str.replace(/\s*/g,""); 
			  if( str == ""  )
			  {
				  alert("请填写新闻的内容！");
				 return false;
			  }
			  if( str.length > 4000 )
			  {
				  alert( "证书说明字数应少于4000字" );
				  return false;	
			  }
		  	document.getElementById('contents').value = document.getElementById('one').value + 
					document.getElementById('two').value + document.getElementById('three').value;
	    	return true;
		}
		function ShowColor()
		{
			var fcolor=showModalDialog("color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+
					(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if( fcolor != null && fcolor != "undefined" ) 
				document.newform.title_color.value = fcolor;
		}
		</script>
	</head>
	<body>

		<form name="newform" action="/doTradeReg.do" method="post">
			<table width=100% border="0" cellspacing="1" cellpadding="1" align="center">
				<tr>
					<td>
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(0)">
									常规参数
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(1)">
									文章内容
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
						</table>
						<!--01-->
						<jsp:include flush="true" page="/admin/cms/modiInfolist.jsp">
							<jsp:param name="news_id" value="<%=news_id%>" />
							<jsp:param name="class_id" value="<%=news_type%>" />
						</jsp:include>
						<!--02-->
						<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" id="bo0">
							<!--tr>
								<td width="111" class="u1">
									信息标题：
								</td>
								<td width="278" class="u2">
									<input name="title" id="title" type="text" value="<%=title%>" size=30 maxlength=70>
								</td>
							</tr-->							
							<tr>
								<td class="u1">
									频道名称：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<div>
										<input name="class_type" type="text" id="class_type" size=20 maxlength=70 value="<%=class_type%>">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									信息内容：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<div>
										<textarea name="content" style=display:none>
											<%=content%>
										</textarea>
										<iframe ID=content src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=news_id%>" frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
									输入范围(汉字应少于4000字)
								</td>
							</tr>
						</table>
						<!--选项结束-->
						<script language=javascript>
						function secBoard(n)
						{
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('d' + n).className="c4";
								} else {
								document.all('d' + i).className="c3";}
							}
							
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('bo' + n).style.display="";
								} else {
								document.all('bo' + i).style.display="none";}
							}
		
					}
					</script>

						<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
							<tr>
								<td colspan=4 class="u3">
									<input name="info_id" type="hidden" id="info_id" value="<%=news_id%>">
									<input name="news_id" type="hidden" value="<%=news_id%>">
									<input type="hidden" name="in_date" id="in_date" value="" />
									<input type="hidden" name="idx" value="<%=idx%>">
									<input name="remark" type="hidden" id="remark" value="">
									<input name="news_type" type="hidden" id="news_type" value="<%=news_type%>">
									<input name="trade_type_code" type="hidden" value=0289>
									<input class="xgan" name="bnt" type="submit" value="" onclick="return Check_Value()">
									&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG" align="absmiddle" onClick="location.href='viewClassNewsInfo.jsp?class_id=<%=type%>'" style="cursor:hand;">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


