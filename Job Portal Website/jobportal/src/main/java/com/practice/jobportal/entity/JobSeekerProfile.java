package com.practice.jobportal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_account_id;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String city;
    private String country;
    private String employment_type;
    private String first_name;
    private String last_name;
    private String profile_photo;
    private String resume;
    private String state;
    private String work_authorization;
    @OneToMany(targetEntity = Skills.class, mappedBy="job_seeker_profile", cascade = CascadeType.ALL) //mappedBy: tên thuộc tính trong lớp Skills tham chiếu đến JobSeekerProfile. Trong trường hợp này, nó là 1 thuộc tính job_seeker_profile của tuan hệ Skills.
    private List<Skills> skills;

    //Constructor
    public JobSeekerProfile(){}

    public JobSeekerProfile(Users userId) {
        this.userId = userId;
    }

    public JobSeekerProfile(int user_account_id, Users userId, String city, String country, String employment_type, String first_name, String last_name, String profile_photo, String resume, String state, String work_authorization, List<Skills> skills) {
        this.user_account_id = user_account_id;
        this.userId = userId;
        this.city = city;
        this.country = country;
        this.employment_type = employment_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.profile_photo = profile_photo;
        this.resume = resume;
        this.state = state;
        this.work_authorization = work_authorization;
        this.skills = skills;
    }

    //Getters, Setters

    public int getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(int user_account_id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWork_authorization() {
        return work_authorization;
    }

    public void setWork_authorization(String work_authorization) {
        this.work_authorization = work_authorization;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }
}
