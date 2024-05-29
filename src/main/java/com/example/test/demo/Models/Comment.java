package com.example.test.demo.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int idProduct;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Date createByDate;

    @Column(nullable = false, length = 1000)
    private String content;

    public Comment() {
    }

    public Comment(int idProduct, String name, Date createByDate, String content) {
        this.idProduct = idProduct;
        this.name = name;
        this.createByDate = createByDate;
        this.content = content;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateByDate() {
        return createByDate;
    }

    public void setCreateByDate(Date createByDate) {
        this.createByDate = createByDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", createByDate=" + createByDate +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                idProduct == comment.idProduct &&
                Objects.equals(name, comment.name) &&
                Objects.equals(createByDate, comment.createByDate) &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduct, name, createByDate, content);
    }
}
