<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<html>
	<head>
		<title>���Ͻɷ�</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.ping_1{
		color: #003399;
		}
		</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		
		<script type="text/javascript">
		  function check_Value(){
		    var cust_name=$F("cust_name");
		    if(cust_name =="" || cust_name==null){
		      alert("�������Ա���ƣ�");
		      $("cust_name").focus();
		      return false;
		    }
		    var id=$F("obj_cust_id");
		    if(id=="" || id==null){
		      alert("�������Ա�����ڻ���������\n������������ȷ�Ļ�Ա����");
		      $("cust_name").focus();
		       return false;
		    }
		     getCheckBox();
		    var value_num=$F("value_num");
		    if(value_num<1){
		      alert("����ѡ��Ҫ�����ķ������ƣ�");
		      return false;
		    }
		    if($("v_orderemail").value==""){
		      alert("�ʼ���ַ����Ϊ�գ�");
		      return false;
		    }else {
		      var regexp=/^[a-zA-Z0-9_]{2,25}[@][a-zA-z0-9-]{1,100}[.]([a-zA-Z]{2,4}|[a-zA-Z]{2,4}[.][a-zA-Z]{2})$/g;
		      if(!regexp.test($("v_orderemail").value)){
		         alert("������Ϸ����ʼ���ַ��");
		        return false;
		      }
		    }  
		    $("v_amount").value=$F("value_num");
		    return true;
		  }
		function setCustId(id){
		  $("obj_cust_id").value=id;
		}
		//�жϻ�Ա�����ķ�������
		function setServerInfo(s_name,s_value){
		 if($(s_name).checked){
		   $(s_value).focus();
		 }else{
		   var num=$F(s_value);
		   if(num!="" && num !=null){
		   var sum=parseFloat(parseFloat($F("value_num"))-parseFloat(num)*50);
		   $("value_num").value=sum;
		   }
		   $(s_value).value="";
		 }
		}
		function setSumServer(s_name,s_value){
		  if($(s_name).checked){
		   var num=$F(s_value);
		   if(num !="" && num!=null){
		    var sum=parseFloat(parseFloat($F("value_num"))+parseFloat(num)*50);
		    $("value_num").value=sum;
		   }else{
		     alert("������������ޣ�");
		     $(s_name).checked=false;
		   }
		 }else{
		  var val=$F(s_value);
		  if(val>0){
		    alert("�Ƿ�Ҫ�����������Ҫ������������ѡ��������ƣ�");
		  }else{
		   val=0;
		   var sum=parseFloat(parseFloat($F("value_num"))-parseFloat(val*50));
		   $("value_num").value=sum;
		  }
		 }
		}
		function getCheckBox(){
		  var value_id="";//��ŷ������ƺ����� oa&5#50|
		  var chkbox = document.getElementsByName('sev');    
	      var size=chkbox.length; 
	      for(var i=0;i<size;i++){
	        var obj=chkbox[i];
	        if(obj.checked){
	          var id=obj.id;
	          var val="f_"+id;
	          var month=parseFloat(parseFloat($F(val))*parseFloat(obj.value));
	          value_id=value_id+id+"&"+month+"|";
	        }
	      }
	      $("value_id").value=value_id;
	      return true;
         }
		</script>
	</head>
	<%
	HttpSession  logsession = request.getSession(); 
	String cust_id="",user_id="",cust_name="",phone="";
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
	if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }
    ArrayList list=bean.genSpecCustInfo(cust_id);
    if(list !=null && list.size()>0){
      HashMap map=(HashMap)list.get(0);
      if(map.get("cust_name")!=null){
        cust_name=map.get("cust_name").toString();
      }
      if(map.get("group_contact_phone")!=null){
        phone=map.get("group_contact_phone").toString();
      }
      
    }
    String account_id=comm.GenTradeId();
	%>
	<body>
		
	<form name=formbill action=/doTradeServe.do method="post"method=post target="_self">
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="f0c4n2mMM080X0G85Be2" />
		</jsp:include>
					<table width=800 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4">
							<td colspan="2" align=center width="100%" height="25">
									<input type="hidden" name="cust_name" id="cust_name" value="<%=cust_name%>">��ѡ�����·���!
								
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								�ʼ���ַ��
							</td>
							<td class="u2" width="85%">
								<div class="ping1">
									<input type="text" name="v_orderemail" id="v_orderemail" maxlength="100" title="��������Ч�ʼ���ַ��" style="height: 12px"><span style="margin-bottom:2px;color:red;">(��������Ч���ʼ���ַ)</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="u1" width="15%">
								�������ƣ�
							</td>
							<td class="u2" width="85%">
								<div class="ping1">
									<table width=100% border=0 cellpadding=2 cellspacing=1 align=center>
										<tr>
											<td class="u5">
												<div class="ping_1">
													����������<input type="checkbox" name="sev" id="b2b" value="1" onclick="setServerInfo('b2b','f_b2b')">����<input type="text" name="f_b2b" id="f_b2b" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('b2b','f_b2b')">��(50��/��)
												</div>
											</td>
											<td class="u5">
												<div class="ping_1">
												    ��������<input type="checkbox" name="sev" id="oa" value="3" onclick="setServerInfo('oa','f_oa')">����<input type="text" size="3" name="f_oa" id="f_oa" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('oa','f_oa')">����(50��/����)
												</div>
											</td>
										</tr>
										<tr>
										  <td class="u5"><div class="ping_1">
													���ͻ���<input type="checkbox" name="sev" id="crm" value="3" onclick="setServerInfo('crm','f_crm')">����<input type="text" name="f_crm" id="f_crm" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('crm','f_crm')">����(50��/����)
												</div>
											</td>
											<td class="u5"><div class="ping_1">
													����桽<input type="checkbox" name="sev" id="mrp" value="12" onclick="setServerInfo('mrp','f_mrp')">����<input type="text" name="f_mrp" id="f_mrp" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('mrp','f_mrp')">��(50��/��)
												</div>
											</td>
										</tr>
										<tr>
										  <td class="u5"><div class="ping_1">
													�����ۡ�<input type="checkbox" name="sev" id="sale" value="12" onclick="setServerInfo('sale','f_sale')">����<input type="text" name="f_sale" id="f_sale" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('sale','f_sale')">��(50��/��)
												</div>
											</td>
											<td class="u5"><div class="ping_1">
													���ɹ���<input type="checkbox" name="sev" id="buy" value="12" onclick="setServerInfo('buy','f_buy')">����<input type="text" name="f_buy" id="f_buy" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('buy','f_buy')">��(50��/��)
												</div>
											</td>
										</tr>
										<tr>
										  <td class="u5"><div class="ping_1">
													���ƻ���<input type="checkbox" name="sev" id="proj" value="12" onclick="setServerInfo('proj','f_proj')">����<input type="text" name="f_proj" id="f_proj" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('proj','f_proj')">��(50��/��)
												</div>
											</td>
											<td class="u5"><div class="ping_1">
													��������<input type="checkbox" name="sev" id="form" value="12" onclick="setServerInfo('form','f_form')">����<input type="text" name="f_form" id="f_form" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('form','f_form')">��(50��/��)
												</div>
											</td>
										</tr>
										<tr>
										  <td class="u5"><div class="ping_1">
													����Ʒ��<input type="checkbox" name="sev" id="prod" value="12" onclick="setServerInfo('prod','f_prod')">����<input type="text" name="f_prod" id="f_prod" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('prod','f_prod')">��(50��/��)
												</div>
											</td>
											<td class="u5"><div class="ping_1">
													�����䡽<input type="checkbox" name="sev" id="trans" value="12" onclick="setServerInfo('trans','f_trans')">����<input type="text" name="f_trans" id="f_trans" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('trans','f_trans')">��(50��/��)
												</div>
											</td>
										</tr>
										<tr>
										  <td class="u5"><div class="ping_1">
													����ͬ��<input type="checkbox" name="sev" id="cont"value="12" onclick="setServerInfo('cont','f_cont')">����<input type="text" name="f_cont" id="f_cont" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('cont','f_cont')">��(50��/��)
												</div>
											</td>
											<td class="u5"><div class="ping_1">������ã�<input type="text" name="value_num" id="value_num" size="15" maxlength="20" value="0" style="height: 12px" readonly></div>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td class="u3" colspan="2">
								<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
							</td>
						</tr>
						  <input type="hidden" id="obj_cust_id" name="obj_cust_id" value="<%=cust_id%>">
						  <input type="hidden" id="user_id" name="user_id" value="<%=user_id%>">
						  <input type="hidden" id="value_id" name="value_id">
						  <input type="hidden" id="account_id" name="account_id" value="<%=account_id%>">
						  <input name="v_oid" type="hidden" maxlength="64" value="<%=account_id%>"/>
	                      <input name="v_rcvemail" type="hidden" maxlength="64" value="sj@wanglong.cc"/>
	                      <input name="cust_id" id="cust_id" type="hidden" maxlength="64" value="<%=cust_id%>"/>
	                      
	                      <input name="v_rcvname" id="v_rcvname" type="hidden" value="<%=cust_name%>"/>
	                      <input name="v_rcvtel" id="v_rcvtel" type="hidden" value="<%=phone%>"/>
	                      <input name="v_amount" id="v_amount" type="hidden" value=""/>
	                      
	                      <input name="server_name" type="hidden" id="server_name" maxlength="64" value=""/>
	                      <input name="trade_type_code" type="hidden" id="trade_type_code" value="1186"/>
					</table>

	</form>
	</body>
</html>




