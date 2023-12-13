package com.lancheria.lancheria.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Double preco;
    private String descricao;
    @Column(columnDefinition = "Text")
    private String img;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Pedido pedido;
}