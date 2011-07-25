<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custMgr.CustClass" %>
<%@ page import="java.util.*,tools.util.FileIO,com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.FileOperate"%>

<%
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("ecms_path");
	
	 
	Custinfo custInfo = new Custinfo();
	String cust_id="",modename="",srcpath="",flag="0";
	if (session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	if( request.getParameter( "modename" ) != null )
	{
		modename = request.getParameter( "modename" ); 
	}
	if( request.getParameter( "srcpath" ) != null )
	{
		srcpath = request.getParameter( "srcpath" ); 
	}
	if( request.getParameter( "flag" ) != null )
	{
		flag = request.getParameter( "flag" ); 
	}
	//out.print( cust_id );
	FileOperate copyfold = new FileOperate();
	
	String display="",display2="";
	String filepath = "company/enterprise/customer/" + cust_id;
	String oldmodepath = "company/enterprise/public/" + modename;
	
	String dirpath = rootpath + filepath; 
	String newmodepath = rootpath + oldmodepath; 
	 if( FileIO.ExistFloder( dirpath ) )
	 {  
	 	if( flag.equals( "1") )
		{	
			copyfold.delFolder( dirpath );
			 %>
				<script language="javascript">
					window.location.reload();
				</script>
			<%	
		}
	 	display2="display:block";
		display="display:none";
	
	 }
	 else if( !FileIO.ExistFloder(dirpath) )
	 {
	 	if( !modename.equals("") )
	 	{
			copyfold.newFolder( dirpath );
	 		copyfold.copyFolder( newmodepath, dirpath+"/"+ modename   );
			%>
				<script language="javascript">
					window.location.reload();
				</script>
			<%	
	 	}
		display2="display:none";
		display="display:block";
	
		
	  }
	ArrayList comList = custInfo.getCustInfo(cust_id);
	String company = "";
	if(comList!=null && comList.size()>0)
	{
		HashMap comMap = (HashMap)comList.get(0);
		if(comMap.get("juristic_type_code")!=null)
		{
			company = comMap.get("juristic_type_code").toString();
		}
	}
	if(company.equals(""))
	{
		company = "请输入企业站名称...";
	}
	String class_name = new CustClass().cust_Class_Value(cust_id);
	String name[] = new String[ class_name.length() ];
	for( int i = 0; i < 7; i++ )
		name[i]="";
	int count = 0;
	for( int i = 0; i < class_name.length()-1; i++ )
	{
		if( class_name.charAt(i) == '|')
		{
			count++;
			continue;
		}
		name[count] = name[count] + class_name.charAt(i);
	}
	
	 
%>
<html>
	<head>
		<title>企业站模板管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			#load{width:500px;height:25px;border:1px #000 solid;}
			#loading{position:absolute;z-index:2;height:23;filter:progid:DXImageTransform.microsoft.gradient( gradienttype=1,startColorStr=white,endColorStr=#39867b );}
			#loadtext{position:absolute;z-index:3;width:100%;height:100%;line-height:23px;text-align:center;}
		</style>
		<script type="text/javascript" src="build.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		 
	</head>
	<body>
			
		<table align="center" style="display:none">
			<tr id="process">
				<td class="u2" width="100%" colspan="2">
					<div id="load" style="display: block">
						<div id="loading"></div>
						<div id="loadtext">
							0%
						</div>
					</div>
					<div id="closeWin" style="display:none;">正在生成网站，请不要关闭此窗口！</div>
				</td>
			</tr>
			<tr>
				<td class="u1" width="100%" colspan="2">
				<span style="text-align: left;display: none;padding-top:5px" id="finsh">企业站已生成完毕 &nbsp;<a href="/admin/enterpriseMgr/InterimPages.jsp?cust_id=<%=cust_id%>" target="_blank">预览</a></span>
				</td>
			</tr>
		</table>
		<table width="50%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
		 <tr>
			<td>
			<table width="600"  height="280" border="0" align="center" cellpadding="0" cellspacing="0"  style="<%=display2%>">
			  <tr>
			    <td  align="left"><font size="4"><b>企业站设置：</b></font></td>
			  </tr>
			  <tr height="20">
			  	<td width="150" align="left">&nbsp;&nbsp;&nbsp;<font color="#3300FF" size="3"><b>设置企业站标题</b></font></td>
				<td width="300" align="center" > 
					<form action="/doCompanyTradeReg.do" name="comForm" method="post">	
			    		<input type="text" name="cust_name" id="company" style="color: #FF0000" value="<%=company%>" size="20" maxlength="20" onClick="this.value=''">
			    		<input type="hidden" name="trade_type_code" id="trade_type_code" value="9945">
						<input type="submit" name="submit" value="设 置"/>
			      	</form>			    
				</td>
				<td width="150" align="right">&nbsp;</td>
			  </tr>
			  <tr>
			    <td align="left">&nbsp;&nbsp;&nbsp;<a href="build.jsp?flag=1"><font color="#3300FF" size="3"><b>选择其他模板</b></font></a></td>
				<td align="center">&nbsp;</td>
				<td align="right">&nbsp;</td>
			  </tr>
			  <tr style="display:none">
			    <td align="left">&nbsp;&nbsp;&nbsp;<a href="javascript:window.close()"><font color="#3300FF" size="3"><b>关闭此窗口</b></font></a></td>
				<td align="center">&nbsp;</td>
				<td align="right">&nbsp;</td>
			  </tr>
			  <tr>
			  	<td align="left">&nbsp;</td>
			    <td align="center"><img src="<%=srcpath%>" width="166" height="166"/></td>
				<td align="right">&nbsp;</td>
			  </tr>
			</table>
			<table width="100%" id="public" border="0" align="center" cellpadding="0" cellspacing="0" style="<%=display%>">
			  <tr>
				<%
				
				for( int i = 0; i <= count; i++ )
				{
					name[i] = name[i].replaceAll( " ",   "");
					
					String src1 = "/images/entimage/"+name[i]+".jpg";
					String value1 = name[i];//"company/enterprise/public/"+name[i];
					String number ="";
					if( name[i].equals( "default" ) )
						number = "1";
					else
					{
						for( int j = 0; j < name[i].length(); j++ )
							if( name[i].charAt( j ) <= '9' && name[i].charAt(j) >= '0' )
								number = "" + name[i].charAt(j);
					}
					if( i == 4 )
						out.println("<tr>");
					 
					srcpath = src1;	
				%>
                <td>
                <table>
                <tr><td><img src="<%=src1%>" width="166" height="166"/></td></tr>
                <tr>
                	<td align="center"><!-- createCustomerWeb(this.value) -->
                		模板<%=number%> | <a href="build.jsp?modename=<%=value1%>&srcpath=<%=srcpath%>">点击应用</a>
                	</td>
                </tr>
				</table>
				</td>
				<%	
					 
				}%>
			  </tr>
			</table>
		 </td>
		</tr>
	</table>
	</body>
</html>




