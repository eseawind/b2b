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
	OneMonth = cus.getAllInfo(1);
	out.println(OneMonth);
	int onesize = 0;
	if(OneMonth!=null){
		onesize = OneMonth.size();
	}
	int twosize = 0;
	if(TwoMonth!=null){
		twosize = TwoMonth.size();
	}
	int threesize = 0;
	if(HalfYear!=null){
		threesize = HalfYear.size();
	}
	int foursize = 0;
	if(OneYear!=null){
		foursize = OneYear.size();
	}
%>

<html>
	<head>
		<title>中国石油信息网</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				<tr class="u3">
					<td colspan="<%=onesize%>">
						近一个月的统计信息发布统计
					</td>
				</tr>
			<tr class="u4" height="20" width="100%">
				<td>
					&nbsp;
				</td>
				<%
				if(OneMonth!=null){
				String ch_name = "";
					for(int i=0;i<OneMonth.size();i++){
						HashMap map = (HashMap)OneMonth.get(i);
						if(map.get("ch_name")!=null){
							ch_name = map.get("ch_name").toString();
						}
					%>
				<td align="center">
					<%=ch_name%>
				</td>
				<%}
				}%>
			</tr>
			<%
				int sumoneMonth = 0;
				if(OneMonth!=null){
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
		</table>
</body>
</html>


