<%@ page contentType="text/html;charset=GBK" language="java" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>B2B���������̨����ϵͳ</title>
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
<td height="25" colspan="2" align="center" bgcolor="efefef">B2B��վ���ɾ�̬ҳ�����̨</td>
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
<td height="22" colspan="2">�������������������</td>
</tr>
<tr>
<td width="11%" height="22" align="right">Ƶ����ҳ��</td>
<td width="89%" height="22">��վ��ҳ ��ҵ�� ��Ӧ��Ϣ ����Ϣ �˲ſ� ��Ѷ ѧԺ</td>
</tr>
<tr>
<td height="22" align="right">��&nbsp;��&nbsp;ҳ��</td>
<td height="22"><a href="buildHtml.jsp?action=productlist" target="_blank">��Ʒ�б�</a> <a href="buildHtml.jsp?action=productlist" target="_blank">��ҵ�б�</a> <a href="buildHtml.jsp?action=productlist" target="_blank">��Ӧ��Ϣ�б�</a> <a href="buildHtml.jsp?action=productlist" target="_blank">����Ϣ�б�</a> ��ְ��Ϣ�б� ��Ƹ��Ϣ�б� �����б� ѧԺ���������б�</td>
</tr>
<tr>
<td height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
<td height="22">��Ʒ
<input name="product" type="text" id="product" value="100">          </td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��ҵ
<input name="enterprise" type="text" id="enterprise" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��Ӧ
<input name="supply" type="text" id="supply" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��
<input name="stock" type="text" id="stock" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">�б�
<input name="bidding" type="text" id="bidding" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��ְ
<input name="job" type="text" id="job" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��Ƹ
<input name="zp" type="text" id="zp" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">��Ѷ
<input name="news" type="text" id="news" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">ѧԺ
<input name="school" type="text" id="school" value="100"></td>
</tr>
<tr>
<td height="22" align="right">&nbsp;</td>
<td height="22">ע��input������ֵ�����ɴ���ҳ�����¼�¼����</td>
</tr>
<tr>
<td height="30" align="right">&nbsp;</td>
<td height="30"><input type="submit" name="Submit" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��Ʒ
              <input name="product" type="text" id="product" value="100"></td>
          </tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit22" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��ҵ
              <input name="enterprise" type="text" id="enterprise" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit23" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��Ӧ
              <input name="supply" type="text" id="supply" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit24" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��
              <input name="stock" type="text" id="stock" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit25" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">�б�
              <input name="bidding" type="text" id="bidding" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit26" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��ְ
              <input name="job" type="text" id="job" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit27" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��Ƹ
              <input name="zp" type="text" id="zp" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit28" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">��Ѷ
                <input name="news" type="text" id="news" value="100"></td>
          </tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit29" value=" �� �� "></td>
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
            <td height="22" colspan="2">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="right">��&nbsp;ϸ&nbsp;ҳ��</td>
            <td width="89%" height="22">ѧԺ
              <input name="school" type="text" id="school" value="100"></td></tr>
          <tr>
            <td height="30" align="right">&nbsp;</td>
            <td height="30"><input type="submit" name="Submit2" value=" �� �� "></td>
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
            <td height="22">�������������������</td>
          </tr>
          <tr>
            <td width="11%" height="22" align="center"><a href="buildHtml.jsp?action=js" target="_blank">��������JS</a></td>
         </tr>
    </table></form></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>



