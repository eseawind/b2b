
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.pricerankMgr.PriceRankInfo"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%
	PriceRankInfo info = new PriceRankInfo();
	ArrayList list = new ArrayList();
	int size = 0;
	list = info.getRankByChId("7830633062");
	if(list!=null){
	for(int i=0;i<list.size();i++){
	HashMap map = (HashMap)list.get(i);
	String title = map.get("keyword").toString();
	SaleInfo saleinfo = new SaleInfo();
	ArrayList salelist = new ArrayList();
	salelist = saleinfo.getListByKeyAndChid(title);
	String title2="",cust_aim="",sale_id="",sale_addr="",publish_date="",group_contact_phone="",saleUrl="",mini_img="";
	String cust_id="";
	if(salelist!=null){
		size = 4;
		if(salelist.size()<4){
			size = salelist.size();
		}
		for(int j=0;j<size;j++){
			HashMap saleMap = (HashMap)salelist.get(j);
			if(saleMap.get("cust_id")!=null){
				cust_id = saleMap.get("cust_id").toString();
			}
			if(saleMap.get("title")!=null){
				title2 = saleMap.get("title").toString();
			}
			if(saleMap.get("mini_img")!=null){
				mini_img = saleMap.get("mini_img").toString();
			}
			if(saleMap.get("cust_aim")!=null){
				cust_aim = saleMap.get("cust_aim").toString();
			}
			if(saleMap.get("sale_id")!=null){
				sale_id = saleMap.get("sale_id").toString();
			}
			if(saleMap.get("sale_addr")!=null){
				sale_addr = saleMap.get("sale_addr").toString();
			}
			if(saleMap.get("publish_date")!=null){
				publish_date = saleMap.get("publish_date").toString();
			}
			if(saleMap.get("group_contact_phone")!=null){
				group_contact_phone = saleMap.get("group_contact_phone").toString();
			}
			if(publish_date.length()>10){
				publish_date = publish_date.substring(0,10);
			}
			if(mini_img.equals("")){
				mini_img = "/images/cp.gif";
			}
			saleUrl = "/default/supply/d/content-"+sale_id+".html";
			out.print("document.write('<tr class=four_bg><td><a href="+saleUrl+"><img src="+mini_img+" border=0 width=100 height=75></a></td>');");
			out.print("document.write('<td valign=top><span class=link_xian><a href="+saleUrl+">"+title2+"</a></span><br>');");
			out.print("document.write('<span class=link_xian>发布者: <a href=/inc/include/InterimPages.jsp?cust_id="+cust_id+">"+cust_aim+"</a>[已核实] </span>');");
			out.print("document.write('<div class=button style=float:left;margin-right:5px;><a href="+saleUrl+">产品信息</a></div>');");
			out.print("document.write('<div class=button style=float:left;><a href=/inc/include/InterimPages.jsp?cust_id="+cust_id+">联系方式</a></div> </td>');");
			out.print("document.write('<td align=center>&nbsp;"+sale_addr+"</td>');");
      out.print("document.write('<td align=center>"+publish_date+"</td>');");
      out.print("document.write('<td align=center>"+group_contact_phone+"</td>');");
      out.print("document.write('</tr>');");
		}
	}
		}
		out.print("document.write('<tr><th><font size=2 color=red>以上是竞价排名</font></th></tr>');");
	}
	
%>




