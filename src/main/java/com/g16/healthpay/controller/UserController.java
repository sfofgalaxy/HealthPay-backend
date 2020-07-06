package com.g16.healthpay.controller;

import com.g16.healthpay.dto.LoginMessage;
import com.g16.healthpay.service.UserService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Resource
//    @Autowired
    @Autowired
    UserService userService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private EncrypteUtils encrypteUtils;

    //等价@PostMapping("/login")
    @ApiOperation("登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginMessage login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        LoginMessage message = new LoginMessage();

        return message;
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public LoginMessage register(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("email") String email){
        LoginMessage message = new LoginMessage();

        return message;
    }
}
