package org.example;

import jakarta.validation.constraints.*;

public class ProductDTORequest {


    @NotBlank(message = "Product name is required.")
    private String name;

    @Size(max = 500, message = "Description can be maximum 500 character.")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero.")
    private Double price;


    private String category;
    private String brand;

    @NotNull(message = "Quantity is required.")
    @Min(value = 0, message = "Quantity can not be negative.")
    private Integer quantity;

    @NotBlank(message = "SKU is required.")
    private String sku;   // stock keeping unit

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
