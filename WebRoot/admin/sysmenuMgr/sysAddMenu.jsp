<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		
		<style type="text/css">
			.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*������ʽ6---- ͷ������1*/
			.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
			.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
			.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*������ʽ1*/
			</style>
	</head>
	<%
		CommParaMgr commPara = new CommParaMgr();
		commMethodMgr comm = new commMethodMgr();
		String menuclass = request.getParameter("class");
		String upMenuId = "";
		if (!menuclass.equalsIgnoreCase("1"))
		{
			upMenuId = request.getParameter("menuId");
		}
	%>
	<body>
		<html:form action="/addmenu">
			<table width="100%" border="0" cellpadding="5" cellspacing="1" align="center" bgcolor="#dddddd">

				<tr>

					<td class="line1" align="left" colspan="6">
						�����˵�

					</td>

				</tr>

				<tr>

					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right" width="18%">
						��ϵͳ���룺
					</td>

					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left" width="82%">
						<div class="ping1">
							<html:text property="subsys_code" maxlength="8" size="8" />

							<html:errors property="subsys_code" />
						</div>

					</td>

				</tr>
				<tr>
				<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right" width="18%">
					�˵����ƣ�
				</td>

				<td width="82%" align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">

					<div class="ping1">
						<input type="text" name="menu_name" value="" size="30" />
					</div>
				</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align="right" width="18%">
						�ϼ��˵���
					</td>
					<td style="background-color:#ffffff; color:#000000; font-size:12px;" align="left">
						<div class="ping1">
							<%
								String upMenuName = "";
								if (menuclass.equalsIgnoreCase("1")) {
									upMenuName = "���ϼ��˵�";
									upMenuId = "NULL";
								} else {
									upMenuName = comm.ConvertCodeToName("menuname", upMenuId);
								}
							%>
							<%=upMenuName%>
							<input type=hidden name=up_menu_id value=<%=upMenuId%>>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�˵�����
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left">
						<div class="ping1">
							<%=menuclass%>
							��
							<input type=hidden name=menu_class value=<%=menuclass%>>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�˵����ͣ�
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left">
						<div class="ping1">
							<html:select property="menu_type" size="1">
								<html:option value="0">0��----��ͨ�˵�---</html:option>
							</html:select>
							<html:errors property="menu_type" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						��Ӧ�ӿ�ģ�飺
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left">
						<div class="ping1">
							<html:select property="module_id" size="1">
								<%=commPara.GenModuleOption()%>
							</html:select>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���1��
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_code1" maxlength="30" size="30" />

							<html:errors property="in_param_code1" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���ֵ1��
					</td>
					<td style="background-color:#ffffff; color:#000000; font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_value1" maxlength="30" size="30" />
							<html:errors property="in_param_value1" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���2��
					</td>
					<td style="background-color:#ffffff; color:#000000; font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_code2" maxlength="30" size="30" />
							<html:errors property="in_param_code2" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���ֵ2��
					</td>
					<td style="background-color:#ffffff; color:#000000; font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_value2" maxlength="30" />
							<html:errors property="in_param_value2" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���3��
					</td>
					<td style="background-color:#ffffff; color:#000000; font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_code1" maxlength="10" />
							<html:errors property="in_param_code1" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" width="18%">
						�ӿڲ���ֵ3��
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align="left">
						<div class="ping1">
							<html:text property="in_param_value3" maxlength="10" />
							<html:errors property="in_param_value3" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
						<input class="qdzjan" type="submit" name="Submit1" value="">
					</td>
				</tr>
			</table>
		</html:form>
	<body>
</html>




