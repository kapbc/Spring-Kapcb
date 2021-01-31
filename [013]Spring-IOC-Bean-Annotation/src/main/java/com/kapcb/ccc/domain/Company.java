package com.kapcb.ccc.domain;

/**
 * <a>Title: Company </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 22:13
 */
public class Company {

    private String companyName;
    private String companyPath;
    private String companyMarketValue;

    public Company() {
    }

    public Company(String companyName, String companyPath, String companyMarketValue) {
        this.companyName = companyName;
        this.companyPath = companyPath;
        this.companyMarketValue = companyMarketValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPath() {
        return companyPath;
    }

    public void setCompanyPath(String companyPath) {
        this.companyPath = companyPath;
    }

    public String getCompanyMarketValue() {
        return companyMarketValue;
    }

    public void setCompanyMarketValue(String companyMarketValue) {
        this.companyMarketValue = companyMarketValue;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companyPath='" + companyPath + '\'' +
                ", companyMarketValue='" + companyMarketValue + '\'' +
                '}';
    }
}
