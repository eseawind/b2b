<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
	config con = new config();
	ArrayList conlist =  new ArrayList();
	conlist = con.getLogProperties();
%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>配置文件管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript">
		</script>
</head>
<body>
		<form name=form action=logindo.jsp method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
				<td style="font-size:20px;text-align:center;color:red">请谨慎修改，错误的参数会导致系统无法正常运行！
				</td>
			</tr>
			<tr>
				<td>
					<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
						<tr class="u4" height="">
							<td align="left" width="30%">
								说明
							</td>
							<td align="left" width="30%">
								名称
							</td>
							<td align="left" width="40%">
								配置数据
							</td>
						</tr>
						<%
						String sss = "";
							if(conlist!=null){
							String help="",name="",value="";
							String help2="";
							for(int i=0;i<conlist.size();i++){
							String nfn = "name"+i;
							String nfv = "value"+i;
							String nfh = "help"+i;
							HashMap map = (HashMap)conlist.get(i);
							if(map.get("help")!=null){
								help = map.get("help").toString();
								sss += "#"+help+"<br>";
							}
							if(map.get("name")!=null){
								name = map.get("name").toString();
								value = map.get("value").toString();
								sss += name +"=" +value+"<br>";
								}
							%>
						<tr class="u2">
							<%if(!name.equals("")){%>
							<td align="left"><%
								if(!help.equals(help2)){
								out.println(help);
								}help2 = help;%><input type="hidden" name=help<%=i%>  id=help<%=i%>  maxlength=90 size=40 value=<%=help%>></td>
								<%}%>
								<%	if(map.get("name")!=null){%>
							<td align="left"><%=name%><input type="hidden" name="name<%=i%>"  id="name<%=i%>" value=<%=name%>></td>
							<td align="left">
								<input type="text" name="value<%=i%>"  id="value<%=i%>"  maxlength=90 size=40 value=<%=value%>>
							</td>
							<%}%>
						</tr>
						<%name=new String("");}
						}%>
						<tr>
							<td class="u3" colspan="4">
								<input name="trade_type_code" type="hidden" value="0000">
								<input name="listsize" type="hidden" value="<%=conlist.size()%>">
								<input class="tjan" name=submit1 type=submit value="" >
							</td>
						</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
 



