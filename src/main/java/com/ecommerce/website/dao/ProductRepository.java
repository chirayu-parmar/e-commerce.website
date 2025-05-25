package com.ecommerce.website.dao;

import com.ecommerce.website.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Timer;

@CrossOrigin("http://localhost:4200/")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @RestResource(path = "category", rel = "category")
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    @RestResource(path = "itemSearch", rel = "itemSearch")
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
    
}


