package com.lancheria.lancheria.dto;

import com.lancheria.lancheria.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private int id;
    private String nome;
    private String username;
    private String cpf;
    private String email;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
    }

}
