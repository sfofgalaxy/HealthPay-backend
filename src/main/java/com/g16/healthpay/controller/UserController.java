package com.g16.healthpay.controller;

import com.g16.healthpay.dto.GeneralMessage;
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
    @ApiOperation("登录/注册")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginMessage login(@RequestParam("phone") String phone,
                              @RequestParam("captcha") String captcha){
        LoginMessage message = new LoginMessage();
        String token = userService.verify(phone,captcha);
        if(token!=null){
            message.setState(true);
            message.setMessage(token);
        }else{
            message.setState(false);
            message.setMessage("登录失败");
        }

        return message;
    }


    @ApiOperation("生成验证码")
    @RequestMapping(value = "/sendCaptcha",method = RequestMethod.POST)
    public GeneralMessage sendCaptcha(@RequestParam("phone") String phone){
        GeneralMessage message = new GeneralMessage();
        String captcha = userService.sendCaptcha(phone);
        System.out.println(captcha);
        message.setState(true);
        message.setMessage("生成成功");
        return message;
    }



}
