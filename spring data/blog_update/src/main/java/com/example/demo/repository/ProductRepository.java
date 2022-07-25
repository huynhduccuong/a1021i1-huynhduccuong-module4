package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value="SELECT * FROM product where `name` like :nameSearch and price like:priceSearch and category_id like :categoryId",
            countQuery ="SELECT * FROM product where `name` like :nameSearch  and price like:priceSearch and category_id like :categoryId",nativeQuery =true)
    Page<Product> search(@Param("nameSearch")String nameSearch, @Param("priceSearch") String priceSearch, @Param("categoryId") String categoryIdSearch, Pageable pageable);
}
