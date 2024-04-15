package com.example.test.demo.Repositories;

import com.example.test.demo.Models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    // Bạn có thể định nghĩa các phương thức truy vấn tùy chỉnh ở đây nếu cần
}
