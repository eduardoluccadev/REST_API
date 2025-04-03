package com.github.eduardoluccadev.CP1.controller.dto;

import jakarta.validation.constraints.*;

public record CidadeDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "O estado é obrigatório")
        @Size(min = 3, max = 100, message = "O estado deve ter entre 3 e 100 caracteres")
        String estado,

        @NotBlank(message = "A UF é obrigatória")
        @Size(min = 2, max = 2, message = "A UF deve ter exatamente 2 caracteres")
        String uf
) {}

