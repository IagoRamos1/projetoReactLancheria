package com.lancheria.lancheria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancheria.lancheria.entities.Endereco;
import com.lancheria.lancheria.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastroEndereco")
    public List<Endereco> cadastroEndereco(Endereco endereco) {
        return enderecoService.cadastroEndereco(endereco);
    }

    @GetMapping("/buscaEndereco")
    public Endereco buscaEndereco(@RequestParam(value = "id") Integer id) {
        return enderecoService.buscaEndereco(id);
    }

    @GetMapping("/listarEndereco")
    public List<Endereco> listaEnderecos() {
        return enderecoService.listaEnderecos();
    }

    @DeleteMapping("/delete")
    public List<Endereco> deleteEndereco(@RequestParam(value = "id") Integer id) {
        return enderecoService.deletaEndereco(id);
    }
}
