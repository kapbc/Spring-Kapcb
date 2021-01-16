package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.Result;
import com.kapcb.ccc.common.constants.ResultInfo;
import com.kapcb.ccc.common.utils.JsonUtil;
import com.kapcb.ccc.domain.Article;
import com.kapcb.ccc.service.IArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <a>Title: ArticleController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/16 10:44
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb/shiro")
public class ArticleController {

    private final IArticleService articleService;

    @ResponseBody
    @RequiresPermissions(value = {"article:read"})
    @GetMapping(path = "/read", produces = "application/json;charset=UTF-8")
    public String readArticle() {
        List<Article> resultData = articleService.read();
        return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.SUCCESS, resultData));
    }


    @ResponseBody
    @RequiresRoles(value = {"admin"})
    @GetMapping(path = "/delete", produces = "application/json;charset=UTF-8")
    public String delete() {
        return "delete success";
    }

}
