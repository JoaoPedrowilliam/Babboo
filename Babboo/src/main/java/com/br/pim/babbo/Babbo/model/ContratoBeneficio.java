package com.br.pim.babbo.Babbo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ContratoBeneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contratoBeneficioId;


    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "BE_ID")
    private Beneficio beneficio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CT_ID")
    private Contrato contrato;
    
}



