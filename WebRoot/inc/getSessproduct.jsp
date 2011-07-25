
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.productMgr.*"%>
<%
	InfoList infoList = new InfoList();	
	ProductInfo product = new ProductInfo();
	ArrayList customerList = new ArrayList();
	customerList = product.getAllProductInfoByForRe("3");
	String product_name="",product_id="",url="";
	String in_cust_id = "",address="";
	int size = 0;
	if(customerList!=null){
	size = customerList.size();
		for(int i=0;i<customerList.size();i++){
			HashMap map = (HashMap)customerList.get(i);
			if(map.get("product_id")!=null){
				product_id = map.get("product_id").toString();
				address = infoList.getChannelSaveDirByInfoId(product_id);
			}
			if(map.get("product_name")!=null){
				product_name = map.get("product_name").toString();
			}
			url = "/" + address + "/d/content-" + product_id +".html";
			in_cust_id = in_cust_id + "<input type=hidden name=product_name"+i+" id=product_name"+i+" value="+product_name+">" + "<input type=hidden name=url"+i+" id=url"+i+" value="+url+">";
		}
	}
	in_cust_id = in_cust_id + "<input type=hidden name=product_size id=product_size value="+size+">";
	out.print( "document.write('"+in_cust_id+"');");
%>





