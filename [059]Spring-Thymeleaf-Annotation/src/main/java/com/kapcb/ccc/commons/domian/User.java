package com.kapcb.ccc.commons.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29 22:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer age;
    private Long userId;
    private String status;
    private String username;
    private String password;
    private LocalDateTime birthday;

}
