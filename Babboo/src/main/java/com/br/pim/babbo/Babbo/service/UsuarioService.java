package com.br.pim.babbo.Babbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.br.pim.babbo.Babbo.model.Usuario;

public interface UsuarioService {

    

Optional<Usuario> findUsuario(Long usuarioID);

Usuario salvarUsuario(Usuario usuario);

void deletarUsuario(Long usuario);

List<Usuario> findUsuarios();

ResponseEntity<Usuario> atualizarUsuario(Long usuarioId, Usuario usuario);


}
