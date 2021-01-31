package com.kapcb.ccc.config;

/**
 * <a>Title: DataSource </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 21:45
 */
public class DataSource {

    private String user;
    private String password;
    private String jdbcUrl;
    private String driverClass;

    public DataSource() {
    }

    public DataSource(String user, String password, String jdbcUrl, String jdbcClass) {
        this.user = user;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
        this.driverClass = jdbcClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcClass() {
        return driverClass;
    }

    public void setJdbcClass(String jdbcClass) {
        this.driverClass = jdbcClass;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", driverClass='" + driverClass + '\'' +
                '}';
    }
}
