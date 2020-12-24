package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/24 - 18:28
 */
@Service("IUserService")
public class IUserServiceImpl implements IUserService {

    private static final DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    @Override
    public List<User> getUserListForEmail() {
        return getAssumeData();
    }

    @Override
    public User getUserInfoByUserId(Long userId) {
        List<User> assumeData = getAssumeData();
        return assumeData.stream().filter(s -> userId.equals(s.getUserId())).findAny().orElseThrow(NoSuchElementException::new);
    }

    private List<User> getAssumeData() {
        ArrayList<User> assumeDataUserList = new ArrayList<>();
        assumeDataUserList.add(new User(4000000000001L, "kapcb", "a", "eirccallroot@163.com", 1000, 20, 10, LocalDateTime.parse("2020-12-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000002L, "aaa", "asd", "eirccallroot@126.com", 96, 0, 10, LocalDateTime.parse("2020-12-11 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000003L, "bbb", "faf", "eirccallroot@yeah.net", 142, 0, 10, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000004L, "ddd", "fsg", "2530628867@qq.com", 103, 0, 0, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000005L, "eee", "gdfsf", "2530628868@163.com", 143, 0, 10, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000006L, "fff", "gsd", "2530628879@126.com", 145, 0, 0, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000007L, "ggg", "gsg", "2530628966@yeah.net", 535, 0, 0, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000008L, "hhh", "gdsg", "2530629865@163.com", 5353, 0, 0, LocalDateTime.parse("2020-08-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000009L, "iii", "kapgsgdcb", "2530638864@yeah.net", 530, 0, 10, LocalDateTime.parse("2020-09-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000010L, "jjj", "ffds", "2530728863@163.com", 153, 0, 0, LocalDateTime.parse("2020-10-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000011L, "kkk", "test", "2531628862@yeah.net", 53, 0, 0, LocalDateTime.parse("2020-02-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000012L, "lll", "a", "2540628862@126.com", 532, 0, 0, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000013L, "mmm", "kadasdpcb", "2630628861@yeah.net", 535, 0, 10, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000014L, "nnn", "kapfsacb", "1530628860@163.com", 324, 0, 10, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000015L, "123", "da", "2530628864@yeah.net", 860, 0, 10, LocalDateTime.parse("2020-11-18 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000016L, "ccc", "w", "2530628865@163.com", 1050, 30, 10, LocalDateTime.parse("2020-12-17 14:41:06:612", dataTimeFormatter)));
        assumeDataUserList.add(new User(4000000000017L, "test001", "e", " eirccallroot@163.com", 900, 10, 20, LocalDateTime.parse("2020-12-18 14:41:06:612", dataTimeFormatter)));
        return assumeDataUserList;
    }

}
