<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.base.config.ProjectConfig"%>

<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<%
	String class_id1="",class_type="";
	String url = request.getHeader("referer");
  if (request.getParameter("class_id") != null)
  {
      class_id1 = request.getParameter("class_id");
  }
  if (request.getParameter("class_type") != null)
  {
      class_type = request.getParameter("class_type");
  }
  String class_name="";
  Productclass pclass = new Productclass();
  class_name = pclass.getClassNameById(class_id1);
  String fname = "";
  if(class_type.equals("2")){
  	fname = "产品分类";
  }
  if(class_type.equals("3")){
  	fname = "企业分类";
  }
  if(class_type.equals("4")){
  	fname = "求购分类";
  }
  if(class_type.equals("5")){
  	fname = "供应分类";
  }
  if(class_type.equals("11")){
  	fname = "图书分类";
  }
  String class_id="",className="",select="";
  Map<String, String> classMap = new HashMap<String, String>();
  classMap = pclass.getProductClassByUpId("000000000000000",class_type);
  Iterator it=classMap.entrySet().iterator();   
  while(it.hasNext())   
  {   
  Map.Entry entry = (Map.Entry)it.next();   
  Object key = entry.getKey();   
  Object value = entry.getValue();
  class_id=(String)key;
  className=(String)value;
  select = select +"<option value="+class_id+">"+className+"</option>";
  }
%>
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
				document.getElementById("class_id").value = "000000000000000";
				document.getElementById("trade_type_code").value="4587";
				return true;
			}
			document.getElementById("trade_type_code").value="4587";
			return true;
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
				align="center" bgcolor="#DEEDFD">
				<tr>
					<td class="u1" width="10%">
						分类类型
					</td>
					<td class="u2">
						<div class="ping1">
							<%=fname%>
						<input type="hidden" name="class_type" id="class_type" style="width:100px" onChange="setOneClass(this.value)" value="<%=class_type%>">
					</div>
					</td>
				</tr>
				<tr>
					<td class="u1" width="10%">
						分类名称
					</td>
					<td class="u2">
						<div class="ping1">
							<%=class_name%>
					</div>
					</td>
				</tr>
				注：如选择上级分类，则调整为所选分类子分类；如不选，则调整为一级分类！
				<tr id="typeInfo" style="display:block">
					<td height="30" class="u1" valign="top">
						分类调整名称
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
										<%=select%>
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
				<input name="class_name" type="hidden" maxlength="100">
				<input type="hidden" name="class_desc" cols="50" rows="6">
				<input name= "class_id" id="class_id" type="hidden" value="">
				<input name= "fee" id="fee" type="hidden" value="<%=class_id1%>">
				<input name= "trade_type_code" id="trade_type_code" type="hidden" value="">
				 
				<tr class="u2">
					<td   colspan=2>
						<center>
							<input class="xgan" name="bnt" type="submit" value=""  onclick="return checkInfo()">&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="/admin/images/comeback.JPG" onClick="location.href='updateClassInfo.jsp'" style="cursor:hand;" align="absmiddle">
						</center>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




