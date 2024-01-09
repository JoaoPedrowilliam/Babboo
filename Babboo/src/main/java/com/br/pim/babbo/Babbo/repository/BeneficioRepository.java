package com.br.pim.babbo.Babbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pim.babbo.Babbo.model.Beneficio;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Long>{
    
}
