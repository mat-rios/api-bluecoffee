package com.blucoffee.productsmanager.controller;

import com.blucoffee.productsmanager.entity.Product;
import com.blucoffee.productsmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save-products")
    public String saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{documentId}")
    public Product getProduct(@PathVariable String documentId) throws ExecutionException, InterruptedException {
        return productService.getProductDetails(documentId);
    }

    @GetMapping("/products/getAll")
    public List<Product> getAllProducts() throws ExecutionException, InterruptedException {
        return productService.getAllProducts();
    }

    @PutMapping("/update-product")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/delete/{documentId}")
    public void deleteProduct(@PathVariable String documentId) throws ExecutionException, InterruptedException {
        productService.deleteProduct(documentId);
    }
}
