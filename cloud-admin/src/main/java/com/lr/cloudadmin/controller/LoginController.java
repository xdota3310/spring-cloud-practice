package com.lr.cloudadmin.controller;

import com.lr.cloudadmin.common.config.Audience;
import com.lr.cloudadmin.common.utils.JwtUtil;
import com.lr.cloudadmin.common.utils.Md5Util;
import com.lr.cloudadmin.common.utils.RedisUtil;
import com.lr.cloudadmin.common.utils.Result;
import com.lr.cloudadmin.entity.DO.UserDO;
import com.lr.cloudadmin.entity.DTO.LoginDTO;
import com.lr.cloudadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登陆接口
 *
 * @author shijie.xu
 * @since 2018年11月14日
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private Audience audience;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/admin")
    public Result<String> Login(){
        LoginDTO loginDTO =new LoginDTO();
        loginDTO.setUserName("xsj");
        loginDTO.setUserPassword("123456");
        String userName = loginDTO.getUserName().trim();
        String userPassword = loginDTO.getUserPassword().trim();
        String newOassword = Md5Util.MD5Encode(userPassword,"utf-8");
        List<UserDO> userDOList = userService.getUser(userName);
        if(userDOList.size()==1){
            if(userDOList.get(0).getUserPassword().equals(newOassword)){
                String jwtToken = JwtUtil.createJWT(userName,newOassword,audience.getClientId(),audience.getName(),
                audience.getExpiresSecond()*1000,audience.getBase64Secret());
                jwtToken = "bearer;" + jwtToken;
                redisUtil.set(userName,jwtToken,3600L);
                redisUtil.set(userDOList.get(0).getUserId().toString(),userDOList.get(0));
                return Result.getSuccessResult(jwtToken);
            }
        }else {
            return Result.getBusinessException("error","444","error");
        }
        return null;
    }
}
