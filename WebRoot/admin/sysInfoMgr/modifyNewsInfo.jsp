<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="bean" class="com.saas.biz.newsMgr.NewsInfo"
	scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%
	String news_id = "", title = "", content = "", news_type = "", class_type = "";
	commMethodMgr commen = new commMethodMgr();
	if (request.getParameter("news_id") != null) {
		news_id = request.getParameter("news_id");
		ArrayList newsList = bean.genOneNews(news_id);
		if (newsList != null && newsList.size() > 0) {
			HashMap map = (HashMap) newsList.get(0);
			if (map.get("title") != null) {
				title = map.get("title").toString();
			}
			if (map.get("content") != null) {
				content = map.get("content").toString();
			}
			if (map.get("news_type") != null) {
				news_type = map.get("news_type").toString();
				ArrayList list = new Productclass()
						.genUpclassByClassId(news_type);
				if (list != null && list.size() > 0) {
					HashMap claMap = (HashMap) list.get(0);
					if (claMap.get("class_name") != null) {
						class_type = claMap.get("class_name")
								.toString();
					}
				}
			}
		}
	}
	String idx = news_id;

	String type = "";
	if (request.getParameter("class_type") != null) {
		type = request.getParameter("class_type");
	}
%>
<html>
	<head>
		<title>电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css"
			href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/inc/prototype.js"></script>
		<script type="text/javascript" src="/inc/upLoad.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
   		
  function Check_Value()
	{
		  if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"") ==null)
			{
				alert("请填写新闻的标题！");
				return false;
			}
			var str=content.getText();
			str=str.replace(/\s*/g,""); 
			if(str == ""  )
			{
				alert("请填写新闻的内容！");
				return false;
			}
			if( str.length > 4000)
			{
				 alert( "证书说明字数应少于4000字" );
				 return false;	
			}

		   //////////////////判断时间是否合理////////////////
		   if(!checkDate(start_date,end_date)){
		     return false;
		   }
		   ///////////////////////////////////////////////
	    return true;
	}
		function ShowColor(){
			var fcolor=showModalDialog("color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.newform.title_color.value = fcolor;
		}
</script>
		<script language="JavaScript">
		function clickSel(val,valId){
			var tt = document.getElementById("contents").value;
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==false){
					tt='10'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==true){
					tt='01'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==false){
					tt='00'
				}
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==true){
					tt='11'
				}
			document.getElementById("contents").value = tt;
		}
		</script>
	</head>
	<body>

		<form name="newform" action=/doTradeReg.do method="post">
			<table width="800" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="30">
					</td>
				</tr>
				<tr>
					<td background="/admin/images/content_03.gif" height="43"
						width="156" align="center">
						<font size="2"><b>修改信息</b>
						</font>
					</td>
					<td background="/admin/images/content_04.gif" align="right">
						&nbsp;
					</td>
					<td width="8">
						<img src="/admin/images/content_06.gif">
					</td>
				</tr>
			</table>
			<table width=800 border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>
						<table width="796" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0"
									onclick="javascript:secBoard(0)">
									常规参数
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1"
									onclick="javascript:secBoard(1)">
									文章内容
								</td>
								<td>
									&nbsp;

								</td>
							</tr>
						</table>
						<!--1-->
						<jsp:include flush="true" page="infolistNews.jsp">
							<jsp:param name="news_id" value="<%=news_id%>" />
							<jsp:param name="class_id" value="1742004681" />
						</jsp:include>

						<!--2-->
						<table width="800" border=0 cellpadding=1 cellspacing=1
							bgcolor="#dddddd" align=center id="bo1" style="display: none">
							<tr>
								<td class="u1">
									信息分类：
								</td>
								<td width="85%" align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;">


									<iframe marginWidth="0" marginHeight="0"
										src="displayClassName.jsp?class_type=<%=type%>" frameborder=0
										scrolling=no width=600 height="510"></iframe>


									<input name="news_id" type="hidden" value=<%=news_id%>>
									<input name="subject_tag" type="hidden" value=0>
									<input name="news_type" type="hidden" value="<%=news_type%>"
										id="news_type">
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类名称：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<div>
										<input name="class_type" type="text" id="class_type" size=20
											maxlength=70 value="<%=class_type%>">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									信息标题：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<div>
										<input name="title" type="text" size=30 maxlength=70
											value="<%=title%>">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									信息内容：
								</td>
								<td
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									align=left>
									<div>
										<textarea name="content" style="display: none">
								<%=content%>
							</textarea>
										<iframe ID=content
											src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=
											<%=news_id%> frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
									输入范围(汉字应少于4000字)
								</td>
							</tr>

							<tr style="display: none">
								<td class="u1">
									附件：
								</td>
								<td bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="path" id="path" type="hidden" size=40
											value="<%=idx%>">
										<iframe src="/inc/uploadAttr.jsp?idx=<%=idx%>" width="100%"
											height="30%" frameborder="no" border="0" marginwidth="0"
											marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
									</div>
								</td>
							</tr>
							<tr style="display: none">
								<td colspan="2" bgcolor="#FFFFFF">
									<dir id="attr-div"></dir>
								</td>
							</tr>
						</table>

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
						<table width="800" border=0 align="center" cellpadding=1
							cellspacing=1 bgcolor="#DEEDFD">
							<input name="news_id" type="hidden" value=<%=news_id%>>
							<input type="hidden" name="idx" value="<%=idx%>">
							<input name="trade_type_code" type="hidden" value=0287>
							<input name="info_id" type="hidden" id="info_id"
								value="<%=news_id%>">
							<input name="remark" type="hidden" id="remark" value="">
							<tr>
								<td
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px; padding-top: 10px; padding-bottom: 10px;"
									align=center colspan=2>
									<input class="xgan" name="bnt" type="submit" value=""
										onclick="return Check_Value()">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



