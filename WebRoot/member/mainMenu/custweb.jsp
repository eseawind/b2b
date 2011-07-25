<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">     
<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="java.util.*,tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.FileOperate"%>
<%@ page import="com.buildhtml.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
    HttpSession logsession = request.getSession();
	String cust_id = "";String tabn="",class_name="",cust_name="";
    String stepstr="";
	 if(logsession.getAttribute("SESSION_CUST_ID") != null )
	 {
     	cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
     }
  
	config configFile = new config();
	configFile.init();
	String index_temp = configFile.getString("index_temp");// company/enterprise/customer/
	String save_dir = configFile.getString("templates_save_path");
 	String templates_path = configFile.getString("templates_path");// /usr/www/wood.bizoss.com/company/enterprise/customer/
	String platform_path = configFile.getString("platform_path");// /usr/www/wood.bizoss.com/company/enterprise/public/
	
	CustCreateIndex createIndex = new CustCreateIndex();
	CustCreateChannel createChannel = new CustCreateChannel();
	CustCreateArticle createArticle = new CustCreateArticle();
	FileOperate copyfold = new FileOperate();	 
	String dirpath = templates_path + cust_id; 
	String newmodepath = platform_path + "default";
	
	 if( !FileIO.ExistFloder(dirpath) )
	 { 
	 %>
	 	
	 <%
		copyfold.newFolder( dirpath );
		copyfold.copyFolder( newmodepath, dirpath+"/default" );
		createIndex.CreateIndex( cust_id, index_temp+cust_id+"/default/index.html",save_dir + cust_id, "index.html" );
		createChannel.CreateChannelIndexList( "0000000000", cust_id );
		createArticle.CreateArticleList( "0000000000", cust_id );
	%>
		<script language="javascript">
			window.location.reload();
		</script>
	<%	
	  }
	  else if( FileIO.ExistFloder(dirpath) )
	  {	 
	  %>
	  <span style="float:left; line-height:20px; height:20px; padding-left:10px;"><A href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank"><font color="#FF0000">点击查看</font></A> <img src="/admin/images/home.gif" name="Image16" width="113" height="20" border="0" align="absmiddle" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://b2b.bizoss.com/company/web/<%=cust_id%>/');"></span>
	 <%
	  }
	  else
	  {
	  		out.print( "报错了！！！" );
	  }
	%>


