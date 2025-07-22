package com.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
