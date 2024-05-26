package com.example.test.demo.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tblproduct10")
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

    private String status;
    private int quantity;
    private Long cateID;
    private Long supplierID;
    private float rate;
    private Date dateReleases;
    private int count; // Trường mới

    public Product1() {
    }

    public Product1(Long productID, String title, String status, int quantity, Long cateID, Long supplierID, float rate, Date dateReleases, int count) {
        this.productID = productID;
        this.title = title;
        this.status = status;
        this.quantity = quantity;
        this.cateID = cateID;
        this.supplierID = supplierID;
        this.rate = rate;
        this.dateReleases = dateReleases;
        this.count = count; // Khởi tạo trường mới
    }

    // Getters và Setters cho trường mới
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Các Getters và Setters hiện có


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    // Các phương thức toString, equals, và hashCode (bao gồm trường mới)
    @Override
    public String toString() {
        return "Product1{" +
                "productID=" + productID +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", cateID=" + cateID +
                ", supplierID=" + supplierID +
                ", rate=" + rate +
                ", dateReleases=" + dateReleases +
                ", count=" + count + // Bao gồm trường mới
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product1 product1 = (Product1) o;
        return quantity == product1.quantity && Float.compare(product1.rate, rate) == 0 && count == product1.count && Objects.equals(productID, product1.productID) && Objects.equals(title, product1.title) && Objects.equals(status, product1.status) && Objects.equals(cateID, product1.cateID) && Objects.equals(supplierID, product1.supplierID) && Objects.equals(dateReleases, product1.dateReleases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, title, status, quantity, cateID, supplierID, rate, dateReleases, count);
    }
}
