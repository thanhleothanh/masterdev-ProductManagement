package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.exceptions.NotFoundException;
import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import com.ghtk.thanhnh157.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy category với id này!"));
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity put(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy category với id này!"));
        categoryRepository.delete(category);

    }
}
