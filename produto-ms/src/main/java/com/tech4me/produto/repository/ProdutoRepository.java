package com.tech4me.produto.repository;

import com.tech4me.produto.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository <Produto, String> {
    
}
