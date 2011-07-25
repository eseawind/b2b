<%@ page contentType="text/html;charset=GBK" language="java" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>B2B电子商务后台管理系统</title>
<link href="/style/style.css" rel="stylesheet" type="text/css">
</head>

<style type="text/css">
<!--
body {
margin-left: 0px;
margin-top: 0px;
margin-right: 0px;
margin-bottom: 0px;
}
--> 
</style>
<body>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
<tr>
<td bgcolor="#FFFFFF"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td height="25" colspan="2" align="center" bgcolor="efefef">B2B网站生成静态页面控制台</td>
</tr>
</table></td>
</tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
<tr>
<td bgcolor="#FFFFFF">
<form name="form" method="post" action="buildHtml.jsp?action=do" target="_blank">
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
<tr align="center" bgcolor="f3f3f3">
<td height="22" colspan="2">生成命令包含以下内容</td>
</tr>
<tr>
<td width="11%" height="22" align="right">频道首页：</td>
<td width="89%" height="22">网站首页 企业库 供应信息 求购信息 人才库 资讯 学院</td>
</tr>
<tr>
<td height="22" align="right">列&nbsp;表&nbsp;页：</td>
<td height="22"><a href="buildHtml.jsp?action=productlist" target="_blank">产品列表</a> <a href="buildHtml.jsp?action=productlist" target="_blank">企业列表</a> <a href="buildHtml.jsp?action=productlist" target="_blank">供应信息列表</a> <a href="buildHtml.jsp?action=productlist" target="_blank">求购信息列表</a> 求职信息列表 招聘信息列表 新闻列表 学院各级内容列表</td>
</tr>
<tr>
<td height="22" align="right">详&nbsp;细&nbsp;页：</td>
<td height="22">产品
<input name="product" type="text" id="product" value="100">          </td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">企业
<input name="enterprise" type="text" id="enterprise" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">供应
<input name="supply" type="text" id="supply" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">求购
<input name="stock" type="text" id="stock" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">招标
<input name="bidding" type="text" id="bidding" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">求职
<input name="job" type="text" id="job" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">招聘
<input name="zp" type="text" id="zp" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">资讯
<input name="news" type="text" id="news" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">学院
<input name="school" type="text" id="school" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">注：input框中数值即生成此项页面最新记录条数</td>
</tr>
<tr>
<td height="30" align="right">&nbsp;</td>
<td height="30"><input type="submit" name="Submit" value=" 提 交 "></td>
</tr>
</table></form></td>
</tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF">
     <form name="form1" method="post" action="buildHtml.jsp?action=product" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
       
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">产品
              <input name="product" type="text" id="product" value="100"></td>
          </tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit22" value=" 提 交 "></td>
          </tr>
    </table> </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF">
    <form name="form2" method="post" action="buildHtml.jsp?action=enterprise" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">企业
              <input name="enterprise" type="text" id="enterprise" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit23" value=" 提 交 "></td>
          </tr>
       
    </table> </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form3" method="post" action="buildHtml.jsp?action=supply" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">供应
              <input name="supply" type="text" id="supply" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit24" value=" 提 交 "></td>
          </tr>
        
    </table></form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form4" method="post" action="buildHtml.jsp?action=stock" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">求购
              <input name="stock" type="text" id="stock" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit25" value=" 提 交 "></td>
          </tr>
    </table></form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form5" method="post" action="buildHtml.jsp?action=bidding" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">招标
              <input name="bidding" type="text" id="bidding" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit26" value=" 提 交 "></td>
          </tr>
       
    </table> </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form6" method="post" action="buildHtml.jsp?action=job" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">求职
              <input name="job" type="text" id="job" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit27" value=" 提 交 "></td>
          </tr>
    </table> </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form7" method="post" action="buildHtml.jsp?action=zp" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">招聘
              <input name="zp" type="text" id="zp" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit28" value=" 提 交 "></td>
          </tr>
      
    </table>  </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form8" method="post" action="buildHtml.jsp?action=news" target="_blank"> 
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">资讯
                <input name="news" type="text" id="news" value="100"></td>
          </tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit29" value=" 提 交 "></td>
          </tr>
       
    </table> </form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form9" method="post" action="buildHtml.jsp?action=school" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        
          <tr align="center" bgcolor="f3f3f3">
            <td height="22" colspan="2">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">详&nbsp;细&nbsp;页：</td>
            <td width="89%" height="22">学院
              <input name="school" type="text" id="school" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit2" value=" 提 交 "></td>
          </tr>
        
    </table></form></td>
  </tr>
</table>
<br>
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666666">
  <tr>
    <td bgcolor="#FFFFFF"><form name="form9" method="post" action="buildHtml.jsp?action=school" target="_blank">
      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center" bgcolor="f3f3f3">
            <td height="22">生成命令包含以下内容</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="center"><a href="buildHtml.jsp?action=js" target="_blank">生成所有JS</a></td>
         </tr>
    </table></form></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>



