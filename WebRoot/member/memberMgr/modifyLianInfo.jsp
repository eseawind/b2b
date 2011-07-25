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
<%@ page import="com.saas.biz.userMgr.UserDetailInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String user_id = "",cust_id="",view="",enable="",modify="",cust_name="";
	String user_name = "",  passwd = "", passwd_answer = "", pspt_id = "", pspt_end_date = date, pspt_addr = "", birthday = date, local_native_code = "", post_addr = "",
	 		phone = "", home_addr = "", community_id = "", job = "", email = "",qq="",fax="",blog="",post_code="",depart_code="",depart_name="",city_code="",city_code1="";
	String marriage="",marriage1="",web_login_tag="",web_login_tag1="";
	String province="",eparchy_code="",city="",province1="",eparchy_code1="",city1="";
	String pspt_type_code="",pspt_type_code1="",folk_code="",folk_code1="",educate_degree_code="",educate_degree_code1="",sex="",sex1="";
	ParamethodMgr paramCom = new ParamethodMgr();
	AreaInfo arae=new AreaInfo(); 
	if(request.getParameter("cust_id")!=null)
	{
	  cust_id=request.getParameter("cust_id");
	   
	}
	if(request.getParameter("user_id")!=null)
	{
	  user_id=request.getParameter("user_id");
	}
	if(request.getParameter("view")!=null)
	{
	  view=request.getParameter("view");
	  enable=" readonly";
	}
	

    ArrayList custInfoList = new UserDetailInfo().getUserDetailByUserId(user_id,cust_id);
	if( custInfoList != null && custInfoList.size() > 0 )
	{
		HashMap custInfoMap = (HashMap)custInfoList.get(0);
		if(custInfoMap.get("pspt_type_code")!=null)
		{
			pspt_type_code = custInfoMap.get("pspt_type_code").toString();
			pspt_type_code1 = paramCom.getItemsBySelected("37",pspt_type_code);
		}
		if (custInfoMap.get("community_id") != null) 
		{
			community_id = custInfoMap.get("community_id").toString();
		}
		if (custInfoMap.get("cust_name") != null) 
		{
			cust_name = custInfoMap.get("cust_name").toString();
		}
		if(custInfoMap.get("folk_code")!=null)
		{
			folk_code = custInfoMap.get("folk_code").toString();
			folk_code1 = paramCom.getItemsBySelected("23",folk_code);
		}	
		if(custInfoMap.get("marriage")!=null)
		{
			marriage = custInfoMap.get("marriage").toString();	
			marriage1 = paramCom.getItemsBySelected("36",marriage);									
		}
		if(custInfoMap.get("educate_degree_code")!=null)
		{
			educate_degree_code = custInfoMap.get("educate_degree_code").toString();
			educate_degree_code1 = paramCom.getItemsBySelected("34",educate_degree_code);
		}
		if(custInfoMap.get("sex")!=null)
		{
			sex = custInfoMap.get("sex").toString();	
			sex1 = paramCom.getItemsBySelected("35",sex);									
		}
		  
	 }
		
	if (request.getParameter("user_id") != null) 
	{
		user_id = request.getParameter("user_id");
		UserInfo userOjb = new UserInfo();
		ArrayList userList = userOjb.getUserInfoByUserId(user_id);
		 
		if (userList != null && userList.size() > 0) 
		{
			HashMap map = (HashMap) userList.get(0);
			if (map.get("rsrv_str4") != null) 
			{
		        province = map.get("rsrv_str4").toString();
		        province1 = arae.getItemsBySelected("5J2mc0X0G85BH",province );
			}
			if (map.get("eparchy_code") != null) 
			{
		        eparchy_code = map.get("eparchy_code").toString();
		        eparchy_code1 = arae.getItemsBySelected( province,eparchy_code );
			}
			if (map.get("city_code") != null) 
			{
		        city_code = map.get("city_code").toString();
		        city_code1 = arae.getItemsBySelected( eparchy_code,city_code );
			}
			if (map.get("user_name") != null) 
			{
		        user_name = map.get("user_name").toString();
			}
			if (map.get("educate_degree_code") != null) 
			{
		        educate_degree_code = map.get("educate_degree_code").toString();
			}
			if (map.get("web_login_tag") != null) 
			{
		        web_login_tag = map.get("web_login_tag").toString();
				web_login_tag1 = paramCom.getItemsBySelected("10",web_login_tag);
			}
			if (map.get("passwd") != null) 
			{
		        passwd = map.get("passwd").toString();
			}
			if (map.get("passwd_answer") != null) 
			{
				passwd_answer = map.get("passwd_answer").toString();
			}
			if (map.get("pspt_id") != null) 
			{
				pspt_id = map.get("pspt_id").toString();
			}
			if (map.get("pspt_end_date") != null) 
			{
				pspt_end_date = map.get("pspt_end_date").toString();
				if (pspt_end_date.length() > 10) 
				{
					pspt_end_date = pspt_end_date.substring(0, 10);
				}
			}
			if (map.get("pspt_addr") != null) 
			{
				pspt_addr = map.get("pspt_addr").toString();
			}
			if (map.get("birthday") != null) 
			{
				birthday = map.get("birthday").toString();
				if (birthday.length() > 10) 
				{
					birthday = birthday.substring(0, 10);
				}
			}
			if (map.get("local_native_code") != null) 
			{
				local_native_code = map.get("local_native_code").toString();
			}
			if (map.get("post_addr") != null) 
			{
				post_addr = map.get("post_addr").toString();
			}
			if (map.get("phone") != null) 
			{
				phone = map.get("phone").toString();
			}
		
			if (map.get("home_addr") != null) 
			{
				home_addr = map.get("home_addr").toString();
			}
			if (map.get("job") != null) 
			{
				job = map.get("job").toString();
			}
			if (map.get("email") != null) 
			{
				email = map.get("email").toString();
			}
			if (map.get("qq") != null) 
			{
				qq = map.get("qq").toString();
			}
			if (map.get("fax") != null) 
			{
				fax = map.get("fax").toString();
			}
			if (map.get("blog") != null) 
			{
				blog = map.get("blog").toString();
			}
			if (map.get("post_code") != null) 
			{
				post_code = map.get("post_code").toString();
			}
			if (map.get("depart_code") != null) 
			{
				depart_code = map.get("depart_code").toString();
			}
		}
	}
			
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
		 
		 
		 //部门修改list
		 String up_orga_id="000000000000000";
		if(request.getParameter("org_id")!=null){
			up_orga_id = request.getParameter("org_id");
		}
		ArrayList orgDownList=new OrganizeInfo().getOrganizeByUpIdList(cust_id,up_orga_id);
		 
		 
