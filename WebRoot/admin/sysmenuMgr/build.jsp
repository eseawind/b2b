<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.base.config.ProjectConfig,java.util.*,com.saas.biz.commen.config,com.buildhtml.*"%>
<html>
	<HEAD>
		<TITLE>ϵͳ���ݹ���</TITLE>
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
					//��ʼ�ж��û�����
					try 
					{
						if (createType != "" && createType != null) 
						{
							 if (createType == "0" || createType.equals("0")) 
							 {
								CreateIndexHtml cindex = new CreateIndexHtml();
								out.println("<br>����������ҳ............");
								cindex.buildIndex(rootpath);
								out.println("<br>������ҳ����............");
							 }
							 else if (createType == "1" || createType.equals("1")) 
							 {
								CreateSupplyInfoHtml csupply = new CreateSupplyInfoHtml();
								out.println("<br>�������ɹ�ӦƵ�����ҳ��............");
								csupply.buildSupplyIndex(rootpath);
								out.println("<br>���ɹ�ӦƵ�����ҳ�����............");
							 }
							 else if (createType == "2" || createType.equals("2")) 
							 {
								out.println("<br>����������Ƶ�����ҳ��............");
								CreateStockInfoHtml cstock = new CreateStockInfoHtml();
								cstock.buildStockIndex(rootpath);
								out.println("<br>������Ƶ�����ҳ�����............");
							 }
							 else if (createType == "3" || createType.equals("3")) 
							 {
								CreateEnterpriseHtml centerprise = new CreateEnterpriseHtml();
								out.println("<br>����������ҵƵ�����ҳ��............");
								centerprise.createEnterpriseIndex(rootpath);
								out.println("<br>������ҵƵ�����ҳ�����............");
							 }
							 else if (createType == "5" || createType.equals("5")) 
							 {
								out.println("<br>���������˲�Ƶ�����ҳ��............");
								CreateJobResumeHtml chr = new CreateJobResumeHtml();
								chr.buildIndex( rootpath );
								out.println("<br>�����˲�Ƶ�����ҳ�����............");
							 }
							 else if(createType=="6" || createType.equals("6"))
							 {
							   out.println("<br>��������ѧԺƵ�����ҳ��............");
								 CreateSchoolHtml cschool = new CreateSchoolHtml();
								 cschool.buildIndex( rootpath );
								 out.println("<br>����ѧԺƵ�����ҳ�����............");
							 }
							 else if(createType=="8" || createType.equals("8"))
							 {
							 	 out.println("<br>����������ѶƵ�����ҳ��............");
								 CreateJcNewsHtml jcnews = new CreateJcNewsHtml();
								 jcnews.buildIndex( rootpath );
								 out.println("<br>������ѶƵ�����ҳ�����............");
							 } 
							 else if(createType=="9" || createType.equals("9"))
							 {
							 	 out.println("<br>������������Ƶ�����ҳ��............");
								 CreateJcDisTestHtml jcDisTest = new CreateJcDisTestHtml();
								 jcDisTest.buildIndex( rootpath );
								 out.println("<br>��������Ƶ�����ҳ�����............");
							 } 
							 
							 else if(createType=="10" || createType.equals("10"))
							 {
							 	 out.println("<br>��������ͼ��Ƶ�����ҳ��............");
								 CreateBooksHtml book = new CreateBooksHtml();
								 book.buildIndex( rootpath );
								 out.println("<br>����ͼ��Ƶ�����ҳ�����............");
							 } 
						    else if(createType=="11" || createType.equals("11"))
						    {
							 out.println("<br>������������Ƶ�����ҳ��............");
							 CreateHqHtml hq = new CreateHqHtml();
							 hq.buildIndex( rootpath );
							 out.println("<br>����������Ƶ����ҳ�����............");
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



