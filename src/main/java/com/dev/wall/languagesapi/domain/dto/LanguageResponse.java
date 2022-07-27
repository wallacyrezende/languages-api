package com.dev.wall.languagesapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageResponse {
    private String id;
    private String title;
    private String image;
    private Integer ranking;
}
