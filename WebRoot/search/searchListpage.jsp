<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="gbk"%>   
<%request.setCharacterEncoding("gbk");%>
<%@ page language="java" import="java.util.*" errorPage="" %>
<%@ page import="com.saas.biz.searchMgr.SearchJob"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="com.saas.biz.custMgr.Custinfo" %>
<%	
	String infotype="",key="";
	int p = 0;	
	if(request.getParameter("p")!=null)
	{
		p=Integer.parseInt( request.getParameter("p") );
	}
	if(p!=0 && p>1){
	  p=p-1;
	}else if(p==1){
	  p=0;
	}
	if(request.getParameter("info_type")!=null)
	{
			infotype=request.getParameter("info_type");			
	}
	if(request.getParameter("key")!=null)
	{
			key=new String(request.getParameter("key").getBytes("ISO8859_1"),"GBK");	
			key=request.getParameter("key");	
	}	
	SearchJob searchjob = new SearchJob();
	ArrayList list = searchjob.doSearchoil(infotype,p*10,key,"");	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
<title>B2B电子商务平台--<%=key%></title>
<link href="mycss.css" rel="stylesheet" type="text/css">
<link href="/style/layout.css" rel="stylesheet" type="text/css">

</head>
<body>
    <jsp:include page="/include/top.jsp">
    	<jsp:param name="info_type" value="<%=infotype%>"/>
    		<jsp:param name="key" value="<%=key%>"/>
    </jsp:include>
	
<!--搜索框-->	
<table width="980" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <td height="42" valign="bottom" style="color:#666;"><span style="font-size:14px">您当前的位置：</span><a href="/"class="lanse">首页</a> > <a href="/" class="lanse">搜索信息</a></td>
  </tr>
</table>
<table width="980" height="30" border="0" align="center" cellpadding="10" cellspacing="1" bgcolor="DBECF4" >
<tr>
  <td bgcolor="ffffff">
<%
  	String counts="0",title="",ref="",linkstr="",path="/images/cp.gif";
  	String publisher="",publish_date="";
	if(list != null && list.size()>0){
		for (int i=0;i<list.size();i++){
			HashMap map = (HashMap)list.get(i);
			if(map.get("title")!=null){
			  title=map.get("title").toString();
			   title=title.replaceAll("<[^<>]+>",""); 
			  if(title.length()>20){
			    title=title.substring(0,15)+"...";
			  }
			}
			if(map.get("ref")!=null){ref=map.get("ref").toString();}
			if(map.get("linkstr")!=null){linkstr=map.get("linkstr").toString();}					
			if(map.get("pic_path")!=null){
				path = map.get("pic_path").toString();
			}
			if(path.equals(""))
				path="/images/cp.gif";
			if(map.get("count")!=null){counts=map.get("count").toString();}	
			if(map.get("publisher")!=null){publisher=map.get("publisher").toString();}
			Custinfo info = new Custinfo();
			String publish_name = info.getCustNameById(publisher);
			if(map.get("publish_date")!=null){publish_date=map.get("publish_date").toString();}	
			//取客户级别
			String para_code1 = new CustClass().getCustClassById(publisher);
			//取出级别图片
			String cust_img = param.getCustImgByParaCode1("1", para_code1);
			if(!cust_img.equals("")){
				cust_img = "<img src="+cust_img+" border=0 />";
			}
			
%>		
      
		<!--列表重复-->
		<div class="oil_search0_list" style="float:left; width:940px; padding-bottom:10px;" >
		<img src="<%=path%>" width=100 height=100 alt=搜索 border=0 style="float:left; margin-right:10px; margin-bottom:5px;">
		<a href="<%=linkstr%>"><%=title%></a><br>
		<%=ref%>...<br>
		 <%=publish_name%><%=cust_img%><%=publish_date%>
		</div>
		<!--结束//-->
		
<%	}		
	if(p==0){
     p=1;
    }else{
     p=p+1;
    }
   String pageTools = tools.getGoogleToolsBar(Integer.parseInt(counts), "searchListpage.jsp?key="+key+"&info_type="+infotype+"&p=",p,10);
%> </td>
  </tr>     
</table>

<table width="980" height="36" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
		 <span style="font-size:14px;"> <%=pageTools%></span></td>
      </tr>
</table>
<%
	  }
		else
		{
		%>
		没有搜索到您要查询的记录！
		<%
		}
	  
	  %>

<!--结束//-->		
	 <jsp:include flush="true" page="/include/footer.jsp" />
</body>
<script type="text/javascript">
  function checkR(info_type){
  redio_bnt = document.getElementsByName("redio_bnt");
  for(var i=0;i<redio_bnt.length;i++){
      redio_bnt[i].checked =false;
  }
  if (info_type = "0141"){
		document.getElementById("supply").checked=true;
	} else if (info_type = "0154") {
		document.getElementById("stock").checked=true;
	} else if (info_type = "0139") {
		document.getElementById("customer").checked=true;
	} else if (info_type = "0161") {
		document.getElementById("news").checked=true;
	}else if (info_type = "0560") {
		document.getElementById("product").checked=true;
	}
  }
</script>
</html>




