package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.annotation.ApiRateLimit;
import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: TestDrivenDevelopmentController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/23 12:01
 */
@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class TestDrivenDevelopmentController {

    @ApiRateLimit
    @PostMapping(path = "/limit", produces = "application/json;charset= UTF-8")
    public String limit() {
        log.info("process the request success");
        return "success";
    }

}
