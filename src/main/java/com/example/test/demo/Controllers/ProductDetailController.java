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

    @GetMapping("/{productID}")
    public ResponseEntity<ResponseObject> getProductDetailByProductID(@PathVariable Integer productID) {
        Optional<ProductDetail> productDetail = productDetailRepository.findByProductID(productID);
        if (productDetail.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "truy vấn chi tiết sản phẩm thành công", productDetail));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "không thể tìm thấy chi tiết sản phẩm với productID = " + productID, ""));
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertProductDetail(@RequestBody ProductDetail newProductDetail) {
        ProductDetail savedProductDetail = productDetailRepository.save(newProductDetail);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "thêm chi tiết sản phẩm thành công", savedProductDetail));
    }

    @PutMapping("/{productID}")
    public ResponseEntity<ResponseObject> updateProductDetail(@PathVariable Integer productID, @RequestBody ProductDetail updatedProductDetail) {
        Optional<ProductDetail> existingProductDetail = productDetailRepository.findByProductID(productID);
        if (existingProductDetail.isPresent()) {
            updatedProductDetail.setId(existingProductDetail.get().getId());
            ProductDetail savedProductDetail = productDetailRepository.save(updatedProductDetail);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "cập nhật chi tiết sản phẩm thành công", savedProductDetail));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "không thể tìm thấy chi tiết sản phẩm với productID = " + productID, ""));
        }
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<ResponseObject> deleteProductDetail(@PathVariable Integer productID) {
        Optional<ProductDetail> productDetail = productDetailRepository.findByProductID(productID);
        if (productDetail.isPresent()) {
            productDetailRepository.deleteById(productDetail.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "xóa chi tiết sản phẩm thành công", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "không thể tìm thấy chi tiết sản phẩm với productID = " + productID, ""));
        }
    }
}
