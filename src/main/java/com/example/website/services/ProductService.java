package com.example.website.services;

import com.example.website.models.Product;
import com.example.website.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAllProducts(String key, Integer sort) {

        List<Product> products = new ArrayList<>();

        try {
            if (key != null && sort != null && sort != 0) {
                if (sort == 1) {
                    products = productRepository.searchProductByOrderByPriceAsc(key);
                } else if (sort == 2) {
                    products = productRepository.searchProductByOrderByPriceDesc(key);
                }
            } else if (key != null) {
                products = productRepository.searchProduct(key);
            } else if (sort != null && sort == 1) {
                products = productRepository.findByOrderByPriceAsc();
            } else if (sort != null && sort == 2) {
                products = productRepository.findByOrderByPriceDesc();
            } else {
                products = productRepository.findAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
