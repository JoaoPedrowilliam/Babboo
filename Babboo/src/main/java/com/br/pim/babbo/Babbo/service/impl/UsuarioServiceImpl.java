package com.br.pim.babbo.Babbo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.pim.babbo.Babbo.model.Usuario;
import com.br.pim.babbo.Babbo.repository.UsuarioRepository;
import com.br.pim.babbo.Babbo.service.UsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService{

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findUsuario(Long usuarioID) {
        return usuarioRepository.findById(usuarioID);
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public List<Usuario> findUsuarios() {
       return usuarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Usuario> atualizarUsuario(Long usuarioId, Usuario usuario) {
        return usuarioRepository.findById(usuarioId).map(usuarioEncontrado -> {
            usuarioEncontrado.setEmail(usuario.getEmail());
            //usuarioEncontrado.setCargo(usuario.getCargo());
            usuarioEncontrado.setSenha(usuario.getSenha());
            Usuario usuarioSalvo = usuarioRepository.save(usuarioEncontrado);
            return ResponseEntity.ok().body(usuarioSalvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    // @Override
    // public ResponseEntity<Usuario> atualizarUsuario(Long usuarioId, Usuario usuario) {
    
    // }

    
}
