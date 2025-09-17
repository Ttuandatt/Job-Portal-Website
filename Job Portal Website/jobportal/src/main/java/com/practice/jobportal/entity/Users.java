package com.practice.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id; //PK
    @Column(unique = true, nullable = false)
    private String email;
    private boolean is_active;
    @NotEmpty
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date registration_date;
    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id") //name: là cột khóa ngoại trong bảng hiện tại, referencedColumnName: là cột khóa chính trong bảng được tham chiếu
    private UsersType user_type_id; //FK. Trong JPA/Hibernate: @ManyToOne (hoặc @OneToOne, @OneToMany, …) không map trực tiếp với kiểu dữ liệu nguyên thủy (int, long, String, …). Nó phải map tới một Entity khác. Ở đây, users_type_id là một tham chiếu tới một đối tượng UsersType.

    // Constructors
    public Users() {
    }
    public Users(int user_id, String email, boolean is_active, @NotEmpty String password, Date registration_date, UsersType user_type_id) {
        this.user_id = user_id;
        this.email = email;
        this.is_active = is_active;
        this.password = password;
        this.registration_date = registration_date;
        this.user_type_id = user_type_id;
    }

    // Getters and Setters


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public UsersType getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(UsersType user_type_id) {
        this.user_type_id = user_type_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_active=" + is_active +
                ", registration_date=" + registration_date +
                ", users_type_id=" + user_type_id +
                '}';
    }
}


