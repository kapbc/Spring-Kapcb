package com.kapcb.ccc.domain;

import com.kapcb.ccc.common.annotation.VoMapping;
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
 * @date 2021/1/8 20:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @VoMapping(value = "userName")
    private String userName;

    @VoMapping(value = "userId")
    private Long userId;

    @VoMapping(value = "emailAddress")
    private String emailAddress;

    @VoMapping(value = "age")
    private int age;

    @VoMapping(value = "birthday")
    private LocalDateTime birthday;
}
