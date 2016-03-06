<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="theme/gray.css" type="text/css">
<title>List Accounts</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<form action="UpdateCustomer" method="post">
  <table>
	<tbody>

		<tr>
			<td align="left">SSN:</td>
			<td><c:out value="${requestScope.customer.ssn}" /></td>
		</tr>

		<tr>
			<td align="left">Title:</td>
			<td><input type="text" name="title" 
				value="<c:out value='${requestScope.customer.title}' />" size="6" maxlength="3"/></td>
		</tr>

		<tr>
			<td align="left">First name:</td>
			<td><input type="text" name="firstName" 
				value="<c:out value='${requestScope.customer.firstName}' />" size="32"/></td>
		</tr>

		<tr>
			<td align="left">Last name:</td>
			<td><input type="text" name="lastName" 
				value="<c:out value='${requestScope.customer.lastName}' />" size="32"/></td>
		</tr>

		<tr>
			<td align="left"></td>
			<td><input type="submit" value="Update"></td>
		</tr>
	</tbody>
  </table>
</form>
<hr>
<table width="100%">
	<thead>
		<tr>
			<th align="left">Account Number</th>
			<th align="right">Balance</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="varAccounts" items="${requestScope.accounts}">
			<tr>
				<td>
					<c:url value="AccountDetails" var="urlVariable">
						<c:param name="accountId" value="${varAccounts.accountNumber}"></c:param>
					</c:url> 
					<a href="<c:out value='${urlVariable}' />"> 
						<c:out value="${varAccounts.accountNumber}" /> 
					</a>
				</td>
				<td align="right">
					<c:url value="AccountDetails" var="urlVariable">
						<c:param name="accountId" value="${varAccounts.accountNumber}"></c:param>
					</c:url>
					<a href="<c:out value='${urlVariable}' />"> 
						<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2"
							value="${varAccounts.balance}" ></fmt:formatNumber>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr>
<form action="Logout" method="post"><input type="submit" value="Logout"></form>
</body>
</html>