%>
 <html>
	<head>
		<title>修改员工</title>
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
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		
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
			<script type="text/javascript" src="/js/memberMgr.js"></script>
			<script language="JavaScript">


function setCitys(prov){
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
	 DWRUtil.removeAllOptions("city_code");
	 DWRUtil.addOptions("city_code",data);
	});
}
function shwoOrHidden(){
if(document.getElementById("sh").style.display=="block"){
    document.getElementById("sh").style.display="none";
  }else{
    document.getElementById("sh").style.display="block";
  }
}
 var tree = new Ext.tree.TreePanel({   
    	el:"tree-div",   
        autoScroll:false,
        animate:true,
        width:'100%',
        height:'300px',
        enableDD:true,
        containerScroll: true, 
        loader: new Ext.tree.TreeLoader({
            dataUrl:'/tree.html'            
        })
    });
 function createTree(){
    var cust=document.getElementById("cust_id").value;
    var org_idx='000000000000000';
    var root_name=document.getElementById("cust_name").value;
	tree.on("click",function(node,event){
	  document.getElementById("org_depart_code").value=node.id;
	  document.getElementById("depart_name").value=node.text;
	});
    var root = new Ext.tree.AsyncTreeNode({
        text: root_name,
        draggable:false,
        iconCls:'root-Img',
        id:org_idx
    });
    tree.setRootNode(root);
   	var id=root.id;
   	OrganizeInfo.getOrganizeByUpIdMap(cust,id,function(data){
	for(var j=0;j<data.length;j++){ 
             var obj=data[j];
              callBackFunction(obj,tree.getNodeById(id));
     }
   	});
   	tree.render();
   	root.expand();
   	tree.expandAll();
   }
   
   //三级节点
   function callBackFunction(obj,node){
      var cust=document.getElementById("cust_id").value;
			for(var org_id in obj){ 
		         var org_name=obj[org_id];
		         if(org_id!='extend'){
		         var nodex = new Ext.tree.TreeNode({text:org_name,draggable:false,iconCls:'Tree-Img',id:org_id});
		         node.appendChild(nodex);
		         OrganizeInfo.getOrganizeByUpIdMap(cust,org_id,function(data){
			      for(var i=0;i<data.length;i++){ 
					var objx=data[i];
					for(var orgid in objx){ 
				         var orgname=objx[orgid];
				         if(orgid!='extend'){
				         var tree_nodex= new Ext.tree.TreeNode({text:orgname,draggable:false,iconCls:'Tree-Img',id:orgid});
				         nodex.appendChild(tree_nodex);
				         OrganizeInfo.getOrganizeByUpIdMap(cust,orgid,function(data){
				          for(var i=0;i<data.length;i++){ 
                            var obj=data[i];
                             callBackFunction(obj,tree_nodex);
                          }
				         });
				         }
			         }
			      }
			   });
			   }
		     }
   }
   
   function setDepartCode(val){
   		document.getElementById('org_depart_code').value = document.getElementById('org_value'+val).value;
   		document.getElementById('work_depart').value = document.getElementById('org_value'+val).value;
   		document.getElementById('depart_name').value = document.getElementById('org_name'+val).value;
   }
   
   
