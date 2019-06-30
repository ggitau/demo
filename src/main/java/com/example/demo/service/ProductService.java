package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(boolean recentlyAdded) {
        if (!recentlyAdded) {

            List<Product> products = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
            logger.info("found {} products", products.size());
            return products;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 30);
        return repository.findCreatedSince(cal.getTime());
    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }


    public Product findOne(Long productId) {
        return repository.findById(productId).get();
    }
}
