package com.daniel.jobportal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    private String userTypeName;

    /*
    *   targetEntity = User.class: Chỉ rõ thực thể con là User.
    *   mappedBy = "userTypeId":
            Dòng này báo cho JPA rằng trường userTypeId trong class User là bên sở hữu (owning side) của mối quan hệ.
            Tức là: bảng users trong database có cột khóa ngoại user_type_id tham chiếu tới user_type(user_type_id).
    *   cascade = CascadeType.ALL: Bất kỳ thao tác nào trên UserType (persist, remove, merge...) cũng sẽ được "lan truyền" xuống danh sách users liên kết với nó.
    * */
    @OneToMany(targetEntity = User.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<User> users;

    public UserType() {
    }

    public UserType(int userTypeId, String userTypeName, List<User> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                ", users=" + users +
                '}';
    }
}
