
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%
	String cust_id = "",cust_type="",se_cust_name="",juristic_type_code="",para_code2="";
	if(session.getAttribute("SESSION_CUST_ID")!=null){
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	if(session.getAttribute("SESSION_CUST_NAME")!=null){
		se_cust_name = session.getAttribute("SESSION_CUST_NAME").toString();
	}
	if(session.getAttribute("SESSION_CUST_TYPE")!=null){
		cust_type = session.getAttribute("SESSION_CUST_TYPE").toString();
	}
	Custinfo cust = new Custinfo();
	ArrayList customerList = new ArrayList();
	customerList = cust.getCustInfoLinkInfoMap(cust_id);
		if(customerList!=null){
			HashMap map = (HashMap)customerList.get(0);
			if(map.get("cust_aim")!=null){
				se_cust_name = map.get("cust_aim").toString();	
			}
			if(se_cust_name.equals("")){
				if(map.get("cust_name")!=null){
					se_cust_name = map.get("cust_name").toString();	
				}
			}
			if(map.get("juristic_type_code")!=null){
				juristic_type_code = map.get("juristic_type_code").toString();	
			}
			if(map.get("para_code2")!=null){
				para_code2 = map.get("para_code2").toString();	
			}
		}
	String in_cust_id = "<input type=hidden name=para_code2 id=para_code2 value="+para_code2+"><input type=hidden name=juristic_type_code id=juristic_type_code value="+juristic_type_code+"><input type=hidden name=se_cust_id id=se_cust_id value="+cust_id+"><input type=hidden name=se_cust_name id=se_cust_name value="+se_cust_name+"><input type=hidden name=cust_id id=cust_id value="+cust_id+"><input type=hidden name=cust_type id=cust_type value="+cust_type+">";
		out.print( "document.write('"+in_cust_id+"');");
		
%>




