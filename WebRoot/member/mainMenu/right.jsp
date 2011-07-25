<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
<%@ page import="tools.util.StringUtil"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%@ page import="com.saas.biz.stockorderMgr.*"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电子商务室</title>
        <style type="text/css">
BODY {
	MARGIN: 0px 0px 0px 0px
}
.t1 a:link,.t1 a:visited{color: #003399;text-decoration: none; font-size:11px; }
.t1 a:hover{color: #0066CC;text-decoration: underline; font-size:11px;}
.t3 a:link,.t3 a:visited{color: #ffffff;text-decoration: none; font-size:14px; font-weight:bold; }
.t3 a:hover{color: #ffffff;text-decoration: underline; font-size:14px; font-weight:bold;}
	.t2{font-size:10px; color:#666666;}
</style>
</head>
	<body >
    <table width="100%" bgcolor="#dcedfc"><tr><td>
					 <%
			            String ch_name="";
			            String save_dir="";
			            String ch_id="7830633062";
                        ChannelInfo channelinfo = new ChannelInfo();
    		            ArrayList supplyList = channelinfo.getChannel(ch_id);
    		            if (supplyList != null && supplyList.size() > 0) {
			             HashMap skmap = (HashMap) supplyList.get(0);
			             if (skmap.get("ch_name") != null) {
											ch_name = skmap.get("ch_name").toString();
										}
								   if (skmap.get("save_dir") != null) {
									  save_dir = skmap.get("save_dir").toString();
									 }
								} 
           	%>
    <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0" >
			<tr align="left" style="background:url(/member/mainMenu/images/left_03.gif);">
				<td width="8%" height="31">&nbsp;<img src="/member/mainMenu/images/tb.jpg" align="absmiddle"/></td>
		      <td width="92%" class="t3"><a href="/<%=save_dir%>" target="_blank" ><%=ch_name%></a></td></tr></table>
               <table width="96%" align="center">
           <%
						 InfoList info=new InfoList();
						 ArrayList supList =  info.getInfoList(0,5,ch_id);
						 String info_id="";
						 String title1="";
						 String pub_date="";
						 if (supList != null && supList.size() > 0) {
							  for (int i = 0; i < supList.size(); i++) {
										HashMap skmap = (HashMap) supList.get(i);
										if (skmap.get("info_id") != null) {
											info_id = skmap.get("info_id").toString();
										}
										if (skmap.get("title") != null) {
											title1 = skmap.get("title").toString();
											if (title1.length() > 10)
												title1 = StringUtil.getLimitLengthString(title1, "", 20) + "...";
										}
										if (skmap.get("pub_date") != null) {
											 pub_date = skmap.get("pub_date").toString();
											 if (pub_date.length() > 10) {
										   pub_date = pub_date.substring(5, 10);
											 }
								  	}
	       %>
                     <TR>
								<TD width="5%"><img src="/member/mainMenu/images/lujian_1.gif" align="absmiddle"/>		</TD>
							 <TD width="80%" class="t1"><a href="/<%=save_dir%>/d/content-<%=info_id%>.html" target="_blank"><%=title1%></a></TD>
						<TD width="15%" class="t2"><%=pub_date%></TD>
				</TR>
         <%}}%>                 	
		</TABLE>
					<%
					  ch_id="6871426767";
						ArrayList stockList= channelinfo.getChannel(ch_id);
		        if (stockList != null && stockList.size() > 0) {
			          HashMap map = (HashMap) stockList.get(0);
			          if (map.get("ch_name") != null) {
						    ch_name = map.get("ch_name").toString();
						    }
						    if (map.get("save_dir") != null) {
                save_dir = map.get("save_dir").toString();
							  }
						}                    
					%>
        <br />
   <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
			<tr align="left" style="background:url(/member/mainMenu/images/left_03.gif);">
				<td width="8%" height="31">&nbsp;<img src="/member/mainMenu/images/tb.jpg" align="absmiddle"/></td>
		      <td width="92%" class="t3"><a href="/<%=save_dir%>" target="_blank" ><%=ch_name%></a></td></tr></table>
              <table width="96%" align="center">
           <%
  					stockList =  info.getInfoList(0,5,ch_id);
						if (stockList != null && stockList.size() > 0) {
						for (int i = 0; i < stockList.size(); i++) {
						  HashMap skmap = (HashMap) stockList.get(i);
					   	if (skmap.get("info_id") != null) {
							info_id = skmap.get("info_id").toString();
						  }
							if (skmap.get("title") != null) {
							title1 = skmap.get("title").toString();
								if (title1.length() > 10)
								title1 = StringUtil.getLimitLengthString(title1, "", 20) + "...";
							}
							if (skmap.get("pub_date") != null) {
							   pub_date = skmap.get("pub_date").toString();
							if (pub_date.length() > 10) {
						    	pub_date = pub_date.substring(5, 10);
							}
						}
				%>
															 <TR>
			 <TD width="5%"><img src="/member/mainMenu/images/lujian_1.gif" align="absmiddle"/></TD>
		 <TD width="80%" class="t1"><a href="/<%=save_dir%>/d/content-<%=info_id%>.html" target="_blank"><%=title1%></a></TD>
		<TD width="15%" class="t2"><%=pub_date%></TD>
	</TR>
  	<%	}	 }  %>              	
</table>
					<%
					    ch_id="0531586180";
							ArrayList newsList = channelinfo.getChannel(ch_id);
		          if (newsList != null && newsList.size() > 0) {
			           HashMap skmap = (HashMap) newsList.get(0);
			           if (skmap.get("ch_name") != null) {
										ch_name = skmap.get("ch_name").toString();
							  	}
								 if (skmap.get("save_dir") != null) {
									save_dir = skmap.get("save_dir").toString();
								 }
							} 
					%>					
    <br />
   <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
			<tr align="left" style="background:url(/member/mainMenu/images/left_03.gif);">
				<td width="8%" height="28">&nbsp;<img src="/member/mainMenu/images/tb.jpg" align="absmiddle"/></td>
		      <td width="92%" class="t3"><a href="/<%=save_dir%>" target="_blank" ><%=ch_name%></a></td></tr></table>
              <table width="96%" align="center">
            <%
                newsList =  info.getInfoList(0,5,ch_id);
						    if (newsList != null && newsList.size() > 0) {
									for (int i = 0; i < newsList.size(); i++) {
									 HashMap skmap = (HashMap) newsList.get(i);
									 if (skmap.get("info_id") != null) {
									  	info_id = skmap.get("info_id").toString();
									 }
									 if (skmap.get("title") != null) {
										 title1 = skmap.get("title").toString();
										 if (title1.length() > 10)
										 title1 = StringUtil.getLimitLengthString(title1, "", 20) + "...";
									}
									if (skmap.get("pub_date") != null) {
									   pub_date = skmap.get("pub_date").toString();
										 if (pub_date.length() > 10) {
											  pub_date = pub_date.substring(5, 10);
											}
								}
           %>
                <TR>
							<TD width="5%"><img src="/member/mainMenu/images/lujian_1.gif" align="absmiddle"/></TD>
						 <TD width="80%" class="t1"><a href="/<%=save_dir%>/d/content-<%=info_id%>.html" target="_blank"><%=title1%></a></TD>
						<TD width="15%" class="t2"><%=pub_date%></TD>
					</TR>
            <%}}%>
                        
		</TABLE>
		</TD></Tr></Table>							
</body>
</html>



