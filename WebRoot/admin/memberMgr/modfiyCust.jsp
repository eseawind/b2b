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
		<title>个人资料修改</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript" src="/templates/default/js/selectArea.js"></script>
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
        <script>
									//设置一级分类
							
										function setSort1(map_data)
										{
											var factory = document.getElementById("sort1");
											DWRUtil.removeAllOptions("sort1");
											DWRUtil.addOptions("sort1",{'000000000000000':'请选择...'});
											DWRUtil.addOptions("sort1",map_data);
											factory.options[0].selected=true;
											document.getElementById("sort2").style.display="none";
											document.getElementById("sort3").style.display="none"; 
											document.getElementById("nextElement").style.display="none"; 
										}
										//设置二级分类
										function setSecondClass(val)
										{
											var up_class_id=val;
											var type="3";
											Productclass.getProductClassByUpId(up_class_id,type,setSort2);
											document.getElementById("class_id").value=up_class_id;
										}
										function setSort2(map_data)
										{
											DWRUtil.removeAllOptions("sort2");
											DWRUtil.addOptions("sort2",map_data);
											document.getElementById("sort3").style.display="none";
											document.getElementById("nextElement").style.display="none"; 
											 var item=document.getElementById("sort2").length;
										     if(item==0)
										    {
										    	document.getElementById("sort2").style.display="none";
										    	document.getElementById("class_id").value=document.getElementById("sort2").value;
										    }
										    else
										    	{
										    		document.getElementById("sort2").style.display="block";
										    		document.getElementById("class_id").value=document.getElementById("sort2").value;
											    	//document.getElementById("calling_type_code").value=document.getElementById("sort2").value;
										    	}
										}
										//设置三级分类
										function setTherdClass(val)
										{
											var up_class_id=val;
											var type="3";
											Productclass.getProductClassByUpId(up_class_id,type,setSort3);
											document.getElementById("class_id").value=up_class_id;
										}
										function setSort3(map_data)
										{
											if(map_data!=null)
											{
												DWRUtil.removeAllOptions("sort3");
											     DWRUtil.addOptions("sort3",map_data);
											     var item=document.getElementById("sort3").length;
											     if(item==0)
											     {
											    	document.getElementById("sort3").style.display="none";
											    	document.getElementById("nextElement").style.display="none"; 
											     }
											     else
											     	{
											     		document.getElementById("sort3").style.display="block";
											     		
										    	document.getElementById("class_id").value=document.getElementById("sort3").value;
											     		//document.getElementById("calling_type_code").value=document.getElementById("sort3").value;
											     	}
											}
										}
										function setTypeName(classId,leave)
										{
											document.getElementById("class_level").value=leave;
											document.getElementById("up_class_id").value=classId;
										}
										 //动态生成下级分类信息
										function cretateSelect(index,value)
										{
										 document.getElementById("nextElement").style.display="block";
										 document.getElementById("class_level").value=index;
										 var type=document.getElementById("class_type").value;
										 var divId=parseInt(index)+parseInt(1);
										 document.getElementById("index_s").value=index;
										 document.getElementById(index).innerHTML="<select name=sort"+index+" id=sort"+index+" onchange=cretateSelect("+divId+",this.value) size=3 onclick=setTypeName(this.value) style=width:130px></select><div id="+divId+"></div>";
										 DWRUtil.removeAllOptions("sort"+index);
										 Productclass.getProductClassByUpId(value,type,setNewSelect);
									    }
									    //回调函数
									     function setNewSelect(map_data){
									      var id=document.getElementById("index_s").value;
									       document.getElementById("class_level").value=id;
									      DWRUtil.addOptions("sort"+id,map_data);
									        var item=document.getElementById("sort"+id).length;
										    if(item==0)
										    {
										    	document.getElementById(id).style.display="none"; 
										    }
										     else
										   	{
										   		document.getElementById(id).style.display="block";
										   	}
									    }
									    
									    
									</script>
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
		String province_name="",eparchy_name="",city_name="";
		String user_name = "",sex = "";
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);
		if (userList != null && userList.size() > 0) 
		{
			HashMap map = (HashMap) userList.get(0);
			if (map.get("user_name") != null) 
			{
		        user_name = map.get("user_name").toString();
			}
			if (map.get("qq") != null) 
			{
				qq = map.get("qq").toString();
			}
			if (map.get("sex") != null) 
			{
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
			
			if (map.get("group_attr") != null) 
			{
				group_attr = map.get("group_attr").toString();
				if(group_attr.equals("rrrrr"))
				{
				  group_attr="";
				}
			}
			
			if (map.get("client_status") != null) {
				client_status = map.get("client_status").toString();
			}
			
			if (map.get("calling_area_code") != null) {
				calling_area_code = map.get("calling_area_code").toString();
			}
			
			if (map.get("province") != null) 
			{
				province = map.get("province").toString();
			}
			
			if(map.get("eparchy_code")!=null)
			{
			 	eparchy_code=map.get("eparchy_code").toString();
			 	
			}
			 
			if (map.get("city_code") != null) 
			{
				city_code = map.get("city_code").toString();
				
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
	  
	  province_name=arae.getItemsBySelected("5J2mc0X0G85BH",province);
	  eparchy_name=arae.getItemsBySelected(province,eparchy_code);
	  city_name = arae.getItemsBySelected( eparchy_code,city_code );
		 
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
			
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">	
				
				<tr class="u4" height="27">
					 <td colspan="4"class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<b>公司名称和主营业务</b></td>
				</tr>
				 
				 <tr>
					<td class="u1">
						企业图片：					</td>
					<td class="u2" colspan="3" align="left">
						<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
							<iframe src="/inc/uploadImg.jsp?root_id=<%=cust_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
						</div>					</td>
				</tr>
				 
				 
				 <tr>
					<td  class="u1">
						公司名称：					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1">
							<input type="text" name="cust_aim" id="cust_aim" value="<%=cust_aim%>" maxlength="40" size="30">
						</div>					
					</td>
							
							
				<tr>
					<td  class="u1">
						电子邮箱：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="email" id="email" value="<%=email%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1" width="15%">
						客户类型：					
					</td>
					<td  class="u2" width="30%">
						<div class="ping1">
							<input type="hidden" name="cust_type" value="<%=cust_type%>"><%=paramName%>
						</div>		
					</td>
				</tr>
				
				<tr>
					<td  class="u1">
						传真：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="fax_nbr" id="fax_nbr" value="<%=fax_nbr%>" maxlength="40" size="30">
						</div>					
					</td>
					<td  class="u1">
						联系电话：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="group_contact_phone" id="group_contact_phone" value="<%=group_contact_phone%>" maxlength="40" size="30">
						</div>		
					</td>
				</tr>
				
				<tr>
					<td  class="u1">
						企业类型：					
					</td>
					<td colspan="3" class="u2" >
						当前类型->&nbsp;<input type="text" name="class_name" id="class_name" value="<%=class_name%>" size="15" style="border:0" readonly>
						<input type="hidden" name="class_id" id="class_id" value="<%=class_id%>" >您还可以在下面的列表框中选择类型进行修改
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
				<tr>
					<td  class="u1">
						公司所在地：					
					</td>
					<td  class="u2" >
						<div class="ping1">省：
							<select name="province" id="province" onclick="setCitys2(this.value)"  onfocus="selectarea(true);" onblur="selectarea(false);" >
									<%=province_name%>
								</select>
								<select name="eparchy_code" id="eparchy_code" onclick="setAreas(this.value)" onfocus="selectarea(true);" onblur="selectarea(false);">
									<%=eparchy_name%>
								</select>
								<select name="city_code" id="city_code" style="display:inline" onfocus="selectarea(true);" onblur="selectarea(false);">
									<%=city_name%>
									
								</select>
						</div>					
					</td>
					<td  class="u1">
						经营地址：					
					</td>
					<td  class="u2" >
						<div class="ping1">
							<input type="text" name="company_address" id="company_address" value="<%=company_address%>" maxlength="40" size="30">
						</div>		
					</td>
				</tr>
				<tr>
					<td  class="u1">
						主营方向：					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1">
							<textarea name="group_memo" cols="40" rows="6"><%=group_memo%></textarea>
						</div>					
					</td>
				</tr>
				<tr>
					<td  class="u1">
						公司简介：					
					</td>
					<td  class="u2" colspan="3">
						<div class="ping1">
							<textarea name="scope" style=display:none><%=scope%></textarea>
							<iframe ID=scope src=/www/ewebeditor/ewebeditor.htm?id=scope&root_id=<%=cust_id%>&style=coolblue frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
						</div>					
					</td>
				</tr>
			</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">	
				 		
					<input type="hidden" name="enterprise_type_code" value="<%=enterprise_type_code%>">
					<input type="hidden" name="pspt_end_date" value="1995-01-01">
					<input type="hidden" name="calling_type_code" value="<%=calling_type_code%>">
					<input type="hidden" name="enterprise_size_code"  value="<%=enterprise_size_code%>">
					<input type="hidden" name="reg_money" value="<%=reg_money%>">
					<input type="hidden" name="cust_name" value="<%=cust_name%>">
					<input type="hidden" name="user_count" value="0">
					<input type="hidden" name="all_emp_count"  value="<%=all_emp_count%>">
					<input type="hidden" name="china_emp_count" value="<%=china_emp_count%>">
					<input type="hidden" name="local_emp_count" value="<%=local_emp_count%>">
					<input type="hidden" name="juristic"  value="<%=juristic%>">
					<input type="hidden" name="juristic_type_code"  value="<%=juristic_type_code%>">
					<input type="hidden" name="pspt_type_code" value="<%=pspt_type_code%>">
					<input type="hidden" name="pspt_id"  value="<%=pspt_id%>">
					<input type="hidden" name="pspt_addr"  value="<%=pspt_addr%>">
					<input type="hidden" name="website"  value="<%=website%>">
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
						&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" onClick="location.href='/admin/memberMgr/memberMgr.jsp'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



