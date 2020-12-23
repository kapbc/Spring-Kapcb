package com.kapcb.ccc.util;


/**
 * <a>Title: Constants </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 21:26
 */
public enum Constants {

    /**
     * see description, must write the description for everyone constants
     */
    COMMON_TEST_TXT_RESOURCES_PATH("SpringMVC-Kapcb-Spring-MyBatis-Email/src/main/resources/test.txt", "The Data For Test");

    private String stringConstant;
    private Integer integerConstant;
    private String description;

    Constants() {
    }

    Constants(String stringConstant, String description) {
        this.stringConstant = stringConstant;
        this.description = description;
    }

    Constants(Integer integerConstant, String description) {
        this.integerConstant = integerConstant;
        this.description = description;
    }

    public String getStringConstant() {
        return stringConstant;
    }


    public Integer getIntegerConstant() {
        return integerConstant;
    }

    private void setStringConstant(String stringConstant) {
        this.stringConstant = stringConstant;
    }

    private void setIntegerConstant(Integer integerConstant) {
        this.integerConstant = integerConstant;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Constants{" +
                "stringConstant='" + stringConstant + '\'' +
                ", integerConstant=" + integerConstant +
                ", description='" + description + '\'' +
                '}';
    }
}
