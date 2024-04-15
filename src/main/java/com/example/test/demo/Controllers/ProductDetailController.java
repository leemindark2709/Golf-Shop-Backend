package com.example.test.demo.Controllers;

import com.example.test.demo.Models.ProductDetail;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product-details")
public class ProductDetailController {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @GetMapping("")
    public List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProductDetailById(@PathVariable int id) {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(id);
        if (productDetail.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query product detail successfully", productDetail));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find product detail with id = " + id, ""));
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertProductDetail(@RequestBody ProductDetail newProductDetail) {
        ProductDetail savedProductDetail = productDetailRepository.save(newProductDetail);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "insert product detail successfully", savedProductDetail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateProductDetail(@PathVariable int id, @RequestBody ProductDetail updatedProductDetail) {
        Optional<ProductDetail> existingProductDetail = productDetailRepository.findById(id);
        if (existingProductDetail.isPresent()) {
            updatedProductDetail.setId(id);
            ProductDetail savedProductDetail = productDetailRepository.save(updatedProductDetail);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update product detail successfully", savedProductDetail));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find product detail with id = " + id, ""));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProductDetail(@PathVariable int id) {
        if (productDetailRepository.existsById(id)) {
            productDetailRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "delete product detail successfully", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find product detail with id = " + id, ""));
        }
    }
}
