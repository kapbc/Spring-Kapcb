package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <a>Title:RequestParamController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/7 21:38
 */
@Controller
@RequestMapping("SpringMVC")
public class SpringMvcTestController {

    /**
     * RequestParam 测试
     *
     * @param name 携带请求参数
     * @param age  不携带请求参数
     * @return success
     */
    @RequestMapping(path = "userRequestParam")
    public String userRequestParamTest(@RequestParam("name") String name,
                                       @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("姓名为：" + name + "年龄为：" + age);
        return "success";
    }


    /**
     * RequestBody 测试
     *
     * @param body body
     * @return success
     */
    @RequestMapping(value = "userRequestBody")
    public String userRequestBodyTest(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable 测试
     *
     * @param id 携带请求参数
     * @return success
     */
    @RequestMapping(path = "userPathVariable/{id}")
    public String userPathVariableTest(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "success";
    }

    /**
     * post 请求：保存
     *
     * @param body body
     * @return success
     */
    @RequestMapping(value = "RESTfulPost", method = RequestMethod.POST)
    public String RESTfulPostTest(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * put 请求：更新
     *
     * @param id id
     * @return success
     */
    @RequestMapping(path = "RESTfulPUT/{id}", method = RequestMethod.PUT)
    public String RESTfulPUTTest(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "success";
    }

    /**
     * delete 请求：删除
     *
     * @param id id
     * @return success
     */
    @RequestMapping(value = "RESTfulDELETE/{id}", method = RequestMethod.DELETE)
    public String RESTfulDELETETest(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "success";
    }

    /**
     * get 请求：查询
     *
     * @param id id
     * @return success
     */
    @RequestMapping(path = "RESTfulGET/{id}", method = RequestMethod.GET)
    public String RESTfulGETTest(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader 测试
     *
     * @param requestHeard requestHeard
     * @return success
     */
    @RequestMapping(path = "userRequestHeader")
    public String userRequestHeaderTest(@RequestHeader(value = "Accept-Language", required = false) String requestHeard) {
        System.out.println(requestHeard);
        return "success";
    }

    /**
     * CookieValue 测试
     *
     * @param cookieValue CookieValue
     * @return success
     */
    @RequestMapping(value = "useCookieValue")
    public String useCookieValueTest(@CookieValue(value = "JSESSIONID", required = false) String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute 修饰方法，优先执行
     *
     * @param user user
     * @return success
     */
    @ModelAttribute
    public String showModel(User user) {
        user.setUsername("Kapcb");
        System.out.println("获取到了名为：" + user.getUsername() + "的请求" + "执行了showModel方法");
        return "success";
    }

    /**
     * 接收请求的方法
     *
     * @param user user
     * @return success
     */
    @RequestMapping(value = "testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("执行了控制器的方法" + user.getUsername());
        return "success";
    }

    /**
     * ModelAttribute 作用于无返回值的方法
     *
     * @param username username
     * @param map      map
     */
    @ModelAttribute
    public void showUser(String username, Map<String, Object> map) {
        System.out.println("执行了showUser");
        //模拟查询数据
        User user = new User();
        user.setUsername("kapcb");
        user.setPassword("123456");
        map.put("abc", user);
    }

    /**
     * ModelAttribute 作用于参数
     *
     * @param user user
     * @return success
     */
    @RequestMapping(path = "updateUser")
    public String updateUserTest(@ModelAttribute(value = "abc") User user) {
        System.out.println(user);
        return "success";
    }


}
