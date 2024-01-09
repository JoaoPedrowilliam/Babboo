package com.br.pim.babbo.Babbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pim.babbo.Babbo.model.Departamento;

@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Long>{
    
}
