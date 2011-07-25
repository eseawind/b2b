<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%> 
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="tools.util.DateUtils"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.saas.biz.chargeMgr.ChargeInfo"%>
<%@ page import="com.saas.biz.feeRecorMgr.FeeRecordInfo"%>
<%
   HttpSession  logsession = request.getSession(); 
    String cust_id = "";
    String iStart ="1";
    String cust_name="";
    String charge_date="";
    String money="";
    String expire_date="";
    String buyfordays="";
    String expiredate="";
    String className="";
    String cust_class="";
    boolean ifowe=false;
    ParamethodMgr ptd=new ParamethodMgr();
    
    request.setCharacterEncoding("gbk");
     int counter=0;
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (logsession.getAttribute("SESSION_CUST_CLASS") != null)
    {
        cust_class = logsession.getAttribute("SESSION_CUST_CLASS").toString();
    }
    if(!cust_class.equals(""))
    {
      className=ptd.getParamNameByValue("14",cust_class);
    }
     if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_name = logsession.getAttribute("SESSION_CUST_NAME").toString();
        	try {
			        cust_name = new String(cust_name.getBytes("ISO8859_1"), "GBK");
		         }
		   catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
   ChargeInfo chargeInfo=new ChargeInfo();
   ArrayList custlist= new ArrayList();
   if(!cust_id.equals(""))
    {     
     expiredate=chargeInfo.getCustEndDate(cust_id);    
    }
    Calendar cal = Calendar.getInstance();
    long today=cal.getTimeInMillis();
     if(!expiredate.equals(""))
    cal=DateUtils.paserStringToCalendar(expiredate);
   if(today>=cal.getTimeInMillis())
       ifowe=true;
    FeeRecordInfo feer = new FeeRecordInfo();
   if(!cust_id.equals(""))
    {     
     //custlist=chargeInfo.getInfoByCustId(cust_id,Integer.parseInt(iStart),20);
    // counter=chargeInfo.getInfoByCustId(cust_id);
     custlist = feer.AddmingetAll(Integer.parseInt(iStart));
     counter = feer.AddmingetAll();
    }
   
    String toolsBar=tools.getPageTools(String.valueOf(counter),"20","charge.jsp?iStart=",Integer.parseInt(iStart));
  //  String toolsBar="";
    iStart+=1;
 // out.println(cust_name);
%>

<html>
<head>
<title>会员缴费列表</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style>
  .t_head{style="color:#000000;  font-weight:bold; font-size:13px;" }
  .chaxun{
					background:url(/admin/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
</style>
		<script type="text/javascript" src="/js/roleMgr.js">
		
	   //空值判断
	    function Check_Value(){
	    //   if(document.getElementById("custnamefind").value ==null || document.getElementById("custnamefind").value ==""){
	     //   alert("请输入查询条件");
	     //   return false;
	     //  }
	     //  else
	      
	       document.custNameFind.submit();
	    }
		</script>
</head>
<body>
		     <table width="100%" border=0 cellpadding=1 cellspacing=1 align="center" bgcolor="#FCB0B0">
		      <tr class="u4" height="25">
					<td width="20%" align="left">客户名称 </td>
					<td width="20%" align="left">缴费时间 </td>
					<td width="20%" align="left">客户级别</td>
					<td width="20%" align="left">缴费金额(元)</td>
					<td width="20%" align="left">有效期</td>
		        </tr>
		        <%
		        String para2 = "",fee="",limit_time="",in_date="",cust_aim="",cust_id1="";
		            if(custlist != null)
		            {
		            	 for (Iterator it = custlist.iterator(); it.hasNext();)
		                  {
		                    HashMap map = (HashMap) it.next();
		                     if (map.get("cust_id") != null) {cust_id1 = map.get("cust_id").toString();}
		                     if (map.get("cust_aim") != null) {cust_aim = map.get("cust_aim").toString();}
		                     if (map.get("para_code2") != null) {para2 = map.get("para_code2").toString();}
		                     if (map.get("fee") != null) {fee = map.get("fee").toString();}
		                     if (map.get("limit_time") != null) {limit_time = map.get("limit_time").toString();}
		                     if (map.get("in_date") != null) {in_date = map.get("in_date").toString();}
		                     //if(in_date.length()>10){
		                     	//in_date = in_date.substring(0,10);
		                    // }		            
						    	%>
					<tr class="u2" >
				  	 <td  align=left><a href="/member/customerMgr/companyIntroduction.jsp?obj_cust_id=<%=cust_id1%>"><%=cust_aim%></a></td>
				  	 <td  align=left><%=in_date%></td>
			       <td  align=left><%=para2%></td>
				  	 <td  align=left><%=fee%></td>
			       <td  align=left><%=limit_time%> </td>
					</tr>
					<%    
		       }
		      	%>
					 <tr class="u1">
						 <%=toolsBar%>						
					</tr>
					<%
		    }else{
		      %>
		      <tr class="u2" >
				  	 <td  colspan=4 align=center>没查到您的缴费记录</td>

					</tr>
		      
		      <%}%>
		    </table>
	
</body>
</html>



