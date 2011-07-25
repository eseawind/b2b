<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.saas.biz.commen.config"%>

<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.text.SimpleDateFormat"%>
<%
   HttpSession logsession = request.getSession();
   String cust_id="",verify_id="",verify_name="",remark="",req_desc="";
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){			
		cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
	}
  VerifyInfo ver=new VerifyInfo();
  String ifexsit= ver.getVerifyIdByCustId(cust_id);
  if(ifexsit.equals(""))
  {
	   verify_id = comm.GenTradeId();
	}
  else
	{
	   verify_id=ifexsit;
	}
	ArrayList list=ver.genOneVerify(verify_id);
	if(null!=list&&list.size()>0){
	 HashMap map = (HashMap) list.get(0);
	  if(null!=map.get("verify_name"))
			   verify_name= map.get("verify_name").toString();
		if(null!=map.get("remark"))
			   remark= map.get("remark").toString();
		if(null!=map.get("req_desc"))
			   req_desc= map.get("req_desc").toString();
	}
	Calendar cal = Calendar.getInstance();
	String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	String verify_type = param.getSelectItems("100");
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<input type="hidden" name="ifexits" id="ifexits" value="<%=ifexsit%>">
<input type="hidden" name="custIds" id="custIds" value="<%=cust_id%>">
<link rel="stylesheet" href="images/style.css" type="text/css" />
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>
<script language="JavaScript">
			function childver()
			{
				var vl=$("verify_name").value;
			if(null==vl||vl==""){
			 alert("请输入证件号码！");
			 return false;
		  }
		  document.childForm.submit();
			}
			
			if(document.getElementById("ifexits").value == "") {	
				//document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>您好,企业站正在生成...</font>';
				
				var ch_id = document.getElementById("custIds").value;
				
				var data = Math.round(Math.random() * 10000);
				var myAjax = new Ajax.Updater('proDiv',
				'CreateCust.jsp?ch_id='+ch_id,{
					method : 'get',
					evalScripts : true
				});
			}		
				
			
			</script>
</head>
<body>
<form name=childForm action=/doTradeReg.do method=post target="_self">
  <%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
	%>
			
<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#ffffff">
<tr><td width="20%"></td><td bgcolor="#ffffff" width="80%" align="right"><img src="images/now1.gif" border="0" align="absbottom"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>

<tr><td bgcolor="#ffffff" colspan="2">
	
	
	<%
		if(verify_name.equals("")){
	%>
  <table border=0 cellpadding=0 cellspacing=0 align=center width="100%" bgcolor="#ffffff">
    <tr>
		<td colspan="2" style="height:36px; valign="top">&nbsp;&nbsp;&nbsp;&nbsp;
			恭喜您,您的详细资料已成功提交,请您填写申请验证信息！打<font color="red">*</font>为必填项</br>
			
		</td>
	</tr>
	<tr> 
	  <td class="u1">证件名称<font color="red">*</font> </td>
      <td class="u2">
          <select name="verify_type" maxlength="25">
            <%=verify_type%>
          </select>        </td>
    </tr>
    <tr>
      <td class="u1">证件号码<font color="red">*</font></td>
      <td class="u2">
          <input type="text" name="verify_name" id="verify_name" maxlength="50" size="30" value="<%=verify_name%>">        </td>
    </tr>
    
    <input type="hidden" name="req_date" id="req_date" size="10" value="<%=start%>" > 
    <input name="remark" type="hidden" id="remark" size="35" maxlength="50" value="<%=remark%>"> 
    <tr>
      <td class="u1" valign="top"> 申请说明<font color="red">*</font></td>
      <td class="u2">
          <textarea name="req_desc"  style="display:none"><%=req_desc%></textarea>
        
        <iframe id="req_desc"  src="/www/ewebeditor/ewebeditor.htm?id=req_desc&style=coolblue" frameborder="0" scrolling="no" width="100%" height="200"></iframe>
        </td>
    </tr>
    <tr>
      <td class="u3" colspan="2"><input name="comit" type="button" class="button"  value="提 交" onclick="return childver()">      </td>
    </tr>
    <input type="hidden" name="oper_date" id="oper_date" value="<%=start%>">
    <input type="hidden" name="oper_user" id="oper_user" value="">
    <input type="hidden" name="cust_id" id="oper_user" value="<%=cust_id%>">
    <input type="hidden" name="verify_status" id="verify_status" value="0">
    <input type="hidden" name="verify_id" id="verify_id" value="<%=verify_id%>">
    <%if(ifexsit.equals("")){%>
    <input type="hidden" name="trade_type_code" id="trade_type_code" value="012">
    <%}else{%>
    <input type="hidden" name="trade_type_code" id="trade_type_code" value="0948">
    <%}%>
  </table>
  
  <%
  	}
  %>
  
  <table>
  	<tr>
  		<td>
  			 &nbsp;&nbsp;&nbsp;&nbsp;
  			 您好,您的验证信息已成功提交,请等待管理员的审批！
  		</td>
  	</tr>
  </table>
  
  
</td></tr></table>
</form>
</body>
</html>




