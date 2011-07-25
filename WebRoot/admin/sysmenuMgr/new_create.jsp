<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.base.config.ProjectConfig"%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		 
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		h1 {float:left;padding-left:8px; font-size:15px; font-weight:bold; padding-top:5px;}
		</style>
		<script language="javascript">
		function setDatas( typesj )
			{
				var selType=typesj;
				document.form0.createType.value=selType;
				document.form0.num.value=document.getElementById("num"+selType).value;
				return false;
			}
			function   isNum(str)
			{   
			  return   (str.search(/^\d+(\.\d+)?$/)!=-1);   
			}   
		</script>
	</head>
	<body>
		<br><br><br> 
	  <h1>内容管理</h1>
	  <form name="form0" method="post" action="new_build.jsp" target="_blank">
	  <table width=100% border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
		<tr>
			<td class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  width="150" align="center">生成页面所在位置</td>
			<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  width="150" align="center">生成数量</td>
			<td style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"  width="100" align="center">执行</td>
		</tr>
		<!---生成说明   createType为生成类型: 0:首页 1:供应信息 2:求购信息  3：企业库  4:资讯 5:人才库 6:学院 7:企业管理---->
		<!---0:首页---->
		
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;" >网站首页及相关页面数量</td>
					<td style=" color:#000000;">
						<input name="num0" type="text" id="num0" value="100" ></td>
						<input name="createType" type="hidden" id="createType" value="0">
						<input name="num" type="hidden" id="num" value="0">
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('0')">
					</td>
				</tr>
	
	     <!---1:供应信息---->

				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">供应信息首页及相关页面数量</td>
					<td style=" color:#000000;">
						<input name="num1" type="text" id="num1" value="100"  >
					</td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('1')">
					</td>
				</tr>
		
	     <!---2:求购信息---->
		
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">求购信息首页及相关页面数量 </td>
					<td style=" color:#000000;">
						<input name="num2" type="text" id="num2" value="100"  >
					</td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('2')">
					</td>
				</tr>
	
	
		   <!---3:企业库---->
			
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">企业库首页及相关页面数量 </td>
					<td style=" color:#000000;">
						<input name="num3" type="text" id="num3" value="100"  >
					</td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('3')">
					</td>
				</tr>
	
				<!---4:资讯---->
			
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">资讯首页及相关页面数量 </td>
					<td style=" color:#000000;">
						<input name="num4" type="text" id="num4" value="100">
					</td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('4')">
					</td>
				</tr>
	
		     <!---5:人才库---->
			
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">人才库首页及相关页面数量</td>
					<td style=" color:#000000;">
						<input name="num5" type="text" id="num5" value="100"></td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('5')">
					</td>
				</tr>
	
		    <!---6:学院---->
			
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">学院首页及相关页面数量</td>
					<td style=" color:#000000;">
						<input name="num6" type="text" id="num6" value="100">
					</td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('6')">
					</td>
				</tr>
	   
	    	<!---7:企业管理---->
		
				<tr style="background-color:#f9f9f9;">
					<td style=" color:#000000;">企业管理及相关页面数量</td>
					<td style=" color:#000000;">
						<input name="num7" type="text" id="num7" value="100"></td>
					<td style=" color:#000000;">
						<input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('7')">
					</td>
				</tr>
	   
	 <!--  
	  <tr align="center">
	     <td colspan="3" class="line1" style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;">生成其他栏目的详细页面</td>
	  </tr>
	
	   -7产品详细页面 
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr7" onmouseover="MM_changeProp('changcolor_tr7','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr7','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">产品详细页面</td>
				<td style=" color:#000000;"><input name="num7" type="text" id="num7" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('7')"></td>
			</tr>
		
	
	   <!---8客户详细页面 
		
			<tr  style="background-color:#f9f9f9; " id="changcolor_tr8" onmouseover="MM_changeProp('changcolor_tr8','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr8','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">客户详细页面</td>
				<td style=" color:#000000;"><input name="num8" type="text" id="num8" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('8')"></td>
			</tr>
		
	
		<!---9供应信息详细页面  
	
			<tr style="background-color:#f9f9f9; " id="changcolor_tr9" onmouseover="MM_changeProp('changcolor_tr9','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr9','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">供应信息详细页面</td>
				<td style=" color:#000000;"><input name="num9" type="text" id="num9" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('9')"></td>
			</tr>
		
	
		<!---10求购信息详细页面  
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr10" onmouseover="MM_changeProp('changcolor_tr10','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr10','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">求购信息详细页面</td>
				<td style=" color:#000000;"><input name="num10" type="text" id="num10" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('10')"></td>
			</tr>
		
	
		<!---11招聘信息详细页面  
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr11" onmouseover="MM_changeProp('changcolor_tr11','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr11','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">招聘信息详细页面</td>
				<td style=" color:#000000;"><input name="num11" type="text" id="num11" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('11')"></td>
			</tr>
	
	
		<!---12招标信息详细页面  
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr12" onmouseover="MM_changeProp('changcolor_tr12','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr12','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">招标信息详细页面</td>
				<td style=" color:#000000;"><input name="num12" type="text" id="num12" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('12')"></td>
			</tr>
	
	
		<!---13求职信息详细页面  >
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr13" onmouseover="MM_changeProp('changcolor_tr13','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr13','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">求职信息详细页面</td>
				<td style=" color:#000000;"><input name="num13" type="text" id="num13" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('13')"></td>
			</tr>
	
	
		<!---14资讯信息详细页面  ->
	
			<tr style="background-color:#f9f9f9; " id="changcolor_tr14" onmouseover="MM_changeProp('changcolor_tr14','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr14','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">资讯信息详细页面</td>
				<td style=" color:#000000;"><input name="num14" type="text" id="num14" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('14')"></td>
			</tr>
	
	
		<!---15学院信息详细页面  ->
	
			<tr style="background-color:#f9f9f9; " id="changcolor_tr15" onmouseover="MM_changeProp('changcolor_tr15','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr15','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">学院信息详细页面</td>
				<td style=" color:#000000;"><input name="num15" type="text" id="num15" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('15')"></td>
			</tr>
	
	
		<!---16生成所有JS页面
		
			<tr style="background-color:#f9f9f9; " id="changcolor_tr16" onmouseover="MM_changeProp('changcolor_tr16','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr16','','backgroundColor','#f9f9f9','DIV')">
				<td style=" color:#000000;">生成所有JS页面</td>
				<td style=" color:#000000;"><input name="num16" type="text" id="num16" value="100"></td>
				<td style=" color:#000000;"><input type="submit" name="Submit22" value=" 生 成 " onclick="setDatas('16')"></td>
			</tr>    
			         -->
		
		</table></form>
 </body>
</html>



