package com.codegym.cglazadaplusproject.model;

public class CustomerMembership {
    private int membershipId;
    private String membershipName;
    private int membershipRef;
    private double membershipReduction;
    private boolean isDelete;

    public CustomerMembership(int membershipId, String membershipName, int membershipRef, double membershipReduction, boolean isDelete) {
        this.membershipId = membershipId;
        this.membershipName = membershipName;
        this.membershipRef = membershipRef;
        this.membershipReduction = membershipReduction;
        this.isDelete = isDelete;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public int getMembershipRef() {
        return membershipRef;
    }

    public void setMembershipRef(int membershipRef) {
        this.membershipRef = membershipRef;
    }

    public double getMembershipReduction() {
        return membershipReduction;
    }

    public void setMembershipReduction(double membershipReduction) {
        this.membershipReduction = membershipReduction;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "CustomerMembership{" +
                "membershipId=" + membershipId +
                ", membershipName='" + membershipName + '\'' +
                ", membershipRef=" + membershipRef +
                ", membershipReduction=" + membershipReduction +
                ", isDelete=" + isDelete +
                '}';
    }
}
