package com.kapcb.ccc.domain;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/30 22:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person implements Serializable {

    private static final long serialVersionUID = 5665708662905687858L;

    private Long id;
    private String personName;
    private String email;
    private LocalDateTime birthDay;
}
