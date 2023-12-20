package com.codegym.cglazadaplusproject.model;

public class Product {
    private int productId;
    private int productUserId;
    private String productName;
    private double productQuantity;
    private double productCost;
    private boolean isDelete;


    public Product(int productUserId, String productName, double productQuantity, double productCost) {
        this.productUserId = productUserId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
    }

    public Product(int productId, int productUserId, String productName, double productQuantity, double productCost, boolean isDelete) {
        this.productId = productId;
        this.productUserId = productUserId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.isDelete = isDelete;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(int productUserId) {
        this.productUserId = productUserId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productUserId=" + productUserId +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productCost=" + productCost +
                ", isDelete=" + isDelete +
                '}';
    }
}
