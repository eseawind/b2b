<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
 
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String user_id = "",cust_id="",view="",enable="",modify="",cust_aim="";
	String user_name = "",  passwd = "", passwd_answer = "", pspt_id = "", pspt_end_date = date, pspt_addr = "", birthday = date, local_native_code = "", post_addr = "",
	 phone = "", home_addr = "",city_code="", community_id = "",work_name="",work_depart="",marriage="", job = "", email = "",qq="",rsrv_str4="",fax="",blog="",post_code="",depart_code="",depart_name="";
	ParamethodMgr paramCom = new ParamethodMgr();
	String educate_degree_code="", pspt_type_code="",folk_code="",folk_code_v="";
	String pspt_type_code_v="";
	HttpSession  logsession = request.getSession(); 
  
  if (logsession.getAttribute("SESSION_CUST_ID") != null)
  {
      cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
  }	  
	if (logsession.getAttribute("SESSION_USER_ID") != null)
  {
      user_id = logsession.getAttribute("SESSION_USER_ID").toString();
  } 
	  
	if( cust_id !=null){
	  cust_aim=new Custinfo().getCustCompany(cust_id);
	}
	 
	String cust_name="";
	UserInfo userOjb = new UserInfo();
	if ( user_id  != null) 
	{
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);


		if (userList != null && userList.size() > 0) {
			HashMap map = (HashMap) userList.get(0);
			if (map.get("user_name") != null) {
		        user_name = map.get("user_name").toString();
			}
			if (map.get("cust_name") != null) {
		        cust_name = map.get("cust_name").toString();
			}
			if (map.get("passwd") != null) {
		        passwd = map.get("passwd").toString();
			}
			if (map.get("passwd_answer") != null) {
				passwd_answer = map.get("passwd_answer").toString();
			}
			if (map.get("pspt_id") != null) {
				pspt_id = map.get("pspt_id").toString();
			}
			if (map.get("city_code") != null) {
				city_code = map.get("city_code").toString();
			}
			if (map.get("pspt_end_date") != null) {
				pspt_end_date = map.get("pspt_end_date").toString();
				if (pspt_end_date.length() > 10) {
					pspt_end_date = pspt_end_date.substring(0, 10);
				}
			}
			if (map.get("pspt_addr") != null) {
				pspt_addr = map.get("pspt_addr").toString();
			}
			if (map.get("birthday") != null) {
				birthday = map.get("birthday").toString();
				if (birthday.length() > 10) {
					birthday = birthday.substring(0, 10);
				}
			}
			if (map.get("local_native_code") != null) {
				local_native_code = map.get("local_native_code").toString();
			}
			if (map.get("post_addr") != null) {
				post_addr = map.get("post_addr").toString();
			}
			if (map.get("phone") != null) {
				phone = map.get("phone").toString();
			}
			if (map.get("community_id") != null) {
				community_id = map.get("community_id").toString();
			}
			if (map.get("home_addr") != null) {
				home_addr = map.get("home_addr").toString();
			}
			if (map.get("work_name") != null) {
				work_name = map.get("work_name").toString();
				if(work_name.equals("0")){
				 work_name="";
				}
			}
			if (map.get("work_depart") != null) {
				work_depart = map.get("work_depart").toString();
				if(work_depart.equals("1")){
				work_depart="";
				}
			}
			if (map.get("job") != null) {
				job = map.get("job").toString();
			}
			if (map.get("marriage") != null) {
				marriage = map.get("marriage").toString();
			}
			if (map.get("email") != null) {
				email = map.get("email").toString();
			}
			if (map.get("rsrv_str4") != null) {
				rsrv_str4 = map.get("rsrv_str4").toString();
			}
			if (map.get("qq") != null) {
				qq = map.get("qq").toString();
			}
			if (map.get("fax") != null) {
				fax = map.get("fax").toString();
			}
			if (map.get("blog") != null) {
				blog = map.get("blog").toString();
			}
			if (map.get("post_code") != null) {
				post_code = map.get("post_code").toString();
			}
			if (map.get("depart_code") != null) {
				depart_code = map.get("depart_code").toString();
			}
			if (map.get("educate_degree_code") != null) {
				educate_degree_code = map.get("educate_degree_code").toString();
			}
			
			if (map.get("pspt_type_code") != null) {
				pspt_type_code = map.get("pspt_type_code").toString();
				pspt_type_code_v = paramCom.getParaCode2ByParaCode1("37", pspt_type_code);
			}
			if (map.get("folk_code") != null) {
				folk_code = map.get("folk_code").toString();
				folk_code_v = paramCom.getParaCode2ByParaCode1("23", folk_code);
			}			
		}
	}
	ArrayList passReqList = paramCom.getCompareInfo("CRM", "passwd_ques");
	ArrayList creditList = paramCom.getCompareInfo("CRM", "pspt_type_code");
	ArrayList folkList = paramCom.getCompareInfo("CRM", "folk_code");
	String marriaged = new ParamethodMgr().getItemsBySelected("36", marriage);
	String degree = new ParamethodMgr().getItemsBySelected("34", educate_degree_code);
	AreaInfo arae=new AreaInfo();
	String province =arae.getItemsBySelected("5J2mc0X0G85BH",rsrv_str4 );
     Map country_Map=new HashMap();
     String up_org_id="";
     country_Map=arae.getAreaByParent("5J2mc0X0G85BH");
     
     ArrayList orgList=new OrganizeInfo().getOrgnaizeByOrg_id(depart_code);

     if(orgList !=null && orgList.size()>0){
        HashMap map=(HashMap)orgList.get(0);
        depart_name=map.get("org_name").toString(); 
        up_org_id=map.get("up_org_id").toString();
        if(up_org_id=="000000000000000" || up_org_id.equals("000000000000000")){
         up_org_id=depart_code;
        }
     }
     String display="";
   commMethodMgr commen = new commMethodMgr();
  
   String idx = user_id;  
   
   String up_orga_id="000000000000000";
	 if(request.getParameter("up_org_id")!=null){
		 up_orga_id = request.getParameter("up_org_id");
	 }
   ArrayList list=bean.getOrganizeByUpIdList(cust_id,up_orga_id);
   
   ArrayList custOrgList = bean.getOrgnaizeByCust_id(cust_id);
   
   
   
   //取出省，市，区
   AreaInfo areaInfo = new AreaInfo();
   String province_a="",eparchy_code_a="",city_a="",province_v="",eparchy_code_v="",city_v="";
   ArrayList custInfoList = userOjb.getUserInfoByUserId(user_id);
   if(custInfoList!=null && custInfoList.size()>0){
   		HashMap custMap = (HashMap)custInfoList.get(0);
   		if (custMap.get("rsrv_str4") != null) {
				province_v = custMap.get("rsrv_str4").toString();
				province_a = areaInfo.getAreaNameByCode(province_v);
			}else{
				province_a = "未选地区";		
			}
			if (custMap.get("eparchy_code") != null) {
				eparchy_code_v = custMap.get("eparchy_code").toString();
				eparchy_code_a = areaInfo.getAreaNameByCode(eparchy_code_v);
			}else{
				eparchy_code_a = "未选地区";		
			}
			if (custMap.get("city_code") != null) {
				city_v = custMap.get("city_code").toString();
				city_a = areaInfo.getAreaNameByCode(city_v);
			}else{
				city_a = "未选地区";		
			}
   }
   
   
