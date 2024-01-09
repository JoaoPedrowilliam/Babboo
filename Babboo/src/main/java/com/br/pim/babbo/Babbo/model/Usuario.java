package com.br.pim.babbo.Babbo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name=Usuario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    public interface CreatUser {}
    public interface UpdateUser{}

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long usuarioId;


    @NotNull(groups = {CreatUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreatUser.class, UpdateUser.class})
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    @NotNull(groups = {CreatUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreatUser.class, UpdateUser.class})
    @Column(name = "senha", nullable = false, length = 25)
    @Size(min = 8, max = 25)
    private String senha;





}
