package com.dev.wall.languagesapi.mappers;

import com.dev.wall.languagesapi.domain.dto.LanguageCreateRequest;
import com.dev.wall.languagesapi.domain.entities.Language;

public class LanguageMapper extends Mapper {

    public static Language languageCreateRequestToLanguage(LanguageCreateRequest languageCreateRequest) {

        if(isNull(languageCreateRequest))
            return null;

        return Language.builder().title(languageCreateRequest.getTitle())
                .image(languageCreateRequest.getImage())
                .ranking(languageCreateRequest.getRanking())
                .build();
    }
}
