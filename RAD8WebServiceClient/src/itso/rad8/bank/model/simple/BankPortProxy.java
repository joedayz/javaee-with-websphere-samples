package itso.rad8.bank.model.simple;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.math.BigDecimal;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

public class BankPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private itso.rad8.bank.model.simple.BankService _service = null;
        private itso.rad8.bank.model.simple.Bank _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new itso.rad8.bank.model.simple.BankService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (itso.rad8.bank.model.simple.BankService)ctx.lookup("java:comp/env/service/BankService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new itso.rad8.bank.model.simple.BankService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getBankPort();
        }

        public itso.rad8.bank.model.simple.Bank getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "BankPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public BankPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public BankPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public String retrieveCustomerName(String ssn) throws CustomerDoesNotExistException_Exception {
        return _getDescriptor().getProxy().retrieveCustomerName(ssn);
    }

    public int getNumAccounts(String arg0) throws AccountDoesNotExistException_Exception, CustomerDoesNotExistException_Exception {
        return _getDescriptor().getProxy().getNumAccounts(arg0);
    }

    public String getAccountId(String arg0, int arg1) throws AccountDoesNotExistException_Exception, CustomerDoesNotExistException_Exception {
        return _getDescriptor().getProxy().getAccountId(arg0,arg1);
    }

    public BigDecimal getAccountBalance(String arg0) throws AccountDoesNotExistException_Exception {
        return _getDescriptor().getProxy().getAccountBalance(arg0);
    }

}