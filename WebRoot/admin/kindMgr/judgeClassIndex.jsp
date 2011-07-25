<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>评测分类</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<jsp:include page="/inc/top.jsp" />
			<tr>
				<!-- 中间 -->
				<td align="center">
					<div id="manager_body">
						<!--左边菜单-->
						<div id="manager_body_right">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<div id="righttop">
											<jsp:include page="judgeClassInfo.jsp"></jsp:include>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>




