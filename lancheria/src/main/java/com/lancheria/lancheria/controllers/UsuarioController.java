package com.lancheria.lancheria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancheria.lancheria.dto.LoginDto;
import com.lancheria.lancheria.dto.UsuarioDto;
import com.lancheria.lancheria.entities.Usuario;
import com.lancheria.lancheria.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastroUsuario")
    public void cadastroUsuario(Usuario usuario) {
        usuarioService.salvar(usuario);
    }

    @PutMapping("/atualizaUsuario")
    public void atualizaUsuario(Usuario usuario) {
        usuarioService.salvar(usuario);
    }

    @GetMapping("/listarUsuarios")
    public List<UsuarioDto> listarUsuarios() {
        return usuarioService.listaUsuarios();
    }

    @GetMapping("/buscaUsuario")
    // public UsuarioDto buscarUsuario(@RequestParam(value = "id") int id,
    // @AuthenticationPrincipal OidcUser principal) {
    // public UsuarioDto buscarUsuario(@RequestParam(value = "id") int id,
    // @AuthenticationPrincipal OidcUser principal) {
    public UsuarioDto buscarUsuario(@RequestParam(value = "id") int id) {
        // String email = principal.getAttribute("email");
        // String nome = principal.getAttribute("name");
        // String password = principal.getAttribute("password");

        // System.out.println("Email: " + email + ", nome: " + nome + " senha: " +
        // password);

        return usuarioService.buscaUsuario(id);
    }

    @PostMapping("/excluirUsuario")
    public List<Usuario> excluirUsuario(@RequestParam(value = "id") int id) {
        return usuarioService.deletaUsuario(id);
    }

    @PostMapping("/login")
    // public ResponseEntity<String> logar(@RequestParam(value = "username") String
    // username,
    // @RequestParam(value = "senha") String senha) {
    public LoginDto logar(@RequestBody LoginDto loginDto) {
        return usuarioService.login(loginDto);
    }
}