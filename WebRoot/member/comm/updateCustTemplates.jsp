<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<link href="/style/layout.css" rel="stylesheet" type="text/css"/>

<title>无标题文档</title>
</head>
<body>
	
	<%
		String cust_id="";
		if (session.getAttribute("SESSION_CUST_ID") != null) 
		{
			cust_id = session.getAttribute("SESSION_CUST_ID").toString();
		}
		String class_name = new CustClass().cust_Class_Value(cust_id);
		String name[] = class_name.split( "\\|" ); 
		 
		/*String name[] = new String[ class_name.length() ];
		for( int i = 0; i < 7; i++ )
			name[i]="";
		int count = 0;
		for( int i = 0; i < class_name.length()-1; i++ )
		{
			if( class_name.charAt(i) == '|')
			{
				count++;
				continue;
			}
			name[count] = name[count] + class_name.charAt(i);
		 
		}*/
	%>

		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
			<tr>
				<%
				String src1 = "",value1 = "",number ="";
				for( int i = 0; i < name.length; i++ )
				{
					name[i] = name[i].replaceAll( " ",   "");
					src1 = "/images/entimage/"+name[i]+".jpg";
					value1 = name[i];
					number ="";
					if( name[i].equals( "default" ) )
						number = "1";
					else
					{
						for( int j = 0; j < name[i].length(); j++ )
							if( name[i].charAt( j ) <= '9' && name[i].charAt(j) >= '0' )
								number = "" + name[i].charAt(j);
					}
					if( i == 4 )
						out.println("<tr>");
					 
				%>
                <td>
                	<table>
                		<tr><td colspan="2"><img src="<%=src1%>" width="166" height="166"/></td></tr>
                		<tr>
							<td align="right" height="30" valign="top">
								模板<%=number%>
							</td>
							<td align="right">
									<form name=modefrom<%=i%> action=/doTradeReg.do method=post target="_self">
									<input type="submit"  name="submit" value="点击应用">
									<input type="hidden" name="cust_id" value="<%=cust_id%>">
									<input type="hidden" name="mode_name" value="<%=value1%>">
									<input type="hidden" name="trade_type_code" value="1705"> 
									</form>
							</td>
						</tr>
					</table>
				</td>
			
				<%	
					 if( i == 3)
					 out.print( "</tr>");
				}
				%>
				
			
		</table>		
			

</body>
</html>





