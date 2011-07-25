<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="classInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
  String type="",level="";
  if(request.getParameter("type")!=null){
    type=request.getParameter("type");
  }
  if(request.getParameter("level")!=null){
    level=request.getParameter("level");
  }
  String select=classInfo.getSelectedByComm(type,level);
%>
<td>
	<select name="x_class_id" id="x_class_id" style="width: 125px">
		<option value="0">
			«Î—°‘Ò...
		</option>
		<%=select%>
	</select>
</td>




