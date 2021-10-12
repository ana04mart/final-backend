package com.tech4me.vendams.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.vendams.model.Venda;
import com.tech4me.vendams.repository.VendaRepository;

import com.tech4me.vendams.shared.VendaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService{

    @Autowired
    VendaRepository repositorioVenda;

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repositorioVenda.findAll();

        ModelMapper mapper = new ModelMapper();

        return vendas.stream().map(venda -> mapper.map(venda, VendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> optionalVenda = repositorioVenda.findById(id);

        if(optionalVenda.isEmpty()){
            throw new InputMismatchException("Não foi possível encontrar a venda com esse id:" + id);
        }

        VendaDto vendaDto = new ModelMapper().map(optionalVenda.get(), VendaDto.class);
        
        return Optional.of(vendaDto);
    }

    @Override
    public VendaDto adicionar(VendaDto vendaDto) {
        ModelMapper mapper = new ModelMapper();

        Venda venda = mapper.map(vendaDto, Venda.class);

        venda.setId(null);

        venda = repositorioVenda.save(venda);

        return mapper.map(venda, VendaDto.class);    
    }

    @Override
    public VendaDto atualizar(String id, VendaDto vendaDto) {
        vendaDto.setId(id);

        Venda venda = new ModelMapper().map(vendaDto, Venda.class);

        repositorioVenda.save(venda);

        return vendaDto;
    }

    @Override
    public void deletar(String id) {
        repositorioVenda.deleteById(id);
        
    }

    @Override
    public VendaDto atualizandoLucroDiario(String id, Integer quantidadeComprada) {
        Optional<Venda> venda = repositorioVenda.findById(id);

        if(venda.isEmpty()){
            throw new InputMismatchException ("A venda mencionada não foi encontrada com o ID: " + id + 
            "Tente novamente!");
        }

        venda.get().setValorParaPagar(venda.get().getValorParaPagar() * quantidadeComprada);

        repositorioVenda.save(venda.get());

        VendaDto vendaDto = new ModelMapper().map(venda.get(), VendaDto.class);
        return vendaDto;
    }

    @Override
    public List<VendaDto> obterProduto(String produto) {
        List<Venda> vendas = repositorioVenda.findByProdutoVendido(produto);
        return vendas.stream().map(venda -> new ModelMapper().
        map(venda, VendaDto.class))
        .collect(Collectors.toList());
    }
    
}
