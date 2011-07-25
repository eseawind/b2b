<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page"/><html>
<head>
<title>B2B电子商务后台管理系统</title>
<style type="text/css" media="screen">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
 
 
<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
<script src="/js/classResposity.js" language="jscript" type="text/jscript"></script>
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
	if(document.classForm.class_name.value.replace(/\s*/g,"") =="" )
	{
		alert("分类名称不能为空！");
		document.classForm.class_name.focus();
		return false;
	}
	if(document.classForm.classlevel.value=='2')
	{
		if(document.classForm.sort1.value =="")
		{
			 alert("请选择父分类！");
			 return false;
		}
		else
		{
			   document.classForm.up_class_id.value=document.classForm.sort1.value;
			   document.classForm.class_level.value="2";
			if(document.classForm.sort2.value!="" && document.classForm.sort2.value !=null)
			{
				document.classForm.up_class_id.value=document.classForm.sort2.value;
				document.classForm.class_level.value="3";
			}	
 	     }
	}
	else
	{
		document.classForm.up_class_id.value="000000000000000";
		document.classForm.class_level.value="1";
	}	
	return true;
}
function selectLevel(leveles)
{
      if(leveles=="2")
	 {
	   document.getElementById("typeInfo").style.display ="block";
	 }
	 else
	{
	  document.getElementById("typeInfo").style.display ="none";
	} 	
}
</script>
</head>
<body>
<%
	String fbtime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String class_id=bean.GenTradeId();
	ParamethodMgr paramCom=new ParamethodMgr();
	ArrayList  webList =paramCom.getCompareInfo("CRM","web_id");
%>
<div class="line6">
                         <div class="img"><img src="/admin/images/icon3_manager_rightbody.gif" /></div><span class="title">分类信息增加注意事项</span><br />
                                             1、当新增知识库的信息没有对应的分类时，可以增加新的分类。<br />
                                             2、可以某个分类下增加下级分类。                          
                         </div>
<form  name="classForm" method="post" action="/doTradeReg.do" target="_self">
     <table width="100%" border="0" cellpadding="5" cellspacing="1" align="center"  bgcolor="#dddddd">
	    <tr>    
        <td  class="line1" align="left" colspan="2">新建产品信息分类
        </td>
        </tr>
        <tr>
		  <td align="right"  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">分类类型：</td>
		  <td align="left"  style="background-color:#ffffff; color:#000000;  font-size:12px;"><div class="ping1"><select name="classlevel" style="width:100px" onChange="selectLevel(this.value)">
                  <option value="1">主分类</option>
                  <option value="2">子分类</option>
            </select> </div>
		  </td>
	 </tr>
		<tr>
		  <td align="right"  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">分类名称：</td>
		  <td align="left"  style="background-color:#ffffff; color:#000000;  font-size:12px;"><div class="ping1"><input name="class_name" type="text" maxlength="100"></div>
		  </td>
		</tr>
		<tr>
			<td align="right"  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">分类说明：</td>
			<td align="left"  style="background-color:#ffffff; color:#000000;  font-size:12px;"><div class="ping1"><textarea name="class_desc" cols="50" rows="6"></textarea></div>
          </td>
        </tr>
		<tr id="typeInfo" style="display:none">
		  <td height="30" align="right"  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">请选择父分类：</td>
              <td  align="left"  style="background-color:#ffffff; color:#000000;  font-size:12px;">
                <div class="ping1"><table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td  style="background-color:#ffffff; color:#000000;  font-size:12px;"><select name="bigsort" style="display:none">
                      <option selected value="0">请选择...</option>
                    </select></td>
                    <td  style="background-color:#ffffff; color:#000000;  font-size:12px;"><select name="sort1" size="10" onChange="this.form.sort2.options.length=0;this.form.sort3.options.length=0;getSubitems(this.form.sort2, this.value)">
                      <option selected value="0">请选择...</option>
                    </select></td>
                    <td  style="background-color:#ffffff; color:#000000;  font-size:12px;"><select name="sort2" size="10"><!--onChange="this.form.sort3.options.length=0;getSubitems(this.form.sort3, this.value)"-->
                      <option value="0">请选择...</option>
                    </select></td>
                    <td  style="background-color:#ffffff; color:#000000;  font-size:12px;"><select name="sort3" size="10">
                      <option value="0">请选择...</option>
                    </select></td>
                  </tr>
                </table></div>
              </td>
		</tr>
		 <input name="class_id" type="hidden" value="<%=class_id%>">
		 <input name="enable_tag" type="hidden" value="0">
		 <input name="class_type" type="hidden" value="8">
		 <input name="up_class_id" type="hidden" value="000000000000000">
		 <input name="class_level" type="hidden" value="1">
		 <input name="trade_type_code" type="hidden" value="0700">
		 <input name="rsrv_str" id="rsrv_str" type="hidden" value="">
		<!--tr>
			<td align="center"   style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"  colspan=2>
			 <input type="submit" class="tjan" value="" onClick=" return checkInfo()">	
			</td>
    </tr-->
    <tr>
				<td height="30" colspan="2" align="center" style="background-color:#f6f6f6; color:#000000;  font-size:12px;">
					<input class="tjan" type="submit" value="" onClick=" return checkInfo()">
				</td>
		</tr>
</table>
</form>
<script language="jscript" type="text/jscript">
	getSubitems(document.classForm.bigsort, "", "请选择...", "");
	getSubitems(document.classForm.sort1, "");
</script>
</body>
</html>




