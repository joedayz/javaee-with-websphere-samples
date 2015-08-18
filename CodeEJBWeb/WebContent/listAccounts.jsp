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
<title>List Accounts</title>
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
         <td valign="top"><siteedit:navbar spec="/CodeEJBWeb/theme/nav_head.jsp" target="topchildren"></siteedit:navbar></td>
      </tr>
      <tr class="content-area">
         <td valign="top"><%-- tpl:put name="bodyarea" --%>
					<table width="700" height="424" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<tbody>
							<tr>
								<td height="21" width="7"></td>
								<td width="700"></td>
							</tr>
							<tr>
								<td height="397"></td>
								<!-- flm:cell -->
								<td valign="top" align="center">
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
												value="<c:out value='${requestScope.customer.title}' />" /></td>
										</tr>

										<tr>
											<td align="left">First name:</td>
											<td><input type="text" name="firstname"
												value="<c:out value='${requestScope.customer.firstName}' />"
												size="36" /></td>
										</tr>

										<tr>
											<td align="left">Last name:</td>
											<td><input type="text" name="lastname"
												value="<c:out value='${requestScope.customer.lastName}' />"
												size="36" /></td>
										</tr>

										<tr>
											<td align="left"></td>
											<td><input type="submit" value="Update" name="update"> &nbsp; 
												<input type="submit" value="New Customer" name="new"> &nbsp; 
												<input type="submit" value="Delete Customer" name="delete"> </td>
										</tr>
									</tbody>
								</table>
								</form>
								<hr>
								<table height="158">
									<thead>
										<tr>
											<th width="336" align="left">Account Number</th>
											<th width="436" align="right">Balance</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="varAccounts" items="${requestScope.accounts}">
											<tr>
												<td width="409"><c:url value="AccountDetails" var="urlVariable">
													<c:param name="accountId"
														value="${varAccounts.id}"></c:param>
												</c:url> <a href="<c:out value='${urlVariable}'/>"> 
													<c:out value="${varAccounts.id}" /> </a></td>
												<td align="right" width="359"><c:url value="AccountDetails"
													var="urlVariable">
													<c:param name="accountId"
														value="${varAccounts.id}"></c:param>
												</c:url> <a href="<c:out value='${urlVariable}'/>"> 
													<fmt:formatNumber maxFractionDigits="2"
														minFractionDigits="2" value="${varAccounts.balance}"></fmt:formatNumber>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<hr>
								<table border="0" cellpadding="10">
									<tbody>
									<tr>
									<td>
										<form action="NewAccount" method="post">
											<input type="submit" value="Add Account">
										</form>										
									</td><td>
										<form action="Logout" method="post">
											<input type="submit" value="Logout">
										</form>
									</td>
									</tr>
									</tbody>
								</table>								
								</td>
							</tr>
							<tr>
								<td height="6"></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				<%-- /tpl:put --%></td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/CodeEJBWeb/theme/footer.jsp" target="ancestor"></siteedit:navbar></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>