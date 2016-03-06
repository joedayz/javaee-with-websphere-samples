<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="theme/gray.css" type="text/css">
<title>List Transaction</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Application Developer">
</head>
<body>
	<table width="700" height="329" cellspacing="0" cellpadding="0"
		border="0">
		<tbody>
			<tr>
				<td height="50" width="3"></td>
				<td width="694"></td>
			<td width="3"></td></tr>
			<tr>
				<td height="260"></td>
				<td valign="top" align="center">
				<table border="0">
					<tbody>
						<tr>
							<td><table width="653">
								<tbody>
									<tr>
										<td align="left">AccountNumber:</td>
										<td><c:out
											value="${requestScope.account.accountNumber}" /></td>
									</tr>
									<tr>
										<td align="left">Balance:</td>
										<td>
											<fmt:formatNumber maxFractionDigits="2"
											minFractionDigits="2"
											value="${requestScope.account.balance}"></fmt:formatNumber>														
										</td>
									</tr>
								</tbody>
							</table>
							</td>
						</tr>
					</tbody>
				</table>
				<hr>
				<table border="1" cellpadding="5">
					<thead>
						<tr>
							<th>Time</th>
							<th>Transaction Type</th>
							<th width="80">Amount</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="varTransactions"
							items="${requestScope.transactions}">
							<tr>
								<td>
									<fmt:formatDate value="${varTransactions.timeStamp}" type="both" dateStyle="short" timeStyle="short"/>
								</td>
								<td><c:out value="${varTransactions.transactionType}" /></td>
								<td align="right">
									<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${varTransactions.amount}"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
				<form method="post" action="AccountDetails"><input type="hidden" name="accountId"
					value="${requestScope.account.accountNumber}"><input
					type="submit" value="Account Details"></form>
				</td>
			<td></td></tr>
			<tr>
				<td height="19"></td>
				<td></td>
			<td></td></tr>
		</tbody>
	</table>
</body>
</html>