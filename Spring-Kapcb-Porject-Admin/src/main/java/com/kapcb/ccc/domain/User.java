package com.kapcb.ccc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:25
 */
@Data
public class User {

    @NotNull(message = "{the userId is required}")
    @Size(min = 1, max = 10, message = "id length is required 1~10")
    private Long userId;

    @NotNull(message = "{the username is required}")
    private String username;

    @JsonIgnore(true)
    private String password;

    @NotNull(message = "{}")
    private Integer deptId;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String mobile;

    @NotNull
    private Integer status;

    @NotNull
    private LocalDateTime creteTime;

    private LocalDateTime modifyTime;

    @NotNull
    private LocalDateTime lastLoginTime;

    @NotNull
    private Integer sex;

    private Integer isTab;

    private String theme;

    private String avatar;
}
