package com.br.pim.babbo.Babbo.service;

import com.br.pim.babbo.Babbo.model.Funcionario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    Optional<Funcionario> findFuncionario(Long funcionarioId);

    Funcionario salvaFuncionario(Funcionario funcionario);

    void deletaFuncionario(Long funcionarioId);

    List<Funcionario> findFuncionarios();

    ResponseEntity<Funcionario> atualizaFuncionario(Long funcionarioId, Funcionario funcionario);
}
