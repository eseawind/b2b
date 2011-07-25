<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import="com.base.config.ProjectConfig,
                 java.util.Vector,
                 com.saas.biz.commen.config,
                 com.bean.ProductClassInfo,
                 com.new_buildHtml.*"%>
<%@ page import="com.base.config.ProjectConfig"%>
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
	     
			String rootpath = configFile.getString( "mysqlbase.rootpath" );
			String  createType = "";
			int number = 0;
			
			if(request.getParameter( "createType" ) != null)
			{
				 createType=request.getParameter( "createType" );
			}
		  if(request.getParameter( "num" ) != null)
			{
				 number = Integer.parseInt( request.getParameter( "num" ) );
			}
	    //开始判断用户请求
		  try 
		  {
			  if( createType != "" && createType != null )
			  {
			     //CreateJs.buildAllJs( rootpath );
				   if( createType=="0" || createType.equals("0") )
					 {
						 CreateIndexHtml cindex = new CreateIndexHtml();
						 out.println("<br>正在生成首页............");
						 cindex.buildIndex( rootpath );
						/*cindex.buildEnterpriseIndex(conn,rootpath);
						//cindex.buildOrderIndex(conn,rootpath);
						//cindex.buildSupplyIndex(conn,rootpath);
						//CreateProductHtml cproduct = new CreateProductHtml();
						cproduct.builderProductDetail(conn,rootpath,number);*/
						 out.println("<br>生成首页结束............");
					 }
				   /*else if( createType=="1" || createType.equals("1") )
				   {
				      //生成企业库相关页面
				      CreateCustomerHtml ccustomer = new CreateCustomerHtml();
							ccustomer.createCustomer(conn,rootpath,number);
				   }
				   else if( createType=="2" || createType.equals("2") )
				   {
		        	//生成供应相关页面
	            out.println("正在生成供应相关页面............");
	            CreateSaleInfoHtml csale = new CreateSaleInfoHtml();
	            csale.builderSaleInfoDetail(conn,rootpath,number);
	            out.println("生成供应相关页面结束............");
				   }
				   else if( createType=="3" || createType.equals("3") )
				   {
	           //生成求购相关页面
	            out.println("正在生成求购相关页面............");
	            CreateStockInfoHtml cstock = new CreateStockInfoHtml();
	            cstock.builderProductDetail(conn,rootpath,number);
	            cstock.builderBiddingDetail(conn,rootpath,number);
	            out.println("生成求购相关页面结束............");
				    }
				    else if( createType=="4" || createType.equals("4") )
				    {
				        //生成人才库相关页面
		            CreateHrHtml chr = new CreateHrHtml();
		            chr.buildHrIndex(conn,rootpath);
		            out.println( "生成人才库相关页面结束............" );
				    }
				    else if(createType=="5" || createType.equals("5"))
				    {
		          //生成资讯相关页面
		            out.println("正在生成资讯相关页面............");
		            CreateNewsHtml cnews= new CreateNewsHtml();
		            cnews.buildIndex(conn,rootpath);
		            out.println("生成资讯相关页面结束............");
				     }
				     else if(createType=="6" || createType.equals("6"))
				     {
		            CreateSchoolHtml cschool = new CreateSchoolHtml();
		            cschool.buildIndex(conn,rootpath);
		            out.println("生成学院相关页面结束............");
				     }*/
				     
				  }
		   } catch (NumberFormatException e) 
		   {
	        out.println("e = " + e.toString());
	     }
	   out.println("<SCRIPT LANGUAGE=\"JAVASCRIPT\">\n"+"setTimeout('window.opener=null;window.close();',1000);"+"</SCRIPT>");
	%>
</h4>
	<center>
 </BODY>
</HTML>



