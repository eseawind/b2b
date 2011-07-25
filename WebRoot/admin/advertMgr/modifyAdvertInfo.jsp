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
   String date =new SimpleDateFormat("yyyy-MM-dd").format(new Date());
   String start_date=date;
    String end_date=date;

	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.MONTH,3);
	
	ParamethodMgr paramCom = new ParamethodMgr();
	
	 AdvertiseInfo adverObj=new AdvertiseInfo();
     ArrayList advertList=adverObj.genOneAdvertise(adv_id);
	 if(advertList!=null && advertList.size()>0){
	   HashMap map=(HashMap)advertList.get(0);
	   if(map.get("content")!=null){content=map.get("content").toString();}
       if(map.get("show_no")!=null){ show_no=map.get("show_no").toString();}
       if(map.get("own_range")!=null){own_range=map.get("own_range").toString();}
       if(map.get("adv_type")!=null){adv_type=map.get("adv_type").toString();}
     
    
       if(map.get("start_date") != null)
       {
          start_date=map.get("start_date").toString();
           if(start_date.length()>10)
          {
           start_date=start_date.substring(0,10);
          }
       }
       if(map.get("end_date") != null)
       {
          end_date=map.get("end_date").toString();
          if(end_date.length()>10)
          {
           end_date=end_date.substring(0,10);
          }
       }
	 }
	 adv_type = paramCom.getItemsBySelected("11",adv_type);
	 own_range = paramCom.getItemsBySelected("12",own_range);
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
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
    	 function confirmsub()
    	 {
    	    var adv_type=$F("adv_type");
    	    if (adv_type=="" || adv_type==null) 
			    {                                                                                         
			     	alert("选择广告类型！");                                                             
				    $("adv_type").focus();                                                    
				    return false;                                                                            
			    }                                                                                      
            var own_range=$F("own_range");
			if (own_range =="" || own_range==null) 
			{                                                                                         
				alert("选择出现的范围！");                                                             
				$("own_range").focus();                                                    
				return false;                                                                            
			}
			var str=content.getHTML();
			str=str.replace(/\s*/g,""); 
			if(str == ""  )
			{
				alert("请填写广告的内容！");
				return false;
			}
	
			 if(document.getElementById("start_date").value.replace(/\s*/g,"")=="" || document.getElementById("start_date").value.replace(/\s*/g,"")==null)
				{
					alert("开始日期不能为空!!!");
					document.getElementById("start_date").focus();
					return false;
				}
			  if(document.getElementById("end_date").value.replace(/\s*/g,"")=="" || document.getElementById("end_date").value.replace(/\s*/g,"")==null)
				{
					alert("结束日期不能为空!!!");
					document.getElementById("end_date").focus();
					return false;
				}

						 if(document.getElementById("show_no").value=="" || document.getElementById("show_no").value==null)
		{
			alert("请填写显示顺序！");
			document.getElementById("show_no").focus();
			return false;
		}
			if(!checkDate(document.getElementById("start_date").value,document.getElementById("end_date").value)){
		     return false;
		   }
    	       return true;         
    	    }
    	    
    	    
  </script>
	</head>
	<body>
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
						<div class="ping">
							<select name=adv_type>
							    <option value="">请选择</option>
								<%=adv_type%>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						广告范围：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping">
							<select name=own_range>
								<option value="0">企业中心</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" valign="middle">
						广告内容：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping">
							<textarea name=content style=display:none><%=content%></textarea>
							<iframe id="content" src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=adv_id%>" frameborder=0 scrolling=no width=600 height=350></iframe>
					</td>
				</tr>
				<tr>
					
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						开始时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping">
							<input name="start_date" id="start_date" type="text" value="<%=start_date%>" onfocus="setday(this);" style="width:93px">(yyyy-mm-dd)
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						结束时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping">
							<input name="end_date" id="end_date" type="text" value="<%=end_date%>" onfocus="setday(this);" style="width:93px">(yyyy-mm-dd)
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						显示顺序：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping">
							<input name="show_no" type="text" size=5 maxlength=10 value="<%=show_no%>" onkeyup="if(isNaN(this.value))this.value=''">
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2" align="center" style="background-color:#f6f6f6; color:#000000;  font-size:12px;">
						<input class="xgan" type="submit" value="" onClick=" return confirmsub()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



