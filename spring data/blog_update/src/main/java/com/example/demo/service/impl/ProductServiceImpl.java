package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByAll(Pageable pageable, String nameSearch, String priceSearch, String categoryIdSearch) {
        return productRepository.search("%"+nameSearch+"%", "%" + priceSearch + "%","%"+categoryIdSearch+"%",pageable);
    }

    @Override
    public void save(Product blog) {
        productRepository.save(blog);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
