package com.kapcb.ccc.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <a>Title: MvcParamsController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:18
 */
@Controller
@RequestMapping(path = "param")
public class MvcParamsController {

    private static final Logger log = LoggerFactory.getLogger(MvcParamsController.class);

    private static final String FAIL = "fail";
    private static final String SUCCESS = "test/success";

    /**
     * 请求参数绑定 基于 k-v
     *
     * @param accountId String
     * @return String
     */
    @GetMapping(path = "findAccountBalance", produces = "application/json; charset=UTF-8")
    public String findAccountBalance(@RequestParam(value = "accountId") String accountId) {
        if (StringUtils.isBlank(accountId)) {
            log.warn("the request of ’findAccountBalance‘ param invalid");
            return FAIL;
        }
        log.warn("process find account balance of account id : " + accountId + " success!");
        System.out.println("查询了账号Id为：" + accountId + " 账户的余额成功!");
        return SUCCESS;
    }

    /**
     * String类型的参数，大小写必须严格一致
     *
     * @param accountId   String
     * @param accountName String
     * @return String
     */
    @GetMapping(path = "findAccountBalanceByUsername", produces = "application/json; charset=UTF-8")
    public String findAccountBalance(@RequestParam(value = "accountId") String accountId,
                                     @RequestParam(value = "accountName") String accountName) {
        if (StringUtils.isBlank(accountId) || StringUtils.isBlank(accountName)) {
            log.warn("the request of ’findAccountBalanceByUsername‘ param invalid");
            return FAIL;
        }
        log.warn("process find account balance of account id : " + accountId + " and accountName is : " + accountName + " success!");
        System.out.println("查询了id为：" + accountId + "用户名为：" + accountName + "的账户");
        return SUCCESS;
    }


    /**
     * map 携带参数输出
     *
     * @param map Map<String, Object>
     * @return String
     */
    @GetMapping(value = "map", produces = "application/json; charset=UTF-8")
    public String testMap(Map<String, Object> map) {
        log.warn("process map...");
        map.put("message", "Hello Kapcb!");
        return SUCCESS;
    }

    /**
     * interface Model携带参数输出
     *
     * @param model Model
     * @return String
     */
    @GetMapping(value = "model", produces = "application/json; charset=UTF-8")
    public String testModel(Model model) {
        log.warn("process model...");
        model.addAttribute("message", "kapcb nb!");
        return SUCCESS;
    }

    /**
     * ModelMap 参数携带 LinkedHashMap
     *
     * @param modelMap ModelMap
     * @return String
     */
    @GetMapping(value = "modelMap", produces = "application/json; charset=UTF-8")
    public String testModelMap(ModelMap modelMap) {
        log.warn("process modelMap...");
        modelMap.addAttribute("message", "kapcb really nb!");
        return SUCCESS;
    }
}
