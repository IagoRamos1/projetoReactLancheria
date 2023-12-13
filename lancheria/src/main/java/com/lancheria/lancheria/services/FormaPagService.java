package com.lancheria.lancheria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancheria.lancheria.entities.FormaPagamento;
import com.lancheria.lancheria.repository.FormaPagRepository;

@Service
public class FormaPagService {
    @Autowired
    FormaPagRepository formaPagRepository;

    public void cadastraFormaPagamento(FormaPagamento formaPagamento) {
        formaPagRepository.save(formaPagamento);
    }

    public List<FormaPagamento> listaFormaPagamento() {
        return formaPagRepository.findAll();
    }

    public FormaPagamento buscaPagamento(Integer id) {
        FormaPagamento formaPagamento = formaPagRepository.findById(id).get();
        return formaPagamento;
    }

    public List<FormaPagamento> deleteFormaPagamento(Integer id) {
        formaPagRepository.deleteById(id);
        List<FormaPagamento> formaPagamento = formaPagRepository.findAll();
        return formaPagamento;
    }
}
