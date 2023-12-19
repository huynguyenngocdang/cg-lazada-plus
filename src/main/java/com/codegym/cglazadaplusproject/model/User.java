package com.codegym.cglazadaplusproject.model;

public class User {

    private int userId;
    private String username;
    private String userPassword;
    private int userRoleId;
    private boolean isActive;
    private boolean isDelete;

    public User(int userId, String username, String userPassword, int userRoleId, boolean isActive, boolean isDelete) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.userRoleId = userRoleId;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public User(String username, String password) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRoleId=" + userRoleId +
                ", isActive=" + isActive +
                ", isDelete=" + isDelete +
                '}';
    }
}
