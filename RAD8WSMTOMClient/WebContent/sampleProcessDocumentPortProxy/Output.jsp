<%
Object obj = com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.getResult(session, request.getParameter("key"));
if (obj instanceof byte[]) {
    response.getOutputStream().write((byte[]) obj);
}
else if (obj instanceof java.awt.Image) {
    response.setContentType("image/jpeg");
    javax.imageio.ImageIO.write((java.awt.image.RenderedImage) obj, "jpeg", response.getOutputStream());
}
else if (obj instanceof javax.activation.DataHandler) {
    javax.activation.DataHandler handler = (javax.activation.DataHandler) obj;
    response.setContentType(handler.getContentType());
    handler.writeTo(response.getOutputStream());
}
else {
    %>
    <HTML>
    <HEAD>
    <LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
    </HEAD>
    <BODY>
    Output type is not recognized.
    </BODY>
    </HTML>
    <%
}
%>