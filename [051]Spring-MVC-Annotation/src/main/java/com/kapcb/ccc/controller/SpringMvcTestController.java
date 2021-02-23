package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <a>Title: SpringMvcTestController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 22:41
 */
@Controller
@RequestMapping(path = "SpringMVC")
public class SpringMvcTestController {

    private static final Logger log = LoggerFactory.getLogger(SpringMvcTestController.class);

    private static final String COMMON_VIEW_NAME = "success";

    /**
     * RequestParam 测试
     *
     * @param age      Integer
     * @param username String
     * @param password String
     * @return String
     */
    @GetMapping(path = "userRequestParam")
    public String userRequestParamTest(@RequestParam(name = "age", required = false) Integer age,
                                       @RequestParam(value = "username") String username,
                                       @RequestParam("password") String password) {
        log.info("=================================");
        log.info("come into user request param...");
        log.info("the username is : {}", username);
        log.info("the password is : " + password);
        log.info("the age is : " + age);
        log.info("=================================");
        return COMMON_VIEW_NAME;
    }

    /**
     * RequestBody 测试
     * 接受 json 参数
     *
     * @param user String
     * @return String
     */
    @PostMapping(value = "userRequestBody")
    public String userRequestBodyTest(@RequestBody String user) {
        log.info("come into user request body...");
        log.info("the request body user is : " + user);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}")
    public String userPathVariableTest(@PathVariable(value = "id") String id) {
        log.info("come into user path variable...");
        log.info("the path variable is : " + id);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id       String
     * @param username String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}/{username}")
    public String userPathVariableTest(@PathVariable("id") String id,
                                       @PathVariable(name = "username") String username) {
        log.info("come into user path variable...");
        log.info("the path variable's id is : " + id);
        log.info("the path variable's username is : " + username);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id       String
     * @param username String
     * @param password String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}/{username}/{password}")
    public String userPathVariableTest(@PathVariable("id") String id,
                                       @PathVariable(name = "username") String username,
                                       @PathVariable(value = "password") String password) {
        log.info("come into user path variable...");
        log.info("the path variable's id is : " + id);
        log.info("the path variable's username is : " + username);
        log.info("the path variable's password is : " + password);
        return COMMON_VIEW_NAME;
    }

    /**
     * post 请求：保存
     *
     * @param user String
     * @return String
     */
    @RequestMapping(value = "restfulPost", method = RequestMethod.POST)
    public String restfulPostTest(@RequestBody String user) {
        log.info("come into restful post test...");
        log.info("the path variable's id is : " + user);
        return COMMON_VIEW_NAME;
    }

    /**
     * test restful put
     *
     * @param id String
     * @return String
     */
    @PutMapping(path = "/restfulPut/{id}")
    public String restfulPut(@PathVariable(value = "id") String id) {
        log.info("the path variable of restfulPut method's id is : " + id);
        return "success";
    }

    /**
     * test restful delete
     *
     * @param id String
     * @return String
     */
    @DeleteMapping(value = "/restfulDelete/{id}")
    public String restfulDelete(@PathVariable(name = "id") String id) {
        log.info("the path variable of restfulDelete method's id is : " + id);
        return "success";
    }

    /**
     * test restful get
     *
     * @param id String
     * @return String
     */
    @GetMapping(path = "/restfulGet/{id}")
    public String restfulGet(@PathVariable(name = "id") String id) {
        log.info("the path variable of restfulGet method's id is : " + id);
        return "success";
    }

    /**
     * test @RequestHeader to get request heard
     *
     * @param requestHeard String
     * @return String
     */
    @GetMapping(path = "/userRequestHeard")
    public String userRequestHeardTest(@RequestHeader(value = "Accept-Language", required = false) String requestHeard) {
        log.info("the value of userRequestHeardTest method's requestHeard is : " + requestHeard);
        return "success";
    }

    /**
     * test @CookieValue to get JSESSIONID
     *
     * @param jSessionId String
     * @return String
     */
    @GetMapping(value = "userCookieValue")
    public String userCookieValueTest(@CookieValue(value = "JSESSIONID", required = false) String jSessionId) {
        log.info("the value of userCookieValueTest method's jSessionId is : " + jSessionId);
        return "success";
    }

    /**
     * test @ModelAttribute point on have return value's method
     *
     * @param user User
     * @return String
     */
    @ModelAttribute
    public String showModel(User user) {
        log.info("come into SpringMvcTestController's showModel method, the variable of user is : " + user.toString());
        user.setUsername("kapcb");
        log.info("the user after set properties is : " + user.toString());
        return "success";
    }

    /**
     * @param user User
     * @return String
     */
    @RequestMapping(value = "testModelAttribute")
    public String testModelAttribute(User user) {
        log.info("come into SpringMvcTestController's testModelAttribute method, the variable of user is : " + user);
        return "success";
    }

    /**
     * test @ModelAttribute point on no return value's method
     *
     * @param username String
     * @param map      Map<String, Object>
     */
    @ModelAttribute
    public void showUser(String username, Map<String, Object> map) {
        log.info("come into SpringMvcTestController's showUser method");
        User user = new User();
        user.setUsername("kapcb");
        user.setPassword("123456");
        map.put("kapcb", user);
        log.info("process SpringMvcTestController's showUser method success!");
    }

    /**
     * test @ModelAttribute point on arguments
     *
     * @param user User
     * @return String
     */
    @RequestMapping(path = "updateUser")
    public String updateUserTest(@ModelAttribute(value = "user") User user) {
        log.info("come into SpringMvcTestController's updateUserTest method");
        log.info("the user is : " + user);
        return "success";
    }
}
