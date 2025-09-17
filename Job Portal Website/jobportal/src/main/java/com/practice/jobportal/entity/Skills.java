package com.practice.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skill_id; //PK
    private String experience_level;
    private String skill_name;
    private String years_of_experience;
    @ManyToOne
    @JoinColumn(name = "job_seeker_profile", referencedColumnName = "user_account_id") //name: là cột khóa ngoại trong bảng hiện tại, referencedColumnName: là cột khóa chính trong bảng được tham chiếu.Ở đây, job_seeker_profile_id là một tham chiếu tới một đối tượng JobSeekerProfile.
    private JobSeekerProfile job_seeker_profile; //FK

    // Constructors
    public Skills() {
    }
    public Skills(int skill_id, String experience_level, String skill_name, String years_of_experience, JobSeekerProfile job_seeker_profile) {
        this.skill_id = skill_id;
        this.experience_level = experience_level;
        this.skill_name = skill_name;
        this.years_of_experience = years_of_experience;
        this.job_seeker_profile = job_seeker_profile;
    }

    // Getters and Setters


    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getExperience_level() {
        return experience_level;
    }

    public void setExperience_level(String experience_level) {
        this.experience_level = experience_level;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(String years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public JobSeekerProfile getJob_seeker_profile() {
        return job_seeker_profile;
    }

    public void setJob_seeker_profile(JobSeekerProfile job_seeker_profile) {
        this.job_seeker_profile = job_seeker_profile;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skill_id=" + skill_id +
                ", experience_level='" + experience_level + '\'' +
                ", skill_name='" + skill_name + '\'' +
                ", years_of_experience='" + years_of_experience + '\'' +
                ", job_seeker_profile=" + job_seeker_profile +
                '}';
    }
}
