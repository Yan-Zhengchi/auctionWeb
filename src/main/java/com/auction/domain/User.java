package com.auction.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String identityCode;
    private String phone;
    private String address;
    private Integer addressNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(Integer addressNum) {
        this.addressNum = addressNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identityCode='" + identityCode + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", addressNum=" + addressNum +
                '}';
    }
}
