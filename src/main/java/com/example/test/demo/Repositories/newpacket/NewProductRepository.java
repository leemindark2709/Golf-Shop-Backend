package com.example.test.demo.Repositories.newpacket;

import com.example.test.demo.Models.Product1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewProductRepository extends JpaRepository<Product1, Long> {
    @Query("SELECT p FROM Product1 p WHERE p.productID = ?1")
    Product1 findProductById(Long productID);
}
