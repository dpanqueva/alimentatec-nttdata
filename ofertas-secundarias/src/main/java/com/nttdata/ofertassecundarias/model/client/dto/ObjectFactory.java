
package com.nttdata.ofertassecundarias.model.client.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nttdata.ofertassecundarias.model.dto.client package. 
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

    private final static QName _MTHResponse_QNAME = new QName("http://tempuri.org/", "MTHResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nttdata.ofertassecundarias.model.dto.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotificaConsultaSMS }
     * 
     */
    public NotificaConsultaSMS createNotificaConsultaSMS() {
        return new NotificaConsultaSMS();
    }

    /**
     * Create an instance of {@link NotificaConsultaSMSResponse }
     * 
     */
    public NotificaConsultaSMSResponse createNotificaConsultaSMSResponse() {
        return new NotificaConsultaSMSResponse();
    }

    /**
     * Create an instance of {@link EnvioSMS }
     * 
     */
    public EnvioSMS createEnvioSMS() {
        return new EnvioSMS();
    }

    /**
     * Create an instance of {@link EnvioSMSResponse }
     * 
     */
    public EnvioSMSResponse createEnvioSMSResponse() {
        return new EnvioSMSResponse();
    }

    /**
     * Create an instance of {@link OperacionMTH }
     * 
     */
    public OperacionMTH createOperacionMTH() {
        return new OperacionMTH();
    }

    /**
     * Create an instance of {@link OperacionMTHResponse }
     * 
     */
    public OperacionMTHResponse createOperacionMTHResponse() {
        return new OperacionMTHResponse();
    }

    /**
     * Create an instance of {@link MTHResponse }
     * 
     */
    public MTHResponse createMTHResponse() {
        return new MTHResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MTHResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MTHResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MTHResponse")
    public JAXBElement<MTHResponse> createMTHResponse(MTHResponse value) {
        return new JAXBElement<MTHResponse>(_MTHResponse_QNAME, MTHResponse.class, null, value);
    }

}
