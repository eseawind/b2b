<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.advertiseMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custpersonMgr.CustPersonInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page"/>

<%
    String resume_id=bean.GenShortTradeId();
    String fbtime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());    
    Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR, -20);
	String end_date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());     
    String user_id="";  
    if ( session.getAttribute("SESSION_USER_ID") != null)
    {
         user_id = session.getAttribute("SESSION_USER_ID").toString();
    }
    if (session.getAttribute("SESSION_USER_ID") != null)
    {
        resume_id = session.getAttribute("SESSION_USER_ID").toString();
    }

    ParamethodMgr paramCom=new ParamethodMgr();
	ArrayList  degreeList =paramCom.getCompareInfo("CRM","degree");
	ArrayList  sexList =paramCom.getCompareInfo("CRM","sex");
	ArrayList  certList =paramCom.getCompareInfo("CRM","cert");
	CustPersonInfo personInfo = new CustPersonInfo();
	UserInfo userOjb = new UserInfo();
	Custinfo custInfo = new Custinfo();
	
	ArrayList userList = userOjb.getUserInfoByUserId(user_id);
	String company="";
	String cust_id = "";
	String userName="";
	if (userList != null && userList.size() > 0) 
	{
		HashMap map = (HashMap) userList.get(0);
		if (map.get("user_name") != null) 
		{
			userName = map.get("user_name").toString();
			cust_id = map.get("cust_id").toString();
		}
		if(cust_id!=null && cust_id!="")
		{
			ArrayList comList = custInfo.getCustInfo(cust_id);
			if( comList != null && comList.size() > 0 )
			{
				HashMap comMap = (HashMap)comList.get( 0 );
				if(comMap.get("cust_name") != null )
				{
					company = comMap.get("cust_name").toString();
				}
			}
			if( company.equals("") )
			{
				company = userName;
			}
		}
	}
	//userName = userInfo.getUserNameByUserId(resume_id);
%>
<html>
<head>
<title>B2B���������̨����ϵͳ</title>
<link href="/style/layout1.css" rel="stylesheet" type="text/css">

