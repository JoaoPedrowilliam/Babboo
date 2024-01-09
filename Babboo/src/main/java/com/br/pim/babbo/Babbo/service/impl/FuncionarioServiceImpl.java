package com.br.pim.babbo.Babbo.service.impl;

import com.br.pim.babbo.Babbo.model.Funcionario;
import com.br.pim.babbo.Babbo.model.Usuario;
import com.br.pim.babbo.Babbo.repository.FuncionarioRepository;
import com.br.pim.babbo.Babbo.service.FuncionarioService;
import com.br.pim.babbo.Babbo.service.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private final FuncionarioRepository funcionarioRepository;


    @Override
    public Optional<Funcionario> findFuncionario(Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId);
    }

    @Override
    public void deletaFuncionario(Long funcionarioId) {
        funcionarioRepository.deleteById(funcionarioId);
    }

    @Override
    public List<Funcionario> findFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Funcionario> atualizaFuncionario(Long funcionarioId, Funcionario funcionario) {
        return funcionarioRepository.findById(funcionarioId).map(funcionarioEncontrado -> {
            funcionarioEncontrado.setNome(funcionario.getNome());
            //funcionarioEncontrado.setCargo(funcionario.getCargo());
            funcionarioEncontrado.setCpf(funcionario.getCpf());
            Funcionario funcionarioSalvo = funcionarioRepository.save(funcionarioEncontrado);
            return ResponseEntity.ok().body(funcionarioSalvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @Override
    public Funcionario salvaFuncionario(Funcionario funcionario) {
        
        Long usuarioId = funcionario.getUsuario().getUsuarioId();
        Usuario usuario = usuarioService.findUsuario(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + usuarioId));

        funcionario.setUsuario(usuario);
        funcionario = this.funcionarioRepository.save(funcionario);


        return funcionario;
    
    
    }



}
