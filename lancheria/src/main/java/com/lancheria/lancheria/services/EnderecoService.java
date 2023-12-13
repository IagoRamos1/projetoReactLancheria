package com.lancheria.lancheria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancheria.lancheria.entities.Endereco;
import com.lancheria.lancheria.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> cadastroEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
        List<Endereco> enderecoList = enderecoRepository.findAll();
        return enderecoList;
    }

    public Endereco buscaEndereco(Integer id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return endereco;
    }

    public List<Endereco> listaEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    public List<Endereco> deletaEndereco(Integer id) {
        enderecoRepository.deleteById(id);
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }
}
