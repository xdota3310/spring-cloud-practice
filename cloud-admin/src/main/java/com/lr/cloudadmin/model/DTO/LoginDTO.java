package com.lr.cloudadmin.model.DTO;

import javax.validation.constraints.NotNull;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
public class LoginDTO {
    @NotNull
    private String userName;
    @NotNull
    private String userPassword;

    @Override
    public String toString() {
        return "LoginDTO{" + "userName='" + userName + '\'' + ", userPassword='" + userPassword + '\'' + '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
