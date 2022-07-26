
package com.nttdata.ofertassecundarias.model.client.dto;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MTH", targetNamespace = "http://tempuri.org/", wsdlLocation = "/wsdl/MyService.wsdl")
public class MTH
    extends Service
{

    private final static URL MTH_WSDL_LOCATION;
    private final static WebServiceException MTH_EXCEPTION;
    private final static QName MTH_QNAME = new QName("http://tempuri.org/", "MTH");

    static {
        MTH_WSDL_LOCATION = MTH.class.getResource("/wsdl/MyService.wsdl");
        WebServiceException e = null;
        if (MTH_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find '/wsdl/MyService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        MTH_EXCEPTION = e;
    }

    public MTH() {
        super(__getWsdlLocation(), MTH_QNAME);
    }

    public MTH(WebServiceFeature... features) {
        super(__getWsdlLocation(), MTH_QNAME, features);
    }

    public MTH(URL wsdlLocation) {
        super(wsdlLocation, MTH_QNAME);
    }

    public MTH(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MTH_QNAME, features);
    }

    public MTH(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MTH(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MTHSoap
     */
    @WebEndpoint(name = "MTHSoap")
    public MTHSoap getMTHSoap() {
        return super.getPort(new QName("http://tempuri.org/", "MTHSoap"), MTHSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTHSoap
     */
    @WebEndpoint(name = "MTHSoap")
    public MTHSoap getMTHSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MTHSoap"), MTHSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns MTHSoap
     */
    @WebEndpoint(name = "MTHSoap12")
    public MTHSoap getMTHSoap12() {
        return super.getPort(new QName("http://tempuri.org/", "MTHSoap12"), MTHSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTHSoap
     */
    @WebEndpoint(name = "MTHSoap12")
    public MTHSoap getMTHSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MTHSoap12"), MTHSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns MTHHttpGet
     */
    @WebEndpoint(name = "MTHHttpGet")
    public MTHHttpGet getMTHHttpGet() {
        return super.getPort(new QName("http://tempuri.org/", "MTHHttpGet"), MTHHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTHHttpGet
     */
    @WebEndpoint(name = "MTHHttpGet")
    public MTHHttpGet getMTHHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MTHHttpGet"), MTHHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns MTHHttpPost
     */
    @WebEndpoint(name = "MTHHttpPost")
    public MTHHttpPost getMTHHttpPost() {
        return super.getPort(new QName("http://tempuri.org/", "MTHHttpPost"), MTHHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTHHttpPost
     */
    @WebEndpoint(name = "MTHHttpPost")
    public MTHHttpPost getMTHHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MTHHttpPost"), MTHHttpPost.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MTH_EXCEPTION!= null) {
            throw MTH_EXCEPTION;
        }
        return MTH_WSDL_LOCATION;
    }

}
