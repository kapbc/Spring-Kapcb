package com.kapcb.ccc.factory;

import com.kapcb.ccc.service.IUserService;

/**
 * <a>Title: InstanceFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 11:35
 */
public class InstanceFactory {

    private InstanceFactory() {
    }

    /**
     * user factory pattern to get instance for bean
     *
     * @param clazzPath class path
     * @return IUserService {@link IUserService}
     */
    public static IUserService getUserService(String clazzPath) {
        try {
            Class<?> aClass = Class.forName(clazzPath);
            return (IUserService) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
