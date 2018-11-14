package com.lr.cloudadmin.controller;

import com.lr.cloudadmin.common.utils.Md5Util;
import com.lr.cloudadmin.model.DTO.LoginDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆接口
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    public String Login(LoginDTO loginDTO){
        String userName = loginDTO.getUserName().trim();
        String userPassword = loginDTO.getUserPassword().trim();
        String newOassword = Md5Util.MD5Encode(userPassword,"utf-8");



        return null;
    }
}
