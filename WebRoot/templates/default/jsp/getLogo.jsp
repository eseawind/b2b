
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	config configFile = new config();
	configFile.init();
	String logourl = configFile.getString("logourl");
	String webtitle = configFile.getString("webtitle");
	String logolink = configFile.getString("logolink");
%>
		<div class="logo_img" style="filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='<%=logourl%>'">
			<h1>
				<a href="<%=logolink%>" title="<%=webtitle%>">
					<%=webtitle%>
				</a>
			</h1>
		</div>

 
 



