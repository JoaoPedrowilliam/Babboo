package com.br.pim.babbo.Babbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Data
@Entity
@Table(name = Beneficio.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Beneficio {
    public static final String TABLE_NAME = "beneficio";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BE_ID", unique = true)
    private Long beneficioId;

    @NotEmpty
    @NotNull
    @Column(name = "benficio", unique = true, nullable = false)
    private String nome;

    @NotEmpty
    @NotNull
    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    private Contrato contrato;
}
