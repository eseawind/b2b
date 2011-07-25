
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.*"%>
<%
	String cust_id = "";
	if(request.getParameter("cust_id")!=null){
		cust_id = request.getParameter("cust_id");
	}
	
	String province="", city ="",pro_name = "",city_name="" ,area_name ="";
	Custinfo cust = new Custinfo();
	ArrayList list  = cust.FindCompanyName(cust_id);
	AreaInfo area = new AreaInfo();
	
	if(list != null && list.size() > 0){
		HashMap map = (HashMap)list.get(0);
		if(map.get("province")!=null)
			province = map.get("province").toString();
		if(map.get("city")!=null)
			city = map.get("city").toString();
			
		pro_name =area.getAreaName(province);
		//city_name =area.getAreaName(city);
		area_name = pro_name + city_name; 
	}
	
	out.print( "document.write('["+area_name+"]');");

%>
	<!--div style="float:right; width:90px; height:22px; color:#666; font-size:12px; p">[<%=area_name%>]</div-->




