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
		if(keywd!=null&&keywd!=""&&keywd!="������������ҵĹؼ���"){
		window.open("/member/search/searchrst.html?"+keywd+","+tradeType);
	  }else{
		 alert("������ؼ���!");
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
			<li><a href="/inc/areaLink.jsp?area=1">������</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=2">���</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=3">�ӱ�</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=4">ɽ��</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=5">���ɹ�</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=6">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=7">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=8">������</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=9">�Ϻ�</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=10">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=11">�㽭</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=12">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=13">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=14">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=15">ɽ��</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=16">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=17">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=18">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=19">�㶫</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=20">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=21">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=22">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=23">�Ĵ�</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=24">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=25">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=26">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=27">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=28">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=29">�ຣ</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=30">����</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=31">�½�</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=32">̨��</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=33">���</a> |</li>
			<li><a href="/inc/areaLink.jsp?area=4590">����</a> |</li>
  </ul>
</div>
		<div >
			  <table width="65%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" class="list_right_cp_lmt">��ƷͼƬ</td>
                  <td width="46%" class="list_right_cp_lmt">��˾/��Ӫ��Ʒ������</td>
                  <td width="12%" class="list_right_cp_lmt">��Ӧ����</td>
                  <td class="list_right_cp_lmt">��������</td>
                  <td width="14%" class="list_right_cp_lmt">��ϵ��ʽ</td>
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
								  <div class="button" style="float:left; margin-right:5px;"><a href="/wood/supply/d/content-<%=info_id%>.html">��Ʒ��Ϣ</a></div> <div class="button" style="float:left;"><a href="/inc/include/InterimPages.jsp?cust_id=<%=cust_id%>">��ϵ��ʽ</a></div>								  </td>
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



