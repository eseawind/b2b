<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.creditMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="comm" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%
	String credit_id = "", credit_title = "", credit_desc = "", credit_start_date = "",
	credit_end_date = "",credit_type="",credit_department="";
	if (request.getParameter("credit_id") != null) {
		credit_id = request.getParameter("credit_id");
	}
	CreditInfo creditInfo = new CreditInfo();
	ArrayList creditList = creditInfo.genOneCredit(credit_id);
	if (creditList != null && creditList.size() > 0) {
		HashMap map = (HashMap) creditList.get(0);
		if(map.get("credit_title")!=null){
		  credit_title = map.get("credit_title").toString();
		}
		if(map.get("credit_desc")!=null){
		  credit_desc = map.get("credit_desc").toString();
		}
		if(map.get("credit_type")!=null){
		  credit_type = map.get("credit_type").toString();
		}
		if(map.get("credit_department")!=null){
		  credit_department = map.get("credit_department").toString();
		}
		if( map.get("credit_start_date")!=null){
		  credit_start_date = map.get("credit_start_date").toString();
		  if (credit_start_date.length() > 10) {
			credit_start_date = credit_start_date.substring(0, 10);
		 }
		}
		if( map.get("credit_end_date")!=null){
		  credit_end_date = map.get("credit_end_date").toString();
		  if(credit_end_date.length() > 10) {
			credit_end_date = credit_end_date.substring(0, 10);
		  }
		}
	}
	ParamethodMgr paramCom = new ParamethodMgr();
	credit_type = paramCom.getParamNameByValue("7",credit_type);
	credit_department =  paramCom.getParamNameByValue("32",credit_department);
	ArrayList list = comm.getAttachInfoByList(credit_id);
%>
<html>
	<head>
		<title>查看证书信息	</title>
		<style type="text/css" media="screen">
	form {padding:0px; margin:0px;}
	.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
	.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
	.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
	.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
	</style>
	<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	
	   
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td height="1"></td>
			</tr>
			<tr>
				<td valign="top">
					
				
					<table width="100%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="u1">
								证书类型：							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<div class="ping1">
									<%=credit_type%>								</div>							</td>
									<td class="u1">
								归属部门：							</td>
							<td class="u1">
								<div class="ping1">
									<%=credit_department%>								</div>							</td>
						</tr>
						<tr>
							<td class="u1">
								证书名称：							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<div >
									<%=credit_title%>								</div>							</td>
									<td class="u1">
								证书说明：							</td>

							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<div >
								 <bean:define id="desc" value="<%=credit_desc%>"/>
								 <bean:write name="desc" filter="false"/>
								</div>							</td>
						</tr>
						<tr>
							<td class="u1">
								开始时间：							</td>
							<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
								<div >
									<%=credit_start_date%>								</div>							</td>
									<td class="u1">
								结束时间：							</td>
							<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
								<div >
									<%=credit_end_date%>								</div>							</td>
						</tr>
						<tr>
							<td class="u1">
								附件信息：							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
								<div >
									<ol>
									   <%
									    if(list !=null && list.size()>0){
									     for(int i=0;i<list.size();i++){
					                        HashMap map=(HashMap)list.get(i);
					                        String attach_desc="",file_path="",attach_name="";
					                        if(map.get("file_path")!=null){
					                          file_path=map.get("file_path").toString();
					                          file_path=file_path.substring(23);
					                        }
					                        if(map.get("attach_desc")!=null){
					                          attach_desc=map.get("attach_desc").toString();
					                        }
					                        if(map.get("attach_name")!=null){
					                          attach_name=map.get("attach_name").toString();
					                        }
					                        if(attach_desc!="0" && !attach_desc.equals("0")){
									       %>
									         <li style="width: 30%"><a href="<%=file_path%>" TARGET=appwin onclick="mydefss()" title="下载..."><%=attach_name%></a></li>
									        <%}
									      }
									    }
									   %>
									</ol>
								</div>							</td>
						</tr>
						<tr>
					
					</table>
			  </td>
			</tr>
			<tr>
				<td height="23" align="center"><img src="/admin/images/comeback.JPG" border="0" onclick="javascript:history.go(-1);" style="cursor:hand;"/></td>
			</tr>
		</table>
	</body>
	<script language="javascript">
		function ResizeImages()
		{
		   var myimg,oldwidth;
		   var maxwidth=200;
		   for(i=0;i<document.images.length;i++){
		     myimg = document.images[i];//得到页面中所有的图片信息
		     if(myimg.width > maxwidth)//若图片的宽度大于200，则将宽度设为200，高度是自动的"auto"
		     {
		        oldwidth = myimg.width;
		        myimg.style.width = maxwidth;
		        myimg.style.height = "auto";
		     }
		   }
		}
		ResizeImages();
	   </script>
</html>



