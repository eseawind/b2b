<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*"%>
<%
	Custinfo in = new Custinfo();
	ArrayList List2 = in.getMaxCustByNo(); 
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="228" height="30" align="center" background="/images/abb_10.gif">
			<span style="color:#073E66; font-size:13px;">�����������ƽ̨����ʼ���Ͻ���</span>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#6AB9FF">
	<tr>
		<td height="180" align="center" bgcolor="#FFFFFF">
			<table width="94%" border="0" cellpadding="2" cellspacing="0">
				<tr>
					<td valign="top">
						��
					</td>
					<td valign="top">
						����ƹ��Ʒ�����������˾��������ң��ύ�������ɿ�չ����ó�ף�
					</td>
				</tr>
			</table>
			<table width="82%" border="0" cellpadding="2" cellspacing="0">
				<tr>
					<td>
						<a href="/member/Newcregister.jsp"><img src="/images/an_03.gif" width="119" height="27" alt="���ע��" border="0"></a>
					</td>
				</tr>
			</table>
			<table width="96%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="20" class="xian"></td>
				</tr>
			</table>
			<table width="94%" border="0" cellpadding="2" cellspacing="0">
				<tr>
					<td valign="top">
						��
					</td>
					<td valign="top">
						����ٿ�չ����ó�ף�����������
					</td>
				</tr>
				<tr>
					<td valign="top">
						��
					</td>
					<td valign="top">
						��ѯ���ߣ�
						<strong>0550-8*******</strong>
					</td>
				</tr>
			</table>
			<table width="82%" border="0" cellpadding="2" cellspacing="0">
				<tr>
					<td>&nbsp;
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="5"></td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		
		<td width="228" height="30" background="/images/ba_106_4.gif">
			<span style="color:#073E66; font-size:14px; font-weight:bold; margin-left:10px;">���½����Ա</span>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="6AB9FF">
	<tr>
		<td height="180" valign="top" bgcolor="#FFFFFF">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<%
					if (List2 != null && List2.size() > 0) {
					for (int i = 0; i < List2.size() && i <6; i++) {
						HashMap map = (HashMap) List2.get(i);
						String cust_name = "", news_cust_id = "", class_name = "";
						if (map.get("cust_id") != null) {
							news_cust_id = map.get("cust_id").toString();
						}
						if (map.get("cust_name") != null) {
							cust_name = map.get("cust_name").toString();
							if(cust_name.length()>13){cust_name=cust_name.substring(0,13);}
						}
						if (map.get("class_name") != null) {
							class_name = map.get("class_name").toString();
						}
			%>
				<tr>
					<td>
						<a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=news_cust_id%>" target=_blank><%=cust_name%></a>
						<img src="/images/Max.gif" width="15" height="12" align="middle" />
						<br>
						<span class="STYLE2">��Ӫ:<%=class_name%>...</span>
					</td>
				</tr>
				<tr>
					<td height="1" class="xian"></td>
				</tr>
				<%
				}
			}
			%>
			</table>
		</td>
	</tr>
</table>
<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td></td>
	</tr>
</table>
<table width="100%" height="90" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="90">
			<img src="/images/abb_11.gif" width="228" height="90">
		</td>
	</tr>
</table>
<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td></td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="DBECF4">
	<tr>
		<td height="120" align="center" bgcolor="#FFFFFF">
			�Ų�Ʒ������� google��������
		</td>
	</tr>
</table>
<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td></td>
	</tr>
</table>
<table width="100%" height="158" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="158">
			<img src="/images/abb1.jpg" width="228" height="158">
		</td>
	</tr>
</table>
<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td></td>
	</tr>
</table>




