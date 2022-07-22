package com.nttdata.ofertassecundarias.model.util;

import com.nttdata.ofertassecundarias.common.exception.NotContentException;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTH;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTHResponse;
import com.nttdata.ofertassecundarias.model.dto.SecondaryOfferResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class SecondaryOfferUtil {
    public OperacionMTH requestClient(String dni){
        var request = new OperacionMTH();
        request.setDni(dni);
        return request;
    }
    public SecondaryOfferResponseDTO converterToResponseDTO(OperacionMTHResponse operacionMTHResponseService) {
        var operationMTH = new SecondaryOfferResponseDTO();
        if (operacionMTHResponseService.getOperacionMTHResult() != null) {
            if (operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferId() != null && operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferName() != null && operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferPrice() != null ) {
                operationMTH.setSecondaryOfferId(operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferId());
                operationMTH.setSecondaryOfferName(operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferName());
                operationMTH.setSecondaryOfferPrice(new BigInteger(operacionMTHResponseService.getOperacionMTHResult().getSecondaryOfferPrice()));
            } else {
                throw new NotContentException("No se encontraron resultados para tu busqueda");
            }
        } else {
            throw new NotContentException("No se encontraron resultados para tu busqueda");
        }
        return operationMTH;
    }
}
