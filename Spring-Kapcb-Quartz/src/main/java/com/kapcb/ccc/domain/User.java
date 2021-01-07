package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-10:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 3729465563549435839L;

    @NotNull(message = "{required}")
    private String name;

    @Email
    @NotNull(message = "{required}")
    private String email;

    @NotNull(message = "{required}")
    private String password;

    @NotNull(message = "{required}")
    private LocalDateTime localDateTime;
}
