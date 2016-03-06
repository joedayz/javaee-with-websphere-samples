//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package itso.rad8.bank.model.simple;

import java.math.BigDecimal;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "Bank", targetNamespace = "http://simple.model.bank.rad8.itso/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Bank {


    /**
     * 
     * @param ssn
     * @return
     *     returns java.lang.String
     * @throws CustomerDoesNotExistException_Exception
     */
    @WebMethod(operationName = "RetrieveCustomerName", action = "urn:getCustomerFullName")
    @WebResult(name = "CustomerFullName", targetNamespace = "")
    @RequestWrapper(localName = "RetrieveCustomerName", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.RetrieveCustomerName")
    @ResponseWrapper(localName = "RetrieveCustomerNameResponse", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.RetrieveCustomerNameResponse")
    @Action(input = "urn:getCustomerFullName", output = "http://simple.model.bank.rad8.itso/Bank/RetrieveCustomerNameResponse", fault = {
        @FaultAction(className = CustomerDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/RetrieveCustomerName/Fault/CustomerDoesNotExistException")
    })
    public String retrieveCustomerName(
        @WebParam(name = "ssn", targetNamespace = "")
        String ssn)
        throws CustomerDoesNotExistException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws CustomerDoesNotExistException_Exception
     * @throws AccountDoesNotExistException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNumAccounts", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetNumAccounts")
    @ResponseWrapper(localName = "getNumAccountsResponse", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetNumAccountsResponse")
    @Action(input = "http://simple.model.bank.rad8.itso/Bank/getNumAccountsRequest", output = "http://simple.model.bank.rad8.itso/Bank/getNumAccountsResponse", fault = {
        @FaultAction(className = CustomerDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/getNumAccounts/Fault/CustomerDoesNotExistException"),
        @FaultAction(className = AccountDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/getNumAccounts/Fault/AccountDoesNotExistException")
    })
    public int getNumAccounts(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws AccountDoesNotExistException_Exception, CustomerDoesNotExistException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns java.lang.String
     * @throws CustomerDoesNotExistException_Exception
     * @throws AccountDoesNotExistException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountId", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetAccountId")
    @ResponseWrapper(localName = "getAccountIdResponse", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetAccountIdResponse")
    @Action(input = "http://simple.model.bank.rad8.itso/Bank/getAccountIdRequest", output = "http://simple.model.bank.rad8.itso/Bank/getAccountIdResponse", fault = {
        @FaultAction(className = CustomerDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/getAccountId/Fault/CustomerDoesNotExistException"),
        @FaultAction(className = AccountDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/getAccountId/Fault/AccountDoesNotExistException")
    })
    public String getAccountId(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws AccountDoesNotExistException_Exception, CustomerDoesNotExistException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.math.BigDecimal
     * @throws AccountDoesNotExistException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountBalance", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetAccountBalance")
    @ResponseWrapper(localName = "getAccountBalanceResponse", targetNamespace = "http://simple.model.bank.rad8.itso/", className = "itso.rad8.bank.model.simple.GetAccountBalanceResponse")
    @Action(input = "http://simple.model.bank.rad8.itso/Bank/getAccountBalanceRequest", output = "http://simple.model.bank.rad8.itso/Bank/getAccountBalanceResponse", fault = {
        @FaultAction(className = AccountDoesNotExistException_Exception.class, value = "http://simple.model.bank.rad8.itso/Bank/getAccountBalance/Fault/AccountDoesNotExistException")
    })
    public BigDecimal getAccountBalance(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws AccountDoesNotExistException_Exception
    ;

}
