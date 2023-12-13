package com.lancheria.lancheria.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private FormaPagamento formaPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Produto> produtos;
}
