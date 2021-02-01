package com.kapcb.ccc.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <a>Title: tdd </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/5 22:07
 */
public class Tdd {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        logger.warn("aaa");
        logger.info("---dadsa---");
        logger.error("dasdas");
    }
}
