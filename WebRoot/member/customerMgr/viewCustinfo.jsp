<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="attach" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>个人资料修改</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
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
		String cust_id = "",user_id = "";
		if (session.getAttribute("SESSION_CUST_ID") != null) {
			cust_id = session.getAttribute("SESSION_CUST_ID").toString();
		}
		if (session.getAttribute("SESSION_USER_ID") != null){
      user_id = session.getAttribute("SESSION_CUST_ID").toString();
  	} 
  	String se_user_name = "";
  	if (session.getAttribute("SESSION_USER_NAME") != null){
      se_user_name = session.getAttribute("SESSION_USER_NAME").toString();
  	} 
		
		CustClass custClass = new CustClass();
		ParamethodMgr paramCom = new ParamethodMgr();
		ParamethodMgr para = new ParamethodMgr();
		AreaInfo arae = new AreaInfo();
		Map country_Map = new HashMap();
		ArrayList custList = new ArrayList();	
		UserInfo userOjb = new UserInfo();
		Productclass classInfo = new Productclass();
			
		String cust_class = custClass.getCustClassById(cust_id);
		
		String cust_name = "", cust_type = "", cust_aim = "", all_emp_count = "", china_emp_count = "",publish_date="";
		String local_emp_count = "", fax_nbr = "", group_contact_phone = "", email = "", company_address = "";
		String calling_area_code = "", client_status = "", juristic = "", juristic_type_code = "", post_addr = "";
		String job = "", qq = "", home_addr = "", blog = "", post_code = "", local_native_code = "", group_attr = "";
		String class_id = "", develope_man = "", develope_channel = "", pspt_type_code = "", eparchy_code = "", province = "";
		String city = "", group_memo = "", scope = "", website = "", user_count = "", pspt_id = "", pspt_addr = "";
		String city_code = "", reg_money = "", enterprise_size_code = "", calling_type_code = "", enterprise_type_code = "", enterprise_scope = "";
		
		String user_name = "",sex = "";
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);
		if (userList != null && userList.size() > 0) {
			HashMap map = (HashMap) userList.get(0);
			if (map.get("user_name") != null) {
		        user_name = map.get("user_name").toString();
			}
			if (map.get("qq") != null) {
				qq = map.get("qq").toString();
			}
			if (map.get("sex") != null) {
				sex = map.get("sex").toString();
			}
		}
		
		if(user_name.equals("")){
			user_name = se_user_name;
		}
		
		
		
		
		
		String userCountList="";
		if(paramCom.getItemsBySelected("53",user_count)!=null){
	    userCountList = paramCom.getItemsBySelected("53",user_count);
		}
		
		country_Map = arae.getCountryAllByCode("cn");
		custList = new Custinfo().getCustInfo(cust_id);
		if (custList != null && custList.size() > 0) {
			HashMap map = (HashMap) custList.get(0);
			if (map.get("cust_name") != null) {
				cust_name = map.get("cust_name").toString();
			}
			if (map.get("publish_date") != null) {
				publish_date = map.get("publish_date").toString();
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
				if(group_attr.equals("rrrrr")){
				  group_attr="";
				}
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
				if(city_code.equals("0")){
				  city_code="";
				}
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
				if(pspt_type_code.equals("0")){
				  pspt_type_code="";
				}
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
		String city_name = arae.getAreaNameByCode(city);
		
		if(province_name==null || province_name==""){
		   province_name="未选定省";
		}
		if(city_name==null || city_name==""){
		   city_name="未选定市";
		}
		String eparchy_name=arae.getAreaNameByCode(eparchy_code);
		if(eparchy_name==null || eparchy_name==""){
		   eparchy_name="未选定区";
		}
		String paramName="";
		ParamethodMgr paramTypeName = new ParamethodMgr();
		ArrayList paramNameList = new ArrayList();
		 paramNameList=paramTypeName.getComparamListByCode("14",cust_class);
		 if(paramNameList!=null &&paramNameList.size()>0){
		   HashMap map2 = (HashMap) paramNameList.get(0);
		   if(map2.get("para_code2")!=null){
		   paramName=map2.get("para_code2").toString();
		   }
		 }
		 
		 String class_name = classInfo.getClassNameById(class_id);
		 
		 
	%>
	<font color="#000000"></font>
	<body>
			
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#026D1E">	
				 <!--tr class="u4" height="27">
					 <td colspan="4"class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<b>帐户信息</b></td>
				 </tr>
				<tr>
					<td  class="u1" width="20%">
						登陆名：					
					</td>
					<td  class="u2" width="35%">
						<div class="ping1">
							<%=user_name%>
						</div>					
					</td>
					<td  class="u1" width="15%">
						客户类型：					
					</td>
					<td  class="u2" width="30%">
						<div class="ping1">
							<%=paramName%>
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						真实姓名：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<%=cust_name%>
						</div>					
					</td>
					<td  class="u1">
						性别：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							
								<%if(sex.equals("0"))out.println("男");%>
								<%if(sex.equals("1"))out.println("女");%>
							
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						电子邮箱：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<a href="mailto:<%=email%>"><%=email%></a>
						</div>					
					</td>
					<td  class="u1">
						联系电话：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<%=group_contact_phone%>
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						传真：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<%=fax_nbr%>
						</div>					
					</td>
					<td  class="u1">
						QQ：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<%=qq%>
						</div>		
					</td>
				</tr-->
				
				<tr class="u4" height="27">
					 <td colspan="4"class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<b>公司名称和主营业务</b></td>
				</tr>
				 
				 <tr> <td class="u1" width="10%"> 企业图片：</td> 
				 			<td class="u2" colspan="3" align="left"> <div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
									<div class="ping1">
										<%
												ArrayList attachlist = attach.getAttachInfoByList(cust_id);
												if (attachlist != null) {
														HashMap attachmap = (HashMap) attachlist.get(0);
														String file_path = "";
														if (attachmap.get("file_path") != null) {
															file_path = attachmap.get("file_path").toString();
														}
											%>
															
												<img src="<%=file_path%>" border=0 width="100" height="100">
															
											<%
												}else{
											%>
												<img src="/images/cp0.gif" border=0 width="100" height="100">
												<input type="button" name="shangchuan" value="上传企业图片" onclick="open('/inc/uploadImg.jsp?root_id=<%=cust_id%>','file','height=400,width=400,toolbar=0,status=0,scroll=yes')"/>
											<%		
												}
											%>
									</div>					
							</td>
				</tr>
				 
				 
				 <tr>
					<td  class="u1">
						公司名称：					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1">
							<%=cust_aim%>
						</div>					
					</td>
							
				
				
				<tr>
					<td  class="u1">
						企业类型：					
					</td>
					<td class="u2" >
							<div class="ping1">
						<%=class_name%>
						</div>		
				</td>
						
				<td  class="u1">
						注册日期：					
					</td>
					<td colspan="3" class="u2" >
							<div class="ping1">
						<%=publish_date%>
						</div>		
				</td>
						
						
						
				</tr>

				
				<tr>
					<td  class="u1">
						公司所在地：					
					</td>
					<td  class="u2" >
						<div class="ping1"><%=province_name%>--<%=eparchy_name%>--<%=city_name%>
						</div>					
					</td>
					<td  class="u1" width="10%">
						经营地址：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<%=company_address%>
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						主营方向：					
					</td>
					
					
					<td  class="u2" colspan="3">
						<div class="ping1">
							<%=group_memo%>
							
						</div>					
					</td>
				</tr>
				<tr>
					<td  class="u1">
						公司简介：					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1"><%=scope%>
						</div>					
					</td>
				</tr>
			</table>
			
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#026D1E">	
				<tr class="u3">
					<td colspan="4" align="center">
						<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;" align="absmiddle">	
					</td>
				</tr>
			</table>
			
			
	</body>
</html>


