package com.lancheria.lancheria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lancheria.lancheria.dto.LoginDto;
import com.lancheria.lancheria.dto.UsuarioDto;
import com.lancheria.lancheria.entities.Usuario;
import com.lancheria.lancheria.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> listaUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public UsuarioDto buscaUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        UsuarioDto usuarioDto = new UsuarioDto(usuario);
        return usuarioDto;
    }

    public List<Usuario> deletaUsuario(Integer id) {
        usuarioRepository.deleteById(id);
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public LoginDto login(LoginDto loginDto) {

        // Usuario usuario = usuarioRepository.findByUsernameAndSenha(username, senha);
        // if (usuario != null) {
        // return ResponseEntity.ok().body("Antenticado com sucesso");
        // }
        // return ResponseEntity.badRequest().body("Falha de autenticação");
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(loginDto.getNome())
                    && usuario.getSenha().equals(loginDto.getSenha())) {
                return loginDto;
            }
        }
        return null;
    }

}
