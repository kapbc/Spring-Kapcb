package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <a>Title: SessionAttributeController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 22:41
 */
@Controller
@RequestMapping(path = "sessionAttribute")
@SessionAttributes(value = {"username", "password"}, types = Integer.class)
public class SessionAttributeController {
}