%>
 <html>
	<head>
		<title>个人资料修改</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/OrganizeInfo.js'></script>  
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/ext/ext-all.js"></script>
<script language="JavaScript" src="/js/dataMgr.js"></script>
</head>
	<body onload="createTree()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
						<table width=100% border=0 cellpadding=1 cellspacing=1
							bgcolor="#98D9A2" align="center">
							<input type=hidden name=trade_type_code value="0110" >
							<input name="user_id" type=hidden value=<%=user_id%>>
							<input name="cust_id" id="cust_id" type=hidden value=<%=cust_id%>>
							 <tr class="u4" height="27">
 <td colspan="4" align="left">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>用户基本资料</b></font></td>
</tr>							
							<tr>
								<td class="u1">
								真实姓名：</td>
								<td  class="u2">
									<input name="cust_name" type=text value="<%=cust_name%>" size="30">									
							  </td>
							  <td class="u1">
								登陆账号：</td>
								<td  class="u2">
									<%=user_name%>
							  </td>
							</tr>
							<tr style="display:none;">
								<td class="u1">
									密码：</td>
								<td class="u2">
									<input name=passwd type=text value="<%=passwd%>" size="30">
								</td>
								<td class="u1">
									确认密码：								</td>
								<td class="u2">
									<input name=passwd1 type=text value="<%=passwd%>" size="30">
								</td>
							</tr>
							<tr style="display:none;">
								<td class="u1">
									密码提示问题：								</td>
								<td class="u2">
									<select name=passwd_ques>
										<%
												if (passReqList != null && passReqList.size() > 0) {
												for (int i = 0; i < passReqList.size(); i++) {
													HashMap map = (HashMap) passReqList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
													<option value="<%=value%>">
														<%=name%>
													</option>
										<%
											}
											}
										%>
									</select>
								</td>
								<td class="u1">
									密码提示问题答案：								</td>
								<td class="u2">
									<input name=passwd_answer type=text value="<%=passwd_answer%>" size="30"  <%=enable%>>
								</td>
							</tr>
			<tr>
								<td class="u1">
									归属部门：								
								</td>
								<td  class="u2" colspan="3">
									 <div id="sh">
								    
								    <%
								    	if(custOrgList!=null){

											String up_orgg_id="",up_org_name="";
											if(list!=null && list.size()>0){
												for(int i=0;i<list.size();i++){
													HashMap upMap = (HashMap)list.get(i);
													if(upMap.get("org_id")!=null){
														up_orgg_id = upMap.get("org_id").toString();
													}
													if(upMap.get("org_name")!=null){
														up_org_name = upMap.get("org_name").toString();
													}
													ArrayList downlist=bean.getOrganizeByUpIdList(cust_id,up_orgg_id);
											%>
												<input type="radio" name="up_org_radio" value="<%=up_orgg_id%>" onclick="javascript:document.getElementById('org_depart_code').value = this.value;document.getElementById('depart_name').value = document.getElementById('depart_name'+<%=i%>).value;">
												<input type="hidden" name="depart_name<%=i%>" id="depart_name<%=i%>" value="<%=up_org_name%>">
												<%
													if(downlist!=null && downlist.size()>0){
												%>
												<a href="modfiyUser.jsp?up_org_id=<%=up_orgg_id%>" title="点击进入子部门！"><%=up_org_name%></a>
												<%
													}else{
												%>
													<font color="black"><%=up_org_name%></font>
												<%
													}
												%>
												<br>
											<%
												}
											}
										%>
								    	<input name="depart_name" type="text" id="depart_name" value="<%=depart_name%>" size="30" />
								    <%
								    	}else{
								    %>
								    	无部门组织结构！点击<a href="/member/organizeMgr/orgIndex.jsp"><b>添加部门</b></a>
								    <%
								    	}
								    %>
								    
								   </div>
									<input type="hidden" name="org_depart_code" id="org_depart_code" value="<%=depart_code%>"> 
									
								</td>
								 
							</tr>
							<tr>
								<td class="u1"> 省份： </td>
								
            		<td class="u2" colspan="3">
	          				<div class="ping1" style="display:inline;">
	       							<select name="province" id="province" onclick="setCitys(this.value)">
												<option value="<%=province_v%>"><%=province_a%></option>
												<%=province%>
	    								</select>
										</div>
										<font style="font-weight:bolder;">归属城市：</font>
										<div class="ping1" style="display:inline;">
											<select name="eparchy_code" id="eparchy_code" style="display:inline"  onclick="setAreas(this.value)">
												<option value="<%=eparchy_code_v%>"><%=eparchy_code_a%></option>
									 		</select>
	      						<font style="font-weight:bolder;">区/县：</font>
	     	 							<select name="city_code" id="city_code" style="display:inline">
												<option value="<%=city_v%>"><%=city_a%></option>
											</select>
	        					</div>
      					</td>
							</tr>
							<input type="hidden" name="city_code" id="city_code" value="<%=city_code%>">
							<tr>
								<td class="u1">
									证件类别：								</td>
								<td class="u2">
									<select name=pspt_type_code>
										<option value="<%=pspt_type_code%>"><%=pspt_type_code_v%></option>
										<%
												if (creditList != null && creditList.size() > 0) {
												for (int i = 0; i < creditList.size(); i++) {
													HashMap map = (HashMap) creditList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>
										</option>
										<%
											}
											}
										%>
									</select>
								</td>
								<td class="u1">
									证件号码：								</td>
								<td class="u2">
									<input name=pspt_id type=text value="<%=pspt_id%>" size="30"  <%=enable%>>
								</td>
							</tr>
							<tr>
								<td class="u1">
									证件有效期：								</td>
								<td class="u2" colspan="3">
									<input name="pspt_end_date" type="text" id="pspt_end_date" onfocus="setday(this);" value="<%=pspt_end_date%>">
									(四位年-二位月-二位日)
								</td>
							</tr>
							<tr>
								<td class="u1">
									证件地址：								</td>
								<td class="u2">
									<input name=pspt_addr type=text value="<%=pspt_addr%>" size="40" <%=enable%>>
								</td>
								<td class="u1">
									性别：								</td>
								<td class="u2">
									<select name=sex>
									<option value=0>
											男
									  </option>
										<option value=1>
											女
										</option>
									</select>
								</td>
							</tr>
							 <tr class="u4" height="27">
   <td colspan="4" align="left">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>用户详细资料</b></font></td>
