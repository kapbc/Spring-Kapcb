package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
@Slf4j
@Controller
@RequestMapping("/kapcb")
@RequiredArgsConstructor
public class UserEmailController {

    private final IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/onlineEmail.do", method = RequestMethod.POST)
    public ModelAndView execute() {
        log.warn("---Come into the email send execute method---");
        try {
            List<User> userListForEmail = userService.getUserListForEmail();
            userListForEmail.stream()
                    .filter(s -> isShouldBeSendEmail(s.getPrevWeekAddPoint(), s.getPrevWeekConsumerPoint()))
                    .filter(s -> isPrevWeekUpdate(s.getLastUpdateDate()))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        } catch (Exception e) {
            log.warn("execute the email send error : " + e.getMessage());
        }
        log.warn("---email send execute method end---");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    @RequestMapping(value = "/send/email.do", method = RequestMethod.GET)
    public ModelAndView handlerTheEmail(@RequestParam(value = "userId", required = false) Long userId) {
        if (userId == null || userId <= 0) {
            throw new RuntimeException("userId is required!!!");
        }

    }

    private boolean isPrevWeekUpdate(LocalDateTime lastUpdateDate) {
        Date time = getScheduleTime();
        LocalDateTime currentDateTime = time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        log.warn("currentDateTime:::" + currentDateTime);
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
