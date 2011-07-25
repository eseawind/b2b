<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo,com.saas.intf.InfoIntf"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@page pageEncoding="gbk"%>   
<%request.setCharacterEncoding("gbk");%>
 
<%
   String timeRange="";
   String keywords="";
   String div="";
   String searchtype="";
   if(request.getParameter("div")!=null)
   {
    	div=request.getParameter("div");
   }
   if(request.getParameter("para1")!=null)
   {
    	timeRange=request.getParameter("para1");
   }
   if(request.getParameter("para2")!=null)
   {
    	keywords=request.getParameter("para2");
   }
   if(request.getParameter("para3")!=null)
   {
    	searchtype=request.getParameter("para3");
   }
   //out.print( "searchtype=" + searchtype );
   InfoIntf savedirInfo =  new InfoIntf();
   String save_dir = "";
    int counter=0;
	String pagtool="",iStart="1";
   if("searchJob".equals(div))
   {
   		if( "job".equals(searchtype) )
		{
			 
		   JobInfo jobObj = new JobInfo();
		  
		   if(request.getParameter("iStart")!=null)
		   {
				iStart=request.getParameter("iStart");
		   }
		   ArrayList jobList = jobObj.genJobBySearch(Integer.parseInt(iStart),20,keywords,timeRange);
		   //out.print( "jobList = " + jobList);
		   counter=jobObj.genJobBySearch(keywords,timeRange);
		   //String urlStr=encodeURI("jobSearch.html?timeRange="+timeRange+"&keywords="+keywords+"&iStart=");
		   pagtool=tools.getGoogleToolsBar(counter,"jobSearch.html?timeRange="+timeRange+"&keywords="+keywords+"&searchtype="+searchtype+"&iStart=",Integer.parseInt(iStart),20);
		   //pagtool=tools.getGoogleToolsBar(counter,urlStr,Integer.parseInt(iStart),5);	 
		   
		  
		   if(jobList!=null)
		   {
		   	   out.print("<table width=65% border=0 align=center cellpadding=0 cellspacing=0>");
			   out.print("<tr>");
			   out.print("<td width=22% class=list_right_cp_lmt>职位名称</td>");
			   out.print("<td width=10% class=list_right_cp_lmt>类别</td>");
			   out.print(" <td width=20% class=list_right_cp_lmt>招聘公司</td>");
			   out.print("<td width=20% class=list_right_cp_lmt>工作地点</td>");
			   out.print("<td width=14% class=list_right_cp_lmt align=center>发布日期</td>");
			   out.print("</tr>");
			   out.print("<tr height=10>");
			   out.print("</tr>");
			   for(int i=0;i<jobList.size();i++)
			   {
				   String title="",job_id="",publish_date="",job_addr="",cust_name="",para_code2="";
				   HashMap map=(HashMap) jobList.get(i);
				  if (map.get("title")!= null)
			      {
					 title = map.get("title").toString();				
			       }
				  if (map.get("job_id")!= null)
				  {
						 job_id = map.get("job_id").toString();				
				  }
				  if (map.get("job_addr")!= null)
				  {
						 job_addr = map.get("job_addr").toString();				
				  }
				  if (map.get("cust_name")!= null)
				  {
						 cust_name = map.get("cust_name").toString();				
				  }
				  if (map.get("para_code2")!= null)
				  {
						 para_code2 = map.get("para_code2").toString();				
				  }
				  if (map.get("publish_date") != null)
				  {
						publish_date = map.get("publish_date").toString();
						if(publish_date.length()>10)
						publish_date=publish_date.substring(0,10);
				  }
				  save_dir = savedirInfo.getChannelSaveDirByInfoId( job_id );
				   out.print("<tr>");
				   out.print("<td  class=list_right_cp_lmt><a href=/"+save_dir+"/d/content-"+job_id+".html >"+title+"</a></td>");
				   out.print("<td  class=list_right_cp_lmt>"+para_code2+"</td>");
				   out.print("<td  class=list_right_cp_lmt>"+cust_name+"</td>");
				   out.print("<td  class=list_right_cp_lmt>"+job_addr+"</td>");
				   out.print("<td  class=list_right_cp_lmt align=center>"+publish_date+"</td>");
				   out.print("</tr>");
			   }
			   out.print("<tr>");
			   out.print("<td colspan=3 align=right>");
			   out.print(pagtool);
			   out.print("</td>");
			   out.print("</tr>");
			}
			else
			{
				out.print("<table width=65% height=300  border=0 align=center cellpadding=0 cellspacing=0>对不起！没有找到您要信息。</table>"); 
			}
		}
		else if( "resume".equals(searchtype) )
		{
		   
		   ResumeInfo reObj = new ResumeInfo();
		   
		   if(request.getParameter("iStart")!=null)
		   {
				iStart=request.getParameter("iStart");
		   }
		   
		   ArrayList reList = reObj.genResumeBySearch(Integer.parseInt(iStart),20,keywords,timeRange);
		   counter = reObj.genResumeBySearch(keywords,timeRange);
		   
		   pagtool = tools.getGoogleToolsBar(counter,"jobSearch.html?timeRange="+timeRange+"&keywords="+keywords+"&searchtype="+searchtype+"&iStart=",Integer.parseInt(iStart),20);
		   
		   if(reList != null )
		   {
		   		out.print("<table width=65% border=0 align=center cellpadding=0 cellspacing=0>");
			   out.print("<tr>");
			   out.print("<td width=12% class=list_right_cp_lmt>姓名</td>");
			   out.print("<td width=20% class=list_right_cp_lmt>专业</td>");
			   out.print(" <td width=20% class=list_right_cp_lmt>毕业院校</td>");
			   out.print("<td width=20% class=list_right_cp_lmt>工作年限</td>");
			   out.print("<td width=14% class=list_right_cp_lmt align=center>更新日期</td>");
			   out.print("</tr>");
			   out.print("<tr height=10>");
			   out.print("</tr>");
			   for( int i = 0; i < reList.size(); i++ )
			   {
				   String name="",resume_id="",update_date="",job_age="",profession="",grad_from = "";
				   HashMap map=(HashMap) reList.get( i );
				  if (map.get("resume_id")!= null)
			      {
					 resume_id = map.get("resume_id").toString();				
			       }
				  if (map.get("name")!= null)
				  {
						 name = map.get("name").toString();				
				  }
				  if (map.get("job_age")!= null)
				  {
						 job_age = map.get("job_age").toString();				
				  }
				  if (map.get("profession")!= null)
				  {
						 profession = map.get("profession").toString();				
				  }
				  if (map.get("grad_from")!= null)
				  {
						 grad_from = map.get("grad_from").toString();				
				  }
				  if (map.get("update_date") != null)
				  {
						update_date = map.get("update_date").toString();
						if(update_date.length()>10)
							update_date=update_date.substring(0,10);
				  }
				   save_dir = savedirInfo.getChannelSaveDirByInfoId( resume_id );
				   out.print("<tr>");
				   out.print("<td  class=list_right_cp_lmt><a href=/"+save_dir+"/d/content-" + resume_id + ".html >" + name + "</a></td>");
				   out.print("<td  class=list_right_cp_lmt>" + profession + "</td>");
				   out.print("<td  class=list_right_cp_lmt>" + grad_from + "</td>");
				   out.print("<td  class=list_right_cp_lmt>" + job_age + "</td>");
				   out.print("<td  class=list_right_cp_lmt align=center>" + update_date + "</td>");
				   out.print("</tr>");
			   }
			   out.print("<tr>");
			   out.print("<td colspan=3 align=right>");
			   out.print( pagtool );
			   out.print("</td>");
			   out.print("</tr>");
			}
			else
			{
				out.print("<table width=65% height=300 border=0 align=center cellpadding=0 cellspacing=0>对不起！没有找到您要信息。</table>"); 
			}
		
		}
		
   }
%>



