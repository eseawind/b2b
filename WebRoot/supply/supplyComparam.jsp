<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="sale" class="com.saas.biz.saleMgr.SupplyInfo" scope="page" />
<jsp:useBean id="cust" class="com.saas.biz.custMgr.CustClass" scope="page" />
<%
	String idx = "";
	if (request.getParameter("idx") != null) {
		idx = request.getParameter("idx");
	}
	ArrayList list=sale.getSupplyCompareById(idx);
	String defaultImg="/images/cp.gif";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>��Ӧ��ϸ��Ϣ</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/supply/supply.js"></script>
		<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		</style>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include flush="true" page="saleHead.jsp" />
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="DCDCDC">
			<tr>
				<td height="29" background="/images/Content_03.gif" bgcolor="#FFFFFF">
					&nbsp;&nbsp;��ӭ��ʹ��
					<span style="color: red;font-weight:bold;">��Ӧ��Ϣ�Ա�</span>����,��������κν�������,����������ϵ �� ��������ѡ��
					<span style="color: red;font-weight:bold;">5</span>��ͬʱ���жԱ�
				</td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%" valign="top"><table border=0 cellpadding=0 cellspacing=0 width="100%">
                <tr>
                  <td width="134" height="32" align="center" background="/images/sup_03.gif" class="bthong"> ��Ӧ��Ϣ�Ա� </td>
                  <td align="right" background="/images/sup_04.gif"><img src="/images/sup_08.gif" align="absmiddle"> &nbsp; </td>
                </tr>
              </table>
			  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="FFC367">
                  <tr>
                    <td bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="10" cellspacing="1">
                  <tr>
                    <td width="20%"><table>
                        <tr height="20" valign="top" bgcolor="whitesmoke" width="100%">
                          <td height="20" valign="top" align="center"></td>
                        </tr>
                        <tr height="80" valign="top" bgcolor="whitesmoke" bordercolor="#CCCCFF">
                          <td height="80" valign="top" align="center"> ͼƬ </td>
                        </tr>
                        <tr height="40" valign="top" bgcolor="whitesmoke" bordercolor="#CCCCFF">
                          <td height="40" valign="top" align="center"> ���� </td>
                        </tr>
                        <tr height="40" valign="top" bgcolor="whitesmoke" bordercolor="#CCCCFF">
                          <td height="40" valign="top" align="center"> ��˾ </td>
                        </tr>
                        <tr height="40" valign="top" bgcolor="whitesmoke" bordercolor="#CCCCFF">
                          <td height="40" valign="top" align="center"> �۸� </td>
                        </tr>
                        <tr height="40" valign="top" bgcolor="whitesmoke" bordercolor="#CCCCFF">
                          <td height="40" valign="top" align="center"> ��Ա���� </td>
                        </tr>
                    </table></td>
                    <%
							 if(list !=null && list.size()>0){
							  for(int i=0;i<list.size();i++){
							   HashMap map=(HashMap)list.get(i);
					           String sale_id=map.get("sale_id").toString();
					           String cust_name="",sale_unit="",cust_class="",sale_price="",title="",pub_date="";
					           if(map.get("cust_name")!=null){cust_name=map.get("cust_name").toString();}
					           if(map.get("title")!=null){title=map.get("title").toString();}
					           if(map.get("sale_unit")!=null){sale_unit=map.get("sale_unit").toString();}
					           if(map.get("sale_price")!=null){sale_price=map.get("sale_price").toString();}
					           cust_class=cust.cust_Class_Name(sale_unit);
					           if(map.get("publish_date")!=null){
							      pub_date=map.get("publish_date").toString();
							      if(pub_date.length()>10){
							        pub_date=pub_date.substring(0,10);
							      }
							    }
							    String file_path="";
							     if(map.get("file_path")!=null){
							       file_path=map.get("file_path").toString();
							       
								}else{
								file_path=defaultImg;
								}
							%>
                    <td bgcolor="#FFFFFF" id="td<%=i%>"><table>
                        <tr height="20px" valign="top" bgcolor="Linen">
                          <td height="20px" valign="top" align="center"><a href="javascript:remove('td<%=i%>')"><font color="red">�� ��</font> </a> </td>
                        </tr>
                        <tr height="40px" valign="top" bgcolor="WhiteSmoke">
                          <td height="80px" valign="top" align="center"><a href="saleInquiry.jsp?sale_id=<%=sale_id%>" target=_blank><img height=80px src="<%=file_path%>" border=0> </a> </td>
                        </tr>
                        <tr height="40px" valign="top">
                          <td height="40px" valign="top" align="center"><a href="saleInquiry.jsp?sale_id=<%=sale_id%>" target=_blank><%=title%></a> <br>
                              <%=pub_date%> </td>
                        </tr>
                        <tr height="40px" valign="top" bgcolor="WhiteSmoke">
                          <td height="40px" valign="top" align="center"><span style="font-weight:bold;color: #330000"><%=cust_name%></span> </td>
                        </tr>
                        <tr height="40px" valign="top">
                          <td height="40px" valign="top" align="center"><%=sale_price%> </td>
                        </tr>
                        <tr height="40px" valign="top" bgcolor="WhiteSmoke">
                          <td height="40px" valign="top" align="center"><%=cust_class%> </td>
                        </tr>
                    </table></td>
                    <%}
							}%>
                  </tr>
              </table></td></tr>
              </table></td>
          </tr>
          <tr>
            <td align="center" style="margin-top: 10px;padding-top: 10px"> ��������ѡ��Ӧ��,�롾 <a href="javascript:window.close()"><font color="#FF3300">�ر�</font></a> �� �˴��ڡ� </td>
          </tr>
        </table>
		<jsp:include flush="true" page="/zone_b2b/footer.jsp" />
	</body>
</html>




