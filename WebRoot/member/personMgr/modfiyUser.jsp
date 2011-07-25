<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
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
	String user_id = "",cust_id="",user_name = "",  passwd = "", passwd_answer = "",passwd_ques="",view="",enable="",modify="",cust_name="";
	String  pspt_id = "", pspt_end_date = date, pspt_addr = "", birthday = date, local_native_code = "", post_addr = "",folk_code="",marriage="",sex="",rsrv_str4="",eparchy_code="",
	 phone = "", home_addr = "",city_code="", community_id = "",work_name="",work_depart="", job = "", email = "",qq="",fax="",blog="",post_code="",depart_code="",depart_name="",
	 pspt_type_code="",educate_degree_code="";
	ParamethodMgr paramCom = new ParamethodMgr();
	String pspt_type_code_v = "";
	String cust_aim="";
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
	   
	  cust_name= new Custinfo().getCustName(cust_id);	   
	  cust_aim = new Custinfo().getCustCompany(cust_id);

	}
	UserInfo userOjb = new UserInfo();
	if ( user_id  != null) 
	{
		
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);
		 
		if (userList != null && userList.size() > 0) 
		{
			HashMap map = (HashMap) userList.get(0);
			/*以下是用户基本信息*/
			if (map.get("user_name") != null) {
		        user_name = map.get("user_name").toString();
			}
			if (map.get("passwd") != null) {
		        passwd = map.get("passwd").toString();
			}
			if (map.get("passwd_answer") != null) {
				passwd_answer = map.get("passwd_answer").toString();
			}
			if (map.get("passwd_ques") != null) {
				passwd_ques = map.get("passwd_ques").toString();
			}
			if (map.get("rsrv_str4") != null) {
				rsrv_str4 = map.get("rsrv_str4").toString();
			}
			if (map.get("eparchy_code") != null) {
				eparchy_code = map.get("eparchy_code").toString();
			}
			if (map.get("city_code") != null) {
				city_code = map.get("city_code").toString();
			}
			/*以下是用户详细信息*/
			if (map.get("pspt_id") != null) {
				pspt_id = map.get("pspt_id").toString();
			}
			if (map.get("pspt_type_code") != null) {
				pspt_type_code = map.get("pspt_type_code").toString();
				pspt_type_code_v = paramCom.getParaCode2ByParaCode1("37", pspt_type_code);
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
			if (map.get("educate_degree_code") != null) {
				educate_degree_code = map.get("educate_degree_code").toString();
			}
			if (map.get("local_native_code") != null) {
				local_native_code = map.get("local_native_code").toString();
			}
			if (map.get("folk_code") != null) {
				folk_code = map.get("folk_code").toString();
			}
			if (map.get("post_addr") != null) {
				post_addr = map.get("post_addr").toString();
			}
			if (map.get("phone") != null) {
				phone = map.get("phone").toString();
			}
			
			if (map.get("home_addr") != null) {
				home_addr = map.get("home_addr").toString();
			}
			if (map.get("work_name") != null) {
				work_name = map.get("work_name").toString();
			}
			if (map.get("work_depart") != null) {
				work_depart = map.get("work_depart").toString();
			}
			if (map.get("job") != null) {
				job = map.get("job").toString();
			}
			if (map.get("email") != null) {
				email = map.get("email").toString();
			}
			if (map.get("sex") != null) {
				sex = map.get("sex").toString();
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
			if (map.get("marriage") != null) {
				marriage = map.get("marriage").toString();
			}
			if (map.get("community_id") != null) {
				community_id = map.get("community_id").toString();
			}
		}
	}
	String passwordques =  new ParamethodMgr().getItemsBySelected("28", passwd_ques);
	String credittype =  new ParamethodMgr().getItemsBySelected("37", pspt_type_code);
	String folk =  new ParamethodMgr().getItemsBySelected("23", folk_code);
	String degree = new ParamethodMgr().getItemsBySelected("34", educate_degree_code);
	String sexd = new ParamethodMgr().getItemsBySelected("35", sex);
	String marriaged = new ParamethodMgr().getItemsBySelected("36", marriage);
	 AreaInfo arae  =new AreaInfo();
     String province =arae.getItemsBySelected("5J2mc0X0G85BH",rsrv_str4 );
	 String city = arae.getItemsBySelected( rsrv_str4,eparchy_code );
	 String county  = arae.getItemsBySelected( eparchy_code,city_code );
     String up_org_id="";
     
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
		<title>成员管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type='text/javascript' src='/dwr/interface/AreaInfo.js'></script>
<script type='text/javascript' src='/dwr/interface/OrganizeInfo.js'></script>  
<script type='text/javascript' src='/dwr/engine.js'></script>  
<script type='text/javascript' src='/dwr/util.js'></script>
<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/ext/ext-all.js"></script>
<script language="JavaScript" src="/js/personMgr.js"></script>
</head>
	<body onload="createTree()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
			<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="<%=top_menu_id%>" />
			</jsp:include>	
			<table width=800 border="0" cellspacing="1" cellpadding="4" align="center">			
				<tr>
					<td>
						<table width=800 border=0 cellpadding=1 cellspacing=10 bgcolor="#DEEDFD" align="center">
							<input type=hidden name=trade_type_code value=2115 >
							<input name="user_id" type=hidden value=<%=user_id%>>
							<input name="cust_id" id="cust_id" type=hidden value=<%=cust_id%>>
							 <tr class="u4" height="27">
 								<td colspan="4">&nbsp;&nbsp;
 								<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;
 								<font size="2"><b>个人基本资料</b></font></td>
							</tr>						
							<tr>
								<td class="u1">
								公司名称：</td>
								<td class="u2">
								<input name="cust_name" type="text" value=<%=cust_name%>>	
							  </td>
							  <td class="u1">
								姓名：</td>
								<td width="74" class="u2">
									<%=user_name%>
							  </td>
							</tr>
							<tr style="display: none;">
								<td class="u1">
									密码：</td>
								<td class="u2">
									<input name=passwd type=text value="<%=passwd%>" size="30"  <%=enable%>>
								</td>
								<td class="u1">
									确认密码：								</td>
								<td class="u2">
									<input name=passwd1 type=text value="<%=passwd%>" size="30"  <%=enable%>>
								</td>
							</tr>
							<tr style="<%=display%>">
								<td class="u1">
									密码提示问题：								</td>
								<td class="u2">
									<select name=passwd_ques>
										<%=passwordques%>
									</select>
								</td>
								<td class="u1">
									密码提示问题答案：								</td>
								<td class="u2">
									<input name=passwd_answer type=text value="<%=passwd_answer%>" size="30" />
								</td>
							</tr>
							<tr style="display: none;">
								<td class="u1">
									归属部门：								</td>
								<td class="u2">
								   <div id="sh" style="display: none;">
								    <div id="tree-div"></div>
								   </div>
									<input type="hidden" name="org_depart_code" id="org_depart_code" value="<%=depart_code%>"> 
									<input name="depart_name" type="text" id="depart_name" value="<%=depart_name%>" size="30" <%=enable%>>
									<input type="checkbox" id="org" name="org" onclick="shwoOrHidden()">查看部门组织结构
								</td>
							</tr>
							<tr style="display:none">
								<td class="u1">
									是否允许登陆门户：								</td>
								<td class="u2">
									<select name=web_login_tag>
										<option value=1>
											允许
										</option>
										<option value=0>
											不允许
										</option>
									</select>
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
							<tr>
								<td class="u1">
									性别：								</td>
								<td class="u2">
									<select name=sex>
									<%=sexd%>
									</select>
								</td>
								<td class="u1">
									生日：								</td>
								<td class="u2">
									<input name="birthday" type="text" id="birthday" onfocus="setday(this);" value="<%=birthday%>" size="20" maxlength="10">
									(yyyy-MM-dd)
								</td>
							</tr>
							<tr>
								<td class="u1">
									籍贯：								</td>
								<td class="u2">
									<input type=text name=local_native_code value="<%=local_native_code%>"  <%=enable%>>
								</td>
								<td class="u1">
									民族：								</td>
								<td class="u2">
									<select name=folk_code>
										<%=folk%>
									</select>
								</td>
							</tr>
							<tr>
								<td class="u1">
									联系电话：								</td>
								<td class="u2">
									<input type=text name="phone" id="phone" value="<%=phone%>"  <%=enable%> size="30" maxlength="15">
									<input type="hidden" name="group_contact_phone" id="group_contact_phone" value="">
									<input type="hidden" name="cust_aim" id="cust_aim" value="<%=cust_aim%>">
								</td>
								<td class="u1">
									传真：								</td>
								<td class="u2">
									<input type=text name=fax_nbr value="<%=fax%>"  <%=enable%> size="30" maxlength="15">
								</td>
							</tr>
							<tr>
								<td class="u1">
									通信地址：								</td>
								<td class="u2">
									<input type=text name=post_addr value="<%=post_addr%>"  <%=enable%> size="30" maxlength="40">
								</td>
								<td class="u1">
									邮政编码：								</td>
								<td class="u2">
									<input type=text name=post_code value="<%=post_code%>"  <%=enable%> size="10" maxlength="6">
								</td>
							</tr>
							<tr>
								<td class="u1">
									家庭地址：								</td>
								<td class="u2">
									<input name=home_addr type=text value="<%=home_addr%>" size="30"  <%=enable%>>
								</td>
								<td class="u1">
									电子邮件：								</td>
								<td class="u2">
									<input name=email type=text value="<%=email%>" size="30"  <%=enable%>>
									<input name="Cust_Name" id="cust_name" type="hidden" value="<%=cust_name%>">
								</td>
							</tr>
							<!--input type="hidden" name="city_code" id="city_code" value="<%=city_code%>"-->
							 <tr class="u4" height="27">
 								<td colspan="4">&nbsp;&nbsp;
								<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;
								<font size="2"><b>个人详细资料</b></font></td>
							</tr>
							<tr>
								<td class="u1">
									证件类别：								</td>
								<td class="u2">
									<select name=pspt_type_code>
										<%=credittype%>
										<%=pspt_type_code_v%>
									</select>
								</td>
								<td class="u1">
									证件号码：								</td>
								<td class="u2">
									<input name=pspt_id type=text value="<%=pspt_id%>" size="30" />
								</td>
							</tr>
							<tr>
								<td class="u1">
									证件有效期：								</td>
								<td class="u2">
									<input name="pspt_end_date" type="text" id="pspt_end_date" onfocus="setday(this);" value="<%=pspt_end_date%>">
									(yyyy-MM-dd)
								</td>
								<td class="u1">
									证件地址：								</td>
								<td class="u2">
									<input name='pspt_addr' type='text' value="<%=pspt_addr%>" size='40' />
								</td>
							</tr>
							
							<tr>
								<td class="u1">
									QQ：								</td>
								<td class="u2">
									<input type=text name=qq value="<%=qq%>" <%=enable%> size="12" maxlength="12">
								</td>
								<td class="u1">
									Blog：								</td>
								<td class="u2">
									<input name=blog type=text value="<%=blog%>" size="30" <%=enable%>>
								</td>
							</tr>							
							<tr>
								<td class="u1">
									工作单位：								</td>
								<td class="u2">
									<input type="text" name="work_name" value="<%=work_name%>">
								</td>
								<td class="u1">
									工作部门：								</td>
								<td class="u2">
									<input type="text" name="work_depart" value="<%=work_depart%>">
								</td>
							</tr>							
							<tr> 
								<td class="u1"> 
									职位：</td> 
								<td class="u2"> 
								<input name=job type=text value="<%=job%>" size="30"> 
								<!--	<input type=hidden  name="up_org_id" id="up_org_id" value="<%=up_org_id%>"> --> 
								</td> 
								<td class="u1"> 
									教育程度：
								</td> 
								<td class="u2"> 
								<select name=educate_degree_code> 
								<%=degree%> 
								</select> 
								</td> 
							</tr> 
							<tr> 
								<td	class="u1"> 
									婚姻：
								</td> 
								<td	class="u2"> 
									<select name=marriage> 
										<%=marriaged%>
									</select> 
								</td> 
								<td class="u1"> 
									社会保障号：
								</td> 
								<td class="u2"> 
									<input type=text name=community_id value="<%=community_id%>"> 
									
								</td> 
							</tr> 
							<tr style="display:none;">
								<td class="u1">
							   		附件：
						   		</td>
						   		<td class="u2" colspan="3">
						      		<input name="path" id="path" type="hidden" size=40 value="<%=idx%>">
						         		<iframe id="saveImag" name="saveImag" style="margin-top:0px" frameborder="0" scrolling="no" hspace="0" WIDTH="330" HEIGHT="25" 
										src="/inc/saveImage.jsp?root_id=<%=idx%>"></iframe>
						      	</td>
						  	</tr>
							 
						
							<tr>
								<td class="u3"colspan=4>
									<input class="tjan" name=submit1 type=submit value=""onclick="confirmsub(Userform)">&nbsp;&nbsp;
									
								</td>
							</tr>
							 
					  </table>
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


