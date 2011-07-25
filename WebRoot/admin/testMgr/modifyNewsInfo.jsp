<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="bean" class="com.saas.biz.newsMgr.NewsInfo" scope="page" />
<%
	String news_id = "", title = "", content = "",news_type="",class_type="";
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
		        ArrayList list=new Productclass().genUpclassByClassId(news_type);
		        if(list !=null && list.size()>0){
		          HashMap claMap=(HashMap)list.get(0);
		          if(claMap.get("class_name")!=null){
		           class_type=claMap.get("class_name").toString();
		          }
		        }
			}
		}
	}
	String idx = news_id;
%>
<html>
	<head>
		<title>电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/inc/prototype.js"></script>
		<script type="text/javascript" src="/inc/upLoad.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<style type="text/css">
			.Tree-Img {
		   	 	background-image:url(/images/org.png) !important;
			}
			.root-Img {
		    	background-image:url(/images/home.png) !important;
			}
      	</style>

		<script language="JavaScript">
	      function setTree(){  
	      var tree = new Ext.tree.TreePanel({   
	    	el:"tree-div",   
	        autoScroll:false,
	        animate:true,
	        width:'30%',
	        autoHeight:true,
	        enableDD:false,
	        containerScroll: true, 
	        loader: new Ext.tree.TreeLoader({
	            dataUrl:'json_data.jsp'            
	        })
	    });
		var resizeable = new Ext.Resizable('tree-div', {
            pinned:true,
            autoWidth:true,
            autoHeight:true,
            handles: 'e',
            widthIncrement:50,
            minWidth: 50,
			maxWidth:450,
            dynamic: true
        });
        
        tree.on("click",function(node,event){
			   document.getElementById("news_type").value=node.id;
			   document.getElementById("class_type").value=node.text;
			});
    		var root = new Ext.tree.AsyncTreeNode({
        	text:'信息类型列表',
        	draggable:false,
        	iconCls:'root-Img',
        	id:'000000000000000'
    		});
    		tree.setRootNode(root);
   			tree.render();
   			root.expand();
   		}
   		
  function Check_Value()
	{
	    if(document.getElementById("class_type").value=="" || document.getElementById("class_type").value==null)
			{
				alert("请选择评测分类！");
				document.getElementById("class_type").focus();
				return false;
			}
		  if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"") ==null)
			{
				alert("请填写新闻的标题！");
				document.getElementById("title").focus();
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
</script>
	</head>
	<body onload="setTree()">
		<form name="newform" action=/doTradeReg.do method="post">
						<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>修改评测信息</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width=800 border=0 cellpadding=0 cellspacing=1 bgcolor="#dddddd" align=center>
				<tr>
					<td width="15%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						评测分类:
					</td>
					<td width="85%" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div>
							<div id="tree-div"></div>
						</div>
						<input name="news_id" type="hidden" value="<%=news_id%>">
						<input name="subject_tag" type="hidden" value=0>
						<input name="news_type" type="hidden" value="<%=news_type%>" id="news_type">
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
						分类名称：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div>
							<input name="class_type" type="text" id="class_type" size=20 maxlength=70 value="<%=class_type%>" readonly>
					  </div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
						评测标题：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div>
							<input name="title" type="text" size=30 maxlength=70 value="<%=title%>">
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right valign=top>
						评测内容：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div>
							<textarea name="content" style=display:none>
								<%=content%>
							</textarea>
							<iframe ID=content src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=news_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
						</div>
						输入范围(汉字应少于4000字)
					</td>
				</tr>

				<tr style="display:none">
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						附件：
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="path" id="path" type="hidden" size=40 value="<%=idx%>">
							<iframe src="/inc/uploadAttr.jsp?idx=<%=idx%>" width="100%" height="30%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
						</div>
					</td>
				</tr>
				<tr style="display:none">
					<td colspan="2" bgcolor="#FFFFFF">
						<dir id="attr-div"></dir>
					</td>
				</tr>
				<tr>
					<td>
					<div id="hello-win"></div>
					<input name="news_id" type="hidden" value=<%=news_id%>>
					<input type="hidden" name="idx" value="<%=idx%>">
					<input name="trade_type_code" type="hidden" value=0289>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px; padding-top:10px;padding-bottom:10px;" align=center colspan=2>
						<input class="xgan" name="bnt" type="submit" value=""  onclick="return Check_Value()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




