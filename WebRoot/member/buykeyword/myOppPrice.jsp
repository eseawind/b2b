<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%@ page import="com.saas.biz.pricerankMgr.*"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id="";
	String iStart = "0";
	String menu_id = "";
    if (request.getParameter("iStart") != null)
    {
        iStart = request.getParameter("iStart");
    }
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){
		cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
		}
	PriceRankInfo ppp = new PriceRankInfo();
	ArrayList alist = new ArrayList();
	alist = ppp.getPriceRankByCust(cust_id,Integer.valueOf(iStart).intValue());
	int counter = ppp.getPriceRankByCust(cust_id);
    int pages=(counter-1)/20+1;
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
<title>�ҵľ������</title> 
    <link href="/style/layout1.css" rel="stylesheet" type="text/css">
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>	
    
	  <table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#98D9A2">
  	<tr>
				<td colspan="5" class="head"> 
					<a href="buykeyword.jsp">���۹������</a>
				</td>
		</tr>
		<tr class="u4" height="25">
	          <td   align=left width="20%">�ؼ���</td>
	          <td   align=left width="20%">����</td>
	          <td   align=left width="20%">�۸�</td>
	          <td   align=left width="20%">�Ƿ�����</td>
	          <td   align=center width="10%" >�޸�</td>
	          <td   align=center width="10%" >ɾ��</td>
        </tr>
        <%
        			KeyPriceInfo priceInfo = new KeyPriceInfo();
        			if(alist!=null && alist.size()>0){
        			String keyword="",title="",price="",rsrv_str6="",rankprice_id="",key_price="",ifchecked="";
        				for(int i=0;i<alist.size();i++){
        					HashMap map = (HashMap)alist.get(i);
        					if(map.get("rankprice_id")!=null){
        						rankprice_id= map.get("rankprice_id").toString();
        					}
        					if(map.get("keyword")!=null){
        						keyword= map.get("keyword").toString();
        					}
        					if(map.get("rsrv_str6")!=null){
        						rsrv_str6= map.get("rsrv_str6").toString();
        					}
        					if(map.get("title")!=null){
        						title= map.get("title").toString();
        					}
        					if(map.get("ifchecked")!=null){
        						ifchecked= map.get("ifchecked").toString();
        						if(ifchecked.equals("1")){
        							ifchecked = "������";
        						}else{
        							ifchecked = "δ����";	
        						}
        					}
        					if(map.get("price")!=null){
        						price= map.get("price").toString();
        						ArrayList priceList = priceInfo.getKeyPriceInfo(price);
								if(priceList!=null && priceList.size()>0){
									HashMap mapt = (HashMap)priceList.get(0);
									if(mapt.get("key_price")!=null){
										key_price=mapt.get("key_price").toString();
											}
									}	
        					}%>
        					<tr bgcolor="white">
				          <td><a href="seeone.jsp?rankprice_id=<%=rankprice_id%>" ><%=keyword%></a></td>
				          <td><%=title%></td>
				          <td><%=key_price%>��Ԫ��</td>
				          <td><%=ifchecked%></td>
				          <td align="center">
				          	<a href=update.jsp?rankprice_id=<%=rankprice_id%>>
							  <img src=/images/edit.gif width=16 height=16 border=0 style="cursor: hand" alt="�޸���Ϣ"></a>
				          	</td>
				          <td   align=center width="10%" > <a href="/doTradeReg.do?trade_type_code=2010&rankprice_id=<%=rankprice_id%>">
		  <img src="/images/del.gif" border="0" title="���ɾ��"> </a></td>
      				  </tr>
        				<%}
        			}%>
        <tr class="u1">
          <td  align="left" colspan="3" style="font-weight:normal; padding:2px 5px;">��<%=counter%>�� &nbsp;��<%=Integer.parseInt(iStart)+1 %>ҳ&nbsp;&nbsp;��<%=pages%>ҳ</td>
          <td  align="right" colspan="4"  style=" padding:2px 5px;">
		  			<a href="myOppPrice.jsp?iStart=0">��ҳ </a>&nbsp; &nbsp;
            <% 
							if(Integer.parseInt(iStart)>0){
						%>
            <a href="myOppPrice.jsp?iStart=<%=pageUp%>">��һҳ</a> &nbsp;
            <%
							}
							if(Integer.parseInt(iStart)<pages-1){
						%>
            <a href="myOppPrice.jsp?iStart=<%=pageDown%>">��һҳ </a>&nbsp;
            <%
							}
						%>
            <a  href="myOppPrice.jsp?iStart=<%=pages-1%>">βҳ</a></td>
			        </tr>
			      <%
					  if(alist==null){
					  %>
        <tr bgcolor="white">
          <td colspan="7" align="center"><b>�޼�¼!</b></td>
        </tr>
        <%
		          }
		        	%>
        			
</table>
</body>
</html>



