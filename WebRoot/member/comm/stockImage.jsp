<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo,java.util.*,tools.util.StringUtil;"%>

<%
  int i = 1;
  if( request.getParameter( "n" ) != null )
  {
 			i = Integer.parseInt(request.getParameter( "n" ));
 	}
  
	Stockorderinfo stockinfo = new Stockorderinfo();
	ArrayList stockList =  stockinfo.genStockByToday( 4 );
	if( stockList != null && stockList.size() > 0 )
	{
			  HashMap map = ( HashMap )stockList.get( i );
				  String stock_id =""; 
					String title="";  
					if( map.get( "stock_id" ) != null )
					{
						stock_id = map.get( "stock_id" ).toString();
					}
					if( map.get( "title" ) != null )
 					{
 						title =  map.get( "title" ).toString();
 						if( title.length() > 8 )
 						title = StringUtil.getLimitLengthString(title,"",16);
 					}
					 String filePath = new Stockorderinfo().getCustAttachPath( stock_id, "0");
					out.print( "<a href=/stock/stockInquiry.jsp?stock_id="+stock_id+"><img src=" + filePath + " width=81 height=50/></a><br>"+title);
			 
	}
	

%>



