package com.lr.cloudadmin.dao;

import com.lr.cloudadmin.entity.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
@Component
public interface UserDao {
    List<UserDO> getUser(String userName);
}
