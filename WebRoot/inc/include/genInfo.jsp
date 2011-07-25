<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.enquirydealMgr.*"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%@ page import="com.saas.biz.enquirydealMgr.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.intf.InfoIntf"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />


<%
  String div_id="";
  String info_id="";
  String cust_id ="";
  String user_id="";
  String iStart="1";
  int counter=0;
  String area_id="";
  HttpSession logsession = request.getSession();
  if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	 if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
  
  if(request.getParameter("info_id")!=null)
   {
     info_id=request.getParameter("info_id");
   }
  if(request.getParameter("div")!=null)
   {
     div_id=request.getParameter("div");
   }
   if(request.getParameter("iStart")!=null)
   {
     iStart=request.getParameter("iStart");
   }
   //������������
   if("question".equals(div_id))
  {
   EnquirydInfo infoBean=new EnquirydInfo();
   ArrayList infoList = infoBean.getEnquriyInfoByChid(info_id,0,10);
   if(infoList!=null)
   {
    for(int i=0;i<infoList.size();i++)
    {
	    HashMap map=(HashMap) infoList.get(i);
	    String title="",enquiry_date="",sale_id="";
	   if(map.get("title")!=null)
	    {
				title = map.get("title").toString();
				if (title.length() > 10) {title = title.substring(0, 10) + "...";}						
	    }
	   if (map.get("sale_id") != null)
	    {
				sale_id = map.get("sale_id").toString();				
	    }
	   if (map.get("enquiry_date") != null)
	    {
			 enquiry_date = map.get("enquiry_date").toString();
			 if (enquiry_date.length() > 10) {enquiry_date = enquiry_date.substring(0, 10);}							
			}
			%>
			<li><a href="javascript:openNew('<%=sale_id%>');"><%=title%></a>&nbsp;<span><%=enquiry_date%></span></li>
			<%
   }
  }
}
   //�ش�ҳ��
  if("critique".equals(div_id))
  {
   	EnquirydInfo ei = new EnquirydInfo();
	  ArrayList List3 = ei.getEnquiryNewByList(0,100, info_id);
	  if(List3 !=null)
	  {
		  for (int i = 0; i < List3.size(); i++)
		  {
			  HashMap map = (HashMap) List3.get(i);
				String rsrv_str5 = "", enquiry_date = "", enquiry_content = "";
				if (map.get("rsrv_str5") != null) {
					rsrv_str5 = map.get("rsrv_str5").toString();
					if(rsrv_str5.equals("")){
						rsrv_str5 = "�ο�";
					}
				}else{
					rsrv_str5 = "�ο�";
				}
				if (map.get("enquiry_content") != null) {enquiry_content = map.get("enquiry_content").toString();}
				if (map.get("enquiry_date") != null) 
				{
				 enquiry_date = map.get("enquiry_date").toString();
				 if (enquiry_date.length() > 10){enquiry_date = enquiry_date.substring(0, 10);}			 
			  }
	     out.print("�����ˣ�"+rsrv_str5+"&nbsp;"+enquiry_date);
	     out.print("</br>��&nbsp;&nbsp;�ݣ�"+enquiry_content+"</br>");
	     out.print("-----------------------------------------------------------------------------------------------------</br>");
		  }
	  }
   if(List3 ==null)
   {
    out.print("��ʱû���˷�������");
   }  
  }
 //�����������
  if("noSolve".equals(div_id))
  {
   EnquirydInfo infoBean=new EnquirydInfo();
   ArrayList infoList = infoBean.getEnquriyInfoByChid(info_id,0,10);
   if(infoList!=null)
   {
    for(int i=0;i<infoList.size();i++)
    {
     if(i==6) break;
	    HashMap map=(HashMap) infoList.get(i);
	    String title="",enquiry_date="",sale_id="";
	   if(map.get("title")!=null)
	    {
				title = map.get("title").toString();
				if (title.length() > 10) {title = title.substring(0, 10) + "...";}						
	    }
	   if (map.get("sale_id") != null)
	    {
				sale_id = map.get("sale_id").toString();				
	    }
	   if (map.get("enquiry_date") != null)
	    {
			 enquiry_date = map.get("enquiry_date").toString();
			 if (enquiry_date.length() > 10) {enquiry_date = enquiry_date.substring(0, 10);}							
			}
			%>
			<li><a href="javascript:openNew('<%=sale_id%>');"><%=title%></a>&nbsp;<span><%=enquiry_date%></span></li>
			<%
   }
  }
  }
 
  //�ѽ��������
 if("solve".equals(div_id))
  {
   EnquirydInfo infoBean=new EnquirydInfo();
   ArrayList infoList = infoBean.getOffEnquriyInfoByChid(info_id);
   if(infoList!=null)
   {
    for(int i=0;i<infoList.size();i++)
    {
     if(i==6) break;
	    HashMap map=(HashMap) infoList.get(i);
	     String title="",enquiry_date="",sale_id="";
	   if (map.get("title") != null)
	    {
				title = map.get("title").toString();
				if (title.length() > 10) {title = title.substring(0, 10) + "...";}						
	    }
	     if (map.get("sale_id") != null)
	    {
				sale_id = map.get("sale_id").toString();				
	    }
	    if (map.get("enquiry_date") != null)
	    {
			 enquiry_date = map.get("enquiry_date").toString();
			 if (enquiry_date.length() > 10) {enquiry_date = enquiry_date.substring(0, 10);}							
			}
			%>
			<li><a href="javascript:openAnswer('<%=sale_id%>');"><%=title%></a>&nbsp;<span><%=enquiry_date%></span></li>
			<%
   }
  }
  }
