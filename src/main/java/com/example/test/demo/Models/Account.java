package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "accout")
public class Account {
    @Id
    private int id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String phone;
    private boolean role;

    public Account() {
    }

    public Account(int id, String username, String password, String name, String address, String phone, boolean role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && role == account.role && Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(name, account.name) && Objects.equals(address, account.address) && Objects.equals(phone, account.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, address, phone, role);
    }
}
