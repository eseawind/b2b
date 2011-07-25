<%@ page contentType="text/html;charset=GBK" %>
<%
    Cookie[] cookies=request.getCookies();   
    
      if(cookies!=null){   
          for(int i=0;i<cookies.length;i++){   
              String   tempuid_1=cookies[i].getName();   
              cookies[i].setPath("/");
              cookies[i].setMaxAge(0);   
              response.addCookie(cookies[i]);     
           }   
      }   
  
%>
<HTML>
    <HEAD>
        <title>B2B电子商务后台管理系统</title>
        <META http-equiv=Content-Type content="text/html; charset=gb2312">
        <STYLE type=text/css>BODY {
        	FONT-SIZE: 12px; FONT-FAMILY: 5310317
        }
        TD {
        	FONT-SIZE: 12px; FONT-FAMILY: 5310317
        }
        A:link {
        	COLOR: #636363; TEXT-DECORATION: none
        }
        A:visited {
        	COLOR: #838383; TEXT-DECORATION: none
        }
        A:hover {
        	COLOR: #a3a3a3; TEXT-DECORATION: underline
        }
        BODY {
        	BACKGROUND-COLOR: #cccccc
        }
        </STYLE>

    <META content="MSHTML 6.00.2900.2523" name=GENERATOR>
     
</HEAD>   
 

<BODY>
<TABLE height="40%" cellSpacing=0 cellPadding=0 width="100%" align=center 
border=0>
  <TBODY>
  <TR vAlign=center align=middle>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff border=0>
        <TBODY>
        <TR>
          <TD width=20 background="/admin/images/rbox_1.gif" 
height=20></TD>
          <TD width=108 background="/admin/images/rbox_2.gif" 
          height=20></TD>
          <TD width=56><IMG height=20 src="/admin/images/rbox_ring.gif" 
            width=56></TD>
          <TD width=100 background="/admin/images/rbox_2.gif"></TD>
          <TD width=56><IMG height=20 src="/admin/images/rbox_ring.gif" 
            width=56></TD>
          <TD width=108 background="/admin/images/rbox_2.gif"></TD>
          <TD width=20 background="/admin/images/rbox_3.gif" 
        height=20></TD></TR>
        <TR>
          <TD align=left background="/admin/images/rbox_4.gif" 
          rowSpan=2></TD>
          <TD align=middle bgColor=#eeeeee colSpan=5 height=50>
            <P style="font-SIZE:13px;COLOR:red"><strong>已经安全注销登录，请选择您的下一步操作
              <br>
            </strong></P></TD>
          <TD align=left background="/admin/images/rbox_6.gif" 
          rowSpan=2></TD></TR>
        <TR>
          <TD align=left colSpan=5 height=80>
            <P align=center>
            
            <UL>
             <P style="font-SIZE:13px;COLOR:red"><strong> <br></strong></P>
             <LI id=list1> <a href="/" style="font-SIZE:13px">返回首页</a> </LI><br>
             <LI id=list1> <a href="/member/index.html" style="font-SIZE:13px">更换帐号，重新登录系统</a> </LI><br>
             <!--LI id=list1> <a href="#" onclick="closeit()" style="font-SIZE:13px">离开系统，关闭浏览器</a> </LI><br-->
          
            
             </UL>
            <DIV align=right><BR>
            <font color=#ff0000><strong>如有其他疑问，请联系我们的客服电话:0551-5310317 </strong></font></DIV></TD></TR>
        <TR>
          <TD align=left background="/admin/images/rbox_7.gif" 
          height=20></TD>
          <TD align=left background="/admin/images/rbox_8.gif" colSpan=5 
          height=20></TD>
          <TD align=left background="/admin/images/rbox_9.gif" 
          height=20></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>
 


