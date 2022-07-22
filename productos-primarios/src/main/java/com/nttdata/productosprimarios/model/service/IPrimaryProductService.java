package com.nttdata.productosprimarios.model.service;

import com.nttdata.productosprimarios.model.dto.PrimaryProductDTO;
import reactor.core.publisher.Mono;

public interface IPrimaryProductService {
    Mono<PrimaryProductDTO> findByProductPrimaryId(String productPrimaryId);
}
