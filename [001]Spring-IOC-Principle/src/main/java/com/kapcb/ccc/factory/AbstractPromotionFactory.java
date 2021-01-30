package com.kapcb.ccc.factory;

import com.kapcb.ccc.service.IUserService;

/**
 * <a>Title: AbstractPromotionFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 12:48
 */
public abstract class AbstractPromotionFactory extends Abstract{

    @Override
    public abstract IUserService getUserService(Class<? extends IUserService> clazz);
}
