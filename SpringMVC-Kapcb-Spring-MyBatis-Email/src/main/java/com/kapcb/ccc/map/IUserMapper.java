package com.kapcb.ccc.map;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title: IUserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/24 - 19:02
 */
@Repository
public interface IUserMapper {

    List<User> getUserListForEmail();

    User getUserInfoByUserId(Long userId);
}
