<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comm" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<html>
	<head>
		<title>upload</title>
	</head>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<%
			String root_id = "";
			if (request.getParameter("idx") != null) {
				root_id = request.getParameter("idx");
			}
			ArrayList list = comm.getAttachInfoByList(root_id);
		%>
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
				<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;height: 25px" align="center" height="15px">
				</td>
				<td bgcolor="#FFFFFF" align="left" width="85%">
                  <%
                    if(list !=null && list.size()>0){
                      for(int i=0;i<list.size();i++){
                        HashMap map=(HashMap)list.get(i);
                        String attach_id=map.get("attach_id").toString();
                        String attach_name="",file_path="";
                        if(map.get("attach_name")!=null){
                          attach_name=map.get("attach_name").toString();
                        }
                        if(map.get("file_path")!=null){
                          file_path=map.get("file_path").toString();
                          file_path=file_path.substring(23);
                        }
                       %>
                       <a href="<%=file_path%>" target="_self"><img src=/img/attach.gif  border=0 style="cursor: hand" alt="ÏÂÔØ¸½¼þ"></a>&nbsp;&nbsp;<a href="/doTradeReg.do?trade_type_code=1157&attach_id=<%=attach_id%>" target="_blank">É¾³ý</a>&nbsp;&nbsp;
                       <%
                       if(i%2==0){
                        out.print("<br>");
                       }
                      }
                    }
                  %>
				</td>
			</tr>
		</table>
	</body>
</html>




