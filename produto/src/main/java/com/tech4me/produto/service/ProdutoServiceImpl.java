package com.tech4me.produto.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.produto.repository.ProdutoRepository;
import com.tech4me.produto.shared.ProdutoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService  {

    @Autowired
    ProdutoRepository repositorioProduto;

    @Override
    public List<ProdutoDto> obterTodos() {
       
        List<Produto> produtos = repositorioProduto.findAll();

        ModelMapper mapper = new ModelMapper();

        return produtos.stream().map(produto -> mapper.
        map(produto, ProdutoDto.class)).
        collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String idProduto) {
        
        Optional<Produto> optionalProduto = repositorioProduto.findById(idProduto);

        if(optionalProduto.isEmpty()){
            throw new InputMismatchException ("Não foi possível encontrar o produto com esse id." + idProduto);
        }

        ProdutoDto produtoDto = new ModelMapper().map(optionalProduto.get(), ProdutoDto.class);

        return Optional.of(produtoDto);
        
    }

    @Override
    public ProdutoDto adicionar(ProdutoDto produtoDto) {
       
        ModelMapper mapper = new ModelMapper();

        Produto produto = mapper.map(produtoDto, Produto.class);

        produto.setId(null);

        produto = repositorioProduto.save(produto);

        return mapper.map(produto, ProdutoDto.class);
    }

    @Override
    public ProdutoDto atualizar(String id, ProdutoDto produtoDto) {
        
        produtoDto.setId(id);

        Produto produto = new ModelMapper().map(produtoDto, Produto.class);

        repositorioProduto.save(produto);
        return produtoDto; 
    }

    @Override
    public void deletar(String idProduto) {
       repositorioProduto.deleteById(idProduto);
        
    }

    @Override
    public ProdutoDto atualizandoValorDoProduto(String idProduto, Double valor) {
      Optional<Produto> optionalProduto = repositorioProduto.findById(idProduto);
        if(optionalProduto.isEmpty()){
            throw new InputMismatchException ("O produto mencionado não foi encontrado com o ID: " + idProduto + 
            "Tente novamente!");
        }
      
        return null;
    }
    
}
