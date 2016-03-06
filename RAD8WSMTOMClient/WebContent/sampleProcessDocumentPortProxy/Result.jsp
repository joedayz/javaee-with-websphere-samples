<%@page contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.init(session);

boolean async       = session.getAttribute("__async__") == null ? false : true;
String methodKey    = request.getParameter("key");
String resultSuffix = methodKey != null && methodKey.length() > 0 ? " - " + methodKey : "";
%>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
<LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
<script language="JavaScript">

function reloadMethods() {
    window.parent.frames["methods"].location.reload(true);
}
</script>
</HEAD>
<BODY>
<TABLE class="heading" width="100%">
<TR><TD>Result<%= org.eclipse.jst.ws.util.JspUtils.markup(resultSuffix) %></TD></TR>
</TABLE>
<P>
<jsp:useBean id="sampleProcessDocumentPortProxyid" scope="session" class="com.ibm.rad8.mtom.ProcessDocumentPortProxy" />

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

boolean isDone = true;
try {
    String sourceInTemp = request.getParameter("__rawxml__");
        javax.xml.transform.Source sourceIn  = sourceInTemp != null ?
            new javax.xml.transform.stream.StreamSource(new java.io.ByteArrayInputStream(sourceInTemp.getBytes())) : null;
    javax.xml.transform.Source sourceOut = null;

    boolean bypass = (sourceIn != null);

switch (methodID){ 
case 2:
    gotMethod = true;
    byte[] returnp3mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof byte[])
                    returnp3mtemp = (byte[]) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleProcessDocumentPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        String arg0_0id=  request.getParameter("arg05");
        String arg05null = request.getParameter("arg05null");
        byte[] arg0_0idTemp;
        if (arg05null != null)
            arg0_0idTemp = null;
        else {
        javax.activation.DataHandler
         arg0_0idTemp_t  = new javax.activation.DataHandler(new javax.activation.FileDataSource(arg0_0id));
        java.io.ByteArrayOutputStream arg0_0idTemp_o = new java.io.ByteArrayOutputStream();
        arg0_0idTemp_t.writeTo(arg0_0idTemp_o);
         arg0_0idTemp = arg0_0idTemp_o.toByteArray();
        arg0_0idTemp_o.close();
        }

        if (!async) {
        try {
            returnp3mtemp = sampleProcessDocumentPortProxyid.sendWordFile(arg0_0idTemp);
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp3mtemp == null) {
%>
    null
<%
} else {
        com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.putResult(session, "returnp3mtemp", returnp3mtemp);
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(returnp3mtemp.toString());
        %>
        <%= tempResultreturnp3 %>
        <%
        %>
        <br/>
        <br/>
        [ <a href="Output.jsp?key=returnp3mtemp">Retrieve contents</a> ]
        <%
}
%>
<HR/><BR/>
<%
}
break;
case 7:
    gotMethod = true;
    java.awt.Image returnp8mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof java.awt.Image)
                    returnp8mtemp = (java.awt.Image) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleProcessDocumentPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        String arg0_2id=  request.getParameter("arg010");
        String arg010null = request.getParameter("arg010null");
        java.awt.Image arg0_2idTemp;
        if (arg010null != null)
            arg0_2idTemp = null;
        else {
         arg0_2idTemp  = javax.imageio.ImageIO.read(new java.io.File(arg0_2id));
        }

        if (!async) {
        try {
            returnp8mtemp = sampleProcessDocumentPortProxyid.sendImage(arg0_2idTemp);
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp8mtemp == null) {
%>
    null
<%
} else {
        com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.putResult(session, "returnp8mtemp", returnp8mtemp);
        String tempResultreturnp8 = org.eclipse.jst.ws.util.JspUtils.markup(returnp8mtemp.toString());
        %>
        <%= tempResultreturnp8 %>
        <%
        %>
        <br/>
        <br/>
        [ <a href="Output.jsp?key=returnp8mtemp">View image</a> ]
        <%
}
%>
<HR/><BR/>
<%
}
break;
case 12:
    gotMethod = true;
    javax.activation.DataHandler returnp13mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof javax.activation.DataHandler)
                    returnp13mtemp = (javax.activation.DataHandler) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleProcessDocumentPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        String arg0_4id=  request.getParameter("arg015");
        String arg015null = request.getParameter("arg015null");
        javax.activation.DataHandler arg0_4idTemp;
        if (arg015null != null)
            arg0_4idTemp = null;
        else {
         arg0_4idTemp  = new javax.activation.DataHandler(new javax.activation.FileDataSource(arg0_4id));
        }

        if (!async) {
        try {
            returnp13mtemp = sampleProcessDocumentPortProxyid.sendPDFFile(arg0_4idTemp);
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp13mtemp == null) {
%>
    null
<%
} else {
        com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.putResult(session, "returnp13mtemp", returnp13mtemp);
        String tempResultreturnp13 = org.eclipse.jst.ws.util.JspUtils.markup(returnp13mtemp.toString());
        %>
        <%= tempResultreturnp13 %>
        <%
        String tempResultreturnp13_ContentType = org.eclipse.jst.ws.util.JspUtils.markup(returnp13mtemp.getContentType());
        %>
        <br/><%= tempResultreturnp13_ContentType %>
        <%
        %>
        <br/>
        <br/>
        [ <a href="Output.jsp?key=returnp13mtemp">Retrieve contents</a> ]
        <%
}
%>
<HR/><BR/>
<%
}
break;
}
} catch (Exception e) { 
%>
exception: <%=org.eclipse.jst.ws.util.JspUtils.markup(e.toString())%>
<%
return;
}
if(!gotMethod){
%>
Result: N/A
<%
} else if (!isDone) {
%>
No results available yet.
<%
} else if (async && methodKey == null) {
%>
The service has been invoked.
<script language="JavaScript">reloadMethods();</script>
<%
}
%>
</BODY>
</HTML>