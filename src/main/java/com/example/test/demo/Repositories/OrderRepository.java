package com.example.test.demo.Repositories;

import com.example.test.demo.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Bạn có thể định nghĩa các phương thức truy vấn tùy chỉnh ở đây nếu cần
}
