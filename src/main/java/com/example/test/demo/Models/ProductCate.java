package com.example.test.demo.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ProductCate")
public class ProductCate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id1")
    private Long id1;


    @Column(name = "id")
    private Long id;

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

    // Constructors, getters, and setters

    public ProductCate() {
    }

    public ProductCate(Long productId, String title, int price, String description, String categoryName, String image, float rate) {
        this.id = productId;
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryName = categoryName;
        this.image = image;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductCate{" +
                "productId=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", image='" + image + '\'' +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCate that = (ProductCate) o;
        return price == that.price && Float.compare(that.rate, rate) == 0 && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(categoryName, that.categoryName) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, categoryName, image, rate);
    }
}
