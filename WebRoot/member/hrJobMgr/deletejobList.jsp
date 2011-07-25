<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="0";
    String meun_idx="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        meun_idx = request.getParameter("menu_id");
        logsession.setAttribute("menu_id",meun_idx);
        /**RightMenu menuObj=new RightMenu();
        ArrayList upmenuList=menuObj.getMenuInfo(meun_idx);
        if(upmenuList != null && upmenuList.size()>0)
        {
          HashMap map=(HashMap)upmenuList.get(0);
          if(map.get("up_menu_id") != null)
          {
            meun_idx=map.get(""up_menu_id").toString();
          }
        }      */  
    }
    if( logsession.getAttribute("menu_id")!= null)
    {
       meun_idx=(String)logsession.getAttribute("menu_id");
    }
      JobInfo jobObj=new JobInfo();
    ArrayList jobList =jobObj.gentjobByCust_id(Integer.valueOf(iStart).intValue(),cust_id);
     int counter=jobObj.getjobListNumber(cust_id);
     int pages=counter/30+1;
	int pageUp=0,pageDown=0;
	int currenPage=Integer.valueOf(iStart).intValue();
	if(pages>currenPage)
	{
	   if(currenPage>0)
	   {
		pageUp=currenPage-1;
	   }
		pageDown=currenPage+1;
	}
    else if(pages==currenPage)
	{
	   pageUp=currenPage-1;
	   pageDown=currenPage;
	}
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<script language="JavaScript" src="/js/hrJobMgr.js"></script>
</head>
<body>
	        	<table  width="100%" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7" style="margin-top:13px">
	            <tr>
	              <td  class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="20%">标题</td>
	              <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="40%">分类产品信息描述</td>
	              <td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="30%">分类产品信息产地</td>
	              <td  style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;" align=center width="10%">删除</td>
	            </tr>
	            <%
	              if(jobList != null && jobList.size()>0)
	              {
	                 for (Iterator it = jobList.iterator(); it.hasNext();)
	                 {
				    HashMap map = (HashMap) it.next();
					    String jobId=map.get("jobId").toString();
					    String title="";
					 //   String req="";
					
					    
					    String job_addr="";
					    if(map.get("title") != null)
					    {
					       title=map.get("title").toString();
					    }
					  
					       if(map.get("request") !=null)
					    {
					      req=map.get("request").toString();
					      req=category_desc.replaceAll("<[^<>]+>","");
					      if(req.length()>30)
					      {
					        req=req.substring(0,30)+"...";
					      }
					    }
					    if(map.get("job_addr") != null)
					    { 
					      job_addr=map.get("job_addr").toString();
					    }
	             %>
	            <tr style="background-color:#f9f9f9; " id="changcolor_tr<%=jobId%>" onmouseover="MM_changeProp('changcolor_tr<%=jobId%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=jobId%>','','backgroundColor','#f9f9f9','DIV')">
	              <td  style=" color:#000000; padding:3px 5px;" align=left><%=title%></td>
	              <!--td  style=" color:#000000; padding:3px 5px;" align=left><%=category_abstract%></td-->
	                <td  style=" color:#000000; padding:3px 5px;" align=left><%=req%></td>
	              <td  style=" color:#000000; padding:3px 5px;" align=left><%=job_addr%></td>
	              <td  style=" color:#000000;" align=center><a href=/doTradeReg.do?jobId=<%=jobId%>&trade_type_code=0388 target="_self"  onClick="return deletejobListchechIfo()"><img src=/img/del.gif width=16 height=16 border=0></a></td>
	            </tr>
	            <%}
	            }%>
	            <tr>
				<td  align="left" colspan="2" class="line1" style="font-weight:normal;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
				<td  align="left" colspan="2" style="background-color:#e2e2e2;"><a href="updatejobindex.jsp?iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="updatejobindex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;<a href="updatejobindex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; <a  href="updatejobindex.jsp?iStart=<%=pages%>">尾页</a></td>
	         </tr>
	         </table>
</body>
</html>




