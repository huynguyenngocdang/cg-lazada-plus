package com.codegym.cglazadaplusproject.model;

public class Product {
    private int productID;
    private int userID;
    private String productName;
    private int productQuantity;
    private double productCost;
    private int isDelete;


    public Product(int userID, String productName, int productQuantity, double productCost, int isDelete) {
        this.userID = userID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.isDelete = isDelete;
    }

    public Product(String productName, int productQuantity, double productCost) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
    }

    public Product(int userID, String productName, int productQuantity, double productCost) {
        this.userID = userID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
    }

    public Product(int productID, int userID, String productName, int productQuantity, double productCost, int isDelete) {
        this.productID = productID;
        this.userID = userID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.isDelete = isDelete;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
