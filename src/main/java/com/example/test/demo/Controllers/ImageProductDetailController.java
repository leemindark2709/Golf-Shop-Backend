package com.example.test.demo.Controllers;

import com.example.test.demo.Models.ImageProductDetail;
import com.example.test.demo.Models.ProductImageDTO;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.ImageProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/imageproductdetails")
public class ImageProductDetailController {
    @Autowired
    private ImageProductDetailRepository imageProductDetailRepository;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getImageProductDetailByProductId(@PathVariable Integer productId) {
        List<ImageProductDetail> imageProductDetails = imageProductDetailRepository.findByProductID(productId);
        if (!imageProductDetails.isEmpty()) {
            List<String> urls = imageProductDetails.stream().map(ImageProductDetail::getImage).collect(Collectors.toList());
            return ResponseEntity.ok().body(new ProductImageDTO(productId, urls));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createImageProductDetail(@RequestBody ImageProductDetail imageProductDetail) {
        Optional<ImageProductDetail> existingImageProductDetail = imageProductDetailRepository.findById(imageProductDetail.getImageID());
        if (existingImageProductDetail.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Hình ảnh với ID " + imageProductDetail.getImageID() + " đã tồn tại", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Chèn hình ảnh sản phẩm thành công", imageProductDetailRepository.save(imageProductDetail))
        );
    }

    @PutMapping("/{imageId}")
    public ResponseEntity<?> updateImageProductDetail(@PathVariable Long imageId, @RequestBody ImageProductDetail updatedImageProductDetail) {
        ImageProductDetail existingImageProductDetail =  imageProductDetailRepository.findById(imageId)
                .orElse(null);
        if (existingImageProductDetail != null) {
            updatedImageProductDetail.setImageID(imageId);
            ImageProductDetail savedImageProductDetail = imageProductDetailRepository.save(updatedImageProductDetail);
            return ResponseEntity.ok().body(savedImageProductDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<?> deleteImageProductDetail(@PathVariable Long imageId) {
        if (imageProductDetailRepository.existsById(imageId)) {
            imageProductDetailRepository.deleteById(imageId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
