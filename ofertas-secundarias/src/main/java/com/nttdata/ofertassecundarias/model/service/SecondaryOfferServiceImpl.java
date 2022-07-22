package com.nttdata.ofertassecundarias.model.service;

import com.nttdata.ofertassecundarias.common.exception.NotContentException;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTH;
import com.nttdata.ofertassecundarias.model.client.dto.OperacionMTHResponse;
import com.nttdata.ofertassecundarias.model.client.ws.SecondaryOfferClient;
import com.nttdata.ofertassecundarias.model.dto.SecondaryOfferResponseDTO;
import com.nttdata.ofertassecundarias.model.util.SecondaryOfferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondaryOfferServiceImpl implements ISecondaryOfferService {

    @Autowired
    private SecondaryOfferUtil util;

    @Autowired
    private SecondaryOfferClient client;
    @Override
    public SecondaryOfferResponseDTO findAll(String dni) {
        OperacionMTH request = util.requestClient(dni);
        OperacionMTHResponse response = client.operationMTH(request);
        if (response==null) {
            throw new NotContentException("No se encontraron resultados para tu busqueda");
        }
        return util.converterToResponseDTO(response);
    }
}
