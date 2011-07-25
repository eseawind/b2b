<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<style type="text/css">
</style>
<link href="/style/b2b_css.css" rel="stylesheet" type="text/css" />
		<script language="javascript">
			function formSub()
			{
				if(document.getElementById('a_cust_class').value=='0000')
				{
						alert('请选择客户类型！');
						return false;
				}
				if(document.getElementById('a_cust_class').value!='0000')
				{
					var para_code1 = document.getElementById("a_cust_class").value;
		       		document.getElementById('para_code1').value=para_code1;
					var uid='';
		  			var obj=document.all.type0;	
		    		for( var i=0; i < obj.length; i++ )
					{
		        		if( obj[i].checked )
						{
		         	   		uid +=obj[i].value + '|';
		        		}
		   		 	}
		        	document.getElementById('para_code3').value = uid;
		        	document.Userform.submit();
		      	}
		  	}
		  	function change()
			{
		  		document.getElementById('ni').value=document.getElementById('a_cust_class').value;
		  		window.location.href='selectEnterprise.jsp?menu_id=c0gnBXRDj5I40K3&ni=' + document.getElementById('a_cust_class').value;
		  	}
	</script>
<title>企业站选择</title>
</head>
<body>
	<%
			String cust_id="",ni="0000";
			if (session.getAttribute("SESSION_CUST_ID") != null) 
			{
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
			}
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null)
			{
				top_menu_id = request.getParameter("menu_id");
			}
			if(request.getParameter("ni")!=null)
			{
				ni = request.getParameter("ni");
			}
			String class_code=bean.getSelectItems("14");
			//ArrayList  list = bean.getCompareInfoByAttr("14",ni);//取得客户级别
			String cust_level = bean.getItemsBySelected( "14",ni );
			
			String class_name = "";
			if(ni.equals("0000"))
			{
				class_name = "de";
			}
			else
			{
			 	class_name = bean.getParaCode3ByParaCode1("14",ni);
			}
			if( class_name == null || class_name.equals("") )
			{
			 	class_name="de";
			}	
			String []name = class_name.split( "\\|" );
			String style1="",style2="",style3="",style4="",style5="",style6="",style7="";
			for( int i = 0; i < name.length; i++ )
			{
				if( name[i].equals( "default" ) )
				{
					style1 = "checked";
				}
				if( name[i].equals( "style2" ) )
				{
					style2 = "checked";
				}
				if( name[i].equals( "style3" ) )
				{
					style3 = "checked";
				}
				if( name[i].equals( "style4" ) )
				{
					style4 = "checked";
				}
				if( name[i].equals( "style5" ) )
				{
					style5 = "checked";
				}
				if( name[i].equals( "style6" ) )
				{
					style6 = "checked";
				}
				if( name[i].equals( "style7" ) )
				{
					style7 = "checked";
				}
			}
			/* String name[] = new String[class_name.length()];
			for(int i=0;i<class_name.length();i++)
			{
				name[i]="";2009-7-10
			}
			int count = 0;
			for(int i=0;i<class_name.length()-1;i++)
			{
				if(class_name.charAt(i)=='|')
				{
					count++;
					continue;
				}
				name[count]=name[count]+class_name.charAt(i);
				out.print( "name["+count+"]=" + name[count] );
			} */
	%>
	<form name="Userform" action="/doTradeReg.do" method="post" target="_self">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" bgcolor="#FCB0B0">
		
			<tr height="30">
				<td>
						&nbsp;&nbsp;<font color="#000000" size="3"><b>客户类型：</b></font>
							<select id="a_cust_class" name="a_cust_class" onChange=" change()">
							 <option value="0000" selected>选择客户级别..</option>
								<%=cust_level%>
							</select>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:5px;">
		  <tr>
				<td width="25%" align="center"><img src="/images/entimage/default.jpg" width="166" height="166" /></td>
				<td width="25%" align="center"><img src="/images/entimage/style2.jpg" width="166" height="166" /></td>
				<td width="25%" align="center"><img src="/images/entimage/style3.jpg" width="166" height="166" /></td>
				<td width="25%" align="center"><img src="/images/entimage/style4.jpg" width="166" height="166" /></td>
		  </tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:5px;">
		  <tr>
				<td width="10%" align="right" valign="bottom">
					<input type="Checkbox" name="type0" id="type0" value="default" <%=style1%>/>
				</td>
				<td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 001</td>
				<td width="10%" align="right" valign="bottom">
					<input type="Checkbox" name="type0" id="type0" value="style2" <%=style2%>/>
				</td>
				<td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 002 </td>
				<td width="10%" align="right" valign="bottom">
					<input type="Checkbox" name="type0" id="type0" value="style3" <%=style3%>/>
				</td>
				<td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 003 </td>
				<td width="10%" align="right" valign="bottom">
					<input type="Checkbox" name="type0" id="type0" value="style4" <%=style4%>/>
				</td>
				<td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 004</td>
			  </tr>
			</table>
			
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:5px;">
			  <tr>
			    <td width="25%" align="center"><img src="/images/entimage/style5.jpg" width="166" height="166" /></td>
			    <td width="25%" align="center"><img src="/images/entimage/style6.jpg" width="166" height="166" /></td>
			    <td width="25%" align="center"><img src="/images/entimage/style7.jpg" width="166" height="166" /></td>
			    <td width="25%" align="center"></td>
			  </tr>
			</table>			
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
					<td width="10%" align="right" valign="bottom">
						<input type="Checkbox" name="type0" id="type0" value="style5" <%=style5%>/>
					</td>
			        <td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 005 </td>
					<td width="10%" align="right" valign="bottom">
						<input type="Checkbox" name="type0" id="type0" value="style6" <%=style6%>/>
					</td>
			        <td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 006 </td>
					<td width="10%" align="right" valign="bottom">
						<input type="Checkbox" name="type0" id="type0" value="style7" <%=style7%>/>
					</td>
			        <td width="15%" align="left" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;模板 007</td>
					<td width="10%" align="right" valign="bottom"></td>
			        <td width="15%" align="center" valign="bottom"></td>
			  </tr>
			</table> 
			<center>
				<input type="hidden" name="para_code3" id="para_code3" />
				<input type="hidden" name="subsys_code" id="subsys_code" value="CRM"/>
				<input type="hidden" name="param_code" id="param_code" value="cust_class"/>
				<input type="hidden" name="param_name" id="param_name" value="客户级别"/>
				<input type="hidden" name="param_attr" id="param_attr" value="14"/>
				<input type="hidden" name="para_code1" id="para_code1" />
				<input type="hidden" name="ni" id="ni" />
				<input type="hidden" name="trade_type_code" id="trade_type_code" value="8815"/><br><br>
				<input name="comit" type="submit" value="" onClick="return formSub()" style="background-image: url('/admin/images/tj.gif');width:78px;height:32px;border:0;cursor:hand;text-align:center;">
			</center>
		</form>
</body>
</html>





