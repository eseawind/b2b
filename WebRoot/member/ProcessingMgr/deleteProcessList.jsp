<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.ProcessMgr.ProcessInfo"%>
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
     ProcessInfo processObj=new ProcessInfo();
    ArrayList processList =processObj.gentProcessByCust_id(Integer.valueOf(iStart).intValue(),cust_id);
     int counter=processObj.getProcessListNumber(cust_id);
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
<script type="text/javascript" src="/js/ProcessingMgr.js"></script>
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
	              if(processList != null && processList.size()>0)
	              {
	                 for (Iterator it = processList.iterator(); it.hasNext();)
	                 {
				    HashMap map = (HashMap) it.next();
					    String category_id=map.get("category_id").toString();
					    String category_title="";
					 //   String category_abstract="";
					    String  category_desc="";
					    
					    String category_addr="";
					    if(map.get("category_title") != null)
					    {
					       title=map.get("category_title").toString();
					    }
					   /* if(map.get("category_abstract") !=null)
					    {
					      category_abstract=map.get("category_abstract").toString();
					      category_abstract=category_abstract.replaceAll("<[^<>]+>","");
					      if(category_abstract.length()>30)
					      {
					        category_abstract=category_abstract.substring(0,30)+"...";
					      }
					    }*/
					       if(map.get("category_desc") !=null)
					    {
					      category_desc=map.get("category_desc").toString();
					      category_desc=category_desc.replaceAll("<[^<>]+>","");
					      if(category_desc.length()>30)
					      {
					        category_desc=category_desc.substring(0,30)+"...";
					      }
					    }
					    if(map.get("category_addr") != null)
					    { 
					      sale_addr=map.get("category_addr").toString();
					    }
	             %>
	            <tr style="background-color:#f9f9f9; " id="changcolor_tr<%=category_id%>" onmouseover="MM_changeProp('changcolor_tr<%=category_id%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=category_id%>','','backgroundColor','#f9f9f9','DIV')">
	              <td  style=" color:#000000; padding:3px 5px;" align=left><%=category_title%></td>
	              <!--td  style=" color:#000000; padding:3px 5px;" align=left><%=category_abstract%></td-->
	                <td  style=" color:#000000; padding:3px 5px;" align=left><%=category_desc%></td>
	              <td  style=" color:#000000; padding:3px 5px;" align=left><%=category_addr%></td>
	              <td  style=" color:#000000;" align=center><a href=/doTradeReg.do?category_id=<%=category_id%>&trade_type_code=0977 target="_self"  onClick="return deleteProcessListchechIfo()"><img src=/img/del.gif width=16 height=16 border=0></a></td>
	            </tr>
	            <%}
	            }%>
	            <tr>
				<td  align="left" colspan="2" class="line1" style="font-weight:normal;">共<%=counter%>条 &nbsp;共<%=pages%>页</td>
				<td  align="left" colspan="2" style="background-color:#e2e2e2;"><a href="modifyIndex.jsp?iStart=0&meun_id=<%=meun_idx%>">首页 </a>&nbsp; &nbsp;<a href="deleteProcessList.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;<a href="deleteProcessList.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; <a  href="deleteProcessList.jsp?iStart=<%=pages%>">尾页</a></td>
	         </tr>
	         </table>
</body>
</html>




