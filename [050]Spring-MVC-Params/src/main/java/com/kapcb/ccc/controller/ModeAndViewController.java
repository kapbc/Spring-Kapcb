package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <a>Title:ModeAndViewController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 13:12
 */
@Controller
@RequestMapping("ModeAndView")
public class ModeAndViewController {

    /**
     * 返回 ModeAndView
     *
     * @return modelAndView
     */
    @RequestMapping(path = "ModeAndViewTest")
    public ModelAndView ModeAndViewTest() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("Kapcb");
        user.setPassword("123456");
        user.setAge(12);

        //将user对象村粗到modelAndView中，它会将user对象存入到request对象中
        modelAndView.addObject("user", user);
        //指定需要返回的视图
        modelAndView.setViewName("view");
        return modelAndView;
    }
}
