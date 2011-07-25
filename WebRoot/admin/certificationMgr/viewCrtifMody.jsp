<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String verify_id = "";
	String req_desc = "";
	String remark = "";
	String verify_type = "",cust_id="";
	String obj_cust_id="";
	String cust_id_one="";
	HttpSession  logsession = request.getSession(); 
	if (request.getParameter("verify_id") != null) {
		verify_id = request.getParameter("verify_id");
	}
	 if (logsession.getAttribute("SESSION_CUST_ID") != null)
  {
        cust_id_one = logsession.getAttribute("SESSION_CUST_ID").toString();
  }
	if (request.getParameter("obj_cust_id") != null) {
		obj_cust_id = request.getParameter("obj_cust_id");
	}
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String req_date = date;
    String verify_name="";
    String verify_status="";
	VerifyInfo adverObj = new VerifyInfo();
//	ArrayList advertList = adverObj.genVerifyByCust_id("7Dey6q4wp57u704");
ArrayList advertList = adverObj.genVerifyByCust_id(cust_id_one);
	if (advertList != null && advertList.size() > 0) {
		HashMap map = (HashMap) advertList.get(advertList.size()-1);
		if (map.get("req_desc") != null) {
			req_desc = map.get("req_desc").toString();
		}
		if (map.get("cust_id") != null) {
			cust_id = map.get("cust_id").toString();
		}
		if (map.get("remark") != null) {
			remark = map.get("remark").toString();
		}
		if (map.get("verify_type") != null) {
			verify_type = map.get("verify_type").toString();
			verify_type = param.getParamNameByValue("100", verify_type);
		}
		if (map.get("verify_name") != null) {
			verify_name = map.get("verify_name").toString();
		}
		if (map.get("req_date") != null) {
			req_date = map.get("req_date").toString();
			if (req_date.length() > 10) {
		     req_date = req_date.substring(0, 10);
			}
		}
		if (map.get("verify_status") != null) {
			verify_status = map.get("verify_status").toString();
			
		}
	}
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		
		<style type="text/css">
		 form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
		</style>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		 <script type="text/javascript">
		   function checkValue(){
		    if(window.confirm("确定要提交所执行的操作？")){
		      return true;
		    }else{
		      return false;
		    }
		   }
		   
		function secBoard(n)
		{
			for(i=0;i<2;i++) {
				if (i==n) {
					document.all('d' + n).className="c4";
				} else {
				document.all('d' + i).className="c3";}
			}
			
			for(i=0;i<2;i++) {
				if (i==n) {
					document.all('bo' + n).style.display="";					
				} else {
				document.all('bo' + i).style.display="none";}
			}

	}		
		 </script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
		  	
		  	<!--td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center" id="d0" onclick="javascript:secBoard(0)"><font size="2"><b>客户信息</b></font></td-->
				<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center" id="d1" ><font size="2"><b>审批信息</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
					
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
	  <%
	   if(null!=advertList &&advertList.size()> 0)
	   {
	  %>
	  <table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#e7e7e7"  id="bo1">
				<tr>
					<td width="100" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"  class="l_td">
						认证类型：
						<input name=verify_id type=hidden value="<%=verify_id%>">
						<input name=verify_type type=hidden value="<%=verify_type%>">
					</td>
					<td align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_type%>
						</div>
					</td>
					<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"  class="l_td">
						认证证件：
						<input name=verify_id type=hidden value="<%=verify_id%>">
						<input name=verify_type type=hidden value="<%=verify_type%>">
					</td>
					<td  align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_name%>
						</div>
					</td>
				</tr>				
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" class="l_td">
						申请原由：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
						<bean:define id="des" value="<%=req_desc%>"/>
						<bean:write name="des" filter="false"/>
					</td>
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						申请时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=req_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						审核结果：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
						<div class="ping1">
							<%if(verify_status.equals("1")){%>
							审核通过
						<%}else if(verify_status.equals("2")){%>										
							审核不通过
						<%}else if(verify_status.equals("0")){%>										
							未通过
             <%}else{%>
              <table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#eee7ee" >
						   	<tr>		  	
							  <td colspan="4" class="u3">
							  	您的认证申请正在被审核，请耐心等待结果！					   
								</td>
								</tr>
						   </table>	
             <%}%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						原因：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
						<div class="ping1">
							<textarea name="remark" cols="50" rows="6" readonly ><%=remark%></textarea>
						</div>
					</td>
				</tr>
				<input name="cust_id" type="hidden" size=35 maxlength=100 value="<%=cust_id%>">
				<input name=trade_type_code type=hidden value=0948>			
			</table>
    <%
     }else
    	{
	  %>
	    <table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#eee7ee" >
	   	<tr>		  	
		  <td colspan="4" class="u3">
		  	您还未申请认证！					   
			</td>
			</tr>
	   </table>	  
     <%
     }
	  %>
	   <table width=800 border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#eee7ee" >
	   	<tr>
					<td colspan="4" class="u3">
					      	<img src="/admin/images/gb.gif" onClick="javascript:window.open('','_self','');window.close();" style="cursor:hand;">
					</td>
			</tr>
	  </table>
		</form>
	</body>
</html>



