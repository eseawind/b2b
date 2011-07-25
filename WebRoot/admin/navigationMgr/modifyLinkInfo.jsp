<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=GBK"%>

<%@ page import="com.saas.biz.commen.ParamethodMgr"%>

<%@ page import="com.saas.biz.indexLinkMgr.*" %>

<%

     String link_id="",link_name="",link_no="",link_type="",link_desc="",link_url="";

     if (request.getParameter("link_id") != null)

     {

        link_id = request.getParameter("link_id");

        IndexlinkInfo linkInof=new IndexlinkInfo();

        ArrayList inofList=linkInof.getLinkInfoById(link_id);

        if(inofList != null && inofList.size()>0)

        {

           HashMap map=(HashMap)inofList.get(0);

           if(map.get("link_name")!=null)

           {

             link_name=map.get("link_name").toString();

           }

           if(map.get("link_no")!=null)

           {

             link_no=map.get("link_no").toString();

           }

           if(map.get("link_type")!=null)

           {

             link_type=map.get("link_type").toString();

           }

           if(map.get("link_desc")!=null)

           {

             link_desc=map.get("link_desc").toString();

             link_desc=link_desc.replaceAll("<[^<>]+>","");

           }

           if(map.get("link_url")!=null)

           {

             link_url=map.get("link_url").toString();

           }

        }

     }

     ParamethodMgr paramCom=new ParamethodMgr();

	ArrayList  linkTypeList =paramCom.getCompareInfo("CRM","link_type");

	

%>

<html>

<head>

<title>修改页面导航</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
<style type="text/css">

.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/

.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}

.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}

.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
.tjan {
	background: url(/admin/images/tj.gif) left center no-repeat;
	width: 78px;
	height: 32px;
	border: 0px;
	cursor: hand;
}
</style>

<script language="JavaScript">

     function check_none()

     {

          if (document.formQuery.advshow.checked)

          {

      	    document.formQuery.submit1.disabled=false;        	     

      	}

      	else

      	{

      	   document.formQuery.submit1.disabled=true;

      	}

  	}

    	function exit()

    	{

    	    window.close();

    	}

    	function confirmsub(){
	        if(document.formQuery.link_name.value== "" || document.formQuery.link_name.value == null){
						alert("链接名称不可以为空！");                                                             
						document.formQuery.link_name.focus();                                                    
						return false;     
	 				}
			    if(document.formQuery.link_url.value== "" || document.formQuery.link_url.value == null){
							alert("链接地址不可以为空！");                                                             
							document.formQuery.link_url.focus();                                                    
							return false;     
			    }
	    		document.formQuery.submit();    	         
    	   
    	}

  </script>

</head>

<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="pageIndex.jsp"><b>友情链接管理</b></a>
				</td>
			</tr>
		</table>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	  </table>

		     <table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">

		     		<input name=link_id type=hidden value="<%=link_id%>">

		     		<input name=trade_type_code type=hidden value=0916>
				    <tr>

				      <td width="14%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;">链接名称：</td>

				      <td width="86%" align=left bgcolor="#FFFFFF"><div class="ping"><input type=text name="link_name" maxlength=50 size=50 value="<%=link_name%>"></div></td>

				    </tr>

				    <tr style="display:none">

				      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>链接类型：</td>

				      <td align=left bgcolor="#FFFFFF"><div class="ping1"><select name=link_type>

				               <%

									if(linkTypeList != null && linkTypeList.size()>0)

									{

										for(int i=0;i<linkTypeList.size();i++)

										{

											HashMap map=(HashMap)linkTypeList.get(i);

											String value=map.get("para_code1").toString();

											String name=map.get("para_code2").toString();

											%>

				                               <option value="<%= value %>"><%= name %></option>

				                               <%

										}

									} %>

				        </select>
</div>
				    </td>

                    </tr>

                     <tr>

				      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>链接地址：</td>

				      <td align=left bgcolor="#FFFFFF"><div class="ping1"><input type=text name=link_url maxlength=50 size=50  value="<%=link_url%>">( http://www.xxxx.com)</div></td>

				    </tr>

                    <tr>

				      <td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>链接说明：</td>

				      <td align=left bgcolor="#FFFFFF"><div class="ping1"><textarea name=link_desc style=display:none><%=link_desc%></textarea>

				         <iframe id="link_desc" src="/www/ewebeditor/ewebeditor.htm?id=link_desc&style=coolblue&root_id=<%=link_id%>" frameborder=0 scrolling=no width=600 height=350></iframe>  
</div>
				      </td>

				    </tr>

				    <tr>

				      <td  style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right>显示顺序：</td>

				      <td align=left bgcolor="#FFFFFF"><div class="ping1"><input type=text name=link_no maxlength="100" value="<%=link_no%>" onkeyup="if(isNaN(value))execCommand('undo')">
										(只能输入数字)</div></td>

				    </tr>

				    <tr>

				      <input type=hidden name=rsrv_num1 value=0>

				     
				    </tr>

				    <tr>

				      <td  colspan="2" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"  align=center><input class="tjan" name="submit1" type=submit value="" onclick=confirmsub()>&nbsp;&nbsp;
							&nbsp;&nbsp;
							<img src="/admin/images/comeback.JPG" onClick="location.href='pageIndex.jsp'" style="cursor:hand;" align="absmiddle">
							</td>
				    </tr>

	      </table>

	  
		</form>



</body>

</html>



