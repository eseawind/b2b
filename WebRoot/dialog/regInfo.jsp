<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>注册成功</title>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/wood.css" />
	</head>
	<body >
<script language="javascript" src="/templates/wood/js/top.js"></script>


<div style=" padding-top:50px; padding-bottom:50px; margin:0 auto;">       
   <div style=" width:500px;margin:0 auto; text-align:center; height:139px; line-height:139px; background:url(/images/error_bg.gif); color:#666666; font-size:14px; font-weight:bold; padding-top:30px;"><img src="/images/BlueErrorIcon.gif" align="absmiddle" border="0"/>&nbsp;
    <a href="/member/">注册成功，请登陆会员中心！</a>
    </div> 
</div>

<%
	 config configFile = new config();
	 configFile.init();
	 String regemail = configFile.getString("regemail");//是否注册邮件验证 0：关 1：开
	 String examine = configFile.getString("examine");//是否开通审批验证 0：关 1：开
	 
	 if(regemail.equals("1") && examine.equals("1")){ //如果两种可能都开通的话，只应用邮件验证
	 	  regemail = "1";
	 }
	 if(regemail.equals("0") && examine.equals("0")){ //如果两种可能都关闭的话，直接登陆系统
	 	  regemail = "2";
	 }
	 if(regemail.equals("1") && examine.equals("0")){
	 	  regemail = "1";
	 }
	 if(regemail.equals("0") && examine.equals("1")){ 
	 	  regemail = "0";
	 }
	 
	 ArrayList resultlist = (ArrayList) request.getAttribute("backQ");
	 String cust_id = "",user_id="";
	 if(resultlist!=null){
		 for (int i=0; i<resultlist.size();i++)
		 {
		    HashMap infoMaps = (HashMap)resultlist.get(i);
		    if (infoMaps.get("CUST_ID")!= null)
		    {
		        cust_id = infoMaps.get("CUST_ID").toString();
		    }
		    if (infoMaps.get("USER_ID")!= null)
		    {
		        user_id = infoMaps.get("USER_ID").toString();
		    }
		 }
	 }
	
	if(regemail.equals("1")){
%>
	<script language="javascript">
		window.location.href='/member/regsuccess.jsp?cust_id=<%=cust_id%>&user_id=<%=user_id%>';
	</script>
<%
	}else if(regemail.equals("0")){
%>
	<script language="javascript">
		window.location.href='/member/regsuccess_two.jsp?cust_id=<%=cust_id%>&user_id=<%=user_id%>';
	</script>
<%
	}else{
		
		
	    Cookie[] cookies=request.getCookies();   
    
      if(cookies!=null){   
          for(int i=0;i<cookies.length;i++){   
              String   tempuid_1=cookies[i].getName();   
              cookies[i].setPath("/");
              cookies[i].setMaxAge(0);   
              response.addCookie(cookies[i]);     
           }   
      }   
      
      
%>
	
	<script language="javascript">
		window.location.href='/member/index.html';
	</script>
<%
	}
%>

<script language="javascript" src="/templates/wood/js/footer.js"></script>
	</body>
</html>




