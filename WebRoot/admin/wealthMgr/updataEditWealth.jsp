<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>会员积分值修改</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
	
		<script type="text/javascript">
		 function check_Value(){
		 	if(document.getElementById('change_value').value==''){
		 		alert('请输入修改积分值！');
		 		document.getElementById('change_value').focus();
		 		return false;
		 	}
		 	var m;
		   var property_value=document.getElementById("property_value1").value;
		   var money=document.getElementsByName("money");
		   for (i=0;i<money.length;i++){
		   	if(money[i].checked){
		   		m=money[i].value;
		   	}           
		   }
		   
		   if(m==1){
		     property_value=property_value*1 - document.getElementById('change_value').value*1;
		    }else{		    	
		    	property_value=property_value*1 + document.getElementById('change_value').value*1;
		    }
		    document.getElementById('property_value').value=property_value;
		  
		 }
		  
		 //删除所有空格
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		 
	
		</script>
		<%
		    String user_id="";
		    String user_name="";
			  String property_value="";
		   if (request.getParameter("user_id") != null){
        user_id = request.getParameter("user_id");
        }
       UserInfo userObj=new UserInfo();
       ArrayList userList =userObj.getUserListByUser(user_id);
		 if(userList != null && userList.size()>0){
		    HashMap map = (HashMap) userList.get(0);
		     if(map.get("property_value") != null)
			   {
           property_value=map.get("property_value").toString();
          
			   }
			   if(map.get("user_name") != null)
			   {
           user_name=map.get("user_name").toString();
			   }
		    
		 }
			String preperty_reason = comparam.getSelectItems("122");
			
			SimpleDateFormat bartDateFormat3 =  new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date(); 
			
			
		%>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
					
						<!--table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center"><font size="2"><b>会员财富值修改 </b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->

										<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
											<tr>
												<td class="u1">
													用户名称：
												</td>
												<td class="u2">
													<div>
													<%=user_name%>
														<input type="hidden" name="user_id" value="<%=user_id%>">
													
													</div>
												</td>
												</tr>
											<tr>
												
												<td class="u1">
													积分值：
												</td>
												<td class="u2">
													<div>
														<input type="text" id="property_value1" name="property_value1" value="<%=property_value%>" readonly>
													  
													
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													修改积分值：   
												</td>
												<td class="u2" colspan="3">
													<div>
														<input type=radio id = 'money' name='money' value='0'checked>增加 
												    <input type=radio id = 'money' name='money' value='1' >减少
												    <input type=text name='change_value' id='change_value'  size='10' onkeyup="if(isNaN(this.value))this.value=''" >
												    <input type="hidden" name='property_value' value="" >
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													修改原因：
												</td>
												<td class="u2" colspan="3">
													<div class="ping1">
														<select name="change_reason">
															<%=preperty_reason %>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="u3" colspan="4">
													<input class="xgan" name="submit" type="submit" value="" onclick="return check_Value()">
													&nbsp;&nbsp;&nbsp;
													<img src="/admin/images/comeback.JPG" onClick="location.href='updataWealth.jsp'" style="cursor:hand;" align="absmiddle">
												</td>
											</tr>
										
										
											<input type="hidden" name="property_type" id="property_type" value="0">
											<input type="hidden" name="change_date" id="change_date" value="<%=bartDateFormat3.format(date)%>">
											<input type="hidden" name="remark" id="remark" value="B2B" />
											<input type="hidden" name="old_value" id="old_value" value="<%=property_value%>"/>
										
											<input type="hidden" name="rsrv_str10">
											<input type="hidden" name="change_user_id">
											<input type="hidden" name="oper_date" value="<%=bartDateFormat3.format(date)%>">
											<input type="hidden" name="rsrv_str1">
											<input type="hidden" name="rsrv_str2">
											<input type="hidden" name="rsrv_str3">
											<input type="hidden" name="rsrv_str7">
											<input type="hidden" name="rsrv_str8">
											<input type="hidden" name="rsrv_str9">
										
											<input type="hidden" name="trade_type_code" value="9978">
										</table>

	</form>
	</body>
</html>



