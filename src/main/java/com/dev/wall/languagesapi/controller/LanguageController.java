package com.dev.wall.languagesapi.controller;

import com.dev.wall.languagesapi.domain.dto.LanguageCreateRequest;
import com.dev.wall.languagesapi.domain.dto.LanguageResponse;
import com.dev.wall.languagesapi.domain.dto.LanguageUpdateRequest;
import com.dev.wall.languagesapi.services.LanguageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {
    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LanguageResponse create(@RequestBody @Valid LanguageCreateRequest request) {
        return service.createLanguage(request);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid LanguageUpdateRequest updateRequest) {
        return ResponseEntity.ok(service.updateLanguage(id, updateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LanguageResponse> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
