package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CateID")
    private int cateID;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "thumb", length = 250)
    private String thumb;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "UpdateBy")
    private Integer updateBy;

    @Column(name = "UpdateDate")
    private Date updateDate;

    // Getters and setters

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateID=" + cateID +
                ", name='" + name + '\'' +
                ", thumb='" + thumb + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return cateID == category.cateID && Objects.equals(name, category.name) && Objects.equals(thumb, category.thumb) && Objects.equals(status, category.status) && Objects.equals(createdBy, category.createdBy) && Objects.equals(createdDate, category.createdDate) && Objects.equals(updateBy, category.updateBy) && Objects.equals(updateDate, category.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cateID, name, thumb, status, createdBy, createdDate, updateBy, updateDate);
    }
}
