<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page"/>
<%@ page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>电子商务平台</title>
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
<style type="text/css" media="screen">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
		 
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script language="javascript">

		
function checkInfo()
{	
	if (document.getElementById("typeInfo").style.display != "none" ){
		if(document.getElementById("up_class_id").value=="" || document.getElementById("up_class_id").value==null){
			alert("请选择上级分类！");
			return false;
		}
	}
	if(document.getElementById("sort2").style.display=="block" && document.getElementById("sort1").style.display=="none"){
		if(document.getElementById("sort2").value == "" || document.getElementById("sort2").value == null)
		{
			alert("请选择子栏目");
			return false;
		}
	}
	if(document.classForm.class_name.value.replace(/\s*/g,"") == "" )
	{
		alert("栏目名称不能为空！");
		document.classForm.class_name.focus();
		return false;
	}
	
	if(document.getElementById("classlevel").value=="0"){
	    document.classForm.class_level.value="1";
		document.classForm.up_class_id.value="000000000000000";
	}
	
	   
	return true;
}

 

function selectLevel(leveles)
{
   if(leveles=="1")
	 {
	   	document.getElementById("typeInfo").style.display ="block";
	   	setOneClass("1");
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
		var type="1";
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
	    	document.getElementById("nextElement").style.display="none"; 
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
		var type="1";
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
	String class_id=bean.GenTradeId();
%>
 
<form  name="classForm" method="post" action="/doTradeReg.do" target="_self">
	<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="y05B999cs51OE76" />
		</jsp:include>	
     <table width="800" border="0" cellpadding="1" cellspacing="1" align="center"  bgcolor="#DEEDFD">
        <tr>
		  <td class="u1">栏目类型</td>
		  <td class="u2">　
			<select name="classlevel" id="classlevel" style="width:100px" onChange="selectLevel(this.value)">
                  <option value="0">主栏目</option>
                  <option value="1">子栏目</option>
                </select>  
		  </td>
	 </tr>
	 <tr id="typeInfo" style="display:none">
		  <td height="30" class="u1" valign="top">请选择上级分类</td>
              <td class="u2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
					<td>
						<select name="sort1" size="10" style="width: 130px"
							onChange="setSecondClass(this.value);"
							onclick="setTypeName(this.value,'2')">
							<option selected value="0">
								请选择...
							</option>
						</select>
					</td>
					<td>
						<select name="sort2" size="10" style="width: 130px; display: none"
							onChange="setTherdClass(this.value);"
							onclick="setTypeName(this.value,'3')">
							<option value="0">
								请选择...
							</option>
						</select>
					</td>
					<td>
						<select name="sort3" size="10" style="width: 130px; display: none"
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
		  <td class="u1">栏目名称</td>
		  <td class="u2">
		  <div class="ping1">　
				  <input name="class_name" type="text" maxlength="100"></div>
		  </td>
		</tr>
		
		<tr>
		  <td class="u1">显示方式</td>
		  <td class="u2">　
			  <!-- <input name="class_name" type="text" maxlength="100" -->
			  <select name="rsrv_str1" id="rsrv_str1" style="width:50px">
                  <option value="1">&nbsp;1</option>
                  <option value="2">&nbsp;2</option>
                  <option value="3">&nbsp;3</option>
                  <option value="4">&nbsp;4</option>
                  <option value="5">&nbsp;5</option>
                  <option value="6">&nbsp;6</option>
                  <option value="7">&nbsp;7</option>
                  <option value="8">&nbsp;8</option>
                  <option value="9">&nbsp;9</option>
        	  </select>
		  </td>
		</tr>
		<tr>
			<td class="u1" valign="top">栏目说明</td>
			<td class="u2">　
	                <textarea name="class_desc" cols="50" rows="6"></textarea>
	       
			 <input name="class_id" type="hidden" value="<%=class_id%>">
			 <input name="enable_tag" type="hidden" value="0">
			 <input name="class_type" type="hidden" value="1">
			 <input type="hidden" name="up_class_id" id="up_class_id"  value="">
			 <input type="hidden" name="class_level" id="Class_Level"  value="">
			 <input name="trade_type_code" type="hidden" value="0711">
			 </td>
		</tr>
     	<tr>
			<td height="30" colspan="2" class="u3">
				<input class="tjan" type="submit" value="" onClick=" return checkInfo()">
			</td>
		</tr>
		</table>
	</form>
  </body>
</html>




