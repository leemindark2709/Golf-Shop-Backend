package com.example.test.demo.Repositories.newpacket;

import com.example.test.demo.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewCategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.cateID = ?1")
    Category findByCateID(Long cateID);
}
