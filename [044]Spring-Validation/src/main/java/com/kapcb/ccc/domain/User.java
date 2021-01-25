package com.kapcb.ccc.commons.domain;


import com.kapcb.ccc.commons.annotation.Constraints;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-10:49
 */
public class User {

    @NotNull(message = "{user id is required}")
    private Long userId;

    @Constraints(contains = "kapcb")
    @NotBlank(message = "{username is required}")
    private String username;

    @NotBlank(message = "{password is required}")
    @Size(min = 4, max = 6, message = "{password's length is between 4 ~ 6}")
    private String password;

    @Email
    @NotBlank(message = "{email is required}")
    private String email;

    @NotNull(message = "{age is required}")
    @Max(value = 20, message = "{age is no more than 20}")
    @Min(value = 10, message = "{age cant not less than 10}")
    private Integer age;

//    @Future(message = "{createTime is a future time}")
//    private LocalDateTime createTime;


    public User() {
    }

    public User(@NotNull(message = "{user id is required}") Long userId, @NotBlank(message = "{username is required}") String username, @NotBlank(message = "{password is required}") @Size(min = 4, max = 6, message = "{password's length is between 4 ~ 6}") String password, @Email @NotBlank(message = "{email is required}") String email, @NotNull(message = "{age is required}") @Max(value = 20, message = "{age is no more than 20}") @Min(value = 10, message = "{age cant not less than 10}") Integer age) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
