package com.codegym.cglazadaplusproject.model;

public class Category {
    private int categoryId;
    private String categoryName;
    private boolean isDelete;

    public Category(int categoryId, String categoryName, boolean isDelete) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isDelete = isDelete;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
