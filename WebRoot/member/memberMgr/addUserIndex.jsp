<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	String up_orga_id="000000000000000";
	String org_name="";
	String birthday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String user_id = "",cust_id="",view="",enable="",modify="",org_idx="";
	ParamethodMgr paramCom = new ParamethodMgr();
	HttpSession http_Ses=request.getSession();
	if(http_Ses.getAttribute("SESSION_CUST_ID")!=null){
	  cust_id=String.valueOf(http_Ses.getAttribute("SESSION_CUST_ID"));
	}
	//String cust_name=bean.getCustNameById(cust_id);
	ArrayList passReqList = paramCom.getCompareInfo("CRM", "passwd_ques");
	ArrayList creditList = paramCom.getCompareInfo("CRM", "pspt_type_code");
	ArrayList folkList = paramCom.getCompareInfo("CRM", "folk_code");
	ArrayList degreeList = paramCom.getCompareInfo("CRM", "educate_degree_code");
	AreaInfo arae=new AreaInfo();
  Map country_Map=new HashMap();
  country_Map=arae.getAreaByParent("5J2mc0X0G85BH");
  user_id=comm.GenTradeId();
  String up_orgaa_id="000000000000000";
  if(request.getParameter("up_org_id")!=null){
  	up_orgaa_id = request.getParameter("up_org_id");
  }
  
	ArrayList list=bean.getOrganizeByUpIdList(cust_id,up_orgaa_id);
  if( list != null && list.size() > 0 )
  {
	  HashMap map=(HashMap)list.get(0);
	  org_idx=map.get("org_id").toString();
	}
	//cust_name=bean.getCustNameById(cust_id);
	TradeInterface interf = new TradeInterface();
