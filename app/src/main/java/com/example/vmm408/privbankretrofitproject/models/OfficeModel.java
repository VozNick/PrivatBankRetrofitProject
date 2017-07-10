package com.example.vmm408.privbankretrofitproject.models;

public class OfficeModel {
    private String name;
    private String state;
    private int id;
    private String country;
    private String city;
    private String index;
    private String phone;
    private String email;
    private String address;

    public OfficeModel() {
    }

    public OfficeModel(String name,
                       String state,
                       int id,
                       String country,
                       String city,
                       String index,
                       String phone,
                       String email,
                       String address) {
        this.name = name;
        this.state = state;
        this.id = id;
        this.country = country;
        this.city = city;
        this.index = index;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "OfficeModel{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", index=" + index +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
