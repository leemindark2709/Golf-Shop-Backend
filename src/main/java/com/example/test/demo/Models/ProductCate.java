package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ProductCate")
public class ProductCate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "title", length = 300)
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "categoryName", length = 250)
    private String categoryName;

    @Column(name = "image", length = 250)
    private String image;

    @Column(name = "rate")
    private float rate;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "createdDate")
    private Date createdDate;

    // Constructors, getters, and setters

    public ProductCate() {
    }

    public ProductCate(Long productId, String title, int price, String description, String categoryName, String image, float rate, BigDecimal discount, Date createdDate) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryName = categoryName;
        this.image = image;
        this.rate = rate;
        this.discount = discount;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}


