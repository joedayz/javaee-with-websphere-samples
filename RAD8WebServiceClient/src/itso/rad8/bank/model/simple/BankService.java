//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package itso.rad8.bank.model.simple;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "BankService", targetNamespace = "http://simple.model.bank.rad8.itso/", wsdlLocation = "WEB-INF/wsdl/BankService.wsdl")
public class BankService
    extends Service
{

    private final static URL BANKSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKSERVICE_EXCEPTION;
    private final static QName BANKSERVICE_QNAME = new QName("http://simple.model.bank.rad8.itso/", "BankService");

    static {
            BANKSERVICE_WSDL_LOCATION = itso.rad8.bank.model.simple.BankService.class.getResource("/WEB-INF/wsdl/BankService.wsdl");
        WebServiceException e = null;
        if (BANKSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/BankService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        BANKSERVICE_EXCEPTION = e;
    }

    public BankService() {
        super(__getWsdlLocation(), BANKSERVICE_QNAME);
    }

    public BankService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKSERVICE_QNAME, features);
    }

    public BankService(URL wsdlLocation) {
        super(wsdlLocation, BANKSERVICE_QNAME);
    }

    public BankService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKSERVICE_QNAME, features);
    }

    public BankService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Bank
     */
    @WebEndpoint(name = "BankPort")
    public Bank getBankPort() {
        return super.getPort(new QName("http://simple.model.bank.rad8.itso/", "BankPort"), Bank.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Bank
     */
    @WebEndpoint(name = "BankPort")
    public Bank getBankPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://simple.model.bank.rad8.itso/", "BankPort"), Bank.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKSERVICE_EXCEPTION!= null) {
            throw BANKSERVICE_EXCEPTION;
        }
        return BANKSERVICE_WSDL_LOCATION;
    }

}
