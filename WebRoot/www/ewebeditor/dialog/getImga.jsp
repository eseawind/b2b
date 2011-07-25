<%@ page contentType="text/html;charset=GBK" language="java"%>
<jsp:useBean id="attaBean" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%@ page import="java.util.*"%>
<%
String ImgUrl="/upload/default.gif";
String root_id="";
if(request.getParameter("root_id")!=null)
{
	 root_id=request.getParameter("root_id");
	 ArrayList list=attaBean.getAttachInfoByList(root_id);
	 if(list !=null && list.size()>0){
           for(int i=0;i<list.size();i++){
             HashMap map=(HashMap)list.get(0);
             String file_path="";
             if(map.get("file_path")!=null){
               file_path=map.get("file_path").toString();
               //file_path=file_path.substring(23);
               ImgUrl=file_path;
             }
      }
}
}
out.print(ImgUrl);
%>




