<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.base.config.ProjectConfig"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
  Custinfo custInfo=new Custinfo();
  HttpSession  logsession = request.getSession(); 
  String cust_id="",cust_name="",cust_aim="",company_address="",website="",province="",develope_channel="";
  String enterprise_scope="",reg_money="",enterprise_size_code="",client_status="",local_emp_count="";
  String fax_nbr="",city="",develope_man="",juristic_type_code="",post_code="",group_memo="",scope="",juristic="";
  String email="",china_emp_count="";
  String user_id="";
  if (logsession.getAttribute("SESSION_CUST_ID") != null)
  {
      cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
  }	 
  if (logsession.getAttribute("SESSION_USER_ID") != null)
  {
      user_id = logsession.getAttribute("SESSION_USER_ID").toString();
  }
  String user_name = "";

  
   ArrayList list=custInfo.getCustInfo(cust_id);
   if(list!=null&&list.size()>0)
   {
   	  HashMap map = (HashMap)list.get(0);
   	  //
   	  if(map.get("juristic")!=null)
   	  juristic=map.get("juristic").toString();
   	  if(map.get("email")!=null)
   	  email=map.get("email").toString();
   	  if(map.get("china_emp_count")!=null)
   	  china_emp_count=map.get("china_emp_count").toString();
   
   	  //
   	  if(map.get("cust_name")!=null)
   	  cust_name=map.get("cust_name").toString();
   	  if(map.get("cust_aim")!=null)
   	  cust_aim=map.get("cust_aim").toString();
   	  if(map.get("company_address")!=null)
   	  company_address=map.get("company_address").toString();
   	  if(map.get("website")!=null)
   	  website=map.get("website").toString();
   	  //
   	  if(map.get("province")!=null)
   	  province=map.get("province").toString();
   	  if(map.get("develope_channel")!=null)
   	  develope_channel=map.get("develope_channel").toString();
   	  if(map.get("enterprise_scope")!=null)
   	  enterprise_scope=map.get("enterprise_scope").toString();
   	  if(map.get("reg_money")!=null)
   	  reg_money=map.get("reg_money").toString();
   	  //
   	  if(map.get("enterprise_size_code")!=null)
   	  enterprise_size_code=map.get("enterprise_size_code").toString();
   	  if(map.get("client_status")!=null)
   	  client_status=map.get("client_status").toString();
   	  if(map.get("local_emp_count")!=null)
   	  local_emp_count=map.get("local_emp_count").toString();
   	  if(map.get("fax_nbr")!=null)
   	  fax_nbr=map.get("fax_nbr").toString();
   	  //
   	  if(map.get("city")!=null)
   	  city=map.get("city").toString();
   	  if(map.get("develope_man")!=null)
   	  develope_man=map.get("develope_man").toString();
   	  if(map.get("juristic_type_code")!=null)
   	  juristic_type_code=map.get("juristic_type_code").toString();
   	  if(map.get("post_code")!=null)
   	  post_code=map.get("post_code").toString();
   	  //
   	  if(map.get("group_memo")!=null)
   	  group_memo=map.get("group_memo").toString();
   	  if(map.get("scope")!=null)
   	    scope=map.get("scope").toString();
   	
   }
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link rel="stylesheet" href="images/style.css" type="text/css" />
<style type="text/css">
	.c4 {
		CURSOR: hand;
		background:url(/admin/images/di_03.jpg) no-repeat;COLOR:#0066CC;font-size: 14px; font-weight:bold; line-height:28px; text-indent:1.8em;
	}
	.c3 {CURSOR: hand;
		background:url(/admin/images/di_04.jpg) no-repeat; COLOR: #0066CC;font-size: 14px; line-height:28px; text-indent:1.8em;}
	
</style>
<script type='text/javascript' src='/dwr/interface/AreaInfo.js'></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>
<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script language="javascript">
	var fectureArray=new Array();
	 fectureArray=['请选择'];
	function setProvince()
	{	//alert( "setProvince"　);
		AreaInfo.getAreaByParent('5J2mc0X0G85BH',function(data){
		DWRUtil.removeAllOptions("province");
		DWRUtil.addOptions("province",fectureArray);
		DWRUtil.addOptions("province",data);
	                          })
	}
	function setCitys(prov)
	{
	     var provence=prov;
		 AreaInfo.getAreaByParent(provence,function(data){
	     DWRUtil.removeAllOptions("eparchy_code");
		 DWRUtil.addOptions("eparchy_code",fectureArray);
		 DWRUtil.addOptions("eparchy_code",data);
		});
	}
	function setArea(prov)
	{
	     var city=prov;
		 AreaInfo.getAreaByParent(city,function(data){
		 DWRUtil.removeAllOptions("city");
		 DWRUtil.addOptions("city",fectureArray);
		 DWRUtil.addOptions("city",data);
		});
	}
	function checkInfo()
	{
		if (document.getElementById("typeInfo").style.display != "none" )
		{
			if(document.getElementById("up_class_id").value=="" || document.getElementById("up_class_id").value==null)
			{
				alert("请选择上级分类！");
				return false;
			}
		}
	/*if(document.parentForm.class_desc.value=="" || document.parentForm.class_desc==null)
	{
		alert("分类说明不能为空！");
		document.parentForm.class_desc.focus();
		return false;
	}*/
		if(document.getElementById("classlevel").value=="0")
		{
			document.parentForm.class_level.value="1";
			document.parentForm.up_class_id.value="000000000000000";
		}
		return true;
	}
	
	function selectLevel(leveles)
	{
		 if(leveles=="3")
		 {
		   document.getElementById("typeInfo").style.display ="block";
		   setOneClass("3");
		   document.all("class_id1").style.display="none";
		 }
		 else
		{
		  document.getElementById("typeInfo").style.display ="none";
		} 	
	}
//设置一级分类
	function setOneClass(val)
	{
		var type=val;
		if( type != "0" )
		{
		 	document.getElementById("typeInfo").style.display="block";
		 	Productclass.getProductClassByUpId("000000000000000",type,setSort1);
		 	
		}
		else
		{
		 	document.getElementById("typeInfo").style.display="none";
		 	document.parentForm.class_name.value="";
		 	document.parentForm.class_desc.value="";
		}
	}
	function setSort1(map_data)
	{
		DWRUtil.removeAllOptions("sort1");
		DWRUtil.addOptions("sort1",map_data);
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
	    }
	    else
	    	{
	    		document.getElementById("sort2").style.display="block";
		    // document.getElementById("calling_type_code").value=document.getElementById("sort2").value;
	    	}
	}
	//设置三级分类
	function setTherdClass(val)
	{
		var up_class_id=val;
		var type="3";
		Productclass.getProductClassByUpId(up_class_id,type,setSort3);
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
		     		//document.getElementById("calling_type_code").value=document.getElementById("sort3").value;
		     	}
		}
	}
	function setTypeName(classId,leave)
	{
		document.parentForm.class_level.value=leave;
		document.parentForm.up_class_id.value=classId;
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
<script language="JavaScript">
	function secBoard(n)
		{
			for(i=0;i<2;i++) {
				if (i==n) {
					document.all('d' + n).className="c4";
				} else {
				document.all('d' + i).className="c3";}
			}
			
			for(i=0;i<2;i++) {	
				 document.all('t' + i).style.display="none";
				}
		 document.all('t' + n).style.display="";

	 }		
	function setAreaValue(val){
			document.getElementById("class_id").value=val;
		}
			function Check_Value()
			{
				var vl=document.getElementById("cust_aim").value;
				var v2=document.getElementById("company_address").value;
				var v3=document.getElementById("website").value;
				var v4=document.getElementById("class_id").value;
				var v5=document.getElementById("calling_type_code").value;
				var v6=document.getElementById("province").value;
				var v7 = document.getElementById("scope").value;
				document.getElementById("group_memo").value = document.getElementById("group_a").value+"|"+document.getElementById("group_b").value;
				var v8 = document.getElementById("group_memo").value;
			if(null==vl||vl==""){
				alert("请输入公司名称！");
				document.getElementById("cust_aim").focus();
				return false;
		  }
		  if(null==v2||v2==""){
				alert("请输入公司地址！");
				document.getElementById("company_address").focus();
				return false;
		  }
		  if(null==v3||v3==""){
				alert("请输入公司网站！");
				document.getElementById("website").focus();
				return false;
		  }
		  if(null==v4||v4==""){
				alert("请选择企业类型！");
				return false;
		  }
		  if(null==v5||v5==""){
				alert("请选择行业类型！");
				return false;
		  }
		  if(v6=="请选择"){
				alert("请选择公司所在地区！");
				return false;
		  }
		  
		  if(v8=="|"){
				alert("请输入主营方向的服务内容！");
				return false;
		  }
		  if(v7=="" || v7=="公司简介不少与20字！"){
				alert("请输入公司简介！");
				document.getElementById("scope").value='';
				document.getElementById("scope").focus();
				return false;
		  }
		  if(v7.length<20){
				alert('公司简介不能少与20字！');
				document.getElementById("scope").onclick='';
				return false;
			}
			
		  document.parentForm.submit();
		  
			}
			window.onload=function()
			{
				//alert( "onload" );
				selectLevel(3);
				setProvince();
			}
</script>
</head>
<body>
<form name=parentForm action=/doTradeReg.do method=post target="_self">
  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#ffffff">
    <tr>
      <td width="20%"></td>
      <td bgcolor="#ffffff" width="80%" align="center"><img src="images/now.gif" border="0" align="absbottom"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr>
      <td align="left" colspan="2" style="height:36px;" valign="top">请认真、仔细地填写以下信息，严肃的商业信息有助于您获得别人的信任，结交潜在的商业伙伴，获取商业机会！&nbsp;打<font color="red">*</font>为必填项 
	   </td>
    </tr>
    <tr>
      <td bgcolor="#ffffff" colspan="2"><div style="overflow:auto; position:relative; overflow-x:hidden; height:550px; width:100%; padding-top:28px;">
	  <div class=c4 id="d0" onclick="javascript:secBoard(0)" style="float:left; width:102px; height:28px; line-height:28px;position:absolute;z-index:1;top:1px;"> 基本资料</div>
	  <!--<div class="c3" id="d1" onclick="javascript:secBoard(1)" style="float:left; width:102px; height:28px; line-height:28px; position:absolute;z-index:1;top:1px; left:103px;"> 详细资料</div>-->
          <table border=0 align=center cellpadding=0 cellspacing=0 width="96%" bgcolor="#ffffff" style="border:1px solid #9BC7F6;">
          	  <tr>
          	<td>
            <table  id="t0" name="t0">
              <tr>
                <td class="u1"> 公司名称 <font color="#ff0000">*</font> </td>
                <td class="u2"><input type="text" name="cust_aim" id="cust_aim" value="<%=cust_aim%>" size="20">
                  </td>
              </tr>
              <tr>
                <td class="u1">公司地址 <font color="#ff0000">*</font></td>
                <td class="u2"><input type="text" name="company_address" value="<%=company_address%>" id="company_address" maxlength="80" size="20">
                  </td>
              </tr>
              <tr>
                <td class="u1">公司网站 <font color="#ff0000">*</font> </td>
                <td class="u2"><input type="text" name="website" id="website" value="<%=website%>" size="20" >
                  </td>
              </tr>
             <input type="hidden" name="email" value="<%=email%>" >
              <tr>
                <td class="u1">企业类型 <font color="#ff0000">*</font></td>
                <td class="u2" align="left">
                  <select name="class_id1" id="class_id1"  onClick="selectLevel(this.value)">
                    <option value="0">请选择分类</option>
                    <!--option value="3">企业分类</option-->
                  </select>									                      	
					<table id="typeInfo" style="display:none">
					  <tr>
						<td>
						  <select name="sort1"  onChange="setSecondClass(this.value);setAreaValue(this.value);"	onclick="setTypeName(this.value,'1')">
							<option selected value="0"> 请选择... </option>
						  </select>
						</td>
						<td>
						  <select name="sort2"  style="display: none" onChange="setTherdClass(this.value);setAreaValue(this.value);" onclick="setTypeName(this.value,'2')">
							<option value="0"> 请选择... </option>
						  </select>
						</td>
						<td>
						  <select name="sort3" style=" display: none" onclick="setTypeName(this.value,'3');setAreaValue(this.value);" onchange="cretateSelect('4',this.value)">
							<option value="0"> 请选择... </option>
						  </select>
						</td>
						<td>
							<div id="nextElement">
								<div id="4" style="display:inline"></div>
								<input type="hidden" name="index_s" id="index_s" value="4">
							</div>
						 </td>
					  </tr>
					</table>						                 
             </td>
              </tr>
              <tr>
                <td class="u1">行业类型<font color="#ff0000">*</font></td>
                <%
                	 ParamethodMgr para = new ParamethodMgr();
									 String select = para.getParaCode2ByParam_code("calling_type_code");
								%>
                <td class="u2">
                	<select id="calling_type_code" name="calling_type_code">
                    <option value="">选择栏目...</option>
                    <%=select%>
                  </select>
                </td>
              </tr>
              <tr>
                <td class="u1"> 省份<font color="#ff0000">*</font></td>
                <td class="u2"><!--input type="text" name="province"  value="<%=province%>" maxlength="15" class="login_textarea"-->
                  <select class="list_input_box" name="province" id="province" onclick="setCitys(this.value)">
                    <option value="">请选择 </option>
                  </select>
                  
                  市：
                  <select class="list_input_box" name="eparchy_code"  id="eparchy_code" onclick="setArea(this.value)">
                    <option value="">请选择 </option>
                  </select>
                  
                  区：
                  <select class="list_input_box" name="city"  id="city">
                    <option value="">请选择 </option>
                  </select>
                  
                </td>
              </tr>
              <tr>
                <td class="u1" valign="top"> 主营方向<font color="#ff0000">*</font> </td>
                <td class="u2">
                	<input type="radio" name="develope_channel" value="0" checked onclick="showSpan(this.value)">销售 
                	<input type="radio" name="develope_channel" value="1" onclick="showSpan(this.value)">采购
                	<input type="radio" name="develope_channel" value="2" onclick="showSpan(this.value)">两者都有
                	<script language="javascript">
                		function showSpan(val){
                			if(val==0){
                				document.getElementById('xiaoshou').style.display='block';
                				document.getElementById('caigou').style.display='none';
                			}
                			if(val==1){
                				document.getElementById('xiaoshou').style.display='none';
                				document.getElementById('caigou').style.display='block';
                			}
                			if(val==2){
                				document.getElementById('xiaoshou').style.display='block';
                				document.getElementById('caigou').style.display='block';
                			}
                		}
                	</script>
                	<br>
                	<span id="xiaoshou">
                		<font color="red">销售</font>的产品（提供的服务）：<br>
                		<input type="text" name="group_a" id="group_a" size="25" maxlength="25"><br>
                	</span>
                	<span id="caigou" style="display:none;">
                		<font color="red">采购</font>的产品（需要的服务）：<br>
                		<input type="text" name="group_b" id="group_b" size="25" maxlength="25">
                	</span>
                	<input type="hidden" name="group_memo" id="group_memo" value="">
                </td>
              </tr>
              <tr>
                <td class="u1">传 真：</td>
                <td class="u2"><input name="fax_nbr" type="text" value="<%=fax_nbr%>" maxlength="20" size="20" class="login_textarea"  onkeyup="if(isNaN(value))execCommand('undo')">
                </td>
              </tr>
              <tr>
                <td class="u1">邮政编码：</td>
                <td class="u2"><input type="text" name="post_code" value="<%=post_code%>" maxlength="6" size="20" class="login_textarea" onkeyup="if(isNaN(value))execCommand('undo')">
                </td>
              </tr>
              <tr>
                <td class="u1"> 公司简介<font color="#ff0000">*</font></td>
                <td class="u2"><textarea name="scope" cols="50" rows="6" value="<%=scope%>" onclick="this.value=''">公司简介不少与20字！</textarea>
                </td>
              </tr>
              
            </table>
            
            
            
            <table  id="t1" name="t1" >
            	
            	
            	
              <tr style="display:none;">
                <td class="u1"> 发展渠道： </td>
                <td class="u2"><input type="text" name="develope_channel" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1"> 区域特点： </td>
                <td class="u2"><input type="text" name="enterprise_scope" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1"> 注册资金： </td>
                <td class="u2"><input type="text" name="reg_money" value=""  maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1"> 企业规模： </td>
                <td class="u2"><input type="text" name="enterprise_size_code"  value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1"> 集团状态： </td>
                <td class="u2"><input type="text" name="client_status" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>              
              <tr style="display:none;">
                <td class="u1">发展人：</td>
                <td class="u2"><input type="text" name="develope_man" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1">法人类别：</td>
                <td class="u2"><input type="text" name="juristic_type_code" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
              <tr style="display:none;">
                <td class="u1">员工数：</td>
                <td class="u2"><input type="text" name="china_emp_count" value="" maxlength="15" class="login_textarea">
                </td>
              </tr>
             
              
              
            </table>
          </td>
            </tr>
              <tr>
              <td class="u3" colspan="2"><input type="button" style="cursor:hand;" class="button"  value="提 交" name="comit" onClick="return Check_Value()"/>
              </td>
             </tr>             
            <input type="hidden" name="trade_type_code" id="trade_type_code" value="1149">
            <input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
            <input type="hidden" name="local_emp_count" id="local_emp_count" value="">
            <input type="hidden" name="VERIFY_ID" id="VERIFY_ID" value="">
            <input type="hidden" name="root_id" id="root_id" value="0000">
            <input type="hidden" name="class_id" id="class_id" value="">
            <input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
            <input type="hidden" name="calling_area_code" id="calling_area_code" value="">
            <input type="hidden" name="city_code" id="CITY_CODE" value="">
            <input type="hidden" name="enterprise_type_code" id="enterprise_type_code" value="">
            <input type="hidden" name="cust_name" id="CUST_NAME" value="<%=cust_name%>">
            <input type="hidden" name="group_attr" id="group_attr" value="rrrrr">
            <input type="hidden" name="all_emp_count" id="all_emp_count" value="20000">
            <input type="hidden" name="group_contact_phone" id="group_contact_phone" value="124325435">
            <input type="hidden" name="juristic" id="juristic" value="15352">
            <input type="hidden" name="pspt_addr" id="pspt_addr" value="15352">
            <input type="hidden" name="pspt_id" id="pspt_id" value="15352">
            <input type="hidden" name="class_level" id="class_level"  value="">
            <input type="hidden" name="work_name" id="work_name"  value="">
            <input type="hidden" name="folk_code" id="folk_code"  value="">
            <input type="hidden" name="sex" id="sex"  value="">
            <input type="hidden" name="educate_degree_code" id="educate_degree_code"  value="">
            <input type="hidden" name="phone" id="phone"  value="">
            <input type="hidden" name="home_addr" id="home_addr"  value="111">
            <input type="hidden" name="post_addr" id="post_addr"  value="111">
            <input type="hidden" name="job" id="job"  value="111">
            <input type="hidden" name="birthday" id="birthday"  value="2007-01-01">
            <input type="hidden" name="marriage" id="marriage"  value="1">               
            <input type="hidden" name="local_native_code" id="local_native_code"  value="111">
            <input type="hidden" name="qq" id="qq"  value="">
            <input type="hidden" name="blog" id="blog"  value="">
            <input type="hidden" name="community_id" id="community_id"  value="">
            <input type="hidden" name="up_class_id" id="up_class_id"  value="">
            <input type="hidden" name="pspt_type_code" id="pspt_type_code" value="1">
            <input type="hidden" name="user_count" id="user_count" value="15352">
          </table>
        </div></td>
    </tr>
  </table>
</form>
</body>
</html>




