package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.Article;
import com.kapcb.ccc.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: ArticleServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/16 10:47
 */
@Slf4j
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

    @Override
    public List<Article> read() {
        return generatorData();
    }

    private List<Article> generatorData() {
        List<Article> articles = new ArrayList<>(16);
        articles.add(new Article(1L, "唐诗三百首", "kapcb", 2000));
        articles.add(new Article(2L, "本草纲目", "kapcb", 1000));
        articles.add(new Article(3L, "三国志", "kapcb", 1500));
        return articles;
    }
}
