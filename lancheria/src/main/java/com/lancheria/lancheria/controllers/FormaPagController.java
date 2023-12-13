package com.lancheria.lancheria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancheria.lancheria.entities.FormaPagamento;
import com.lancheria.lancheria.services.FormaPagService;

@RestController
@RequestMapping("/formaPagamento")
public class FormaPagController {
    @Autowired
    FormaPagService pagamentoService;

    @GetMapping("/formaPagamento")
    public List<FormaPagamento> listarFormaPagamento() {
        return pagamentoService.listaFormaPagamento();
    }

    @PostMapping("/cadastro")
    public void cadastraFormaPagamento(FormaPagamento formaPagamento) {
        pagamentoService.cadastraFormaPagamento(formaPagamento);
    }

    @GetMapping("/buscaFormaPagamento")
    public FormaPagamento buscFormaPagamento(@RequestParam(value = "id") int id) {
        return pagamentoService.buscaPagamento(id);
    }

    @DeleteMapping("/delete")
    public List<FormaPagamento> deletaFormaPagamentos(@RequestParam(value = "id") int id) {
        return pagamentoService.deleteFormaPagamento(id);
    }
}
