
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.attachMgr.Attachinfo"%>
<%@ page import="com.saas.biz.pricerankMgr.PriceRankInfo" %>
<%@ page import="tools.util.StringUtil" %>
<%

        Attachinfo attinfo=new Attachinfo();
				PriceRankInfo rankInfo=new PriceRankInfo();
				ArrayList inofList = new ArrayList();
				ArrayList attlist= new ArrayList();
      
     String ch_id="",title="",link="",tele="",publish_date="",addr="",content="",img="";
      if (request.getParameter("ch_id") != null)
         ch_id=request.getParameter("ch_id");
         
        inofList= rankInfo.getRankByChId(ch_id);
     

%>
<html>
<head>
<title>修改页面导航</title>

<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
<script type="text/javascript">
<!--
function iframeAutoFit()
{
try
{
if(window!=parent)
{
var a = parent.document.getElementsByTagName("IFRAME");
for(var i=0; i<a.length; i++) //author:meizz
{
if(a[i].contentWindow==window)
{
var h1=0, h2=0, d=document, dd=d.documentElement;
a[i].parentNode.style.height = a[i].offsetHeight +"px";
a[i].style.height = "10px";

if(dd && dd.scrollHeight) h1=dd.scrollHeight;
if(d.body) h2=d.body.scrollHeight;
var h=Math.max(h1, h2);

if(document.all) {h += 4;}
if(window.opera) {h += 1;}
a[i].style.height = a[i].parentNode.style.height = h +"px";
}
}
}
}
catch (ex){}
}
if(window.attachEvent)
{
window.attachEvent("onload", iframeAutoFit);
//window.attachEvent("onresize", iframeAutoFit);
}
else if(window.addEventListener)
{
window.addEventListener('load', iframeAutoFit, false);
//window.addEventListener('resize', iframeAutoFit, false);
}
//-->
</script> 

<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
.tjan{
     background: url(/admin/images/tj.gif) left center no-repeat;
	 width:78px;
	 height:32px;
	 border:0px; 
	 cursor:hand;
	 }
</style>
</head>
<body leftmargin="0" topmargin="0">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="background-color:#FFD2D2">
                <!--tr>
                  <td width="16%" class="list_right_cp_lmt">产品图片</td>
                  <td width="46%" class="list_right_cp_lmt">公司/主营产品、服务</td>
                  <td width="12%" class="list_right_cp_lmt">供应地区</td>
                  <td class="list_right_cp_lmt">发布日期</td>
                  <td width="14%" class="list_right_cp_lmt">联系方式</td>
                </tr-->                
        <%
          if(inofList != null && inofList.size()>0)
          {
           for(int i=0;i<inofList.size();i++){
           HashMap map=(HashMap)inofList.get(i);
           if(map.get("title")!=null)
           {
             title=map.get("title").toString();
           }
           if(map.get("link")!=null)
           {
             link=map.get("link").toString();
           }
           if(map.get("publish_date")!=null)
           {
             publish_date=map.get("publish_date").toString();
           }
           if(map.get("rsrv_str4")!=null)
           {
             tele=map.get("rsrv_str4").toString();
  
           }
           if(map.get("rsrv_str7")!=null)
           {
            addr=map.get("rsrv_str7").toString();
           
           }
            if(map.get("content")!=null)
           {
            content=map.get("content").toString();
            content= StringUtil.substr(content, 25);
           }
           if(map.get("rsrv_str6")!=null)
           {
            img=map.get("rsrv_str6").toString();
              attlist=  attinfo.getFilePath(img);           
             if(attlist!=null&&attlist.size()>0){          
                HashMap map1=(HashMap)attlist.get(0);
                if(map1.get("file_path")!=null)
                img=map1.get("file_path").toString();
             }else
             	{
             	img="/upload/3fwMjTy8m0V4w45/67WC6dP0357L1rk.jpg";
             	}
            img="<img src="+img+ " border=0 width=100 height=75>";
           }
     
     %>
                <tr height="90">
                  <td class="list_right_cp_xian" width="16%"><a href="<%=link%>" target="_blank"><%=img%></a></td>
                  <td class="list_right_cp_xian" width="46%">
								  <span class="span"><a href="<%=link%>" target="_blank"> <%=title%></a></span><br>
								  <font><%=content%></font><br>
								  <div class="button" style="float:left; margin-right:5px;"><a href="<%=link%>" target="_blank">产品信息</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=[field:info_id/]" target="_blank">联系方式</a></div>
								  </td>
                  <td class="list_right_cp_xian" width="12%"><%=addr%></td>
                  <td class="list_right_cp_xian"><%=publish_date%></td>
                  <td class="list_right_cp_xian" width="14%"><%=tele%></td>
                </tr>


<%   }
     }%>
              </table>
              
	 
</body>
</html>


























  


