package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Person;

/**
 * <a>Title: IApiThreadPoolServie </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/30 22:26
 */
public interface IApiThreadPoolService {

    /**
     * get all person result list
     *
     * @param id Long
     * @return Person
     */
    Person getPersonById(Long id);

}
