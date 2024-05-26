package com.example.test.demo.Controllers;


import com.example.test.demo.Models.*;
import com.example.test.demo.Repositories.newpacket.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/new-products")
public class NewProductController {

    @Autowired
    private NewProductRepository newProductRepository;

    @Autowired
    private NewProductDetailRepository newProductDetailRepository;

    @Autowired
    private NewCategoryRepository newCategoryRepository;

    @Autowired
    private NewImageProductDetailRepository newImageProductDetailRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductDetails(@PathVariable Long id) {
        Product1 product = newProductRepository.findProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        ProductDetail productDetail = newProductDetailRepository.findByProductID(product.getProductID().intValue());
        Category category = newCategoryRepository.findByCateID(product.getCateID());
        List<String> images = newImageProductDetailRepository.findImagesByProductID(product.getProductID().intValue());

        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId(product.getProductID());
        dto.setTitle(product.getTitle());
        dto.setPrice(productDetail.getPrice());
        dto.setDescription(productDetail.getDescription());
        dto.setCategory(category.getName());
        dto.setImages(images);
        dto.setThumbnail(productDetail.getImage()); // Gán giá trị thumbnail

        ProductDetailDTO.RatingDTO ratingDTO = new ProductDetailDTO.RatingDTO();
        ratingDTO.setRate(product.getRate());
        ratingDTO.setCount(product.getCount());
        dto.setRating(ratingDTO);

        return ResponseEntity.ok(dto);
    }
}
