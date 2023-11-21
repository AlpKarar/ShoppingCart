package com.deneme.shoppingcart.Repository;

import com.deneme.shoppingcart.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