</script>

</head>
	<body onload="createTree()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="modifyUserIndex.jsp">资料管理</a>
				</td>
			</tr>
		</table>
			<table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=0 cellspacing=1 bgcolor="#dddddd" align="center">
							<input type=hidden name=trade_type_code value=0110>
							<input name="user_id" type=hidden value=<%=user_id%>>
							<input name="cust_id" id="cust_id" type=hidden value=<%=cust_id%>>
							<tr>
 								<td colspan="4" background="/admin/images/newsbg.gif" height="28" align="left">&nbsp;&nbsp;
								<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>基本信息</b></font></td>
							</tr>							 
							<tr>
								<td width="18%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
								真实姓名：</td>
								<td width="32%" height="20" style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left;padding:3px 5px;height:25px">
									<%=cust_name%>
							  </td>
							 
								<td width="18%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
								登陆账号：</td>
								<td width="32%" style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; text-align:left; width:75%;">
									<%=user_name%>
							  </td>
							
							</tr>
							
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									点击修改部门：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:5px; display:inline" align=left>
								   <div id="sh">
								<table>   	
						<%
							
							if(orgDownList!=null && orgDownList.size()>0){
								for(int i=0;i<orgDownList.size();i++){
									String org_id="",org_name="",org_desc="",in_date="";
									HashMap orgMap = (HashMap)orgDownList.get(i);
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
									ArrayList downlist=new OrganizeInfo().getOrganizeByUpIdList(cust_id,org_id);
						%>
							<tr class="u2">
									<td align="left">
										<input type="radio" name="org_value" id="org_value<%=i%>" value="<%=org_id%>" onclick="setDepartCode('<%=i%>')">
										<input type="hidden" name="org_name<%=i%>" id="org_name<%=i%>" value="<%=org_name%>">
											<%
												if(downlist!=null && downlist.size()>0){
											%>
												<a href="modifyLianInfo.jsp?org_id=<%=org_id%>&cust_id=<%=cust_id%>&user_id=<%=user_id%>" title="点击进入子部门！"><%=org_name%></a>
											<%		
												}else{
											%>
												<%=org_name%>
											<%			
												}
											%>
											
									</td>
							</tr>
						<%
								}
							}
						%>
						<%
							if(!up_orga_id.equals("000000000000000")){
						%>
						<tr>
								<td>
									<a href="modifyLianInfo.jsp?org_id=000000000000000&cust_id=<%=cust_id%>&user_id=<%=user_id%>">返回</a>
								</td>
						</tr>
						<%
							}
						%>
						</table>
								    
								   </div>
									<input type="hidden" name="org_depart_code" id="org_depart_code" size="30"  value="<%=depart_code%>"> 
									<input type="hidden" name="work_depart" id="work_depart" size="30"  value="<%=depart_code%>"> 
									<input name="depart_name" type="text" id="depart_name" value="<%=depart_name%>" size="30" <%=enable%>>
									
								</td>
						
								 
			
							</tr>
							
							<tr>
								<td align="right" bgcolor="#f5f5f5" style="font-weight:bolder;"> 省份： </td>
              					 <td align="left" bgcolor="#FFFFFF"  colspan="3">
            						<select name="province" id="province" onclick="setCitys(this.value)">
         								<option value="">请选择..</option>
										<%=province1%>
	    							</select>
  									<font style="font-weight:bolder;">归属城市：</font>
									<select name="eparchy_code" id="eparchy_code" style="display:inline"  onclick="setAreas(this.value)">
										<option value="">请选择..</option>
										<%=eparchy_code1%>
									</select>
								 	<font style="font-weight:bolder;">区/县：</font>
									<select name="city_code" id="city_code" style="display:inline">
										<option value="">请选择..</option>
										<%=city_code1%>
									</select>
        					</td>
							</tr>
							 <tr>
 								<td colspan="4" background="/admin/images/newsbg.gif" height="28" align="left">&nbsp;&nbsp;
 								<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>详细信息</b></font>
								</td>
							</tr>
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									证件类别：								
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<select name=pspt_type_code>	
								 		<%=pspt_type_code1%> 
									</select>
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									证件号码：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=pspt_id type=text value="<%=pspt_id%>" size="30"  <%=enable%>>
								</td>
					
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									证件有效期：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name="pspt_end_date" type="text" id="pspt_end_date" onfocus="setday(this);" value="<%=pspt_end_date%>">(四位年—两位月—两位日)
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									证件地址：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=pspt_addr type=text value=<%=pspt_addr%><%=enable%>>
								</td>
							</tr>
	
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									性别：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<select name=sex>
									 <%=sex1%>
									</select>
								</td>			
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									生日：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name="birthday" type="text" id="birthday"
										onfocus="setday(this);" value="<%=birthday%>" size="20" maxlength="10">
									(四位年—两位月—两位日)
								</td>			
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									籍贯：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type=text name=local_native_code
										value="<%=local_native_code%>"  <%=enable%>>
								</td>
					
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									民族：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<select name=folk_code>
										<%=folk_code1%>
									</select>
								</td>
							</tr>
						
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									联系电话：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name="phone" id="phone" value="<%=phone%>"  <%=enable%> size="30" maxlength="15">
									<input type="hidden" name="group_contact_phone" id="group_contact_phone" value="">
								</td>
										
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									传真：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=fax_nbr value="<%=fax%>"  <%=enable%> size="30" maxlength="15">
								</td>
							</tr>
					 		<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									通信地址：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=post_addr value="<%=post_addr%>"  <%=enable%> size="30" maxlength="40">
								</td>
								
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									邮政编码：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=post_code value="<%=post_code%>"  <%=enable%> size="10" maxlength="6">
								</td>
							</tr>
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									家庭地址：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=home_addr type=text value="<%=home_addr%>" size="30"  <%=enable%>>
								</td>
						
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									电子邮件：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name=email type=text value="<%=email%>" size="30"  <%=enable%>>
									<input name="cust_name" id="cust_name" type="hidden" value="<%=cust_name%>">
								</td>
					
							</tr>
							
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									QQ：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type=text name=qq value="<%=qq%>" <%=enable%> size="12" maxlength="12">
								</td>
							
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									Blog：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=blog type=text value="<%=blog%>" size="30" <%=enable%>>
								</td>
					
							</tr>
							
							
							<tr style="display: none">
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									工作单位：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input type="hidden" name=work_name value="">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									工作部门：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<select name=work_depart>
									</select>
								</td>
						 	</tr>
	
						
							
							<tr>
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									职位：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<input name=job type=text value="<%=job%>" size="30">
									<input type=hidden name="up_org_id" id="up_org_id" value="<%=up_org_id%>">
								</td>
								
								<td
									align=right
									style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									教育程度：								</td>
								<td
									style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;"
									align=left>
									<select name=educate_degree_code>
										<%=educate_degree_code1%>
									</select>
								</td>
							</tr>
							
							
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									婚姻：								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<select name=marriage>
										<%=marriage1%>
									</select>
								</td>
							
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									社会保障号：</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input type=text name=community_id value="<%=community_id%>">
								</td>
					
							</tr>
							<input type="hidden" name="city_code" id="city_code" value="">
							<input type="hidden" name="passwd" id="passwd" value="<%=passwd%>">
							<input type="hidden" name="passwd_ques" id="passwd_ques" value="">
								<input type="hidden" name="cust_aim" id="passwd_ques" value="">
							<input type="hidden" name="passwd_answer" id="passwd_answer" value="<%=passwd_answer%>">
							<tr>
								<td height="40" colspan="6" bgcolor="#FFFFFF">
									<div align="center">
										<input class="tjan" type="submit" name="Submit" value="" onclick="return check()">
									</div>
								</td>
							</tr>
					  </table>
					</td>
				</tr>
				<tr>
					<td height="46">
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



