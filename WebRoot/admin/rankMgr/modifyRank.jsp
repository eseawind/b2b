<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%
  String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
   String cust_name="",cust_id="";
    if (request.getParameter("cust_name") != null)
    {
        cust_name = request.getParameter("cust_name");
    }
    if (request.getParameter("cust_id") != null)
    {
        cust_id = request.getParameter("cust_id");
    }
	ParamethodMgr comparList=new ParamethodMgr();
	HashMap compMap=comparList.getCompareInfoByCode("CRM","cust_type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script language="JavaScript" src="/js/dialog.js"></script>

</head>
<body>
<br><br><br> <form name=form1 action=/doTradeReg.do method="post">
<table  width=700 border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#dddddd">
  <tr>    
    <td  class="line1" align="left" colspan="2" >修改级别
    </td>
  </tr>
 
    <tr>
      <td width="163" align=right  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">客户名称：</td>
      <td width="526" align=left  style="background-color:#ffffff; color:#000000;  font-size:12px;" class="ping1"><%=cust_name%></td>
    </tr>
    <tr>
      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>客户级别：</td>
      <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" class="ping1" align=left><select name=cust_class>
          <%
           if (compMap != null && compMap.size() > 0) 
           {
	            Iterator it = compMap.entrySet().iterator();
	            while (it.hasNext())
	             {
	                Map.Entry entry = (Map.Entry) it.next();
	                String keys =entry.getKey().toString();
	                String values =entry.getValue().toString();
	                %>
	                 <option value=<%=keys%>><%=values%></option>
	                <%
	               }
             }
          %>          
        </select>
      </td>
    </tr>
    <tr>
      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>有效开始时间：</td>
      <td style="background-color:#ffffff; color:#000000;  font-size:12px;" class="ping" align=left>
          <input name="start_date" type="text" size=15 maxlength=7 class="input1" id="start_date"   onfocus="setday(this);">(yyyy-MM-dd)
      </td>
    </tr>
    <tr>
      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>有效截止时间：</td>
      <td style="background-color:#ffffff; color:#000000;  font-size:12px;" class="ping" align=left>
      	<input name="end_date" type="text" size=15 maxlength=7 class="input1" id="end_date" onfocus="setday(this);">(yyyy-MM-dd)
      </td>
    </tr>
    <tr>
      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>操作说明：</td>
      <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left class="ping"><input type="text" name="remark"></td>
    </tr>

      <input type="hidden" name="trade_type_code" value=0315>
      <input type="hidden" name="cust_id" value="<%=cust_id%>">

    <tr>
      <input type=hidden name=rsrv_num1 value=0>
      <td  style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan=2 align="center"><INPUT id=advcheck name=advshow type=checkbox value=0 onclick=check_none(form1)>
        以上资料正确无误。
      </td>
    </tr>
    <tr>
      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;" align=center colspan=2><input name=submit1 class="tjan" type=button value="" disabled=true onclick=confirmsub(form1)>
        <input name=button1 class="qxan" type=button value="" onclick=exit()></td>
    </tr>
    

</table>  </form>
</body>
</html>




