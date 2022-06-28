package com.ghtk.thanhnh157.repositories;

import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
