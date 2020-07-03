package com.kapcb.ccc.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IConsumerService;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

/**
 * <a>Title:IConsumerService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 14:26
 */
@Service
public class IConsumerServiceImpl implements IConsumerService {

    @Autowired(required = false)
    private IUserService iUserService;

    public void init(String id) throws Exception {
        System.out.println("方法调用开始,id为：" + id);
        List<User> allUserList = this.iUserService.getAllUserList(id);
        System.out.println("方法调用结束,开始输出结果:");
        for (User user : allUserList) {
            System.out.println(user);
        }
    }
}
