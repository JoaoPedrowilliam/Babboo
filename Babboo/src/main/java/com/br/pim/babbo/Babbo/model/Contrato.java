package com.br.pim.babbo.Babbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;




@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "contrato")
public class Contrato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CT_ID", unique = true)
    private  Long  contratoId;

    @OneToOne
    @JoinColumn(name = "funcionarioId", nullable = false, updatable = false)
    private Funcionario funcionario; 
    
    
    private String departamento;
    
    private String tipo;

    @NotNull
    @NotEmpty
    private String cargo;

    private Double salarioBruto;

    // @NotNull
    private String admissao;

    // private LocalDate demissao;

    // @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    // private List<Beneficio> beneficios = new ArrayList<>();
                 
     


    
}
