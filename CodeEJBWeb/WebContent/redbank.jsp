
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://www.ibm.com/siteedit/sitelib" prefix="siteedit" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/gray.css" type="text/css">

<title>RedBank</title>
</head>
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
         <td valign="top">
         <TABLE width="700" height="178" cellspacing="0" cellpadding="0"
						border="0">
						<!-- flm:table -->
						<TBODY>
							<TR>
								<TD height="31" width="55"></TD>
								<TD width="700"></TD>
							</TR>
							<TR>
								<TD height="117"></TD>
								<!-- flm:cell -->
								<TD valign="top">
									<FORM action="ListAccounts" method ="post">Please enter your customer ID (SSN):<BR>
									<INPUT type="text" name="customerNumber" size="20">
									<BR>
									<BR>
									<INPUT type="submit" name="ListAccounts" value="Submit">
									</FORM>
								</TD>
							</TR>
							<TR>
								<TD height="30"></TD>
								<TD></TD>
							</TR>
						</TBODY>
					</TABLE>
         </td>
      </tr>
      <tr>
         <td valign="top"><siteedit:navbar spec="/CodeEJBWeb/theme/footer.jsp" target="ancestor"></siteedit:navbar></td>
      </tr>
   </tbody>
</table>
</body>
</html>