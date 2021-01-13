package com.kapcb.ccc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 20:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -8897577837153106414L;

    @NotNull(message = "{required}")
    private Long userId;

    @NotNull(message = "{required}")
    private String username;

    @NotNull(message = "{required}")
    private String nickName;

    @NotNull(message = "{required}")
    @JsonIgnore
    private String password;

    @NotNull(message = "{required}")
    private String email;

    @NotNull(message = "{required}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    private LocalDateTime birthday;

    @NotNull(message = "{required}")
    private Integer age;

    @NotNull(message = "{required}")
    private String status;
}
