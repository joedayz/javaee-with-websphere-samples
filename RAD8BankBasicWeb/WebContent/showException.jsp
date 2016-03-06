<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="theme/gray.css" type="text/css">
<title>Show Exception</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Application Developer">
</head>
<body>
	<table width="700" height="207" cellspacing="0" cellpadding="0"
		border="0">
		<tbody>
			<tr>
				<td height="33" width="37"></td>
				<td width="632"></td>
				<td width="31"></td>
			</tr>
			<tr>
				<td height="141"></td>
				<td valign="top">
				<table border="0" width="600">
					<tbody>
						<tr>
							<td>
							<table width="612">
								<tbody>

									<tr>
										<td align="left" width="200">An error has occurred:</td>
										<td><c:out value="${requestScope.message}" /></td>
									</tr>

								</tbody>
							</table>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td align="left"></td>
							<td><c:url value="${requestScope.forward}"
								var="urlVariable"></c:url>
								<a href="welcome.html"> 
								   <c:out value="Click here to continue" /></a></td>
						</tr>
					</tbody>
				</table>
				</td>
				<td></td>
			</tr>
			<tr>
				<td height="33"></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>