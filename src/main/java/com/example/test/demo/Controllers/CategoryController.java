package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Category;
import com.example.test.demo.Models.Product1;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.CategoryRepository;
import com.example.test.demo.Repositories.Product1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Product1Repository product1Repository;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getCategoryById(@PathVariable int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query category successfully", category));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find category with id = " + id, ""));
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertCategory(@RequestBody Category newCategory) {
        Category savedCategory = categoryRepository.save(newCategory);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "insert category successfully", savedCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            updatedCategory.setCateID(id);
            Category savedCategory = categoryRepository.save(updatedCategory);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update category successfully", savedCategory));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find category with id = " + id, ""));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@PathVariable int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "delete category successfully", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find category with id = " + id, ""));
        }
    }

    // New API to find products by category name
    @GetMapping("/findProductsByCategoryName")
    public ResponseEntity<ResponseObject> findProductsByCategoryName(@RequestParam String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        if (category != null) {
            List<Product1> products = product1Repository.findByCateID(category.getCateID());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query products successfully", products));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find category with name = " + categoryName, ""));
        }
    }
}
