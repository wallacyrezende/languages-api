package com.dev.wall.languagesapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LanguageCreateRequest {

    @NotEmpty(message = "Por favor, informe o nome da linguagem")
    private String title;

    @NotEmpty(message = "Por favor, informe a url da imagem")
    private String image;

    private Integer ranking;
}
