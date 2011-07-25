<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/wealthMgr.js">
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;}
		 .t1{background-color:#ffffff; color:#000000;font-size:12px;}
		 .t2{background-color:#f6f6f6; color:#000000;font-size:12px;}
		</style>
		
		<%
		ArrayList list = comparam.getCompareInfoByAttr("101");
		%>
	</head>
	<body>
		
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="f0c4n2mMM080X0G85Be8" />
		</jsp:include>
			
								<table width=800 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
									<tr>
										<td background="/images/newsbg.gif" align="center" width="15%">
											会员级别
										</td>
										<td background="/images/newsbg.gif" align="center" width="30%">
											会员动作
										</td>
										<td background="/images/newsbg.gif" align="center" width="15%">
											奖励黄金数量
										</td>
										<td background="/images/newsbg.gif" align="center" width="15%">
											重新设置
										</td>
										<td background="/images/newsbg.gif" align="center" width="15%">
											删除
										</td>
									</tr>
									<%
									  if(list !=null && list.size()>0){
									    for(int i=0;i<list.size();i++){
									       HashMap map=(HashMap)list.get(i);
									       String para_code1="";
									       if(map.get("para_code1")!=null){para_code1=map.get("para_code1").toString();}
									       String para_code2="";
									       if(map.get("para_code2")!=null){para_code2=map.get("para_code2").toString();}
									       String para_code3="";
									       if(map.get("para_code3")!=null){para_code3=map.get("para_code3").toString();}
									       String para_code4="";
									       if(map.get("para_code4")!=null){para_code4=map.get("para_code4").toString();}
									       String para_code5="";
									       if(map.get("para_code5")!=null){para_code5=map.get("para_code5").toString();}
									       if(i%2==0){
									        out.print("<tr class=t1>");
									       }else{
									        out.print("<tr class=t2>");
									       }
									 %>
										<td align="left" width="15%">
											<%=para_code5%>
										</td>
										<td align="left" width="30%">
											<%=para_code2%>
										</td>
										<td align="center" width="15%">
											<%=para_code3%>两黄金
										</td>
										<td align="center" width="15%">
											<a href="editWealth.jsp?code1=<%=para_code1%>&code4=<%=para_code4%>" TARGET=appwin onclick="mydefss()"><img src=/img/edit.png width=16 height=16 border=0 alt="重新设置会员财富"></a>
										</td>
										<td align="center" width="15%">
											<a href="/doTradeReg.do?para_code1=<%=para_code1%>&trade_type_code=1189&subsys_code=B2B&param_attr=101&amp;para_code4=<%=para_code4%>" onclick="return chechIfo()" target="_self" ><img src=/img/del.gif width=16 height=16 border=0 alt="删除会员财富设置"></a>
										</td>
									</tr>
									 <%      
									    }
									  }
									%>
								</table>
<table>
	<tr>
		<td height="30">
		</td>
	</tr>
</table>
	</body>
</html>




