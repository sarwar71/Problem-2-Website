package com.example.website.controllers;

import com.example.website.models.Product;
import com.example.website.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String getAllProducts(Model model, @RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "sort", required = false) Integer sort) {

        List<Product> products = new ArrayList<>();

        try {
            products = productService.findAllProducts(keyword, sort);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        model.addAttribute("selectedSort", sort != null ? sort : "");

        return "index";
    }
}
