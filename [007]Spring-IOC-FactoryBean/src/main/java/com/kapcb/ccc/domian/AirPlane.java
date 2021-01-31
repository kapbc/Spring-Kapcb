package com.kapcb.ccc.domian;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <a>Title: AirPlane </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 11:53
 */
public class AirPlane {

    private Long planeId;
    private String planeName;
    private BigDecimal planePrice;
    private String planeCreateCompany;
    private LocalDateTime planeCreateDate;

    public AirPlane() {
    }

    public AirPlane(Long planeId, String planeName, BigDecimal planePrice, String planeCreateCompany, LocalDateTime planeCreateDate) {
        this.planeId = planeId;
        this.planeName = planeName;
        this.planePrice = planePrice;
        this.planeCreateCompany = planeCreateCompany;
        this.planeCreateDate = planeCreateDate;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public BigDecimal getPlanePrice() {
        return planePrice;
    }

    public void setPlanePrice(BigDecimal planePrice) {
        this.planePrice = planePrice;
    }

    public String getPlaneCreateCompany() {
        return planeCreateCompany;
    }

    public void setPlaneCreateCompany(String planeCreateCompany) {
        this.planeCreateCompany = planeCreateCompany;
    }

    public LocalDateTime getPlaneCreateDate() {
        return planeCreateDate;
    }

    public void setPlaneCreateDate(LocalDateTime planeCreateDate) {
        this.planeCreateDate = planeCreateDate;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "planeId=" + planeId +
                ", planeName='" + planeName + '\'' +
                ", planePrice=" + planePrice +
                ", planeCreateCompany='" + planeCreateCompany + '\'' +
                ", planeCreateDate=" + planeCreateDate +
                '}';
    }
}
