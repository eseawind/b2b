<%@ page import="java.sql.*" %>
<%
	Connection conn;
	Statement sqlstmt;
	ResultSet sqlrst;
	
	Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	conn=DriverManager.getConnection("jdbc:mysql://localhost/xxsjk_it?user=root&password=");
	sqlstmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);	
%>
<%!
	String native2Unicode(String s) { 
		if (s == null || s.length() == 0) { 
			return null; 
		} 
		byte[] buffer = new byte[s.length()]; 
		for (int i = 0; i < s.length(); i++) { 
			buffer[i] = (byte)s.charAt(i); 
		} 
			return new String(buffer); 
	} 
	
	String unicode2Native(String s) { 
		if (s == null || s.length() == 0) { 
			return null; 
		} 
		char[] buffer = new char[s.length() * 2]; 
		char c; 
		int j = 0; 
		for (int i = 0; i < s.length(); i++) { 
			if (s.charAt(i) >= 0x100) { 
				c = s.charAt(i); 
				byte []buf = (""+c).getBytes(); 
				buffer[j++] = (char)buf[0]; 
				buffer[j++] = (char)buf[1]; 
			} 
			else { 
				buffer[j++] = s.charAt(i); 
			} 
		} 
		return new String(buffer, 0, j); 
	} 
	
	
%>




