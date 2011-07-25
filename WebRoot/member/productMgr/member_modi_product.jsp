<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.productMgr.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.newproductattrMgr.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String product_id = "", cust_id = "",cust_id1="";
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("product_id") != null) {
		product_id = request.getParameter("product_id");
	}
	 
	NewProductAttrInfo group = new NewProductAttrInfo();
	ArrayList tableList = group.getProductById(product_id);
	
  String product_name = "",product_type="", product_abstract = "", product_desc = "", product_site = "", product_unit = "", audit_date = "", remark = "";
  String product_unit_value="",validity="",product_class = "";
	ProductInfo groups = new ProductInfo();
	ArrayList list = groups.getProductInfo( product_id);
	 
	String productType = comm.getSelectItems("84");
	String class_id="",class_name = "",class_id_grp="";
	HashMap maps = new HashMap();
	if(list!=null && list.size()>0)
	{
		maps = (HashMap) list.get(0);
		if( maps.get( "product_name" ) != null )
		{
			product_name = maps.get( "product_name" ).toString();
		}
		if( maps.get( "product_type" ) != null )
		{
			product_type = maps.get( "product_type" ).toString();
			productType = comm.getItemsBySelected("84",product_type);
		}
		if (maps.get("class_id_grp") != null) {
			class_id_grp = maps.get("class_id_grp").toString();
		}
		if (maps.get("product_class") != null) {
			product_class = maps.get("product_class").toString();
		}
		if( maps.get( "class_id" ) != null )
		{
			class_id = maps.get( "class_id" ).toString();
		}
		if( maps.get( "class_name" ) != null )
		{
			class_name = maps.get( "class_name" ).toString();
		}
		if( maps.get( "product_abstract" ) != null )
		{
			product_abstract = maps.get( "product_abstract" ).toString();
		}
		if( maps.get( "validity" ) != null )
		{
			validity = maps.get( "validity" ).toString();
		}
		if( maps.get( "product_desc" ) != null )
		{
			product_desc = maps.get( "product_desc" ).toString();
		}
		if( maps.get( "product_site" ) != null )
		{
			product_site = maps.get( "product_site" ).toString();
		}
		if( maps.get( "product_unit" ) != null )
		{
			product_unit = maps.get( "product_unit" ).toString();
			product_unit_value = comm.getParaCode2ByParaCode1("91", product_unit);
		}
		if( maps.get( "audit_date" ) != null )
		{
			audit_date = maps.get( "audit_date" ).toString();
			if( audit_date.length() > 10 )
			{
				audit_date = audit_date.substring( 0,10 );
			}
		}
		if( maps.get( "remark" ) != null )
		{
			remark = maps.get( "remark" ).toString();
		}
		if( maps.get( "cust_id" ) != null )
		{
			cust_id1 = maps.get( "cust_id" ).toString();
		}
	}
	String unit = comm.getSelectItems("91");
	int size = 0;
	
	
	String select = classBean.getSelectedByComm("2", "1");
	
	String ch_id=new ChannelInfo().getChIdByContMod("3");
	
	
	String up_id="000000000000000";
	if(request.getParameter("up_class_id") != null){
		up_id=request.getParameter("up_class_id").toString();
	}
	
	ArrayList json = proInfo.getproductByUpId(cust_id, up_id);
	
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script type="text/javascript" src="modi_productInfo.js"></script>
		<script type="text/javascript" src="product.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductAttrInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script src="/js/productMgr.js" type="text/javascript"></script>
		<script language="javascript">
			
		function Check_Value_My(){
			if(document.getElementById('product_name').value==''){
				alert('请填写产品名称！');
				document.getElementById('product_name').focus();
				return false;
			}
			document.getElementById('title').value = document.getElementById('product_name').value;
		}
		function setProductDiv(class_id){
	   	document.getElementById('loading').style.display="block";
			var data=Math.round(Math.random()*10000);
			var myAjax = new Ajax.Updater('loading',
				'/member/addProductattrInfoMgr/modi_del_attr.jsp?class_id='+class_id+"&datas="+data, {
				method : 'post',
				evalScripts : true
			});
		}
		
	</script>
	</head>
	<body>
		<form name="newproductform" action="/doTradeReg.do" method="post" target="_self">
			<!--
	    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(0)">
									常规参数
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(1)">
									产品说明
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
	    </table>
		 <!--01-->
						<jsp:include  flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="3"/>
							<jsp:param name="news_id" value="<%=product_id%>"/>
							<jsp:param name="ch_id" value="<%=ch_id%>"/>
							<jsp:param name="class_id" value="<%=class_id%>"/>
						</jsp:include>
		<!--02-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="/admin/productMgr/index.jsp">管理产品信息</a>
				</td>
			</tr>
		</table>
		
	  <table width=100% border="0" cellpadding="0" cellspacing="1" align="center" bgcolor="#dddddd" id="bo0"  >
							<tr>
								<td  class="u1">
									产品标题：								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan="3">
								<div class="ping1">
									<input type=text name="product_name" id="product_name" value="<%=product_name%>">
									<input type=hidden name="title" id="title" value="<%=product_name%>">
								</div>
								</td>
								<input type="hidden" name="product_type" value="1">
							</tr>
							<tr>
								<td class="u1" >
									产品型号：
								</td>
						<td class="u2"  colspan="3"> 									
						<table width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;" bgcolor="#DEEDFD">
							<tr class="u4" height="25">
								<td width="20%" align="center" >选择型号</td>
								<td width="20%" align="center" >型号名称</td>
								<td width="40%" align="center" >型号描述</td>
							</tr>
							<%
							
								if(json!=null && json.size()>0){
								HashMap map=null;
									for(int i=0;i<json.size();i++){
									String class_name_xing="";
									String class_id_up="";
									String class_desc="";
									String enable_tag="";
									ArrayList downlist=null;
					           map=(HashMap)json.get(i);
					           if(map.get("class_name")!=null){
					          	 class_name_xing=map.get("class_name").toString();
					           }
					           if(map.get("class_id")!=null){
					          	 class_id_up=map.get("class_id").toString();
					          	 downlist = proInfo.getproductByUpId(cust_id, class_id_up);
					           }
					           if(map.get("class_desc")!=null){
					          	 class_desc=map.get("class_desc").toString();
					          	 if(class_desc.equals("")){
					          	 		class_desc="无";
					          	 }
					           }
					          
					           
					           if(map.get("enable_tag")!=null){
					          	 enable_tag=map.get("enable_tag").toString();
					          	 if(enable_tag.equals("0")){
					          	 		enable_tag="有效";
					          	 }else{
					          	 		enable_tag="无效";
					          	 	}
					           }
					           %>
					           <tr>
					      <td width="20%" align="center"  style="background-color: #ffffff; color: #000000;  font-size: 12px;">
			         <input type="radio" name="up_class_id" <%if(class_id_up.equals(product_class)) out.println("checked");%>  value="<%=class_id_up%>" title="<%=class_name%>" onclick="document.getElementById('product_class').value='<%=class_id_up%>';setProductDiv('<%=class_id_up%>');"/>
								</td>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%if(downlist!=null){%>
									<a href="/member/productMgr/member_modi_product.jsp?up_class_id=<%=class_id_up%>&product_id=<%=product_id%>" title="查看下级型号"><%=class_name%></a>
									<%}else{%>
									<%=class_name_xing%>
									<%}%>
									
								</td>
								<td width="40%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;">
									<%=class_desc%>
								</td>
								
							</tr>
								<%}
							}else{%>
								<tr>
								<td width="20%" align="center" style="background-color: #ffffff; color: #000000;  font-size: 12px;" colspan="4">暂无型号！</td>
							</tr>
							<%	}
							%>
							<tr>
								<td width="20%" align="center" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;" colspan="4"></td>
							</tr>
			            </table>
						</td>
							</tr>
							<tr>
								<td class="u1" >
								</td>
								<td colspan="3" align="left" bgcolor="white">
									<div class="ping1">
										<div id="loading" style="display: none">
											<img src="/images/wait.gif" border="0">
											正在获取数据，请稍等...
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
								选择分类<span style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">：</span>								</td>
								<td  align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;"colspan="3">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
												<input type="text" name="class_name" id="class_name" value="<%=class_name%>">
												<input type="hidden"  name="class_id" id="class_id" value="<%=class_id%>">
											</td>
										</tr>
										<tr>
											<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
												<select name="sort1" id="sort1" size="10" style="width: 130px" onChange="setSecondClass(this.value);" onclick="setTypeName(this)">
													<%=select%>
												</select>
											</td>
											<td style="background-color:#ffffff; color:#000000; font-size:12px;">
												<select name="sort2" id="sort2" size="10" style="width: 130px; display: none" onChange="setTherdClass(this.value);" onclick="setTypeName(this)">
													<option value="0">
														请选择...
													</option>
												</select>
											</td>
											<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
												<select name="sort3" id="sort3" size="10" style="width: 130px; display: none" onclick="setTypeName(this)" onchange="cretateSelect('4',this.value)">
													<option value="0">
														请选择...
													</option>
												</select>
											</td>
											<td>
												<div id="nextElement" style="display: none">
													<div id="4" style="width;100px; float:left;display:inline;white-space:nowrap"></div>
													<input type="hidden" name="index_s" id="index_s" value="4">
												</div>
											</td>
										</tr>
									</table>

								</td>
							</tr>
							<tr>
								<td class="u1">
									产品生产地：								
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div class="ping1"><input type=text name="product_site" id="product_site" value="<%=product_site%>"></div>
								</td>
								<td class="u1" >
									产品有效期：
								</td>
								<td class="u2" >
									<div class="ping1">
										<input type=text name="validity" id="validity" onfocus="setday(this);" value="<%=validity%>">
										(四位年-二位月-二位日)
									</div>
								</td>
								<input type="hidden" name="product_unit" value="1">
								
							</tr>
							<tr>
								<td class="u1">
									缩略图：
								</td>
								<td class="u2" colspan="3">
									<input name="mini_img" id="mini_img" type="hidden">
									<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
										<iframe src="/inc/uploadImg.jsp?root_id=<%=product_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
									</div>
								</td>
								
							</tr>
							<tr style="display:none">
								<td class="u1">
									产品简介：								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan="3">
									<div class="ping1"><textarea name="product_abstract" id="product_abstract" cols="50" rows="6"><%=product_abstract%></textarea></div>
								</td>
							</tr>
							
							<tr>
								<td class="u1">
									产品描述：
								</td>
								<td  style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left colspan="3">
									<textarea name=product_desc style="display:none">
										<%=product_desc%>
									</textarea>
									<iframe id="product_desc" src="/www/ewebeditor/ewebeditor.htm?id=product_desc&style=coolblue&root_id=<%=product_id%>" frameborder="0" scrolling="no" width="700" height="350"></iframe>
								</td>
							</tr>
								<input type="hidden" name="remark" id="remark" value="<%=remark%>" size="50">
						</table>
	  					<table width=100% border="0" cellpadding="5" cellspacing="1" align="center" bgcolor="#dddddd">
							<tr>
								<td height="36" colspan=4 align=center style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									<input class="tjan" name=submit1 type=submit value="" onclick="return Check_Value_My()">		
									&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG" onClick="location.href='/admin/productMgr/index.jsp'" style="cursor:hand;" align="absmiddle">
								 </td>
							</tr>
							<input type="hidden" name="trade_type_code" id="trade_type_code" value="1228" />
							<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id1%>">
							<input type=hidden name="product_class" id="product_class" value="<%=product_class%>"/>
							<input type="hidden" name="root_id" id="root_id" value="<%=product_id%>">
							<input name="class_id_grp" id="class_id_grp" type="hidden" value="<%=class_id_grp%>">
							<input type="hidden" name="product_id" id="product_id" value="<%=product_id%>" />
							<input type="hidden" name="info_id" id="info_id" value="<%=product_id%>" />
							<input type="hidden" name="rsrv_str1" id="rsrv_str1" value="" />
							<input type="hidden" id="size" name="size" value="<%=size%>">
							 
				  </table>
					
			 </form>
	</body>
</html>



