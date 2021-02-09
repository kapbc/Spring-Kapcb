package com.kapcb.ccc.commons.constants;

import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: PropertiesPath </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:24
 */
@Slf4j
public enum PropertiesPath {
    /**
     *
     */
    KAPCB_PROPERTIES("kapcb", ""),
    SYSTEM_PROPERTIES("system", "");
    private static final String LOCATION_SUFFIX = ".properties";
    private static final String LOCATION_PREFIX = "properties\\";

    private final String location;
    private final String description;

    PropertiesPath(String location, String description) {
        this.location = location;
        this.description = description;
    }

    public String getLocation() {
        StringBuilder fileLocation = new StringBuilder();
        fileLocation.append(LOCATION_PREFIX);
        fileLocation.append(this.location);
        fileLocation.append(LOCATION_SUFFIX);
        log.info("the properties file location is: " + fileLocation.toString());
        return fileLocation.toString();
    }
}
