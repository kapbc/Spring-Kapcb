package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * <a>Title: ValidationController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21-16:27
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/validation")
public class ValidationController {


    @ResponseBody
    @PostMapping
    public String signUp(@Valid User user, BindingResult bindingResult) {
        List<ObjectError> allErrorsInformation = null;
        if (bindingResult.hasErrors()) {
            allErrorsInformation = bindingResult.getAllErrors();

        }
    }

}
