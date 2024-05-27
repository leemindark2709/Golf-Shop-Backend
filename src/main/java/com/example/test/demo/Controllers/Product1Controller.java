package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Product1;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.Product1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products1")
public class Product1Controller {
    @Autowired
    private Product1Repository repository1;

    @GetMapping("")
    List<Product1> getAllProducts1() {
        return repository1.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product1> foundProduct = repository1.findById(id);
        if (foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query product successfully", foundProduct));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "can not find product with id =" + id, "")
            );
        }
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product1 newProduct) {
        if (newProduct.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "product title cannot be null", "")
            );
        }

        List<Product1> foundProducts = repository1.findByTitle(newProduct.getTitle().trim());
        if (!foundProducts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("failed", "product name already taken", "")
            );
        }

        Product1 savedProduct = repository1.save(newProduct);
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "insert product successfully", savedProduct)
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product1 newProduct, @PathVariable Long id) {
        if (!repository1.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "product not found with id: " + id, "")
            );
        }

        Product1 updatedProduct = repository1.findById(id)
                .map(product -> {
                    product.setTitle(newProduct.getTitle());
                    product.setPrice(newProduct.getPrice());  // Update price
                    product.setQuantity(newProduct.getQuantity());
                    product.setCateID(newProduct.getCateID());
                    product.setSupplierID(newProduct.getSupplierID());
                    product.setRate(newProduct.getRate());
                    product.setDateReleases(newProduct.getDateReleases());
                    product.setCount(newProduct.getCount());
                    product.setDiscount(newProduct.getDiscount()); // Update discount
                    return repository1.save(product);
                }).orElse(null);

        if (updatedProduct != null) {
            return ResponseEntity.ok().body(
                    new ResponseObject("ok", "update successfully", updatedProduct)
            );
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseObject("failed", "failed to update product with id: " + id, "")
            );
        }
    }
}
