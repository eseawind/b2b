  <%@ page import="com.base.db.DBConnectorBase,
                 com.base.db.DBConnectionManager,
                 com.base.config.ProjectConfig,
                 java.util.Vector,
                 com.saas.biz.commen.config,
                 com.bean.ProductClassInfo,
                 com.buildhtml.*"%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import="com.base.config.ProjectConfig"%>
<html>
 <HEAD>
  <title>B2B电子商务后台管理系统</title>
 </HEAD>
 <BODY>
 	<center>
 		<h4>  
		   
<%
    DBConnectorBase conn = DBConnectionManager.getInstance().getConnection(ProjectConfig.DBTITLE);
    config configFile= new config();
    configFile.init();
    //String rootpath = "/usr/www/saas/";//getServletConfig().getServletContext().getRealPath("/");
	String rootpath = configFile.getString("mysqlbase.rootpath");
	String  createType="";
	int number=0;
	if(request.getParameter("createType")!=null)
	{
		 createType=request.getParameter("createType");
	}
    if(request.getParameter("num")!=null)
	{
		number= Integer.parseInt(request.getParameter("num"));
	}
    //开始判断用户请求
    try 
    {
	if(createType!="" && createType!=null)
	{
	       CreateJs.buildAllJs(rootpath);
		   if(createType=="0" || createType.equals("0"))
			{
				CreateIndexHtml cindex = new CreateIndexHtml();
				out.println("<br>正在生成首页............");
				cindex.buildIndex(conn,rootpath);
				cindex.buildEnterpriseIndex(conn,rootpath);
				cindex.buildOrderIndex(conn,rootpath);
				cindex.buildSupplyIndex(conn,rootpath);
				CreateProductHtml cproduct = new CreateProductHtml();
				cproduct.builderProductDetail(conn,rootpath,number);
				out.println("<br>生成首页结束............");
			 
		        //生成企业库相关页面
		        CreateCustomerHtml ccustomer = new CreateCustomerHtml();
				ccustomer.createCustomer(conn,rootpath,number);
		     
			    //生成供应相关页面
		        out.println("正在生成供应相关页面............");
		        CreateSaleInfoHtml csale = new CreateSaleInfoHtml();
		        csale.builderSaleInfoDetail(conn,rootpath,number);
		        out.println("生成供应相关页面结束............");
		     
		        //生成求购相关页面
		        out.println("正在生成求购相关页面............");
		        CreateStockInfoHtml cstock = new CreateStockInfoHtml();
		        cstock.builderProductDetail(conn,rootpath,number);
		        cstock.builderBiddingDetail(conn,rootpath,number);
		        out.println("生成求购相关页面结束............");
		     
				//生成人才库相关页面
		        CreateHrHtml chr = new CreateHrHtml();
		        chr.buildHrIndex(conn,rootpath);
		        chr.buildJobList(conn,rootpath);
		        chr.buildRecJobList(conn,rootpath);
		        chr.buildResumeDetail(conn,rootpath,number);
		        chr.buildResumeList(conn,rootpath);
		        chr.buildEnterpriseDetail(conn,rootpath,number);
		        out.println("生成人才库相关页面结束............");
		     
		        //生成资讯相关页面
		        out.println("正在生成资讯相关页面............");
		        CreateNewsHtml cnews= new CreateNewsHtml();
		        cnews.buildIndex(conn,rootpath);
		        for(int i=1;i <=29 ;i++)
		        {
		            cnews.buildList(conn,rootpath,String.valueOf(i));
		        }
		        cnews.buildDetail(conn,rootpath,number);
		        out.println("生成资讯相关页面结束............");
		      
		        CreateSchoolHtml cschool = new CreateSchoolHtml();
		        cschool.buildIndex(conn,rootpath);
		        cschool.buildDetail(conn,rootpath,number);
		        ProductClassInfo pinfo = new ProductClassInfo();
		        Vector rvec = pinfo.getProductClassInfoVectorByClassType(conn,"8");
		        for(int i=0;i < rvec.size();i++)
		        {
		            ProductClassInfo pcinfo = (ProductClassInfo)rvec.get(i);
		            cschool.buildList(conn,rootpath,pcinfo.class_id);
		        }
		        for(int i=1;i < 4;i++)
		        {
		            cschool.buildThreeList(conn,rootpath,"0",i);
		        }
		        out.println("生成学院相关页面结束............");
		      
			    //生成产品详细页面
			     
	            cproduct.builderProductDetail(conn,rootpath,number);
		      
		        //供应信息详细页面
		           
                csale.builderSaleInfoDetail(conn,rootpath,number);
		      
		        //求购信息详细页面
 
                cstock.builderProductDetail(conn,rootpath,number);
		      
			    //招聘信息详细页面
			      
	            chr.buildEnterpriseDetail(conn,rootpath,number);
		      
		        //招标信息详细页面
			      
	            cstock.builderBiddingDetail(conn,rootpath,number);
		      
		        //求职信息详细页面
		        
                chr.buildResumeDetail(conn,rootpath,number);
		      
		        //资讯信息详细页面
		         
                cnews.buildDetail(conn,rootpath,number);
		      
		        //学院信息详细页面
		        
                cschool.buildDetail(conn,rootpath,number);
		     } 
	}
   } catch (NumberFormatException e) {
        out.println("e = " + e.toString());
}
   out.println("<SCRIPT LANGUAGE=\"JAVASCRIPT\">\n"+"setTimeout('window.opener=null;window.close();',1000);"+"</SCRIPT>");
%>
</h4>
<center>
 </BODY>
</HTML>
<%DBConnectionManager.getInstance().freeConnection(ProjectConfig.DBTITLE, conn);%>



