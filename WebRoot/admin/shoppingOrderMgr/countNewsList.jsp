<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%
				
%>
<html>
<head>
<title>��Ѷ��Ϣͳ��</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
    <script language="javascript" src="/js/Calendar_Ly.js"></script>
    <script type="text/javascript" src="/js/prototype.js"></script>
    <style type="text/css">
			.chaxun{
					background:url(/admin/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
		</style>
</head>

<body onload="check_Value()">
	<script type="text/javascript">
		  function check_Value(){
		    
	      var yesRadio = document.forms[0].yes;   
			   var TimeRadio = '';
			   for(var i = 0;i<yesRadio.length;i++){   
           if(yesRadio[i].checked == true){
          	 TimeRadio = yesRadio[i].value;
        	 }
        }
        document.getElementById("proDiv").style.display = "block";
		document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3> ͳ���� . . .</font>';
		    
		    var data = Math.round(Math.random() * 10000);		    
				var myAjax = new Ajax.Updater('proDiv',
				'ajaxNews.jsp?TimeRadio='+TimeRadio+'&data='+data,{
					method : 'get',
					evalScripts : true
				});
		    
			 	return true;
		   }	
		</script>
	<form action="countNewsList.jsp" method="post" name="orderform">
		<table height="20">
			<tr>
				<td>
				</td>
			</tr>
		</table>
				<table width="80%" border=0 cellpadding=2 cellspacing=1 bgcolor="#DEEDFD" align="center">
					<tr bgcolor="white">
						<td>
							<input type="radio" name="yes" value="0" checked>ȫ�� &nbsp;&nbsp;&nbsp;&nbsp;					
							<input type="radio" name="yes" value="3">���� &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="7">һ�� &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="30">һ���� &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="90">������ &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="180">���� &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="365">һ�� &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="count5" id="count5" value=" ͳ �� " onclick="check_Value()">
						</td>
					</tr>
				</table>
		</form>
		
    <table bgcolor="#ECF5FD" width=80% border=0 cellpadding=1 cellspacing=1 align="center">
		    	<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
		    	<tr>
		    		<td width="100%" bgcolor="white">
		    			<div id="proDiv" style="display: none;"><img src="/images/wait.gif" border="0"><font size="3"> ͳ���� . . .</font></div>	    			
		    		</td>
		    	</tr>
				 
		    </table>		  
		    <table>
		    		<tr>
		    				<td height="30">
		    				</td>
		    		</tr>
		    </table>
</body>
</html>


