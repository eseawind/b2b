<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%@ page import="java.util.*"%>

<%
	String news_id = bean.GenTradeId();
	String up_id="000000000000000";
	if(request.getParameter("up_class_id") != null){
		up_id=request.getParameter("up_class_id").toString();
	}
	String class_type="10";
	ArrayList json = proInfo.getInfoByUpId(up_id,class_type);
%>

<html>
	<head>
		<title>电子商务平台</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/inc/prototype.js"></script>
		<script type="text/javascript" src="/inc/upLoad.js"></script>
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
        	if(node.id!='000000000000000'){
			   		document.getElementById("news_type").value=node.id;
			   		document.getElementById("class_type").value=node.text;
			  	}else{
			  		document.getElementById("news_type").value='';
			   		document.getElementById("class_type").value='';	
			  	}
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
    function Check_Value(){
		    if($F("class_type")=="" || $F("class_type")==null || $F("news_type")=="000000000000000"){
				alert("请选择评测分类！");
				document.getElementById("class_type").focus();
				return false;
			}
			 if($F("title").replace(/\s*/g,"")=="" || $F("title").replace(/\s*/g,"")==null){
				alert("请填写评测的标题！");
				document.getElementById("title").focus();
				return false;
			}
			  var str=content.getText();
				str=str.replace(/\s*/g,""); 
				if(str == ""  ){
					alert("请填写评测的内容！");
					return false;
				}
				if( str.length > 4000){
					 alert( "证书说明字数应少于4000字" );
					 return false;	
				}
				
		    return true;
	}
</script>
	</head>
	<body ">
	<form name="testform" action=/doTradeReg.do method="post" target="_self">
	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>新增评测</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
		<table width="800" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="800" border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
						<tr>
							<td class="u1" width="15%">
								评测分类：
							</td>
							<td width="85%" class="u2">
								<!--<div>
									<div id="tree-div"></div>
								</div>-->
								<table width="450px" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="20%" align="center" >分类名称</td>
								<td width="40%" align="center" >分类描述</td>
								<td width="20%" align="center" >是否有效</td>
							</tr>
							<%
								if(json!=null && json.size()>0){
								HashMap map=null;
									for(int i=0;i<json.size();i++){
									String class_name="";
									String class_id_up="";
									String class_desc="";
									String enable_tag="";
									String remark="";
									ArrayList list=null;
					           map=(HashMap)json.get(i);
					           if(map.get("class_name")!=null){
					          	 class_name=map.get("class_name").toString();
					           }
					           if(map.get("class_id")!=null){
					          	 class_id_up=map.get("class_id").toString();
					          	 list = proInfo.getInfoByUpId(class_id_up,class_type);
					           }
					           if(map.get("class_desc")!=null){
					          	 class_desc=map.get("class_desc").toString();
					          	 if(class_desc.equals("")){
					          	 		class_desc="无";
					          	 }
					           }
					           if(map.get("enable_tag")!=null){
					          	 enable_tag=map.get("enable_tag").toString();
					          	 if(enable_tag.equals("0")){
					          	 		enable_tag="有效";
					          	 }else{
					          	 		enable_tag="无效";
					          	 	}
					           }
					           if(map.get("remark")!=null){
					          	 remark=map.get("remark").toString();
					          	 
					           }
					           %>
					           <tr>
								<td width="30%" align="left" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									&nbsp;&nbsp;&nbsp;<input type="radio" name="up_class_id" value="<%=class_id_up%>" title="<%=class_name%>" onclick="document.getElementById('class_type').value='<%=class_name%>';document.getElementById('class_id').value='<%=class_id_up%>';"/>&nbsp;<%if(list!=null){%>
									<a href="/admin/testMgr/index.jsp?up_class_id=<%=class_id_up%>" title="查看下级分类"><%=class_name%></a>
									<%}else{%>
									<%=class_name%>
									<%}%>
									
								</td>
								<td width="35%" align="left" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=class_desc%>
								</td>
								<td width="25%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%=enable_tag%>
								
							</tr>
								<%}
							}else{%>
								<tr>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;" colspan="4">暂无分类！</td>
							</tr>
							<%	}
							%>
							<tr>
								<td width="20%" align="center" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;" colspan="4"></td>
							</tr>
						</table>
								<input name="news_id" type="hidden" value=<%=news_id%>>
								<input name="subject_tag" type="hidden" value=0>
								<input name="news_type" type="hidden" value="" id="news_type">
								<input type="hidden" name="class_id" id="class_id" value="">
								
							</td>
						</tr>
						<tr>
							<td class="u1">分类名称:
							</td>
							<td class="u2"><div>
								<input name="class_type" type="text" id="class_type" size=20 maxlength=70 readonly>
							</div>
							</td>
						</tr>
						<tr>
							<td class="u1">信息标题：
							</td>
							<td class="u2"><div>
									<input name="title" type="text" id="title" size=30 maxlength=70>
								</div>
							</td>
						</tr>
						<tr>
							<td class="u1">评测内容：
							</td>
							<td class="u2"><div>
									<textarea name="content" style=display:none></textarea>
									<iframe ID=content src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=news_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
								</div>
								输入范围(汉字应少于4000字)
							</td>
						</tr>
						
						<tr>
							<td class="u3" align=center colspan=2>
								<input name="trade_type_code" type="hidden" value="0261">
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





