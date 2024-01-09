package com.br.pim.babbo.Babbo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Departamento.TABLE_NAME)
public class Departamento {
    public static final String TABLE_NAME = "departamento";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long departamentoId;


    // @OneToMany(mappedBy = "departamento")
    // private List<Contrato> contratos;

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "gestor_id", unique = true, nullable = false)
    private Funcionario gestor;

}
