<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="com.saas.biz.apphighcustMgr.ApphighcustInfo"%>
<%
	request.setCharacterEncoding("GBK");
	String it = "0",key_word="";
	String iStart = "0";
	if (request.getParameter("iStart") != null) 
	{
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("i") != null) {
		it = request.getParameter("i");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word");
	}
	if(it.equals("1")){
		key_word=URLDecoder.decode(key_word,"GBK");
		key_word= new String(key_word.getBytes("ISO-8859-1"),"GBK");
	}
	ApphighcustInfo app = new ApphighcustInfo();
	ArrayList custlist = new ArrayList();
	custlist = app.getAllApp(Integer.valueOf(iStart).intValue());
	int counter = app.getAllApp();
	if(!key_word.equals("")){
		custlist = app.getByKey(Integer.valueOf(iStart).intValue(),key_word);
		counter = app.getByKey(key_word);
	}
	int pages = (counter-1) / 20 + 1;
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
		<title>中国石油信息网</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="javascript">
		function Check_Value(){
	       if(document.getElementById("keyword").value ==null || document.getElementById("keyword").value ==""){
	        alert("请输入关键字！");
	        return false;
	       }
	    document.indexform.submit();
	  }
	  </script>
	</head>
	<body>
	<form action="indexappHight.jsp" method="post" name="indexform">
		<table  width="100%" border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
			<tr>
				<td class="u2">
				请输入公司名称:<input type="text" id="keyword" name="key_word"  value="">&nbsp;
				<img src="/admin/images/chaxun.gif" onClick="Check_Value();" align="absmiddle">
				</td>
			</tr>
		</table>
			<%if(null==custlist) {%>
		<center>没有您要查询的记录。</center>
	<%} else{%>
	<table width="100%" border="0" cellpadding="1" cellspacing="1"
			align="center" bgcolor="#DEEDFD">
			<tr class="u4" height="25">
				<td align="left"  width="30%">
					公司名称
				</td>
				<td align="left" width="20%">
					当前级别
				</td>
				<td align="left" width="15%">
					申请级别
				</td>
				<td align="left" width="25%">
					申请时间
				</td>
				<td align="center" width="10%">
					申请验证
				</td>
			</tr>
			<%
			if(null!=custlist){
				CustClass level=new CustClass();
				ParamethodMgr par = new ParamethodMgr();
				String cust_aim="",in_date="",cust_type="",app_level="",cust_id2="",trade_id="",pass_or_not="";
				for(int i = 0;i<custlist.size();i++){
					HashMap map = (HashMap)custlist.get(i);
					if(map.get("pass_or_not")!=null){
						pass_or_not = map.get("pass_or_not").toString();
					}
					if(map.get("trade_id")!=null){
						trade_id = map.get("trade_id").toString();
					}
					if(map.get("cust_id")!=null){
						cust_id2 = map.get("cust_id").toString();
					}
					if(map.get("app_level")!=null){
						app_level = map.get("app_level").toString();
					}
					if(map.get("in_date")!=null){
						in_date = map.get("in_date").toString();
					}
					if(map.get("cust_aim")!=null){
						cust_aim = map.get("cust_aim").toString();
					}
					String app_level1="";
					cust_type = level.cust_Class_Name( cust_id2 );
					app_level1 = par.getParaCode2ByParaCode1("14",app_level);
					if(in_date.length()>10){
						in_date = in_date.substring(0,10);
					}
			%>
				<tr class="u2">
						<td align="left"><a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id2%>&user_id="><%=cust_aim%></a></td>
						<td align="left"><%=cust_type%></td>
						<td align="left"><%=app_level1%></td>
						<td align="left"><%=in_date%></td>
						<%if(pass_or_not.equals("1")){%>
						<td align="center">已审批</td>
						<%}else{%>
						
						<td align=center><a href="/doTradeReg.do?cust_id=<%=cust_id2%>&trade_type_code=2248&trade_id=<%=trade_id%>&cust_class=<%=app_level%>&now_class_type=<%=app_level%>"><img src=/images/edit.gif width=16 height=16 border=0></a></td>
			<%}
			}
				}
				%>	<tr>
				<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
				<td align="right" colspan="3"  style=" padding:2px 5px;">
				<a href="indexappHight.jsp?iStart=0&key_word=<%=key_word %>&i=1">首页 </a>&nbsp; &nbsp;
				<% 
					if(Integer.parseInt(iStart)>0){
				%>
					<a href="indexappHight.jsp?iStart=<%=pageUp %>&i=1">上一页</a> &nbsp;
				<%
					}
					if(Integer.parseInt(iStart)<pages-1){
				%>
					<a href="indexappHight.jsp?iStart=<%=pageDown%>&key_word=<%=key_word%>&i=1">下一页 </a>&nbsp; 
				<%
					}
				%>
				<a  href="indexappHight.jsp?iStart=<%=pages-1 %>&key_word=<%=key_word %>&i=1">尾页</a></td>
	   </tr>
		</table>
		<%} %>
		

		</form>	
	<body>
</html>



