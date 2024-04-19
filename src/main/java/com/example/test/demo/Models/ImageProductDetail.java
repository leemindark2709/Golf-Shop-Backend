package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "image_product_detail")
public class ImageProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageID;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Integer productID;

    // Constructors
    public ImageProductDetail() {
    }

    public ImageProductDetail(String image, Integer productID) {
        this.image = image;
        this.productID = productID;
    }

    // Getters and setters
    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    // toString, equals, and hashCode methods (optional)
    @Override
    public String toString() {
        return "ImageProductDetail{" +
                "imageID=" + imageID +
                ", image='" + image + '\'' +
                ", productID=" + productID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageProductDetail that = (ImageProductDetail) o;
        return imageID.equals(that.imageID);
    }

    @Override
    public int hashCode() {
        return imageID.hashCode();
    }
}
