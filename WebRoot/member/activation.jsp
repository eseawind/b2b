<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*"%>
<jsp:useBean id="userObj" scope="page" class="com.saas.biz.userMgr.UserInfo"></jsp:useBean>
<%
  String user_id=request.getParameter("u");
  String check_code=request.getParameter("k");
  String trade="";
  ArrayList list=userObj.genOneUserInfo(user_id);
  if(list!=null && list.size()>0){
    HashMap map=(HashMap)list.get(0);
    if(map.get("rsrv_str2")!=null){
       String code=map.get("rsrv_str2").toString();
       if(check_code==code || check_code.equals(code)){
         trade="0";
       }else{
         trade="1";
       }
    }
  }
%>
<html>
    <head>
 <title>B2B电子商务后台管理系统会员帐号激活</title>
	<script language="javascript" src="/js/member.js"></script>
</head>
<body onload="activationautoSubmit()">
<FORM name="formbill" action="/doTradeActive.do" method=post>
	<input name ="user_id" type="hidden" value="<%=user_id%>"/>
	<input name ="trade" id="trade" type="hidden" value="<%=trade%>"/>
	<input name="trade_type_code" type="hidden" value="4647">
 </form>
<div id="isShow" style="display: none;text-align: center;font-size: 15px;margin-top: 15px;color: blue;">对不起，您的激活码已经失效或已经使用过，如果你的帐号还没有激活请与管理员联系！</div>
</body>
</html>


