package com.tech4me.vendams.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.vendams.service.VendaService;
import com.tech4me.vendams.shared.VendaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    
    @Autowired
    VendaService servicoVenda;
  

    @GetMapping
    public ResponseEntity<List<VendaDto>> obterTodos(){
        List<VendaDto> vendas = servicoVenda.obterTodos();

        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VendaDto>> obterPorId(@PathVariable String id){
        Optional<VendaDto> venda = servicoVenda.obterPorId(id);

        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @GetMapping("/{produto}/lista")
    public ResponseEntity<List<VendaDto>> obterProduto (@PathVariable String produto){
        List <VendaDto> dto = servicoVenda.obterProduto(produto);

        if(dto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendaDto> adicionar(@RequestBody @Valid VendaDto vendaDto){
        vendaDto = servicoVenda.adicionar(vendaDto);

        return new ResponseEntity<>(vendaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoVenda.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDto> atualizar(@PathVariable String id, @RequestBody @Valid VendaDto vendaDto) {
      
        VendaDto dto = servicoVenda.atualizar(id, vendaDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    
    @PatchMapping("/{id}")
    public ResponseEntity<VendaDto> atualizandoLucroDiario(@PathVariable String id, @Valid @PathVariable Integer quantidadeComprada){
     
        VendaDto produtoAtualizado = servicoVenda.atualizandoLucroDiario(id, quantidadeComprada);
       return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

}
