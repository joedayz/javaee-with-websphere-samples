
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="theme/gray.css" type="text/css">
<title>Account Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Application Developer">
</head>
<body>
	<table width="700" height="356" cellspacing="0" cellpadding="0" border="0">
	<tbody>
			<tr>
				<td height="16" width="63"></td>
				<td width="646"></td>
				<td width="50"></td>
			</tr>
			<tr>
				<td height="294"></td>
				<td valign="top" align="center">
				<table border="0">
					<tbody>
						<tr>
							<td><table width="636" height="73">
								<tbody>
									<tr>
										<td align="left">Account Number:</td>
										<td><c:out
											value="${requestScope.account.accountNumber}" /></td>
									</tr>
									<tr>
										<td align="left">Balance:</td>
										<td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2"
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
				<form method="post" action="PerformTransaction"><input
					type="hidden" name="accountId"
					value='<c:out value="${requestScope.account.accountNumber}" />'>
				<center>
				<table border="0">
					<tbody>
						<tr>
							<td><input type="radio" name="transaction" value="list"
								checked></td>
							<td colspan="3" width="380">List Transactions</td>
						</tr>
						<tr>
							<td><input type="radio" name="transaction"
								value="withdraw"></td>
							<td>Withdraw</td>
							<td rowspan="2">Amount:</td>
							<td rowspan="2"><input type="text"
								name="amount" size="20"></td>
						</tr>
						<tr>
							<td><input type="radio" name="transaction"
								value="deposit"></td>
							<td>Deposit</td>
						</tr>
						<tr>
							<td><input type="radio" name="transaction"
								value="transfer"></td>
							<td>Transfer</td>
							<td>To Account:</td>
							<td><input type="text"
								name="targetAccountId" size="20"></td>
						</tr>
						<tr>
							<td colspan="4" align="center"><input type="submit"
								value="Submit"></td>
						</tr>
					</tbody>
				</table>
				</center>
				</form>
				<form action="ListAccounts" method="post"><input type="submit"
					value="Customer Details"></form>
				</td>
				<td></td>
			</tr>
			<tr>
				<td height="46"></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>