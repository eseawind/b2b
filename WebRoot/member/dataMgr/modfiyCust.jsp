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
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>���������޸�</title>
		<link href="/style1/layout1.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*������ʽ6---- ͷ������1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*������ʽ1*/
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
		String cust_id = "",user_id = "";
		if (logsession.getAttribute("SESSION_CUST_ID") != null) {
			cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
		}
		if (logsession.getAttribute("SESSION_USER_ID") != null){
      user_id = logsession.getAttribute("SESSION_USER_ID").toString();
  	} 
		if(request.getParameter("cust_id")!=null){
			cust_id = request.getParameter("cust_id");
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
		
		String cust_name = "", cust_type = "", cust_aim = "", all_emp_count = "", china_emp_count = "";
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
		   province_name="��ѡ��";
		}
		if(city_name==null || city_name==""){
		   city_name="��ѡ��";
		}
		String eparchy_name=arae.getAreaNameByCode(eparchy_code);
		if(eparchy_name==null || eparchy_name==""){
		   eparchy_name="��ѡ��";
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
		<form name=form1 action=/doTradeReg.do method=post target="_self">
			
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#F1F9F3">	
				 <tr class="u4" height="27">
					 <td colspan="4"class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<b>�ʻ���Ϣ</b></td>
				 </tr>
				<tr>
					<td  class="u1" width="20%">
						��½����					
					</td>
					<td  class="u2" width="35%">
						<div class="ping1">
							<input type="hidden" name="user_name"   value="<%=user_name%>" maxlength="40" size="30"><%=user_name%>
						</div>					
					</td>
					<td  class="u1" width="15%">
						�ͻ����ͣ�					
					</td>
					<td  class="u2" width="30%">
						<div class="ping1">
							<input type="hidden" name="cust_type" value="<%=cust_type%>"><%=paramName%>
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						��ʵ������					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="cust_name"  value="<%=cust_name%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1">
						�Ա�					
					</td>
					<td  class="u2" >
						<div class="ping1">
							
								<input type="radio"   name="sex" <%if(sex.equals("0"))out.println("checked");%>  value= "0"/> ��
								<input type="radio"   name="sex" <%if(sex.equals("1"))out.println("checked");%>  value= "1"/> Ů		
							
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						�������䣺					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="email" id="email" value="<%=email%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1">
						��ϵ�绰��					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="group_contact_phone" id="group_contact_phone" value="<%=group_contact_phone%>" maxlength="40" size="30">
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						���棺					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="fax_nbr" id="fax_nbr" value="<%=fax_nbr%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1">
						QQ��					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="qq" id="qq" value="<%=qq%>" maxlength="40" size="30">
						</div>		
					</td>
				</tr>
				
				<tr class="u4" height="27">
					 <td colspan="4"class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<b>��˾���ƺ���Ӫҵ��</b></td>
				</tr>
				 
				 <tr>
					<td class="u1">
						��ҵͼƬ��					</td>
					<td class="u2" colspan="3" align="left">
						<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
							<iframe src="/inc/uploadImg.jsp?root_id=<%=cust_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
						</div>					</td>
				</tr>
				 
				 
				 <tr>
					<td  class="u1">
						��˾���ƣ�					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="cust_aim" id="cust_aim" value="<%=cust_aim%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1">
						��˾��ַ��					
					</td>
							<td  class="u2" >
					<input type="text" id="hidden" name="website"  value="<%=website%>">
				</td>
				
				<tr>
					<td  class="u1">
						��ҵ���ͣ�					
					</td>
					<td colspan="3" class="u2" >
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
											��ѡ��...										
										</option>
									</select>								
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
									<select name="sort3" size="10" style="width: 130px; display: none" onclick="setTypeName(this)" onchange="cretateSelect('4',this.value)">
										<option value="0">
											��ѡ��...										
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
						<input type="text" name="class_name" id="class_name" value="<%=class_name%>" maxlength="40" size="30" readonly>
						<input type="hidden" name="class_id" id="class_id" value="<%=class_id%>" >
				</td>
						
						
						
				</tr>
				
				
				<tr>
					<td  class="u1">
						��˾���ڵأ�					
					</td>
					<td  class="u2" >
						<div class="ping1">ʡ��
							
							
							
										<select name="province" id="province"  onclick="setCitys(this.value)">
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
											�У�
											<script>
												function setAreas(city_id){
													var fectureArray=new Array();
		 											fectureArray=['��ѡ��'];
													AreaInfo.getAreaByParent(city_id,function(data){
													 DWRUtil.removeAllOptions("city");
												   DWRUtil.addOptions("city",fectureArray);
													 DWRUtil.addOptions("city",data);
													});
												}
											</script>
											<select name="eparchy_code" id="eparchy_code"  onclick="setAreas(this.value)" >
												<option value="<%=eparchy_code%>">
													<%=eparchy_name%>							
												</option>
											</select>
											����
											<select name="city" id="city" style="display:inline" >
												<option value="<%=city%>"><%=city_name%></option>
											</select>		
							
						</div>					
					</td>
					<td  class="u1">
						��Ӫ��ַ��					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="company_address" id="company_address" value="<%=company_address%>" maxlength="40" size="30">
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						��Ӫ����					
					</td>
					
					
					<td  class="u2" colspan="3">
						<div class="ping1">
							<textarea name="group_memo" cols="40" rows="6"><%=group_memo%></textarea>
							
						</div>					
					</td>
				</tr>
				<tr>
					<td  class="u1">
						��˾��飺					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1">
							<textarea name="scope" style=display:none><%=scope%></textarea>
							<iframe ID=scope src=/www/ewebeditor/ewebeditor.htm?id=scope&root_id=<%=cust_id%>&style=coolblue frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
						</div>					
					</td>
				</tr>
			</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#026D1E">	
				 		
					<input type="hidden" name="enterprise_type_code" value="<%=enterprise_type_code%>">
					<input type="hidden" name="pspt_end_date" value="1995-01-01">
					<input type="hidden" name="calling_type_code" value="<%=calling_type_code%>">
					<input type="hidden" name="enterprise_size_code"  value="<%=enterprise_size_code%>">
					<input type="hidden" name="reg_money" value="<%=reg_money%>">
					<input type="hidden" name="user_count" value="<%=user_count%>">
					<input type="hidden" name="all_emp_count"  value="<%=all_emp_count%>">
					<input type="hidden" name="china_emp_count" value="<%=china_emp_count%>">
					<input type="hidden" name="local_emp_count" value="<%=local_emp_count%>">
					<input type="hidden" name="juristic"  value="<%=juristic%>">
					<input type="hidden" name="juristic_type_code"  value="<%=juristic_type_code%>">
					<input type="hidden" name="pspt_type_code" value="<%=pspt_type_code%>">
					<input type="hidden" name="pspt_id"  value="<%=pspt_id%>">
					<input type="hidden" name="pspt_addr"  value="<%=pspt_addr%>">
					<input type="hidden" name="post_code"  value="<%=post_code%>">
					<input type="hidden" name="city_code" id="city_code" value="<%=city_code%>">				
					<input type="hidden" name="class_id" id="class_id" value="<%=class_id%>">					
					<input type="hidden" name="develope_man" id="develope_man" value="<%=develope_man%>">		
					<input type="hidden" name="develope_channel" id="develope_channel" value="<%=develope_channel%>">			
					<input type="hidden" name="group_attr" id="group_attr" value="<%=group_attr%>">
					<input type="hidden" name="client_status" id="client_status" value="<%=client_status%>">					
					<input type="hidden" name="calling_area_code" id="calling_area_code" value="<%=calling_area_code%>">
					<input type="hidden" name="cust_id" value="<%=cust_id%>">
					<input type="hidden" name="root_id" value="<%=cust_id%>">
					<input type="hidden" name="rsrv_str1" value="1">
					<input type="hidden" name="local_native_code" value="">
					<input type="hidden" name="work_name" value="">
					<input type="hidden" name="home_addr" value="">
					<input type="hidden" name="post_addr" value="">
					<input type="hidden" name="job" value="">
					<input type="hidden" name="user_id" value="<%=user_id%>">
					<input type="hidden" name="birthday" value="1995-01-01">
					<input type="hidden" name="marriage" value="">
					<input type="hidden" name="community_id" value="">
					<input type="hidden" name="qq" value="">
					<input type="hidden" name="blog" value="">
					<input type="hidden" name="folk_code" value="">
					<input type="hidden" name="phone" value="">
					<input type="hidden" name="educate_degree_code" value="">
					<input type="hidden" name="trade_type_code" value="1149">

				

				<tr class="u3">
					<td colspan="4" align="center">
						<input class="tjan" type="submit" name="sub" value="" onclick="return checkValue()">	
						
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


