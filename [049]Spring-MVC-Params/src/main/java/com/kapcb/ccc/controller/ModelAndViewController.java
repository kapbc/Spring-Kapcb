package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.domain.User.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

/**
 * <a>Title: ModelAndViewController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 16:00
 */
@Controller
@RequestMapping(value = "modelAndView")
public class ModelAndViewController {

    private static final Logger log = LoggerFactory.getLogger(ModelAndViewController.class);
    private static final String SUCCESS_VIEW_NAME = "/test/success";

    /**
     * 返回 ModeAndView
     *
     * @return ModelAndView
     */
    @GetMapping(path = "modelAndViewTest")
    public ModelAndView modelAndViewTest() {
        log.warn("come into model and view");
        ModelAndView modelAndView = new ModelAndView();
        log.warn("begin to build the return User Bean...");
        User kapcb = new Builder()
                .username("kapcb")
                .password("123456")
                .age(15)
                .account(Collections.emptyList())
                .accountMap(null)
                .build();
        log.warn("build User Bean for return value success");
        /**
         * 将user对象村粗到modelAndView中，它会将user对象存入到request对象中
         */
        modelAndView.addObject("message", kapcb);

        /**
         * 指定需要返回的视图
         */
        modelAndView.setViewName(SUCCESS_VIEW_NAME);
        log.warn("process success...");
        return modelAndView;
    }
}
