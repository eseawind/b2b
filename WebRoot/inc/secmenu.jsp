<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=GBK" %>
 
<%@ page import="java.util.*" %> 
<%@ page import="com.saas.biz.rightMgr.*" %> 
<script id=clientEventHandlersJS language=javascript>
<!--

function Button1_onclick(inurl) 
{
  parent.navigatorLoad(inurl);
}
function openPageFromOutside(inurl)
{
// pinNavigator is the id of the pinNavigator control
// you can also use document.getElementById(“pinNavigator”)
    navigator.contentWindow.navigatorLoad(inurl);
}
//-->
</script> 
 
<%
    HttpSession  logsessions = request.getSession(); 
    String menu_id = "";
    String subsys_code="";
    String user_type="";
    String role_code="";
    String menuId = "";
    if (request.getParameter("menuId") != null)
    {
        menuId = request.getParameter("menuId");
    } 
    if (request.getParameter("menuId") != null)
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
	     out.println("<meta http-equiv='refresh'  content='0;url="+to_Url+"'>");
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
		out.println("<meta http-equiv='refresh'  content='0;url=/index.jsp'>");
	}
    //firstMenuList = RightMenuMgr.genSuperRightMenuList(user_id,user_name,"1",user_class,subsys_code,user_type,role_code);
%>
 <link href="/style/left.css" rel="stylesheet" type="text/css"/>

  <table width=100% cellspacing="0" cellpadding="0" valign=right border=0 class="new-left">
    <tr>
        <th align="left">&nbsp;&nbsp;&nbsp;<img src="/admin/images/icon3_menu.gif" width="11" height="11" /><a href="/main.jsp">会员中心首页</a></th>
    </tr> 
     <TR>
    <th>
        
		 
		    <table width=100% cellspacing="0" cellpadding="0" border="0">	
    				    <%
    				        ArrayList secdMenuList = new ArrayList();
    				        String link = "";
    				        secdMenuList = RightMenuMgr.genchildRightMenuList(user_name,"2",menuId,user_class,role_code,user_type);
    				        if (secdMenuList != null && secdMenuList.size()>0)
            	    	    {
            	    	        for(Iterator secit = secdMenuList.iterator(); secit.hasNext();)
                        		{
                        			HashMap secmenuInfo = (HashMap)secit.next();
                        			String secmenuId = "";
                        			String secmenuName = "";
                        			String remark="";
                        			String images="";
                        			HashMap secmenuListMap = new HashMap();
                        			if (secmenuInfo.get("var") != null)
                        				secmenuId =secmenuInfo.get("var").toString();
                        			if (secmenuInfo.get("text") != null)	
                        				secmenuName = secmenuInfo.get("text").toString();   
                        		    if (secmenuInfo.get("image") != null)
                        		    {	
                        				images = secmenuInfo.get("image").toString(); 
                        		    }
                        		    else
                        		    {
                        		        images = "/images/menuimage/0249.gif";
                        		    }
                        		    if (images.equals("")) images = "/images/menuimage/0249.gif";
                        		     link = "/gettradeinterface.do?menu_id="+secmenuId+"&trade_type_code=0120";
									%> 								 	    
    								    <tr>     									   
        							        <td class="second_class_menu" onMouseOver=this.style.backgroundColor='#CCCCCC' onMouseOut=this.style.backgroundColor=''>
        							            <table width=100% cellspacing="0" cellpadding="0" border="0">
        							                <tr>
        							                     <td><img src="<%=images%>" width="30" height="30" border="0"/></td>
        							                     <td><a href="#" onclick="return openPageFromOutside('<%=link%>')" style="font-size:14px">
        							                        <%=secmenuName%></a>
        							                     </td>
        							                </tr>
        							            </table>
        							           <div style="width:150px; border-bottom:1px dashed #CCCCCC;"></div>
        							        </td>  	
    								    </tr>
								   <%
        			            }
        			        }
        			   %>    
			      </table>
  	</th>
    </TR> 
      <tr>
    <td class="bottom">
    <div style="display: none">对会员中心有意见或建议？<br /><img src="/admin/images/manager_ask.jpg" /></div> 
	 </td>
  </tr>
</table> 

 





