<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commodityMgr.CommodityInfo" scope="page"/>
<%
    String commodity_id="",cust_id="";
    String commodity_name="",commodity_unit="",sale_market="",content="",commodity_brand="",commodity_price="",sale_price="";
    if (request.getParameter("commodity_id") != null)
    {
        commodity_id = request.getParameter("commodity_id");
        ArrayList commList=new ArrayList();
        commList=bean.genCommodityList(commodity_id);
        if(commList != null && commList.size()>0)
        {
            HashMap map=(HashMap)commList.get(0);
             if(map.get("commodity_name")!=null)
             {
               commodity_name=map.get("commodity_name").toString();
             }
			if(map.get("commodity_unit")!=null)
			{
			  commodity_unit=map.get("commodity_unit").toString();
			}
			if(map.get("sale_market")!=null)
			{
			  sale_market=map.get("sale_market").toString();
			}
			if(map.get("content")!=null)
			{
			   content=map.get("content").toString();
			}
			if(map.get("commodity_brand")!=null)
			{
			   commodity_brand=map.get("commodity_brand").toString();
			}
			if(map.get("commodity_price")!=null)
			{
			   commodity_price=map.get("commodity_price").toString();
			}
			if(map.get("sale_price")!=null)
			{
			   sale_price=map.get("sale_price").toString();
			}
        }
    }
     ParamethodMgr paramCom=new ParamethodMgr();
	ArrayList  webList =paramCom.getCompareInfo("CRM","web_id");
	ArrayList  comTypeList=paramCom.getCompareInfo("CRM","commodity_type");
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout1.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="/www/fuction/public.js"></script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script src="/js/productMgr.js" type="text/javascript"></script>
</head>
<body>
<table width="818" border="0" cellspacing="0" cellpadding="0" align="center">
 <tr>
	    <td height="26" background="/img/bg-1.gif">&nbsp;</td>
	  </tr>
	  <tr>
	    <td background="/img/bg-2.gif">
	     <form name=form1 action=/doTradeReg.do method=post target="blank">
         <table  width="93%" border="0" cellpadding="5" cellspacing="1" align="center" bgcolor="#dddddd">
        
		  <tr>    
            <td  class="line1" align="left" colspan="2">修改商品信息
            </td>
          </tr>          
		  <tr>
           <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">商品名称</td>
           <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=commodity_name value="<%=commodity_name%>"></td>
         </tr>
           <input name=commodity_id type=hidden value="<%=commodity_id%>">
           <input type=hidden name=reattach_tag value="0">
         <tr>
          <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">计价单位</td>
         <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=commodity_unit value="<%=commodity_unit%>"></td>
       </tr>
       <tr>
         <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">销售地点</td>
         <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=sale_market value="<%=sale_market%>"></td>
       </tr>
       <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">选择子网</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
      	<select name=web_id>
              <%
					if(webList != null && webList.size()>0)
					{
						for(int i=0;i<webList.size();i++)
						{
							HashMap map=(HashMap)webList.get(i);
							String value=map.get("para_code1").toString();
							String name=map.get("para_code2").toString();
							%>
                               <option value="<%= value %>"><%= name %></option>
                               <%
						}
					} %>
        </select>
         </td>
       </tr>
       <tr>
         <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">商品分类</td>
         <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><select name=commodity_type>
               <%
					if(comTypeList != null && comTypeList.size()>0)
					{
						for(int i=0;i<comTypeList.size();i++)
						{
							HashMap map=(HashMap)comTypeList.get(i);
							String value=map.get("para_code1").toString();
							String name=map.get("para_code2").toString();
							%>
                               <option value="<%= value %>"><%= name %></option>
                               <%
						}
					} %>
        </select>
        </td>
      </tr>
      <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right" valign="top">商品说明</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><textarea name=content style=display:none><%=content%></textarea>
         <iframe id="content" src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=commodity_id%>" frameborder=0 scrolling=no width=600 height=350></iframe>  
        </td>
      </tr>
      <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">品牌</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=commodity_brand value="<%=commodity_brand%>"></td>
      </tr>
      <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">原价</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=commodity_price value="<%=commodity_price%>"></td>
      </tr>
      <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">价格</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><input type=text name=sale_price value="<%=sale_price%>">
		<input type=hidden name=trade_type_code value=0312></td>
      </tr>
      <tr>
        <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right">价格类型</td>
        <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left><select name=price_type>
          <option value=0>正常价格</option>
          <option value=1>打折价格</option>
        </select></td>
      </tr>
      <tr>
        <input type=hidden name=rsrv_num1 value=0>
        <td class=grayE colspan=2 align="center"><INPUT id=advcheck name=advshow type=checkbox value=0 onclick=check_none(form1)>
         以上资料正确无误。
        </td>
      </tr>
      <tr>
        <td   style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"  align=center colspan=2><input name=submit1 type=button value=确定 disabled=true onclick=modifyProductInfoconfirmsub(form1)>
        <input name=button1 type=button value=取消 onclick=exit()></td>
      </tr>
  
  </table>  </form>
  	     </td>
	  </tr>
	  <tr>
	    <td height="46" background="/img/bg-3.gif">&nbsp;</td>
	  </tr>
</table>
</body>
</html>



