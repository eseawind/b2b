<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools"
	scope="page" />
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String scust_name = "";

	request.setCharacterEncoding("gbk");
	int counter = 0;
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	Custinfo custinfo = new Custinfo();
	ArrayList custlist = new ArrayList();
	if (null != request.getParameter("scust_name"))
		scust_name = request.getParameter("scust_name");
	if (!scust_name.equals("")) {
		custlist = custinfo.getListByNamePage("%" + scust_name + "%",
				Integer.parseInt(iStart), 20);
		counter = custinfo.getListByName("%" + scust_name + "%");
		//  out.println("234234"+scust_name+"+++++"+counter);

	} else {
		custlist = custinfo.getAllCustOrderClass(Integer
				.parseInt(iStart), 20);
		counter = custinfo.getAllCustOrderClass();
	}
	String toolsBar = tools.getPageTools(String.valueOf(counter), "20",
			"talentsList.jsp?" + "scust_name=" + scust_name
					+ "&iStart=", Integer.parseInt(iStart));

	// out.println(counter);
%>

<html>
	<head>
		<title></title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style>
.t_head {
	style ="color: #000000;
	font-weight: bold;
	font-size: 13px;
	"
}

.chaxun {
	background: url(/admin/images/chaxun.gif) left center no-repeat;
	width: 70px;
	height: 26px;
	border: 0px;
	cursor: hand;
}
</style>
		<script type="text/javascript" src="/js/roleMgr.js">
		
	   //空值判断
	    function Check_Value(){
	    //   if(document.getElementById("custnamefind").value ==null || document.getElementById("custnamefind").value ==""){
	     //   alert("请输入查询条件");
	     //   return false;
	     //  }
	     //  else
	      
	       document.custNameFind.submit();
	    }
		</script>
	</head>
	<body>
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="CaI02Rs1s0hsB20" />
		</jsp:include>
		<table width="800" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<form name="custNameFind" action="talentsList.jsp" method=post
						target="_self">
						<table width="100%" border=0 cellpadding=1 cellspacing=1
							align=center bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="12%" align=center>
									供应商名称
								</td>
								<td width="15%" align=left>
									<input type="text" id="scust_name_id" name="scust_name"
										value=<%=scust_name%>>
								</td>
								<td width="3%" align=left>
								</td>
								<td width="15%" align=left>
									<input id="custname" class="chaxun" type="submit" name="comit"
										value="" style="cursor: hand;">
								</td>
								<td width="50%" align=left>
								</td>
							</tr>
						</table>
					</form>
					<table width="100%" border=0 cellpadding=1 cellspacing=1
						align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="25%">
								供应商名称
							</td>
							<td width="25%">
								供应商级别
							</td>
							<td width="10%">
								已推荐值
							</td>
							<td width="15%">
								推荐
							</td>
						</tr>
						<%
							if (custlist != null && custlist.size() > 0) {
								for (Iterator it = custlist.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String custid = "", info_no = "未推荐", cust_name = "", para_code2 = "";
									if (map.get("cust_id") != null) {
										custid = map.get("cust_id").toString();
									}
									if (map.get("cust_name") != null) {
										cust_name = map.get("cust_name").toString();
									}
									if (map.get("para_code2") != null) {
										para_code2 = map.get("para_code2").toString();
									}
									OrderCast ordercast = new OrderCast();
									HashMap mapOrder = ordercast
											.getCastByIdandType(custid, "6");
									if (mapOrder != null && mapOrder.get("info_no") != null) {
										info_no = mapOrder.get("info_no").toString();
									}
						%>
						<tr class="u2">
							<td align=center>
								<a
									href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=custid%>"
									target=_blank> <%=cust_name%></a>
							</td>
							<td align=center><%=para_code2%></td>
							<td align=center><%=info_no%>
							</td>
							<td align=center>
								<a href="commend.jsp?custid=<%=custid%>" TARGET=appwin><img
										src=/images/edit.gif width=16 height=16 border=0 alt="推荐">
								</a>&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<%
							}
						%>
						<tr class="u1">
							<%=toolsBar%>
						</tr>
						<%
							}
						%>
					</table>
				</td>
			</tr>
		</table>

	</body>
</html>



