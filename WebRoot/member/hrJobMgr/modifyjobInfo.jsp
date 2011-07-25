<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>


<%
 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
 String job_id="";
 String title="";
 String req="";
 String job_addr="",job_type="";
 String class_id = "7830633062";
 commMethodMgr commen = new commMethodMgr();
 String idx = commen.GenTradeId();
 
 if (request.getParameter("job_id") != null)
  {
      job_id = request.getParameter("job_id");
  }
 JobInfo jobObj=new JobInfo();
 ArrayList jobList=new ArrayList();
 if(job_id != null && ! job_id.equals(""))
 {
   jobList=jobObj.genOneJob(job_id);
   if(jobList != null && jobList.size()>0)
   {
      HashMap map=(HashMap)jobList.get(0);
       job_id=map.get("job_id").toString();
       if(map.get("title") != null)
       {
          title=map.get("title").toString();
       }
      if(map.get("job_type") != null)
       {
          job_type = map.get("job_type").toString();
       }
       
       if(map.get("request") != null)
       {
          req=map.get("request").toString();
       }
       
       if(map.get("job_addr") != null)
       {
          job_addr=map.get("job_addr").toString();
       }
   }
 }
 
 ParamethodMgr paramCom = new ParamethodMgr();
 ArrayList jobTypeList = paramCom.getCompareInfo("CRM", "job_type");
 
 String job_type_name = paramCom.getParaCode2ByParaCode1("17",job_type);
 String chanal_id = "0341146200";
 
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script language="JavaScript" src="/js/hrJobMgr.js"></script>
</head>
		<script language="JavaScript">
			function Check_Value_My(){
				if(document.getElementById('title').value==''){
					alert('请填写标题！');
				return false;
			}
			 return true;
		}
		</script>
		<script language="JavaScript">
		function clickSel(val,valId){
			var tt = document.getElementById("contents").value;
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==false){
					tt='10'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==true){
					tt='01'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==false){
					tt='00'
				}
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==true){
					tt='11'
				}
			document.getElementById("contents").value = tt;
		}
		</script>
<body>
	<form name=form1 action=/doTradeReg.do method=post target="_self">
					<table width=100% border="0" cellspacing="1" cellpadding="1" align="center">
						<tr class="u1">
						   	<td align='left' colspan='4' class="head">
						   		<a href="/member/hrJobMgr/updatejobindex.jsp">招聘信息管理</a>
						   	</td>
						  </tr>
							<tr>
				<tr>
					<td>
						<!--1-->
						<jsp:include  flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="5"/>
							<jsp:param name="news_id" value="<%=job_id%>"/>
							<jsp:param name="ch_id" value="<%=chanal_id%>"/>
							<jsp:param name="class_id" value=""/>
						</jsp:include>
			
			<!--2-->
		 <table width=100% border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd"  id="bo1"  >
				          
			            <tr>
			             <td class="u1" width="25%">职位标题：</td>
			             <td  style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;">
			             	<input type=text name=title value="<%=title%>"></td>
			           </tr>
			           
			           <tr>
								<td class="u1">
									职位类型：
								</td>
								<td class="u2">
									<select name=job_type>
										<option value="<%=job_type%>"><%=job_type_name%></option>		
										<%
												if (jobTypeList != null && jobTypeList.size() > 0) {
												for (int i = 0; i < jobTypeList.size(); i++) {
													HashMap map = (HashMap) jobTypeList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>
										</option>
										<%
											}
											}
										%>
									</select>
								</td>
							</tr>
			           
			           
					    <tr>
			             <td class="u1">工作地址：</td>
			             <td align=left   style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;">
			             		<input name="job_addr" id="job_addr" type="text" value="<%=job_addr%>" maxlength="50" size="20"/>
			             </td>
			           </tr>
			          <tr>
			          <td class="u1">招聘要求：</td>
			          <td  class="line" style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
			          	
			          	<textarea name="request" id="request" style=display:none><%=req%></textarea>
										<iframe ID=request src=/www/ewebeditor/ewebeditor.htm?id=request&style=coolblue&root_id=<%=job_id%> frameborder=0 scrolling=no width=720 HEIGHT=350></iframe>
			          </td>
			        </tr>
			      </table>
				<script language=javascript>
						function secBoard(n)
						{
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('d' + n).className="c4";
								} else {
								document.all('d' + i).className="c3";}
							}
							
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('bo' + n).style.display="";
								} else {
								document.all('bo' + i).style.display="none";}
							}
		
					}
				</script>
			<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
			     		<input type=hidden name=rsrv_num1 value=0>	   
			     		<input type=hidden name=job_id value="<%=job_id%>">
			      		<input type=hidden name=trade_type_code value="0387">
						<input type="hidden" name="info_id" id="info_id" value=<%=job_id%>>
						<input type="hidden" name="remark" id="remark" value="">
			    <tr>
			      <td align="center"  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" colspan="2">
			      	<input class="tjan" name=submit type=submit value=""  onclick="return modifyjobInfoCheck_Value()">
			      	&nbsp;&nbsp;&nbsp;&nbsp;
			      	<input class="comeback" name=submit1 type=button value=""  onclick="window.location.href='/member/hrJobMgr/updatejobindex.jsp';">
			      </td>
			    </tr>
			</table>  
			</form>
</body>
</html>




