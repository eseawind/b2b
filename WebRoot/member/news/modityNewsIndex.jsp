<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	String news_types = "";
	String up_class_id="1764778601";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("up_class_id") != null) {
		up_class_id = request.getParameter("up_class_id");
	}
	

	ChannelInfo channel = new ChannelInfo();
	String upp_ch_id="1764778601";
	if (request.getParameter("up_ch_id") != null) {
		upp_ch_id = request.getParameter("up_ch_id");
	}
	ArrayList classlist = channel.getChSon (Integer.parseInt(iStart),upp_ch_id);
	ArrayList counterList = channel.getChSon (upp_ch_id);
	int counter = 0;
	if(null!=classlist){
	counter = counterList.size();
	for (int j = 0; j < classlist.size(); j++) {
			HashMap map = (HashMap) classlist.get(j);
			String cont_mod1="";
			if(map.get("cont_mod")!=null){
				cont_mod1 = map.get("cont_mod").toString();
			}
			if(!cont_mod1.equals("0") && !cont_mod1.equals("11") && !cont_mod1.equals("6")&&!cont_mod1.equals("8")){
				counter--;
			}
		}
	}
	
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "modityNewsIndex.jsp?cust_id="+cust_id+"&news_type="+news_types+"&iStart=", Integer.parseInt(iStart));
	
	
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
		<title>B2B���������̨����ϵͳ</title>
		
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function showDown(val){
				var ch_img = document.getElementById('img'+val);
				if(ch_img.src=='http://b2b.bizoss.com/admin/images/addP.gif'){
					ch_img.src = '/admin/images/delP.gif';
				}else{
					ch_img.src='/admin/images/addP.gif'	
				}
				var ch_tr = document.getElementById('tr'+val);
				if(ch_tr.style.display=='block'){
					ch_tr.style.display = 'none';
				}else{
					ch_tr.style.display = 'block';
				}
			}
		</script>
	</head>
	<body>
		<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<table width="100%" border="0" bgcolor="#DEEDFD" cellspacing="1" cellpadding="1" align="center">
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="20%">
								Ƶ������
							</td>
							<td width="10%">
								Ƶ������
							</td>
							<td width="20%">
								�ϼ�Ƶ��
							</td>
							<td width="20%">
								Ƶ������
							</td>
							<td width="10%" align="center">
								������Ѷ
							</td>						
						</tr>
						<%	
								String ch_id = "", ch_name = "",ch_desc="",up_ch_id="",ch_level="",up_ch_name="",ch_attr="";
								ArrayList downList = new ArrayList();
								if (classlist != null && classlist.size() > 0) {
									for (int a = 0; a < classlist.size(); a++) {
										HashMap class_map = (HashMap) classlist.get(a);
										String cont_mod="";
										if(class_map.get("cont_mod")!=null){
											cont_mod = class_map.get("cont_mod").toString();
										}
										if(!cont_mod.equals("0") && !cont_mod.equals("11") && !cont_mod.equals("6")&&!cont_mod.equals("8")){
											continue;
										}
										if (class_map.get("ch_name") != null) {
											ch_name = class_map.get("ch_name").toString();
										}
										if (class_map.get("ch_desc") != null) {
											ch_desc = class_map.get("ch_desc").toString();
										}
										if (class_map.get("up_ch_id") != null) {
											up_ch_id = class_map.get("up_ch_id").toString();
											up_ch_name = channel.getChName(up_ch_id);
										}
										if(up_ch_name.equals("")){
											up_ch_name = "���ϼ�Ƶ��";
										}
										if (class_map.get("ch_level") != null) {
											ch_level = class_map.get("ch_level").toString();
										}
										
										if(ch_desc.equals("")){
											ch_desc = "��Ƶ������";
										}
										if (class_map.get("ch_id") != null) {
											ch_id = class_map.get("ch_id").toString();
										}
										if (class_map.get("ch_attr") != null) {
											ch_attr = class_map.get("ch_attr").toString();
										}
										downList = channel.getChSon (ch_id);
										
						%>
						<tr class="u2">
							<td align=left>
								<font color="black"><%=ch_name%></font>
							</td>
							<td align=left>
								<%=ch_level%>
							</td>
							<td align=left>
								<%=up_ch_name%>
							</td>
							<td align=left>
								<%=ch_desc%>
							</td>							
							<td align=center>
								<a href="addNewsIndex.jsp?class_id=<%=ch_id%>" target=""><img src="/admin/images/xinzeng.png" border="0"></a>
							</td>
						</tr>
						<%
								}
							}else{
						%>
						<tr align=center ><td colspan="5">���޼�¼!</td></tr>
						<%
							}
						%>
					</table>
				</td>
			</tr>
			
		</table>
	</body>
</html>


