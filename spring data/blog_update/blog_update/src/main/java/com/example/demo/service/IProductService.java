package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findByAll(Pageable pageable, String nameSearch, String priceSearch, String categoryIdSearch);

    void save(Product product);

    Optional<Product> findById(Integer id);

    void delete(Integer id);
}
