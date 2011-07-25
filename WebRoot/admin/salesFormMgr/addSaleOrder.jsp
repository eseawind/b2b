
<jsp:directive.page import="com.saas.biz.templateFormMgr.TemplateOject" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="formBean" class="com.saas.biz.templateFormMgr.TempFormInfo" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String quo_id = "", form_id = "", cust_id = "", form_name = "";
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("form_id") != null) {
		form_id = request.getParameter("form_id");
	}
	if (request.getParameter("quo_id") != null) {
		quo_id = request.getParameter("quo_id");
	}
	ArrayList list = formBean.getTemplateFormById(cust_id, form_id);
	if (list != null && list.size() > 0) {
		HashMap map = (HashMap) list.get(0);
		if (map.get("form_name") != null) {
			form_name = map.get("form_name").toString();
		}
	}
	//out.print("form_id=="+form_id+"<br>quo_id="+quo_id);
	String item_id=comm.GenTradeId();
	ArrayList formObject =formBean.getTemplateAreaField(cust_id, form_id);
	int index=0;
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/css.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
		form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		.bnt{background-image: url('/images/zjtm.gif');width:100px;height: 26px;border:0;cursor:hand;margin-left: 5px;display:none;}
		</style>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="JavaScript">
		function confirmsub(){
		
		  var index=document.getElementById("index").value;
		  var resultHtml="",ins_value="";
		  for(var i=0;i<index;i++){
		   var obj="id"+i;
		   var obj_value=document.getElementById(obj).value;
		   var obj_name=document.getElementById(obj).name;
		   var data=obj_name+"&"+obj_value;
		    resultHtml=resultHtml+data+"|";
		    ins_value=ins_value+obj_value;
		  }
		  document.getElementById("field_value").value=resultHtml;
		  var quo_name=document.getElementById("quo_name").value;
		  if(quo_name==null || quo_name==""){
		    Ext.MessageBox.alert("bizoss 提示","请认真填写订单名称！");
		    return false;
		  }
		  return true;
		}
		function addDetial(field_id,id){
		 if(document.getElementById(id).checked){
			 var form_id=document.getElementById("form_id").value;
			 window.open ("/saleOrder/addOrderItme.jsp?form_id="+form_id+"&field_id="+field_id+"&quo_id="+id);
		 }
		}
		function setHtmlCode(value,obj){
		  document.getElementById(obj).value=value
		}
        </script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="727" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px" bgcolor="#dddddd" align="center">
				<tr>
					<td height="2"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#FFFFFF">
							<tr height="25px">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:15px;text-align:center;" align="center" width=100%>
									<%=form_name%>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:15px;text-align:left;">
									订单名称：<input type="text" id="quo_name" name="quo_name" size="25" maxlength="100">
								</td>
							</tr>
							<tr>
								<td align=left bgcolor="#FFFFFF">
									<%
									if (formObject != null && formObject.size() > 0) {
									for (int i = 0; i < formObject.size(); i++) {
										TemplateOject obj = (TemplateOject) formObject.get(i);
										String area_name=obj.getArea_name();
										HashMap detailMap=obj.getMap();
									%>
									<table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#dddddd">
										<tr>
											<td bgcolor="#FFFFFF" style="margin-left:5px;font-weight:bold;" colspan="3">
												<div class="ping1">
													<%=area_name%>
												</div>
											</td>
										</tr>
										<%if(detailMap!=null && detailMap.size()>0){
										   Iterator it=detailMap.entrySet().iterator();
										   while(it.hasNext()){
										    Entry entObj=(Entry)it.next();
										    HashMap fieldMap=(HashMap)entObj.getKey();
										    ArrayList items=(ArrayList)entObj.getValue();
										    String field_name="",field_type="",value="",name="",select="",field_id="",
										    default_value="",html="";
										   if(fieldMap.get("field_name")!=null){
									           field_name=fieldMap.get("field_name").toString();
									        }
									        if(fieldMap.get("field_id")!=null){
									           field_id=fieldMap.get("field_id").toString();
									        }
									        if(fieldMap.get("default_value")!=null){
									           default_value=fieldMap.get("default_value").toString();
									        }
									        int idx=index++;
									        html="<input type=hidden name="+field_id+" id=id"+idx+">";
									       if(fieldMap.get("field_type")!=null){
									           field_type=fieldMap.get("field_type").toString();
									           if(field_type=="0" || field_type.equals("0")){
									            field_type="<select id=field_type name=field_type onclick=setHtmlCode(this.value,'id"+idx+"')>";
									            select=select+"<option value=0>请选择..</option>";
									            if(items !=null && items.size()>0){
									             for(int j=0;j<items.size();j++){
									                HashMap map=(HashMap)items.get(j);
									                 if(map.get("item_name")!=null){
												         name=map.get("item_name").toString();
												     }
												     if(map.get("item_id")!=null){
												         value=map.get("item_id").toString();
												     }
												     select=select+"<option value="+value+">"+name+"</option>";
									             }
									            }
									            field_type=field_type+select+"</select>";
									            html="<input type=hidden name="+field_id+" id=id"+idx+" value=0>";
									           }else  if(field_type=="1" || field_type.equals("1")){
									             field_type="<input type=text name=item_name size=30 maxlength=50 onblur=setHtmlCode(this.value,'id"+idx+"')>";
									           }else if(field_type=="2" || field_type.equals("2")){
									              String detail_id=comm.GenShortTradeId();
									              field_type="<input type=checkbox name=bnt id="+detail_id+" value=明细录入 onclick=addDetial('"+field_id+"','"+detail_id+"')>明细录入| <a href=/saleOrder/viewOrderItem.jsp?form_id="+form_id+"&quo_id="+detail_id+" target=_blank>查看明细</a>";
									              html="<input type=hidden name="+field_id+" id=id"+idx+" value="+detail_id+">";
									           }else if(field_type=="3" || field_type.equals("3")){
									              field_type=default_value;
									               html="<input type=hidden name="+field_id+" id=id"+idx+" value="+default_value+">";
									           }
									       }
										%>
											<tr>
												<td style="background-color:#f6f6f6; color:#000000; font-size:12px;margin-left: 15px;text-align: right" width="20%">
													<div style="text-align:right;margin-right:2px;">
														<%=field_name%>:
													</div>
												</td>
												<td style="background-color:#FFFFFF; color:#000000; font-size:12px;margin-left: 15px" colspan="2" width="80%">
													<div style="margin-left: 2px;">
														<%=field_type%><%=html%>
													</div>
												</td>
											</tr>
										<%
										}
										}%>
									</table>
									<%
										}
									}
									%>
								</td>
							</tr>
							<input type="hidden" name="quo_id" id="quo_id" value="<%=quo_id%>">
							<input type="hidden" name="form_name" id="form_name" value="<%=form_name%>">
							<input type="hidden" name="form_id" id="form_id" value="<%=form_id%>">
							<input type="hidden" name="index" id="index" value="<%=index++%>">
							<input type="hidden" name="field_value" id="field_value" value="">
							<input type="hidden" name="item_id" id="item_id" value="<%=item_id%>">
							<input type="hidden" name="trade_type_code" id="trade_type_code" value="1089">
							<tr height="25px">
								<td style="background-color:#f6f6f6; color:#000000;text-align:left;" width=100%>
									备注：<input name="remark2" id="remark2" size="52" maxlength="50" value="">
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;text-align:left;margin-left: 25px;text-align:center;" colspan="2">
									<input name="comit" type="submit" value="" onclick="return confirmsub()" style="background-image: url('/images/tj.gif');width:70px;height: 26px;border:0;cursor:hand;text-align:center;">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		</form>
	</body>
</html>





