package com.practice.jobportal.entity;

import jakarta.persistence.*;
import org.hibernate.usertype.UserType;

import java.util.List;

@Entity
@Table(name = "users_type")
public class UsersType {
    private static UsersType userTypeInstance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class,mappedBy = "usersTypeId",cascade = CascadeType.ALL)
    private List<Users> users;

    // Use singleton pattern to ensure only one instance of UsersType
    // Constructors
    private UsersType(String userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }
    public UsersType() {
    }

    public static UsersType getUserType() {
        if(userTypeInstance==null){
            userTypeInstance = new UsersType();
        }
        return  userTypeInstance;
    }

    // Getters and Setters
    public String getUserTypeId() {
        return userTypeId;
    }
    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }
    public String getUserTypeName() {
        return userTypeName;
    }
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeId='" + userTypeId + '\'' +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
