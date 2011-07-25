<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>

<%
	Custinfo cus = new Custinfo();
	ArrayList OneMonth = new ArrayList();//注销
	ArrayList TwoMonth = new ArrayList();//冻结
	OneMonth = cus.getAllCustBySum("1");
	TwoMonth = cus.getAllCustBySum("2");
	int maxleng = 0;
	if(TwoMonth!=null){
		if(TwoMonth.size()>maxleng){
			maxleng = TwoMonth.size();
		}
	}
	if(OneMonth!=null){
		if(OneMonth.size()>maxleng){
			maxleng = OneMonth.size();
		}
	}
%>

<html>
	<head>
		<title>中国石油信息网</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<table  width="100%">
		<tr>
			<td  width="25%">
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				<tr class="u3">
					<td colspan="2">
						当前已注销客户
					</td>
				</tr>
			<tr class="u4" height="20" width="25%">
				<td align="center"  width="50%">
					注册地址
				</td>
				<td align="center" width="50%">
					注册人数
				</td>
			</tr>
			<%
				int onesize = 0;
				int sumoneMonth = 0;
				if(OneMonth!=null){
				onesize = OneMonth.size();
				String area_name="",countmun="";
					for(int i=0;i<OneMonth.size();i++){
					HashMap map1 = (HashMap)OneMonth.get(i);
					if(map1.get("area_name")!=null){
					area_name = map1.get("area_name").toString();
					}
					if(map1.get("count")!=null){
					countmun = map1.get("count").toString();
					sumoneMonth = sumoneMonth + Integer.valueOf(countmun).intValue();
					}%>
					<tr class="u2">
						<td>
							<%=area_name%>
						</td>
						<td>
							<%=countmun%>
						</td>
					</tr>
				<%}
			}%>
					<tr class="u2">
						<td>
							总数
						</td>
						<td>
							<%=sumoneMonth%>
						</td>
					</tr>
			<%for(int j=0;j<maxleng-onesize;j++){
			%>
			<tr class="u2">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<%}%>
		</table>
	</td>
			<td  width="25%">
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				<tr class="u3">
					<td colspan="2">
						当前已冻结客户
					</td>
				</tr>
			<tr class="u4" height="20" width="25%">
				<td align="center"  width="50%">
					注册地址
				</td>
				<td align="center" width="50%">
					注册人数
				</td>
			</tr>
			<%
				int twosize = 0;
				int sumTwoMonth = 0;
				if(TwoMonth!=null){
				twosize = TwoMonth.size();
				String area_name="",countmun="";
					for(int i=0;i<TwoMonth.size();i++){
					HashMap map1 = (HashMap)TwoMonth.get(i);
					if(map1.get("area_name")!=null){
					area_name = map1.get("area_name").toString();
					}
					if(map1.get("count")!=null){
					countmun = map1.get("count").toString();
					sumTwoMonth = sumTwoMonth + Integer.valueOf(countmun).intValue();
					}%>
					<tr class="u2">
						<td>
							<%=area_name%>
						</td>
						<td>
							<%=countmun%>
						</td>
					</tr>
				<%}
			}%>
					<tr class="u2">
						<td>
							总数
						</td>
						<td>
							<%=sumTwoMonth%>
						</td>
					</tr>
			<%
			for(int j=0;j<maxleng-twosize;j++){
			%>
			<tr class="u2">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<%}%>
		</table>
	</td>
</tr>
</table>
</body>
</html>


