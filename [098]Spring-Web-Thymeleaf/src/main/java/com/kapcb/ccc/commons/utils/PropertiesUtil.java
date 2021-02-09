package com.kapcb.ccc.commons.utils;

import com.kapcb.ccc.commons.constants.PropertiesPath;
import lombok.extern.slf4j.Slf4j;
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
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:21
 */
@Slf4j
public class PropertiesUtil {

    private static final String PROPERTIES_SUFFIX = ".properties";
    private static final String PROPERTIES_PREFIX = "properties\\";
    private static final List<String> PROPERTIES_LIST = new ArrayList<>();

    static {
        PROPERTIES_LIST.add(PropertiesPath.KAPCB_PROPERTIES.getLocation());
        PROPERTIES_LIST.add(PropertiesPath.SYSTEM_PROPERTIES.getLocation());
    }

    private PropertiesUtil() {
    }

    public static Resource[] getPropertiesResources() {
        int size = PROPERTIES_LIST.size();
        size = Optional.of(size).orElseThrow(RuntimeException::new);
        Resource[] resources = new Resource[size];
        for (int i = 0; i < size; i++) {
            String propertiesLocation = PROPERTIES_LIST.get(i);
            log.info("the load properties location is : " + propertiesLocation);
            try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesLocation)) {
                Resource resource = new InputStreamResource(Objects.requireNonNull(inputStream));
                resources[i] = resource;
            } catch (Exception e) {
                log.error("process load properties error, the exception is : " + e.getMessage(), e);
            }
        }
        return Optional.ofNullable(resources).orElseGet(PropertiesUtil::getDefaultReturnResources);
    }

    private static Resource[] getDefaultReturnResources() {
        return new Resource[0];
    }
}
