<%-- tpl:insert page="/theme/itso_jsp_template.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://www.ibm.com/siteedit/sitelib" prefix="siteedit" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/gray.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>ITSO Home</title>
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
         				<table width="760" height="268" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<tbody>
							<tr>
								<td height="41" width="72"></td>
								<td width="573"></td>
								<td width="115"></td>
							</tr>
							<tr>
								<td height="45"></td>
								<!-- flm:cell -->
								<td valign="top">
								<h1>Welcome to the ITSO RedBank!</h1>
								</td>
								<td></td>
							</tr>
							<tr>
								<td height="61"></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td height="40"></td>
								<!-- flm:cell -->
								<td valign="top">
								<p>For more information on the ITSO and IBM <font
									color="red">Red</font>books, please visit our <a
									href="http://www.ibm.com/redbooks">Internet site</a></p>
								</td>
								<td></td>
							</tr>
							<tr>
								<td height="81"></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table><%-- /tpl:put --%></td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/RAD8EJBWeb/theme/footer.jsp" target="ancestor"></siteedit:navbar></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>