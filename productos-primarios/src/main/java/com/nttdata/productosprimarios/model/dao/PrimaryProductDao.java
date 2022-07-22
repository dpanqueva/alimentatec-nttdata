package com.nttdata.productosprimarios.model.dao;

import com.nttdata.productosprimarios.model.document.PrimaryProductDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PrimaryProductDao extends ReactiveMongoRepository<PrimaryProductDocument, String> {
    Mono<PrimaryProductDocument> findByProductPrimaryId(String dni);
}
