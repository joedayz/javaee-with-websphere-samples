<%@page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="sampleProcessDocumentPortProxyid" scope="session" class="com.ibm.rad8.mtom.ProcessDocumentPortProxy"/>
<HTML>
<HEAD>
<TITLE>Methods</TITLE>
<LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
<script language="JavaScript">
function selectAll() {
var form = document.getElementById("pendingForm");
var pending = form.elements["key"];
if (isNaN(pending.length))
pending.checked = true;
else {
var i;
for (i = 0; i < pending.length; i++)
pending[i].checked = true;
}
}
</script>
</HEAD>
<BODY>
<TABLE class="heading" width="100%">
<TR><TD>Methods</TD></TR>
</TABLE>
<UL>
<LI><A HREF="Input.jsp?method=2&methodName=sendWordFile" TARGET="inputs">sendWordFile(byte[])</A></LI>
<LI><A HREF="Input.jsp?method=7&methodName=sendImage" TARGET="inputs">sendImage(java.awt.Image)</A></LI>
<LI><A HREF="Input.jsp?method=12&methodName=sendPDFFile" TARGET="inputs">sendPDFFile(javax.activation.DataHandler)</A></LI>
</UL>
<%
if (com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.hasAsync(sampleProcessDocumentPortProxyid.getClass())) {
%>
<FORM id="pendingForm" method="GET" action="Method.jsp">
<TABLE class="heading" width="100%">
<TR><TD>Pending Methods</TD></TR>
</TABLE>
<BR/>
<%
String[] deleteKeys = request.getParameterValues("key");
if (deleteKeys != null) {
for (int i = 0; i < deleteKeys.length; i++)
com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.removeResponse(session, deleteKeys[i]);
}
synchronized(session) {
java.util.Iterator iter = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getIterator(session);
if (iter != null) {
%>
<TABLE cellspacing="1">
<%
while (iter.hasNext()) {
java.util.Map.Entry entry = (java.util.Map.Entry) iter.next();
com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.ResponseHolder holder =
(com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.ResponseHolder) entry.getValue();
%>
<TR>
<TD valign="top"><INPUT type="checkbox" name="key" value="<%= entry.getKey() %>"/></TD>
<TD><A href="Result.jsp?method=<%= holder.methodID %>&key=<%= entry.getKey() %>" target="result"><%= entry.getKey() %></A></TD>
</TR>
<%
}
%>
</TABLE>
<%
}
}
if (com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getSize(session) > 0) { %>
<BR/>
<INPUT CLASS="wide" TYPE="BUTTON" VALUE="Select All" onclick="javascript:selectAll();"/>
<INPUT CLASS="wide" TYPE="SUBMIT" VALUE="Discard selected methods"/>
<% } else { %>
<INPUT CLASS="wide" TYPE="SUBMIT" VALUE="Discard selected methods" disabled/>
<% } %>
</FORM>
<%
}
%>
</BODY>
</HTML>
