package com.kamil0nowak.blogapi.services;

import com.kamil0nowak.blogapi.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
}
