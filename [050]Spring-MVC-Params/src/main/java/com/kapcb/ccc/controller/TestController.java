package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <a>Title:TestController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 11:08
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        System.out.println("执行了test方法");
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

/*        request.getRequestDispatcher("/WEN-INF/views/success.jsp").forward(request, response);

        response.sendRedirect("test");

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("JSON串");*/

        return "success";
    }

    /**
     * 使用forward关键字进行请求转发
     * "forward:转发的JSP路径"，不走视图解析器了，所以需要编写完整的路径
     *
     * @return return
     */
    @RequestMapping(value = "forWard")
    public String forWard() {
        System.out.println("forWard方法执行了");
        return "forward:/ModeAndView/ModeAndViewTest";
    }

    /**
     * 重定向
     *
     * @return return
     */
    @RequestMapping(path = "redirect")
    public String redirectTest() {
        System.out.println("redirectTest方法执行了");
        return "redirect:index.jsp";
    }
}