//////////////////////�鿴session
if("session_cust".equals(div_id))
  {
    if(!"".equals(cust_id) && cust_id!="")
    {
    %>
    <input type="hidden" id="session_cust_id" name="session_cust_id" value="<%=cust_id%>">
    <input type="hidden" id="_user_id" name="_user_id" value="<%=user_id%>">
    <%
    }
  	}  
 //�鿴����
  if("view".equals(div_id))
  { 
  EnquirydInfo infoBean=new EnquirydInfo();
  Enquirydealinfo dealInfo = new Enquirydealinfo();
  
  ArrayList infoList = infoBean.genSign(info_id);
  if(infoList!=null)
  {
   HashMap map=(HashMap) infoList.get(0);
	 String title="",enquiry_date="",sale_id="";
	  if(map.get("title")!=null)
	    {
				title = map.get("title").toString();
								
	    }
	   if (map.get("sale_id") != null)
	    {
				sale_id = map.get("sale_id").toString();				
	    }
	    
	   ArrayList dealList = dealInfo.getEnquriyInfoById(sale_id);
	   
	   if (map.get("enquiry_date") != null)
	    {
			 enquiry_date = map.get("enquiry_date").toString();
			 if (enquiry_date.length() > 10) {enquiry_date = enquiry_date.substring(0, 10);}							
			}
			
			String deal_user_again="",deal_content_again="",deal_date_again="";
			if(dealList!=null){
				for(int u = 0;u<dealList.size();u++){
					HashMap dealMap = (HashMap)dealList.get(u);
					if(dealMap.get("deal_user")!=null){
						deal_user_again = dealMap.get("deal_user").toString();
					}
					if(dealMap.get("deal_content")!=null){
						deal_content_again = dealMap.get("deal_content").toString();
					}
					if(dealMap.get("deal_date")!=null){
						deal_date_again = dealMap.get("deal_date").toString();
					}
	%>
			 <b><%=title%></b></br>
			
			�ش����ݣ�<%=deal_content_again%></br>
			�ش��ˣ�<%=deal_user_again%> &nbsp;&nbsp;&nbsp;&nbsp;<%=deal_date_again%> &nbsp;<b>��<%=u+1%>¥</b></br></br>
			------------------------------------------------------------------------------------------------------------------</br>
	<%
				}
			}else{
	%>
			Ŀǰ��û���˻ش�������⣡
	<%		
			}
 %>
	 		<form name=answerForm action=/doTradeReg.do method=post target="_self">
			<div class="left_list_box">
			<div class="left_list_lmt"><span><%=title%></span></div>
			<div class="content_xx">
				<ul>
					<li>��������Ĵ�</li>
					<li style="text-align:top;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td valign="top" align="right">���Ļش�</td>
						<td><textarea  name="deal_content" id="deal_content" cols="50" rows="8" class="input_box"></textarea></td>
					  </tr>
					  <tr>
						<td valign="top" align="right">�ش��ˣ�</td>
						<td><input name="deal_user" id="deal_user" type="text" class="input_box" /><span style="color:#999;">������������˾����</span></td>
					  </tr>
					  <input type="hidden" name="trade_type_code" id="trade_type_code" value="3424">
					<input type="hidden" name="deal_tag" id="deal_tag" value="3">
					<input type="hidden" name="enquiry_id" id="enquiry_id" value="<%=sale_id%>">
					<input type="hidden" name="trade_id" id="trade_id" value="<%=sale_id%>">
					<input type="hidden" name="rsrv_str1" id="rsrv_str1" value="1">
					<input type="hidden" id="session_cust_id" name="session_cust_id" value="<%=cust_id%>">
					<input type="hidden" name="session_user_id" value="55555"  /> 
					  <tr>
						<td></td>
						<td>
							<input name="submit" type="submit" value="���ύ" onclick="return CheckAsk();"/>
						</td>
							
					  </tr>
					</table>
					</li>
				</ul> 
			</div>
		</div>
		</form>
		
 <%
  	}
  }
