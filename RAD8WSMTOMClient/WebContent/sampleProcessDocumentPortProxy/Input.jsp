<%@page contentType="text/html;charset=UTF-8"%>
<%!
private static final String ENVELOPE_TEMPLATE =
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
    "<soapenv:Header>\n" +
    "</soapenv:Header>\n" +
    "<soapenv:Body>\n\n" +
    "</soapenv:Body>\n" +
    "</soapenv:Envelope>";
%>
<%
boolean bypass = session.getAttribute("__bypass__") == null ? false : true;
request.setCharacterEncoding("UTF-8");
String methodName = request.getParameter("methodName");
if (methodName == null || methodName.trim().length() == 0) methodName = "Inputs";
%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
<LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
<script language="JavaScript">
function saveFullPath(fileInput, hiddenInput) {
    hiddenInput.value = fileInput.value;
}

function noBinding() {
    var doc  = window.parent.frames["config"].document;
    var form = doc.getElementById("configForm");
    form.bypass.click();
}

function triggerSoapAction() {
    var chk = document.getElementById("__use_soapaction__");
    var txt = document.getElementById("__soapaction__");
    txt.disabled = !chk.checked;
}
</script>
</HEAD>
<BODY>
<TABLE class="heading" width="100%">
<TR><TD><%= org.eclipse.jst.ws.util.JspUtils.markup(methodName) %></TD></TR>
</TABLE>
<BR/>
<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="arg05null" value="arg05null"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">arg0:</TD>
<TD ALIGN="left">
Please provide a local file path that contains data to include in Web service request:<br/>
<INPUT TYPE="TEXT" NAME="arg05" SIZE="70"/>
</TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 7:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="arg010null" value="arg010null"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">arg0:</TD>
<TD ALIGN="left">
Please provide a local file path that contains data to include in Web service request:<br/>
<INPUT TYPE="TEXT" NAME="arg010" SIZE="70"/>
</TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 12:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="arg015null" value="arg015null"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">arg0:</TD>
<TD ALIGN="left">
Please provide a local file path that contains data to include in Web service request:<br/>
<INPUT TYPE="TEXT" NAME="arg015" SIZE="70"/>
</TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
}
if (valid) {
%>
Select a method to test
<%
}
%>

</BODY>
</HTML>
