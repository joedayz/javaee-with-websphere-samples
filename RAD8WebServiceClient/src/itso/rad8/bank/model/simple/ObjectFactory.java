//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package itso.rad8.bank.model.simple;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itso.rad8.bank.model.simple package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAccountId_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getAccountId");
    private final static QName _GetAccountIdResponse_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getAccountIdResponse");
    private final static QName _CustomerDoesNotExistException_QNAME = new QName("http://simple.model.bank.rad8.itso/", "CustomerDoesNotExistException");
    private final static QName _AccountDoesNotExistException_QNAME = new QName("http://simple.model.bank.rad8.itso/", "AccountDoesNotExistException");
    private final static QName _RetrieveCustomerName_QNAME = new QName("http://simple.model.bank.rad8.itso/", "RetrieveCustomerName");
    private final static QName _GetAccountBalance_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getAccountBalance");
    private final static QName _RetrieveCustomerNameResponse_QNAME = new QName("http://simple.model.bank.rad8.itso/", "RetrieveCustomerNameResponse");
    private final static QName _GetAccountBalanceResponse_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getAccountBalanceResponse");
    private final static QName _GetNumAccounts_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getNumAccounts");
    private final static QName _GetNumAccountsResponse_QNAME = new QName("http://simple.model.bank.rad8.itso/", "getNumAccountsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itso.rad8.bank.model.simple
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAccountId }
     * 
     */
    public GetAccountId createGetAccountId() {
        return new GetAccountId();
    }

    /**
     * Create an instance of {@link GetAccountIdResponse }
     * 
     */
    public GetAccountIdResponse createGetAccountIdResponse() {
        return new GetAccountIdResponse();
    }

    /**
     * Create an instance of {@link CustomerDoesNotExistException }
     * 
     */
    public CustomerDoesNotExistException createCustomerDoesNotExistException() {
        return new CustomerDoesNotExistException();
    }

    /**
     * Create an instance of {@link GetAccountBalance }
     * 
     */
    public GetAccountBalance createGetAccountBalance() {
        return new GetAccountBalance();
    }

    /**
     * Create an instance of {@link RetrieveCustomerName }
     * 
     */
    public RetrieveCustomerName createRetrieveCustomerName() {
        return new RetrieveCustomerName();
    }

    /**
     * Create an instance of {@link AccountDoesNotExistException }
     * 
     */
    public AccountDoesNotExistException createAccountDoesNotExistException() {
        return new AccountDoesNotExistException();
    }

    /**
     * Create an instance of {@link GetNumAccounts }
     * 
     */
    public GetNumAccounts createGetNumAccounts() {
        return new GetNumAccounts();
    }

    /**
     * Create an instance of {@link GetAccountBalanceResponse }
     * 
     */
    public GetAccountBalanceResponse createGetAccountBalanceResponse() {
        return new GetAccountBalanceResponse();
    }

    /**
     * Create an instance of {@link RetrieveCustomerNameResponse }
     * 
     */
    public RetrieveCustomerNameResponse createRetrieveCustomerNameResponse() {
        return new RetrieveCustomerNameResponse();
    }

    /**
     * Create an instance of {@link GetNumAccountsResponse }
     * 
     */
    public GetNumAccountsResponse createGetNumAccountsResponse() {
        return new GetNumAccountsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getAccountId")
    public JAXBElement<GetAccountId> createGetAccountId(GetAccountId value) {
        return new JAXBElement<GetAccountId>(_GetAccountId_QNAME, GetAccountId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getAccountIdResponse")
    public JAXBElement<GetAccountIdResponse> createGetAccountIdResponse(GetAccountIdResponse value) {
        return new JAXBElement<GetAccountIdResponse>(_GetAccountIdResponse_QNAME, GetAccountIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "CustomerDoesNotExistException")
    public JAXBElement<CustomerDoesNotExistException> createCustomerDoesNotExistException(CustomerDoesNotExistException value) {
        return new JAXBElement<CustomerDoesNotExistException>(_CustomerDoesNotExistException_QNAME, CustomerDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "AccountDoesNotExistException")
    public JAXBElement<AccountDoesNotExistException> createAccountDoesNotExistException(AccountDoesNotExistException value) {
        return new JAXBElement<AccountDoesNotExistException>(_AccountDoesNotExistException_QNAME, AccountDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "RetrieveCustomerName")
    public JAXBElement<RetrieveCustomerName> createRetrieveCustomerName(RetrieveCustomerName value) {
        return new JAXBElement<RetrieveCustomerName>(_RetrieveCustomerName_QNAME, RetrieveCustomerName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getAccountBalance")
    public JAXBElement<GetAccountBalance> createGetAccountBalance(GetAccountBalance value) {
        return new JAXBElement<GetAccountBalance>(_GetAccountBalance_QNAME, GetAccountBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "RetrieveCustomerNameResponse")
    public JAXBElement<RetrieveCustomerNameResponse> createRetrieveCustomerNameResponse(RetrieveCustomerNameResponse value) {
        return new JAXBElement<RetrieveCustomerNameResponse>(_RetrieveCustomerNameResponse_QNAME, RetrieveCustomerNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getAccountBalanceResponse")
    public JAXBElement<GetAccountBalanceResponse> createGetAccountBalanceResponse(GetAccountBalanceResponse value) {
        return new JAXBElement<GetAccountBalanceResponse>(_GetAccountBalanceResponse_QNAME, GetAccountBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getNumAccounts")
    public JAXBElement<GetNumAccounts> createGetNumAccounts(GetNumAccounts value) {
        return new JAXBElement<GetNumAccounts>(_GetNumAccounts_QNAME, GetNumAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumAccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://simple.model.bank.rad8.itso/", name = "getNumAccountsResponse")
    public JAXBElement<GetNumAccountsResponse> createGetNumAccountsResponse(GetNumAccountsResponse value) {
        return new JAXBElement<GetNumAccountsResponse>(_GetNumAccountsResponse_QNAME, GetNumAccountsResponse.class, null, value);
    }

}
