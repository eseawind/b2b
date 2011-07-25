<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
	<head>
		<title>客户级别管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align:right;width: 20%}
		 .r_td{background-color:#ffffff; color:#000000;  font-size:12px;width: 80%}
		</style>
		<script language="javascript">
		function checkInfo()
		{
			var cls=$("old_class").value;
		 	var val=$("cust_class").value;
		 	var cust_name=$F("cust_name");
			if(cls == "1")
			{
				alert("未验证客户不能修改客户级别!请先申请验证！");
				return false;
			}
			
			if(val == "0"){
				alert("请选择客户级别!");
				return false;
			}else if(val == "1"){
			   alert("不能把【"+cust_name+"】的级别修改为未验证客户!");
			   return false;
			}
			
	      var start_date=$F("start_date");
		   start_date=delAllSpace(start_date);
		   if(start_date =="" || start_date==null){
		    alert("开始时间不能为空！");
		    $("start_date").focus();
		    return false;
		   }
		   
		   var end_date=$F("end_date");
		   end_date=delAllSpace(end_date);
		   if(end_date =="" || end_date==null){
		    alert("结束时间不能为空！");
		    $("end_date").focus();
		    return false;
		   }
		   //////////////////判断时间是否合理////////////////
		   if(!checkDate(start_date,end_date)){
		     return false;
		   }
		   ///////////////////////////////////////////////
		   return true;
		 }
		 //删除所有空格
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
     </script>
	</head>
	<body>
		<%
		  String start_date = "";
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			start_date = formate.format(new Date());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 50);
			String end_date = formate.format(cal.getTime());
			String cust_id = "";
			if (request.getParameter("cust_id") != null) {
				cust_id = request.getParameter("cust_id");
			}
			Custinfo custinfo = new Custinfo();
			ArrayList custArray = new ArrayList();
			custArray = custinfo.getCustInfo(cust_id);
			String cust_name = "", cust_phone = "", cust_addr = "";
			if (custArray != null && custArray.size() > 0) {
				HashMap map = (HashMap) custArray.get(0);
				if (map.get("cust_aim") != null) {
					cust_name = map.get("cust_aim").toString();
				}
				if (map.get("group_contact_phone") != null) {
					cust_phone = map.get("group_contact_phone").toString();
				}
				if (map.get("company_address") != null) {
					cust_addr = map.get("company_address").toString();
				}
			}
			CustClass level = new CustClass();
			String class_Name = level.cust_Class_Name(cust_id);
			ArrayList itemList=level.genOneright(cust_id);
			if(itemList !=null)
			{
			HashMap itemMap=(HashMap) itemList.get(0);
			 if(itemMap.get("cust_start_date")!=null)
			  {
			  start_date=itemMap.get("cust_start_date").toString();
			  }
			 if(itemMap.get("cust_end_date")!=null)
			 {
		    end_date=itemMap.get("cust_end_date").toString();
			 }
			} 
			ParamethodMgr paramCom = new ParamethodMgr();
			String customer_class = paramCom.getSelectItems("14");
			String cust_class=level.getCustClassById(cust_id);
		%>
		<form method="post" name="NewRegisterForm" id="NewRegisterForm" action=/doTradeReg.do>
		   <!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>客户级别修改</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->
			<table width=100% border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
				<tr>
					<td class="u1">
						公司名称：
					</td>
					<td class="u2">
						<div class="ping1">
							<%=cust_name%>
						</div>
					</td>
						<td class="u1">
						当前级别：
					</td>
					<td class="u2">
						<div class="ping1" style="font-size:12px">
							<%=class_Name%>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						更改级别：
					</td>
					<td class="u2" colspan="3">
						<div class="ping" style="font-size:12px">
							<select name="cust_class" id="cust_class">
							    <option value="0">请选择...</option>
								<%=customer_class%>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						有效开始时间：
					</td>
					<td class="u2">
						<div class="ping1" style="font-size:12px">
						  <input name="start_date" type="text" id="start_date" size=10 maxlength=15 value="<%=start_date%>" onfocus="setday(this);">
						</div>
					</td>
					<td class="u1">
						有效结束时间：
					</td>
					<td class="u2">
						<div class="ping1" style="font-size:12px">
							<input name="end_date" type="text" id="end_date" size=10 maxlength=15 value="<%=end_date%>"  onfocus="setday(this);">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						备注：
					</td>
					<td class="u2" colspan="3">
						<div class="ping1" style="font-size:12px">
							<input type="text" name="remark" size="50" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1" colspan="4" style="text-align: center;">
						<input class="tjan" type="submit" value="" onclick="return checkInfo()">
						<input type="hidden" name="trade_type_code" value="0567">
						<input type="hidden" name="cust_name" id="cust_name" value="<%=cust_name%>">
						<input type="hidden" name="old_class" id="old_class" value="<%=cust_class%>">
						<input type="hidden" name="cust_id" value="<%=cust_id%>">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




