package com.br.pim.babbo.Babbo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pim.babbo.Babbo.model.Usuario;
import com.br.pim.babbo.Babbo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping()
    public Usuario cirarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> buscarUsuarios(){
        return usuarioService.findUsuarios();
    }

}
