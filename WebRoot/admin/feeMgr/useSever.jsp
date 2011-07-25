<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="custBean" class="com.saas.biz.serverMgr.ServerInfo" scope="page" />
<%@ page import="java.util.*"%>
<%
	String cust_id = "";
	if (request.getParameter("cust_id") != null) {
		cust_id = request.getParameter("cust_id");
	}
	ArrayList list = custBean.getUseServerListByCust(cust_id,"0");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		#tr{
		 background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align: center;
		}
		#tr1{
		 background-color:#f6f6f6; color:#000000; font-size:12px;
		}
		#tr2{
		 background-color:#ffffff; color:#000000; font-size:12px;
		}
		</style>
	</head>
	<body>
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr id="tr">
				<td> 
				  务名称 
				</td>
				<td>
				  开始时间
				</td>
				<td>
				  结束时间
				</td>
				<td >
				  已交费用
				</td>
				<td >
				  订购期限
				</td>
				<td>
				  服务计量单位
				</td>
			</tr>
			<%
			 int sum=0;
			  if(list !=null && list.size()>0){
			    for(int i=0;i<list.size();i++){
			       HashMap map=(HashMap)list.get(i);
			       String para_code2="",start_date="",end_date="",para_code4="0",rsrv_str9="0",para_code5="";
			       if(map.get("para_code2")!=null){para_code2=map.get("para_code2").toString();}
			       if(map.get("para_code4")!=null){para_code4=map.get("para_code4").toString();}
			       if(map.get("para_code5")!=null){para_code5=map.get("para_code5").toString();}
			       if(map.get("rsrv_str9")!=null){rsrv_str9=map.get("rsrv_str9").toString();}
			       if(map.get("start_date")!=null){start_date=map.get("start_date").toString();if(start_date.length()>10){start_date=start_date.substring(0,10);}}
			       if(map.get("end_date")!=null){end_date=map.get("end_date").toString();if(end_date.length()>10){end_date=end_date.substring(0,10);}}
			       int sumMoney=0,month=0;
			        String unit="";
			       try{
								if(para_code5.equals("1") || para_code5.equals("0")){
				           unit="季度";
				           month=Integer.parseInt(rsrv_str9)/3;
				       }else{
				           unit="年";
				           month=Integer.parseInt(rsrv_str9)/12;
				       }
				       sumMoney=month*Integer.parseInt(para_code4);
			        }catch(Exception e){
			       }
			       if(i%2==0){
				    %><tr id="tr2"><%
				   }else{
				    %><tr id="tr1"><%
				   }
				   sum=sumMoney+sum;
				   %>
				    <td align="left"><%=para_code2%></td>
				    <td align="center"><%=start_date%></td>
				    <td align="center"><%=end_date%></td>
				    <td align="left"><%=sumMoney%></td>
				    <td align="center"><%=month%><%=unit%></td>
				    <td align="center"><%=unit%>/<%=para_code4%></td>
				</tr>
				<%
			    }
			  }
			%>
			<input type="hidden" id="sum" name="sum" value="<%=sum%>">
		</table>
	</body>
</html>




