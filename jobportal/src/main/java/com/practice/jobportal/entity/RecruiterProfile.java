package com.practice.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiter_profile")
public class RecruiterProfile {
    @Id
    private String user_account_id;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String city;
    private String company;
    private String country;
    private String first_name;
    private String last_name;
    @Column(nullable = true, length = 64)
    private String profile_photo;
    private String state;

    //Constructor
    public RecruiterProfile(){}

    public RecruiterProfile(String user_account_id, Users userId, String city, String company, String country, String first_name, String last_name, String profile_photo, String state) {
        this.user_account_id = user_account_id;
        this.userId = userId;
        this.city = city;
        this.company = company;
        this.country = country;
        this.first_name = first_name;
        this.last_name = last_name;
        this.profile_photo = profile_photo;
        this.state = state;
    }

    //Getters, Setters
    public String getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(String user_account_id) {
        this.user_account_id = user_account_id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RecruiterProfile{" +
                "user_account_id='" + user_account_id + '\'' +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
