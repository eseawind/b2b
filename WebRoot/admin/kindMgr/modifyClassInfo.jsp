<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.base.config.ProjectConfig"%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
		
		<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
		<script src="/js/modifyType.js" language="jscript" type="text/jscript"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript">
		function setTypeName(classId)
		{
			var class_id=classId;
			document.getElementById("class_id").value="";
			if(class_id!=null && class_id.length>10)
			{
			    document.classForm.class_id.value=class_id;
				Productclass.getclassByClassId(class_id,setClassNameAndDesc);
			}
			else
		    {
		    	document.classForm.class_name.value="";
			    document.classForm.class_desc.value="";
		    }
		}
		
		function setClassNameAndDesc(classInfo){
			document.classForm.class_name.value=classInfo['class_name'];
			document.classForm.class_desc.value=classInfo['class_desc'];
		}
		
		function checkInfo()
		{
			
			if(document.classForm.class_type.value  == "0" )
			{
				alert("请选择分类类型！");
				document.classForm.class_type.focus;
				return false;
			} 
			if(document.classForm.class_name.value.replace(/\s*/g,"") == "" )
			{
				alert("请选择分类名称！");
				document.classForm.class_name.focus;
				return false;
			}
			document.getElementById("trade_type_code").value="0811";
			return true;
		}
		
		function deleteInfo()
		{
			 if(document.classForm.class_type.value  == "0" )
			{
				alert("请选择分类类型！");
				document.classForm.class_type.focus;
				return false;
			} 
			if(document.classForm.class_name.value.replace(/\s*/g,"") == "" )
			{
				alert("请选择分类名称！");
				document.classForm.class_name.focus;
				return false;
			} 
				
			var idx=document.getElementById("class_id").value.replace(/\s*/g,"");
		  if(idx!="")
		  {
		  	 Productclass.checkChildren(idx,checkChildren);
		  }
		  return false;
		}
		function checkChildren(data)
		{
		   var hasChildren=data;
		   if(hasChildren=="0")
		   {
		    document.getElementById("trade_type_code").value="0812";
		    document.classForm.submit();
		   }
		   else
		   {
		    alert("不能删除该分类！\n如果确定要删除该分类，请先删除其子分类！");
		     return false;
		   }
		  
		}
	//设置一级分类
	function setOneClass(val)
	{
		var type=val;
		if(type!="0")
		{
		 document.getElementById("typeInfo").style.display="block";
		 Productclass.getProductClassByUpId("000000000000000",type,setSort1);
		}
		else
		{
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
		var type=document.getElementById("class_type").value;
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
		var type=document.getElementById("class_type").value;
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
	
   //动态生成下级分类信息
	function cretateSelect(index,value)
	{
	 document.getElementById("nextElement").style.display="block";
	 var type=document.getElementById("class_type").value;
	 var divId=parseInt(index)+parseInt(1);
	 document.getElementById("index_s").value=index;
	 document.getElementById(index).innerHTML="<select name=sort"+index+" id=sort"+index+" onchange=cretateSelect("+divId+",this.value) size=3 onclick=setTypeName(this.value) style=width:130px></select><div id="+divId+"></div>";
	 DWRUtil.removeAllOptions("sort"+index);
	 Productclass.getProductClassByUpId(value,type,setNewSelect);
  }
    //回调函数
     function setNewSelect(map_data)
     {
        var id=document.getElementById("index_s").value;
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
		
		<form name="classForm" method="post" action="/doTradeReg.do" target="_self">
			<table width="100%" border="0" cellpadding="1" cellspacing="1"
				align="center" bgcolor="#FCB0B0">
				<tr>
					<td class="u1">
						修改分类类型
					</td>
					<td class="u2">
						<div class="ping1">
						<select name="class_type" id="class_type" style="width:100px" onChange="setOneClass(this.value)">
							<option value="0">
								请选择分类...
							</option>
							<option value="2">
								产品分类
							</option>
							<option value="3">
								企业分类
							</option>
							<option value="4">
								求购分类
							</option>
							<option value="5">
								供应分类
							</option>
							<option value="11">
								图书分类
							</option>
						</select>
					</div>
					</td>
				</tr>
				<tr id="typeInfo" style="display:none">
					<td height="30" class="u1" valign="top">
						分类名称
					</td>
					<td class="u2">
						<div class="ping1">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								
                	<script language="javascript">
		          		function down(val){
		          				setSecondClass(val);
		          				setTypeName(val);
		          			}	
          			</script>
									<td>
									<select name="sort1" id="sort1" size="10" style="width: 130px"
										 onChange="setSecondClass(this.value);" onclick="setTypeName(this.value)" onkeydown="down(this.value);" onkeyup="down(this.value);">
										<option selected value="0">
											请选择...
										</option>
									</select>
								</td>
								<td>
									<select name="sort2" id="sort2"  size="10" style="width: 130px; display: none" onChange="setTherdClass(this.value );" onclick="setTypeName(this.value)">
										<option value="0">
											请选择...
										</option>
									</select>
								</td>
								<td>
									<select name="sort3" size="10" id="sort3"  style="width: 130px; display: none" onclick="setTypeName(this.value);" onchange="cretateSelect('4',this.value)" >
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
					</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						修改名称
					</td>
					<td class="u2">
						<div class="ping1">
							<input name="class_name" type="text" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1" valign="top">
						修改说明
					</td>
					<td class="u2">
						<div class="ping1">
						<textarea name="class_desc" cols="50" rows="6"></textarea>
						</div>
					</td>
				</tr>
				<input name= "class_id" id="class_id" type="hidden" value="">
				<input name= "trade_type_code" id="trade_type_code" type="hidden" value="">
				 
				<tr>
					<td class="u3" colspan=2>
						<input class="xgan" name="bnt" type="submit" value=""  onclick="return checkInfo()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="scan" name="bnt" type="submit" value=""  onclick="return deleteInfo()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




