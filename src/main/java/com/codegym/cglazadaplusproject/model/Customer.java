package com.codegym.cglazadaplusproject.model;

public class Customer {
    private int customerId;
    private int userId;
    private String customerName;
    private String customerAddress;
    private int customerPoint;
    private int customerMembershipId;
    private boolean isDelete;

    public Customer(){
    }

    public Customer(int customerId, int userId, String customerName, String customerAddress, int customerPoint, int customerMembershipId,boolean isDelete) {
        this.customerId = customerId;
        this.userId = userId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPoint = customerPoint;
        this.customerMembershipId = customerMembershipId;
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

    public int getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(int customerPoint) {
        this.customerPoint = customerPoint;
    }

    public int getCustomerMembershipId() {
        return customerMembershipId;
    }

    public void setCustomerMembershipId(int customerMembershipId) {
        this.customerMembershipId = customerMembershipId;
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
                ", customerPoint=" + customerPoint +
                ", customerMembershipId=" + customerMembershipId +
                '}' + isDelete;
    }
}
