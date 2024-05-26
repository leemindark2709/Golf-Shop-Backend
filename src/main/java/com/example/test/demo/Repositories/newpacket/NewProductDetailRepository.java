package com.example.test.demo.Repositories.newpacket;

import com.example.test.demo.Models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    @Query("SELECT pd FROM ProductDetail pd WHERE pd.productID = ?1")
    ProductDetail findByProductID(Integer productID);
}
