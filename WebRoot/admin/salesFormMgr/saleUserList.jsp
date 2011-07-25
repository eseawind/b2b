<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.relationccMgr.RelationCcInfo"%>
<%@ page contentType="text/html;charset=GBK"%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		
<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../ext/ext-all.js"></script>
		
<script language="javascript">
  
  function sumbimtData(){
    if(document.getElementById("obj_cust_name").value=="" || document.getElementById('obj_cust_name').value ==null){
      Ext.MessageBox.alert("bizoss 提示","请选择一个客户!");
      return false;
    }else{
		window.opener.resumeForm.obj_cust_name.value=document.getElementById("obj_cust_name").value;
		window.opener.resumeForm.obj_cust_id.value=document.getElementById("obj_cust_id").value;
		window.close();
		return false;
	}
  }
  function setObjValue(cust_name,cust_id){
    document.getElementById("obj_cust_name").value=cust_name;
    document.getElementById("obj_cust_id").value=cust_id;
  }

</script>
	</head>
	<body>
		<%
			HttpSession logsession = request.getSession();
			String cust_id = "";
			String iStart = "0";
			if (request.getParameter("iStart") != null) {
				iStart = request.getParameter("iStart");
			}
			if (logsession.getAttribute("SESSION_CUST_ID") != null) {
				cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
			}
			RelationCcInfo relation = new RelationCcInfo();
			ArrayList relationList =relation.getAllOppPageByType(Integer.parseInt(iStart),cust_id,"1");
			int counter = relation.getPateSizeByType(cust_id,"1");
			int pages = counter / 20 + 1;
			int pageUp = 0, pageDown = 0;
			int currenPage = Integer.valueOf(iStart).intValue();
			if (pages > currenPage) {
				if (currenPage > 0) {
					pageUp = currenPage - 1;
				}
				pageDown = currenPage + 1;
			}
			else if (pages == currenPage) {
				pageUp = currenPage - 1;
				pageDown = currenPage;
			}
		%>
		<table width="750" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td height="13" align="left">
				</td>
			</tr>
			<tr>
				<td>
					<table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr>
							<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="30%">
								客户名称
							</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">
								邮件地址
							</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">
								联系电话
							</td>
							<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="15%">
								建立日期
							</td>
						</tr>
						<%
								if (relationList != null && relationList.size() > 0) {
								int i = 0;
								for (Iterator it = relationList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String idx = map.get("obj_cust_id").toString();
									String cust_name = "";
									String email = "";
									String group_contact_phone = "";
									String start_date = "";
									if (map.get("cust_name") != null) {
								     cust_name = map.get("cust_name").toString();
									}
									if (map.get("group_contact_phone") != null) {
								     group_contact_phone = map.get("group_contact_phone").toString();
									}
									if (map.get("email") != null) {
									 email = map.get("email").toString();
									}
									if (map.get("start_date") != null) {
									 start_date = map.get("start_date").toString();
									 if (start_date.length() > 10) {
										start_date = start_date.substring(0, 10);
									 }
									}
									if(i%2==0){
									%>
									<tr bgcolor=#FFFFFF>
									<%
									}else{
									%>
									<tr bgcolor=#efefef>
									<%
									}
							%>
								<td style=" color:#000000;" align=left>
									<input type="radio" name="sel" id="sel" onclick="setObjValue('<%=cust_name%>','<%=idx%>')">
									<%=cust_name%>
								</td>
								<td style=" color:#000000;" align=left>
									<%=email%>
								</td>
								<td style=" color:#000000;" align=left>
									<%=group_contact_phone%>
								</td>
								<td style=" color:#000000;" align=left>
									<%=start_date%>
								</td>
							</tr>
	
							<%
								i++;
								}
						%>

						<tr bgcolor=#FFFFFF>
							<td align="left" colspan="2" class="line1" style="font-weight:normal;">
								共
								<%=counter%>
								条 &nbsp;共
								<%=pages%>
								页
							</td>
							<td align="left" colspan="3">
								<a href="customerList.jsp?iStart=1">首页 </a>&nbsp; &nbsp;
								<a href="customerList.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<a href="customerList.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp;
								<a href="customerList.jsp?iStart=<%=pages%>">尾页</a>
							</td>
						</tr>

						<%
							}
						%>
						<tr>
							<input type="hidden" name="obj_cust_id" id="obj_cust_id" value="">
							<input type="hidden" name="obj_cust_name" id="obj_cust_name" value="">
							<td align="center" colspan="5">
								<input type="button" value="确定" onclick=" return sumbimtData();">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="13"></td>
			</tr>
		</table>
	</body>
</html>





