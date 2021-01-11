package com.kapcb.ccc.tdd;

import com.kapcb.ccc.commons.bean.ResultInfo;
import com.kapcb.ccc.commons.dto.Result;
import com.kapcb.ccc.commons.utils.JsonUtil;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 22:55
 */
public class TestDrivenDevelopment {

    public static void main(String[] args) {
        String jsonString = JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.SUCCESS));
        System.out.println("jsonString = " + jsonString);
    }
}
