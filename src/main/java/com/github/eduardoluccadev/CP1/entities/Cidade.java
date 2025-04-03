package com.github.eduardoluccadev.CP1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100, message = "O estado deve ter entre 3 e 100 caracteres")
    private String estado;

    @Column(nullable = false, length = 2)
    @Size(min = 2, max = 2, message = "A UF deve ter exatamente 2 caracteres")
    private String uf;

    public Cidade(Object o, @NotBlank(message = "O nome é obrigatório") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres") String nome, @NotBlank(message = "O estado é obrigatório") @Size(min = 3, max = 100, message = "O estado deve ter entre 3 e 100 caracteres") String estado, @NotBlank(message = "A UF é obrigatória") @Size(min = 2, max = 2, message = "A UF deve ter exatamente 2 caracteres") String uf) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}

