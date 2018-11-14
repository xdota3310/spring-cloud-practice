package com.lr.cloudadmin.service.impl;

import com.lr.cloudadmin.dao.UserDao;
import com.lr.cloudadmin.model.DO.UserDO;
import com.lr.cloudadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDO> getUser(String userName) {
        return userDao.getUser(userName);
    }
}
