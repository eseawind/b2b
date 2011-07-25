
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<link rel="stylesheet" type="text/css" href="/templates/default/style/supply.css" />
<%@ page import="java.util.*"%>
			

<%

	config configFile = new config();
	configFile.init();
	String default_img = configFile.getString("default_img");
	InfoList info = new InfoList();
	String cont_mod="",ch_id="",arow="",start="",now_page="",total_page="",total_num="",class_id="",area_code="";
	if(request.getParameter("cont_mod")!=null){
		cont_mod = request.getParameter("cont_mod");
	}
	if(request.getParameter("total_page")!=null){
		total_page = request.getParameter("total_page");
	}
	if(request.getParameter("total_num")!=null){
		total_num = request.getParameter("total_num");
	}
	if(request.getParameter("ch_id")!=null){
		ch_id = request.getParameter("ch_id");
	}
	if(request.getParameter("row")!=null){
		arow = request.getParameter("row");
	}
	if(request.getParameter("now_page")!=null){
		now_page = request.getParameter("now_page");
	}
	if(request.getParameter("class_id")!=null){
		class_id = request.getParameter("class_id");
	}
	if(request.getParameter("area_code")!=null){
		area_code = request.getParameter("area_code");
	}
	InfoIntf infoIntf = new InfoIntf();
	int apage = Integer.parseInt(now_page)*Integer.parseInt(arow);
	ArrayList infoList = info.getInfoListByContmodByLimit(apage,Integer.parseInt(arow),ch_id,cont_mod);
	if(!class_id.equals("0")){	
		infoList = info.getInfoListByClassIdByLimit(apage,Integer.parseInt(arow),ch_id,class_id,cont_mod);
	}
	if(!area_code.equals("0")){
		infoList = info.getInfoListByAreaCode(apage,Integer.parseInt(arow),ch_id,area_code,cont_mod);
	}
	ChannelInfo channel = new ChannelInfo();
	String ch_name = channel.getChName(ch_id);
	
