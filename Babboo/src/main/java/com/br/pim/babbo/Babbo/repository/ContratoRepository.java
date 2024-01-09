package com.br.pim.babbo.Babbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pim.babbo.Babbo.model.Contrato;

@Repository
public interface ContratoRepository  extends JpaRepository<Contrato, Long>{
    
}
