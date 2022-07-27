package com.dev.wall.languagesapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LanguageUpdateRequest {

    @NotEmpty(message = "Por favor, informe a url da imagem")
    private String image;
    private Integer ranking;
}
