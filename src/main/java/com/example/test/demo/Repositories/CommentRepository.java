package com.example.test.demo.Repositories;

import com.example.test.demo.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByIdProduct(int idProduct);
}
