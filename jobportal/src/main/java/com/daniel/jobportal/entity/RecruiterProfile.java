package com.daniel.jobportal.entity;

import jakarta.persistence.*;

@Entity // Đánh dấu đây là một thực thể (entity) JPA, ánh xạ với một bảng trong CSDL
@Table(name = "recruiter_profile") // Đặt tên bảng trong CSDL là 'recruiter_profile'
public class RecruiterProfile {

    @Id // Biến này là khóa chính (Primary Key) của bảng recruiter_profile
    private int userAccountId;

    @OneToOne // Thiết lập mối quan hệ 1-1 với entity User
    @JoinColumn(name = "user_account_id") // Cột khóa ngoại trong bảng recruiter_profile tham chiếu đến khóa chính của bảng users
    @MapsId // Sử dụng khóa chính của thực thể User làm luôn khóa chính cho recruiter_profile
    // => Cột 'user_account_id' bây giờ  vừa là khóa chính (thay v vừa là khóa ngoại
    private User userId;

    // Các thông tin chi tiết của hồ sơ nhà tuyển dụng
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String company;

    @Column(nullable = true, length = 64) // Cột profile_photo cho phép null, giới hạn độ dài tối đa là 64 ký tự
    private String profilePhoto;

    // Constructor mặc định (bắt buộc phải có khi dùng JPA)
    public RecruiterProfile() {
    }
    public RecruiterProfile(User user){
        this.userId = user;
    }

    // Constructor đầy đủ để khởi tạo đối tượng với tất cả các thuộc tính
    public RecruiterProfile(int userAccountId, User userId, String firstName, String lastName,
                            String city, String state, String country, String company, String profilePhoto) {
        this.userAccountId = userAccountId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.company = company;
        this.profilePhoto = profilePhoto;
    }

    // Getter và Setter cho tất cả các trường

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
