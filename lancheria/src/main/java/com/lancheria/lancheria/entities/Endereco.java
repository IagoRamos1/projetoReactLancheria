package com.lancheria.lancheria.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rua;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "endereco")
    private List<Pedido> pedidos;

}
