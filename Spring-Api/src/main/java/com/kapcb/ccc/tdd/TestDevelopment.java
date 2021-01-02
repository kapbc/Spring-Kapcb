package com.kapcb.ccc.tdd;

import com.kapcb.ccc.common.Result;
import com.kapcb.ccc.common.ResultInfo;
import com.kapcb.ccc.common.json.ConvertJsonFromApi;
import com.kapcb.ccc.domain.User;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <a>Title: TestDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 12:02
 */
public class TestDevelopment {

    public static void main(String[] args) {
        User user = new User();
        user.setUserId(123456L);
        user.setUsername("kapcb");
        user.setEmail("eircccallroot@yeah.net");
        user.setFlag("Y");
        user.setTotalPoint(15590);
        user.setBirthday(LocalDateTime.now());
        Result<User> userResult = new Result<>(ResultInfo.REQUEST_SUCCESS, user);
        String result = ConvertJsonFromApi.convertObjectToJsonByTryCatch(userResult);
        System.out.println("result = " + result);

        Result<User> bean = ConvertJsonFromApi.convertStringToObjectByTryCatch(result, new User());
        System.out.println("bean = " + bean);
        User data = bean.getData();
        System.out.println("data.getBirthday() = " + data.getUsername());

        String[] split = result.split(",");
        for (int i = 0; i < split.length; i++) {
//            System.out.println("split[i] = " + split[i]);
        }
    }
}
