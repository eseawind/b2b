<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>��Ա�Ƹ�����</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;}
		 .t1{background-color:#ffffff; color:#000000;font-size:12px;}
		 .t2{background-color:#f6f6f6; color:#000000;font-size:12px;}
		</style>
		<script type="text/javascript">
		   function chechIfo()
		  {
			   if(confirm('�Ƿ�ȷ��ɾ��������¼��')) 
			{
				return true;
			}
			else
			{
				return false;
			}
		  }
		</script>
		<% String iStart ="0";
   	if(request.getParameter("iStart")!=null){
   		iStart = request.getParameter("iStart");
   	}
		ArrayList list = comparam.getCompareInfoByAttrF("101",Integer.parseInt(iStart));
		int counter = 0;
		if(list!=null && list.size()>0){
			counter = list.size();
		}
		int pages = counter / 20 + 1;
		int pageUp = 0, pageDown = 0;
		int currenPage = Integer.parseInt(iStart);
		if (pages > currenPage) {
			if (currenPage > 0) {
				pageUp = currenPage - 1;
			}
			pageDown = currenPage + 1;
		} else if (pages == currenPage) {
			pageUp = currenPage - 1;
			pageDown = currenPage;
		}	 
		
		%>
	</head>
	<body>
			
								<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#FCB0B0">
									<tr class="u4" height="25">
										<td align="left" width="15%">
											��Ա����
										</td>
										<td align="left" width="30%">
											��Ա����
										</td>
										<td align="left" width="15%">
											�����ƽ�����
										</td>
										<td  align="center" width="15%">
											��������
										</td>
										<td align="center" width="15%">
											ɾ��
										</td>
									</tr>
									<%
									  if(list !=null && list.size()>0){
									    for(int i=0;i<list.size();i++){
									       HashMap map=(HashMap)list.get(i);
									       String para_code1="";
									       if(map.get("para_code1")!=null){para_code1=map.get("para_code1").toString();}
									       String para_code2="";
									       if(map.get("para_code2")!=null){para_code2=map.get("para_code2").toString();}
									       String para_code3="";
									       if(map.get("para_code3")!=null){para_code3=map.get("para_code3").toString();}
									       String para_code4="";
									       if(map.get("para_code4")!=null){para_code4=map.get("para_code4").toString();}
									       String para_code5="";
									       if(map.get("para_code5")!=null){para_code5=map.get("para_code5").toString();}
									       if(i%2==0){
									        out.print("<tr class=u2>");
									       }else{
									        out.print("<tr class=u2>");
									       }
									 %>
										<td align="left" width="15%">
											<%=para_code5%>
										</td>
										<td align="left" width="30%">
											<%=para_code2%>
										</td>
										<td align="left" width="15%">
											<%=para_code3%>���ƽ�
										</td>
										<td align="center" width="15%">
											<a href="editWealth.jsp?code1=<%=para_code1%>&code4=<%=para_code4%>" onclick="mydefss()"><img src=/images/edit.png width=16 height=16 border=0 alt="�������û�Ա�Ƹ�"></a>
										</td>
										<td align="center" width="15%">
											<a href="/doTradeReg.do?para_code1=<%=para_code1%>&trade_type_code=1189&subsys_code=B2B&param_attr=101&amp;para_code4=<%=para_code4%>" onclick="return chechIfo()" target="_self" ><img src=/images/del.gif width=16 height=16 border=0 alt="ɾ����Ա�Ƹ�����"></a>
										</td>
								 
									 <%      
									    }
									  }else{
						%>
						<tr align=center ><td colspan="5">���޼�¼!</td></tr>
									  	<%}
									%><tr>
										<td background="/images/kehu_list_17.gif"  align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">��<%=counter%>�� &nbsp;��<%=Integer.parseInt(iStart)+1 %>ҳ&nbsp;&nbsp;��<%=pages%>ҳ</td>
										<td background="/images/kehu_list_17.gif" align="right" colspan="6"  style=" padding:2px 5px;">
										<a href="indexMgr.jsp?iStart=0">��ҳ </a>&nbsp; &nbsp;
										<% 
											if(Integer.parseInt(iStart)>0){
										%>
											<a href="indexMgr.jsp?Start=<%=pageUp%>">��һҳ</a> &nbsp;
										<%
											}
											if(Integer.parseInt(iStart)<pages-1){
										%>
											<a href="indexMgr.jsp?iStart=<%=pageDown%>">��һҳ </a>&nbsp; 
										<%
											}
										%>
										<a  href="indexMgr.jsp?iStart=<%=pages-1%>">βҳ</a></td>
			
							         </tr>
								</table>
	</body>
</html>



