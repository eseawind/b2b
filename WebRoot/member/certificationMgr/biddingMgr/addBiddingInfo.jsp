<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=GBK"%>

<%@ page import="java.util.Date"%>

<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="com.saas.biz.commen.ParamethodMgr"%>

<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page"/>

	<%

	String fbtime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	String bidding_id=bean.GenTradeId();

	%>

<html>

<head>

<title>发布招标公告</title>



<script language="javascript" src="/js/Calendar_Ly.js"></script>
<script type="text/javascript" src="/js/certificationMgr.js"></script>

</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>

  <tr>

    <td valign="top" >
 <form name=bidForm action=/doTradeReg.do method=post target="_self">
	      <table width=100% border=0 cellpadding=5 cellspacing=1 align=center  bgcolor="#dddddd">

		 

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"  align=right  width="15%">招标标题：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left  width="75%"><div class="ping"><input name="title" type="text" size=50 maxlength=50></div>

            </td>

          </tr>

          <input name="bidding_id" type="hidden" value=<%=bidding_id%>>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>标号：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
            	<div class="ping"> 
            	<input name="bidding_no" type="text" size=50 maxlength=50>
						</div>
            </td>

          </tr>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>开标时间：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
            	<div class="ping"> 
            	<input name="open_date" id="open_date" readonly type="text" size=10  onfocus="setday(this);"  style="width:93px">
            	</div>
            	</td>

          </tr>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>招标地点：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
            	<div class="ping"> 
            	<input name="addr" type="text" size=50 maxlength=50>
            	</div>

            </td>

          </tr>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>招标说明：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
            	<div class="ping"> 
            	<textarea name="content" style=display:none></textarea>
              <iframe ID=content src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=bidding_id%> frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
              </div>
              </td>

          </tr>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>联系电话：</td>

            <td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
            	<div class="ping"> 
            	<input name="phone" id="phone" type="text" size=25 maxlength=25>
							</div>
            </td>

          </tr>

          <input name="trade_type_code" type="hidden" value="0236">

          <input name="attach_tag" type="hidden" value="0">

          <tr>

            <td style="background-color:#ffffff; color:#000000; padding:3px 5px;  font-size:12px;" colspan=2 align="center"><INPUT name="advshow" type="checkbox" value="0" onclick="addBiddingInfocheck_none(bidForm)">

              &nbsp;以上资料正确无误。

            </td>

          </tr>

          <tr>

            <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px; padding-top:10px;padding-bottom:10px;" align="center" colspan=2><input class="tjan" name="submit1" type="button" value="" disabled="true" onclick="addBiddingInfoconfirmsub(bidForm)">

            </td>

          </tr>

        

      </table>
   </form>
	  </td>

  </tr>

  <tr>

    <td height="13"></td>

  </tr>

</table>

</body>

</html>





