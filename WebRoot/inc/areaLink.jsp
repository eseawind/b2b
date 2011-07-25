<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.saleMgr.SupplyInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="java.util.*"%>
<%
	String pagtool="";
		int counter=0;
		String iStart="1";
		String area="",areaName="";
		if(request.getParameter("iStart")!=null)
   {
    iStart=request.getParameter("iStart");
   }
   	if(request.getParameter("area")!=null)
   {
    area=request.getParameter("area");
   }
   AreaInfo areaInfo=new AreaInfo();
   areaName=areaInfo.getAreaNameByCode(area);

    if(areaName.length()>2)
     areaName=areaName.substring(0,2);
		SupplyInfo infoBean=new SupplyInfo();
		ArrayList infoList=infoBean.genAdminListArea(areaName,Integer.parseInt(iStart),10);
		counter=infoBean.genAdminListArea(areaName);
		
		pagtool=tools.getGoogleToolsBar(counter,"areaLink.jsp?area="+area+"&iStart=",Integer.parseInt(iStart),10);
%>
<head>
<link rel="stylesheet" type="text/css" href="/templates/wood/style/wood.css" />
<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
<script type="text/javascript" src="/templates/wood/js/setClassName.js"></script>
<script language="javascript" src="/templates/wood/js/changcode.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<script language="javascript" type="text/javascript" src="/templates/wood/js/genInfo.js"></script>
<script language="javascript" src="/templates/wood/js/top.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>浙江木业网(http://b2b.bizoss.com)</title>
<script language="javascript">
	function Search(){
		var keywd=document.getElementById("keyword").value;
     var tradeType=document.getElementById("tradeTypecode").value;
		if(keywd!=null&&keywd!=""&&keywd!="请输入您想查找的关键字"){
		window.open("/member/search/searchrst.html?"+keywd+","+tradeType);
	  }else{
		 alert("请输入关键字!");
		return;
		}				
	}
		
	function SearchNew(keyword,ch_id){
		var keyw = decodeURI(keyword);
		window.open("/member/search/searchrst.html?"+keyw+","+ch_id);			
	}
	
  function tradeType(val){
		document.getElementById("tradeTypecode").value=val;
	}
</script>
</head>
<body>
<!--头部-->
<!--菜单-->
<!--地区分类-->
 <div id="nav"></div>
 <div id="area"></div>


<!--内容-->
<div>
			  <table width="65%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" class="list_right_cp_lmt">产品图片</td>
                  <td width="46%" class="list_right_cp_lmt">公司/主营产品、服务</td>
                  <td width="12%" class="list_right_cp_lmt">供应地区</td>
                  <td class="list_right_cp_lmt">发布日期</td>
                  <td width="14%" class="list_right_cp_lmt">联系方式</td>
                </tr>
               <%
               if(infoList!=null)
               {
                for(int i=0;i<infoList.size();i++)
                {
                   HashMap map=(HashMap) infoList.get(i);
                  String cust_name="",sale_addr="", title="", in_date="",  info_dsec="",author="",info_id="",cust_id="";
                  String  mini_img="/images/default_wood.gif";
                  if(map.get("title")!=null)
                  {
                  title=map.get("title").toString();
                  }
                 if(map.get("sale_addr")!=null)
                  {
                  sale_addr=map.get("sale_addr").toString();
                  }
                  if(map.get("in_date")!=null)
                  {
                  in_date=map.get("in_date").toString();
                  }
                  if(map.get("mini_img")!=null)
                  {
                  mini_img=map.get("mini_img").toString();
                  }
                  if(map.get("info_dsec")!=null)
                  {
                  info_dsec=map.get("info_dsec").toString();
                  }
                  if(map.get("author")!=null)
                  {
                  author=map.get("author").toString();
                  }
                  if(map.get("info_id")!=null)
                  {
                  info_id=map.get("info_id").toString();
                  }
                  if(map.get("mini_img")!=null)
                  {
                   mini_img=map.get("mini_img").toString();
                  if("".equals(mini_img))mini_img="/images/default_wood.gif";
                  }
                  if(map.get("cust_id")!=null)
                  {
                   cust_id=map.get("cust_id").toString();
                  }
                 %>
                 <tr height="90">
                  <td class="list_right_cp_xian"><a href="/wood/supply/d/content-<%=info_id%>.html"><img src="<%=mini_img%>" border="0" width="100" height="75"></a></td>
                  <td class="list_right_cp_xian">
								  <span class="span"><a href="/wood/supply/d/content-<%=info_id%>.html"><%=title%></a></span><br>
								  <font><%=info_dsec%></font>
                 </font><br>
								  <div class="button" style="float:left; margin-right:5px;"><a href="/wood/supply/d/content-<%=info_id%>.html">产品信息</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>">联系方式</a></div>
								  </td>
                  <td class="list_right_cp_xian"><%=sale_addr%></td>
                  <td class="list_right_cp_xian"><%=in_date%></td>
                  <td class="list_right_cp_xian"><%=author%></td>
                </tr>                 
                 <%
                }
                %>
                <tr>
                	<td align="right" colspan="5">
                 <%=pagtool%>
                </td>
               </tr>
               <%
               }
               %>
            </table>         
			</div>	
<div id="session_cust" ></div>
<input type="hidden" name="area_id" id ="area_id" value="<%=area%>">
</body>
</html>
<script>
	var val=window.opener.document.getElementById("nav").innerHTML;
	document.getElementById("nav").innerHTML=val;
	var area=document.getElementById("area_id").value;
	getCritiqueDiv('session_cust','5136025130');
	getCritiqueDiv('area',area);
</script>
<script language="javascript" src="/templates/wood/js/footer.js"></script>
<script language="javascript" src="/templates/wood/js/loginOrNot.js"></script>



