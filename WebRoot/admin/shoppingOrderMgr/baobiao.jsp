<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>

<%
	Custinfo cus = new Custinfo();
	ArrayList OneMonth = new ArrayList();
	ArrayList TwoMonth = new ArrayList();
	ArrayList HalfYear = new ArrayList();
	ArrayList OneYear = new ArrayList();
	OneMonth = cus.GetYearAndArea(1);
	TwoMonth = cus.GetYearAndArea(2);
	HalfYear = cus.GetYearAndArea(3);
	OneYear = cus.GetYearAndArea(4);
	
	int maxleng = 0;
	if(OneYear!=null){
		maxleng = OneYear.size();
	}
	if(HalfYear!=null){
		if(HalfYear.size()>maxleng){
			maxleng = HalfYear.size();
		}
	}
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
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
				<tr class="u3">
					<td colspan="2">
						近一个月会员注册报表
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
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
				<tr class="u3">
					<td colspan="2">
						近两个月会员注册报表
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
			<td  width="25%">
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
				<tr class="u3">
					<td colspan="2">
						近半年会员注册报表
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
				int halfsize = 0;
				int sumHelfYear = 0;
				if(HalfYear!=null){
					halfsize = HalfYear.size();
				String area_name="",countmun="";
					for(int i=0;i<HalfYear.size();i++){
					HashMap map1 = (HashMap)HalfYear.get(i);
					if(map1.get("area_name")!=null){
					area_name = map1.get("area_name").toString();
					}
					if(map1.get("count")!=null){
					countmun = map1.get("count").toString();
					sumHelfYear = sumHelfYear + Integer.valueOf(countmun).intValue();
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
							<%=sumHelfYear%>
						</td>
					</tr>
			<%
			for(int j=0;j<maxleng-halfsize;j++){
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
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#FCB0B0">
				<tr class="u3">
					<td colspan="2">
						近一年会员注册报表
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
				int yearsize = 0;
				int sumOneYear = 0;
				if(OneYear!=null){
					yearsize = OneYear.size();
				String area_name="",countmun="";
					for(int i=0;i<OneYear.size();i++){
					HashMap map1 = (HashMap)OneYear.get(i);
					if(map1.get("area_name")!=null){
					area_name = map1.get("area_name").toString();
					}
					if(map1.get("count")!=null){
					countmun = map1.get("count").toString();
					sumOneYear = sumOneYear + Integer.valueOf(countmun).intValue();
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
							<%=sumOneYear%>
						</td>
					</tr>
			<%
			for(int j=0;j<maxleng-yearsize;j++){
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


