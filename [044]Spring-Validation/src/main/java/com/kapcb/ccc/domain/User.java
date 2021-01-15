package com.kapcb.ccc.domain;

import com.kapcb.ccc.commons.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Nullable
    private Long userId;

    @Nullable
    private String username;

    @Nullable
    private String password;

    @Nullable
    private String email;

    @Nullable
    private int age;

    @Nullable

    private String status;
    private LocalDateTime birthday;
}
