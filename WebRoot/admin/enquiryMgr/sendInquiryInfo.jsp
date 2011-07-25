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
<%@ page import="com.saas.biz.advertiseMgr.AdvertiseInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
    String adv_id="";
    String content="";
    String show_no="";
    String adv_type="";
    String own_range="";
    if(request.getParameter("adv_id")!=null){
      adv_id=request.getParameter("adv_id");
    }
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	String start_date = format.format(new Date());
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.MONTH,3);
	String end_date=format.format(cal.getTime());
	ParamethodMgr paramCom = new ParamethodMgr();
	
	 AdvertiseInfo adverObj=new AdvertiseInfo();
     ArrayList advertList=adverObj.genOneAdvertise(adv_id);
	 if(advertList!=null && advertList.size()>0){
	   HashMap map=(HashMap)advertList.get(0);
	   if(map.get("content")!=null){content=map.get("content").toString();}
       if(map.get("show_no")!=null){ show_no=map.get("show_no").toString();}
       if(map.get("own_range")!=null){own_range=map.get("own_range").toString();}
       if(map.get("adv_type")!=null){adv_type=map.get("adv_type").toString();}
       if(map.get("start_date")!=null){start_date=map.get("start_date").toString();
       if(start_date.length()>10)
         {
           start_date=start_date.substring(0,10);
         }
       }
       if(map.get("end_date")!=null)
       {
         end_date=map.get("end_date").toString();
         if(end_date.length()>10)
         {
           end_date=end_date.substring(0,10);
         }
       }
	 }
	 adv_type = paramCom.getParamNameByValue("11",adv_type);
	 own_range = paramCom.getParamNameByValue("12",own_range);
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
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>
	<body>
	    <bean:define id="adver" value="<%=content%>"/>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#e7e7e7">
				<tr>
				 <td colspan="2"style="background-color:#ffffff; color:#000000;  font-size:12px;">&nbsp;</td>
				</tr>
				<tr>
					<td width="100" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						广告类型：
						<input name=adv_id type=hidden value="<%=adv_id%>">
						<input name=trade_type_code type=hidden value=0918>
					</td>
					<td width="604" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
								<%=adv_type%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						广告范围：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
								<%=own_range%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" valign="middle">
						广告内容：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<bean:write name="adver" filter="false"/>
					   </td>
				</tr>
				<tr>
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						开始时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=start_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						结束时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=end_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						显示顺序：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<%=show_no%>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




