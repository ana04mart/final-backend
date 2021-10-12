package com.tech4me.vendams.http;

import java.util.List;

import com.tech4me.vendams.shared.ProdutoDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "produtos-ms")
public interface ProdutosFeignClient {
        
    @GetMapping(path = "/api/produtos/{idProduto}/lista")

    List<ProdutoDto> obterProdutoDtos (@PathVariable String idProduto);
}
