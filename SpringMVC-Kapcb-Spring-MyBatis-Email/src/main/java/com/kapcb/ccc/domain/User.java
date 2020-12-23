package com.kapcb.ccc.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <a>Title: UserScore </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 21:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private Long userId;
    private String firstName;
    private String secondName;
    private String emailAddress;
    private Integer totalPoints;
    private Integer prevWeekAddPoint;
    private Integer prevWeekConsumerPoint;
    private LocalDateTime lastUpdateDate;
}
