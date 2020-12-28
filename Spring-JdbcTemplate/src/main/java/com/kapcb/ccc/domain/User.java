package com.kapcb.ccc.domain;

import com.kapcb.ccc.annotation.Column;
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
 * @date 2020/12/28 - 20:54
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Column(name = "id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "loginname")
    private String loginName;

    @Column(name = "address")
    private String address;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "remark")
    private String remark;

    @Column(name = "password")
    private String password;

    @Column(name = "deptId")
    private Integer deptId;

    @Column(name = "hiredate")
    private LocalDateTime hireDate;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "available")
    private Integer available;

    @Column(name = "orderNum")
    private Integer orderNumber;

    @Column(name = "tyoe")
    private Integer type;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "salt")
    private String salt;

}
