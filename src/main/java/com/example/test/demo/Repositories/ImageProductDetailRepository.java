package com.example.test.demo.Repositories;

import com.example.test.demo.Models.ImageProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageProductDetailRepository extends JpaRepository<ImageProductDetail, Long> {
    List<ImageProductDetail> findByProductID(Integer productID);
}
