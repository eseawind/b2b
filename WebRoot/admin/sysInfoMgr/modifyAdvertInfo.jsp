<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.saas.biz.advertiseMgr.AdvertiseInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />

<%
	ChannelInfo info = new ChannelInfo();
	String chselect = info.getChannelItems("0000000000");
	String adv_id="";
	if(request.getParameter("adv_id")!=null){
		adv_id = request.getParameter("adv_id");
	}
	AdvertiseInfo adverObj=new AdvertiseInfo();
  ArrayList advertList=adverObj.genOneAdvertise(adv_id);
	String cust_adv_id="",ch_id="",ch_name="",adv_name="",time_limit="",start_date="",end_date="",n_content="",p_content="";
  if(advertList!=null && advertList.size()>0){
	   HashMap map=(HashMap)advertList.get(0);
	   	 if(map.get("cust_adv_id")!=null){cust_adv_id=map.get("cust_adv_id").toString();}
       if(map.get("ch_id")!=null){ 
       	ch_id=map.get("ch_id").toString();
       	ch_name = info.getChName(ch_id);
       }
       if(map.get("adv_name")!=null){adv_name=map.get("adv_name").toString();}
       if(map.get("time_limit")!=null){
       		time_limit=map.get("time_limit").toString();
       }
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
       if(map.get("n_content")!=null){n_content=map.get("n_content").toString();}
       if(map.get("p_content")!=null){p_content=map.get("p_content").toString();}
	 }
%>

<html>
	<head>
		<title>广告修改</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AdvertiseInfo.js'></script> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
    	function confirmsub(){
	    	if($("cust_adv_id").value.replace(/\s*/g,"")=="" || $("cust_adv_id").value.replace(/\s*/g,"")==null)
				{
					alert("广告位标识不能为空!");
					$("cust_adv_id").focus();
					return false;
				}
				if($("adv_name").value.replace(/\s*/g,"")=="" || $("adv_name").value.replace(/\s*/g,"")==null)
				{
					alert("广告位名称不能为空");
					$("adv_name").focus();
					return false;
				}
			    if($("start_date").value.replace(/\s*/g,"")=="" || $("start_date").value.replace(/\s*/g,"")==null)
				{
					alert("开始日期不能为空!!!");
					$("start_date").focus();
					return false;
				}
			    if($("end_date").value.replace(/\s*/g,"")=="" || $("end_date").value.replace(/\s*/g,"")==null)
				{
					alert("结束日期不能为空!!!");
					$("end_date").focus();
					return false;
				}
		    if(!checkDate($("start_date").value,$("end_date").value)){
				   return false;
				}
				var str=n_content.getHTML();
				str=str.replace(/\s*/g,""); 
				if(str == ""  )
				{
					alert("请填写正常显示内容！");
					return false;
				}
				var str_p=p_content.getHTML();
				str_p=str_p.replace(/\s*/g,""); 
				if(str_p == ""  )
				{
					alert("请填写过期显示内容！");
					return false;
				}
	     return true;         
    }
    
    function checkCustAdv(val){
    	AdvertiseInfo.checkCustAdvId(val,setData);
    }
    function setData(val){
    	if(val==1){
    		alert('广告位标识已存在，请重新输入！');
    		document.getElementById('cust_adv_id').value='';
    	}else{
    		
    	}
    }
        
  </script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="modifyAdvertIndex.jsp"><b>广告管理</b></a>
				</td>
			</tr>
		</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 align="center" bgcolor="#DEEDFD">
				<tr>
					<td class="u1" valign="middle">
						广告位标识：
					</td>
					<td class="u2" colspan="3">
							<input type="text" name="cust_adv_id" id="cust_adv_id" size="20" maxlength="20" value="<%=cust_adv_id%>" onblur="checkCustAdv(this.value)">
							<input type="hidden" name="ch_id" value="">
					</td>
				</tr>
				<tr>
					<td class="u1" valign="middle">
						广告位名称：
					</td>
					<td class="u2"><div>
							<input type="text" name="adv_name" id="adv_name" size="20" maxlength="20" value="<%=adv_name%>">
					</td>
					<td class="u1" valign="middle">
						时间限制：
					</td>
					<td class="u2" colspan="3"><div>
							<input type="radio" name="time_limit" value="0" 
							<%
								if(time_limit.equals("0")){
							%>
								checked
							<%
								}
							%>
							>永不过期 &nbsp;<input type="radio" value="1" name="time_limit"
							<%
								if(time_limit.equals("1")){
							%>
								checked
							<%
								}
							%>
							>在设内时间内有效 
					</td>
				</tr>
				<tr>
					<td class="u1">开始时间：
					</td>
					<td class="u2"><div>
							<input name="start_date" id="start_date" type="text" value="<%=start_date%>" onfocus="setday(this);" style="width:93px">
							(yyyy-mm-dd)
						</div>
					</td>
					<td class="u1">结束时间：
					</td>
					<td class="u2"><div>
							<input name="end_date" id="end_date" type="text" value="<%=end_date%>" onfocus="setday(this);" style="width:93px">
							(yyyy-mm-dd)
						</div>
					</td>
				</tr>						
				<tr>
					<td class="u1" valign="middle">
						正常显示内容：
					</td>
					<td class="u2" colspan="3"><div>
							<textarea name=n_content style=display:none><%=n_content%></textarea>
							<iframe id="n_content" src="/www/ewebeditor/ewebeditor.htm?id=n_content&style=coolblue&root_id=<%=adv_id%>" frameborder=0 scrolling=no width=680 height=350></iframe>
					</td>
				</tr>
				<tr>
					<td class="u1" valign="middle">
						过期显示内容：
					</td>
					<td class="u2" colspan="3"><div>
							<textarea name=p_content style=display:none><%=p_content%></textarea>
							<iframe id="p_content" src="/www/ewebeditor/ewebeditor.htm?id=p_content&style=coolblue&root_id=<%=adv_id%>" frameborder=0 scrolling=no width=680 height=350></iframe>
					</td>
				</tr>
				
			
				<tr>
					<td height="30" colspan="4" class="u3">
						<input class="tjan" type="submit" value="" onClick=" return confirmsub()">&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" onClick="location.href='modifyAdvertIndex.jsp'" style="cursor:hand;" align="absmiddle">
						<input name=adv_id type=hidden value="<%=adv_id%>">
						<input name=trade_type_code type=hidden value=0918>
						<input name="info_type" id="info_type" type=hidden value="2">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<script language="javascript">
	function ResizeImages()
	{
	   var myimg,oldwidth;
	   var maxwidth=250;
	   for(i=0;i<document.images.length;i++){
	     myimg = document.images[i];
	     if(myimg.width > maxwidth)
	     {
	        oldwidth = myimg.width;
	        myimg.style.width = maxwidth;
	        myimg.style.height = "auto";
	     }
	   }
	}
	ResizeImages();
  </script> 



