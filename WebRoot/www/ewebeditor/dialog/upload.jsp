<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="comm" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%
	String root_id = "";
	if (request.getParameter("root_id") != null) {
		root_id = request.getParameter("root_id");
	}
		Productclass pcls=new Productclass();
	String imgT="";
	imgT=pcls.getImgTypeup();
%>
<html>
	<head>
		<title>upload</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type="text/javascript" src="/inc/prototype.js"></script>
		<script type="text/javascript">
			var imgtype="";
			Productclass.getImgTypeup(getType);
			
			function getType(imgdata){
				imgtype=imgdata;
				
				}
		   function submitForm(){
		      document.getElementById("files").value=document.getElementById("file_dir").value;
		      document.forms[0].submit();
		   }
		  function checkImage() {
			var imag = document.getElementById('files').value;
			if (imag == null || imag == "") {
				alert("请选择要上传的附件！");
				return false;
			} else {
				var pos = imag.lastIndexOf(".");
				var lastname = imag.substring(pos+1, imag.length)
				if (imgtype.indexOf(lastname)<0) {
					alert("您上传的文件类型为" + lastname + "，附件格式类型不正确！");
					return false;
				}
			}
			 return true;
		}
		</script>
	</head>
	<body>
		<html:form action="/uploadFile.do" enctype="multipart/form-data" target="_self">
			<table width="420px" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd" height="140px">
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=left width="100%" height="25px">
						<html:file property="files" />
						<html:errors property="files" />
						<input type="submit" value="上传" onclick="return checkImage()">
						<br/>
						<input type="radio" name="rsrv_str2" value="2" checked="checked">不加水印  
					  	<input type="radio" name="rsrv_str2" value="1"> 加水印
					  		<p>能上传的图片类型，<%=imgT%></p>
					</td>
					<input name="file_dir" type="hidden" id="file_dir" value=""/>
					<input name="trade_type_code" type="hidden" value="1156"/>
					<input name="filename" type="hidden"/>
					 <input name="file_type" type="hidden" value="3"/>
					<input name="attach_root_id" type="hidden" value="<%=root_id%>"/>
					<input name="id" type="hidden" id="id" value="<%=root_id%>"/>
					<input type="hidden" name="rsrv_str1" id="rsrv_str1" value="0"/>
				
				</tr>
			</table>
		</html:form>
	</body>
</html>




