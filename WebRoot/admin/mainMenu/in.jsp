<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<jsp:useBean id="classinfo" class="com.saas.biz.custMgr.CustClass" scope="page" />
<%@ page import="com.saas.biz.enquirytrackMgr.EnquirytrackInfo"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="property" class="com.saas.biz.propertyuMgr.PropertyuInfo" scope="page" />
<jsp:useBean id="vertif" class="com.saas.biz.verifyMgr.VerifyInfo" scope="page" />
<%
	String subsys_code = "CTR";
	if (request.getParameter("subsys_code") != null) {
		subsys_code = request.getParameter("subsys_code");
		if(subsys_code=="out" || subsys_code.equals("out")){
		 %>
    <jsp:forward page="/member/out.jsp"/><%
		 return;
		}
	}
%>
<% 
	HttpSession logsession = request.getSession();
	String user_id = "";
	String user_name="",cust_name="",cust_id="",cust_type="";
	boolean ifCertfied=false;
	if(logsession.getAttribute("SESSION_USER_ID")!=null){
			user_id = (String)logsession.getAttribute("SESSION_USER_ID");
			UserInfo user = new UserInfo();
			ArrayList lists = new ArrayList();
			lists = user.getForCustByID(user_id);
		  if(lists!=null && lists.size()>0){
	  			HashMap maps = (HashMap)lists.get(0);
	 		 	user_name = maps.get("user_name").toString();
	 		 	cust_name = maps.get("cust_name").toString();
	 		 	cust_id = maps.get("cust_id").toString();
		  	}
	  	}
	  	
	  	//ȡ��Ա����
	ifCertfied=vertif.ifCertifed(cust_id);
	String cust_class = classinfo.getCustClassById(cust_id);

	//ȡ�û�����
	OrganizeInfo organ = new OrganizeInfo();
	EnquirydInfo enquirydInfo = new EnquirydInfo();
	String cmpname = organ.getCustNameById(cust_id);

	//ȡ�û��Ƹ�
	String money = property.getUserPropertyValue(user_id, "0");

	//ȡ�û��Ƹ��ȼ�
	int moneys = Integer.parseInt(money);

	//ȡ����
	EnquirytrackInfo enquiryObj = new EnquirytrackInfo();
	int counter1 = enquiryObj.getStockNumberByUser(user_id);
	LeavewordsInfo enquiryObjs = new LeavewordsInfo();
	int counter2 = enquirydInfo.getEnquiryList(cust_id);
	int counter3 = enquiryObj.getSaleNumberByUser(user_id);

	//ȡ�����Ĺ�Ӧ��Ϣ
	SaleInfo processObj = new SaleInfo();
	int pro_counter1 = processObj.getSaleListNum(cust_id);
	int pro_counter2 = processObj.getOffSaleListNum(cust_id);

	//ȡ�����Ĳɹ���Ϣ
	Stockorderinfo stockObj = new Stockorderinfo();
	int st_counter1 = stockObj.getStockListNumber(cust_id);
	int st_counter2 = stockObj.getOffStockListNumber(cust_id);

	Custinfo cust = new Custinfo();
	ArrayList list22 = cust.getCustomerCustType(cust_id);
		if(list22!=null && list22.size()>0){
			HashMap map = (HashMap)list22.get(0);
			if( map.get("cust_type")!=null){
				cust_type = map.get("cust_type").toString();
			}
		}
	  	
	  	
	if(logsession.getAttribute("SESSION_USER_ID")==null){
%>
<script language="javascript">
        window.location.href("/member/index.jsp"); 
    </script>
<%		
		 
	}	
%>
<html>
<head>
<title>B2B���������̨����ϵͳ</title>
<link href="/style/kbuzi.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" align="absmiddle">
  <tr>
    <td><table width="703" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="703"><img src="/images/uu81_logon_03.gif" /></td>
        </tr>
        <tr>
          <td background="/images/uu81_logon_05.gif"><div class="welcome">
              <div class="welcome_01"> <span style="font-size:14px; line-height:26px;">��ӭ����&nbsp;<%=cust_name%> �� <%=user_name%> �û� <br/>
                ��ã� <span style="color:#FF6633;">���ѳɹ���½��վ!</span> </div>
                	  <div class="welcome_02">������ҳ�鿴��Ϣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://b2b.bizoss.com/">������ҳ</a></div>
						<%if(ifCertfied){%>
						<span style="color:#666; line-height:36px;">��ӭ�״ν����й������̵�������ƽ̨��Ϊȷ����Ϣ�������ԣ���������������д������</span><br>
						<%}
						if (cust_class.equals("1")) {
						%>
					<center><br><br><div class="welcome_02"><a href="http://b2b.bizoss.com/member/certificationMgr/verify.jsp?menu_id=4v2Kggfgfd66iYB2Y&info_type=0">���������֤!</a> 
				<span style="color:#666; line-height:36px;"><a href="http://b2b.bizoss.com/member/dataMgr/modfiyUser.jsp?menu_id=q4Ghj8d7hs8QB30&=&=&=">�����д����!</a></div></center>
						<%
						} else {
						%>
         	   <%if(cust_type.equals("1")){%>
         	     <div class="welcome_02">�����Ƿ�������๦�ܵĺ�̨���й��� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/admin/change/index.jsp">�����̨</a></div>
              <%}else{%>
              <div class="welcome_02">�����Ƿ�������๦�ܵĺ�̨���й��� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/admin/mainMenu/default.jsp">�����̨</a></div>
               <div class="welcome_02">ȥ�ҵ���ҵվ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=cust_id%>">�ҵ���ҵվ</a></div>
              <%}%> 
              <div style=" float:left;margin:20px; display:inline;"><img src="/images/uu81_logon_08.gif" /></div>
            </div></td>
            <%}%><div style=" float:left;margin:20px; display:inline;"><img src="/images/uu81_logon_08.gif" /></div>
        </tr>
        <tr>
          <td><img src="/images/uu81_logon_11.gif" /></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>




