<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=GBK"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=">
<title>广告管理-获取JS</title>
<link rel="stylesheet" type="text/css" href="base.css">
</head>
<body leftmargin="8" topmargin='8'>
	
<%
	String cust_adv_id = "";
	if(request.getParameter("cust_adv_id")!=null){
		cust_adv_id = request.getParameter("cust_adv_id");
	}
	AdvertiseIntf adv = new AdvertiseIntf();
	HashMap advMap = adv.getInfoByCustAdvId(cust_adv_id);
	String n_content = "",p_content = "",time_limit = "",end_date = "";
	if(advMap!=null){
		if(advMap.get("n_content")!=null){n_content = advMap.get("n_content").toString();}
		if(advMap.get("p_content")!=null){p_content = advMap.get("p_content").toString();}
		if(advMap.get("time_limit")!=null){time_limit = advMap.get("time_limit").toString();}
		if(advMap.get("end_date")!=null){end_date = advMap.get("end_date").toString();}
	}
	
	String disStr = "";
	String ndate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	if(!time_limit.equals("") && time_limit.equals("0")){
		disStr = n_content;
	}
	if(!time_limit.equals("") && time_limit.equals("1")){
		if(ndate.compareTo(end_date) > 0){
			disStr = p_content;
		}else{
			disStr = n_content;
		}
	}
%>
<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
			<td height="50"> 
			</td>
	</tr>
  <tr>
		<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>广告管理-获取JS</b></font></td>
		<td background="/admin/images/content_04.gif">&nbsp;</td>
		<td width="8"><img src="/admin/images/content_06.gif"></td>
  </tr>
</table-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="BORDER-COLLAPSE: collapse">
  <tr> 
    <td width="100%" height="20">
				<table width='100%'  border='0' cellpadding='3' cellspacing='1' bgcolor='#CBD8AC'>
					<tr bgcolor='#EEF4EA'>
						<td colspan='2' ><b>以下为选定广告的JS调用代码：</b></td>
					</tr>

					<tr>
							<td bgcolor='#EEF4EA'>
								<xmp style='color:#333333;background-color:#ffffff'>
									
<script src='/inc/ad_js.jsp?cust_adv_id=<%=cust_adv_id%>' language='javascript'></script>
							</xmp><b>预览</b>：
							</td>
					</tr>
					<tr>
							<td bgcolor='#EEF4EA' height="200" valign="top">
									<%=disStr%>
							</td>
					</tr>
				</table>
    </td>
  </tr>
  <tr >
					      <td colspan="4" class="u3">
					      	<center>
					      	<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;">
					      </center>
					      </td>
						 </tr>
</table>

</body>

</html>
<script language="javascript">
	function ResizeImages()
	{
	   var myimg,oldwidth;
	   var maxwidth=250;
	   for(i=0;i<document.images.length;i++){
	     myimg = document.images[i];
	     if(myimg.width > maxwidth)
	     {
	        oldwidth = myimg.width;
	        myimg.style.width = maxwidth;
	        myimg.style.height = "auto";
	     }
	   }
	}
	ResizeImages();
  </script> 


