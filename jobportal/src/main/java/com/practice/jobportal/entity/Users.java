package com.practice.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "users")
public class Users {
    private static Users usersInstance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(unique = true)
    private String email;

    @NotEmpty
    private String password;

    private boolean isActive;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UsersType usersTypeId;

    // Use singleton pattern to ensure only one instance of Users
    // Constructors
    public Users() {
    }
    private Users(String userTypeId, String userTypeName) {
        this.usersTypeId = UsersType.getUserType();
        this.usersTypeId.setUserTypeId(userTypeId);
        this.usersTypeId.setUserTypeName(userTypeName);
    }
    public static Users getUsersInstance() {
        if(usersInstance==null){
            usersInstance = new Users();
        }
        return  usersInstance;
    }

    // Getters and Setters
    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersType getUsersTypeId() {
        return usersTypeId;
    }

    public void setUsersTypeId(UsersType usersTypeId) {
        this.usersTypeId = usersTypeId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", registrationDate=" + registrationDate +
                ", usersTypeId=" + usersTypeId +
                '}';
    }
}
