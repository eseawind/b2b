<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>

<%
	String news_id = bean.GenTradeId();
	commMethodMgr commen = new commMethodMgr();
	String idx = commen.GenTradeId();
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
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
	            dataUrl:'/newsMgr/json_data.jsp'            
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
   			tree.expandAll();
   		} 
   		
    function Check_Value()
	{
	    if(document.getElementById("class_type").value=="" || document.getElementById("class_type").value==null)
		{
			alert("请选择资讯分类！");
			document.getElementById("class_type").focus();
			return false;
		}
		 if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"")==null)
		{
			alert("请填写资讯的标题！");
			document.getElementById("title").focus();
			return false;
		}
		  var str=content.getText();
			str=str.replace(/\s*/g,""); 
			if(str == ""  )
			{
				alert("请填写资讯的内容！");
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
	<form name="newform" action=/doTradeReg.do method="post" target="_self">
		<table width="725" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=5 cellspacing=1 bgcolor="#dddddd">
						<tr>
							<td width="15%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
								资讯分类：
							</td>
							<td width="85%" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
								<div class="ping">
									<div id="tree-div"></div>
								</div>
								<input name="news_id" type="hidden" value=<%=news_id%>>
								<input name="subject_tag" type="hidden" value=0>
								<input name="news_type" type="hidden" value="" id="news_type">
							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>
								分类名称:
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
							  <div class="ping">
								<input name="class_type" type="text" id="class_type" size=20 maxlength=70 readonly>
							</div>
							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								信息标题：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<div class="ping">
									<input name="title" type="text" size=30 maxlength=70>
								</div>
							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								资讯内容：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<div class="ping">
									<textarea name="content" style=display:none></textarea>
									<iframe ID=content src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=news_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
								</div>
								输入范围(汉字应少于4000字)
							</td>
						</tr>
						<input type="hidden" name="class_id" id="class_id" value="">
						<input name="trade_type_code" type="hidden" value="0261">
						<tr>
							<td class="graymn" align=center colspan=2 style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;">
								<input class="tjan" name="bnt" type="submit" value=""  onclick="return Check_Value()">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>





