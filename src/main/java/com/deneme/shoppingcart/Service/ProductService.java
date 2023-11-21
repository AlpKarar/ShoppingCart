package com.deneme.shoppingcart.Service;

import com.deneme.shoppingcart.Entity.Product;
import com.deneme.shoppingcart.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts() {
        List<Product> products = productRepository.findAll();

        return products;
    }

    public Product findProductById(int id) {
        Product product = productRepository.findById(id).get();

        return product;
    }
}
