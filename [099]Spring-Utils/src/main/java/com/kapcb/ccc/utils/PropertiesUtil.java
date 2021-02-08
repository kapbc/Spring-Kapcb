package com.kapcb.ccc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <a>Title: PropertiesUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8-8:56
 */
public class PropertiesUtil {

    private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);

    private static final int INITIAL_CAPACITY = 20;
    private static final List<String> PROPERTIES_LIST = new ArrayList<>(INITIAL_CAPACITY);

    static {
        PROPERTIES_LIST.add(PropertiesFilePath.KAPCB_PROPERTIES.getPath());
        PROPERTIES_LIST.add(PropertiesFilePath.SYSTEM_PROPERTIES.getPath());
    }

    private PropertiesUtil() {
    }

    public static Resource[] getPropertiesResources() {
        int size = Optional.ofNullable(PROPERTIES_LIST.size()).orElseThrow(RuntimeException::new);
        Resource[] resources = new Resource[size];
        for (int i = 0; i < size; i++) {
            String propertiesFilePathString = PROPERTIES_LIST.get(i);
            log.info("the properties file path string is : " + propertiesFilePathString);
            try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFilePathString)) {
                Resource resource = new InputStreamResource(Objects.requireNonNull(inputStream));
                resources[i] = resource;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.ofNullable(resources).orElseGet(PropertiesUtil::getDefaultEmptyResourceResult);
    }

    private static Resource[] getDefaultEmptyResourceResult() {
        return new Resource[0];
    }

    private static enum PropertiesFilePath {

        /**
         * system propertied files
         */
        SYSTEM_PROPERTIES("system.properties", ""),
        KAPCB_PROPERTIES("kapcb.properties", "");

        private final String path;
        private final String description;

        PropertiesFilePath(String path, String description) {
            this.path = path;
            this.description = description;
        }

        private String getPath() {
            return "properties\\" + this.path;
        }
    }
}
