<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=gbk" %>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
 

<%
	/*request.setCharacterEncoding("GBK");
	String it = "0";
	if (request.getParameter("i") != null) {
		it = request.getParameter("i");
	}*/
  String start_time1 ="",end_time1 ="",code="",key_word="",cust_class="";
  Calendar cal = Calendar.getInstance();
  if (request.getParameter("start_time") != null) {
		start_time1 = request.getParameter("start_time");
	}
	if (request.getParameter("end_time") != null) {
		end_time1 = request.getParameter("end_time");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word");
	}
	
	if (request.getParameter("cust_class") != null) {
		cust_class = request.getParameter("cust_class").trim(); 
	}
	
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

	String meun_idx = "";
	String iStart = "0";
	if (request.getParameter("iStart") != null) 
	{
		iStart = request.getParameter("iStart");
	}
	CustClass level=new CustClass();
	Custinfo custEntity = new Custinfo();
	int counter = 0 ;
  ArrayList custArray = new ArrayList();
  ParamethodMgr paramCom = new ParamethodMgr();
	String customer_class = paramCom.getSelectItems("14");
	//if( it.equals("1"))
	//{
	key_word=URLDecoder.decode(key_word,"GBK");
	key_word= new String(key_word.getBytes("ISO-8859-1"),"GBK");
	//}
	
	if("1".equals(code))
	{
		custArray = custEntity.getCustListByStateKey(Integer.valueOf(iStart).intValue(), "0", key_word, cust_class,start_time1,end_time1);
		counter = custEntity.getCustListByStateKey("0",key_word,cust_class,start_time1,end_time1);
	}
	else
	{
		custArray = custEntity.getCustListByState(Integer.valueOf(iStart).intValue(), "0");
		counter = custEntity.getCustListByState("0");
	}
	
	int pages = (counter-1) / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) 
	{
		if (currenPage > 0) 
		{
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} 
	else if (pages == currenPage) 
	{
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
	
%>
<html>
	<head>
		<title>中国石油信息网</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/Calendar_Ly.js"></script>
	</head>
 
<script language="javascript">
	  function Check_Value()
	  {
	       if(document.getElementById("start_time").value ==null || document.getElementById("start_time").value =="")
		   {
	        	alert("请选择开始时间！");
	        	return false;
	       }
	       if(document.getElementById("end_time").value ==null || document.getElementById("end_time").value =="")
		   {
	       	 	alert("请选择结束时间！");
	        	return false;
	       }
	    document.indexform.submit();
	  }
</script>
	<body>
	<form action="index.jsp" method="post" name="indexform">
		<table  width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="#FCB0B0" align="center">
			<tr>
				<td class="u2">
				公司名称:<input type="text" id="keyword1" name="key_word"  value="">
				级别：<select name="cust_class" id="cust_class">
						<option value="">请选择...</option>
						<%=customer_class%>
					</select>
				</td>
			</tr>
			<tr>
				<td class="u2">
					开始时间:<input type="text" id="start_time" name="start_time" onFocus="setday(this);" value="<%=start_time%>">
					结束时间:<input type="text" id="end_time" name="end_time" onFocus="setday(this);" value="<%=end_time%>">
					<img src="/admin/images/chaxun.gif" onClick="Check_Value();" align="absmiddle">
					<input type="hidden" name="code" value="1">
				</td>
			</tr>
		</table>
	</form>	
	<%
		if( null == custArray && "1".equals( code ) ) 
		{
	%>
		<center>没有您要查询的记录。</center>
	<%	} 
		else
		{
	%>
		<table width="98%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
			<tr class="u4" height="25">
				<td align="left"  width="20%">公司名称</td>
				<td align="left" width="15%">客户类型</td>
				<td align="left" width="20%">管理员姓名</td>
				<td align="left" width="15%">联系电话</td>
				<td align="left" width="20%">公司地址</td>
				<td align="center" width="8%">修改</td>
			</tr>
			<%
			    if (custArray != null && custArray.size() > 0) 
			    {
						for (Iterator inIt = custArray.iterator(); inIt.hasNext();) 
						{
							HashMap map = (HashMap) inIt.next();
							String cust_id = "";
							String cust_name = "",cust_type="";
							String phone = "";
							String cust_addr = "";
							String cust_aim = "";
							cust_id = map.get("cust_id").toString();
							if(map.get("cust_name") != null) {
								cust_name = map.get("cust_name").toString();
							}
							if(map.get("cust_aim") != null) {
								cust_aim = map.get("cust_aim").toString();
							}							
							if (map.get("group_contact_phone") != null) {
								phone = map.get("group_contact_phone").toString();
							}							
							if (map.get("company_address") != null) {
								cust_addr = map.get("company_address").toString();
							}
							//out.println(cust_id);
							cust_type = level.cust_Class_Name( cust_id );
					%>
					<tr class="u2">
						<td align="left"><a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>&user_id=" onClick="mydefss()"><%=cust_aim%></a></td>
						<td align="left"><%=cust_type%></td>
						<td align="left"><%=cust_name%></td>
						<td align="left"><%=phone%></td>
						<td align="left"><%=cust_addr%></td>
						<td align=center><a href="modifyRelation.jsp?cust_id=<%=cust_id%>" onclick="mydefss()"><img src=/images/edit.gif width=16 height=16 border=0></a></td>
					</tr>
					<%
					}
					%>
						<tr>
				<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
				<td align="right" colspan="3"  style=" padding:2px 5px;">
				<a href="index.jsp?iStart=0&key_word=<%=key_word %>&cust_class=<%=cust_class%>&start_time=<%=start_time %>&end_time=<%=end_time %>&code=<%=code %>&i=1">首页 </a>&nbsp; &nbsp;
				<% 
					if(Integer.parseInt(iStart)>0){
				%>
					<a href="index.jsp?iStart=<%=pageUp %>&key_word=<%=key_word %>&cust_class=<%=cust_class%>&start_time=<%=start_time %>&end_time=<%=end_time %>&code=<%=code%>&i=1">上一页</a> &nbsp;
				<%
					}
					if(Integer.parseInt(iStart)<pages-1){
				%>
					<a href="index.jsp?iStart=<%=pageDown%>&key_word=<%=key_word%>&cust_class=<%=cust_class%>&start_time=<%=start_time%>&end_time=<%=end_time%>&code=<%=code%>&i=1">下一页 </a>&nbsp; 
				<%
					}
				%>
				<a  href="index.jsp?iStart=<%=pages-1 %>&key_word=<%=key_word %>&cust_class=<%=cust_class%>&start_time=<%=start_time %>&end_time=<%=end_time %>&code=<%=code%>&i=1">尾页</a></td>

	   </tr>
					<%
			}
			%>
		</table>
		<%} %>
		
	<body>
</html>




