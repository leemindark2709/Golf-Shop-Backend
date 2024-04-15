package com.example.test.demo.Repositories;

import com.example.test.demo.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Bạn có thể định nghĩa các phương thức truy vấn tùy chỉnh ở đây nếu cần
}
