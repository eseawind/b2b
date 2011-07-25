<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page contentType="text/html;charset=GBK" %>
 
<%@ page import="java.util.*" %> 
<%@ page import="com.saas.biz.rightMgr.*" %> 
<%@ page import="com.saas.biz.menuguideMgr.MenuguideInfo" %> 
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
 
<%	
		MenuguideInfo menuguide = new MenuguideInfo();
		RightMenu RightMenuMgr = new RightMenu();
    HttpSession  logsessions = request.getSession(); 
    String up_menu_id = "";
    String subsys_code = ""; 
    String user_type="";
    String role_code="";
    String menu_class = "",cust_id="";     
    if (request.getParameter("up_menu_id") != null)
    {
        up_menu_id = request.getParameter("up_menu_id");
    }
    if (request.getParameter("subsys_code") != null)
    {
        subsys_code = request.getParameter("subsys_code");
        HttpSession sessions = request.getSession();
        sessions.setAttribute("subsys_code",subsys_code);
    }
    if (request.getParameter("menu_class") != null) 
	{
		menu_class = request.getParameter("menu_class");
	}
		if (logsessions.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsessions.getAttribute("SESSION_CUST_ID").toString();
    }
    String serIncludeJsp = "",menuIncludeJsp="";
    serIncludeJsp = bean.getJspBySubCode("41",subsys_code);
    ArrayList newsList = RightMenuMgr.getMenuInfo(up_menu_id);
    if(newsList!=null && newsList.size()>0){
    		HashMap newsMap = (HashMap)newsList.get(0);
    		if(newsMap.get("rsrv_str3")!=null){
    			menuIncludeJsp = newsMap.get("rsrv_str3").toString();
    		}
    }
    if(!menuIncludeJsp.equals("")&&!menu_class.equals("1")){
 %>
 			<jsp:include page="<%=menuIncludeJsp%>"></jsp:include>
			</br>
 <%
    }
    if(!serIncludeJsp.equals("")&&menu_class.equals("1")){
%> 	
			<jsp:include page="<%=serIncludeJsp%>"></jsp:include>
			</br>
<%	}
    
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
	if (Integer.parseInt(menu_class)<=1)
	{
        firstMenuList = RightMenuMgr.genSuperRightMenuList(user_id,user_name,menu_class,user_class,subsys_code,user_type,role_code);
    }
    else if (Integer.parseInt(menu_class)==2)
    {
        firstMenuList = RightMenuMgr.genchildRightMenuList(user_name,menu_class,up_menu_id,user_class,role_code,user_type);
    }
