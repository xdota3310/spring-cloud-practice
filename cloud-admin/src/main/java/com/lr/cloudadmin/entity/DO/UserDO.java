package com.lr.cloudadmin.entity.DO;

/**
 * 用户基础类
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
public class UserDO {
    private Long userId;
    private String userName;
    private String userPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "UserDO{" + "userId=" + userId + ", userName='" + userName + '\'' + ", userPassword='" + userPassword + '\'' + '}';
    }
}