%>
			<%
				if(cont_mod.equals("1") || cont_mod.equals("2") || cont_mod.equals("3") || cont_mod.equals("7")){	
			%>
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"> 
            <tr>
              <th width="16%">产品图片</th>
              <th width="46%">公司/主营产品、服务</th>
              <th width="12%">
              	<%
              		if(cont_mod.equals("1") || cont_mod.equals("7") ){
              	%>
              		供应地区
              	<%	
              		}else if(cont_mod.equals("2")){
              	%>
              		求购地区
              	<%
              		}else{
              	%>
              		产品地区
              	<%
              		}
              	%></th>
              <th width="12%">发布日期</th>
              <th width="14%">联系方式</th>
            </tr>
			<%
			 }else if(cont_mod.equals("6")){
			 	
			%>
			
			<dl>
			<dt>
				<ul>
					<li style="width:56%">展会标题</li>
					<li style="width:16%">开展时间</li>
					<li style="width:25%">出展地点</li>
				</ul>
			</dt>
			
			<%	
			}else{
			%>
				
				<dl>
				<dt>
					<ul>
						<li><%=ch_name%></li>
					</ul>
				</dt>
				<dd>
					<ul>
			<%
				}
			%>
			
			<%
				String save_dir = "";
				if(infoList!=null){
					for(int i=0;i<infoList.size();i++){
					
					HashMap map=(HashMap) infoList.get(i);
          String cust_name="",sale_addr="", title="", in_date="",  info_dsec="",author="",info_id="",cust_id="",phone="",show_addr="",stock_addr="";
          String  mini_img="";
          if(map.get("title")!=null){title=map.get("title").toString();}
         	if(map.get("sale_addr")!=null){sale_addr=map.get("sale_addr").toString();}
         	if(map.get("stock_addr")!=null){stock_addr=map.get("stock_addr").toString();}
         	if(sale_addr.equals("")){
         		sale_addr = stock_addr;
         	}
          if(map.get("in_date")!=null){
          	in_date=map.get("in_date").toString();
          }
          if(map.get("mini_img")!=null){mini_img=map.get("mini_img").toString();}
          if(map.get("show_addr")!=null){
          	show_addr=map.get("show_addr").toString();
          	if(show_addr.length()>12){
          		show_addr = show_addr.substring(0,12)+"...";
          	}
          }
          if(map.get("info_dsec")!=null){
          	info_dsec=map.get("info_dsec").toString();
          	if(info_dsec.length()>20){
          		info_dsec = info_dsec.substring(0,20)+"...";
          	}
          }
          if(map.get("author")!=null){author=map.get("author").toString();}
          
          if(map.get("info_id")!=null){
          	info_id=map.get("info_id").toString();
          	save_dir = infoIntf.getChannelSaveDirByInfoId(info_id);
          }
          if(!class_id.equals("0")){
          	save_dir = save_dir+"/class/"+class_id+"/";
          }
          if(!area_code.equals("0")){
          	save_dir = save_dir+"/area/"+area_code+"/";
          }
          if(map.get("group_contact_phone")!=null){phone=map.get("group_contact_phone").toString();}
          if(map.get("mini_img")!=null){
          	mini_img=map.get("mini_img").toString();
          }
          if(mini_img.equals("")){
        	  mini_img = default_img;
        	}
          if(map.get("cust_id")!=null){cust_id=map.get("cust_id").toString();}
					if(map.get("cust_name")!=null){cust_name=map.get("cust_name").toString();}
					String urlhref = "/"+save_dir+"/d/content-"+info_id+".html";
					
				
					if(cont_mod.equals("1") || cont_mod.equals("2") || cont_mod.equals("3") || cont_mod.equals("7")){	
			%>

			<tr>
        <td><a href="<%=urlhref%>" target="_blank"><img src="<%=mini_img%>" border="0" width="100" height="75"></a></td>
        <td valign="top">
			  <span class="content_name link_xian"><a href="<%=urlhref%>" target="_blank"><%=title%></a></span><br>
			 	<%=info_dsec%> 
				<br>
			  <span class="link_xian">发布者: <a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank"><%=cust_name%></a>   [已核实] </span>
			  <div class="button" style="float:left; margin-right:5px;"><a href="<%=urlhref%>"  target="_blank">产品信息</a></div> 
			  <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank">联系方式</a></div> </td>
        <td align="center">&nbsp;
        	<%=sale_addr%>
        </td>
        <td align="center"><%=in_date%></td>
        <td align="center"><%=phone%></td>
      </tr>
			<%
				}else if(cont_mod.equals("6")){	
					if(!title.equals("") && title.length()>25){
						title = title.substring(0,25)+"...";
					}
					if(!in_date.equals("") && in_date.length()>16){
          		in_date = in_date.substring(0,16);
          }
			%>
				<dd>
					<ul>
						<li style="width:50%"><a href="<%=urlhref%>"><%=title%></a> </li>
						<li style="width:20%">
							<%=in_date%>
						</li>
						<li style="width:25%">
							<%=show_addr%>
						</li>
					</ul>
				</dd>
			
			<%
				}else{
			%>
				<li><a href="<%=urlhref%>" target="_blank"><%=title%></a><span><%=in_date%></span></li>
			<%
				}			
				}
			}
			%>

			<%
				if(cont_mod.equals("1") || cont_mod.equals("2") || cont_mod.equals("3") || cont_mod.equals("7")){	
			%>
			</table> 
			<div class="cplist_page lin1">
				<span><a href=/<%=save_dir%> >[首页]</a></span><span id=fenye1>第<%=now_page%>页<a href=list.html?page=<%=Integer.parseInt(now_page)-1%>&row=<%=arow%> >[上一页]</a><a href=list.html?page=<%=Integer.parseInt(now_page)+1%>&row=<%=arow%>>[下一页]</a></span>
				<span><a href=list.html?page=<%=Integer.parseInt(total_page)%>&row=<%=arow%>>[最后]</a>共<%=total_page%>页共<%=total_num%>条</span>	
			</div>
			<%
				}else{
			%>
					
				 
			<div class="list_page lin1">
				<span><a href=/<%=save_dir%> >[首页]</a></span><span id=fenye1>第<%=now_page%>页
					<%
						if(now_page.equals("10")){
					%>
						<a href=9.html>
					<%
						}else{
					%>
						<a href=list.html?page=<%=Integer.parseInt(now_page)-1%>&row=<%=arow%> >
					<%
						}
					%>
					[上一页]</a><a href=list.html?page=<%=Integer.parseInt(now_page)+1%>&row=<%=arow%>>[下一页]</a></span>
				<span><a href=list.html?page=<%=Integer.parseInt(total_page)%>&row=<%=arow%>>[最后]</a>共<%=total_page%>页共<%=total_num%>条</span>		
			</div>
					<!--新闻分页部门-->
			<%
				}
			%>	




