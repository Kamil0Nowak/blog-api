package com.kamil0nowak.blogapi.services.impl;

import com.kamil0nowak.blogapi.domain.entities.Category;
import com.kamil0nowak.blogapi.repositories.CategoryRepository;
import com.kamil0nowak.blogapi.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }


}
