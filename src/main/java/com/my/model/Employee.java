package com.my.model;

public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String mobile;
    private String password;
    private Integer role;
    private String profile;
    private String imageName;
    private int orders;

    /**
     * This method increments number of users orders
     *
     */
    public void addOneOrder() {
        this.orders++;
    }
    /**
     * This method returns employees role
     * @return Role
     */
    public String getRoleName(){
        switch (this.role) {
            case 1:
                return "Admin";
            case 2:
                return "Cashier";
            case 3:
                return "Senior cashier";
            case 4:
                return "Commodity expert";
            default:
                return "Unknown role";
        }
    }

    public String getSurname() {
        return surname;
    }
    public String getMobile() {
        return mobile;
    }
    public String getImageName() {
        return imageName;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;

    }
    public String getEmail() {
        return email;
    }
    public int getOrders() {
        return orders;
    }
    public Integer getRole() {
        return role;
    }
    public String getProfile() {
        return profile;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public void setOrders(int orders) {
        this.orders = orders;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Integer role) {
        this.role = role;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }


}

