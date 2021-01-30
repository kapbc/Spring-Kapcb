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
public class InstanceFactory extends AbstractFactory {

    /**
     * user factory pattern to get instance for bean
     *
     * @param clazzPath class path
     * @return IUserService {@link IUserService}
     */
    @Override
    public IUserService getUserService(String clazzPath) {
        try {
            Class<?> aClass = Class.forName(clazzPath);
            return (IUserService) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public IUserService getUserService(Class<? extends IUserService> clazz) {
        return null;
    }


}
