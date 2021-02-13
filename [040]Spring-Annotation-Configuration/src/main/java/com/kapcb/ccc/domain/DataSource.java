package com.kapcb.ccc.domain;

/**
 * <a>Title: DataSource </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 10:09
 */
public class DataSource {

    private String dataBaseUser;
    private String dataBasePassword;

    public DataSource() {
        this.dataBaseUser = "kapcb";
        this.dataBasePassword = "123456";
    }

    public String getDataBaseUser() {
        return dataBaseUser;
    }

    public void setDataBaseUser(String dataBaseUser) {
        this.dataBaseUser = dataBaseUser;
    }

    public String getDataBasePassword() {
        return dataBasePassword;
    }

    public void setDataBasePassword(String dataBasePassword) {
        this.dataBasePassword = dataBasePassword;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "dataBaseUser='" + dataBaseUser + '\'' +
                ", dataBasePassword='" + dataBasePassword + '\'' +
                '}';
    }
}