</tr>
							<tr>
								<td class="u1">
									生日：								</td>
								<td class="u2">
									<input name="birthday" type="text" id="birthday" onfocus="setday(this);" value="<%=birthday%>" size="20" maxlength="10">
									(四位年-二位月-二位日)
								</td>
								<td class="u1">
									籍贯：								</td>
								<td class="u2">
									<input type=text name=local_native_code value="<%=local_native_code%>"  <%=enable%>>
								</td>
							</tr>
							<tr>
								<td class="u1">
									民族：								</td>
								<td class="u2">
									<select name=folk_code>
										<option value="<%=folk_code%>"><%=folk_code_v%></option>
										<%
												if (folkList != null && folkList.size() > 0) {
												for (int i = 0; i < folkList.size(); i++) {
													HashMap map = (HashMap) folkList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>
										</option>
										<%
											}
											}
										%>
									</select>
								</td>
								<td class="u1">
									联系电话：								</td>
								<td class="u2">
									<input type=text name="phone" id="phone" value="<%=phone%>"  <%=enable%> size="30" maxlength="15">
									<input type="hidden" name="group_contact_phone" id="group_contact_phone" value="">
								</td>
							</tr>
							<tr>
								<td class="u1">
									传真：								</td>
								<td class="u2">
									<input type=text name=fax_nbr value="<%=fax%>"  <%=enable%> size="30" maxlength="15">
								</td>
								<td class="u1">
									通信地址：								</td>
								<td class="u2">
									<input type=text name=post_addr value="<%=post_addr%>"  <%=enable%> size="30" maxlength="40">
								</td>
							</tr>
							<tr>
								<td class="u1">
									邮政编码：								</td>
								<td class="u2">
									<input type=text name=post_code value="<%=post_code%>"  <%=enable%> size="10" maxlength="6">
								</td>
								<td class="u1">
									家庭地址：								</td>
								<td class="u2">
									<input name=home_addr type=text value="<%=home_addr%>" size="30"  <%=enable%>>
								</td>
							</tr>
							<tr>
								<td class="u1">
									电子邮件：								</td>
								<td class="u2">
									<input name=email type=text value="<%=email%>" size="30"  <%=enable%>>
									<input name="cust_name" id="cust_name" type="hidden" value="<%=cust_name%>">
								</td>
								<td class="u1">
									QQ：								</td>
								<td class="u2">
									<input type=text name=qq value="<%=qq%>" <%=enable%> size="12" maxlength="12">
								</td>
							</tr>
							<tr>
								<td class="u1">
									Blog：								</td>
								<td class="u2">
									<input name=blog type=text value="<%=blog%>" size="30" <%=enable%>>
								</td>
								<td class="u1">
									工作单位：								</td>
								<td class="u2">
									<input type="text" name="work_name" value="<%=work_name%>">
								</td>
							</tr>
							<tr>
								<td class="u1">
									工作部门：								</td>
								<td class="u2">
									<input type="text" name="work_depart" value="<%=work_depart%>">
								</td>
								<td class="u1">
									职位：								</td>
								<td class="u2">
									<input name=job type=text value="<%=job%>" size="30">
								<!--	<input type=hidden name="up_org_id" id="up_org_id" value="<%=up_org_id%>"> -->
								</td>
						 	</tr>
							<tr>
								<td class="u1">
									教育程度：								</td>
								<td class="u2">
									<select name=educate_degree_code>
										
										<%=degree%> 
									
									
									
									
								</td>
								<td class="u1">
									婚姻：								</td>
								<td class="u2">
									<select name=marriage> 
										<%=marriaged%>
									</select> 
								</td>
							</tr>
							<tr>
								<td class="u1">
									社会保障号：</td>
								<td class="u2" colspan="3">
									<input type=text name=community_id value="<%=community_id%>">
								</td>
							</tr>
							 
							 <tr style="display:none;">
								<td class="u1">
							   		附件：
						   </td>
						   <td bgcolor="#FFFFFF" colspan="3" align="left">
						      <div class="ping1">
						         <input name="path" id="path" type="hidden" size=40 value="<%=idx%>">
						         <iframe id="saveImag" name="saveImag" style="margin-top:2px" frameborder="0" scrolling="no" hspace="0" WIDTH="330" HEIGHT="25" src="/inc/saveImage.jsp?root_id=<%=idx%>"></iframe>
						      </div>
						   </td>
						  </tr>							 						
							<tr>
								<td class="u3" colspan=4>
									<input class="tjan" name=submit1 type=submit value="" onclick=modfiyUserconfirmsub(Userform)>&nbsp;&nbsp;
									
								</td>
							</tr>
							 
					  </table>
				
		</form>
	</body>
</html>
<script language="javascript">
var fectureArray=new Array();
	 fectureArray=['请选择..'];
function setAreas(city_id){
	AreaInfo.getAreaByParent(city_id,function(data){
	 DWRUtil.removeAllOptions("city_code");
     DWRUtil.addOptions("city_code",fectureArray);
	 DWRUtil.addOptions("city_code",data);
	});
}
function setCitys(prov){
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
	 DWRUtil.removeAllOptions("eparchy_code");
	 DWRUtil.addOptions("eparchy_code",fectureArray);
	 DWRUtil.addOptions("eparchy_code",data);
	 DWRUtil.removeAllOptions("city_code");
	 DWRUtil.addOptions("city_code",fectureArray);
	});
}
</script>


