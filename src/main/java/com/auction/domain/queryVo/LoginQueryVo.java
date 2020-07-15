package com.auction.domain.queryVo;

import java.io.Serializable;

public class LoginQueryVo implements Serializable {

    private String username;
    private String password;
    private String adminName;
    private String adminPassword;

    @Override
    public String toString() {
        return "LoginQueryVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String loginName) {
        this.username = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
