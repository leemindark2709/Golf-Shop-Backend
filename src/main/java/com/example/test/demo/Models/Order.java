package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private int orderID;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "CustomerID")
    private Integer customerID;

    @Column(name = "Discount")
    private BigDecimal discount;

    // Getters and setters

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", customerID=" + customerID +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Objects.equals(orderDate, order.orderDate) && Objects.equals(status, order.status) && Objects.equals(customerID, order.customerID) && Objects.equals(discount, order.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderDate, status, customerID, discount);
    }
}
