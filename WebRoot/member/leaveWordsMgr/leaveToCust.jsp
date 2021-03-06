<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />

<%
   HttpSession  logsession = request.getSession(); 
    String suser_name = "";
    String iStart ="1";
    String meun_idx="";
    String cust_id="";
    boolean flag=false;
    String cust_type="";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_USER_NAME") != null)
    {
        suser_name = logsession.getAttribute("SESSION_USER_NAME").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        meun_idx = request.getParameter("menu_id");
        logsession.setAttribute("menu_id",meun_idx);
    }
    if( logsession.getAttribute("SESSION_CUST_ID")!= null)
    {
       cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    Custinfo info =new Custinfo();
    cust_type=info.getCustTypeById(cust_id);
    if(cust_type.equals("1"))
     flag=true;
  	LeavewordsInfo enquiryObj=new LeavewordsInfo();
  	int counter = 0 ;
    ArrayList newsList = new ArrayList();

   	newsList = enquiryObj.getLeavelListByOut(Integer.valueOf(iStart).intValue(),20,cust_id);

    counter=enquiryObj.getLeavelListByOut(cust_id);

	String pageTools=tools.getPageTools(String.valueOf(counter),"20","leaveToCust.jsp?iStart=",Integer.parseInt(iStart));
	int size = counter;
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
<script language="javascript">
  function chechIfo()
  {
	   if(confirm('是否确认删除留言？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
</script>
<script language="javascript">			
	function selAllNews(){
			var size = document.getElementById('size').value;
			for(var i=0;i<size;i++){
					document.getElementById('re_news'+i).checked = true;
			}
	}
	
	function delAllNews(){
			var size = document.getElementById('size').value;
			for(var i=0;i<size;i++){
					if(document.getElementById('re_news'+i).checked==true){
						document.getElementById('re_news'+i).checked = false;	
					}else{
						document.getElementById('re_news'+i).checked = true;		
					}
			}
	}
	function reloadNews(){
			var size = document.getElementById('size').value;
			var all_news_id='';
			for(var i=0;i<size;i++){
				if(document.getElementById('re_news'+i).checked==true){
						all_news_id += document.getElementById('re_news'+i).value+'|';
				}
			}
			document.getElementById('trade_id').value = all_news_id;
			if(all_news_id==''){
				alert('请至少选择一条!');
				return false;
			}else{
				document.indexdateform.action='/doTradeReg.do';
				document.getElementById("trade_type_code").value="3123";
				document.indexdateform.submit();
			}
	}
		
</script>
</head>
<body>
	<form action="leaveToCust.jsp" method="post" name="indexdateform">
					
					<%
						String top_menu_id = "";
						if(request.getParameter("menu_id")!=null){
							top_menu_id = request.getParameter("menu_id");
						}
					%>
					

		     <table width=100% border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#FCB0B0">
		        <tr class="u4">
			        <td  align=left width="20%">标题</td>
					    <td  width="25%">信息内容</td>
					    <td  width="15%">收信人</td>
					    <td  width="10%">发信日期</td>
						<td width="15%" align="center">
							<input type="button" name="reload" value="删除" onclick="reloadNews()"/>
							<input type="button" name="selAll" value="全选" onclick="selAllNews()"/>
							<input type="button" name="delAll" value="反选" onclick="delAllNews()"/>
						</td>
		        </tr>
		        <%
		            if(newsList != null && newsList.size()>0)
		            {  
                  		 String word_type="";
						 int i = 0;
		              	 for (Iterator it = newsList.iterator(); it.hasNext();)
		                  {
						        HashMap map = (HashMap) it.next();
						        String trade_id=map.get("trade_id").toString();
						        String title="";
						         String cust_name="";
						        String content="";
						        String in_date="";
						        if(map.get("title")!=null)
						        {
						         title=map.get("title").toString();
						        }
						         if(map.get("cust_id")!=null)
						        {
						         cust_id=map.get("cust_id").toString();
						         cust_name =info.getCustName(cust_id);
						        }
						        if(map.get("content")!=null)
						        {
						          content=map.get("content").toString();
						          if(content.length()>10)
						          {
						             content=content.substring(0,10)+"...";
						          }
						         }
						         if(map.get("in_date")!=null)
						        {
						          in_date=map.get("in_date").toString();
						          if(in_date.length()>10)
						          {
						             in_date=in_date.substring(0,10);
						          }
						         }
						         if(map.get("word_type")!=null)
						        {
						          word_type=map.get("word_type").toString();

						         }
						        %>
						        
						        <tr class="u2" >
					              <td  align=left>
					              	
						              <a href="sendFeedBack.jsp?trade_id=<%=trade_id%>" ><%=title%></a>
					                
					              	</td>
					              <td  align=left><%=content%></td>
					              <%
								  		if(word_type.equals("a"))
										{
								  %>
					              <td  align=left>全部客户</td>
					              	<%
										}
										else{
									%>
					              <td  align=left><%=cust_name%></td>
					              <%	
								  		}
								  %>
					              <td  align=left><%=in_date%></td>
								  <td align=center>
          							<input type="checkbox" name="re_news<%=i%>" id="re_news<%=i%>" value="<%=trade_id%>" />
									<input type="hidden" name="size" value="<%=size%>" id="size" />
								  </td>
					            </tr>
					            <%
								i++;
					     	}
					     %>
					     
					      <tr>
							  <%=pageTools%>
							 </tr>
					     
					  <%}
		          	else
		          	{
		          %>
								<tr>
									<td colspan="6" align="center" bgcolor="white">
										无记录！
									</td>
								</tr>
					<%		
					}
		      %>
		    </table>
			 <input type="hidden" value="" id="trade_id" name="trade_id">
		    <input type="hidden" value="" id="trade_type_code" name="trade_type_code">
	</form>	
</body>
</html>




