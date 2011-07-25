<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<html>
	<head>
		<title>评测分类</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
		
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
		<script src="/js/product.js" language="jscript" type="text/jscript"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script language="javascript">
function checkInfo()
{
	if (document.getElementById("typeInfo").style.display != "none" ){
		if(document.getElementById("up_class_id").value=="" || document.getElementById("up_class_id").value==null){
			alert("请选择上级分类！");
			return false;
		}
	}
	if(document.classForm.class_name.value.replace(/\s*/g,"") =="" || document.classForm.class_name==null)
	{
		alert("分类名称不能为空！");
		document.classForm.class_name.focus();
		return false;
	}
	/*if(document.classForm.class_desc.value=="" || document.classForm.class_desc==null)
	{
		alert("分类说明不能为空！");
		document.classForm.class_desc.focus();
		return false;
	}*/
	if(document.getElementById("classlevel").value=="0"){
	    document.classForm.class_level.value="1";
		document.classForm.up_class_id.value="000000000000000";
	}
	return true;
}
function selectLevel(leveles)
{
     if(leveles=="10")
	 {
	   document.getElementById("typeInfo").style.display ="block";
	   setOneClass("10");
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
		if(type!="0"){
		 document.getElementById("typeInfo").style.display="block";
		 Productclass.getProductClassByUpId("000000000000000",type,setSort1);
		}else{
		 document.getElementById("typeInfo").style.display="none";
		 document.classForm.class_name.value="";
		 document.classForm.class_desc.value="";
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
		var type="10";
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
	    	}
	}
	//设置三级分类
	function setTherdClass(val)
	{
		var up_class_id=val;
		var type="10";
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
		     	}
		}
	}

	
	function setTypeName(classId,leave)
	{
		document.classForm.class_level.value=leave;
		document.classForm.up_class_id.value=classId;
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
	</head>
	<body>
		<%
			String fbtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String class_id = bean.GenTradeId();
			ParamethodMgr paramCom = new ParamethodMgr();
			ArrayList webList = paramCom.getCompareInfo("CRM", "web_id");
		%>
		<form name="classForm" method="post" action="/doTradeReg.do" target="_self">
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="2J0c4n2mMM080X0342BH" />
			</jsp:include>	
			<table width="800" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				<tr>
					<td class="u1">
						分类类型
					</td>
					<td class="u2"><select name="classlevel" id="classlevel" style="width:100px"
							onChange="selectLevel(this.value)">
							<option value="0">
								主分类
							</option>
							<option value="10">
								子分类
							</option>
						</select>
					</td>
				</tr>
				<tr id="typeInfo" style="display:none">
					<td height="30" class="u1" valign="top">
						请选择父分类
						
					</td>
					<td class="u2"><table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<select name="sort1" id="sort1" size="10" style="width: 130px"
										onChange="setSecondClass(this.value);"
										onclick="setTypeName(this.value,'2')">
										<option selected value="0">
											请选择...
										</option>
									</select>
								</td>
								<td>
									<select name="sort2" id="sort2" size="10"
										style="width: 130px; display: none"
										onChange="setTherdClass(this.value);"
										onclick="setTypeName(this.value,'3')">
										<option value="0">
											请选择...
										</option>
									</select>
								</td>

								<td>
									<select name="sort3" id="sort3" size="10"
										style="width: 130px; display: none"
										onclick="setTypeName(this.value,'4')"
										onchange="cretateSelect('4',this.value)">
										<option value="0">
											请选择...
										</option>
									</select>
								</td>
								<td>
									<div id="nextElement">
										<div id="4" style="width;100px; float:left;display:inline;white-space:nowrap"></div>
										<input type="hidden" name="index_s" id="index_s" value="4">
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="u1">分类名称
					</td>
					<td class="u2">
					<div class="ping1"><input name="class_name" type="text" maxlength="100"></div>
					</td>
				</tr>
				<tr>
					<td class="u1"
						valign="top">
						分类说明
					</td>
					<td class="u2"><textarea name="class_desc" cols="50" rows="6"></textarea>
					</td>
				</tr>
						<input name="class_id" type="hidden" value="<%=class_id%>">
						<input name="enable_tag" type="hidden" value="0">
						<input name="class_type" id="class_type" type="hidden" value="10">
						<input type="hidden" name="up_class_id" id="up_class_id" value="">
						<input type="hidden" name="class_level" id="class_level" value="">
						<input name="trade_type_code" type="hidden" value="0700">
						<input name="rsrv_str" id="rsrv_str" type="hidden" value="">
					
				<tr>
					<td height="30" colspan="2" class="u3">
						<input class="tjan" type="submit" value=""
							onClick=" return checkInfo()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




