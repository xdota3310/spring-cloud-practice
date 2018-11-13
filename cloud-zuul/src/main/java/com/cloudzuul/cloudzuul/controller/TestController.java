package com.cloudzuul.cloudzuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author shijie.xu
 * @since 2018年11月13日
 */
@RestController
public class TestController {
    @Value("${testString}")
    private String testStr;

    @RequestMapping(value = "/configCenterTest",method = RequestMethod.GET)
    public String configCenterTest(){
        return testStr;
    }
}
