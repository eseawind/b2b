<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.propertyuMgr.*"%>
<%@ page import="com.saas.biz.commen.*"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;}
		 .t1{background-color:#ffffff; color:#000000;font-size:12px;}
		 .t2{background-color:#f6f6f6; color:#000000;font-size:12px;}
		</style>
		<%
		    String iStart ="1";
		    if (request.getParameter("iStart") != null)
              {
                     iStart = request.getParameter("iStart");
                }
				PropertyuInfo propertyuinfo =new PropertyuInfo();
				ArrayList wealthList=propertyuinfo.getUserPropertyByAll(Integer.valueOf(iStart).intValue(), "0");
		         int counter=propertyuinfo.getUserPropertyByAllNum( "0");
		         PageTools tools=new PageTools();
			    String pageTools=tools.getPageTools(String.valueOf(counter),"30","manageWealth.jsp?iStart=",Integer.parseInt(iStart));
		%>
	</head>
	<body>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 10px" >
				<tr>
					<!-- 中间 -->
					<td align="center" height="27px">
						<div id="manager_body">
							<div id="manager_body_right">
								<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
									<tr class="u4" height="25">
										<td align="center" width="20%">
											会员名称
										</td>
										<td align="center" width="30%">
											客户名称
										</td>
											<td align="center" width="10%">
											客户级别
										</td>
										<td align="center" width="20%">
											黄金数量
										</td>
										<td align="center" width="20%">
											重新设置
										</td>
									</tr>
									<%
									  if(wealthList !=null && wealthList.size()>0){
									    for(int i=0;i<wealthList.size();i++){
									       HashMap map=(HashMap)wealthList.get(i);
									       String user_id="";
									       if(map.get("user_id")!=null){user_id=map.get("user_id").toString();}
									       String acct_id="";
									       if(map.get("acct_id")!=null){acct_id=map.get("acct_id").toString();}
									       String property_type="";
									       if(map.get("property_type")!=null){property_type=map.get("property_type").toString();}
									       String property_value="";
									       if(map.get("property_value")!=null){property_value=map.get("property_value").toString();}
									       String enable_tag="";
									       if(map.get("enable_tag")!=null){enable_tag=map.get("enable_tag").toString();}
									       String user_name="";
									        if(map.get("user_name")!=null){user_name=map.get("user_name").toString();}
									      String cust_type="";
									      if(map.get("cust_type")!=null){cust_type=map.get("cust_type").toString();
									         cust_type=comparam.getParamNameByValue("14",cust_type);
									      }
									      String cust_name="";
									       if(map.get("cust_name")!=null){cust_name=map.get("cust_name").toString();}
									       String cust_id="";
									        if(map.get("cust_id")!=null){cust_id=map.get("cust_id").toString();}
									        
									  %>
										<td align="left" width="20%" class="u2" >
											<%=user_name%>
										</td>
										<td align="left" width="30%" class="u2">
											<%=cust_name%>
										</td>
										<td align="left" width="10%" class="u2">
											<%=cust_type%>
										</td>
										<td align="center" width="20%"class="u2">
											<%=property_value%>两黄金
										</td>
										<td align="center" width="20%" class="u2">
											<a href="singleEditWealth.jsp?user_name=<%=user_name%>&cust_type=<%=cust_type%>&cust_id=<%=cust_id%>&property_value=<%=property_value%>&acct_id=<%=acct_id%>" ><img src=/img/edit.png width=16 height=16 border=0 alt="重新设置会员财富"></a>
										</td>							
								 
									 <%      
									    }
									  }
									%>
									<tr class="u1"><%=pageTools%></tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
	</body>
</html>



