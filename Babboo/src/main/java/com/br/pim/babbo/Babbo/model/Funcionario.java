package com.br.pim.babbo.Babbo.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = Funcionario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {
    public static final String TABLE_NAME = "funcionario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long funcionarioId;

    private String nome;

    private String genero;

    private String telefone;

    @NotNull
    @NotEmpty
    @Column(name="CPF", nullable = false)
    private String cpf;

    private String linkedin;
 
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Usuario usuario;

}
