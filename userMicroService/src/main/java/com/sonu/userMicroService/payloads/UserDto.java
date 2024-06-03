package com.sonu.userMicroService.payloads;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UserDto {
    private String userId;
    @Size(min = 3, max = 30, message = "Invalid Name!! Name should be between character 3 to 30")
    private String userName;
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid user email")
    private String email;
    @NotBlank(message = "write something about yourself")
    private String about;

    @NotBlank(message = "password is required")
    @Size(min = 5, max = 15, message = "Password should be between character 3 to 30")
    private String password;

  //  private List<RatingDto> ratingList;

    public UserDto() {
    }

    public UserDto(String userId, String userName, String email, String about) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.about = about;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
