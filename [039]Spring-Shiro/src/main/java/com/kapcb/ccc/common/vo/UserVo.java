package com.kapcb.ccc.common.vo;

import lombok.Data;

import java.io.Serializable;


/**
 * <a>Title: UserVo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 21:56
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -6770315718973727435L;

    private String userName;
    private String userId;
    private String emailAddress;
    private String age;
    private String birthday;
}
