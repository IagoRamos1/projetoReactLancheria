package com.lancheria.lancheria.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancheria.lancheria.entities.Produto;
import com.lancheria.lancheria.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void cadastro(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> getObject() {
        return produtoRepository.findAll();
    }

    public Produto getProduto(int id) {
        return produtoRepository.findById(id).get();
    }

    public void delProduto(int id) {
        produtoRepository.deleteById(id);

    }

}