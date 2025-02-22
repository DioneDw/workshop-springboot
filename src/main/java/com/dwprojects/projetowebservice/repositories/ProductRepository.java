package com.dwprojects.projetowebservice.repositories;

import com.dwprojects.projetowebservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
