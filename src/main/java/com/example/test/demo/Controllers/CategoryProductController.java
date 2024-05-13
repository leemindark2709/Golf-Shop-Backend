package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Category;
import com.example.test.demo.Models.Product1;
import com.example.test.demo.Models.ProductCate;
import com.example.test.demo.Models.ProductDetail;
import com.example.test.demo.Repositories.CategoryRepository;
import com.example.test.demo.Repositories.Product1Repository;
import com.example.test.demo.Repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Products1Categori")
public class CategoryProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Product1Repository product1Repository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<ProductCate>> getProductsByCategory(@PathVariable String categoryName) {
        // Tìm category bằng tên
        Category category = categoryRepository.findByName(categoryName);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Lấy danh sách sản phẩm của category
        List<Product1> products = product1Repository.findByCateID(category.getCateID());

        // Tạo danh sách đối tượng ProductCate
        List<ProductCate> responseProducts = new ArrayList<>();
        for (Product1 product : products) {
            // Lấy thông tin chi tiết của sản phẩm
            ProductDetail productDetail = productDetailRepository.findByProductID(product.getProductID());
            if (productDetail != null) {
                // Tạo đối tượng ProductCate từ thông tin sản phẩm và chi tiết sản phẩm
                ProductCate productCate = new ProductCate();
                productCate.setId(product.getProductID());
                productCate.setTitle(product.getTitle());
                productCate.setPrice(productDetail.getPrice());
                productCate.setDescription(productDetail.getDescription());
                productCate.setCategoryName(category.getName());
                productCate.setImage(productDetail.getImage());
                productCate.setRate(product.getRate());

                // Thêm sản phẩm vào danh sách responseProducts
                responseProducts.add(productCate);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseProducts);
    }
}
