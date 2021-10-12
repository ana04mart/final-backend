package com.tech4me.produto.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.produto.service.ProdutoService;
import com.tech4me.produto.shared.ProdutoDto;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jogos")
public class ProdutoController {
    
    @Autowired
    ProdutoService servicoProduto;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> obterTodos(){
        List<ProdutoDto> produtos = servicoProduto.obterTodos();

      return new ResponseEntity<>(produtos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoDto>> obterPorId(@PathVariable String id){
        Optional<ProdutoDto> produto = servicoProduto.obterPorId(id);

        return new ResponseEntity<> (produto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> adicionar(@RequestBody @Valid ProdutoDto produtoDto){
        produtoDto = servicoProduto.adicionar(produtoDto);

        return new ResponseEntity<>(produtoDto, HttpStatus.CREATED);
    }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoProduto.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable String id, @RequestBody @Valid ProdutoDto produtoDto){
        ProdutoDto dto = servicoProduto.atualizar(id, produtoDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> correcao(@PathVariable String id) {
        
        if(servicoProduto.)
    }

}
