package com.nttdata.ofertassecundarias.model.client.ws;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTH;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTHResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXB;
import java.io.StringWriter;

@Component
@Slf4j
public class SecondaryOfferClient extends WebServiceGatewaySupport {

    @Value("${url.balance.transfer}")
    private String endpoint;

    @SneakyThrows
    public OperacionMTHResponse operationMTH(OperacionMTH request) {
        OperacionMTHResponse value = null;
        try {
            Object obj = getWebServiceTemplate().marshalSendAndReceive(endpoint, request, new SoapActionCallback("OperacionMTH"));
            StringWriter sw = new StringWriter();
            JAXB.marshal(obj, sw);
            String xmlString = sw.toString();
            XmlMapper xmlMapper = new XmlMapper();
            AnnotationIntrospector aiJaxb = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
            xmlMapper.setAnnotationIntrospector(aiJaxb);
            value = xmlMapper.readValue(xmlString, OperacionMTHResponse.class);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }
        return value;

    }
}
