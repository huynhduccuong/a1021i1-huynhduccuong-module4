package com.example.demo.dto;

import com.example.demo.model.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductDTO implements Serializable {
    private Integer id;
    @NotEmpty(message = "không được để trống.")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải có độ dài từ 5-50 ký tự.")
    private String name;
    @Min(value = 100000, message = "giá của sản phẩm phải từ 100000 trở lên.")
    private double price;
    @NotEmpty(message = "không được để trống.")
    private String status;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, double price, String status, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
