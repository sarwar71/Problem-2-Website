package com.example.website.repositories;

import com.example.website.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE CONCAT(p.productName, p.brand) LIKE %?1%")
    List<Product> searchProduct(String key);

    @Query("FROM Product ORDER BY price ASC")
    List<Product> findByOrderByPriceAsc();

    @Query("FROM Product ORDER BY price DESC")
    List<Product> findByOrderByPriceDesc();

    @Query("SELECT p FROM Product p WHERE CONCAT(p.productName, p.brand) LIKE %?1% ORDER BY price ASC")
    List<Product> searchProductByOrderByPriceAsc(String key);

    @Query("SELECT p FROM Product p WHERE CONCAT(p.productName, p.brand) LIKE %?1% ORDER BY price DESC")
    List<Product> searchProductByOrderByPriceDesc(String key);
}
