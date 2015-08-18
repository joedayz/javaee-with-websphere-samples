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
<title>List Transactions</title>
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
					<table width="700" height="329" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<tbody>
							<tr>
								<td height="50" width="3"></td>
								<td width="694"></td>
							<td width="3"></td></tr>
							<tr>
								<td height="260"></td>
								<!-- flm:cell -->
								<td valign="top" align="center">
								<table border="0">
									<tbody>
										<tr>
											<td><table width="653">
												<tbody>

													<tr>
														<td align="left">AccountNumber:</td>
														<td><c:out
															value="${requestScope.account.id}" /></td>
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
													<fmt:formatDate value="${varTransactions.transTime}" type="both" dateStyle="short" timeStyle="short"/>
												</td>
												<td><c:out value="${varTransactions.transType}" /></td>
												<td align="right">
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${varTransactions.amount}"/>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<hr>
								<form method="post" action="AccountDetails"><input type="hidden" name="accountId"
									value="${requestScope.account.id}"><input
									type="submit" value="Account Details"></form>
								</td>
							<td></td></tr>
							<tr>
								<td height="19"></td>
								<td></td>
							<td></td></tr>
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