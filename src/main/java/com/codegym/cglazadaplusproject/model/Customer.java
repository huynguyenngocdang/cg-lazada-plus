package com.codegym.cglazadaplusproject.model;

public class Customer {
    private int customerId;
    private int userId;
    private String customerName;
    private String customerAddress;
    private double customerBalance;
    private int customerPoint;
    private int customerMemebershipId;
    private boolean isDelete;

    public Customer(int customerId, int userId, String customerName, String customerAddress, double customerBalance, int customerPoint, int customerMemebershipId, boolean isDelete) {
        this.customerId = customerId;
        this.userId = userId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerBalance = customerBalance;
        this.customerPoint = customerPoint;
        this.customerMemebershipId = customerMemebershipId;
        this.isDelete = isDelete;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public int getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(int customerPoint) {
        this.customerPoint = customerPoint;
    }

    public int getCustomerMemebershipId() {
        return customerMemebershipId;
    }

    public void setCustomerMemebershipId(int customerMemebershipId) {
        this.customerMemebershipId = customerMemebershipId;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", userId=" + userId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerBalance=" + customerBalance +
                ", customerPoint=" + customerPoint +
                ", customerMemebershipId=" + customerMemebershipId +
                ", isDelete=" + isDelete +
                '}';
    }
}
