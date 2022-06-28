package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.models.entities.CategoryEntity;

public interface CategoryService {
    CategoryEntity getById(Integer id);

    CategoryEntity save(CategoryEntity category);

    CategoryEntity put(CategoryEntity category);

    void deleteById(Integer id);
}
