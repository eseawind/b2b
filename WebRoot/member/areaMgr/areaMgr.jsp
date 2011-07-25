<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("gbk");
	String iStart = "0";
	String parent_area_code="5J2mc0X0G85BH";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("parent_area_code") != null) {
		parent_area_code = request.getParameter("parent_area_code");
	}
	 String input_area_name="";
	  if ( request.getParameter( "input_area_name" ) != null )
	    {
	        input_area_name = request.getParameter( "input_area_name" );
	    }
	AreaInfo area = new AreaInfo();
	ArrayList arealist = area.getAreaByParent2(Integer.parseInt(iStart),parent_area_code);
	String parent_area_name = area.getAreaName(parent_area_code);
	int counter = area.getAreaByParent2(parent_area_code);
	  if ( request.getParameter( "input_area_name" ) != null ){
	  	parent_area_code = request.getParameter("parent_area_code");
		arealist = area.getAreaByParentAndName(Integer.parseInt(iStart),parent_area_code,input_area_name);
		parent_area_name = area.getAreaName(parent_area_code);
		counter =  area.getAreaByParentAndName(parent_area_code,input_area_name);
	  }
	int pages = counter / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
	
	
%>
<html>
	<head>
		<title>地区管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function showDown(){
				if(document.getElementById('input_area_name').value==''){
						alert('请输入查询地区名!');
						return false;
					}
				javascript:document.proForm.submit();
			}
		</script>
		<script language="javascript">
				
				function selAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								document.getElementById('re_news'+i).checked = true;
						}
				}
				
				function delAllNews(){
						var size = document.getElementById('size').value;
						for(var i=0;i<size;i++){
								if(document.getElementById('re_news'+i).checked==true){
									document.getElementById('re_news'+i).checked = false;	
								}else{
									document.getElementById('re_news'+i).checked = true;		
								}
						}
				}
				
				function reloadNews(){
						var size = document.getElementById('size').value;
						var all_news_id='';
						for(var i=0;i<size;i++){
							if(document.getElementById('re_news'+i).checked==true){
									all_news_id += document.getElementById('re_news'+i).value+'|';
							}
						}
						document.getElementById('area_code').value = all_news_id;
						if(all_news_id==''){
							alert('请至少选择一条!');
							return false;
						}else{
									document.proForm.action='/doTradeReg.do';
									document.getElementById("trade_type_code").value="1596";
									document.proForm.submit();
							}
				}
				</script>
	</head>
	<body>
			<form action="areaMgr.jsp?parent_area_code=<%=parent_area_code%>" method="post" name="proForm">	
		<%
			String top_menu_id="";
			String url = "addAreaIndex.jsp?area_code="+parent_area_code;
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="<%=url%>">新增地区</a>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" bgcolor="#FCB0B0" cellspacing="1" cellpadding="1" align="center">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" >
					<tr class="u1">
						<td align="left">
							请输入地区名：	<input type="text" name="input_area_name" id="input_area_name" value="" />
							<img src="/admin/images/chaxun.gif" border="0" onclick="showDown();" style="cursor:hand;"/>
						</td>
					</tr>
			</table>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=left bgcolor="#FCB0B0">
						<tr class="u4" height="25">
							<td width="20%">
								地区名
							</td>
							<td width="20%">
								地区所属
							</td>
							<td width="10%">
								<center>修改</center>
							</td>
							<td width="10%" align="center">
								<center>添加地区</center>
							</td>
							<!--td width="10%">
								<center>删除</center>
							</td-->
						<td width="20%" align="center">
								<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
								<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
								<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
						</td>
						</tr>
						<%
							String area_name="",area_code="";
							ArrayList areadownList = new ArrayList();
							if (arealist != null && arealist.size() > 0) {
							int size = arealist.size();
								for (int i = 0; i < arealist.size(); i++) {
								HashMap map = (HashMap) arealist.get(i);
								area_name=map.get("area_name").toString();
								if(map.get("area_code").toString()!=""){
									area_code = map.get("area_code").toString();
									areadownList = area.getAreaByParent2(0,area_code);
								}
						%>
						<tr class="u2">
							<td align=left>
								<%
									if(areadownList!=null && areadownList.size()>0){
								%>
									<a href="areaMgr.jsp?parent_area_code=<%=area_code%>&menu_id=<%=top_menu_id%>">&nbsp;<%=area_name%></a>
								<%
									}else{
								%>
									 <font color="black"><%=area_name%></font>
								<%
									}
								%>
							</td>
							<td align=left>
								<%=parent_area_name%>
							</td>
							<td align=left>
								<center>
									<a href="updateArea.jsp?area_code=<%=area_code%>" ><img src="/images/edit.png"  border="0"/></a>
								</center>
							</td>
							<td align=left>
								<center>
									<a href="addAreaIndex.jsp?area_code=<%=area_code%>" >
									<img src="/admin/images/xinzeng.png" border="0"></a>
								</center>
							</td>
							<td align=left>
								<center>
								  <!--a href="/doTradeReg.do?trade_type_code=8856&area_code=<%=area_code%>" target="_self">
								  <img src="/images/del.gif" border="0" title="点击删除该地区"> </a></td-->
								  <input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=area_code%>" />
						<input type="hidden" name="size" value="<%=size%>" id="size" />
								  </center>
							</td>
						</tr>
						<%
							}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right" colspan="4"  style=" padding:2px 5px;">
								<a href="areaMgr.jsp?iStart=0&parent_area_code=<%=parent_area_code%>&menu_id=<%=top_menu_id%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="areaMgr.jsp?iStart=<%=pageUp%>&parent_area_code=<%=parent_area_code%>&menu_id=<%=top_menu_id%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="areaMgr.jsp?iStart=<%=pageDown%>&parent_area_code=<%=parent_area_code%>&menu_id=<%=top_menu_id%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="areaMgr.jsp?iStart=<%=pages-1%>&parent_area_code=<%=parent_area_code%>&menu_id=<%=top_menu_id%>">尾页</a></td>
						</tr>
						
					<%if(!parent_area_code.equals("5J2mc0X0G85BH")){%>
				<tr class="u2">
			      <td align="center" colspan="5">
			      	<center>
			      	<img src="/admin/images/comeback.JPG" onClick="location.href='areaMgr.jsp'" style="cursor:hand;">
			      </center>
			      </td>
				 </tr>
						<%
						}if(null==arealist){
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
									  	<%}
						%>
					</table>
			<%}%>
				</td>
			</tr>
		</table>
		<input type="hidden" name="trade_type_code" id="trade_type_code" value="">
		<input type="hidden" name="area_code" id="area_code" value="">
	</form>
	</body>
</html>



