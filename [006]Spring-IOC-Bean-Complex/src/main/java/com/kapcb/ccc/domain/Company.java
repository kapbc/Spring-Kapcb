package com.kapcb.ccc.domain;

import java.math.BigDecimal;

/**
 * <a>Title: Company </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 0:03
 */
public class Company {

    private String companyName;
    private String boss;
    private BigDecimal marketValue;

    public Company() {
    }

    public Company(String companyName, String boss, BigDecimal marketValue) {
        this.companyName = companyName;
        this.boss = boss;
        this.marketValue = marketValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", boss='" + boss + '\'' +
                ", marketValue=" + marketValue +
                '}';
    }
}
