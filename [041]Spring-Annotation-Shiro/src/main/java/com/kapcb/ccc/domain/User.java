package com.kapcb.ccc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @date 2021/1/10 21:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull(message = "{required}")
    private String username;

    @JsonIgnore
    @NotNull(message = "{required}")
    private String password;

    @NotNull(message = "{required}")
    @Size(min = 6, max = 9, message = "{id size out of bound}")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    private LocalDateTime birthday;

    @Email
    @NotNull(message = "{required}")
    private String email;
}