//��������
if("serch".equals(div_id))
{
  EnquirydInfo infoBean=new EnquirydInfo();
  try{
  		info_id = new String(info_id.getBytes("ISO-8859-1"),"gbk");
  }catch(Exception e){
  }
  ArrayList infoList = infoBean.genSearch(info_id);
  if(infoList !=null)
  {
  %>
  
  	<div class="content_xx">
		<ul>
  
  <%
    for(int i=0;i<infoList.size();i++)
    {
       HashMap map=(HashMap) infoList.get(i);
	   String title="",enquiry_date="",sale_id="";
	   if(map.get("title")!=null)
	   {
			title = map.get("title").toString();
			if (title.length() > 10) 
			{
				title = title.substring(0, 10) + "...";
			}						
	   }
	   if (map.get("sale_id") != null)
	   {
			sale_id = map.get("sale_id").toString();				
	   }
	   if (map.get("enquiry_date") != null)
	   {
		   enquiry_date = map.get("enquiry_date").toString();
		   if (enquiry_date.length() > 10) 
		   {
		   		enquiry_date = enquiry_date.substring(0, 10);
			}							
		}
	   out.print("<li><a href=\'javascript:openWin(\""+sale_id+"\");\'>"+title+"</a>&nbsp;<span>"+enquiry_date+"</span></li>");
    }
  %>
  </ul>
</div>
  <%
  }
  else
  {
   		out.print("û���ҵ������Ϣ��");
   } 
}
//�鿴����Ĵ��б�
if("answer".equals(div_id))
{
Enquirydealinfo infoBean = new Enquirydealinfo();
ArrayList infoList = infoBean.SchrepoitoryById(info_id);
if(infoList!=null)
{
for(int i=0;i<infoList.size();i++)
{
 String deal_content="",deal_date="",deal_user="";
 HashMap map=(HashMap) infoList.get(i);
  if (map.get("deal_date") != null)
	{
	 deal_date = map.get("deal_date").toString();
	 if (deal_date.length() > 10) {deal_date = deal_date.substring(0, 10);}					
	}
	if (map.get("deal_user") != null)
  {
		deal_user = map.get("deal_user").toString();				
  }
 if (map.get("deal_content") != null)
  {
		deal_content = map.get("deal_content").toString();				
  }	

 out.print("<li>����:&nbsp;"+deal_content+"&nbsp;�ش���:&nbsp;"+deal_user+"&nbsp;"+deal_date+"</li>");
// out.print("<li>����:&nbsp;");
}

}else{
 out.print("��ʱ��û���˶Դ����������ش�~~");
 }
 
}

