package com.lr.cloudadmin.service;

import com.lr.cloudadmin.entity.DO.UserDO;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
public interface UserService {
    /**
     * 查询用户信息
     *
     * @param userName
     * @return List<UserDO>
     */
    List<UserDO> getUser(String userName);
}
