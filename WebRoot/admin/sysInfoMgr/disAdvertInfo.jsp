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
		<title>广告查看</title>
	</head>
	<body>
	<!--table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>广告查看</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->
			<table width=100% border=0 cellpadding=2 cellspacing=2 align="center" bgcolor="#DEEDFD">
				<tr>
					<td align="right" valign="middle" bgcolor="white" width="20%">
						广告位标识：
					</td>
					<td  colspan="3"  bgcolor="white">
							<%=cust_adv_id%>
					</td>
				</tr>
				<tr>
					<td  align="right"  bgcolor="white">
						广告位名称：
					</td>
					<td  bgcolor="white">
							<%=adv_name%>
					</td>
					<td  align="right"  bgcolor="white">
						时间限制：
					</td>
					<td  colspan="3" bgcolor="white">
							<%
								if(time_limit.equals("0")){
							%>
								永不过期
							<%
								}
								if(time_limit.equals("1")){
							%>
								在设内时间内有效 
							<%
								}
							%>
					</td>
				</tr>
				<tr>
					<td  align="right" bgcolor="white">开始时间：
					</td>
					<td bgcolor="white">
							<%=start_date%>
					 
					</td>
					<td  align="right" bgcolor="white">结束时间：
					</td>
					<td bgcolor="white">
							<%=end_date%>
					 
					</td>
				</tr>						
				<tr>
					<td  align="right" valign="middle" bgcolor="white">
						正常显示内容：
					</td>
					<td colspan="3" bgcolor="white">
							<%=n_content%>
					</td>
				</tr>
				<tr>
					<td  align="right" valign="middle" bgcolor="white">
						过期显示内容：
					</td>
					<td colspan="3" bgcolor="white">
							<%=p_content%>
					</td>
				</tr>
				 <tr >
			      <td colspan="4" class="u3" align="center" bgcolor="white">
			      	<img src="/admin/images/comeback.JPG" onClick="jjavascript:window.history.go(-1);" style="cursor:hand;">
			      </td>
				 </tr>
			</table>
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




