
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
 
<link rel="stylesheet" type="text/css" href="/templates/default/style/supply.css" />
<%
	
	String cust_id = "",class_type="";
	//if(session.getAttribute("SESSION_CUST_ID")!=null){
	//	cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	//}
	if( request.getParameter( "class_type" ) != null )
	{
		class_type = request.getParameter( "class_type" );
	}
	
	InfoList infolist = new InfoList();
	ArrayList productList = infolist.getInfoListByClasstype( 0, 10, "2" );
	String class_id = "",class_name="",class_count=""; 
	out.print( "&nbsp;&nbsp;");
	if( productList != null && productList.size() > 0 )
	{
		for( int i = 0; i < productList.size(); i++ )
		{
			HashMap prodmap = ( HashMap )productList.get( i );
			
			if( prodmap.get( "class_id" ) != null )
			{
				class_id = prodmap.get( "class_id" ).toString();
			}
			 
			if( prodmap.get( "class_name" ) != null )
			{
				class_name = prodmap.get( "class_name" ).toString();
			}  
			if( prodmap.get( "class_count" ) != null )
			{
				class_count = prodmap.get( "class_count" ).toString();
			}
			out.print( " <a href=\"/default/product/class/" + class_id + "\" target=\"_blank\">"+ class_name +"</a>( "+class_count+ " )&nbsp;&nbsp;&nbsp;" ); 			 
			//	document.write("<li><a href='/default/product/class/ '> </a>( ) </li>");
		 
		}
	} 
	 
%>
 
 
 



