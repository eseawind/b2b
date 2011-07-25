<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.SupplyInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<html>
	<head>
		<title>
		</title>
		<link rel="stylesheet" type="text/css" href="/templates/wood/style/wood.css" />	
		<link rel="stylesheet" type="text/css" href="/templates/wood/style/supply.css" />
    <script language="javascript" src="/templates/wood/js/top.js"></script>
    <script type="text/javascript" src="/js/prototype.js"></script>
    <script type="text/javascript" src="/templates/wood/js/setClassName.js"></script>
    <script language="javascript" type="text/javascript" src="/templates/wood/js/genInfo.js"></script>
    <script language="javascript" src="/templates/wood/js/changcode.js"></script>
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
	<%
		String pagtool="";
		int counter=0;
		String iStart="1";
		if(request.getParameter("iStart")!=null)
   {
    iStart=request.getParameter("iStart");
   }
		SupplyInfo infoBean=new SupplyInfo();
		ArrayList infoList=infoBean.genAdminList(Integer.parseInt(iStart),10);
		counter=infoBean.genAdminList();
		pagtool=tools.getGoogleToolsBar(counter,"imgLink.jsp?iStart=",Integer.parseInt(iStart),10);
	%>
	<div id="nav">
	</div>
<div id="area">
  <ul>
			<li><a href="/inc/areaLink.jsp?area=1">北京市</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=2">天津</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=3">河北</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=4">山西</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=5">内蒙古</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=6">辽宁</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=7">吉林</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=8">黑龙江</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=9">上海</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=10">江苏</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=11">浙江</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=12">安徽</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=13">福建</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=14">江西</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=15">山东</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=16">河南</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=17">湖北</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=18">湖南</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=19">广东</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=20">广西</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=21">海南</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=22">重庆</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=23">四川</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=24">贵州</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=25">云南</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=26">西藏</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=27">陕西</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=28">甘肃</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=29">青海</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=30">宁夏</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=31">新疆</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=32">台湾</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=33">香港</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=4590">澳门</a> |</li>
  </ul>
</div>
		<div >
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
								  <font><%=info_dsec%>                 </font><br>
								  <div class="button" style="float:left; margin-right:5px;"><a href="/wood/supply/d/content-<%=info_id%>.html">产品信息</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>">联系方式</a></div>								  </td>
                  <td class="list_right_cp_xian"><%=sale_addr%></td>
                  <td class="list_right_cp_xian"><%=in_date%></td>
                  <td class="list_right_cp_xian"><%=author%></td>
                </tr>                 
                 <%
                }
                %>
                <tr>
                	<td align="right" colspan="5">
                 <%=pagtool%>                </td>
               </tr>
               <%
               }
               %>
            </table>         
	</div>
		<div id="session_cust" ></div>
	</body>
</html>
<script>
	var val=window.opener.document.getElementById("nav").innerHTML;
	document.getElementById("nav").innerHTML=val;
	getCritiqueDiv('session_cust','5136025130');
	setTopName();
</script>
<script language="javascript" src="/templates/wood/js/footer.js"></script>
<script language="javascript" src="/templates/wood/js/loginOrNot.js"></script>



