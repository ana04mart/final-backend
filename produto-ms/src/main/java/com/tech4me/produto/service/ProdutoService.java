package com.tech4me.produto.service;

import java.util.List;
import java.util.Optional;


import com.tech4me.produto.shared.ProdutoDto;

public interface ProdutoService {
   
    List<ProdutoDto> obterTodos();

    Optional<ProdutoDto> obterPorId(String idProduto);

    ProdutoDto adicionar(ProdutoDto produtoDto);

    ProdutoDto atualizar(String id, ProdutoDto produtoDto);

    void deletar(String idProduto);

   ProdutoDto atualizandoValorDoProduto(String id, double valorAtual);
}
