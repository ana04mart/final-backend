package com.tech4me.vendams.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.vendams.shared.VendaDto;

public interface VendaService {
    
    List<VendaDto> obterTodos();

    Optional<VendaDto> obterPorId(String id);

    VendaDto adicionar(VendaDto vendaDto);

    VendaDto atualizar(String id, VendaDto vendaDto);

    void deletar(String id);

    VendaDto atualizandoLucroDiario(String id, @Valid Integer quantidadeComprada);

    List<VendaDto> obterProduto (String produto);
}
