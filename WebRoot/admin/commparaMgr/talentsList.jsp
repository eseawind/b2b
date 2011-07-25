<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
		//request.setCharacterEncoding("gbk");
    String iStart ="0";
   	if(request.getParameter("iStart")!=null){
   		iStart = request.getParameter("iStart");
   	}
   	String param_attr="",param_name="",param_code="";
   	String param = "";
   	if(request.getParameter("param")!=null){
   		param = request.getParameter("param");
   		param = new String(param.getBytes("ISO-8859-1"),"GBK");
   	}
 ParamethodMgr para = new ParamethodMgr();
 ArrayList paraList=new ArrayList();
 paraList =para.getallCompareInfoByCode(Integer.parseInt(iStart));
 int counter=  para.getallCompareInfoByCodeA(); 
 if(!param.equals("") ){
   		param_attr = param;
   		param_name = param;
   		param_code = param;
 		paraList =para.getallCompareInfoBySearchANC(Integer.parseInt(iStart),param_attr,param_name,param_code);
 		counter = para.getallCompareInfoBySearchANC(param_attr,param_name,param_code);
 }
	int pages = counter / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.parseInt(iStart);
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
<title>参数管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function search(){
				if(document.getElementById('param').value=='' ){
						alert('请输入关键字！');
						return false;
				}
				document.searchForm.submit();
			}
	 </script>
</head>
<body>
	<form action="talentsList.jsp" method="post" name="searchForm">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
						<a href="addCommpara.jsp">新增参数</a>
				</td>
			</tr>
		</table>

		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#efefef">
			
			<tr class="u1">
				<td align="left">
					<b>输入关键字</b>：<input type=text name="param" id="param" value="<%=param%>" size="20" maxlength="20"/>&nbsp;&nbsp;
					<img src="/admin/images/chaxun.gif" onclick="search();" style="cursor:hand">
				</td>	
		</tr>
	</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td>
		     <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
		     	 <%  
		            if(null != paraList && paraList.size()>0)
		            {%>
			      <tr class="u4" height="25">
								<td width="20%" align="left">参数名称</td>
								<td width="25%" align="left">参数类型</td>
								<td width="25%" align="left">参数代码</td>
								<td width="30%" align="left">参数说明</td>
			       </tr>
			       <%}%>
		        <%  
		            if(null != paraList && paraList.size()>0)
		            {
		            	 for (int i=0;i<paraList.size();i++)
		                 {
		              String para_code4="", para_code1 ="",para_code2="";
						      HashMap map = (HashMap) paraList.get(i);
						      
						      if (map.get("para_code4") != null) {para_code4 = map.get("para_code4").toString();}
						      if (map.get("param_attr") != null) {param_attr = map.get("param_attr").toString();}
						      if (map.get("param_code") != null) {param_code = map.get("param_code").toString();}
						      if (map.get("param_name") != null) {param_name = map.get("param_name").toString();}					     
									%>
				          <tr class="u2" >
								  	 <td  align=left><a href="talenslist2.jsp?param_code=<%=param_code%>"><%=param_name%></a></td>
								  	 <td  align=left><%=param_code%></td>
								  	 <td  align=left><%=param_attr%></td>
								  	 <td  align=left><%=para_code4%></td>
									</tr>
									<%
									  }
									%>
					<%
				}
		       %>
						<tr>
										<td background="/images/kehu_list_17.gif"  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td background="/images/kehu_list_17.gif" align="right" colspan="6"  style=" padding:2px 5px;">
										<a href="talentsList.jsp?param=<%=param%>&iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="talentsList.jsp?param=<%=param%>&iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="talentsList.jsp?param=<%=param%>&iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href="talentsList.jsp?param=<%=param%>&iStart=<%=pages-1%>">尾页</a></td>
			
							         </tr>
		    </table>
	     </td>
	  </tr>
				<%if( null==paraList ){%>
		<table width=800 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#efefef">
					<tr bgcolor="white">
					<td>
					<center>没有您要查询的数据</center>
				</td>
			</tr>
		</table>
				<%}%>
	</table>
</form>	
</body>
</html>



