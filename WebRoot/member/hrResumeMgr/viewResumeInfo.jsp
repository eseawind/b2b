<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%
    String fbtime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String user_id="",userName="",grad_from="",profession="",wish="",born_date=fbtime,born_site="",
    phone="",email="",addr="",position="",age="",job_age="",grad_date=fbtime,work_history="",spec="",tel="",
    remark="",cert="",degree="";
    if(request.getParameter("user_id")!=null){
       user_id=request.getParameter("user_id");
    }
    ParamethodMgr paramCom=new ParamethodMgr();
    HashMap  degreeList =paramCom.getCompareInfoByCode("CRM","degree");
	HashMap  sexList =paramCom.getCompareInfoByCode("CRM","sex");
	HashMap  certList =paramCom.getCompareInfoByCode("CRM","cert");
    ResumeInfo resume=new ResumeInfo();
    //得到个人简历
	ArrayList resumeLists=resume.genResumeByUser_Id(user_id);
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/calendar.js"></script>
<script language="JavaScript" src="/js/hrJobMgr.js"></script>
<script language="javascript">
  var cdr = new Calendar("cdr");
  document.write(cdr);
  cdr.showMoreDay = true;
</script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>
<form name=resumeForm action=/doTradeReg.do method=post  target="_blank">
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td>
	<table width=100% border=0 cellpadding=5 cellspacing=1 align=center   bgcolor="#ECF5FD" >
      <%
	     if( resumeLists != null && resumeLists.size() > 0 )
		 {
	     	HashMap map=(HashMap)resumeLists.get(0);
	     	if( null != map.get("name") )
			{
	     		userName = map.get("name").toString();
	     	}
	     	if(map.get("grad_from")!=null)
	     	{
	       		grad_from=map.get("grad_from").toString();
	     	}
	        if(map.get("profession")!=null)
	     	{
	       		profession=map.get("profession").toString();
	     	}
	        if(map.get("wish")!=null)
	     	{
	       		wish=map.get("wish").toString();
	     	}
	        if(map.get("born_site")!=null)
	        {
	       		born_site=map.get("born_site").toString();
	    	}
	     	if(map.get("born_date")!=null)
	     	{
	       		born_date=map.get("born_date").toString();
			   if(born_date.length()>10)
			   {
				 born_date=born_date.substring(0,10);
			   }
			}
	        if(map.get("phone")!=null)
	     	{
	       		phone=map.get("phone").toString();
	     	}
	      	if(map.get("email")!=null)
	     	{
	       		email=map.get("email").toString();
	     	}
	      	if(map.get("addr")!=null)
	     	{
	       		addr=map.get("addr").toString();
	     	}
	      	if(map.get("position")!=null)
	     	{
	       		position=map.get("position").toString();
	     	}
	        if(map.get("age")!=null)
	     	{
	       		age=map.get("age").toString();
	     	}
	      	if(map.get("job_age")!=null)
	     	{
	       		job_age=map.get("job_age").toString();
	     	}
	      	if(map.get("grad_date")!=null)
	     	{
	       		grad_date=map.get("grad_date").toString();
	        	if( grad_date.length() > 10 )
	       		{
	         		grad_date=grad_date.substring(0,10);
	       		}
	     	}
	      	if(map.get("work_history")!=null)
	     	{
	       		work_history=map.get("work_history").toString();
	     	}
	      	if(map.get("spec")!=null)
	     	{
	       		spec=map.get("spec").toString();
	     	}
	     	if(map.get("tel")!=null)
	     	{
	       		tel=map.get("tel").toString();
	     	}
	     	if(map.get("remark")!=null)
	     	{
	       		remark=map.get("remark").toString();
	     	}
	     	if( map.get("cert") != null )
	     	{
	       		cert=map.get("cert").toString();
	     	}
	     	if(map.get("degree")!=null)
	     	{
	       		degree=map.get("degree").toString();
	     	}
	 %>
          <tr>
            <td align=right  width="15%">姓名</td>
            <td align=left  width="35%"><%=userName%></td>
            <td align=right>毕业学校</td>
            <td align=left><%=grad_from%>
            </td>
          </tr>
          <tr>
            <td align=right>专业</td>
            <td align=left><%=profession%>
            </td>
            <td align=right>期望薪资</td>
            <td align=left><%=wish%>
            </td>
          </tr>
          <tr>
            <td align=right>出生年月</td>
            <td align=left><%=born_date%></td>
            <td align=right>籍贯</td>
            <td align=left><%=born_site%>
            </td>
          </tr>
          <tr>
            <td align=right>联系电话</td>
            <td align=left><%=phone%>
            </td>
		    <td align=right>电子邮件</td>
            <td align=left><%=email%>
            </td>
          </tr>
          <tr>
            <td align=right>固定电话</td>
            <td align=left><%=tel%>
            </td>
            <td align=right>联系地址</td>
            <td align=left><%=addr%>
            </td>
          </tr>
          <tr>
            <td align=right>当前职位</td>
            <td align=left><%=position%>
            </td>
            <td align=right>年龄</td>
            <td align=left><%=age%>
            </td>
          </tr>
          <tr>
            <td align=right>性别</td>
            <td align=left>
            <%
            	if(remark !=null && !remark.equals("")){
					if(sexList != null && sexList.size()>0){
						out.print(sexList.get(remark));
					} 
				}
			%> 
            </td>
            <td align=right>学历</td>
            <td align=left>
             <%
                if(degree!=null && !degree.equals("")){
					if(degreeList != null && degreeList.size()>0){
						out.print(degreeList.get(degree));
					} 
			   }
			  %>
            </td>
          </tr>
          <tr>
            <td align=right>工作年限</td>
            <td align=left><%=job_age%>
            </td>
            <td align=right>毕业年份</td>
            <td align=left><%=grad_date%></td>
          </tr>
          <tr>
            <td style="WHITE-SPACE: nowrap;" align=right  valign=top>工作经历</td>
            <td  style="word-break:break-all;" align=left><%=work_history%></td>
          
            <td style="WHITE-SPACE: nowrap;" align=right valign=top>特殊技能</td>
            <td  style="word-break:break-all;" align=left><%=spec%></td>
          </tr>
          <input name="trade_type_code" type="hidden" value="0341">
          <tr>
            <td align=right>所获证书</td>
            <td align=left colspan=3>
            <%
           		if(cert!=null && !cert.equals("")){
					if(certList != null && certList.size()>0){
						out.print(certList.get(cert));
					} 
				}
			%>
            </td>
          </tr>
          <tr>
            <td align=center colspan=4>
            	<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;">
            </td>
          </tr>
          <% 
		   		}else{
		  %>
          <tr>
          	<td class="grayE" colspan=2 align="center">      
              	该用户还没有个人简历.
			</td>
		  </tr>
		  <tr>
          	<td colspan="3" align=center>
            	<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;">
            </td>
          </tr>
          <%
		  	} 
		%>        
      </table>
	 </td>
  </tr>
</table>
 </form>
</body>
</html>




