
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<%
	String trade_id="";
	if(request.getParameter("trade_id")!=null){
		trade_id = request.getParameter("trade_id");
	}
	EnquirydInfo enquiry = new EnquirydInfo();
	ArrayList anList = new ArrayList();
	anList = enquiry.getEnquiryById(trade_id);
	String title = "";
	if(anList!=null){
			HashMap anMap = (HashMap)anList.get(0);
			if(anMap.get("rsrv_str3")!=null){
				title = anMap.get("rsrv_str3").toString();
				if(title.length()>12){
					title = title.substring(0,12);
				}
			}
 %>
 		<div id='top'>
 			<div class='width'>
 					<div class='top_left'>
 						��ӭ���� �й�ľ���г���-��ľ����
 					</div>
 					<div class='top_right'>
 						<a href='#'>�߼���Ա����</a> | <a href='#'>��ϵ����</a> | <span class='lin2'><a href='#'>���ʰ�����</a></span>
 					</div>
 			</div>
 		</div>  
		<div id='head'>
			<div class='logo'>
				<a href='/'><img src='/templates/default/images/logo.gif'  border='0' /></a>
			</div>
		<div class='head_right'>
			<div class='head_right_button'>
				<div class='button lin1'>
					<span><a href='/member/index.html'>��ѷ�����Ϣ</a></span>
				</div> 
				<div class='button'>
					<span><a href='/default/product/'>��Ʒ����</a></span>
				</div>
				<div class='button'>
					<span><a href='/member/Newcregister.html'>���ע��</a></span>
				</div>
				<div class='button'>
					<span><a href='/member/index.html'>��¼</a></span>
				</div>
			</div>
			<div class='nav_link'>
				<ul>
					<li id='dis12'><a href='/default/supply/index.html'>��Ӧ��Ϣ</a></li>
					<li id='dis11'><a href='/default/stock/index.html'>����Ϣ</a></li>
					<li id='dis10'><a href='/default/product/index.html'>��Ʒ��</a></li>
					<li id='dis9'><a href='/default/enterprise/index.html'>��ҵ��</a></li>  
					<li id='dis8'><a href='/default/changyeJiaMeng/index.html'>��ҵ����</a></li>
					<li id='dis7'><a href='/default/pingCe/index.html'>����</a></li>
					<li id='dis6'><a href='/default/myzh/index.html'>�г�չ��</a></li>
					<li id='dis5'><a href='/default/news/index.html'>��Ѷ</a></li>
					<li id='dis4'><a href='/default/aiwen/index.html'>�ʴ�</a></li>
					<li id='dis3'><a href='/default/job/index.html'>�˲�</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id='nav'>
		<div class='nav_menu'>
			<ul>
				<li><a href='/default/aiwen/index.html'>������ҳ</a></li>
				<li><a href='/default/aiwen/request/index.html'>���������</a>&nbsp;&nbsp;|</li>
				<li><a href='/default/aiwen/resolveReq/index.html'>�ѽ������</a>&nbsp;&nbsp;|</li>
				<li><a href='/default/aiwen/woodKnowledge/index.html'>��ҵ֪ʶ</a>&nbsp;&nbsp;|</li>
				<li><a href='/default/aiwen/woodPicture/index.html'>��ҵͼ��</a>&nbsp;&nbsp;|</li>
				<li><a href='/default/aiwen/technology/index.html'>�����ɹ�</a>&nbsp;&nbsp;|</li>
			</ul>
			<div class='nav_menu_sws'>
				�ҵ�������
			</div>
		</div>
		<div class='nav_search_box'>
			<table width='100%' border='0' cellspacing='0' cellpadding='0' style='margin-top:12px;'>
				<tr>
					<td height='52' align='center'>
						<span style='font-size:14px;'>�������������⣺</span>
						<input name='textfield' id='textfield' type='text' style='font-size:14px; line-height:18px; height:20px; border:1px solid #7F9DB9' value='' size='42' />
					  <input type='button' name='Submit' value='������' class='school_button' onclick='return searchanser('searchTwo')'/>
					</td>
					<td align='right' valign='top'>
						<a href='javascript:openMore('answers');'><img src='/templates/default/images/aiwen_15.gif' border='0' /></a>
						<a href='javascript:openMore('question');'><img src='/templates/default/images/aiwen_16.gif' border='0' /></a>
					</td>
				</tr>
			</table>
		</div>
	</div>
 		
 	<div id="main">
	    <div class="path">�����ڵ�λ�� > <a href="/">��ҳ</a> >
				<span id="position">���������</span>			
			</div>
      <div id="view" style="height:400px"></div>      
   </div>		
 		
 
 <%
		}
	
 %>
	

 
 



