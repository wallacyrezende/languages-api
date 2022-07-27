package com.dev.wall.languagesapi.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
@Builder
@Data
public class Language {

    @Id
    private String id;
    private String title;
    private String image;
    private Integer ranking;
}
