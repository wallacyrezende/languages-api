package com.dev.wall.languagesapi.services.impl;

import com.dev.wall.languagesapi.domain.dto.LanguageCreateRequest;
import com.dev.wall.languagesapi.domain.dto.LanguageResponse;
import com.dev.wall.languagesapi.domain.dto.LanguageUpdateRequest;
import com.dev.wall.languagesapi.exceptions.LanguageNotFoundException;
import com.dev.wall.languagesapi.mappers.LanguageMapper;
import com.dev.wall.languagesapi.mappers.LanguageResponseMapper;
import com.dev.wall.languagesapi.repositories.LanguageRepository;
import com.dev.wall.languagesapi.services.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;

    public LanguageServiceImpl(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LanguageResponse> listAll() {
        var languages = repository.findAll();
        return languages.stream()
                        .map(LanguageResponseMapper::languagesToLanguagesResponse)
                        .collect(Collectors.toList());
    }

    @Override
    public LanguageResponse createLanguage(LanguageCreateRequest request) {
        var language = LanguageMapper.languageCreateRequestToLanguage(request);
        var savedLanguage = repository.save(language);
        return LanguageResponseMapper.languagesToLanguagesResponse(savedLanguage);
    }

    @Override
    public LanguageResponse updateLanguage(String id, LanguageUpdateRequest request) {
        var languageOptional = repository.findById(id);

        if(languageOptional.isEmpty()) {
            throw new LanguageNotFoundException();
        }

        var language = languageOptional.get();
        language.setImage(request.getImage());
        language.setRanking(request.getRanking());
        var savedLanguage = repository.save(language);
        return LanguageResponseMapper.languagesToLanguagesResponse(savedLanguage);
    }

    @Override
    public LanguageResponse delete(String id) {
        var languageOptional = repository.findById(id);

        if(languageOptional.isEmpty()) {
            throw new LanguageNotFoundException();
        }

        var language = languageOptional.get();
        repository.delete(language);
        return LanguageResponseMapper.languagesToLanguagesResponse(language);
    }
}
