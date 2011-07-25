<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo,java.util.*,tools.util.StringUtil;"%>

<%

	Stockorderinfo stockinfo = new Stockorderinfo();
	ArrayList stockList =  stockinfo.genStockByToday( 9 );
	
	if( stockList != null && stockList.size() > 0 )
	{
			for( int i = 2; i < stockList.size(); i++ )
			{
				  HashMap map = ( HashMap )stockList.get( i );
				  String stock_id =""; 
					String title ="";  
					if( map.get( "stock_id" ) != null )
					{
						stock_id = map.get( "stock_id" ).toString();
					}
					if( map.get( "title" ) != null )
					{
						title =  map.get( "title" ).toString();
						if( title.length() > 10 )
						title = StringUtil.getLimitLengthString(title,"",30);
					}
					out.print( "<div style=\"height: 22px;\"><a href=/stock/stockInquiry.jsp?stock_id=" + stock_id +">"+ title + "</a><img src=/images/news.gif></div>" );
			}
	}

%>




