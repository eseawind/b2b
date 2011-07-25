<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String link_id = bean.GenTradeId();
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList linkTypeList = paramCom.getCompareInfo("CRM", "link_type");
%>
<html>
	<head>
		<title>www.21oil.com</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<style type="text/css">
form {
	padding: 0px;
	margin: 0px;
}

.line6 {
	width: 72spx;
	width: 70spx !important;
	border: #ffcb99 1px solid;
	background-color: #fff8ee;
	text-align: left;
	padding-left: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: #000000;
	margin-top: 13px;
	margin-bottom: 13px;
}  /*横栏样式6---- 头部提醒1*/
.line6 .img {
	width: 53px;
	height: 53px;
	float: left;
	margin-right: 20px;
}

.line6 .title {
	font-size: 14px;
	font-weight: bold;
	color: #ff5400;
}
.tjan{
     background: url(/admin/images/tj.gif) left center no-repeat;
	 width:78px;
	 height:32px;
	 border:0px; 
	 cursor:hand;
	 }
.line1 {
	border-left: #ff7300 3px solid;
	background-color: #e2e2e2;
	color: #333333;
	text-align: left;
	font-size: 13px;
	font-weight: bold;
	padding-left: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
} /*横栏样式1*/
</style>
		<script language="JavaScript">
     function check_none()
     {
          if (document.formQuery.advshow.checked)
          {
      	    document.formQuery.submit1.disabled=false;        	     
      	}
      	else
      	{
      	   document.formQuery.submit1.disabled=true;
      	}
  	}
    	function exit()
    	{
    	    window.close();
    	}
    	function confirmsub()
    	{
    	    if(document.formQuery.link_name.value== "" || document.formQuery.link_name.value == null)
			{
				
        alert("链接名称不可以为空！");                                                            
				document.formQuery.link_name.focus();                                                    
				return false;     
			}
			if(document.getElementById("link_no").value=="" || document.getElementById("link_no").value==null){
					alert("链接显示顺序不能为空");                        
				document.formQuery.link_no.focus()
				return false;
				}
			if(document.formQuery.link_url.value== "" || document.formQuery.link_url.value == null ||
			document.formQuery.link_url.value == "http://www.")
			{
				alert("链接地址不可以为空！");                                                             
				document.formQuery.link_url.focus();                                                    
				return false;     
			}
			var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
  			+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
        + "|" 
        + "([0-9a-z_!~*'()-]+\.)*" 
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." 
        + "[a-z]{2,6})" // first level domain- .com or .museum  
        + "(:[0-9]{1,4})?" // 端口- :80  
        + "((/?)|" // a slash isn't required if there is no file name  
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        var re=new RegExp(strRegex);  
 
        if (re.test(document.getElementById("link_url").value)){ 
            
        }else{  
						alert("链接地址格式错误！");
            return false;  
        }    	         
    	}
  </script>
	</head>
	<body>
	
		
					<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="pageIndex.jsp"><b>友情链接管理</b></a>
				</td>
			</tr>
		</table>
						<table width=100% border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>

							</tr>
							<tr>
								<td width="12%" class="u1">
									链接名称：
								</td>
								<td width="88%" class="u2">
									<div class="ping">
										<input type=text name="link_name" maxlength=50 size=50>
									</div>
								</td>
							</tr>
							<tr style="display:none;">
								<td class="u1">
									链接类型：
								</td>
								<td class="u2">
									<div class="ping">
										<select name="link_type">
											<%
												if (linkTypeList != null && linkTypeList.size() > 0)
												{
													for (int i = 0; i < linkTypeList.size(); i++)
													{
														HashMap map = (HashMap) linkTypeList.get(i);
														String value = map.get("para_code1").toString();
														String name = map.get("para_code2").toString();
											%>
											<option value="<%=value%>"><%=name%></option>
											<%
												}
												}
											%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									链接地址：
								</td>

								<td class="u2">
									<div class="ping">
										<input type=text name="link_url"  id="link_url" maxlength=50 size=50 value="http://www.">
										<font color="red">( http://www.xxxx.com)</font>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									链接说明：
								</td>
								<td class="u2">
									<div class="ping1">
										<textarea name=link_desc style="display: none"></textarea>
										<iframe id="link_desc" src="/www/ewebeditor/ewebeditor.htm?id=link_desc&style=coolblue&root_id=<%=link_id%>" frameborder=0 scrolling=no width=600 height=350></iframe>
									</div>
								</td>
							</tr>
							<tr >
								<td class="u1">
									显示顺序：
								</td>
								<td class="u2">
									<div class="ping1">
										<input type=text name=link_no id="link_no" maxlength="100" value="" onkeyup="if(isNaN(value))execCommand('undo')">
										(只能输入数字)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan=2 align="center">
									<input class="tjan" type="submit" value="" onclick="return confirmsub()">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG" onClick="location.href='pageIndex.jsp'" style="cursor:hand;" align="absmiddle">
								</td>
							</tr>
							<input name=link_id type=hidden value="<%=link_id%>">
							<input type=hidden name=rsrv_num1 value=0>
							<input name=trade_type_code type=hidden value=0911>
						</table>
						
					</form>
	
	</body>
</html>


