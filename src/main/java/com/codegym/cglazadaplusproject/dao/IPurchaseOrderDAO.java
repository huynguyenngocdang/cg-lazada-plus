package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrderDAO {
    List<PurchaseOrder> getPurchaseOrder(int userId);
}
