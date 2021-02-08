package com.kapcb.ccc.utils;

import com.kapcb.ccc.constants.PropertiesPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

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
 * @date 2021/2/8-9:38
 */
public class PropertiesUtil {

    private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
    private static final int INITIAL_CAPACITY = 30;
    private static final List<String> SYSTEM_PROPERTIES_FILE_PATH_LIST = new ArrayList<>(INITIAL_CAPACITY);

    static {
        SYSTEM_PROPERTIES_FILE_PATH_LIST.add(PropertiesPath.KAPCB_PROPERTIES.getLocation());
        SYSTEM_PROPERTIES_FILE_PATH_LIST.add(PropertiesPath.SYSTEM_PROPERTIES.getLocation());
    }

    private PropertiesUtil() {

    }

    public static Resource[] getSystemPropertiesFileResources() {
        int size = SYSTEM_PROPERTIES_FILE_PATH_LIST.size();
        size = Optional.ofNullable(size).orElseThrow(RuntimeException::new);
        Resource[] resources = new Resource[size];
        for (int i = 0; i < size; i++) {
            String propertiesFileLocation = SYSTEM_PROPERTIES_FILE_PATH_LIST.get(i);
            log.info("the properties file location string is : " + propertiesFileLocation);
            try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFileLocation)) {
                Resource resource = new InputStreamResource(Objects.requireNonNull(inputStream));
                resources[i] = resource;
            } catch (Exception e) {
                log.error("process load system properties error, the exception is : " + e.getMessage());
            }
        }
        return Optional.ofNullable(resources).orElseGet(PropertiesUtil::getDefaultEmptyResult);
    }

    private static Resource[] getDefaultEmptyResult() {
        return new Resource[0];
    }
}
