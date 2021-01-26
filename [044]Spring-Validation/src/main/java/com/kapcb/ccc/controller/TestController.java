package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.annotation.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: TestController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-15:26
 */
@Controller
@ResponseBody
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test/one")
    public String validation(@NotNull(message = "the id is required not null") @RequestParam(value = "id", required = false) String id) {
        log.info("the id is : " + id);
        return "success";
    }

    @RequestMapping("/test/two")
    public String validation(@RequestParam(value = "aaa", required = false) String aaa, @NotNull(message = "the id is required not null") @RequestParam(value = "id", required = false) String id) {
        log.info("the aaa is : " + aaa + "the id is : " + id);
        return "success";
    }

    @Judgement
    @RequestMapping("/test/three")
    public String validationThree(@NotNull(message = "the aaa required not null") @RequestParam(value = "aaa", required = false) String aaa, @NotNull(message = "the id is required not null") @RequestParam(value = "id", required = false) String id) {
        log.info("the aaa is : " + aaa + "the id is : " + id);
        return "success";
    }
}
