package com.br.pim.babbo.Babbo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "joranda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JornadaDeTrabalho {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    private String diaDaSemana;
    private String horaDeEntrada;
    private String horaDeSaida;


}
