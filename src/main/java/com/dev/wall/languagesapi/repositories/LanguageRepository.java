package com.dev.wall.languagesapi.repositories;

import com.dev.wall.languagesapi.domain.entities.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository  extends MongoRepository<Language, String> {
}