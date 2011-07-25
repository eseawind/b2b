<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.util.*"%>

<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.base.config.ProjectConfig"%>
<%
	String keyWord = "";
	ArrayList custArray = new ArrayList();
	if (request.getParameter("keyword") != null) {
		keyWord = request.getParameter("keyword");
		keyWord=new String(keyWord.getBytes("ISO-8859-1"),"GBK"); 
		Custinfo custEntity = new Custinfo();
		custArray = custEntity.getCustomByStockSeach(keyWord);
	}
	 String menu_idx = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_idx = request.getParameter("menu_id");
    }
	ParamethodMgr comparList = new ParamethodMgr();
	HashMap compMap = comparList.getCompareInfoByCode("CRM", "cust_type");
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<SCRIPT language=javascript src="/js/index.js" type=text/javascript></SCRIPT>
		<SCRIPT language=javascript src="/js/enterpriseMgr.js" type=text/javascript></SCRIPT>
	</head>

	<body>
		<div>
			<form action="index.jsp" method="post">
				<table width="100%" border="0" cellpadding="2" cellspacing="1" align="center">
				  <tr>
					  <td align="right" width="40%">
								请输入要自定义网页模板的客户：
						</td>
						<td align="left" width="25%">
								<input type="text" name="keyword" id="keyword" size="30" maxlength="50">
					  </td>
					  <td align="left" width="25%">
								<input type="submit" value="提交" onclick="return checkInfo()">
								<input type="hidden"  name="menu_id" value="<%=menu_idx%>">
						</td>
						<td align="left" width="10%">
								&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</div>
		<table width="727" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7">
			<tr>
				<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="15%" >
					客户名称
				</td>
				<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="13%">
					级别
				</td>
				<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="7%">
					状态
				</td>
				<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align="center" width="10%">
					修改模板
				</td>
			</tr>
			<% 
				if (custArray != null && custArray.size() > 0) 
				{ 
					int i = 0;
					for (Iterator inIt = custArray.iterator(); inIt.hasNext();)
					{
						HashMap map = (HashMap) inIt.next();
						String cust_id = "";
						String cust_name = "";
						String cust_type = "";
						String cust_state = "正常";
						String cust_addr = "";
						cust_id = map.get("cust_id").toString();
						cust_name = map.get("cust_name").toString();
						if (map.get("cust_type") != null) 
						{
					       cust_type = map.get("cust_type").toString();
						}
					 
					%>
					<tr style="background-color:#f9f9f9; " >
						<td class="ping1" style=" color:#000000;" align="left">
							<%=cust_name%>
						</td>
						<td style=" color:#000000;" align="center">
							<%=compMap.get(cust_type)%>
						</td>
						<td style=" color:#000000;" align="center">
							<%=cust_state%>
						</td>
						 
						<td style=" color:#000000;" align="center">
							<a
								href="modifyRank.jsp?cust_id=<%=cust_id%>&cust_name=<%=cust_name%>" target="_bank">
								<img src="/img/edit.gif" width="16" height="16"> </a>
						</td>
					</tr>
				<%
					i++;
					}
				}
			%>
		</table>
	<body>
</html>




