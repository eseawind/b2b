<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=GBK" %>
 
<%@ page import="java.util.*" %> 
<%@ page import="com.saas.biz.rightMgr.*" %> 
 
<%
    HttpSession  logsessions = request.getSession(); 
    String menu_id = "";
    String subsys_code="";
    String user_type="";
    String role_code="";
     
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
    if (request.getParameter("subsys_code") != null)
    {
        subsys_code = request.getParameter("subsys_code");
        HttpSession sessions = request.getSession();
        sessions.setAttribute("subsys_code",subsys_code);
    }
    else
    {
        if( logsessions.getAttribute("subsys_code")!= null)
		{
		  subsys_code=logsessions.getAttribute("subsys_code").toString();
		}
    }
    subsys_code = "CRM";
	if(menu_id == null || menu_id.equals(""))
	{
		if( logsessions.getAttribute("menu_id")!= null)
		{
		  menu_id=logsessions.getAttribute("menu_id").toString();
		}
	}
%> 
<%
    RightMenu RightMenuMgr = new RightMenu();
    HttpSession  logsession = request.getSession(); 
    String user_name = "";
    String user_class = "";
    String user_id = "";
     ArrayList firstMenuList = new ArrayList();
	  if(logsession.getAttribute("LINK_URL")!=null && !logsession.getAttribute("LINK_URL").equals(""))
	  {
	     String to_Url=logsession.getAttribute("LINK_URL").toString();
	     logsession.setAttribute("LINK_URL",null);
	     //out.println("<meta http-equiv='refresh'  content='0;url="+to_Url+"'>");
	  }
    if (logsession.getAttribute("SESSION_USER_NAME") != null)
    {
        user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
        user_class = logsession.getAttribute("SESSION_CUST_CLASS").toString();
        if (logsession.getAttribute("SESSION_ROLE_CODE")!= null) role_code = logsession.getAttribute("SESSION_ROLE_CODE").toString();
        user_type = logsession.getAttribute("SESSION_USER_TYPE").toString();
    }
	else
	{
		//out.println("<meta http-equiv='refresh'  content='0;url=/index.jsp'>");
	}
    firstMenuList = RightMenuMgr.genSuperRightMenuList(user_id,user_name,"1",user_class,subsys_code,user_type,role_code);
%>
<HTML>
<HEAD>
<script>

// this function is called if navigator is ready
function navigatorCreate(objNavigator,id)
{
  objNavigator.splitcolor = "#C4DAFA";
  objNavigator.splitarea  = true;
  objNavigator.width      = "200";
  objNavigator.splitwidth = 4;
  objNavigator.splittype  = 1;
  objNavigator.url        = "/rjzx.html";
  
  // now build the navigator
    <%
	    int n = 0;
	    if (firstMenuList != null && firstMenuList.size()>0)
	    {
	        for(Iterator it = firstMenuList.iterator(); it.hasNext();)
        	{
        		HashMap menuInfo = (HashMap)it.next();
        		String menuId = "";
        		String menuName = "";
        		n = n +1;
        		if (menuInfo.get("var") != null)
        			menuId =menuInfo.get("var").toString();
        		if (menuInfo.get("text") != null)	
        			menuName = menuInfo.get("text").toString();
    %>	 
             
      var item = objNavigator.createItem();
      item.text = "<%=menuName%>";
      item.image = "design/image/email.gif";
      <%
        if (n ==1)
        {
      %>
            item.active = true; 
      <%
        }
        else
       {
       %>
            item.active = false;
       <%
        }
       %>
       <%
        if (n >=6)
        {
      %>
            item.visible = false;
      <%
        }
        else
       {
       %>
            item.visible = true;
       <%
        }
       %>
      item.url = "/inc/secmenu.jsp?menuId=<%=menuId%>"; 
      objNavigator.add(item);                   
    <%  
            }
        }                  
    %>
  objNavigator.create();
}
</script>

</HEAD>
	<body>
			<jsp:include page="/inc/top.jsp" />
			<iframe id="navigator" src="/inc/navigator/pinNavigator.html" style="Z-INDEX: 101; LEFT: 26px; margin-right: 0px;POSITION: absolute; TOP: 175px;Width:950px;Height:800px"  frameborder="0" scrolling="no"></iframe>
			
			 
	</body>
</HTML>