<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script src="/www/fuction/calendar.js" type="text/javascript"></script>
<script language="JavaScript" src="/www/fuction/public.js"></script>
<script language="JavaScript" src="/js/hrResumeMgr.js"></script>
</head>
<body>
	(��<font color="red">*</font>Ϊ������)
	<form name=resumeForm action=/doTradeReg.do method=post  target="_self">
	<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
        	<input name="resume_id" type="hidden" value="<%=resume_id%>">
          <tr>
            <td class="u1">����</td>
            <td class="u2">
            	<div class="ping1">
            		<input name="name" type="text" size=15 maxlength=30 value="<%=company%>" ><font color="red">*</font>
            	</div>
            </td>
            <td class="u1">��ҵѧУ</td>
            <td class="u2">
						<div class="ping1"><input name="grad_from" type="text" size=20 maxlength=50><font color="red">*</font>
						</div>
            </td>
          </tr>
          <tr>
            <td class="u1"t>רҵ</td>
            <td class="u2">
			<div class="ping1">
			<input name="profession" type="text" size=20 maxlength=50 ><font color="red">*</font>
			</div>
            </td>
             <td class="u1">����н��</td>
            <td class="u2">
						<div class="ping1">
						<input name="wish" type="text" size=25 maxlength=25>(/��)<font color="red">*</font>
						</div>
            </td>
          </tr>

          <tr>
            <td class="u1">��������</td>
            <td class="u2"><div class="ping1">
			        <input name="born_date" id="born_date" readonly type="text" value="<%=end_date%>" size=25  onfocus="setday(this);"  style="width:93px" ><font color="red">*</font>(��λ��-��λ��-��λ��)
			</div></td>
					<td class="u1">����</td>
            <td class="u2"><div class="ping1">
						<input name="born_site" type="text" size=25 maxlength=50><font color="red">*</font>
						</div>
            </td>
          </tr>
          <tr>
            <td class="u1">��ϵ�绰</td>
            <td class="u2"><div class="ping1">
			<input name="phone" type="text" size=15 maxlength=15><font color="red">*</font>
			</div>
            </td>
             <td class="u1">�����ʼ�</td>
            <td class="u2"><div class="ping1">
			<input name="email" type="text" size=25 maxlength=50><font color="red">*</font>
			</div>
            </td>
          </tr>

          <tr>
            <td class="u1">�̶��绰</td>
            <td class="u2">
			<div class="ping1">
			<input name="tel" type="text" size=25 maxlength=15 ><font color="red">*</font>
			</div>
            </td>
            <td class="u1">��ϵ��ַ</td>
            <td class="u2">
			<div class="ping1">
			<input name="addr" type="text" size=30 maxlength=50><font color="red">*</font>
			</div>
            </td>
          </tr>
          <tr>
            <td class="u1">��ְְλ</td>
            <td class="u2">
			<div class="ping1">
			<input name="position" type="text" size=20 maxlength=50><font color="red">*</font>
			</div>
            </td>
             <td class="u1">����</td>
            <td class="u2">
			<div class="ping1">
			<input name="age" type="text" size=2 maxlength=3 onkeyup="if(isNaN(value))execCommand('undo')">�� <font color="red">*</font> ���������֣�
			</div>
            </td>
          </tr>

          <tr>
            <td class="u1">�Ա�</td>
            <td class="u2">
			<div class="ping1">
			<select name=remark>
                <%
					if(sexList != null && sexList.size()>0)
					{
						for(int i=0;i<sexList.size();i++)
						{
							HashMap map=(HashMap)sexList.get(i);
							String value=map.get("para_code1").toString();
							String name=map.get("para_code2").toString();
							%>
                               <option value="<%= value %>"><%= name %></option>
                               <%
						}
					} %>
              </select>
			  </div>
            </td>
            <td class="u1">ѧ��</td>
            <td class="u2">
			<div class="ping1">
			<select name=degree>
                <%
					if(degreeList != null && degreeList.size()>0)
					{
						for(int i=0;i<degreeList.size();i++)
						{
							HashMap map=(HashMap)degreeList.get(i);
							String value=map.get("para_code1").toString();
							String name=map.get("para_code2").toString();
							%>
                               <option value="<%= value %>"><%= name %></option>
                               <%
						}
					} %>
              </select>
			  </div>
            </td>
          </tr>

          <tr>
            <td class="u1">��������</td>
            <td class="u2"><div class="ping1"><input name="job_age" type="text" size=1 maxlength=2 onkeyup="if(isNaN(value))execCommand('undo')">�� <font color="red">*</font>  ���������֣�</div>
            </td>
            <td class="u1">��ҵ���</td>
            <td class="u2"><div class="ping1"><input name="grad_date" id="grad_date" readonly type="text" size=10  onfocus="setday(this);"  style="width:93px"> <font color="red">*</font> (��λ��-��λ��-��λ��)</div></td>
          </tr>

					<tr>
            <td class="u1">����֤��</td>
            <td class="u2" colspan="3">
			<div class="ping1">
			<select name="cert" >
            	<%
					if(certList != null && certList.size()>0)
					{
						for(int i=0;i<certList.size();i++)
						{
							HashMap map=(HashMap)certList.get(i);
							String value=map.get("para_code1").toString();
							String name=map.get("para_code2").toString();
							%>
             <option value="<%= value %>"><%= name %></option>
             <%
						}
					}
					 %>
            </select>
			</div>
            </td>
          </tr>

          <tr>
            <td class="u1"  valign=top>��������</td>
            <td class="u2" colspan="3">
            	<div class="ping1"><textarea name="work_history" style=display:none></textarea>
              <iframe ID=work_history src=/www/ewebeditor/ewebeditor.htm?id=work_history&style=coolblue&root_id=<%=resume_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe> <font color="red">*</font> </div></td>
          </tr>
          <tr>
            <td class="u1"  valign=top>��ְ����</td>
            <td class="u2" colspan="3"><div class="ping1"><textarea name="spec" style=display:none></textarea>
              <iframe ID=spec src=/www/ewebeditor/ewebeditor.htm?id=spec&style=coolblue&root_id=<%=resume_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe> <font color="red">*</font> </div></td>
          </tr>
          <input name="trade_type_code" type="hidden" value="0260">
          

          <tr>
            <td class="u3" colspan=4 >	 
			         <input class ="tjan" name="submit1" type="submit" value="" onclick="return addResumeInfoCheck_Value()">
			     
			         <input type="hidden" name="info_id" id="info_id" value=<%=resume_id%>>
			         <input type="hidden" name="contents" id="contents" value="">
			         <input name="title" id="title" type="hidden" value="<%=userName%>">
			         <input type="hidden" name="tag" id="tag" value="">
			         <input type="hidden" name="src" id="src" value="">
			         <input type="hidden" name="author" id="author" value="">
			         <input type="hidden" name="mini_mg" id="mini_mg" value="">
			         <input type="hidden" name="ch_id" id="ch_id" value="2526202622">
			         <input type="hidden" name="cust_ch_id" id="cust_ch_id" value="4505407266">
			         <input type="hidden" name="mimi_title" id="mini_title" value="">
			         <input type="hidden" name="pub_date" id="pub_date" value="">
			         <input type="hidden" name="title_color" id="title_color" value="">
			         <input type="hidden" name="read_right" id="read_right" value="">
			         <input type="hidden" name="user_temp" id="user_temp" value="">
			         <input type="hidden" name="create_tag" id="create_tag" value="">
			         <input type="hidden" name="info_dsec" id="info_dsec" value="">
			         <input type="hidden" name="info_key" id="info_key" value="">
			         <input type="hidden" name="message_tag" id="message_tag" value="">
			         <input type="hidden" name="log_tag" id="log_tag" value="">
			         <input type="hidden" name="other_tag" id="other_tag" value="">
			         <input type="hidden" name="in_date" id="in_date" value="">
            </td>
          </tr>
     </table>
      </form>
</body>
</html>




