package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: TestUser </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUser implements Serializable {

    private static final long serialVersionUID = -6964553492816142629L;

    @NotNull(message = "{required}")
    @Size(min = 3, max = 12, message = "{name length required 3 ~ 12}")
    private String name;

    @NotNull(message = "{required}")
    @Size(min = 4, max = 6, message = "{UserId is required and length between 4 ~ 6}")
    private Long userId;

    @Email
    @NotNull(message = "{required}")
    private String email;

    @NotNull(message = "{required}")
    private LocalDateTime localDateTime;
}
