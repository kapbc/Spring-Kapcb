package com.kapcb.ccc.factory;

import com.kapcb.ccc.service.IUserService;

/**
 * <a>Title: PromotionInstanceFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 12:24
 */
public class PromotionInstanceFactory {

    public PromotionInstanceFactory(){}

    public static IUserService getUserService(Class<? extends IUserService> clazz) {
        if (clazz != null) {
            try {
                IUserService iUserService = clazz.newInstance();
                return iUserService;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
