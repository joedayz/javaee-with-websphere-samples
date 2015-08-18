<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="sitenav" type="com.ibm.etools.siteedit.sitelib.core.SiteNavBean" scope="request"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>footer.html</title>
</head>
<body>
<table class="footer" cellspacing="0" cellpadding="0" width="100%" border="0">
   <tbody>
      <tr>
		 <td width="5"><img src="c.gif" width="5" height="1" border="0" alt=""></td>
         <td>
         <table border="0" cellspacing="0" cellpadding="2">
            <tbody>
               <tr>
<c:forEach var="item" items="${sitenav.items}">
 <c:choose>
  <c:when test="${item.self}">
                  <td class="nav-f-highlighted"><c:out value='${item.label}' escapeXml='false'/></td>
  </c:when>
  <c:when test="${item.group}">
                  <td class="nav-f-group"><b><c:out value='${item.label}' escapeXml='false'/>:</b></td>
  </c:when>
  <c:otherwise>
                  <td class="nav-f-normal"><c:out value='<a href="${item.href}">${item.label}</a>' escapeXml='false'/></td>
  </c:otherwise>
 </c:choose>
</c:forEach>
               </tr>
            </tbody>
         </table>
         </td>
         <td width="5"><img src="c.gif" width="5" height="1" border="0" alt=""></td>
      </tr>
   </tbody>
</table>
</body>
</html>
