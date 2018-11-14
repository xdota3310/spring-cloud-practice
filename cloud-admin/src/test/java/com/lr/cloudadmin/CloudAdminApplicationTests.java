package com.lr.cloudadmin;

import com.lr.cloudadmin.common.utils.Md5Util;
import com.lr.cloudadmin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudAdminApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getuserTest(){
        System.out.println(userService.getUser("admin"));

    }

    @Test
    public void md5Test() {
        System.out.println(Md5Util.MD5Encode("123456","utf-8"));
    }

}
