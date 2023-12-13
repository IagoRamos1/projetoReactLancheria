package com.lancheria.lancheria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancheria.lancheria.entities.FormaPagamento;

public interface FormaPagRepository extends JpaRepository<FormaPagamento, Integer> {

}
