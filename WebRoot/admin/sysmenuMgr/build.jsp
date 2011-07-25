<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.base.config.ProjectConfig,java.util.*,com.saas.biz.commen.config,com.buildhtml.*"%>
<html>
	<HEAD>
		<TITLE>系统内容管理</TITLE>
	</HEAD>
	<BODY>
		<center>
			<h4>
				<%
					config configFile = new config();
					configFile.init();
					String rootpath = configFile.getString("mysqlbase.rootpath");
					String createType = "";
					int number = 0;
					if (request.getParameter("createType") != null) 
					{
						createType = request.getParameter("createType");
					}
					if (request.getParameter("num") != null) 
					{
						number = Integer.parseInt(request.getParameter("num"));
					}
					//开始判断用户请求
					try 
					{
						if (createType != "" && createType != null) 
						{
							 if (createType == "0" || createType.equals("0")) 
							 {
								CreateIndexHtml cindex = new CreateIndexHtml();
								out.println("<br>正在生成首页............");
								cindex.buildIndex(rootpath);
								out.println("<br>生成首页结束............");
							 }
							 else if (createType == "1" || createType.equals("1")) 
							 {
								CreateSupplyInfoHtml csupply = new CreateSupplyInfoHtml();
								out.println("<br>正在生成供应频道相关页面............");
								csupply.buildSupplyIndex(rootpath);
								out.println("<br>生成供应频道相关页面结束............");
							 }
							 else if (createType == "2" || createType.equals("2")) 
							 {
								out.println("<br>正在生成求购频道相关页面............");
								CreateStockInfoHtml cstock = new CreateStockInfoHtml();
								cstock.buildStockIndex(rootpath);
								out.println("<br>生成求购频道相关页面结束............");
							 }
							 else if (createType == "3" || createType.equals("3")) 
							 {
								CreateEnterpriseHtml centerprise = new CreateEnterpriseHtml();
								out.println("<br>正在生成企业频道相关页面............");
								centerprise.createEnterpriseIndex(rootpath);
								out.println("<br>生成企业频道相关页面结束............");
							 }
							 else if (createType == "5" || createType.equals("5")) 
							 {
								out.println("<br>正在生成人才频道相关页面............");
								CreateJobResumeHtml chr = new CreateJobResumeHtml();
								chr.buildIndex( rootpath );
								out.println("<br>生成人才频道相关页面结束............");
							 }
							 else if(createType=="6" || createType.equals("6"))
							 {
							   out.println("<br>正在生成学院频道相关页面............");
								 CreateSchoolHtml cschool = new CreateSchoolHtml();
								 cschool.buildIndex( rootpath );
								 out.println("<br>生成学院频道相关页面结束............");
							 }
							 else if(createType=="8" || createType.equals("8"))
							 {
							 	 out.println("<br>正在生成资讯频道相关页面............");
								 CreateJcNewsHtml jcnews = new CreateJcNewsHtml();
								 jcnews.buildIndex( rootpath );
								 out.println("<br>生成资讯频道相关页面结束............");
							 } 
							 else if(createType=="9" || createType.equals("9"))
							 {
							 	 out.println("<br>正在生成评测频道相关页面............");
								 CreateJcDisTestHtml jcDisTest = new CreateJcDisTestHtml();
								 jcDisTest.buildIndex( rootpath );
								 out.println("<br>生成评测频道相关页面结束............");
							 } 
							 
							 else if(createType=="10" || createType.equals("10"))
							 {
							 	 out.println("<br>正在生成图书频道相关页面............");
								 CreateBooksHtml book = new CreateBooksHtml();
								 book.buildIndex( rootpath );
								 out.println("<br>生成图书频道相关页面结束............");
							 } 
						    else if(createType=="11" || createType.equals("11"))
						    {
							 out.println("<br>正在生成行情频道相关页面............");
							 CreateHqHtml hq = new CreateHqHtml();
							 hq.buildIndex( rootpath );
							 out.println("<br>生成行情相频道关页面结束............");
						    } 

						}
					}
					catch (NumberFormatException e) {
						out.println("e = " + e.toString());
					}
					out.println("<SCRIPT LANGUAGE=\"JAVASCRIPT\">\n" + "setTimeout('window.opener=null;window.close();',1000);" + "</SCRIPT>");
				%>
			</h4>
			<center>
	</BODY>
</HTML>



