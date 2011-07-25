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
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />

<html>
	<head>
		<title>客户管理</title>
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px; font-weight:bold; padding-left:20px;}  /*横栏样式1*/
		.Tree-Img {
		    background-image:url(/images/org.png) !important;
		}
		.root-Img {
		    background-image:url(/images/home.png) !important;
		}
		</style>
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/UserInfo.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/OrganizeInfo.js'></script>  
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../ext/ext-all.js"></script>


</head>
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String user_id = "",cust_id="",view="",enable="",modify="",cust_aim="";
	String user_name = "",  passwd = "", passwd_answer = "", pspt_id = "", pspt_end_date = date, pspt_addr = "", birthday = date, local_native_code = "", post_addr = "",
	 phone = "", home_addr = "", community_id = "", job = "", email = "",qq="",fax="",blog="",post_code="",depart_code="",depart_name="";
	 String marriage="",work_name="",educate_degree_code="",work_depart="",fax_nbr="", folk_code="",sex="",pspt_type_code="";




	ParamethodMgr paramCom = new ParamethodMgr();
	  
	if(request.getParameter("cust_id")!=null){
	  cust_id=request.getParameter("cust_id");
	  cust_aim=new Custinfo().getCustCompany(cust_id);
	}
	if(request.getParameter("user")!=null){
	  modify=request.getParameter("user");
	}
	if(request.getParameter("view")!=null){
	  view=request.getParameter("view");
	  enable=" readonly";
	}
	String cust_name=bean.getCustNameById(cust_id);
	if (request.getParameter("user_id") != null) {
		user_id = request.getParameter("user_id");
		UserInfo userOjb = new UserInfo();
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);
		if (userList != null && userList.size() > 0) {
			HashMap map = (HashMap) userList.get(0);
			if (map.get("pspt_type_code") != null) {
		        pspt_type_code = map.get("pspt_type_code").toString();
			}
			if (map.get("sex") != null) {
		        sex = map.get("sex").toString();
			}
			if (map.get("folk_code") != null) {
		        folk_code = map.get("folk_code").toString();
			}
			if (map.get("fax_nbr") != null) {
		        fax_nbr = map.get("fax_nbr").toString();
			}
			if (map.get("user_name") != null) {
		        user_name = map.get("user_name").toString();
			}
			if (map.get("educate_degree_code") != null) {
		        educate_degree_code = map.get("educate_degree_code").toString();
			}
			if (map.get("marriage") != null) {
		        marriage = map.get("marriage").toString();
			}
			if (map.get("work_depart") != null) {
		        work_depart = map.get("work_depart").toString();
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
			if (map.get("pspt_end_date") != null) {
				pspt_end_date = map.get("pspt_end_date").toString();
				if (pspt_end_date.length() > 10) {
					pspt_end_date = pspt_end_date.substring(0, 10);
				}
			}
			if (map.get("work_name") != null) {
				work_name = map.get("work_name").toString();
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
			if (map.get("job") != null) {
				job = map.get("job").toString();
			}
			if (map.get("email") != null) {
				email = map.get("email").toString();
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
		}

	 AreaInfo arae=new AreaInfo();
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
%>

	<body>
	
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>员工基本信息</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=800 border=0 cellpadding=1 cellspacing=1 bgcolor="#dddddd" align="center">
							
							<tr>
								<td width="17%" align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									用户名：								</td>
								<td width="44%" style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=user_name%>
							  </td>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									归属部门：								
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=depart_name%>
							  </td>	
							</tr>																											
							<tr>
								<td align=right bgcolor="#f2f2f2" style="color:#000000;font-weight:bold;font-size:12px;">
									证件类别：								
								</td>
								<td style="background-color:#ffffff; color:#000000; font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%
										if(null != folk_code && !"".equals(folk_code)){
											out.print(paramCom.getParaCode2ByParaCode1("37", folk_code));
										}
									%>
							  </td>
							  <td align=right bgcolor="#f2f2f2" width="10%">
							  	<span style="color:#000000;  font-weight:bold; font-size:12px;">证件号码：</span>
							  </td>
							  <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=pspt_id%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									证件有效期：
							 </td>
								<td 
									style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=pspt_end_date%>
							  </td>
							  <td align=right bgcolor="#f2f2f2">
							  	<span style=" color:#000000;  font-weight:bold; font-size:12px;">证件地址：</span>
							  </td>
							  <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=pspt_addr%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									用户性别：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%	if(null != sex && !"".equals(sex)){
											out.print(paramCom.getParaCode2ByParaCode1("35", sex));
										}
									%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">生日：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=birthday%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									籍贯：								
							 </td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=local_native_code%>
							</td>
							   <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">民族：</span></td>
							   <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%
										if(null != folk_code && !"".equals(folk_code)){
											out.print(paramCom.getParaCode2ByParaCode1("23", folk_code));
										}
									%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									联系电话：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=phone%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">传真：</span></td>
							   <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=fax_nbr%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									通信地址：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=post_addr%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">邮政编码：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=post_code%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									家庭地址：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=home_addr%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">电子邮件：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=email%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									QQ：								</td>
							<td width="20%" style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=qq%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">Blog：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=blog%>
							  </td>
							</tr>
							
							<tr style="display: none">
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									工作单位：								</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=work_name%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">工作部门： </span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=work_depart%>
							  </td>
							</tr>
							
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									职位：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=job%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">教育程度：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%
										if(null != marriage && !"".equals(educate_degree_code)){
											out.print(paramCom.getParaCode2ByParaCode1("34", educate_degree_code));
										}
									%>
							  </td>
							</tr>
							<tr>
								<td align=right bgcolor="#f2f2f2" style=" color:#000000;  font-weight:bold; font-size:12px;">
									婚姻：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%
										if(null != marriage && !"".equals(marriage)){
											if(marriage.equals("0")){
												out.print("未婚");
											}else{
												out.print("已婚");
											}
										}
									%>
							  </td>
							    <td align=right bgcolor="#f2f2f2"><span style=" color:#000000;  font-weight:bold; font-size:12px;">社会保障号：</span></td>
							    <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=community_id%>
							  </td>
							</tr>		
							<tr>
									<td width="100%" align="center" height="50" bgcolor="#FFFFFF" colspan="6">
											<img src="/admin/images/gb.gif" onclick="javascript:window.open('','_self','');window.close();" style="cursor:hand;">
									</td>
							</tr>																
						</table>
					</td>
				</tr>
				
			</table>
	
	<%
	}
	%>
	
	</body>
	
</html>



