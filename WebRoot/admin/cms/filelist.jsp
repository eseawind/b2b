<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	config configFile = new config();
	configFile.init();
	String retStr = "";
	//项目路径
	String webpath = configFile.getString("mysqlbase.projpath");
	//文件路径
	String servletFile = "";
	//上一个文件夹
	String perFile = "";
	String objId = "";
	if (null != request.getParameter("servletFile")&& !"".equals(request.getParameter("servletFile"))) {
		servletFile = request.getParameter("servletFile");
	}
	if (null != request.getParameter("id")) {
		objId = request.getParameter("id");
	}
	if (null != servletFile && !"".equals(servletFile)) {
		String files[] = servletFile.split(File.separator);
		for (int j = 0; j < files.length - 1; j++) {
			perFile = perFile + files[j] + File.separator;
		}
	}

	if (webpath.equals(File.separator)) {
		webpath = webpath + File.separator;
	}
	webpath = webpath + servletFile;

	File file = new File(webpath);
	String files[] = file.list();
	if (!servletFile.endsWith(File.separator)&& !"".equals(servletFile + servletFile)) {
		retStr = servletFile;
		servletFile = servletFile + File.separator;
		
	}else{
		
	}
%>

<html>
	<head>
		<title>文件</title>
		<style type="text/css">
	 	#name_list{height:310px;width:370px;overflow:auto;overflow-x:hidden;border:1px solid #dddddd;padding:0 5px;}
	 	#name_list ul{margin-left:15px; padding:0px; list-style-image:url(/admin/images/file.gif);}
		#name_list ul li{ padding-left:5px; margin-top:0px;margin-bottom:5px;}
		#name_list ul li ul{margin-left:15px; padding:0px; list-style-image:url(/admin/images/text.gif);}
		#name_list ul li ul li{ padding-left:5px; margin-top:0px;margin-bottom:5px;}
	</style>
	</head>
	<script>
function  selectFile(){
	window.opener.document.getElementById("<%=objId%>").value = "<%=retStr%>";
	window.close();
} 
</script>
	<body>
		<table>
			<tr>
				<td>
					<div id="name_list">
						<%
						if(null != files){
				  			for(int i = 0; i < files.length; i++){
				  				int j = files[i].indexOf(".");
								if(j==-1){
						%>
									<img src="/admin/images/file.gif" border="0">
									<a href="filelist.jsp?id=<%=objId%>&servletFile=<%=servletFile + files[i]%>"><%=files[i]%></a>
									</br>
						<% 
								}else{
						%>
									<img src="/admin/images/text.gif" border="0" >
									<a href="filelist.jsp?id=<%=objId%>&servletFile=<%=servletFile + files[i]%>"><%=files[i]%></a>
									</br>
						<% 
								}
				  			}
						}else{
				  	 	%>
				  	 				<script language="javascript">
										function  selectFile(){
											window.opener.document.getElementById("<%=objId%>").value = "<%=retStr%>";
											window.close();
										} 
										selectFile();
									</script>
				  	 	<% 
				  	 	}
				  	 	%>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="向上" onClick="window.location.href = 'filelist.jsp?id=<%=objId%>&servletFile=<%=perFile%>'"/> &nbsp;&nbsp;&nbsp;
				</td>
			</tr>
  		</table>
  	</body>
</html>


