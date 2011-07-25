<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">     
<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*,tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.FileOperate"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
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
    
   	//out.println("class_name==="+class_name+"cust_name==="+cust_name+"stepstr==="+stepstr+"tabn==="+tabn+"============"); 
    
		VerifyInfo ver =new VerifyInfo();
		config configFile = new config();
		configFile.init();
		String rootpath = configFile.getString("ecms_path"); 
		String examine = configFile.getString("examine");
	
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
   <title>快速注册---安徽制造业信息化商务平台(http://www.huipoo.com)</title>
	<link rel="stylesheet" href="images/style.css" type="text/css" />
	
</head>
<body onload="setTabs2()">
	<input type="hidden" name="setTab" id="setTab" value="<%=tabn %>">
	<input type="hidden" name="examines" id="examines" value="<%=examine%>">
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
                <table id="tab1" width="100%" border="0" cellspacing="0" cellpadding="0" style="display:block" >
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

<span><IMG src="/admin/images/ucs2.gif" align="absmiddle"> 产品购买咨询：肖先生
    (QQ)<a href="http://wpa.qq.com/msgrd?V=1&Uin=31688721&Site=a-hai.net&Menu=yes tencent://message/?uin=31688721" target=_blank class="lanse">31688721</a> 
    (MSN)<a href=msnim:chat?contact=xiaobo68@gmail.com>xiaobo68@gmail.com</a></span> <BR>
  	<a href="http://www.wanglong.cc" target="_blank" class="lanse">合肥贞龙信息技术有限公司</a> 版权所有 &copy;  2008  保留所有权利 <BR>
		<A href="http://www.wanglong.cc/html/wanglongxinwen/200808/20-17.html" target="_blank" class="lanse">关于我们</A> | <A href="http://www.wanglong.cc/html/yonghubangzhu/200808/18-12.html" target="_blank" class="lanse">联系我们</A> | <A href="http://www.miibeian.gov.cn/" target=_blank>皖ICP备07039386号</A> 
		<br />


</div>
</body>
</html>
<script language="JavaScript">
			if(document.getElementById("setTab").value == "2") {		
					slectTab(2);						
			}
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
 