%>
 <html>
	<head>
		<title>成员管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
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
<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/ext/ext-all.js"></script>
<script type="text/javascript" src="/js/memberMgr.js"></script>
</head>
	<body onload="startP()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
			<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="modifyUserIndex.jsp">资料管理</a>
				</td>
			</tr>
		</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" align="center">
							<input type=hidden name=trade_type_code value="0280" >
							<input name="user_id" type=hidden value=<%=user_id%>>
							<input name="cust_id" id="cust_id" type=hidden value=<%=cust_id%>>
							<input name="org_idx" id="org_idx" type="hidden" value="<%=org_idx%>">	
							<tr class="u4" height="27">
 								<td colspan="4" class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>员工基本信息</b></font></td>
							</tr>						
							<tr>
								<td width="17%" class="u1">
									登陆名：								</td>
								<td   class="u2">
								<div><input type="text" name="user_name" id="user_name" value="" onblur="checkUserName(this.value);">	</div>							</td>
								  <td width="17%" class="u1">
									真实姓名：								</td>
								<td   class="u2">
								<div><input type="text" name="cust_name" id="cust_name" value="">	</div>							</td>
							</tr>
							<tr>
								<td
									class="u1">
									密码：								</td>
								<td class="u2">
								<div><input type=password name=passwd value="">	</div>							</td>
							    <td class="u1">确认密码：</td>
							    <td class="u2"><div><input type=password name=passwd1 value="">	</div></td>
							</tr>
							<tr>
								<td
									class="u1">
									密码提示问题：								</td>
								<td class="u2">
									<div class="ping1"><select name=passwd_ques>
										<%
												if (passReqList != null && passReqList.size() > 0) {
												for (int i = 0; i < passReqList.size(); i++) {
													HashMap map = (HashMap) passReqList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
													<option value="<%=value%>">
														<%=name%>													</option>
										<%
											}
											}
										%>
									</select>	</div>							</td>
							    <td class="u1">密码提示问题答案：</td>
							    <td class="u2"><div class="ping1"><input type=text name=passwd_answer value="">	</div></td>
							</tr>
							<tr>
								<td class="u1">
									归属部门：								
								</td>
							<td  style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; display:inline" align=left>
								   <div id="sh">
								<table>   	
						<%
							
							if(list!=null && list.size()>0){
								for(int i=0;i<list.size();i++){
									String org_id="",org_desc="",in_date="";
									HashMap orgMap = (HashMap)list.get(i);
									if(orgMap.get("org_id")!=null){
										org_id = orgMap.get("org_id").toString();
									}
									if(orgMap.get("org_name")!=null){
										org_name = orgMap.get("org_name").toString();
									}
									if(orgMap.get("org_desc")!=null){
										org_desc = orgMap.get("org_desc").toString();
									}
									if(orgMap.get("in_date")!=null){
										in_date = orgMap.get("in_date").toString();
									}
									if(orgMap.get("up_orga_id")!=null){
										up_orga_id = orgMap.get("up_orga_id").toString();
									}
									ArrayList downlist=new OrganizeInfo().getOrganizeByUpIdList(cust_id,org_id);
						%>
							<tr class="u2">
									<td align="left" >
										<input type="radio" name="org_value" id="org_value<%=i%>" value="<%=org_id%>" onclick="setDepartCode('<%=i%>')">
										<input type="hidden" name="org_name<%=i%>" id="org_name<%=i%>" value="<%=org_name%>">
											<%
												if(downlist!=null && downlist.size()>0){
											%>
												
												<a href="addUserIndex.jsp?up_org_id=<%=org_id%>" title="点击进入子部门！"><%=org_name%></a>
											<%		
												}else{
											%>
												<font color="black"><%=org_name%></font>
											<%			
												}
											%>
											
									</td>
							</tr>
						<%
								}
							}
							else
							{
									org_name = "没有部门供您选择,请到部门管理添加部门";
							}
						 
							if(!up_orgaa_id.equals("000000000000000")){
						%>
						<tr>
								<td>
									<a href="addUserIndex.jsp">返回</a>
								</td>
						</tr>
						<%
							}
						%>
						
						<script language="javascript">
								function setDepartCode(val){
									document.getElementById('org_name').value=document.getElementById('org_name'+val).value;
									document.getElementById('org_id').value=document.getElementById('org_value'+val).value;
								}
						</script>
						</table>
								    
								   </div>
									<input name="org_name" type="text" id="org_name" value="<%=org_name%>" size="30" readonly />
									<input name="org_id" type="hidden" id="org_id" value="" size="30">
									
								</td>
						</tr>
							<tr>
								<td
									class="u1">
									用户角色：								</td>
								<td colspan="3" class="u2">
									<div><select name="role_code" id="role_code">
									    <option value="">请选择归属角色</option>
									    <%=interf.getCustSpeOption("ROLE_LIST",cust_id)%>
									</select>
									用户角色和权限密切相关，请慎重设置 [<a href="/member/roleMgr/addRoleInfo.jsp">添加角色</a>]		</div>						</td>
							</tr>
							<tr style="display:none">
								<td class="u1">
									是否允许登陆门户：								</td>
								<td colspan="3" class="u2">
								<div class="ping1"><input type="hidden"  name="web_login_tag" id="web_login_tag" value="1">	</div>	
								<div class="ping1"><input type="hidden"  name="org_depart_code" id="org_depart_code" value="1">	</div>							</td>
							</tr>
							<tr>
								<td class="u1">省份：</td>
               					<td class="u2" colspan="6">
            					<div class="ping1" style="display:inline;">
         						<select name="province" id="province" onclick="setCitys(this.value)">
         						<option value="">请选择..</option>
								<%
									if (country_Map != null && country_Map.size() > 0)
									{
										Iterator it = country_Map.entrySet().iterator();
										 while (it.hasNext()) {
											Map.Entry entry = (Map.Entry) it.next();
											Object key = entry.getKey();
											Object value = entry.getValue();
											%>
											<option value=<%=key%>><%=value%></option>
											<%
										}
									 }
							   %>
						    	</select></div>
				   				
			  					<b>归属城市：</b>
			  					<div class="ping1" style="display:inline;">
				 					<select name="eparchy_code" id="eparchy_code" style="display:inline"  onclick="setAreas(this.value)">
                   						<option value="">请选择..</option>
            	 					</select></div>
              					<b>区/县：</b>
            	 					<select name="city_code" id="city" style="display:inline">
                   						<option value="">请选择..</option>
                 					</select>             				</td>
							</tr>
							<tr class="u4" height="27">
 								<td colspan="4" class="u2">&nbsp;&nbsp;
								<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>员工详细信息</b></font></td>
							</tr>
							<tr>
								<td class="u1">
									证件类别：								</td>
								<td class="u2">
									<div class="ping1"><select name=pspt_type_code>
										<%
												if (creditList != null && creditList.size() > 0) {
												for (int i = 0; i < creditList.size(); i++) {
													HashMap map = (HashMap) creditList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>										</option>
										<%
											}
											}
										%>
									</select>	</div>							</td>
							    <td class="u1">证件号码：</td>
							    <td class="u2"><div class="ping1"><input type=text name=pspt_id value=""></div></td>
							</tr>
							<tr>
								<td class="u1">
									证件有效期：								</td>
								<td class="u2">
									<div class="ping1"><input name="pspt_end_date" type="text" id="pspt_end_date"
										onfocus="setday(this);" value="<%=birthday%>">
									</div>							</td>
							    <td class="u1">证件地址：</td>
							    <td class="u2"><div class="ping1"><input type=text name=pspt_addr value="">	</div>	</td>
							</tr>
							<tr>
								<td class="u1">
									用户性别：								</td>
								<td class="u2">
									<div class="ping1"><select name=sex>
										<option value=1>
											女性										</option>
										<option value=0>
											男性										</option>
									</select>		</div>						</td>
							    <td class="u1">生日：</td>
							    <td class="u2"><div class="ping1"><input name="birthday" type="text" id="birthday" onfocus="setday(this);" value="<%=birthday%>">
										</div></td>
							</tr>
							<tr>
								<td class="u1">
									籍贯：								</td>
								<td class="u2">
								<div class="ping1"><input type=text name=local_native_code value="">								</div></td>
							    <td class="u1">民族：</td>
							    <td class="u2"><div class="ping1"><select name=folk_code>
										<%
												if (folkList != null && folkList.size() > 0) {
												for (int i = 0; i < folkList.size(); i++) {
													HashMap map = (HashMap) folkList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>"><%=name%></option>
										<%
											}
											}
										%>
									</select>	</div></td>
							</tr>
							<tr>
								<td class="u1">
									联系电话：								</td>
								<td class="u2">
									<div class="ping1"><input type=text name="phone" id="phone" value="">
									<input type="hidden" name="group_contact_phone" id="group_contact_phone" value="">	</div>								</td>
							    <td class="u1">传真：</td>
							    <td class="u2">
									<div class="ping1"><input type=text name=fax_nbr value=""></div>								</td>
							</tr>
							<tr>
								<td
									class="u1">
									通信地址：								</td>
								<td class="u2">
								<div class="ping1"><input type=text name=post_addr value="">	</div>							</td>
							    <td class="u1">邮政编码：</td>
							    <td class="u2"><div class="ping1"><input type=text name=post_code value="">	</div></td>
							</tr>
							<tr>
								<td
									class="u1">
									家庭地址：								</td>
								<td class="u2">
								<div class="ping1"><input type=text name=home_addr value="">	</div>							</td>
							    <td class="u1">电子邮件：</td>
							    <td class="u2"><div class="ping1">	<input type=text name=email value="" >
									 	</div></td>
							</tr>
							<tr>
								<td
									class="u1">
									QQ：								</td>
								<td class="u2">
								<div class="ping1"><input type=text name=qq value="">		</div>						</td>
							    <td class="u1">Blog：</td>
							    <td class="u2"><div class="ping1"><input type=text name=blog value="">		</div>	</td>
							</tr>
							
							<tr>
								<td
									class="u1">
									工作单位：								</td>
								<td class="u2">
								<div class="ping1">
									<input type="text" name=work_name value="">	
								</div>							</td>							    
							    
							    		<input type="hidden" value="" name="work_depart">							    							
							    
							</tr>
							
							<tr>
								<td
									class="u1">
									职位：								</td>
								<td class="u2">
								<div class="ping1"><input type=text name=job value="">	</div>							</td>
							    <td class="u1">教育程度：</td>
							    <td class="u2"><div class="ping1"><select name=educate_degree_code>
										<%
												if (degreeList != null && degreeList.size() > 0) {
												for (int i = 0; i < degreeList.size(); i++) {
													HashMap map = (HashMap) degreeList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>										</option>
										<%
											}
											}
										%>
									</select>	</div></td>
							</tr>
							<tr>
								<td
									class="u1">
									婚姻：								</td>
								<td class="u2">
									<div class="ping1">
									<select name=marriage>
										<option value="0">未婚</option>
										<option value="1">已婚</option>
									</select>	
									</div>								</td>
							    <td class="u1">社会保障号：</td>
							    <td class="u2">
							    	<div class="ping1">
						        <input type=text name=community_id value="">		
						        </div>						      </td>
							</tr>							
							<tr>
								<td colspan=4 class="u3">
									<input class="tjan" name="submit1" type="submit" value=""  onclick="return addUserInfoCheck_Value()">&nbsp;&nbsp;								</td>
							</tr>
						</table>
				
		</form>
	</body>
</html>
<script type="text/javascript">

var fectureArray=new Array();
	 fectureArray=['请选择..'];
function setAreas(city_id){
	AreaInfo.getAreaByParent(city_id,function(data){
	 DWRUtil.removeAllOptions("city");
     DWRUtil.addOptions("city",fectureArray);
	 DWRUtil.addOptions("city",data);
	});
}
function setCitys(prov){
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
	 DWRUtil.removeAllOptions("eparchy_code");
	 DWRUtil.addOptions("eparchy_code",fectureArray);
	 DWRUtil.addOptions("eparchy_code",data);
	 DWRUtil.removeAllOptions("city");
	 DWRUtil.addOptions("city",fectureArray);
	});
}

</script>



