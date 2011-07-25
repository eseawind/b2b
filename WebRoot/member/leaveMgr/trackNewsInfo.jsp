<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.advertiseMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.enquirytrackMgr.EnquirytrackInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	String enquiry_id = "";
	String trade_id = bean.GenTradeId();
	String enquiry_content = "";
	if (request.getParameter("trade_id") != null) {
		enquiry_id = request.getParameter("trade_id");
		EnquirytrackInfo enquiry = new EnquirytrackInfo();
		ArrayList enquiryList = enquiry.getEnquiryInfo(enquiry_id);
		if (enquiryList != null && enquiryList.size() > 0) {
			HashMap map = (HashMap) enquiryList.get(0);
			if (map.get("enquiry_content") != null) {
				enquiry_content = map.get("enquiry_content").toString();
			}
		}
	}
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="JavaScript">
    function Check_Value()
	{
		if (deal_content.getText()=="" || document.reposForm.deal_content.value == null) 
		{                                                                                         
			alert("回复内容不可以为空！");                                                             
			document.reposForm.deal_content.focus();                                                    
			return false;                                                                            
		}                                                                                     
 	    return true;
	}
     function check_none(current_obj)
     {
          if (current_obj.advshow.checked)
          {
      	    current_obj.submit1.disabled=false;        	     
      	}
      	else
      	{
      	    current_obj.submit1.disabled=true;
      	}
  	 }
    	function confirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {  	    	
    	        if (!Check_Value())
    	        {
    	             return;
    	        }
    	         formobj.submit();   	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
</script>
	</head>
	<body>
		<form name=reposForm action=/doTradeReg.do method=post>
			<table width="820" border="0" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td height="26" background="/img/bg-1.gif">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td background="/img/bg-2.gif">
						<table width=95% border=0 cellpadding=10 cellspacing=1
							align=center bordercolor=#000000>

							<input name="trade_type_code" type="hidden" value="0238">
							<tr>
								<td class=graymn align=right>
									处理类型：
								</td>
								<td class=grayD align=left>
									<select name=deal_tag>
										<option value="1">
											已处理
										</option>
										<option value="2">
											垃圾留言
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class=graymn align=right>
									留言内容：
								</td>
								<td class=grayD align=left>
									<%=enquiry_content%>
								</td>
							</tr>
							<tr>
								<td class=graymn align=right>
									回复内容：
								</td>
								<td class=grayD align=left>
									<textarea name="deal_content" style="display: none"></textarea>
									<iframe ID=deal_content
										src=/www/ewebeditor/ewebeditor.htm?id=deal_content&style=coolblue&root_id=
										<%=trade_id%> frameborder=0 scrolling=no width=500 HEIGHT=350></iframe>
								</td>
							</tr>
							<input name="trade_id" type="hidden" value=<%=trade_id%>>
							<input name="enquiry_id" type="hidden" value=<%=enquiry_id%>>
							<tr>
								<td class=graymn colspan=2 align="left">
									<INPUT name="advshow" type="checkbox" value="0"
										onclick="check_none(reposForm)">
									以上资料正确无误。
								<td>
							</tr>
							<tr>
								<td class="graymn" align=right></td>
								<td class="graymn" align=right>
									<input name="submit1" type="button" value="提交" disabled="true"
										onclick="confirmsub(reposForm)">
								</td>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td height="46" background="/img/bg-3.gif">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




