  <%@ page import="com.base.db.DBConnectorBase,
                 com.base.db.DBConnectionManager,
                 com.base.config.ProjectConfig,
                 java.util.Vector,
                 com.bean.ProductClassInfo,
                 com.buildhtml.*"%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<HTML>
 <HEAD>
  <title>B2B电子商务后台管理系统</title>
 </HEAD>
 <BODY>
 	<center>
 		<h4>
		   
<%
    DBConnectorBase conn = DBConnectionManager.getInstance().getConnection(ProjectConfig.DBTITLE);
    String rootpath = "/usr/www/saas/";//getServletConfig().getServletContext().getRealPath("/");
  %>
  <input type="text" name="paths" value=<%=rootpath%>>
  <%
    if(request.getParameter("action")!=null && request.getParameter("action").equals("do")){
        ProductClassInfo pinfo = new ProductClassInfo();
        try {
            int productnum = Integer.parseInt(request.getParameter("product"));
            int enterprisenum = Integer.parseInt(request.getParameter("enterprise"));
            int supplynum = Integer.parseInt(request.getParameter("supply"));
            int stocknum = Integer.parseInt(request.getParameter("stock"));
            int biddingnum = Integer.parseInt(request.getParameter("bidding"));
            int jobnum = Integer.parseInt(request.getParameter("job"));
            int zpnum = Integer.parseInt(request.getParameter("zp"));
            int newsnum = Integer.parseInt(request.getParameter("news"));
            int schoolnum = Integer.parseInt(request.getParameter("school"));

            //生成前四个频道首页
            CreateIndexHtml cindex = new CreateIndexHtml();
            out.println("正在生成首页............");
            cindex.buildIndex(conn,rootpath);
            out.println("生成首页结束............");
            out.println("正在生成企业首页............");
            cindex.buildEnterpriseIndex(conn,rootpath);
            out.println("生成企业首页结束............");
            out.println("正在生成求购首页............");
            cindex.buildOrderIndex(conn,rootpath);
            out.println("生成求购首页结束............");
            out.println("正在生成供应首页............");
            cindex.buildSupplyIndex(conn,rootpath);
            out.println("生成供应首页结束............");
            //生成学院相关页面
            out.println("正在生成学院相关页面............");

            CreateSchoolHtml cschool = new CreateSchoolHtml();
            cschool.buildIndex(conn,rootpath);
            cschool.buildDetail(conn,rootpath,schoolnum);
            Vector rvec = pinfo.getProductClassInfoVectorByClassType(conn,"8");
            for(int i=0;i < rvec.size();i++){
                ProductClassInfo pcinfo = (ProductClassInfo)rvec.get(i);
                cschool.buildList(conn,rootpath,pcinfo.class_id);
            }
            for(int i=1;i < 4;i++){
                cschool.buildThreeList(conn,rootpath,"0",i);
            }
            out.println("生成学院相关页面结束............");
            //生成资讯相关页面
            out.println("正在生成资讯相关页面............");
            CreateNewsHtml cnews= new CreateNewsHtml();
            cnews.buildIndex(conn,rootpath);
            for(int i=1;i <=29 ;i++){
                cnews.buildList(conn,rootpath,String.valueOf(i));
            }
            cnews.buildDetail(conn,rootpath,newsnum);
            out.println("生成资讯相关页面结束............");

            out.println("正在生成人才库相关页面............");
            //生成人才库相关页面
            CreateHrHtml chr = new CreateHrHtml();
            chr.buildHrIndex(conn,rootpath);
            chr.buildJobList(conn,rootpath);
            chr.buildRecJobList(conn,rootpath);
            chr.buildRecJobList(conn,rootpath);
            chr.buildResumeDetail(conn,rootpath,jobnum);
            chr.buildResumeList(conn,rootpath);
            chr.buildEnterpriseDetail(conn,rootpath,zpnum);
            out.println("生成人才库相关页面结束............");


            out.println("正在生成求购相关页面............");
            //生成求购相关页面
            CreateStockInfoHtml cstock = new CreateStockInfoHtml();
            cstock.builderProductDetail(conn,rootpath,stocknum);
            cstock.builderBiddingDetail(conn,rootpath,biddingnum);
            out.println("生成求购相关页面结束............");
            //生成供应相关页面
            out.println("正在生成供应相关页面............");
            CreateSaleInfoHtml csale = new CreateSaleInfoHtml();
            csale.builderSaleInfoDetail(conn,rootpath,supplynum);

            out.println("生成供应相关页面结束............");
            //生成产品相关页面
            out.println("正在生成产品相关页面............");
            CreateProductHtml cproduct = new CreateProductHtml();
            cproduct.builderProductDetail(conn,rootpath,productnum);

            out.println("生成产品相关页面结束............");
            //生成企业相关页面
            out.println("正在生成企业相关页面............");
            CreateCustomerHtml ccustomer = new CreateCustomerHtml();
            ccustomer.createCustomer(conn,rootpath,enterprisenum);
            out.println("生成企业相关页面结束............");

            CreateJs.buildAllJs(rootpath);

        } catch (NumberFormatException e) {
            out.println("e = " + e.toString());
        }
    }else{
        if(request.getParameter("action")!=null){
            String action = request.getParameter("action");

            if(action.equals("product")){
                int productnum = Integer.parseInt(request.getParameter("product"));
                CreateProductHtml cproduct = new CreateProductHtml();
                cproduct.builderProductDetail(conn,rootpath,productnum);
            }
            if(action.equals("enterprise")){
                int enterprisenum = Integer.parseInt(request.getParameter("enterprise"));
                CreateCustomerHtml ccustomer = new CreateCustomerHtml();
                ccustomer.createCustomer(conn,rootpath,enterprisenum);
            }
            if(action.equals("supply")){
                int supplynum = Integer.parseInt(request.getParameter("supply"));
                CreateSaleInfoHtml csale = new CreateSaleInfoHtml();
                csale.builderSaleInfoDetail(conn,rootpath,supplynum);
            }
            if(action.equals("stock")){
                int stocknum = Integer.parseInt(request.getParameter("stock"));
                CreateStockInfoHtml cstock = new CreateStockInfoHtml();
                cstock.builderProductDetail(conn,rootpath,stocknum);
            }
            if(action.equals("bidding")){
                int biddingnum = Integer.parseInt(request.getParameter("bidding"));
                CreateStockInfoHtml cstock = new CreateStockInfoHtml();
                cstock.builderBiddingDetail(conn,rootpath,biddingnum);
            }
            if(action.equals("job")){
                int jobnum = Integer.parseInt(request.getParameter("job"));
                CreateHrHtml chr = new CreateHrHtml();
                chr.buildResumeDetail(conn,rootpath,jobnum);
            }
            if(action.equals("zp")){
                int zpnum = Integer.parseInt(request.getParameter("zp"));
                CreateHrHtml chr = new CreateHrHtml();
                chr.buildEnterpriseDetail(conn,rootpath,zpnum);
            }
            if(action.equals("news")){
                int newsnum = Integer.parseInt(request.getParameter("news"));
                CreateNewsHtml cnews= new CreateNewsHtml();
                cnews.buildDetail(conn,rootpath,newsnum);
            }
            if(action.equals("school")){
                int schoolnum = Integer.parseInt(request.getParameter("school"));
                CreateSchoolHtml cschool = new CreateSchoolHtml();
                cschool.buildDetail(conn,rootpath,schoolnum);
            }
             if(action.equals("js")){
                CreateJs.buildAllJs(rootpath);
            }
        }
    }
%>
</h4>
<center>
 </BODY>
</HTML>
<%DBConnectionManager.getInstance().freeConnection(ProjectConfig.DBTITLE, conn);%>



