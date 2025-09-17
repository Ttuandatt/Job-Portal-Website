package com.practice.jobportal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {
    @Id
    private String user_account_id;

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
    @OneToMany(targetEntity = Skills.class, mappedBy="jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Skills> skills;

    //Constructor
    public JobSeekerProfile(){}

    public JobSeekerProfile(Users userId) {
        this.userId = userId;
    }

    public JobSeekerProfile(String user_account_id, Users userId, String city, String country, String employment_type, String first_name, String last_name, String profile_photo, String resume, String state, String work_authorization, List<Skills> skills) {
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
}
