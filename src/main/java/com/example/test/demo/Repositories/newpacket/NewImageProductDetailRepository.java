package com.example.test.demo.Repositories.newpacket;

import com.example.test.demo.Models.ImageProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewImageProductDetailRepository extends JpaRepository<ImageProductDetail, Long> {
    @Query("SELECT ipd.image FROM ImageProductDetail ipd WHERE ipd.productID = ?1")
    List<String> findImagesByProductID(Integer productID);
}
