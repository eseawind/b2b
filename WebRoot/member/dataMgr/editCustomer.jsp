<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>修改客户资料</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
			h1 {float:left;padding-left:8px; font-size:15px; font-weight:bold; padding-top:5px;}
			#td{
				width:100px;
				text-align:right;
				margin-left:5px;
				height:30px;
				line-height:30px;
				}
        </style>
		<script language="javascript" src="customer.js"></script>
	</head>
	<%
		HttpSession logsession = request.getSession();
		String cust_id = "";
		if (request.getParameter("cust_id") != null) {
			cust_id = request.getParameter("cust_id").toString();
		}
		ArrayList custList = new ArrayList();
		String cust_name = "", cust_type = "", cust_aim = "", all_emp_count = "", china_emp_count = "", local_emp_count = "", fax_nbr = "", group_contact_phone = "", email = "", company_address = "", calling_area_code = "", client_status = "", juristic = "", juristic_type_code = "", post_addr = "", job = "", qq = "", home_addr = "", blog = "", post_code = "", local_native_code = "", group_attr = "", class_id = "", develope_man = "", develope_channel = "", pspt_type_code = "", eparchy_code = "", province = "", city = "", group_memo = "", scope = "", website = "", user_count = "", user_id = "", pspt_id = "", pspt_addr = "", city_code = "", reg_money = "", enterprise_size_code = "", calling_type_code = "", enterprise_type_code = "", enterprise_scope = "";
		ParamethodMgr paramCom = new ParamethodMgr();
		String userCountList = paramCom.getItemsBySelected("53",user_count);
		AreaInfo arae = new AreaInfo();
		Map country_Map = new HashMap();
		country_Map = arae.getCountryAllByCode("cn");
		custList = new Custinfo().getCustInfo(cust_id);
		if (custList != null && custList.size() > 0) {
			HashMap map = (HashMap) custList.get(0);
			if (map.get("cust_name") != null) {
				cust_name = map.get("cust_name").toString();
			}
			if (map.get("cust_type") != null) {
				cust_type = map.get("cust_type").toString();
			}
			if (map.get("cust_aim") != null) {
				cust_aim = map.get("cust_aim").toString();
			}
			if (map.get("all_emp_count") != null) {
				all_emp_count = map.get("all_emp_count").toString();
			}
			if (map.get("local_emp_count") != null) {
				local_emp_count = map.get("local_emp_count").toString();
			}
			if (map.get("china_emp_count") != null) {
				china_emp_count = map.get("china_emp_count").toString();
			}
			if (map.get("fax_nbr") != null) {
				fax_nbr = map.get("fax_nbr").toString();
			}
			if (map.get("group_contact_phone") != null) {
				group_contact_phone = map.get("group_contact_phone").toString();
			}
			if (map.get("email") != null) {
				email = map.get("email").toString();
			}
			if (map.get("company_address") != null) {
				company_address = map.get("company_address").toString();
			}
			if (map.get("post_code") != null) {
				post_code = map.get("post_code").toString();
			}
			if (map.get("juristic") != null) {
				juristic = map.get("juristic").toString();
			}
			if (map.get("juristic_type_code") != null) {
				juristic_type_code = map.get("juristic_type_code").toString();
			}
			if (map.get("group_memo") != null) {
				group_memo = map.get("group_memo").toString();
			}
			if (map.get("scope") != null) {
				scope = map.get("scope").toString();
			}
			if (map.get("website") != null) {
				website = map.get("website").toString();
			}
			if (map.get("user_count") != null) {
				user_count = map.get("user_count").toString();
			}
			
			if (map.get("group_attr") != null) {
				group_attr = map.get("group_attr").toString();
			}
			
			if (map.get("client_status") != null) {
				client_status = map.get("client_status").toString();
			}
			
			if (map.get("calling_area_code") != null) {
				calling_area_code = map.get("calling_area_code").toString();
			}
			if(map.get("eparchy_code")!=null)
			 {
			 eparchy_code=map.get("eparchy_code").toString();
			 }
			if (map.get("city_code") != null) {
				city_code = map.get("city_code").toString();
			}
			if (map.get("province") != null) {
				province = map.get("province").toString();
			}
			if (map.get("city") != null) {
				city = map.get("city").toString();
			}
			if (map.get("class_id") != null) {
				class_id = map.get("class_id").toString();
			}
			if (map.get("develope_man") != null) {
				develope_man = map.get("develope_man").toString();
			}
			if (map.get("develope_channel") != null) {
				develope_channel = map.get("develope_channel").toString();
			}
			if (map.get("pspt_type_code") != null) {
				pspt_type_code = map.get("pspt_type_code").toString();
			}
			if (map.get("pspt_id") != null) {
				pspt_id = map.get("pspt_id").toString();
			}
			if (map.get("pspt_addr") != null) {
				pspt_addr = map.get("pspt_addr").toString();
			}
			if (map.get("reg_money") != null) {
				reg_money = map.get("reg_money").toString();
			}
			if (map.get("enterprise_size_code") != null) {
				enterprise_size_code = map.get("enterprise_size_code").toString();
			}
			if (map.get("calling_type_code") != null) {
				calling_type_code = map.get("calling_type_code").toString();
			}
			if (map.get("enterprise_type_code") != null) {
				enterprise_type_code = map.get("enterprise_type_code").toString();
			}
			if (map.get("enterprise_scope") != null) {
				enterprise_scope = map.get("enterprise_scope").toString();
			}
		}
		country_Map = arae.getAreaByParent("5J2mc0X0G85BH");
		String select = classBean.getSelectedByComm("3", "1");
		String province_name=arae.getAreaNameByCode(province);
		if(province_name==null || province_name==""){
		   province_name="请选择..";
		}
		String eparchy_name=arae.getAreaNameByCode(eparchy_code);
		if(eparchy_name==null || eparchy_name==""){
		   eparchy_name="请选择..";
		}
	%>
	<font color="#000000"></font>
	<body>
		<form name=form1 action=/doTradeReg.do method=post target="_self">
			<table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7" style="margin-top:10px;">
				<tr>
					<td class="line1" colspan="3" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" width="150" align="center">
						<%
						out.print("修改客户资料！");
						%>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td width="18%" align="right" style=" color:#000000; font-weight:bolder;">
						客户名称：
					</td>
					<td colspan="2" align="left" width="82%">
						<div class="ping1">
							<input type="text" name="cust_name" readonly="true" size="20" maxlength="100" value="<%=cust_name%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; display:none; ">
					<td width="18%" align="right" style=" color:#000000; font-weight:bolder;">
						客户类型：
					</td>
					<td colspan="2" align="left" width="82%">
						<div class="ping1">
							<input type="text" name="cust_type" value="<%=cust_type%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						公司名称：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="cust_aim" size="30" maxlength="30" value="<%=cust_aim%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;">
					<td width="18%" align="right" style=" color:#000000; font-weight:bolder;">
						企业类型：
					</td>
					<td colspan="2" align="left" width="82%">
						<div class="ping1" style="display:none">
							<input type="text" name="enterprise_type_code" value="<%=enterprise_type_code%>">
						</div>
						<table>
							<tr>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
									<select name="sort1" size="10" style="width: 130px" onChange="setSecondClass(this.value);" onclick="setTypeName(this)">
										<%=select%>
									</select>
								</td>
								<td style="background-color:#ffffff; color:#000000; font-size:12px;">
									<select name="sort2" size="10" style="width: 130px; display: none" onChange="setTherdClass(this.value);" onclick="setTypeName(this)">
										<option value="0">
											请选择...
										</option>
									</select>
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
									<select name="sort3" size="10" style="width: 130px; display: none" onclick="setTypeName(this)" onchange="cretateSelect('4',this.value)">
										<option value="0">
											请选择...
										</option>
									</select>
								</td>
								<td>
									<div id="nextElement" style="display: none">
										<div id="4" style="width;100px; float:left;display:inline;white-space:nowrap"></div>
										<input type="hidden" name="index_s" id="index_s" value="4">
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none;  ">
					<td width="18%" align="right" style=" color:#000000; font-weight:bolder;">
						行业类别：
					</td>
					<td colspan="2" align="left" width="82%">
						<div class="ping1">
							<input type="text" name="calling_type_code" value="<%=calling_type_code%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						企业规模：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="enterprise_size_code" size="30" maxlength="30" value="<%=enterprise_size_code%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						注册资金：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="reg_money" size="30" maxlength="30" value="<%=reg_money%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						用 户 数：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<select name="user_count" id="user_count">
								<%=userCountList%>
							</select>
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none;">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						全球员工数：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="all_emp_count" size="15" maxlength="20" value="<%=all_emp_count%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none;">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						中国员工数：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="china_emp_count" size="15" maxlength="20" value="<%=china_emp_count%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none;">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						本地员工数：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="local_emp_count" size="15" maxlength="20" value="<%=local_emp_count%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						联系电话：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="group_contact_phone" size="15" maxlength="20" value="<%=group_contact_phone%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						传 真：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="fax_nbr" size="15" maxlength="20" value="<%=fax_nbr%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						公司Email：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="email" size="52" maxlength="40" value="<%=email%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						公司网站：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="website" size="30" maxlength="50" value="<%=website%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						公司地址：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="company_address" size="52" maxlength="40" value="<%=company_address%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						邮政编码：
					</td>
					<td colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="post_code" size="52" maxlength="40" value="<%=post_code%>">
						</div>
					</td>
				</tr>

				<tr style="background-color:#f9f9f9; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						法人代表/联系人：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="juristic" size="12" maxlength="15" value="<%=juristic%>">
						</div>
					</td>
				</tr>

				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						法人类别：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="juristic_type_code" size="12" maxlength="15" value="<%=juristic_type_code%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; display:none;">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						证件类型：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="pspt_type_code" size="12" maxlength="15" value="<%=pspt_type_code%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						证件号码：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="pspt_id" size="12" maxlength="15" value="<%=pspt_id%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						证件地址：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<input type="text" name="pspt_addr" size="12" maxlength="15" value="<%=pspt_addr%>">
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						归属业务：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="city_code" id="city_code" value="<%=city_code%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						公司简介：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<textarea name="scope" style=display:none><%=scope%></textarea>
							<iframe ID=scope src=/www/ewebeditor/ewebeditor.htm?id=scope&root_id=<%=cust_id%>&style=coolblue frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						经营范围：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<textarea name="group_memo" cols="50" rows="6"><%=group_memo%></textarea>
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						发展人：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="develope_man" id="develope_man" value="<%=develope_man%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td align="right" style=" color:#000000; font-weight:bolder;">
						发展渠道：
					</td>
					<td style=" color:#000000;background-color:#FFFFFF" colspan="2" align="left">
						<div class="ping1">
							<textarea name="develope_channel" cols="50" rows="6">
								<%=develope_channel%>
							</textarea>
						</div>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						客户规模：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="class_id" id="class_id" value="<%=class_id%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						集团属性：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="group_attr" id="group_attr" value="<%=group_attr%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none;">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						集团状态：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="client_status" id="client_status" value="<%=client_status%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						所属行业区域：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="calling_area_code" id="calling_area_code" value="<%=calling_area_code%>">
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						省份：
					</td>
					<td colspan="2" align="left">
						<select name="province" id="province" onclick="setCitys(this.value)">
							<option value="<%=province%>">
								<%=province_name%>
							</option>
							<%
									if (country_Map != null && country_Map.size() > 0) {
									Iterator it = country_Map.entrySet().iterator();
									while (it.hasNext()) {
										Map.Entry entry = (Map.Entry) it.next();
										Object key = entry.getKey();
										Object value = entry.getValue();
							%>
							<option value=<%=key%>>
								<%=value%>
							</option>
							<%
								}
								}
							%>
						</select>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						城市：
					</td>
					<td colspan="2" align="left">
						<input type="hidden" name="city" id="city" value="<%=city%>">
						<select name="eparchy_code" id="eparchy_code" style="display:inline">
							<option value="<%=eparchy_code%>">
								<%=eparchy_name%>
							</option>
						</select>
					</td>
				</tr>
				<tr style="background-color:#f9f9f9;display:none; ">
					<td style=" color:#000000; font-weight:bolder;" align="right">
						区域特点：
					</td>
					<td colspan="2" align="left">
						<input type="text" name="enterprise_scope" id="enterprise_scope" value="<%=enterprise_scope%>">
					</td>
				</tr>

				<tr>
					<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						企业图片：
					</td>
					<td align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
							<iframe src="/inc/uploadImg.jsp?root_id=<%=cust_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
						</div>
					</td>
				</tr>

				<tr style="background-color:#f9f9f9; ">
					<td colspan="2" align="center">
						<input type="hidden" name="cust_id" value="<%=cust_id%>">
						<input type="hidden" name="root_id" value="<%=cust_id%>">
						<input type="hidden" name="rsrv_str1" value="1">
						<input type="hidden" name="local_native_code" value="">
						<input type="hidden" name="trade_type_code" value="1149">
						<input class="tjan" type="submit" name="sub" value="" onclick="return checkValue()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


