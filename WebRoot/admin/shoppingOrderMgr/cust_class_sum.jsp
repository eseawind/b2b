<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>

<%
	Custinfo cus = new Custinfo();
	ArrayList OneMonth = new ArrayList();//ע��
	OneMonth = cus.getAllCustByClassId();
%>

<html>
	<head>
		<title>�й�ʯ����Ϣ��</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<table  width="100%">
		<tr>
			<td  width="25%">
			<table  width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				<tr class="u3">
					<td colspan="2">
						��Ա����ͳ��
					</td>
				</tr>
			<tr class="u4" height="20" width="25%">
				<td align="center"  width="50%">
					��������
				</td>
				<td align="center" width="50%">
					��Ա����
				</td>
			</tr>
			<%
				int sumoneMonth = 0;
				if(OneMonth!=null){
				String class_name="",countmun="";
					for(int i=0;i<OneMonth.size();i++){
					HashMap map1 = (HashMap)OneMonth.get(i);
					if(map1.get("class_name")!=null){
					class_name = map1.get("class_name").toString();
					}
					if(map1.get("count")!=null){
					countmun = map1.get("count").toString();
					sumoneMonth = sumoneMonth + Integer.valueOf(countmun).intValue();
					}%>
					<tr class="u2">
						<td>
							<%=class_name%>
						</td>
						<td>
							<%=countmun%>
						</td>
					</tr>
				<%}
			}%>
					<tr class="u2">
						<td>
							����
						</td>
						<td>
							<%=sumoneMonth%>
						</td>
					</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>


