package com.example.test.demo.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tblproduct11")
public class Product1 {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productID;

    @Column(nullable = false, unique = true, length = 300)
    private String title;

    private int price;  // Changed from status to price
    private int quantity;
    private Long cateID;
    private Long supplierID;
    private float rate;
    private Date dateReleases;
    private int count;  // New field
    private int discount; // New field

    public Product1() {
    }

    public Product1(Long productID, String title, int price, int quantity, Long cateID, Long supplierID, float rate, Date dateReleases, int count, int discount) {
        this.productID = productID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.cateID = cateID;
        this.supplierID = supplierID;
        this.rate = rate;
        this.dateReleases = dateReleases;
        this.count = count;
        this.discount = discount;
    }

    // Getters and Setters

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCateID() {
        return cateID;
    }

    public void setCateID(Long cateID) {
        this.cateID = cateID;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getDateReleases() {
        return dateReleases;
    }

    public void setDateReleases(Date dateReleases) {
        this.dateReleases = dateReleases;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "productID=" + productID +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", cateID=" + cateID +
                ", supplierID=" + supplierID +
                ", rate=" + rate +
                ", dateReleases=" + dateReleases +
                ", count=" + count +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product1 product1 = (Product1) o;
        return price == product1.price &&
                quantity == product1.quantity &&
                Float.compare(product1.rate, rate) == 0 &&
                count == product1.count &&
                discount == product1.discount &&
                Objects.equals(productID, product1.productID) &&
                Objects.equals(title, product1.title) &&
                Objects.equals(cateID, product1.cateID) &&
                Objects.equals(supplierID, product1.supplierID) &&
                Objects.equals(dateReleases, product1.dateReleases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, title, price, quantity, cateID, supplierID, rate, dateReleases, count, discount);
    }
}
