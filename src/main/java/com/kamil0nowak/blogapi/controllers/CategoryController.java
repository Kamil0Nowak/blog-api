package com.kamil0nowak.blogapi.controllers;

import com.kamil0nowak.blogapi.domain.dto.CategoryDto;
import com.kamil0nowak.blogapi.mappers.CategoryMapper;
import com.kamil0nowak.blogapi.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        var categories = categoryService.listCategories()
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        return ResponseEntity.ok(categories);
    }
}
