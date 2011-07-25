<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<%@ page import="com.saas.biz.linkmenuMgr.LinkmenuInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>关联菜单管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RightMenu.js'></script> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
		<script type="text/javascript">	
			function showLink(val){
				alert(val);
				if(document.getElementById('link_menu_id'+val).checked==true){
					document.getElementById('div'+val).style.dispaly='block';
				}else{
					document.getElementById('div'+val).style.dispaly='none';
				}
			}
			var fectureArray=new Array();
	 		fectureArray=['请选择..'];
			function setOneMenu(val){
				 RightMenu.getAreaByParent(val,function(data){
				 DWRUtil.removeAllOptions("oneMenu");
				 DWRUtil.addOptions("oneMenu",fectureArray);
				 DWRUtil.addOptions("oneMenu",data);
				 DWRUtil.removeAllOptions("twoMenu");
				 DWRUtil.addOptions("twoMenu",fectureArray);
				});
			}
			function setTwoMenu(oneMenu){
				 RightMenu.getAreaByParentById(oneMenu,function(data){
				 DWRUtil.removeAllOptions("twoMenu");
			     DWRUtil.addOptions("twoMenu",fectureArray);
				 DWRUtil.addOptions("twoMenu",data);
				});
			}
			
			function formSubmit(){
				document.linkForm.submit();
			}
			function checkSub(){
					var size = document.getElementById('size').value;
					var all_link = '',all_name = '',all_desc = '';
					for(var i=0;i<size;i++){
							if(document.getElementById('link_box'+i).checked==true){
									if(document.getElementById('link_name'+i).value==''){
										alert('请输入关联名称!');
										return false;
									}
									if(document.getElementById('link_desc'+i).value==''){
										alert('请输入关联描述!');
										return false;
									}
									all_link += document.getElementById('link_box'+i).value+'|';
									all_name += document.getElementById('link_name'+i).value+'|';
									all_desc += document.getElementById('link_desc'+i).value+'|';
							}
					}
					document.getElementById('link_menu_id').value = all_link;
					document.getElementById('link_name').value = all_name;
					document.getElementById('link_desc').value = all_desc;
					//document.linkExpForm.submit();
			}
		</script>
	</head>
	<body>
		<%
			RightMenu rightMenu = new RightMenu();
			String re_menu_id="",three_menu_name="";
			if(request.getParameter("menu_id")!=null){
				re_menu_id = request.getParameter("menu_id");
			}
			String code="0",twoMenu="";
			if(request.getParameter("code")!=null){
				code = request.getParameter("code");
			}
			if(request.getParameter("twoMenu")!=null){
				twoMenu = request.getParameter("twoMenu");
			}
			ArrayList helist = new ArrayList();
			int size = 0;
			if(code.equals("1")){
				helist = rightMenu.getSpecMenuIdInfo(twoMenu,re_menu_id);
				size = helist.size();
			}
			String serSel = bean.getSelectItems("41");
			three_menu_name = rightMenu.getMenuNameById(re_menu_id);
			LinkmenuInfo linkInfo = new LinkmenuInfo();
			ArrayList list = linkInfo.getLinkMenuById(re_menu_id);
			String l_menu_id="",l_link_menu_id="",link_name="",link_desc="",l_link_menu_name="";
			String no_menu_id="",no_menu_name="",subsys_code="",menu_id="";
		%>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td height="50" colspan="5">
				</td>
			</tr>
		</table>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td height="50" colspan="5">
						<b>三级菜单:<%=three_menu_name%></b>&nbsp;&nbsp; <a href="linkmenuMgr.jsp"><b>返回</b></a>
				</td>
			</tr>
		</table>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td width="50">
				</td>
				<td>
						<div style="height:220px;width:95%;overflow:auto;overflow-x:hidden;border:1px solid #95b3cf;padding:0 5px;font-size:12px;">
								<b>已关联菜单:</b></br>
					<% 
						if(list!=null && list.size()>0){
							for(int i=0;i<list.size();i++){
								HashMap map = (HashMap)list.get(i);
								if(map.get("menu_id")!=null){
									l_menu_id = map.get("menu_id").toString();
								}
								if(map.get("link_menu_id")!=null){
									l_link_menu_id = map.get("link_menu_id").toString();
									l_link_menu_name = rightMenu.getMenuNameById(l_link_menu_id);
								}
								if(map.get("link_name")!=null){
									link_name = map.get("link_name").toString();
								}
								if(map.get("link_desc")!=null){
									link_desc = map.get("link_desc").toString();
								}
					%>
							<%=l_link_menu_name %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/doTradeReg.do?trade_type_code=4501&menu_id=<%=re_menu_id%>&link_menu_id=<%=l_link_menu_id %>"><img src="/img/del.gif" border="0"></a></br>
					<%
							}
						}else{
					%>
						无菜单关联!
					<%
						}
					%>
					</div>
				</td>
				<td>
						<div style="height:220px;width:95%;overflow:auto;overflow-x:hidden;border:1px solid #95b3cf;padding:0 5px;font-size:12px;">
								<b>未关联菜单:</b></br>
								请选择服务名称:
								<select onclick="setOneMenu(this.value)">
									<%=serSel%>
								</select>
								&nbsp;&nbsp;
								请选择一级菜单:
								<select name="oneMenu" id="oneMenu" onchange="setTwoMenu(this.value)">
			              <option value="">请选择..</option>
			          </select>
			          <form action="linkmenuMgrExp.jsp" method="post" name="linkForm">
			          	<input type="hidden" name="menu_id" value="<%=re_menu_id%>">
									请选择二级菜单:
									<input type="hidden" name="code" id="code" value="1">
									<select name="twoMenu" id="twoMenu" onchange="formSubmit()">
				               <option value="">请选择..</option>
				          </select>
				        </form>
					</div>
					</table>	
		<% 
			if(helist!=null && helist.size()>0){
		%>
		
			<table>
				<tr>
					<td class="line1" style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
						菜单名称
					</td>
					<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
						加入时间
					</td>
					<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
						关联
					</td>
					<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="60%">
						备注
					</td>
				</tr>
				
				 
		<%
				for (int i = 0; i < helist.size(); i++) {
					HashMap map = (HashMap) helist.get(i);
					String menu_name="",in_date="";
					if (map.get("menu_id") != null) {
						menu_id = map.get("menu_id").toString();
					}
					if (map.get("menu_name") != null) {
						menu_name = map.get("menu_name").toString();
					}
					if (map.get("in_date") != null) {
						in_date = map.get("in_date").toString();
					}
					if (in_date.length() > 10) {
						in_date = in_date.substring(0, 10);
					}
		%>

		<tr style="background-color: #f9f9f9;">
			<td style="color: #000000; padding: 2px 5px;" align=left>
				<%=menu_name%>
			</td>
			<td style="color: #000000; padding: 2px 5px;" align=center><%=in_date%></td>
			<td style="color: #000000;" align=center>
				<input type=checkbox name=link_box id=link_box<%=i%> value=<%=menu_id%> >
			</td>
			<td style="color: #000000;" align=left>
				关联名称:<input type="text" name="link_name<%=i%>" id="link_name<%=i%>" value="" size="20" maxlength="20"> 
				关联描述:<input type="text" name="link_desc<%=i%>" id="link_desc<%=i%>" value="" size="50" maxlength="50">
			</td>
		</tr>
		
		<% 
			}
		%>
			<tr>
			<td colspan="4" align="center" height="50">
				<form method="post" name="linkExpForm" action=/doTradeReg.do target="_self">
					<input type="hidden" name="trade_type_code" value="1291">
					<input type="hidden" name="menu_id" value="<%=re_menu_id%>">
					<input type="hidden" name="link_menu_id" id="link_menu_id" value="">
					<input type="hidden" name="link_name" id="link_name" value="">
					<input type="hidden" name="link_desc" id="link_desc" value="">
					<input type="hidden" name="size" id="size" value="<%=size%>">
					<input type="submit" name="submit" value="提交" onclick="return checkSub()">
				</form>
			</td>
		</tr>
		</table>
	
		<%	
			}
		%>
			 
 
	 
		
	</body>
</html>



