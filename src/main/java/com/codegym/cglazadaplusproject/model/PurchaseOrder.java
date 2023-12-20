package com.codegym.cglazadaplusproject.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class PurchaseOrder {
    private int productId;
    private int buyerId;
    private int sellerId;
    private Date poDate;
    private String poAddress;
    private double poQuantity;
    private double poUnitPrice;
    private double poTotalCost;
    private double poFinalCost;

    public PurchaseOrder(int productId, int buyerId, int sellerId,String poAddress, double poQuantity, double poUnitPrice, double poTotalCost, double poFinalCost) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.poAddress = poAddress;
        LocalDateTime localDateTime = LocalDateTime.now();
        this.poDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        this.poQuantity = poQuantity;
        this.poUnitPrice = poUnitPrice;
        this.poTotalCost = poTotalCost;
        this.poFinalCost = poFinalCost;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public double getPoQuantity() {
        return poQuantity;
    }

    public void setPoQuantity(double poQuantity) {
        this.poQuantity = poQuantity;
    }

    public double getPoUnitPrice() {
        return poUnitPrice;
    }

    public void setPoUnitPrice(double poUnitPrice) {
        this.poUnitPrice = poUnitPrice;
    }

    public double getPoTotalCost() {
        return poTotalCost;
    }

    public void setPoTotalCost(double poTotalCost) {
        this.poTotalCost = poTotalCost;
    }

    public double getPoFinalCost() {
        return poFinalCost;
    }

    public void setPoFinalCost(double poFinalCost) {
        this.poFinalCost = poFinalCost;
    }

    public String getPoAddress() {
        return poAddress;
    }

    public void setPoAddress(String poAddress) {
        this.poAddress = poAddress;
    }
}
