package com.codegym.cglazadaplusproject.model;

public class CartItem {
    private Product product;
    private double productQuantity;

    public CartItem() {
    }

    public CartItem(Product product, double productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "product=" + product.toString() +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
