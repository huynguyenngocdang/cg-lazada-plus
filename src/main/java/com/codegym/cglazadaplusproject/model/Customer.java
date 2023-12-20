package com.codegym.cglazadaplusproject.model;

public class Customer {
    private int customerId;
    private int userId;
    private String customerName;
    private String customerAddress;
<<<<<<< HEAD
    private int customerPoint;
    private int customerMembershipId;
    private boolean isDelete;

    public Customer(){
    }

    public Customer(int customerId, int userId, String customerName, String customerAddress, int customerPoint, int customerMembershipId,boolean isDelete) {
=======
    private double customerBalance;
    private int customerPoint;
    private int customerMemebershipId;
    private boolean isDelete;

    public Customer(int customerId, int userId, String customerName, String customerAddress, double customerBalance, int customerPoint, int customerMemebershipId, boolean isDelete) {
>>>>>>> 27cd8a35bc26d282d6ce9900430f3402e25ad951
        this.customerId = customerId;
        this.userId = userId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
<<<<<<< HEAD
        this.customerPoint = customerPoint;
        this.customerMembershipId = customerMembershipId;
=======
        this.customerBalance = customerBalance;
        this.customerPoint = customerPoint;
        this.customerMemebershipId = customerMemebershipId;
>>>>>>> 27cd8a35bc26d282d6ce9900430f3402e25ad951
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

<<<<<<< HEAD
=======
    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

>>>>>>> 27cd8a35bc26d282d6ce9900430f3402e25ad951
    public int getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(int customerPoint) {
        this.customerPoint = customerPoint;
    }

<<<<<<< HEAD
    public int getCustomerMembershipId() {
        return customerMembershipId;
    }

    public void setCustomerMembershipId(int customerMembershipId) {
        this.customerMembershipId = customerMembershipId;
=======
    public int getCustomerMemebershipId() {
        return customerMemebershipId;
    }

    public void setCustomerMemebershipId(int customerMemebershipId) {
        this.customerMemebershipId = customerMemebershipId;
>>>>>>> 27cd8a35bc26d282d6ce9900430f3402e25ad951
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
<<<<<<< HEAD
                ", customerPoint=" + customerPoint +
                ", customerMembershipId=" + customerMembershipId +
                '}' + isDelete;
=======
                ", customerBalance=" + customerBalance +
                ", customerPoint=" + customerPoint +
                ", customerMemebershipId=" + customerMemebershipId +
                ", isDelete=" + isDelete +
                '}';
>>>>>>> 27cd8a35bc26d282d6ce9900430f3402e25ad951
    }
}
