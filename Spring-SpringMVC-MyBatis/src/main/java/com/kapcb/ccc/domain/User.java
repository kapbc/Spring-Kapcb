package com.kapcb.ccc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:28
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private Long userId;
    private String username;
    private String password;
    private Integer deptId;
    private String email;
    private String mobile;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private LocalDateTime lastLoginTime;
    private Integer sex;
    private Integer isTab;
    private String theme;
    private String avatar;
    private String description;
}
