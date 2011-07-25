<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%
				
%>
<html>
<head>
<title>供求信息统计</title> 
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
		    
		    document.getElementById("proDiv1").style.display = "block";
		    document.getElementById("proDiv1").innerHTML='<img src=/images/wait.gif border=0><font size=1> 统计中 . . .</font>';
		    document.getElementById("proDiv2").style.display = "block";
		    document.getElementById("proDiv2").innerHTML='<img src=/images/wait.gif border=0><font size=1> 统计中 . . .</font>';
		    document.getElementById("proDiv3").style.display = "block";
		    document.getElementById("proDiv3").innerHTML='<img src=/images/wait.gif border=0><font size=1> 统计中 . . .</font>';
		    document.getElementById("proDiv4").style.display = "block";
		    document.getElementById("proDiv4").innerHTML='<img src=/images/wait.gif border=0><font size=1> 统计中 . . .</font>';
		    document.getElementById("proDiv5").style.display = "block";
		    document.getElementById("proDiv5").innerHTML='<img src=/images/wait.gif border=0><font size=1> 统计中 . . .</font>';
		    
		    var data1 = Math.round(Math.random() * 10000);		    
				var myAjax1 = new Ajax.Updater('proDiv1',
				'ajaxCreate.jsp?TimeRadio='+TimeRadio+'&data='+data1+'&chanel=1',{
					method : 'get',
					evalScripts : true
				});
				
				var data2 = Math.round(Math.random() * 10000);		    
				var myAjax1 = new Ajax.Updater('proDiv2',
				'ajaxCreate.jsp?TimeRadio='+TimeRadio+'&data='+data2+'&chanel=2',{
					method : 'get',
					evalScripts : true
				});
				
				var data3 = Math.round(Math.random() * 10000);		    
				var myAjax3 = new Ajax.Updater('proDiv3',
				'ajaxCreate.jsp?TimeRadio='+TimeRadio+'&data='+data3+'&chanel=3',{
					method : 'get',
					evalScripts : true
				});
				
				var data4 = Math.round(Math.random() * 10000);		    
				var myAjax4 = new Ajax.Updater('proDiv4',
				'ajaxCreate.jsp?TimeRadio='+TimeRadio+'&data='+data4+'&chanel=4',{
					method : 'get',
					evalScripts : true
				});
				
				var data5 = Math.round(Math.random() * 10000);		    
				var myAjax5 = new Ajax.Updater('proDiv5',
				'ajaxCreate.jsp?TimeRadio='+TimeRadio+'&data='+data5+'&chanel=5',{
					method : 'get',
					evalScripts : true
				});
								
		    	return true;
		   }
		</script>
	<form action="countInfoList.jsp" method="post" name="orderform">		
		<table height="20">
			<tr>
				<td>
				</td>
			</tr>
		</table>
				<table width="80%" border=0 cellpadding=2 cellspacing=1 bgcolor="#DEEDFD" align="center">
					<tr bgcolor="white">
						<td>
							<input type="radio" name="yes" value="0" checked>全部 &nbsp;&nbsp;&nbsp;&nbsp;					
							<input type="radio" name="yes" value="3">三天 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="7">一周 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="30">一个月 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="90">三个月 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="180">半年 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="yes" value="365">一年 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="count5" id="count5" value=" 统 计 " onclick="check_Value()">
						</td>
					</tr>
					
				</table>
		</form>
		
    <table bgcolor="#ECF5FD" width=80% border=0 cellpadding=1 cellspacing=1 align="center"  >
		    	<tr>
		    		<td height="10">
		    		</td>
		    	</tr>
					<tr>									 
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td>
										<table width="100%" height="80">
											<tr>
												<th>
													供应信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<div id="proDiv1" style="display: none;"><img src="/images/wait.gif" border="0"><font size="1"> 统计中 . . .</font></div>													
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													求购信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<div id="proDiv2" style="display: none;"><img src="/images/wait.gif" border="0"><font size="1"> 统计中 . . .</font></div>													
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													二手信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<div id="proDiv3" style="display: none;"><img src="/images/wait.gif" border="0"><font size="1"> 统计中 . . .</font></div>													
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>									   		
				 <tr><td height=15></td>
				</tr>
				 
				 
				 
				<tr>
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													产品信息统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<div id="proDiv4" style="display: none;"><img src="/images/wait.gif" border="0"><font size="1"> 统计中 . . .</font></div>													
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" bgcolor="white">													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="center">
										<table width="100%" height="80">
											<tr>
												<th>
													信息总数统计：
												</th>
											</tr>
											 
											<tr>
												<td >
													信息数量
												</td>
												<td align="left">
													<div id="proDiv5" style="display: none;"><img src="/images/wait.gif" border="0"><font size="1"> 统计中 . . .</font></div>													
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						
						<td width=15></td>
						
						<td width="200" height="100" align="center" >													
							<table width="100%" border="0" cellspacing="0" cellpadding="0">								
								<tr>
									<td align="left">
										&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>									   		
				 <tr><td height=15></td>
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


