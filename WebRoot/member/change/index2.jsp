<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
    HttpSession logsession = request.getSession();
	  String cust_id = "";String tabn="";
    String cust_aim="",company_address="",website="",user_count="",stepstr="";
	 if(logsession.getAttribute("SESSION_USER_ID")!=null){
     cust_id=logsession.getAttribute("SESSION_USER_ID").toString();
    }
    Custinfo custInfo=new Custinfo();
    stepstr= custInfo.getStepByCustId(cust_id);
    tabn=custInfo.getTabByCustId(cust_id);
    tabn="3";
%>
<html >
<head>
	<title>企业商务室</title>
	<link rel="stylesheet" href="images/style.css" type="text/css" />
		<script language="JavaScript">
			function slectTab(val)
		  {
		  	for(var i=1;i<=3;i++) {
				if (i==val) {
					document.all('tab' + i).style.display="";
				} else {
				document.all('tab' + i).style.display="none";
				}
			}  	
		  }
 </script>
</head>

<body>

<div id="footer-contact">
	<a href=" " class="close-contact" ></a>
</div>
	<div id="header"></div>
	<div id="menu">
    <ul>
    <li><a id="m_piece1" href=""></a></li>
    <li><a id="m_piece2" href="index.html"></a></li>
    <li><a id="m_piece3" href="Enterprises.html"></a></li>
    <li><a id="m_piece4" href="Cooperation.html"></a></li>
    <li><a id="m_piece5" href="Contact.html"></a></li>
    <li><a id="m_piece6" href="Assistant.html"></a></li>
    <li><a id="m_piece7" href="Online.html"></a></li>
    <li><a id="m_piece8" href=""></a></li>
    </ul>
	
</div>
	<div id="global">
	<table id="tabCompany" width="600" border="0" cellspacing="0" align="center" cellpadding="0" style="">
				<tr>
						<%=stepstr%>
				</tr>
			</table>
	<div id="accueil">
			<div id="contenu">
				<div id="presentation">
         <div style="float:left; padding-left:40px;">
                   <%if(true){%> 	
              <table id="tab1" width="600" border="0" cellspacing="0" cellpadding="0" style="display:blank" >
					 	 <tr>
					 		<td>
                <jsp:include flush="true" page="/member/change/verify.jsp">
							<jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>
							<jsp:param name="info_type" value="2"/>
						  </jsp:include>	 
					 		</td>
					 	</tr>
					 </table>
          <%}%>
                   
              
           <% if(tabn.equals("1")){ %>
					 <table id="tab1" width="600" border="0" cellspacing="0" cellpadding="0" style="display:blank" >
					 	<tr>
					 		<td>
					 		<jsp:include  flush="true" page="/member/change/verify.jsp">
							<jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>
							<jsp:param name="info_type" value="2"/>
						  </jsp:include>		 		 
					 		</td>
					 	</tr>
					 </table>
						<% }else{ %>
						<table id="tab1" width="600" border="0" cellspacing="0" cellpadding="0" style="display:none">
					 	<tr>
					 		<td>
					 		<jsp:include  flush="true" page="/member/change/verify.jsp">
							<jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>
							<jsp:param name="info_type" value="2"/>
						  </jsp:include>		 		 
					 		</td>
					 	</tr>
					 </table>						
						<% } %>
					  <table id="tab2" width="600" border="0" cellspacing="0" cellpadding="0" style="display:none">
					 	<tr>
					 		<td>
					 			<jsp:include  flush="true" page="/member/change/verify2.jsp">
							 <jsp:param name="menu_id" value="4v2Kggfgfd66iYB2Y"/>
							 <jsp:param name="info_type" value="0"/>
						  </jsp:include>
					 		</td>
					 	</tr>
					 </table>
				 <%	if(tabn.equals("3")){ %>
					  <table id="tab3" width="600" border="0" cellspacing="0" cellpadding="0" style="display:blank">
					 	<tr>
					 		<td>
					 		<jsp:include  flush="true" page="/member/change/linkAccount.jsp">
							<jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>
							<jsp:param name="info_type" value="2"/>
						  </jsp:include>
					 		</td>
					 	</tr>
					 </table>
					 <% }else{ %>
					  <table id="tab3" width="600" border="0" cellspacing="0" cellpadding="0" style="display:none">
					 	  <tr>
					 		<td>
					 		<jsp:include  flush="true" page="/member/change/linkAccount.jsp">
							<jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>
							<jsp:param name="info_type" value="2"/>
						  </jsp:include>
					 		</td>
					 	</tr>
					 </table>
					 <% } %>	         
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
                    	
        </div>
				</div>
			  <div id="infos">
					<h2>公司文化</h2>
				<p>1、三位一体，荣辱与共；</p>
                <p>2、态度第一，技术第二；</p>
                <p>3、交流沟通，理解信任；</p>
                <p>4、团队发展，和谐工作。</p>
			  </div>
              <div style="float:right; padding-right:40px;"><input type="button" class="button"  value="提 交" /></div>
			</div>
	  </div>
	</div>
	<div id="footer">
		<div id="paintoo">
			<h3>
				<a href=" " title=" "><span>PaintoO</span></a>
			</h3>
		</div>
	</div>
	<div id="copyright">
		<p>
        产品购买咨询：肖先生 (QQ)31688721 (MSN)xiaobo68@gmail.com 
		</p>
		<p> 
			合肥网龙信息技术有限公司 版权所有 © 2008 保留所有权利  
		</p>
		<p>
			关于我们 | 联系我们 | 皖ICP备07039386号
		</p>
	</div>
</body>
</html>




