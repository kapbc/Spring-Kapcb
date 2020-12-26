package com.kapcb.ccc.configure;

import com.kapcb.ccc.service.IContentService;
import com.kapcb.ccc.service.impl.IContentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: ContentConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 11:05
 */
@Configuration
public class ContentConfiguration {

    public ContentConfiguration() {
        System.out.println("Spring Content Is Initial Now ...");
    }

    @Bean(value = "contentService")
    public IContentService iContentService() {
        return new IContentServiceImpl();
    }

}
