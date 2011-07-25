<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">     
<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*,tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.FileOperate"%>
<%
    HttpSession logsession = request.getSession();
	  String cust_id = "";String tabn="",class_name="",cust_name="";
    String stepstr="";
	 if(logsession.getAttribute("SESSION_CUST_ID")!=null){
     cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    Custinfo custInfo=new Custinfo();
    class_name=custInfo.getCustClassName(cust_id);
    cust_name=custInfo.getCustomerNameById(cust_id);
    stepstr= custInfo.getStepByCustId(cust_id);
    tabn=custInfo.getTabByCustId(cust_id);
	
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("ecms_path");///usr/www/b2b.bizoss.com/
	
	FileOperate copyfold = new FileOperate();
	String filepath = "company/enterprise/customer/" + cust_id;
	String oldmodepath = "company/enterprise/public/default" ;
	
	String dirpath = rootpath + filepath; 
	String newmodepath = rootpath + oldmodepath; 
	 if( !FileIO.ExistFloder(dirpath) )
	 { 	 
		copyfold.newFolder( dirpath );
		copyfold.copyFolder( newmodepath, dirpath+"/default"    );
	%>
		<script language="javascript">
			window.location.reload();
		</script>
	<%	
	 	 
		 
	  }
	
%>
<html>
<head>

   <title>b2b.bizoss.com</title>
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
    <li><a id="m_piece2" href="http://b2b.bizoss.com/"></a></li>
    <li><a id="m_piece3" href="member/enterpriseMgr/InterimPages.jsp?cust_id=<%=cust_id%>"></a></li>
    <li><a id="m_piece4" href="Cooperation.html"></a></li>
    <li><a id="m_piece5" href="Contact.html"></a></li>
    <li><a id="m_piece6" href="Assistant.html"></a></li>
    <li><a id="m_piece7" href="/member/mainMenu/default.jsp"></a></li>
    <li><a id="m_piece8" href=""></a></li>
    </ul>
	
</div>
	<div id="global">
	<!--div id="recherche">
    <ul>
      <li><img src="images/button1_01.jpg" border="0" align="absbottom"/></li>
      <li><img src="images/to.gif" border="0" align="absbottom"/></li>
      <li><img src="images/button2_02.jpg" border="0" align="absbottom"/></li>
      <li><img src="images/to.gif" border="0" align="absbottom"/></li>
      <li><img src="images/button3_03.jpg" border="0" align="absbottom"/></li>
      <li><img src="images/to.gif" border="0" align="absbottom"/></li>
      <li><img src="images/button3_04.jpg" border="0" align="absbottom"/></li>
      <li><img src="images/to.gif" border="0" align="absbottom"/></li>
      <li><img src="images/button_wc.jpg" border="0" align="absbottom"/></li>
    </ul>
      <div style="width:60%; text-align:center; padding-top:10px;"><img src="images/now.gif" border="0" align="absbottom"/></div>
    </div-->
					<% if(!tabn.equals("4")){%>
    <table id="tabCompany" width="80%" height="50"  border="0" cellspacing="0" align="center" cellpadding="0" >
				<tr> 
					<td>	<%=stepstr%></td>
				</tr>
			</table>			
					<%}%>
	<div id="accueil">
			<div id="contenu">
			  <div id="presentation">
                <% if(tabn.equals("1")){ %>
                <table id="tab1" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:blank" >
                  <tr>
                    <td><jsp:include  flush="true" page="/member/change/verify.jsp">
                      <jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>              
                      <jsp:param name="info_type" value="2"/>              
                      </jsp:include>
                    </td>
                  </tr>
                </table>
			    <% }else{ %>
                <table id="tab1" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none">
                  <tr>
                    <td><jsp:include  flush="true" page="/member/change/verify.jsp">
                      <jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>              
                      <jsp:param name="info_type" value="2"/>              
                      </jsp:include>
                    </td>
                  </tr>
                </table>
			    <% } %>
                <table id="tab2" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none">
                  <tr>
                    <td><jsp:include  flush="true" page="/member/change/verify2.jsp">
                      <jsp:param name="menu_id" value="4v2Kggfgfd66iYB2Y"/>              
                      <jsp:param name="info_type" value="0"/>              
                      </jsp:include>
                    </td>
                  </tr>
                </table>
			    <%	if(tabn.equals("3")){ %>
                <table id="tab3" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:blank">
                  <tr>
                    <td><jsp:include  flush="true" page="/member/change/linkAccount.jsp">
                      <jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>              
                      <jsp:param name="info_type" value="2"/>              
                      </jsp:include>
                    </td>
                  </tr>
                </table>
			    <% }else{ %>
                <table id="tab3" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:none">
                  <tr>
                    <td><jsp:include  flush="true" page="/member/change/linkAccount.jsp">
                      <jsp:param name="menu_id" value="tt23cv603456yck46v7k"/>              
                      <jsp:param name="info_type" value="2"/>              
                      </jsp:include>
                    </td>
                  </tr>
                </table>
			       <% } if(tabn.equals("4")){%>
			        <table id="tab3" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:blank">
                  <tr>
                    <td>
                     <td>
                     	<jsp:include  flush="true" page="/member/change/success.jsp"/>
                    </td>
                     
                  </tr>
                </table>
			       
			       <%}%>
              </div>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <%
								
							%>
							<input type="button" name="createIndex" id="createIndex" value="生成企业站">
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
         <jsp:include  flush="true" page="/member/change/footer.jsp"/>

</div>
</body>
</html>




