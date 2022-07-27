package com.dev.wall.languagesapi.mappers;

import com.dev.wall.languagesapi.domain.dto.LanguageResponse;
import com.dev.wall.languagesapi.domain.entities.Language;

public class LanguageResponseMapper extends Mapper{

    public static LanguageResponse languagesToLanguagesResponse(Language language) {

        if(isNull(language))
            return null;

        return LanguageResponse.builder().id(language.getId())
                .title(language.getTitle())
                .image(language.getImage())
                .ranking(language.getRanking())
                .build();
    }
}
