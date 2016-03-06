//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package itso.rad8.bank.model.simple;

import javax.xml.ws.WebFault;

@WebFault(name = "CustomerDoesNotExistException", targetNamespace = "http://simple.model.bank.rad8.itso/")
public class CustomerDoesNotExistException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CustomerDoesNotExistException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CustomerDoesNotExistException_Exception(String message, CustomerDoesNotExistException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public CustomerDoesNotExistException_Exception(String message, CustomerDoesNotExistException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: itso.rad8.bank.model.simple.CustomerDoesNotExistException
     */
    public CustomerDoesNotExistException getFaultInfo() {
        return faultInfo;
    }

}