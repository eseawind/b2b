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
	String class_id="000000000000000",class_type="2";
	String url = request.getRequestURL().toString();
	//out.println(url);
    if (request.getParameter("class_type") != null)
    {
        class_type = request.getParameter("class_type");
    }
    if (request.getParameter("class_id") != null)
    {
        class_id = request.getParameter("class_id");
    }
    //out.println(class_id+"****"+class_type);
   String select1 = "",	select2 = "", select3 = "", select4 = "", select5 = "";
   if( class_type.equals("2") )
   {
   		select1 = "selected";
    }
   if( class_type.equals("3") )
   {
   		select2 = "selected";
   }
   if(class_type.equals("4") )
   {
   		select3 = "selected";
   }
   if(class_type.equals("5") )
   {
   		select4 = "selected";
   }
   if(class_type.equals("11") )
   {
   		select5 = "selected";
   }
  String display = "";
  if( class_id.equals("") )
  {
  	 display="display:none";
  }
  else
  {
  	display = "display:blank";	
  }
  ArrayList classList = new ArrayList();
  Productclass pclass = new Productclass();
  classList = pclass.getInfoByUpId(class_id,class_type);
  String up_class_name ="";
  url = "updateClassInfo.jsp?class_id="+class_id+"&class_type="+class_type;
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
			function setOneClass(val)
			{
					if(val==0){
						alert("请选择调整类型");
					}else{
					 document.getElementById("class_id").value="000000000000000";
					 document.classForm.submit();
					}
			}
			function checkInfo()
			{
				var size = document.getElementById("size").value;
				var cid = '';
				var rsrv = '';
				for(var i = 0;i<size;i++)
				{
					if(document.getElementById("rsrv"+i).value!='' && document.getElementById("rsrv"+i).value!=''){
							cid = cid +document.getElementById("id"+i).value+'|';
							rsrv = rsrv + document.getElementById("rsrv"+i).value+'|'
						}
					}
					if(cid==''){
						alert("请填写分类排序");
						return false;
					}else{
						document.getElementById("rsrv_str2").value=rsrv;
						document.getElementById("class_id").value=cid;
						document.getElementById("trade_type_code").value="0364";
					  document.classForm.action="/doTradeReg.do";
					  //document.write(rsrv);
					  document.classForm.submit();
					}
			}
		</script>
    </head>
	<body>
		<form name="classForm" method="post" action="updateClassInfo.jsp" target="_self">
			<table width="100%" border="0" cellpadding="1" cellspacing="1"
				align="center" bgcolor="#DEEDFD">
				<tr>
					<td class="u1"  width="10%">
						分类类型
					</td>
					<td class="u2">
						<div class="ping1">
						<select name="class_type" id="class_type" style="width:100px" onChange="setOneClass(this.value)">
							<option value="2" <%=select1%> >产品分类</option>
							<option value="3" <%=select2%> >企业分类</option>
							<option value="4" <%=select3%> >求购分类</option>
							<option value="5" <%=select4%> >供应分类</option>
							<option value="11" <%=select5%> >图书分类</option>
						</select>
					</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="1" cellspacing="1"	align="center" bgcolor="#DEEDFD" style="<%=display%>">
				<tr class="u4" height="25">
					<td width="25%">
						分类名称
					</td>
					<td width="25%">
						上级分类
					</td>
					<td width="25%">
						排序<font color="#5E605F" size="1">（只能填写数字）</font>
					</td>
					<td width="25%">
						<center>
							级别调整
						</center>
					</td>
				</tr>
				<%
				int size = 0;
				if(classList!=null){
				String up_class_id="",class_name="",up_class_name1="",classid="",rsrv_str2="";
				
				for(int i=0;i<classList.size();i++)
				{
					size = classList.size();
					HashMap classMap = (HashMap)classList.get(i);
					if(classMap.get("up_class_id")!=null){
						up_class_id = classMap.get("up_class_id").toString();
						up_class_name1 = pclass.getClassNameById(up_class_id);
					}
					if(classMap.get("rsrv_str2")!=null){
						rsrv_str2 = classMap.get("rsrv_str2").toString();
					}
					if(classMap.get("class_name")!=null){
						class_name = classMap.get("class_name").toString();
					}
					if(classMap.get("class_id")!=null){
						classid = classMap.get("class_id").toString();
					}
					if(up_class_name1.equals("") || up_class_name1==null){
						up_class_name1 = up_class_name;
					}
					ArrayList downlist = new ArrayList();
					downlist = pclass.getInfoByUpId(classid,class_type);
				%>
				<tr  class="u2">
					<td width="25%">
						<%if(null!=downlist){%>
						<a href="updateClassInfo.jsp?class_id=<%=classid%>&class_type=<%=class_type%>"><%=class_name%></a>
						<%}else{%>
						<%=class_name%>
						<%}%>
					</td>
					<td width="25%">
						<%=up_class_name1%>
					</td>
					<td width="25%">
						<input type="text" style="height:15px;width:25px" id="rsrv<%=i%>" name="rsrv<%=i%>" value="<%=rsrv_str2%>" onkeyup="if(isNaN(value))execCommand('undo')"> 
						<input type="hidden" id="id<%=i%>" name="id<%=i%>" value="<%=classid%>"> 
					</td>
					<td width="25%">
						<center>
							<a href="ClassUpdate.jsp?class_id=<%=classid%>&class_type=<%=class_type%>" ><img src=/images/edit.gif width=16 height=16 border=0 alt="修改分类信息"> </a>
						</center>
					</td>
				</tr>
				<%}
				}%>
				<input name= "size" id="size" type="hidden" value="<%=size%>">
				<input name= "class_id" id="class_id" type="hidden" value="">
				<input name= "rsrv_str2" id="rsrv_str2" type="hidden" value="">
				<input name= "trade_type_code" id="trade_type_code" type="hidden" value="">
				<tr>
					<td class="u3" colspan=4>
						<!--a href="<%=url%>">返回</a-->
						<input class="xgan" name="bnt" type="submit" value=""  onclick="return checkInfo()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%if(!class_id.equals("000000000000000")){%>
							<img src="/admin/images/comeback.JPG" onClick="location.href='updateClassInfo.jsp'" style="cursor:hand;" align="absmiddle">
							<%}%>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



