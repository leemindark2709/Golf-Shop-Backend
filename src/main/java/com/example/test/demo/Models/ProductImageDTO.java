package com.example.test.demo.Models;

import java.util.List;

public class ProductImageDTO {
    private Integer productID;
    private List<String> urls;

    public ProductImageDTO(Integer productID, List<String> urls) {
        this.productID = productID;
        this.urls = urls;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
