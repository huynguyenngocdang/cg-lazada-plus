package com.codegym.cglazadaplusproject.dao;

public interface ICustomerMembershipDAO {
    double getCustomerMembershipReduction(int customerMembershipId);
    String getCustomerRank(int customerMembershipId);
}
