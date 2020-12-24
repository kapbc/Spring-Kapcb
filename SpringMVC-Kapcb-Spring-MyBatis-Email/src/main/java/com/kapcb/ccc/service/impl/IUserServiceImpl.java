package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.map.IUserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {

    private static final Logger logger = Logger.getLogger(String.valueOf(IUserMapper.class));

    private static final Path path = Paths.get("SpringMVC-Kapcb-Spring-MyBatis-Email/src/main/resources/test.txt");

    private static final DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss S");

    @Override
    public List<User> getUserListForEmail() {
        try {
            List<User> assumeDataFrom = getAssumeDataFrom();
            return assumeDataFrom;
        } catch (IOException e) {
            logger.warning("get data error : " + e.getMessage());
        }
        return null;
    }

    @Override
    public User getUserInfoByUserId(Long userId) {
        try {
            List<User> assumeDataFrom = getAssumeDataFrom();
            User user = null;
            if (assumeDataFrom != null) {
                user = assumeDataFrom.stream().filter(s -> userId.equals(s.getUserId())).findAny().orElseThrow(NoSuchElementException::new);
            }
            return user;
        } catch (IOException e) {
            logger.warning("get data error : " + e.getMessage());
        }
        return null;
    }

    private List<User> getAssumeDataFrom() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            List<User> assumeDataList = lines.map(s -> s.split(", ")).map(s -> new User(Long.valueOf(s[0]),
                    s[1],
                    s[2],
                    s[3],
                    Integer.valueOf(s[4]),
                    Integer.valueOf(s[5]),
                    Integer.valueOf(s[6]),
                    LocalDateTime.parse(s[7], dataTimeFormatter))).collect(Collectors.toList());
            return assumeDataList;
        } catch (Exception e) {
            logger.warning("get assume data list error : " + e.getMessage());
        }
        return null;
    }


}
