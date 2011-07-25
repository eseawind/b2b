
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<select name="mp">
	<option value=0 selected> 所有市场 </option>
<%
com.bizoss.util.DBConnection mpdbc = new com.bizoss.util.DBConnection(true);
com.bizoss.util.Charset mpcharset = new com.bizoss.util.Charset();
 dbc.getConnection();
java.sql.ResultSet mprs = dbc.getRS("select distinct marketplace from saasnews.agriprice");
while(mprs.next()){
 %>
 <option value='<%= charset.ISO_2_GBK(mprs.getString(1)) %>'><%= charset.ISO_2_GBK(mprs.getString(1)) %></option>
                <%
	}
	mprs=null;
mpdbc.close();
%>
</select>



