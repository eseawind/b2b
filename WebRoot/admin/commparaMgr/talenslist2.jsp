<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
		request.setCharacterEncoding("gbk");
    String iStart ="0";
   	if(request.getParameter("iStart")!=null){
   		iStart = request.getParameter("iStart");
   	}
   	String param_attr="",param_name="",param_code="";
   	String param = "";
   	if(request.getParameter("param")!=null){
   		param = request.getParameter("param");
   	}
   	if(request.getParameter("param_code")!=null){
   		param_code = request.getParameter("param_code");
   	}
 ParamethodMgr para = new ParamethodMgr();
 ArrayList paraList=new ArrayList();
 paraList =para.getallCompareInfoByCode2(Integer.parseInt(iStart),param_code);
 int counter=para.getallCompareInfoByCodeA2(param_code); 
 if(!param.equals("") ){
   		param_attr = param;
   		param_name = param;
 		paraList =para.getallCompareInfoBySearchANC2(Integer.parseInt(iStart),param_attr,param_name,param_code);
 		counter = para.getallCompareInfoBySearchANC2(param_attr,param_name,param_code);
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
	  
        String subsys_code1="", param_attr1 ="",param_code1="";
	 if(null != paraList && paraList.size()>0)
      {
      	 for (int i=0;i<paraList.size();i++)
           {
	      HashMap map = (HashMap) paraList.get(i);
	      
	      if (map.get("subsys_code") != null) {subsys_code1 = map.get("subsys_code").toString();}
	      if (map.get("param_attr") != null) {param_attr1 = map.get("param_attr").toString();}
	      if (map.get("param_code") != null) {param_code1 = map.get("param_code").toString();}
	  	}
	 }
	String url = "addCommpara2.jsp?param_code="+param_code1+"&subsys_code="+subsys_code1+"&param_attr="+param_attr1;
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
	<form action="talenslist2.jsp?param_code=<%=param_code%>" method="post" name="searchForm">
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
					<td align="left" class="head">
						<a href="addCommpara.jsp?param_code=<%=param_code%>">新增参数</a>
					</td>
			</tr>
		</table>

		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#efefef">
			
			<tr bgcolor="white">
				<td align="left">
					<b>输入关键字</b>：<input type=text name="param" id="param" value="<%=param%>" size="20" maxlength="20"/>&nbsp;&nbsp;
					<img src="/admin/images/chaxun.gif" onclick="search();" style="cursor:hand">
				</td>	
		</tr>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td>
		     <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
			      <tr class="u4" height="25">
								<td width="10%" align="center">系统标识</td>
								<td width="10%" align="center">参数属性</td>
								<td width="10%" align="center">参数代码</td>
								<td width="20%" align="center">参数内容</td>
								<td width="10%" align="center">参数标识</td>
								<td width="20%" align="center">参数说明</td>
								<td width="10%" align="center">修改</td>
								<td width="10%" align="center">删除</td>
			       </tr>
		        <%  
		            if(null != paraList && paraList.size()>0)
		            {
		            	 for (int i=0;i<paraList.size();i++)
		                 {
		              String subsys_code="", para_code1 ="",para_code2="";
						      HashMap map = (HashMap) paraList.get(i);
						      
						      if (map.get("subsys_code") != null) {subsys_code = map.get("subsys_code").toString();}
						      if (map.get("param_attr") != null) {param_attr = map.get("param_attr").toString();}
						      if (map.get("param_code") != null) {param_code = map.get("param_code").toString();}
						      if (map.get("param_name") != null) {param_name = map.get("param_name").toString();}				     
						      if(map.get("para_code1") != null) {para_code1 = map.get("para_code1").toString();}
						      if(map.get("para_code2") != null) {para_code2 = map.get("para_code2").toString();};						     
									%>
				          <tr class="u2" >
								  	 <td  align=center><%=subsys_code%></td>
								  	 <td  align=center><%=param_attr%></td>
								  	 <td  align=center><%=param_code%></td>
								  	 <td  align=center><%=param_name%></td>
								  	 <td  align=center><%=para_code1%></td>
								  	 <td  align=center><%=para_code2%></td>
								  	 <td  align=center><a href="updateCommpara.jsp?subsys_code=<%=subsys_code%>&param_attr=<%=param_attr%>&param_code=<%=param_code%>&Thename=<%=param_name%>&hongdong=<%=para_code1%>&hongdong2=<%=para_code2%>" ><img src="/images/edit.png" border="0"/></a></td>
								  	 <td  align=center><a href=/doTradeReg.do?subsys_code=<%=subsys_code%>&param_code=<%=param_code%>&param_attr=<%=param_attr%>&cust_name=<%=para_code1%>&trade_type_code=1125 target="_self"><img src="/admin/images/shanchu.gif" border="0"/></a></td>										  	 
									</tr>
									<%
									  }
									%>
						<tr>
										<td background="/images/kehu_list_17.gif"  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
										<td background="/images/kehu_list_17.gif" align="right" colspan="6"  style=" padding:2px 5px;">
										<a href="talenslist2.jsp?param=<%=param%>&param_code=<%=param_code%>&iStart=0">首页 </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="talenslist2.jsp?param=<%=param%>&param_code=<%=param_code%>&iStart=<%=pageUp%>">上一页</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="talenslist2.jsp?param=<%=param%>&param_code=<%=param_code%>&iStart=<%=pageDown%>">下一页 </a>&nbsp; 
										<%
											}
										%>
										<a  href=talenslist2.jsp?param=<%=param%>&param_code=<%=param_code%>&iStart=<%=pages-1%>>尾页</a></td>
			
							         </tr>
			
		    </table>
	     </td>
	  </tr>	
	  	<%
				}
		       %>
				<% if( paraList==null || paraList.size()<=0){%>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#efefef">
					<tr bgcolor="white">
					<td>
					<center>没有您要查询的数据</center>
				</td>
			</tr>
		</table>
				<%}%>
					 <tr >
					      <td colspan="4">
					      		<center>
					      			<img src="/admin/images/comeback.JPG" onClick="location.href='talentsList.jsp'" style="cursor:hand;" align="absmiddle">
					      		</center>
					      	</td>
						 </tr>
	</table>
	</table>
</form>	
</body>
</html>



