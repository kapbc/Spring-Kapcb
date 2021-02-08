package com.kapcb.ccc.constants;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <a>Title: PropertiesPath </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8-9:39
 */
public enum PropertiesPath {
    /**
     * System Properties Name
     */
    SYSTEM_PROPERTIES("system", "system properties"),
    KAPCB_PROPERTIES("kapcb", "kapcb properties");



    private static final Logger log = LoggerFactory.getLogger(PropertiesPath.class);
    private static final String PROPERTIES_LOCATION_PREFIX = "properties\\";
    private static final String PROPERTIES_LOCATION_SUFFIX = ".properties";

    private final String location;
    private final String description;

    PropertiesPath(String location, String description) {
        this.location = location;
        this.description = description;
    }

    public String getLocation() {
        StringBuilder locationPath = new StringBuilder();
        locationPath.append(PROPERTIES_LOCATION_PREFIX);
        locationPath.append(this.location);
        locationPath.append(PROPERTIES_LOCATION_SUFFIX);
        log.info("the properties file path is : " + locationPath.toString());
        return locationPath.toString();
    }

}
