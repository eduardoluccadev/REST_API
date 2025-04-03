package com.github.eduardoluccadev.CP1.controller.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record EventoDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "A URL é obrigatória")
        @Size(min = 10, max = 255, message = "A URL deve ter entre 10 e 255 caracteres")
        String url,

        @NotNull(message = "A data do evento é obrigatória")
        LocalDate data,

        @NotNull(message = "O ID da cidade é obrigatório")
        Long cidadeId
) {}

