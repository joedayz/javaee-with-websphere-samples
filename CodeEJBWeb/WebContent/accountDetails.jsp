<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- tpl:insert page="/theme/itso_jsp_template.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://www.ibm.com/siteedit/sitelib" prefix="siteedit" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/gray.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>Account Detail</title>
<%-- /tpl:put --%></head>
<body>
<table width="600" cellspacing="0" cellpadding="0" border="0">
   <tbody>
      <tr>
         <td valign="top">
         <table class="header" cellspacing="0" cellpadding="0" border="0" width="100%">
            <tbody>
               <tr>
                  <td width="150"><img border="0" width="70" height="50" alt="Company's LOGO" src="${pageContext.request.contextPath}/theme/itso_logo.gif"></td>
                  <td><H1>ITSO <Font color="red">RedBank</Font></H1></td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/RAD8EJBWeb/theme/nav_head.jsp" target="topchildren"></siteedit:navbar></td>
      </tr>
      <tr class="content-area">
         <td valign="top"><%-- tpl:put name="bodyarea" --%>
					<table width="700" height="356" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<tbody>
							<tr>
								<td height="16" width="63"></td>
								<td width="646"></td>
								<td width="50"></td>
							</tr>
							<tr>
								<td height="294"></td>
								<!-- flm:cell -->
								<td valign="top" align="center">
								<table border="0">
									<tbody>
										<tr>
											<td><table width="636" height="73">
												<tbody>

													<tr>
														<td align="left">Account Number:</td>
														<td><c:out
															value="${requestScope.account.id}" /></td>
													</tr>

													<tr>
														<td align="left">Balance:</td>
														<td><fmt:formatNumber maxFractionDigits="2"
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
								<form method="post" action="PerformTransaction"><input
									type="hidden" name="accountId"
									value='<c:out value="${requestScope.account.id}" />'>
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
								<hr>
								<table border="0" cellpadding="10">
									<tbody>
									<tr>
									<td>
										<form action="ListAccounts" method="post">
											<input type="submit" value="Customer Details">
										</form>
									</td><td>
										<form action="DeleteAccount" method="post">
											<input type="hidden" name="accountId"
												value='<c:out value="${requestScope.account.id}" />'>
											<input type="submit" value="Delete Account">
										</form>
									</td>
									</tr>
									</tbody>
								</table>
								<td></td>
							</tr>
							<tr>
								<td height="46"></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				<%-- /tpl:put --%></td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/RAD8EJBWeb/theme/footer.jsp" target="ancestor"></siteedit:navbar></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>