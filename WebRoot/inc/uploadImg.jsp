<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.productclassMgr.Productclass"%>
<jsp:useBean id="comm" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%
	String root_id = "", attach_id = "", file_path = "";
	if (request.getParameter("root_id") != null) {
		root_id = request.getParameter("root_id");
	}
	Productclass pcls=new Productclass();
	String imgT="";
	imgT=pcls.getImgTypeup();
	String display = "display:none";
	int cols=1;
%>
<html>
	<head>
		<title>upload</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
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
				if ((imgtype.indexOf(lastname)<0) || (lastname.indexOf('jsp')>0) ||(lastname.indexOf('htm')>0)  ){
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
			<table width="100%" border=0 cellpadding=0 cellspacing=0 align=left height="120px">
				<tr id="img-div" style="display: block;">
				<td>
				 <table width="100%" border=0 cellpadding=0 cellspacing=0 align=left>
				   <tr>
					<%
						String ifHavePhono = "0";
						ArrayList list = comm.getAttachInfoByList(root_id);
						if (list != null && list.size() > 0) {
							ifHavePhono = "1";
							display = "display:block";
							cols=list.size();
							for (int i = 0; i < list.size(); i++) {
								HashMap map = (HashMap) list.get(i);
								attach_id = map.get("attach_id").toString();
								file_path = "";
								if (map.get("file_path") != null) {
									file_path = map.get("file_path").toString();
								}
								%>
									<td style=" color:#000000;  font-weight:bold; font-size:12px;" align=left>
										<img src="<%=file_path%>" border=0 width="100" height="100"> <a href="/doTradeReg.do?trade_type_code=1157&attach_id=<%=attach_id%>" target="_self">删除</a>
									</td>
								<%
						 }
					 }
					 if(list==null || list.size()<=0){
					%>
				<td style=" color:#000000;  font-weight:bold; font-size:12px;" align=left>
										<img src="/images/cpwu.gif" border=0 width="100" height="100"> 
									</td>
						<%}%>
					</tr>
					</table>
				 </td>
				</tr>
				<tr>
            <td style="color:#000000;  font-weight:bold; font-size:12px;" colspan="<%=cols%>">
						<html:file property="files" />
						<html:errors property="files" />
						
						<input name="file_dir" type="hidden" id="file_dir" value="" />
						<input name="trade_type_code" type="hidden" value="1156" />
						<input name="filename" type="hidden" />
						<input name="attach_root_id" type="hidden" value="<%=root_id%>" />
						<input name="id" type="hidden" id="id" value="<%=root_id%>" />
						<input type="hidden" name="rsrv_str1" id="rsrv_str1" value="0">
						<input type="hidden" name="rsrv_str2" id="rsrv_str2" value="2">
						<%
							if(ifHavePhono.equals("0")) {
						%>
								<input type="submit" value="图片上传" onClick="return checkImage()">
						<%
							}else {
						%>
								<input type="submit" value="继续上传" onClick="return checkImage()">
						<%
							}
						%>
						
						
							<p>能上传的图片类型，<%=imgT%></p>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>




