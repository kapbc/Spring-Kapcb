package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.util.EmailUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * <a>Title: UserEmailController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 21:21
 */
@Controller
@RequestMapping("/kapcb")
public class UserEmailController {

    private static final Logger logger = Logger.getLogger(String.valueOf(UserEmailController.class));

    @Autowired
    private IUserService IUserService;

    @ResponseBody
    @RequestMapping(value = "/onlineEmail", method = RequestMethod.POST)
    public ModelAndView execute() {
        logger.warning("---Come into the email send execute method---");
        try {
            List<User> userListForEmail = IUserService.getUserListForEmail();
            userListForEmail.stream()
                    .filter(s -> isShouldBeSendEmail(s.getPrevWeekAddPoint(), s.getPrevWeekConsumerPoint()))
                    .filter(s -> isPrevWeekUpdate(s.getLastUpdateDate()))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } catch (Exception e) {
            logger.warning("execute the email send error : " + e.getMessage());
        }
        logger.warning("---email send execute method end---");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("email/sendSuccess");
        return modelAndView;
    }

    @RequestMapping(value = "/send/email", method = RequestMethod.GET)
    public ModelAndView handlerTheEmail(@RequestParam(value = "userId", required = false) Long userId, Model model) {
        if (userId == null || userId <= 0) {
            throw new RuntimeException("userId is required!!!");
        }
        User userInfoByUserId = IUserService.getUserInfoByUserId(userId);
        System.out.println("userInfoByUserId ================= " + userInfoByUserId);
        model.addAttribute("username", userInfoByUserId.getFirstName());
        model.addAttribute("totalPoint", userInfoByUserId.getTotalPoints());
        model.addAttribute("lastUpdateDate", userInfoByUserId.getLastUpdateDate());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("email/email_template");
        return modelAndView;
    }

    private boolean isPrevWeekUpdate(LocalDateTime lastUpdateDate) {
        Date time = getScheduleTime();
        LocalDateTime currentDateTime = time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        logger.warning("currentDateTime:::" + currentDateTime);
        return lastUpdateDate.isAfter(currentDateTime);
    }

    public Date getScheduleTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private boolean isShouldBeSendEmail(Integer prevWeekAddPoint, Integer prevWeekConsumerPoint) {
        if (prevWeekAddPoint == null || Objects.equals(0, prevWeekAddPoint)) {
            return false;
        }
        return prevWeekAddPoint - prevWeekConsumerPoint > 0;
    }
}
