<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- tpl:insert page="/theme/itso_jsp_template.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://www.ibm.com/siteedit/sitelib" prefix="siteedit" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/gray.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>Show Exception</title>
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
					<table width="700" height="207" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<tbody>
							<tr>
								<td height="33" width="37"></td>
								<td width="632"></td>
								<td width="31"></td>
							</tr>
							<tr>
								<td height="141"></td>
								<!-- flm:cell -->
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
												<a href="index.jsp"> 
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
				<%-- /tpl:put --%></td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/RAD8EJBWeb/theme/footer.jsp" target="ancestor"></siteedit:navbar></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>