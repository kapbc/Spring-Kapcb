package com.kapcb.ccc.domain;

import lombok.Data;
import lombok.NonNull;

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
 * @date 2021/1/1 1:15
 */
@Data
public class User {

    @NotNull(message = "The UserId Is Required Not Null!")
    private Long userId;

    @NotNull(message = "Username Required Not Null!")
    @Size(min = 6, max = 11, message = "The Username Length Required Between 6 ~ 11")
    private String username;

    @NotNull(message = "Email Required Not Null!")
    private String email;

    @Size(min = 1, max = 1, message = "Flag Required One ")
    private String flag;

    private Integer totalPoint;

    @NotNull(message = "Birthday Required Not Null!")
    private LocalDateTime birthday;
}
