package com.dwprojects.projetowebservice.repositories;

import com.dwprojects.projetowebservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