%>
       
   
	    	<%  
	    	    if (Integer.parseInt(menu_class)<3)
	    	    {
    	    	    if (firstMenuList != null && firstMenuList.size()>0)
    	    	    {
    	    	        for(Iterator it = firstMenuList.iterator(); it.hasNext();)
                		{
                			HashMap menuInfo = (HashMap)it.next();
                			String menuId = "";
                			String menuName = "";
                			String images="";
                			String desc="";
                			if (menuInfo.get("menu_id") != null)
                				menuId =menuInfo.get("menu_id").toString();
                			if (menuInfo.get("menu_name") != null)	
                				menuName = menuInfo.get("menu_name").toString();
                			if (menuInfo.get("rsrv_str9") != null)
                            {	
                            	images = menuInfo.get("rsrv_str9").toString(); 
                            }
                            else
                            {
                                images = "/images/menuimage/28.gif";
                            }
                            if (menuInfo.get("rsrv_str4") != null)
                            {	
                            	desc = menuInfo.get("rsrv_str4").toString(); 
                            }
                            
                            String inRsrv = "";
                            String iparam1 = "";
                            String iparam2 = "";
                            String iparam3 = "";
                            String ivalue1 = "";
                            String ivalue2 = "";
                            String ivalue3 = "";
                            if (menuInfo.get("in_param_code1") != null)  iparam1 = menuInfo.get("in_param_code1").toString(); 
                            if (menuInfo.get("in_param_code2") != null)  iparam2 = menuInfo.get("in_param_code2").toString(); 
                            if (menuInfo.get("in_param_code3") != null)  iparam3 = menuInfo.get("in_param_code3").toString();
                            if (menuInfo.get("in_param_value1") != null) ivalue1 = menuInfo.get("in_param_value1").toString();  
                            if (menuInfo.get("in_param_value2") != null) ivalue2 = menuInfo.get("in_param_value2").toString();  
                            if (menuInfo.get("in_param_value3") != null) ivalue3 = menuInfo.get("in_param_value3").toString();  
            				if (!iparam1.equalsIgnoreCase(""))
            				{
            					inRsrv = inRsrv + "?"+iparam1+"="+ivalue1;
            				}else{
            				    inRsrv = inRsrv + "?";
            				}
            				if (!iparam2.equalsIgnoreCase(""))
            				{
            					inRsrv = inRsrv + "&"+iparam2+"="+ivalue2;
            				}
            				if (!iparam3.equalsIgnoreCase(""))
            				{
            					inRsrv = inRsrv + "&"+iparam3+"="+ivalue3;
            				}
                            if (images.equals("")) images = "/images/menuimage/28.gif";	
            %>
	    	 
			
			     <div class="mid-nrone1">
                  <div class="mid-nrone2"  onmouseover="this.style.backgroundColor='#FFCC66'" onmouseout="this.style.backgroundColor='#FFFFFF'"> 
                    <div class="mid-nrone4"><img src="<%=images%>" width="51" height="55" /></div>
                    <div class="mid-nrone5"> 
                      <div class="mid-nrone6">
                        <a href="/main.jsp<%=inRsrv%>&menu_id=<%=menuId%>&menu_class=<%=Integer.parseInt(menu_class)+1%>&subsys_code=<%=subsys_code%>"><%=menuName%></a>
                        </div>
                      <div class="mid-nrone7"><%=desc%></div>
                    </div>
                    <div class="mid-nrone8">
                       <%
        				        ArrayList secdMenuList = new ArrayList();
        				        secdMenuList = RightMenuMgr.genchildRightMenuList(user_name,String.valueOf(Integer.parseInt(menu_class)+1),menuId,user_class,role_code,user_type);
        				        if (secdMenuList != null && secdMenuList.size()>0)
                	    	    {
                	    	        int s = 0;
                	    	        for(Iterator secit = secdMenuList.iterator(); secit.hasNext();)
                            		{
                            			s = s +1;
                            			HashMap secmenuInfo = (HashMap)secit.next();
                            			String secmenuId = "";
                            			String secmenuName = "";
                            			String remark="";
                            			//HashMap secmenuListMap = new HashMap();
                            			if (secmenuInfo.get("menu_id") != null)
                            				secmenuId =secmenuInfo.get("menu_id").toString();
                            			if (secmenuInfo.get("menu_name") != null)	
                            				secmenuName = secmenuInfo.get("menu_name").toString();   
                            		    if (Integer.parseInt(menu_class)<2)
                            		    { 
    									%> 								 	    
        								   <a href="/main.jsp?menu_id=<%=secmenuId%>&menu_class=<%=Integer.parseInt(menu_class)+2%>&subsys_code=<%=subsys_code%>"><%=secmenuName%></a>
    								    <%
    								    } 
    								    else if (Integer.parseInt(menu_class)>=2)
    								    {
	    								   
	    								    %>
	    								        <a href="/gettradeinterface.do?menu_id=<%=secmenuId%>&trade_type_code=0120" TARGET=appwin onclick="mydefss()"><%=secmenuName%></a>
	    								    <%
	    								   
    								    }
    								   if (s>=3) break;
            			            }
            			        }
            			   %>  
                    </div>
                  </div>
                  <div class="mid-nrone3"></div>
                </div>
            <%
                        }
                    }
                }
                else
                {
                    ArrayList thirdMenuList = new ArrayList();
                    thirdMenuList = RightMenuMgr.genchildRightMenuList(user_name,"3",up_menu_id,user_class,role_code,user_type);
                    
                    if (thirdMenuList != null && thirdMenuList.size()>0)
                    {
                        for(Iterator thit = thirdMenuList.iterator(); thit.hasNext();)
                    	{
                    		HashMap thmenuInfo = (HashMap)thit.next();
                    		String thmenuId = "";
                    		String thmenuName = "";
                    		String thmenudesc="";
                    		String rsrv_str1="";
                    		if (thmenuInfo.get("menu_id") != null)
                    			thmenuId =thmenuInfo.get("menu_id").toString();
                    		if (thmenuInfo.get("menu_name") != null)	
                    			thmenuName = thmenuInfo.get("menu_name").toString();   
                    		if (thmenuInfo.get("rsrv_str4") != null)	
                    			thmenudesc = thmenuInfo.get("rsrv_str4").toString();
                    		if (thmenuInfo.get("rsrv_str1") != null)	
                    			rsrv_str1 = thmenuInfo.get("rsrv_str1").toString();      
                  			 ArrayList guideList = menuguide.getLevelListByCustEntity(cust_id,subsys_code,thmenuId); 
                  			 //out.println(guideList);
                  			 String note_name="",note_desc="",link_url="",obj_cust_id="",param_code="";
                  			 if(guideList!=null && guideList.size()>0){
	                  			 HashMap guideMap = (HashMap)guideList.get(0);
	                  			 if(guideMap.get("note_name")!=null){note_name = guideMap.get("note_name").toString();}
	                  			 if(guideMap.get("note_desc")!=null){note_desc = guideMap.get("note_desc").toString();}
	                  			 if(guideMap.get("link_url")!=null){link_url = guideMap.get("link_url").toString();}
	                  			 if(guideMap.get("obj_cust_id")!=null){obj_cust_id = guideMap.get("obj_cust_id").toString();}
	                  			 if(guideMap.get("param_code")!=null){param_code = guideMap.get("param_code").toString();}
                  			 }
                  			 if(guideList == null){
                  			 
                %>
                     
                     <div class="mid-nrone1"> 
                      	<div class="mid-nrone2" onmouseover="this.style.backgroundColor='#FFCC66'" onmouseout="this.style.backgroundColor='#FFFFFF'">
				                        	<div class="mid-nrone4">
				                        			<img src="images/mid-06.gif" width="51" height="55" />
				                        	</div>
                        	
                        					<div class="mid-nrone5"> 
					                          		<div class="mid-nrone6">
					                          				<%if(rsrv_str1=="0" || rsrv_str1.equals("0"))
					                          				{
					                          				%>
																								<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" target="_blank"><%=thmenuName%></a>
											 											<%
					                            			}else{
					                           				%>
					                             					<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onclick="mydefss()"><%=thmenuName%></a>
					                          				<%
					                          				}
					                          				%>
					                           		</div>
                          							<div class="mid-nrone7">
                          									<%=thmenudesc%>
                          							</div>
                        					</div>
                      		</div>
                    </div>    
                      
                     
                <%    	
                			}else{
                					if(obj_cust_id=="" || obj_cust_id.equals("")){
                %>
                					      						
                					
                		<div class="mid-nrone1"> 
                      	<div class="mid-nrone2" onmouseover="this.style.backgroundColor='#FFCC66'" onmouseout="this.style.backgroundColor='#FFFFFF'">
				                        	<div class="mid-nrone4">
				                        			<img src="images/mid-06.gif" width="51" height="55" />
				                        	</div>
                        	
                        					<div class="mid-nrone5"> 
					                          		<div class="mid-nrone6">
																							<font color="#a9a9a9"><%=param_code%></font>
					                           		</div>
                          							<div class="mid-nrone7">
                          								<a href="<%=link_url%>" TARGET=appwin onclick="mydefss()"><font color="red"><b><%=note_name%></b></font></a></br>
                          									<%=note_desc%>
                          							</div>
                        					</div>
                      		</div>
                    </div> 
                					
                					
                					
                <%
                				  }else{
                %>
                			<div class="mid-nrone1"> 
                      	<div class="mid-nrone2" onmouseover="this.style.backgroundColor='#FFCC66'" onmouseout="this.style.backgroundColor='#FFFFFF'">
				                        	<div class="mid-nrone4">
				                        			<img src="images/mid-06.gif" width="51" height="55" />
				                        	</div>
                        	
                        					<div class="mid-nrone5"> 
					                          		<div class="mid-nrone6">
					                          				<%if(rsrv_str1=="0" || rsrv_str1.equals("0"))
					                          				{
					                          				%>
																								<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onclick="mydefss()"><%=thmenuName%></a>
											 											<%
					                            			}else{
					                           				%>
					                             					<a href="/gettradeinterface.do?menu_id=<%=thmenuId%>&trade_type_code=0120" TARGET=appwin onclick="mydefss()"><%=thmenuName%></a>
					                          				<%
					                          				}
					                          				%>
					                           		</div>
                          							<div class="mid-nrone7">
                          									<%=thmenudesc%>
                          							</div>
                        					</div>
                      		</div>
                    </div>  
                					
                <%				}
                				}
                    	}
                    }
                }
            %> 
            
 





