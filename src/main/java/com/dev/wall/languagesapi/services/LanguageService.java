package com.dev.wall.languagesapi.services;

import com.dev.wall.languagesapi.domain.dto.LanguageCreateRequest;
import com.dev.wall.languagesapi.domain.dto.LanguageResponse;
import com.dev.wall.languagesapi.domain.dto.LanguageUpdateRequest;

import java.util.List;

public interface LanguageService {

    List<LanguageResponse> listAll();
    LanguageResponse createLanguage(LanguageCreateRequest request);
    LanguageResponse updateLanguage(String id, LanguageUpdateRequest request);
    LanguageResponse delete(String id);
}
