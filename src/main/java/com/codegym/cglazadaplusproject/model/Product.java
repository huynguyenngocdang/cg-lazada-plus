package com.codegym.cglazadaplusproject.model;

public class Product {
<<<<<<< HEAD:src/main/java/com/codegym/cglazadaplusproject/model/Product.java
    private int productId;
    private int productUserId;
    private String productName;
    private double productQuantity;
    private double productCost;
    private boolean isDelete;

    public Product(int productId, int productUserId, String productName, double productQuantity, double productCost, boolean isDelete) {
        this.productId = productId;
        this.productUserId = productUserId;
=======
    private int productID;
    private int userID;
    private String productName;
    private int productQuantity;
    private double productCost;
    private int isDelete;


    public Product(int userID, String productName, int productQuantity, double productCost, int isDelete) {
        this.userID = userID;
>>>>>>> b531d509370960c9c7f54efc27300b1dce3411be:cg-lazada-plus-project/src/main/java/com/codegym/cglazadaplusproject/model/Product.java
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.isDelete = isDelete;
    }

<<<<<<< HEAD:src/main/java/com/codegym/cglazadaplusproject/model/Product.java
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
=======
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
>>>>>>> b531d509370960c9c7f54efc27300b1dce3411be:cg-lazada-plus-project/src/main/java/com/codegym/cglazadaplusproject/model/Product.java
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

<<<<<<< HEAD:src/main/java/com/codegym/cglazadaplusproject/model/Product.java
    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
=======
    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
>>>>>>> b531d509370960c9c7f54efc27300b1dce3411be:cg-lazada-plus-project/src/main/java/com/codegym/cglazadaplusproject/model/Product.java
        this.productQuantity = productQuantity;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

<<<<<<< HEAD:src/main/java/com/codegym/cglazadaplusproject/model/Product.java
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
=======
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
>>>>>>> b531d509370960c9c7f54efc27300b1dce3411be:cg-lazada-plus-project/src/main/java/com/codegym/cglazadaplusproject/model/Product.java
    }
}
