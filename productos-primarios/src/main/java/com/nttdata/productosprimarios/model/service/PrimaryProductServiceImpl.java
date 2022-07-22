package com.nttdata.productosprimarios.model.service;

import com.nttdata.productosprimarios.model.dao.PrimaryProductDao;
import com.nttdata.productosprimarios.model.document.PrimaryProductDocument;
import com.nttdata.productosprimarios.model.dto.PrimaryProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PrimaryProductServiceImpl implements IPrimaryProductService {
    @Autowired
    private PrimaryProductDao dao;

    @Override
    public Mono<PrimaryProductDTO> findByProductPrimaryId(String productPrimaryId) {

        return dao.findByProductPrimaryId(productPrimaryId).map(p-> new PrimaryProductDTO(p.getProductPrimaryId()
                ,p.getProductPrimaryName(),p.getProductPrimaryPrice()));
    }
}
