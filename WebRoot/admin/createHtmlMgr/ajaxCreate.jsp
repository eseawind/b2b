<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.saas.biz.searchMgr.IndexFiles"%>
<html>
	<head>
		<title>更新主页</title>
	</head>
	<body>						
		<%
				String cust_id = session.getAttribute("SESSION_CUST_ID").toString();	
				CreateIndex cindex = new CreateIndex();	
				ChannelInfo info = new ChannelInfo();
				CreateArticle article = new CreateArticle();
				CreateChannel channel = new CreateChannel();	
				IndexFiles indexFile = new IndexFiles();
				String index_temp = "",save_dir="",default_page="",ch_id="",code="",yes="",born_type="";	
				String getselect = "";
				//接受参数范围
				if (request.getParameter("index_temp") != null){
					index_temp = request.getParameter("index_temp");
				}
				if (request.getParameter("getselect") != null){
					getselect = request.getParameter("getselect");
				}
				if (request.getParameter("save_dir") != null){
					save_dir = request.getParameter("save_dir");
				}
				if (request.getParameter("default_page") != null){
					default_page = request.getParameter("default_page");
				}		
				if (request.getParameter("ch_id") != null){
					ch_id = request.getParameter("ch_id");
				}			
				if (request.getParameter("code") != null){
					code = request.getParameter("code");
				}	
				if (request.getParameter("yes") != null){
					yes = request.getParameter("yes");
				}
				if (request.getParameter("born_type") != null){
					born_type = request.getParameter("born_type");
				}
				String ch_name = "";
				ArrayList list = info.getChannel(ch_id);
				if (list != null && list.size() > 0){
					HashMap map = (HashMap)list.get(0);
					if(map.get("ch_name") != null)
						ch_name = map.get("ch_name").toString();
					if(map.get("save_dir") != null)
						save_dir = map.get("save_dir").toString();
					if(map.get("default_page") != null)
						default_page = map.get("default_page").toString();	
				}
				
				String brows_url = "/"+save_dir+"/"+default_page;
				
				//执行生成类范围
				if(!index_temp.equals("")){
					cindex.CreateIndex(cust_id,index_temp,save_dir,default_page);
				}
				if(!ch_id.equals("") && code.equals("1")){
					article.CreateArticleList(ch_id,born_type);
				}
				if(!ch_id.equals("") && code.equals("2")){
					if(yes.equals("1")){
						channel.CreateChannelIndexSingel(ch_id);
					}
					if(yes.equals("0")){
						channel.CreateChannelIndexList(ch_id);
					}
					///new added;
					if(yes.equals("2")){//仅更新所选栏目地区列表
						CreateChannel.CreateChannelListArea(ch_id);
					}
					if(yes.equals("3")){//仅更新所选栏目分类列表
						CreateChannel.CreateChannelListClass(ch_id);
					}
					if(yes.equals("4")){//仅更新所选栏首页列表
						CreateChannel.CreateChannelListAll(ch_id);
					}
					if(yes.equals("5")){//仅更新所选栏首页
						CreateChannel.CreateChannelIndexOne(ch_id);
					}
				}
				
				if(getselect.equals("gengxin")){
					indexFile.updateSelect();
				}
				
				
		%>
		
		
		
		<%
			if(!index_temp.equals("")){//显示提示文字范围
		%>
			<font size="3">生成首页结束............</font>
			<a href="/" target="_blank"><font size="3">预览...</font></a><br>
		<%
			}
		%>
		<%
			if(code.equals("2")){
		%>
			<font size="3">生成<%=ch_name%>栏目结束............</font>
			<a href=<%=brows_url%> target="_blank"><font size="3">预览...</font></a><br>
		<%
			}
			if(code.equals("1")){
		%>
			<font size="3">生成<%=ch_name%>详细页面结束............</font>
			<a href=<%=brows_url%> target="_blank"><font size="3">预览...</font></a><br>
		<%
			}
		%>
		
		<%
			if(getselect.equals("gengxin")){
		%>
			更新搜索结束............
		<%
			}
		%>
		
	</body>
</html>