if("answers".equals(div_id))
{
   EnquirydInfo infoBean=new EnquirydInfo();
   ArrayList infoList = infoBean.getOffEnquriyInfoByChid(info_id);
   if(infoList!=null)
   {
    for(int i=0;i<infoList.size();i++)
    {
	    HashMap map=(HashMap) infoList.get(i);
	     String title="",enquiry_date="",sale_id="";
	   if (map.get("title") != null)
	    {
				title = map.get("title").toString();
				if (title.length() > 10) {title = title.substring(0, 10) + "...";}						
	    }
	     if (map.get("sale_id") != null)
	    {
				sale_id = map.get("sale_id").toString();				
	    }
	    if (map.get("enquiry_date") != null)
	    {
			 enquiry_date = map.get("enquiry_date").toString();
			 if (enquiry_date.length() > 10) {enquiry_date = enquiry_date.substring(0, 10);}							
			}
			%>
			<li><a href="javascript:openAnswer('<%=sale_id%>');"><%=title%></a>&nbsp;<span><%=enquiry_date%></span></li>
			<%
   }
  } 
}

//����ʡȡ���¼�����
if("area".equals(div_id))
{
 AreaInfo infoBean=new AreaInfo();
  ArrayList infoList = infoBean.getAreaByParentByCMS(info_id);
  if(infoList!=null)
  {
   out.print("<ul>");
   for(int i=0;i<infoList.size();i++)
   {
    HashMap map=(HashMap) infoList.get(i);
    String area_code="",area_name="";
    if (map.get("area_code") != null)
    {
			area_code = map.get("area_code").toString();				
    }
     if (map.get("area_name") != null)
    {
			area_name = map.get("area_name").toString();				
    }
    
    out.print("	<li><a href=/inc/areaLink.jsp?area="+area_code+">"+area_name+"</a>|</li>");
   }
  out.print("</ul>");
  }
}

//ȡ����ҵ֪ʶ
if("custKnowledge".equals(div_id)){
	String title = "",info_ids="",sava_addr="";
  InfoList info = new InfoList();
  
  ArrayList arrayList = info.getCustInfoLists();
  if(arrayList!=null && arrayList.size()>0){  
	   for(int i=0; i<arrayList.size(); i++){
		    HashMap map=(HashMap)arrayList.get(i);
		    if (map.get("title") != null){
					title = map.get("title").toString();
					if(title.length() > 14) {
						title = title.substring(0,14);
					}					
		    }
		    if (map.get("info_id") != null){
					info_ids = map.get("info_id").toString();
					sava_addr = info.getChannelSaveDirByInfoId(info_ids);				
		    }
	    out.print("<li><a href=/"+sava_addr+"/d/content-"+info_ids+".html>"+title+"</a></li>");
	    if(i==6) {
	    	break;
	    }
	   }  
  }
}
//ȡ�����۾���
if("selKnowledge".equals(div_id)){
	String title = "",info_ids="",sava_addr="";
  InfoList info = new InfoList();
  
  ArrayList arrayList = info.getSelInfoLists();
  if(arrayList!=null && arrayList.size()>0){  
	   for(int i=0; i<arrayList.size(); i++){
		    HashMap map=(HashMap)arrayList.get(i);
		    if (map.get("title") != null){
					title = map.get("title").toString();
					if(title.length() > 14) {
						title = title.substring(0,14);
					}					
		    }
		    if (map.get("info_id") != null){
					info_ids = map.get("info_id").toString();
					sava_addr = info.getChannelSaveDirByInfoId(info_ids);				
		    }
	    out.print("<li><a href=/"+sava_addr+"/d/content-"+info_ids+".html>"+title+"</a></li>");
	    if(i==6) {
	    	break;
	    }
	   }  
  }
}
%>


		



