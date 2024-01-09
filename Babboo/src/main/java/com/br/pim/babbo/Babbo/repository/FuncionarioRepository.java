package com.br.pim.babbo.Babbo.repository;

import com.br.pim.babbo.Babbo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
}
