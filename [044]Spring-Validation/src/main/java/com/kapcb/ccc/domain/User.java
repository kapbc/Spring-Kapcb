package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15 23:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 3729465563549435839L;

    @NotNull(message = "{user.id.not.null}")
    @Size(min = 4, max = 8, message = "{user.id.out.of.bound}")
    private Long userId;

    @NotBlank(message = "{user.name.not.null}")
    @Size(min = 4, max = 6, message = "{user.name.out.of.bound}")
    private String username;

    @NotBlank(message = "{user.password.not.null}")
    @Size(max = 4, min = 12, message = "{password.out.of.bound}")
    private String password;

    @NotBlank(message = "{user.email.not.null}")
    @Email(message = "{email.illegal.formatter}")
    private String email;

    @NotNull(message = "{user.age.not.null}")
    private int age;

    @NotNull(message = "{user.status.not.null}")
    @Max(value = 1, message = "{user.status.out.of.bound}")
    private String status;

    private LocalDateTime birthday;

    @AssertTrue
    private boolean isBlackListFlag;
}
