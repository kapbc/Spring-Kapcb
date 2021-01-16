package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Article;
import com.kapcb.ccc.domain.User;

import java.util.List;

/**
 * <a>Title: IArticleService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/16 10:47
 */
public interface IArticleService {

    List<Article> read();
}
