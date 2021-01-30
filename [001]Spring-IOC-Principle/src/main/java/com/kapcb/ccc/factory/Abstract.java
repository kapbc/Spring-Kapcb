package com.kapcb.ccc.factory;

import com.kapcb.ccc.service.IUserService;

/**
 * <a>Title: Abstract </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 12:49
 */
public abstract class Abstract {

    public abstract IUserService getUserService(String clazzPath);

    public abstract IUserService getUserService(Class<? extends IUserService> clazz);
}
