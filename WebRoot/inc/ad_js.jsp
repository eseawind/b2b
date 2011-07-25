 
<%@ page import="java.util.*"%>
<%@ page import="com.saas.intf.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=GBK"%>

 
<%
	String cust_adv_id = "";
	if(request.getParameter("cust_adv_id")!=null){
		cust_adv_id = request.getParameter("cust_adv_id");
	}
	AdvertiseIntf adv = new AdvertiseIntf();
	HashMap advMap = adv.getInfoByCustAdvId(cust_adv_id);
	String n_content = "",p_content = "",time_limit = "",end_date = "";
	if(advMap!=null){
		if(advMap.get("n_content")!=null){n_content = advMap.get("n_content").toString();}
		if(advMap.get("p_content")!=null){p_content = advMap.get("p_content").toString();}
		if(advMap.get("time_limit")!=null){time_limit = advMap.get("time_limit").toString();}
		if(advMap.get("end_date")!=null){end_date = advMap.get("end_date").toString();}
	}
	
	String disStr = "";
	String ndate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	if(!time_limit.equals("") && time_limit.equals("0")){
		disStr = n_content;
	}
	if(!time_limit.equals("") && time_limit.equals("1")){
		if(ndate.compareTo(end_date) > 0){
			disStr = p_content;
		}else{
			disStr = n_content;
		}
	}
		out.print( "document.write('"+disStr+"');");
%>

 
 




