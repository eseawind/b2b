<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="java.util.*,tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.FileOperate"%>
<%@ page import="com.saas.biz.channelColumnMgr.ChannelColumnInfo"%>
<%
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("ecms_path");
		 
	Custinfo custInfo = new Custinfo();
	String cust_id="",template="";
	if (session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}

	template = new ChannelColumnInfo().getTemplateFolder( cust_id );
	 
%>
<html>
	<head>
		<title>��ҵվģ�����</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
					
			<script language="javascript">
			 function secBoard(n)
			{
				for(var i=0;i<3;i++) {
					
					if (i==n) {
						document.getElementById('bo' + n).style.display="block";
					} else {
						document.getElementById('bo' + i).style.display="none";
					}
				}
			}
			</script>
			
	</head>
	<body>
			
			
			<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" >
				<tr class="u1">
					<td class="head" align="left">
						<a href="javascript:secBoard(0);">������ҵվ</a>
					</td>
					<td class="head" align="left">
						<a href="javascript:secBoard(1);">ѡ������ģ��</a>
					</td>
					<td class="head" align="left">
						<a href="javascript:secBoard(2);">�޸���ҵģ��</a>
					</td>
				</tr>
			</table>
			
			
			<div id="bo0">
				<b>������ҵվ��ҳ</b><br>
				<iframe src="/member/createHtmlMgr/createIndex.jsp" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" ></iframe> 
				<b>������ҵվ��Ŀ</b><br>
				<iframe src="/member/createHtmlMgr/createChannel.jsp" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" ></iframe> 
				<b>������ҵվ��ϸҳ</b><br>
				<iframe src="/member/createHtmlMgr/creatArticle.jsp" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" ></iframe> 
			</div>
			
			
			<div id="bo1" style="display:none;">
				<iframe src="/member/comm/updateCustTemplates.jsp" width="100%" height="400"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" ></iframe> 
			</div>
			
			<div id="bo2" style="display:none;">
				<iframe src="/member/comm/templateList.jsp?templateFolder=<%=template%>" height="800" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" ></iframe> 
			</div>
			
			

	</body>
</html>


		




